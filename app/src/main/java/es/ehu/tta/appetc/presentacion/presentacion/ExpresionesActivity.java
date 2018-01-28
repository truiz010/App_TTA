package es.ehu.tta.appetc.presentacion.presentacion;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.modelo.Expresion;
import es.ehu.tta.appetc.presentacion.modelo.ProgressTask;
import es.ehu.tta.appetc.presentacion.modelo.RestClient;

public class ExpresionesActivity extends AppCompatActivity {

    String login;
    String tipo;
    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");
    String producto;
    Expresion expresion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresiones);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);
        tipo=intent.getStringExtra(MenuPrincipalActivity.EXTRA_TIPO);

        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        Intent intent2=getIntent();
        TextView textUsuario=(TextView)findViewById(R.id.expresiones);
        textUsuario.setText(intent.getStringExtra(MenuPrincipalActivity.EXTRA_TIPO)+" baten ohiko esaerak");

        new ProgressTask<Expresion>(this){

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Expresion work()throws IOException, JSONException{
                try{
                    expresion=new Expresion();
                    JSONObject json=rest.getJSON(String.format("requestEsaldiak?login=%s",login+"&erabiltzaileMota="+tipo));

                    // Expresion expresion=new Expresion();
                    expresion.setLogin(json.getString("login"));
                    JSONArray array=json.getJSONArray("esaldiak");

                    for(int i=0;i<array.length();i++){
                        JSONObject item=array.getJSONObject(i);
                        Expresion.Esaldiak exp=new Expresion.Esaldiak();
                        exp.setEsaldiaCast(item.getString("esaldiaCast"));
                        exp.setEsaldiaEusk(item.getString("esaldiaEusk"));
                        exp.setAudioFitxIzena(item.getString("audioFitxIzena"));
                        exp.setErabiltzaileMota(item.getString("erabiltzaileMota"));
                        exp.setIdEsaldiak(item.getInt("idEsaldia"));

                        expresion.getEsaldia().add(exp);
                    }
                    return expresion;
                }
                catch (JSONException e){
                    return null;
                }
            }

            @Override
            protected void onFinish(Expresion result){
                for(int i=0; i<13;i++){
                    TableLayout tl =findViewById(R.id.tableExpresiones);


                    TableRow tr = new TableRow(getApplicationContext());
                    tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                    TextView gaztelaniaz = new TextView(getApplicationContext());
                    gaztelaniaz.setText(result.getEsaldia().get(i).getEsaldiaCast());
                    gaztelaniaz.setGravity(Gravity.CENTER);
                    gaztelaniaz.setTextColor(Color.BLACK);
                    gaztelaniaz.setTextSize(10);

                    TextView euskaraz = new TextView(getApplicationContext());
                    euskaraz.setText(result.getEsaldia().get(i).getEsaldiaEusk());
                    euskaraz.setGravity(Gravity.CENTER);
                    euskaraz.setTextColor(Color.BLACK);
                    euskaraz.setTextSize(10);

                    final Button boton=new Button(getApplicationContext());
                    boton.setText("ENTZUN");
                    boton.setId(i);
                    boton.setGravity(Gravity.CENTER);
                    boton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            int id=boton.getId();
                            reproducir(view,id);
                        }
                    });
                    // TextView audioa = new TextView(getApplicationContext());
                    //audioa.setText(result.getEsaldia().get(i).getAudioFitxIzena());
                    //audioa.setGravity(Gravity.CENTER);
                    //audioa.setTextSize(10);

                    tr.addView(gaztelaniaz);
                    tr.addView(euskaraz);
                    tr.addView(boton);

                    tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    }

                    for(int i=13;i<result.getEsaldia().size();i++){
                        TableLayout tl =findViewById(R.id.tableExpresiones);


                        TableRow tr = new TableRow(getApplicationContext());
                        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        TextView gaztelaniaz = new TextView(getApplicationContext());
                        gaztelaniaz.setText(result.getEsaldia().get(i).getEsaldiaCast());
                        gaztelaniaz.setGravity(Gravity.CENTER);
                        gaztelaniaz.setTextColor(Color.BLACK);
                        gaztelaniaz.setTextSize(10);

                        TextView euskaraz = new TextView(getApplicationContext());
                        euskaraz.setText(result.getEsaldia().get(i).getEsaldiaEusk());
                        euskaraz.setGravity(Gravity.CENTER);
                        euskaraz.setTextColor(Color.BLACK);
                        euskaraz.setTextSize(10);

                        final Button boton=new Button(getApplicationContext());
                        boton.setText("ENTZUN");
                        boton.setId(i);
                        boton.setGravity(Gravity.CENTER);
                        boton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                int id=boton.getId();
                                reproducir2(view,id);
                            }
                        });
                        // TextView audioa = new TextView(getApplicationContext());
                        //audioa.setText(result.getEsaldia().get(i).getAudioFitxIzena());
                        //audioa.setGravity(Gravity.CENTER);
                        //audioa.setTextSize(10);

                        tr.addView(gaztelaniaz);
                        tr.addView(euskaraz);
                        tr.addView(boton);

                        tl.addView(tr, new TableLayout.LayoutParams(TableLayout.LayoutParams.FILL_PARENT, TableLayout.LayoutParams.WRAP_CONTENT));
                    }

            }
        }.execute();
    }

    public void misExpresiones(View view){
        Intent intent=new Intent(this,EstadoExpresionesActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

    public void nuevaExpresion(View view){
        Intent intent=new Intent(this,NuevaExpresionActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
    }

    public void responderExpresion(View view){
        Intent intent=new Intent(this,ExpresionesVaciasActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
    }

    public void reproducir(View view, int id) {
        // Toast.makeText(this,"reproduccion",Toast.LENGTH_SHORT).show();
        if (tipo.matches("eroslea")) {
            switch (id) {
                case 0:
                    Toast.makeText(this,"id:"+id,Toast.LENGTH_SHORT).show();
                    producto = "https://www.dl.dropboxusercontent.com/s/0r7sg8cy4vx9v4x/esaera1.wav";
                    showAudio(producto);
                    break;
                case 1:

                    producto = "https://www.dl.dropboxusercontent.com/s/cghhrfignfir7jb/esaera2.wav";
                    showAudio(producto);
                    break;
                case 2:
                    producto = "https://www.dl.dropboxusercontent.com/s/scq13nzwafzchh4/esaera3.wav";
                    showAudio(producto);
                    break;
                case 3:
                    producto = "https://www.dl.dropboxusercontent.com/s/jln2qcr5qeo7tln/esaera4.wav";
                    showAudio(producto);
                    break;
                case 4:
                    producto = "https://www.dl.dropboxusercontent.com/s/vbr4iikocmrr3sy/esaera5.wav";
                    showAudio(producto);
                    break;
                case 5:
                    producto = "https://www.dl.dropboxusercontent.com/s/m3dd37cpgwap56n/esaera6.wav";
                    showAudio(producto);
                    break;
                case 6:
                    producto = "https://www.dl.dropboxusercontent.com/s/c222sty76qq4qb0/esaera7.wav";
                    showAudio(producto);
                    break;
                case 7:
                    producto = "https://www.dl.dropboxusercontent.com/s/cijmf9ku5jwjv0o/esaera8.wav";
                    showAudio(producto);
                    break;
                case 8:
                    producto = "https://www.dl.dropboxusercontent.com/s/geyp5haffq5si3r/esaera9.wav";
                    showAudio(producto);
                    break;
                case 9:
                    producto = "https://www.dl.dropboxusercontent.com/s/lb5j7gsgraysg55/esaera10.wav";
                    showAudio(producto);
                    break;
                case 10:
                    producto = "https://www.dl.dropboxusercontent.com/s/4ncq8pupj8e4tc2/esaera11.wav";
                    showAudio(producto);
                    break;
                case 11:
                    producto = "https://www.dl.dropboxusercontent.com/s/zu0az4p28eghuot/esaera12.wav";
                    showAudio(producto);
                    break;
                case 12:
                    producto = "https://www.dl.dropboxusercontent.com/s/bimttty5xxjkla2/esaera13.wav";
                    showAudio(producto);
                    break;
            }
        }
        else{
            switch (id) {
                case 0:
                    producto = "https://www.dl.dropboxusercontent.com/s/ea4aofflcnftlee/esaera14.wav";
                    showAudio(producto);
                    break;
                case 1:
                    producto = "https://www.dl.dropboxusercontent.com/s/t9czcupyrhjq4r4/esaera15.wav";
                    showAudio(producto);
                    break;
                case 2:
                    producto = "https://www.dl.dropboxusercontent.com/s/r8dqfh8tv13e2qh/esaera16.wav";
                    showAudio(producto);
                    break;
                case 3:
                    producto = "https://www.dl.dropboxusercontent.com/s/gkrx3jc2inktbe3/esaera17.wav";
                    showAudio(producto);
                    break;
                case 4:
                    producto = "https://www.dl.dropboxusercontent.com/s/2nlqsjzaacosxlt/esaera18.wav";
                    showAudio(producto);
                    break;
                case 5:
                    producto = "https://www.dl.dropboxusercontent.com/s/259eb70re30z3nt/esaera19.wav";
                    showAudio(producto);
                    break;
                case 6:
                    producto = "https://www.dl.dropboxusercontent.com/s/6g2gddc2kqcdaim/esaera20.wav";
                    showAudio(producto);
                    break;
                case 7:
                    producto = "https://www.dl.dropboxusercontent.com/s/bvoyiaku6jrradl/esaera21.wav";
                    showAudio(producto);
                    break;
                case 8:
                    producto = "https://www.dl.dropboxusercontent.com/s/p1bkepn4byzf4y2/esaera22.wav";
                    showAudio(producto);
                    break;
                case 9:
                    producto = "https://www.dl.dropboxusercontent.com/s/gs15up5fiqjwvc8/esaera23.wav";
                    showAudio(producto);
                    break;
                case 10:
                    producto = "https://www.dl.dropboxusercontent.com/s/7azsx10cwe7rsvf/esaera24.wav";
                    showAudio(producto);
                    break;
                case 11:
                    producto = "https://www.dl.dropboxusercontent.com/s/h2g1kla7m5a5073/esaera25.wav";
                    showAudio(producto);
                    break;
                case 12:
                    producto = "https://www.dl.dropboxusercontent.com/s/tfbesbmffurhvli/esaera26.wav";
                    showAudio(producto);
                    break;
            }
        }
    }

    public void reproducir2(View view, int id){
        // Toast.makeText(this,"id:"+id,Toast.LENGTH_SHORT).show();
        int num=expresion.getEsaldia().get(id).getIdEsaldiak();
        producto = "http://u017633.ehu.eus:28080/static/Appetc_Rest/audio/esaera"+num+".mp4";
        showAudio(producto);
    }
    public void showAudio(String producto){

        View view=new View(this);
        AudioPlayer audio=new AudioPlayer(view);
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        try{
            audio.setAudioUri(Uri.parse(producto));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ViewGroup layout=(ViewGroup)findViewById(R.id.mostrarExpresion);
        layout.addView(view);
        audio.start();
    }

}
