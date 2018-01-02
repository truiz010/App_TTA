package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class VerduleriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verduleria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }



    public void ahorcado(View view){
        Intent intent=new Intent(this,AhorcadoVerduleriaActivity.class);
        startActivity(intent);
    }

    public void parejas(View view){
        Intent intent=new Intent(this,ParejasVerduleriaActivity.class);
        startActivity(intent);
    }

    public void palabraCorrecta(View view){
        Intent intent=new Intent(this,PalabraCorrectaVerduleriaActivity.class);
        startActivity(intent);
    }

    public void oca(View view){
        Intent intent=new Intent(this,OcaVerduleriaActivity.class);
        startActivity(intent);
    }

    public void diccionarioVerduleria(View view){
        Intent intent=new Intent(this,DiccionarioVerduleriaActivity.class);
        startActivity(intent);
    }

}
