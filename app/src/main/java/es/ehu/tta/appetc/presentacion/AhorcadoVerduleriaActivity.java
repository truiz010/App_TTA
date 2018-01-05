package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class AhorcadoVerduleriaActivity extends AppCompatActivity {

    public static int acierto3=0;
    public static int fallo3=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado_verduleria);
        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void comprobar(View view){

        String letra=((EditText)findViewById(R.id.letra)).getText().toString();
        TextView gion13=(TextView)findViewById(R.id.gion13);
        TextView gion23=(TextView)findViewById(R.id.gion23);
        TextView gion33=(TextView)findViewById(R.id.gion33);
        TextView gion43=(TextView)findViewById(R.id.gion43);
        TextView gion53=(TextView)findViewById(R.id.gion53);
        TextView gion63=(TextView)findViewById(R.id.gion63);
        TextView gion73=(TextView)findViewById(R.id.gion73);
        TextView gion83=(TextView)findViewById(R.id.gion83);


        if(letra.equals("m")){
            gion13.setText("M");
            acierto3++;
        }
        else
        if(letra.equals("a")){
            gion23.setText("A");
            gion83.setText("A");
            acierto3++;
        }
        else
        if(letra.equals("r")){
            gion33.setText("R");
            gion43.setText("R");
            acierto3++;
        }
        else
        if(letra.equals("u")){
            gion53.setText("U");
            acierto3++;
        }else
        if(letra.equals("b")){
            gion63.setText("B");
            acierto3++;
        }
        else
        if(letra.equals("i")){
            gion73.setText("I");
            acierto3++;
        }
        else{
            fallo3++;
        }

        if(acierto3==6){
            Toast.makeText(
                    this,
                    "ZORIONAK!!! PRODUKTUA ASMATU DUZU",
                    Toast.LENGTH_SHORT
            ).show();
        }else
        if(fallo3==1){
            findViewById(R.id.imagenError).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==2){
            findViewById(R.id.imagenError).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError1).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==3){
            findViewById(R.id.imagenError1).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError2).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==4){
            findViewById(R.id.imagenError2).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError3).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==5){
            findViewById(R.id.imagenError3).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError4).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==6){
            findViewById(R.id.imagenError4).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError5).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==7){
            findViewById(R.id.imagenError5).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError6).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==8){
            findViewById(R.id.imagenError6).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError7).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==9){
            findViewById(R.id.imagenError7).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError8).setVisibility(View.VISIBLE);
        }
        else
        if(fallo3==10){
            findViewById(R.id.imagenError8).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError9).setVisibility(View.VISIBLE);
            Toast.makeText(
                    this,
                    "GALDU DUZU. ASMATU BEHARREKO PRODUKTUA MARRUBIA DA",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    public void ayuda(View view){
        Toast.makeText(
                this,
                "Haziz jantzita nagoela diote. Bihotz itxura, gorria gorputza, berdea burua.",
                Toast.LENGTH_SHORT
        ).show();
    }

}
