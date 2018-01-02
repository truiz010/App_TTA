package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class ExpresionesVaciasActivity extends AppCompatActivity {

    String expresion="¿Cuanto cuesta eso?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expresiones_vacias);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        TextView textExpresion=(TextView)findViewById(R.id.botonExpresion);
        textExpresion.setText(expresion);
    }

    public void responderExpresion(View view){
        Intent intent=new Intent(this,ResponderExpresionActivity.class);
        startActivity(intent);
    }

}
