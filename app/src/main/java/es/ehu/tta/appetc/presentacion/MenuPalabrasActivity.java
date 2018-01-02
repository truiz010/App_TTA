package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class MenuPalabrasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_palabras);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Bienvenido "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void carniceria(View view){

    }

    public void pescaderia(View view){

    }

    public void verduleria(View view){

    }

    public void productos(View view){

    }
}
