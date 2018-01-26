package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class MenuPrincipalActivity extends AppCompatActivity {

    String login;
    public static final String EXTRA_TIPO="tipo";
    String tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);

        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void comprador(View view){

        Intent intent=new Intent(this,MenuActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        tipo="eroslea";
        intent.putExtra(MenuPrincipalActivity.EXTRA_TIPO,tipo);
        startActivity(intent);
    }

    public void vendedor(View view){
        Intent intent=new Intent(this,MenuActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        tipo="saltzailea";
        intent.putExtra(MenuPrincipalActivity.EXTRA_TIPO,tipo);
        startActivity(intent);
    }
}
