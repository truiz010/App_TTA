package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class AhorcadoPescaderiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado_pescaderia);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void comprobar(View view){

    }

    public void ayuda(View view){
        Toast.makeText(
                this,
                "Anfibio batek nire abizena darama. Lurrean 'kroak! kroak! egingo nuke",
                Toast.LENGTH_SHORT
        ).show();
    }

}
