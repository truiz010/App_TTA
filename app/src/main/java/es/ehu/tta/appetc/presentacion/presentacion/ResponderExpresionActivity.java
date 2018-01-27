package es.ehu.tta.appetc.presentacion.presentacion;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.OpenableColumns;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.modelo.Expresion;
import es.ehu.tta.appetc.presentacion.modelo.ProgressTask;
import es.ehu.tta.appetc.presentacion.modelo.RestClient;

public class ResponderExpresionActivity extends AppCompatActivity {

    final int AUDIO_REQUEST_CODE = 2;
    final int READ_REQUEST_CODE = 1;
    int resultado;
    String login;
    String idEsaldiak;
    int id;
    String esaeraCast;
    String erabiltzaileMota;
    String fileName;
    String nombre;
    String path;
    String respuesta;
    private final static String TAG="tag";

    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");

    private static final String LOG_TAG = "Grabadora";
    private MediaRecorder mediaRecorder;
    private MediaPlayer mediaPlayer;

    //private static String fichero = Environment.getExternalStorageDirectory().getAbsolutePath()+"/esaera.mp4";
    private static String fichero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_expresion);

        Intent intent = getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);
        TextView textLogin = (TextView) findViewById(R.id.menu_login);
        textLogin.setText("Login: " + intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void grabar(View view) {
        fichero = Environment.getExternalStorageDirectory().getAbsolutePath()+"/esaera"+idEsaldiak+".mp4";
        mediaRecorder = new MediaRecorder();
        mediaRecorder.setOutputFile(fichero);
        mediaRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        mediaRecorder.setOutputFormat(MediaRecorder.
                OutputFormat.MPEG_4);
        mediaRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.
                AMR_NB);
        try {
            mediaRecorder.prepare();
        } catch (IOException e) {
            Log.e(LOG_TAG, "Fallo en grabación");
        }
        Toast.makeText(this,"Grabando audio...",Toast.LENGTH_SHORT).show();
        mediaRecorder.start();
    }

    public void detener(View view) {
        mediaRecorder.stop();
        mediaRecorder.release();
        Toast.makeText(this,"Detenido",Toast.LENGTH_SHORT).show();
    }

    public void reproducir(View view) {
        mediaPlayer = new MediaPlayer();
        try {
            mediaPlayer.setDataSource(fichero);
            mediaPlayer.prepare();
            mediaPlayer.start();
        } catch (IOException e) {
            Log.e(LOG_TAG, "Fallo en reproducción");
        }
    }

    /*public void AudioRecord(View view) {

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            Toast.makeText(this, "El dispositivo no tiene microfono", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            } else {
                Toast.makeText(this, "No hay ningun programa para grabar audio", Toast.LENGTH_SHORT).show();
                ;
            }
        }

    }*/

    public void completarExpresion(View view) {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent, READ_REQUEST_CODE);

        if(resultado==200) {
            fileName="esaera"+idEsaldiak;
            new ProgressTask<Expresion>(this) {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                protected Expresion work() throws IOException, JSONException {
                    try {
                        final String esaera = ((EditText) findViewById(R.id.expresionEusk)).getText().toString();
                        JSONObject json = new JSONObject();
                        json.put("login", login);
                        json.put("audioFitxIZena", fileName);
                        json.put("esaldiaEusk", esaera);
                        id = Integer.parseInt(idEsaldiak);
                        json.put("idEsaldia", id);
                        json.put("erabiltzaileMota", erabiltzaileMota);

                        respuesta = rest.postJSON(json, String.format("responseEsaldia"));
                        Expresion exp = new Expresion();
                        exp.setRespuesta(respuesta);
                        return exp;

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                }

                @Override
                protected void onFinish(Expresion result) {

                    if (result.getRespuesta().matches("ESALDIA OSATUTA")) {
                        Toast.makeText(getApplicationContext(), "Expresión completada", Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Error al completar la expresion", Toast.LENGTH_LONG).show();
                    }

                }
            }.execute();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case READ_REQUEST_CODE:
                Uri uri = data.getData();
                nombre=Metadatos(uri);
                path=data.getData().getPath();
                uploadFile(nombre,uri,path);
                break;
            case AUDIO_REQUEST_CODE:
                break;
        }
    }

    public String Metadatos(Uri uri)
    {
        Cursor cursor=getContentResolver().query(uri,null,null,null,null,null);
        String displayName ="";
        try
        {
            if(cursor!=null && cursor.moveToFirst())
            {
                displayName=cursor.getString(cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME));
                Log.i(TAG,"Display Name: "+displayName);

                int sizeIndex=cursor.getColumnIndex(OpenableColumns.SIZE);
                String size=null;
                if(!cursor.isNull(sizeIndex))
                    size=cursor.getString(sizeIndex);
                else
                    size="Unknown";
                Log.i(TAG,"Size: "+size);
            }
        }finally {
            cursor.close();
        }
        return displayName;
    }


    public void uploadFile(final String fileName, final Uri uri, final String path)
    {
        new ProgressTask<Expresion>(this)
        {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Expresion work()throws IOException, JSONException
            {
                try{
                    InputStream inputStream=getContentResolver().openInputStream(uri);
                    resultado=rest.postFile(String.format("uploadFile"),inputStream,fileName);
                    //if(resultado==200){
                   /* final String esaera=((EditText)findViewById(R.id.expresionEusk)).getText().toString();
                    JSONObject json=new JSONObject();
                    json.put("login",login);
                    json.put("audioFitxIZena",fileName);
                    json.put("esaldiaEusk",esaera);
                    id=Integer.parseInt(idEsaldiak);
                    json.put("idEsaldia",id);
                    json.put("erabiltzaileMota",erabiltzaileMota);

                    respuesta=rest.postJSON(json,String.format("responseEsaldia"));
                    Expresion exp=new Expresion();
                    exp.setRespuesta(respuesta);
                    return exp;*/

                    //}
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onFinish(Expresion result) {

                Toast.makeText(getApplicationContext(),"resultado:"+resultado,Toast.LENGTH_LONG).show();

               /* if(result.getRespuesta().matches("ESALDIA OSATUTA")){
                    Toast.makeText(getApplicationContext(),"Expresión completada",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Error al completar la expresion",Toast.LENGTH_LONG).show();
                }*/

            }
        }.execute();
    }


}
