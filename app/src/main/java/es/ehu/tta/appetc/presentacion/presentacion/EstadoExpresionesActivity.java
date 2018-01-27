package es.ehu.tta.appetc.presentacion.presentacion;

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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.modelo.Expresion;
import es.ehu.tta.appetc.presentacion.modelo.ProgressTask;
import es.ehu.tta.appetc.presentacion.modelo.RestClient;

public class EstadoExpresionesActivity extends AppCompatActivity {

    String login;
    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");
    Expresion expresion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estado_expresiones);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);

        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        new ProgressTask<Expresion>(this){

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Expresion work()throws IOException, JSONException {
                try{
                    expresion=new Expresion();
                    JSONObject json=rest.getJSON(String.format("requestEsaldiaUser?login=%s",login));

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
                for(int i=0; i<result.getEsaldia().size();i++){
                    TableLayout tl =findViewById(R.id.tableEstadoExpresiones);

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
                    //TextView audioa = new TextView(getApplicationContext());
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

    public void reproducir(View view, int id){

        if(expresion.getEsaldia().get(id).getAudioFitxIzena().contains("esaera")){
            int num=expresion.getEsaldia().get(id).getIdEsaldiak();
            String producto = "http://u017633.ehu.eus:28080/static/Appetc_Rest/esaera"+num+".3gpp";
            //String producto="http://u017633.ehu.eus:28080/static/ServidorTta/AndroidManifest.mp4";
            showAudio(producto);
        }
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
        ViewGroup layout=(ViewGroup)findViewById(R.id.estadoExpresion);
        layout.addView(view);
        audio.start();
    }

}
