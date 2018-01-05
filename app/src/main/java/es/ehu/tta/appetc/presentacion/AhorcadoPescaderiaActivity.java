package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class AhorcadoPescaderiaActivity extends AppCompatActivity {

    public static int acierto2=0;
    public static int fallo2=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ahorcado_pescaderia);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void comprobar(View view){

        String letra=((EditText)findViewById(R.id.letra)).getText().toString();
        TextView gion12=(TextView)findViewById(R.id.gion12);
        TextView gion22=(TextView)findViewById(R.id.gion22);
        TextView gion32=(TextView)findViewById(R.id.gion32);
        TextView gion42=(TextView)findViewById(R.id.gion42);
        TextView gion52=(TextView)findViewById(R.id.gion52);
        TextView gion62=(TextView)findViewById(R.id.gion62);
        TextView gion72=(TextView)findViewById(R.id.gion72);
        TextView gion82=(TextView)findViewById(R.id.gion82);
        TextView gion92=(TextView)findViewById(R.id.gion92);
        TextView gion102=(TextView)findViewById(R.id.gion102);

        if(letra.equals("i")){
            gion12.setText("I");
            acierto2++;
        }
        else
        if(letra.equals("t")){
            gion22.setText("T");
            acierto2++;
        }
        else
        if(letra.equals("s")){
            gion32.setText("S");
            gion52.setText("S");
            acierto2++;
        }
        else
        if(letra.equals("a")){
            gion42.setText("A");
            gion72.setText("A");
            gion102.setText("A");
            acierto2++;
        }else
        if(letra.equals("z")){
            gion62.setText("Z");
            acierto2++;
        }
        else
        if(letra.equals("o")){
            gion92.setText("O");
            acierto2++;
        }
        else
        if(letra.equals("p")){
            gion82.setText("P");
            acierto2++;
        }
        else{
            fallo2++;
        }

        if(acierto2==7){
            Toast.makeText(
                    this,
                    "ZORIONAK!!! PRODUKTUA ASMATU DUZU",
                    Toast.LENGTH_SHORT
            ).show();
        }else
        if(fallo2==1){
            findViewById(R.id.imagenError).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==2){
            findViewById(R.id.imagenError).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError1).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==3){
            findViewById(R.id.imagenError1).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError2).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==4){
            findViewById(R.id.imagenError2).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError3).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==5){
            findViewById(R.id.imagenError3).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError4).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==6){
            findViewById(R.id.imagenError4).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError5).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==7){
            findViewById(R.id.imagenError5).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError6).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==8){
            findViewById(R.id.imagenError6).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError7).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==9){
            findViewById(R.id.imagenError7).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError8).setVisibility(View.VISIBLE);
        }
        else
        if(fallo2==10){
            findViewById(R.id.imagenError8).setVisibility(View.INVISIBLE);
            findViewById(R.id.imagenError9).setVisibility(View.VISIBLE);
            Toast.makeText(
                    this,
                    "GALDU DUZU. ASMATU BEHARREKO PRODUKTUA ITSAS ZAPOA DA",
                    Toast.LENGTH_SHORT
            ).show();
        }
    }

    public void ayuda(View view){
        Toast.makeText(
                this,
                "Anfibio batek nire abizena darama. Lurrean 'kroak! kroak! egingo nuke",
                Toast.LENGTH_SHORT
        ).show();
    }

}
