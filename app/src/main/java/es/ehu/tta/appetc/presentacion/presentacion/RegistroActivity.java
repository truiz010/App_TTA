package es.ehu.tta.appetc.presentacion.presentacion;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.File;
import java.io.IOException;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.modelo.ProgressTask;
import es.ehu.tta.appetc.presentacion.modelo.RestClient;
import es.ehu.tta.appetc.presentacion.modelo.User;

public class RegistroActivity extends AppCompatActivity {

    private Uri pictureUri;
    final int PICTURE_REQUEST_CODE=1;
    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");
    String resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void registro(View view){
        Intent intent=new Intent(this,SesionActivity.class);
        final String nombre=((EditText)findViewById(R.id.nombre)).getText().toString();
        final String dni=((EditText)findViewById(R.id.dni)).getText().toString();
        final String edad=((EditText)findViewById(R.id.edad)).getText().toString();
        final int edadUSer=Integer.parseInt(edad);
        final String poblacion=((EditText)findViewById(R.id.poblacion)).getText().toString();
        final String lenguaMaterna=((EditText)findViewById(R.id.lenguaMaterna)).getText().toString();
        final String contraseña=((EditText)findViewById(R.id.contraseña)).getText().toString();
        if(nombre.matches("")||dni.matches("")||edad.matches("")||poblacion.matches("")||lenguaMaterna.matches("")||contraseña.matches("")){

            Toast.makeText(
                    this,
                    "Rellene todos los campos",
                    Toast.LENGTH_SHORT
            ).show();
        }
        else{
            //intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
            /*Toast.makeText(
                this,
                "Usuario registrado",
                Toast.LENGTH_SHORT
            ).show();
            startActivity(intent);*/
            new ProgressTask<User>(this) {

                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                protected User work()throws Exception{
                    JSONObject json=new JSONObject();
                    json.put("nan",dni);
                    json.put("izena",nombre);
                    json.put("herria",poblacion);
                    json.put("adina",edadUSer);
                    json.put("amaHizkuntza",lenguaMaterna);
                    json.put("pasahitza",contraseña);

                    resultado=rest.postJSON(json,String.format("addErabiltzaile"));
                    User usuario=new User();
                    usuario.setLogin(resultado);
                    return usuario;
                }

                @Override
                protected void onFinish(User result){

                    String registro=String.format("Bienvenido a Appetc. Recuerda el nuevo login que se te ha asignado, es importante. Tu login es: %s",result);
                    Toast.makeText(getApplicationContext(), registro,Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(getApplicationContext(),SesionActivity.class);
                    startActivity(intent);

                }
            }.execute();
        }
    }

    public void takePhoto(View view){

        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(this,"El dispositivo no tiene camara",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null){
                File dir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try{
                    File file=File.createTempFile("login",".jpg",dir);
                    pictureUri= Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                    startActivityForResult(intent,PICTURE_REQUEST_CODE);
                }
                catch (IOException e){

                }
            }
            else{
                Toast.makeText(this,"No hay ningun programa para sacer fotos",Toast.LENGTH_SHORT).show();;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        switch (requestCode){
            case PICTURE_REQUEST_CODE:
                // dumpImageMetaData(pictureUri);
                break;
        }
    }
}
