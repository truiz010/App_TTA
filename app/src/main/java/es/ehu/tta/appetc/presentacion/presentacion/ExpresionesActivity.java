package es.ehu.tta.appetc.presentacion.presentacion;

import android.animation.TimeAnimator;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
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
                    JSONObject json=rest.getJSON(String.format("requestEsaldiak?login=%s",login+"&erabiltzaileMota="+tipo));

                    Expresion expresion=new Expresion();
                    expresion.setLogin(json.getString("login"));
                    JSONArray array=json.getJSONArray("esaldiak");

                    for(int i=0;i<array.length();i++){
                        JSONObject item=array.getJSONObject(i);
                        Expresion.Esaldia exp=new Expresion.Esaldia();
                        exp.setEsaldiaCast(item.getString("esaldiaCast"));
                        exp.setEsaldiaEusk(item.getString("esaldiaEusk"));
                        exp.setAudioFitxIzena(item.getString("audioFitxIzena"));
                        exp.setErabiltzaileMota(item.getString("erabiltzaileMota"));
                        exp.setIdEsaldiak(item.getInt("idEsaldiak"));
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

               String[] esaldiaCast=new String[0];
                String[] esaldiaEusk= new String[0];
                String[] audioFitxIzena=new String[0];

                    for(int i=0; i<result.getEsaldiak().size();i++){
                        TableLayout tl =findViewById(R.id.tableExpresiones);

                        TableRow tr = new TableRow(getApplicationContext());
                        tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.FILL_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

                        TextView gaztelaniaz = new TextView(getApplicationContext());
                        gaztelaniaz.setText(result.getEsaldiak().get(i).getEsaldiaCast());
                        gaztelaniaz.setGravity(Gravity.CENTER);
                        gaztelaniaz.setTextSize(10);

                        TextView euskaraz = new TextView(getApplicationContext());
                        euskaraz.setText(result.getEsaldiak().get(i).getEsaldiaEusk());
                        euskaraz.setGravity(Gravity.CENTER);
                        euskaraz.setTextSize(10);

                        TextView audioa = new TextView(getApplicationContext());
                        audioa.setText(result.getEsaldiak().get(i).getAudioFitxIzena());
                        audioa.setGravity(Gravity.CENTER);
                        audioa.setTextSize(10);

                        tr.addView(gaztelaniaz);
                        tr.addView(euskaraz);
                        tr.addView(audioa);

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

}
