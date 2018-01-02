package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class OcaPescaderiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oca_pescaderia);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        TextView correctos=(TextView)findViewById(R.id.correcto2);
        correctos.setText("Zuzenak: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        TextView fallos=(TextView)findViewById(R.id.fallo2);
        fallos.setText("Okerrak: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void pato12(View view){

    }

    public void pato22(View view){

    }

    public void pato32(View view){

    }

}
