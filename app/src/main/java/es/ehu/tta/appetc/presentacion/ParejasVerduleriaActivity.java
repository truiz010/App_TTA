package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class ParejasVerduleriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas_verduleria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void boton13(View view){

    }

    public void imagen13(View view){

    }

    public void boton23(View view){

    }

    public void imagen23(View view){

    }

    public void boton33(View view){

    }

    public void imagen33(View view){

    }

    public void boton43(View view){

    }

    public void imagen43(View view){

    }

    public void correguir3(View view){

    }

}
