package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class MenuActivity extends AppCompatActivity {

    String login;
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);
        tipo=intent.getStringExtra(MenuPrincipalActivity.EXTRA_TIPO);

        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void expresiones(View view){

        Intent intent=new Intent(this,ExpresionesActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        intent.putExtra(MenuPrincipalActivity.EXTRA_TIPO,tipo);
        startActivity(intent);
    }

    public void palabras(View view){
        Intent intent=new Intent(this,PalabrasActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }
}
