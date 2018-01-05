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

public class ParejasPescaderiaActivity extends AppCompatActivity {

    //public static  int boton1=0;
    //public static  int boton2=0;
    //public static  int boton3=0;
    //public static  int boton4=0;
    public static int pulsado=0;

    public static  int imagen12=0;
    public static  int imagen22=0;
    public static  int imagen32=0;
    public static  int imagen42=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parejas_pescaderia);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void boton12(View view){
        if(pulsado==0){
            // boton1=1;
            findViewById(R.id.boton2).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                // boton1=2;
                findViewById(R.id.boton2).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //  boton1=3;
                    findViewById(R.id.boton2).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton1=4;
                        findViewById(R.id.boton2).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen12(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright).setBackgroundColor(BLUE);
            imagen12=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright).setBackgroundColor(RED);
            imagen12=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright).setBackgroundColor(GREEN);
            imagen12=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright).setBackgroundColor(YELLOW);
            imagen12=4;
        }
    }

    public void boton22(View view){
        if(pulsado==0){
            // boton2=1;
            findViewById(R.id.boton22).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                // boton2=2;
                findViewById(R.id.boton22).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //boton2=3;
                    findViewById(R.id.boton22).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton2=4;
                        findViewById(R.id.boton22).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen22(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright1).setBackgroundColor(BLUE);
            imagen22=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright1).setBackgroundColor(RED);
            imagen22=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright1).setBackgroundColor(GREEN);
            imagen22=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright1).setBackgroundColor(YELLOW);
            imagen22=4;
        }
    }

    public void boton32(View view){
        if(pulsado==0){
            // boton3=1;
            findViewById(R.id.boton32).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                //  boton3=2;
                findViewById(R.id.boton32).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    //    boton3=3;
                    findViewById(R.id.boton32).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        //   boton3=4;
                        findViewById(R.id.boton32).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen32(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright22).setBackgroundColor(BLUE);
            imagen32=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright22).setBackgroundColor(RED);
            imagen32=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright22).setBackgroundColor(GREEN);
            imagen32=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright22).setBackgroundColor(YELLOW);
            imagen32=4;
        }
    }

    public void boton42(View view){
        if(pulsado==0){
            //boton4=1;
            findViewById(R.id.boton42).setBackgroundColor(BLUE);
            pulsado++;
        }
        else{
            if(pulsado==1){
                //  boton4=2;
                findViewById(R.id.boton42).setBackgroundColor(RED);
                pulsado++;
            }
            else{
                if(pulsado==2){
                    // boton4=3;
                    findViewById(R.id.boton42).setBackgroundColor(GREEN);
                    pulsado++;
                }else{
                    if(pulsado==3){
                        // boton4=4;
                        findViewById(R.id.boton42).setBackgroundColor(YELLOW);
                        pulsado++;
                    }
                }
            }
        }
    }

    public void pulsarImagen42(View view){
        if(pulsado==1){
            findViewById(R.id.button_topright32).setBackgroundColor(BLUE);
            imagen42=1;
        }
        else
        if(pulsado==2){
            findViewById(R.id.button_topright32).setBackgroundColor(RED);
            imagen42=2;
        }
        else
        if(pulsado==3){
            findViewById(R.id.button_topright32).setBackgroundColor(GREEN);
            imagen42=3;
        }
        else
        if(pulsado==4){
            findViewById(R.id.button_topright32).setBackgroundColor(YELLOW);
            imagen42=4;
        }
    }

    public void correguir2(View view){
        int correcto=0;
        int error=0;

        if(imagen22==1){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen42==2){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen32==3){
            correcto++;
        }
        else{
            error++;
        }

        if(imagen22==4){
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
