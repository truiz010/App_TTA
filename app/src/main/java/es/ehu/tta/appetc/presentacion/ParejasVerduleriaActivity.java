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

public class ParejasVerduleriaActivity extends AppCompatActivity {

    //public static  int boton1=0;
    //public static  int boton2=0;
    //public static  int boton3=0;
    //public static  int boton4=0;
    public static int pulsado=0;

    public static  int imagen13=0;
    public static  int imagen23=0;
    public static  int imagen33=0;
    public static  int imagen43=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas_verduleria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void boton13(View view){
        if(pulsado==0){
            // boton1=1;
            findViewById(R.id.boton31).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                // boton1=2;
                findViewById(R.id.boton31).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //  boton1=3;
                    findViewById(R.id.boton31).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton1=4;
                        findViewById(R.id.boton31).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void PulsarImagen13(View view){

        if(pulsado==1){
            findViewById(R.id.button_topright).setBackgroundColor(BLUE);
            imagen13=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright).setBackgroundColor(RED);
            imagen13=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright).setBackgroundColor(GREEN);
            imagen13=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright).setBackgroundColor(YELLOW);
            imagen13=4;
        }
    }

    public void boton23(View view){
        if(pulsado==0){
            // boton2=1;
            findViewById(R.id.boton32).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                // boton2=2;
                findViewById(R.id.boton32).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //boton2=3;
                    findViewById(R.id.boton32).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton2=4;
                        findViewById(R.id.boton32).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen23(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright1).setBackgroundColor(BLUE);
            imagen23=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright1).setBackgroundColor(RED);
            imagen23=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright1).setBackgroundColor(GREEN);
            imagen23=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright1).setBackgroundColor(YELLOW);
            imagen23=4;
        }
    }

    public void boton33(View view){
        if(pulsado==0){
            // boton3=1;
            findViewById(R.id.boton33).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                //  boton3=2;
                findViewById(R.id.boton33).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //    boton3=3;
                    findViewById(R.id.boton33).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        //   boton3=4;
                        findViewById(R.id.boton33).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen33(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright2).setBackgroundColor(BLUE);
            imagen33=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright2).setBackgroundColor(RED);
            imagen33=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright2).setBackgroundColor(GREEN);
            imagen33=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright2).setBackgroundColor(YELLOW);
            imagen33=4;
        }
    }

    public void boton43(View view){
        if(pulsado==0){
            //boton4=1;
            findViewById(R.id.boton34).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                //  boton4=2;
                findViewById(R.id.boton34).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    // boton4=3;
                    findViewById(R.id.boton34).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton4=4;
                        findViewById(R.id.boton34).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen43(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright3).setBackgroundColor(BLUE);
            imagen43=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright3).setBackgroundColor(RED);
            imagen43=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright3).setBackgroundColor(GREEN);
            imagen43=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright3).setBackgroundColor(YELLOW);
            imagen43=4;
        }
    }

    public void correguir3(View view){
        int correcto=0;
        int error=0;

        if(imagen43==1){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen13==2){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen33==3){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen23==4){
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
