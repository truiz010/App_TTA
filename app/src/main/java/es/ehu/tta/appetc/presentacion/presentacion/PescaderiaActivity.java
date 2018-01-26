package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class PescaderiaActivity extends AppCompatActivity {

    String login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pescaderia);

        Intent intent=getIntent();
        login=intent.getStringExtra(SesionActivity.EXTRA_LOGIN);
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void ahorcado(View view){
        Intent intent=new Intent(this,AhorcadoPescaderiaActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

    public void parejas(View view){
        Intent intent=new Intent(this,ParejasPescaderiaActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

    public void palabraCorrecta(View view){
        Intent intent=new Intent(this,PalabraCorrectaPescaderiaActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

    public void oca(View view){
        Intent intent=new Intent(this,OcaPescaderiaActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

    public void diccionarioPescaderia(View view){
        Intent intent=new Intent(this,DiccionarioPescaderiaActivity.class);
        intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
        startActivity(intent);
    }

}
