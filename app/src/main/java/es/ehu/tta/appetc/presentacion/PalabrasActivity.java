package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class PalabrasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabras);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void carniceria(View view){
        Intent intent=new Intent(this,CarniceriaActivity.class);
        startActivity(intent);
    }

    public void pescaderia(View view){
        Intent intent=new Intent(this,PescaderiaActivity.class);
        startActivity(intent);
    }

    public void verduleria(View view){
        Intent intent=new Intent(this,VerduleriaActivity.class);
        startActivity(intent);
    }

    public void productos(View view){
        Intent intent=new Intent(this,TodosProductosActivity.class);
        startActivity(intent);
    }

}
