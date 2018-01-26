package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.modelo.ProgressTask;
import es.ehu.tta.appetc.presentacion.modelo.RestClient;
import es.ehu.tta.appetc.presentacion.modelo.User;

public class SesionActivity extends AppCompatActivity {

    public static final String EXTRA_LOGIN="login";
    private RestClient rest=new RestClient("http://u017633.ehu.eus:28080/Appetc_Rest/rest/Appetc");
    String resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
    }

    public void login(View view){
        Intent intent=new Intent(this,MenuPrincipalActivity.class);
        final String login=((EditText)findViewById(R.id.login)).getText().toString();
        final String passwd=((EditText)findViewById(R.id.passwd)).getText().toString();
        if(login.matches("")||passwd.matches("")){
            Toast.makeText(
                    this,
                    "Rellene todos los campos",
                    Toast.LENGTH_SHORT
            ).show();
        }
        else{
            /*intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
            Toast.makeText(
                    this,
                    "Acceso correcto",
                    Toast.LENGTH_SHORT
            ).show();*/

            new ProgressTask<User>(this){


                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                protected User work()throws Exception{
                    User usuario=new User();
                    resultado=rest.getString(String.format("loginUser?login=%s",login+"&pasahitza="+passwd));
                    usuario.setRespuesta(resultado);
                    return usuario;
                }

                @Override
                protected void onFinish(User result){

                    if(result.getRespuesta().matches("OK")){
                        Intent intent=new Intent(getApplicationContext(),MenuPrincipalActivity.class);
                        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
                        startActivity(intent);
                    }
                    else
                    if(result.getRespuesta().matches("PASSWORD ERROR")){
                        Toast.makeText(getApplicationContext(),"Password erroreo",Toast.LENGTH_SHORT).show();

                    }
                    else
                    if(result.getRespuesta().matches("LOGIN ERROR")){
                        Toast.makeText(getApplicationContext(),"Usuario no registrado",Toast.LENGTH_SHORT).show();
                    }

                }
            }.execute();
        }

        //startActivity(intent);

    }
}
