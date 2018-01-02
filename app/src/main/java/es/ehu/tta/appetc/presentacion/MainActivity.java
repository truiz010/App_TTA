package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import es.ehu.tta.appetc.R;
import es.ehu.tta.appetc.presentacion.RegistroActivity;
import es.ehu.tta.appetc.presentacion.SesionActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void iniciarSesion(View view){
        Intent intent=new Intent(this,SesionActivity.class);
        startActivity(intent);
    }

    public void registrarse(View view){
        Intent intent=new Intent(this,RegistroActivity.class);
        startActivity(intent);
    }
}
