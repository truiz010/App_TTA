package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class ParejasPescaderiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas_pescaderia);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void boton12(View view){

    }

    public void imagen12(View view){

    }

    public void boton22(View view){

    }

    public void imagen22(View view){

    }

    public void boton32(View view){

    }

    public void imagen32(View view){

    }

    public void boton42(View view){

    }

    public void imagen42(View view){

    }

    public void correguir2(View view){

    }

}
