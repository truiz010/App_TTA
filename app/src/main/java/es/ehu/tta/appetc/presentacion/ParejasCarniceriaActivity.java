package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.GREEN;
import static android.graphics.Color.RED;
import static android.graphics.Color.YELLOW;

public class ParejasCarniceriaActivity extends AppCompatActivity {

    //public static  int boton1=0;
    //public static  int boton2=0;
    //public static  int boton3=0;
    //public static  int boton4=0;
    public static int pulsado=0;

    public static  int imagen1=0;
    public static  int imagen2=0;
    public static  int imagen3=0;
    public static  int imagen4=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas_carniceria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void boton1(View view){

        if(pulsado==0){
            // boton1=1;
            findViewById(R.id.boton).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                // boton1=2;
                findViewById(R.id.boton).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //  boton1=3;
                    findViewById(R.id.boton).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton1=4;
                        findViewById(R.id.boton).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen1(View view){

        if(pulsado==1){
            findViewById(R.id.imagen1).setBackgroundColor(BLUE);
            imagen1=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.imagen1).setBackgroundColor(RED);
            imagen1=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.imagen1).setBackgroundColor(GREEN);
            imagen1=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.imagen1).setBackgroundColor(YELLOW);
            imagen1=4;
        }
    }

    public void boton2(View view){

        if(pulsado==0){
            // boton2=1;
            findViewById(R.id.boton2).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                // boton2=2;
                findViewById(R.id.boton2).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //boton2=3;
                    findViewById(R.id.boton2).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton2=4;
                        findViewById(R.id.boton2).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen2(View view){

        if(pulsado==1){
            findViewById(R.id.imagen2).setBackgroundColor(BLUE);
            imagen2=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.imagen2).setBackgroundColor(RED);
            imagen2=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.imagen2).setBackgroundColor(GREEN);
            imagen2=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.imagen2).setBackgroundColor(YELLOW);
            imagen2=4;
        }
    }

    public void boton3(View view){

        if(pulsado==0){
            // boton3=1;
            findViewById(R.id.boton3).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                //  boton3=2;
                findViewById(R.id.boton3).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //    boton3=3;
                    findViewById(R.id.boton3).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        //   boton3=4;
                        findViewById(R.id.boton3).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen3(View view){

        if(pulsado==1){
            findViewById(R.id.imagen3).setBackgroundColor(BLUE);
            imagen3=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.imagen3).setBackgroundColor(RED);
            imagen3=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.imagen3).setBackgroundColor(GREEN);
            imagen3=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.imagen3).setBackgroundColor(YELLOW);
            imagen3=4;
        }
    }

    public void boton4(View view){

        if(pulsado==0){
            //boton4=1;
            findViewById(R.id.boton4).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                //  boton4=2;
                findViewById(R.id.boton4).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    // boton4=3;
                    findViewById(R.id.boton4).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton4=4;
                        findViewById(R.id.boton4).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen4(View view){

        if(pulsado==1){
            findViewById(R.id.imagen4).setBackgroundColor(BLUE);
            imagen4=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.imagen4).setBackgroundColor(RED);
            imagen4=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.imagen4).setBackgroundColor(GREEN);
            imagen4=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.imagen4).setBackgroundColor(YELLOW);
            imagen4=4;
        }
    }

    public void correguir(View view){
        int correcto=0;
        int error=0;

        if(imagen3==1){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen1==2){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen4==3){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen2==4){
            correcto++;
        }
        else{
            error++;
        }

        Toast.makeText(
                this,
                "Correctas: "+correcto+" Fallos: "+error,
                Toast.LENGTH_SHORT
        ).show();
    }
}
