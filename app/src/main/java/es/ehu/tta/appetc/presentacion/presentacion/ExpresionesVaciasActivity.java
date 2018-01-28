package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
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

public class ExpresionesVaciasActivity extends AppCompatActivity {

    //String expresion="¿Cuanto cuesta eso?";
    String login;
    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");
    //public final static String EXTRA_ESAERACAST = "esaeraCast";
    public final static String EXTRA_ERABILTZAILEMOTA = "erabiltzaileMota";
    public final static String EXTRA_IDESALDIAK = "idEsaldiak";
    Expresion expresion;
   // static int numBotones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresiones_vacias);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);

        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        //TextView textExpresion=(TextView)findViewById(R.id.botonExpresion);
       // textExpresion.setText(expresion);

        new ProgressTask<Expresion>(this){

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            protected Expresion work()throws IOException {
                try{
                    Expresion expresion=new Expresion();
                    JSONObject json=rest.getJSON(String.format("requestForoa?login=%s",login));

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
                Toast.makeText(getApplicationContext(),"Pagina de expresiones",Toast.LENGTH_SHORT).show();

                for(int i=0; i<result.getEsaldia().size();i++){
                    LinearLayout ll=findViewById(R.id.llBotonera);
                    Button boton=new Button(getApplicationContext());
                    boton.setText(result.getEsaldia().get(i).getEsaldiaCast());
                    boton.setGravity(Gravity.CENTER);
                    ll.addView(boton);
                }
            }
        }.execute();

    }

    public void responderExpresion(View view, int id){
        Intent intent=new Intent(this,ResponderExpresionActivity.class);
        intent.putExtra(ExpresionesVaciasActivity.EXTRA_ERABILTZAILEMOTA,expresion.getEsaldia().get(id).getErabiltzaileMota());
        //intent.putExtra(ExpresionesVaciasActivity.EXTRA_ESAERACAST,expresion.getEsaldia().get(id).getEsaldiaCast());
        int ide=expresion.getEsaldia().get(id).getIdEsaldiak();
        intent.putExtra(ExpresionesVaciasActivity.EXTRA_IDESALDIAK,Integer.toString(ide));
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

}
