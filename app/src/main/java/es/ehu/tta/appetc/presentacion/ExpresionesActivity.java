package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class ExpresionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresiones);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        Intent intent2=getIntent();
        TextView textUsuario=(TextView)findViewById(R.id.expresiones);
        textUsuario.setText("Expresiones tipicas de un "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void misExpresiones(View view){
        Intent intent=new Intent(this,EstadoExpresionesActivity.class);
        startActivity(intent);
    }

    public void nuevaExpresion(View view){
        Intent intent=new Intent(this,NuevaExpresionActivity.class);
        startActivity(intent);
    }

    public void responderExpresion(View view){
        Intent intent=new Intent(this,ExpresionesVaciasActivity.class);
        startActivity(intent);
    }

}
