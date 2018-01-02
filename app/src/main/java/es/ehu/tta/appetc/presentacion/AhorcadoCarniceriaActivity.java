package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class AhorcadoCarniceriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado_carniceria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void comprobar(View view){

    }

    public void ayuda(View view){
        Toast.makeText(
                this,
                "Gaztelaniaz badakizu, erraz asmatuko duzu! Adobaturik aurkitu dezakezu harategian",
                Toast.LENGTH_SHORT
        ).show();
    }

}
