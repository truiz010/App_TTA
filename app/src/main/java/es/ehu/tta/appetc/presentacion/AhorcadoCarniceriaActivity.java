package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class AhorcadoCarniceriaActivity extends AppCompatActivity {

    public static int acierto=0;
    public static int fallo=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado_carniceria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void comprobar(View view){

        String letra=((EditText)findViewById(R.id.letra)).getText().toString();
        TextView gion1=(TextView)findViewById(R.id.gion1);
        TextView gion2=(TextView)findViewById(R.id.gion2);
        TextView gion3=(TextView)findViewById(R.id.gion3);
        TextView gion4=(TextView)findViewById(R.id.gion4);
        TextView gion5=(TextView)findViewById(R.id.gion5);
        TextView gion6=(TextView)findViewById(R.id.gion6);
        TextView gion7=(TextView)findViewById(R.id.gion7);

        if(letra.equals("s")){
            gion1.setText("S");
            acierto++;
        }
        else
        if(letra.equals("o")){
            gion2.setText("O");
            gion4.setText("O");
            gion6.setText("O");
            acierto++;
        }
        else
        if(letra.equals("l")){
            gion3.setText("L");
            acierto++;
        }
        else
        if(letra.equals("m")){
            gion5.setText("M");
            acierto++;
        }else
        if(letra.equals("a")){
            gion7.setText("A");
            acierto++;
        }
        else{
            fallo++;
        }
        if(acierto==5){
            Toast.makeText(
                    this,
                    "ZORIONAK!!! PRODUKTUA ASMATU DUZU",
                    Toast.LENGTH_SHORT
            ).show();
        }else
        if(fallo==1){
            findViewById(R.id.imagenError).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==2){
            findViewById(R.id.imagenError).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError1).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==3){
            findViewById(R.id.imagenError1).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError2).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==4){
            findViewById(R.id.imagenError2).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError3).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==5){
            findViewById(R.id.imagenError3).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError4).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==6){
            findViewById(R.id.imagenError4).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError5).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==7){
            findViewById(R.id.imagenError5).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError6).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==8){
            findViewById(R.id.imagenError6).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError7).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==9){
            findViewById(R.id.imagenError7).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError8).setVisibility(View.VISIBLE);
        }
        else
        if(fallo==10){
            findViewById(R.id.imagenError8).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError9).setVisibility(View.VISIBLE);
            Toast.makeText(
                    this,
                    "GALDU DUZU. ASMATU BEHARREKO PRODUKTUA SOLOMOA DA",
                    Toast.LENGTH_SHORT
            ).show();
        }

    }

    public void ayuda(View view){
        Toast.makeText(
                this,
                "Gaztelaniaz badakizu, erraz asmatuko duzu! Adobaturik aurkitu dezakezu harategian",
                Toast.LENGTH_SHORT
        ).show();
    }

}
