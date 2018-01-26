package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.modelo.Expresion;
import es.ehu.tta.appetc.presentacion.modelo.ProgressTask;
import es.ehu.tta.appetc.presentacion.modelo.RestClient;

public class NuevaExpresionActivity extends AppCompatActivity {

    String login;
    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");
    String respuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_expresion);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void añadirExpresion(View view){

        final String esaldiaCast=((EditText)findViewById(R.id.expresionCast)).getText().toString();
        final String erabiltzaileMota=((EditText)findViewById(R.id.tipoUsuario)).getText().toString();

        if(esaldiaCast.matches("")|| erabiltzaileMota.matches("")){
            Toast.makeText(
                    this,
                    "Rellene todos los campos",
                    Toast.LENGTH_SHORT
            ).show();
        }
        else
        {
            new ProgressTask<Expresion>(this){
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                protected Expresion work()throws IOException, JSONException {
                    JSONObject json=new JSONObject();
                    json.put("login",login);
                    json.put("esaldiaCast",esaldiaCast);
                    json.put("erabiltzaileMota",erabiltzaileMota);

                    respuesta=rest.postJSON(json,String.format("addEsaldia"));
                    Expresion exp=new Expresion();
                    exp.setRespuesta(respuesta);
                    return exp;
                }

                @Override
                protected void onFinish(Expresion result){

                    if(result.getRespuesta().matches("Esaldia gehituta")){

                        Toast.makeText(getApplicationContext(),"Esaera berria foroan gehitu da",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Errore bat gertatuta da",Toast.LENGTH_SHORT).show();
                    }

                }
            }.execute();
        }
    }

}
