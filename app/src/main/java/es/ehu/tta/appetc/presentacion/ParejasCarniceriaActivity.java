package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class ParejasCarniceriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas_carniceria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void boton1(View view){

    }

    public void imagen1(View view){

    }

    public void boton2(View view){

    }

    public void imagen2(View view){

    }

    public void boton3(View view){

    }

    public void imagen3(View view){

    }

    public void boton4(View view){

    }

    public void imagen4(View view){

    }

    public void correguir(View view){

    }

}
