package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import es.ehu.tta.appetc.R;

public class OcaVerduleriaActivity extends AppCompatActivity {

    public static  int Okerra=0;
    public static  int Zuzena=0;
    public static  int correcto=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oca_verduleria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        TextView correctos=(TextView)findViewById(R.id.correcto3);
        correctos.setText("Zuzenak: "+Zuzena);

        TextView fallos=(TextView)findViewById(R.id.fallo3);
        fallos.setText("Okerrak: "+Okerra);
    }

    public void pato13(View view){

        findViewById(R.id.pato13).setBackgroundColor(Color.BLUE);

        int pulsado=0;
        if(pulsado==correcto){
            Zuzena++;
            TextView correctos=(TextView)findViewById(R.id.correcto3);
            correctos.setText("Zuzenak: "+Zuzena);

            TextView fallos=(TextView)findViewById(R.id.fallo3);
            fallos.setText("Okerrak: "+Okerra);
        }
        else{
            Okerra++;
            TextView fallos=(TextView)findViewById(R.id.fallo3);
            fallos.setText("Okerrak: "+Okerra);

            TextView correctos=(TextView)findViewById(R.id.correcto3);
            correctos.setText("Zuzenak: "+Zuzena);
        }
    }

    public void pato23(View view){



        findViewById(R.id.pato23).setBackgroundColor(Color.RED);

        int pulsado=1;
        if(pulsado==correcto){
            Zuzena++;
            TextView correctos=(TextView)findViewById(R.id.correcto3);
            correctos.setText("Zuzenak: "+Zuzena);

            TextView fallos=(TextView)findViewById(R.id.fallo3);
            fallos.setText("Okerrak: "+Okerra);
        }
        else{
            Okerra++;
            TextView fallos=(TextView)findViewById(R.id.fallo3);
            fallos.setText("Okerrak: "+Okerra);

            TextView correctos=(TextView)findViewById(R.id.correcto3);
            correctos.setText("Zuzenak: "+Zuzena);
        }
    }

    public void pato33(View view){



        findViewById(R.id.pato33).setBackgroundColor(Color.GREEN);

        int pulsado=2;
        if(pulsado==correcto){
            Zuzena++;
            TextView correctos=(TextView)findViewById(R.id.correcto3);
            correctos.setText("Zuzenak: "+Zuzena);

            TextView fallos=(TextView)findViewById(R.id.fallo3);
            fallos.setText("Okerrak: "+Okerra);
        }
        else{
            Okerra++;
            TextView fallos=(TextView)findViewById(R.id.fallo3);
            fallos.setText("Okerrak: "+Okerra);

            TextView correctos=(TextView)findViewById(R.id.correcto3);
            correctos.setText("Zuzenak: "+Zuzena);
        }
    }

}
