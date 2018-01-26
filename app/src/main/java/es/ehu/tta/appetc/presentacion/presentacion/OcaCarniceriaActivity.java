package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class OcaCarniceriaActivity extends AppCompatActivity {

    public static  int Okerra=0;
    public static  int Zuzena=0;
    public static  int correcto=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oca_carniceria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        TextView correctos=(TextView)findViewById(R.id.correcto);
        correctos.setText("Zuzenak: "+Zuzena);

        TextView fallos=(TextView)findViewById(R.id.fallo);
        fallos.setText("Okerrak: "+Okerra);
    }

    public void pato1(View view){



        findViewById(R.id.pato1).setBackgroundColor(Color.BLUE);

        int pulsado=0;
        if(pulsado==correcto){
            Zuzena++;
            TextView correctos=(TextView)findViewById(R.id.correcto);
            correctos.setText("Zuzenak: "+Zuzena);

            TextView fallos=(TextView)findViewById(R.id.fallo);
            fallos.setText("Okerrak: "+Okerra);
        }
        else{
            Okerra++;
            TextView fallos=(TextView)findViewById(R.id.fallo);
            fallos.setText("Okerrak: "+Okerra);

            TextView correctos=(TextView)findViewById(R.id.correcto);
            correctos.setText("Zuzenak: "+Zuzena);
        }

    }

    public void pato2(View view){

        findViewById(R.id.pato2).setBackgroundColor(Color.RED);

        int pulsado=1;
        if(pulsado==correcto){
            Zuzena++;
            TextView correctos=(TextView)findViewById(R.id.correcto);
            correctos.setText("Zuzenak: "+Zuzena);

            TextView fallos=(TextView)findViewById(R.id.fallo);
            fallos.setText("Okerrak: "+Okerra);
        }
        else{
            Okerra++;
            TextView fallos=(TextView)findViewById(R.id.fallo);
            fallos.setText("Okerrak: "+Okerra);

            TextView correctos=(TextView)findViewById(R.id.correcto);
            correctos.setText("Zuzenak: "+Zuzena);
        }

    }

    public void pato3(View view){

        findViewById(R.id.pato3).setBackgroundColor(Color.GREEN);

        int pulsado=2;
        if(pulsado==correcto){
            Zuzena++;
            TextView correctos=(TextView)findViewById(R.id.correcto);
            correctos.setText("Zuzenak: "+Zuzena);

            TextView fallos=(TextView)findViewById(R.id.fallo);
            fallos.setText("Okerrak: "+Okerra);
        }
        else{
            Okerra++;
            TextView fallos=(TextView)findViewById(R.id.fallo);
            fallos.setText("Okerrak: "+Okerra);

            TextView correctos=(TextView)findViewById(R.id.correcto);
            correctos.setText("Zuzenak: "+Zuzena);
        }

    }

}
