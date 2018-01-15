package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import es.ehu.tta.appetc.R;

public class DiccionarioCarniceriaActivity extends AppCompatActivity {

    private String producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario_carniceria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void reproducir(View view){

        switch (view.getId()){
            case R.id.boton1castC:
                producto="https://www.dl.dropboxusercontent.com/s/oq1sqshz2t96sai/solomillo.wav";
                showAudio(producto);
                break;
            case R.id.boton1euskC:
                producto="https://www.dl.dropboxusercontent.com/s/ig7q3g1x1561ito/azpizuna.wav";
                showAudio(producto);
                break;
            case R.id.boton2castC:
                producto="https://www.dl.dropboxusercontent.com/s/kn62bexizaorrm9/cordero.wav";
                showAudio(producto);
                break;
            case R.id.boton2euskC:
                producto="https://www.dl.dropboxusercontent.com/s/runp02pdnv2b8es/bildotsa.wav";
                showAudio(producto);
                break;
            case R.id.boton3castC:
                producto="https://www.dl.dropboxusercontent.com/s/devwsw9q3vr08q4/espaldilla.wav";
                showAudio(producto);
                break;
            case R.id.boton3euskC:
                producto="https://www.dl.dropboxusercontent.com/s/nfgfhyas0nyy31q/bizkarkia.wav";
                showAudio(producto);
                break;
            case R.id.boton4castC:
                producto="https://www.dl.dropboxusercontent.com/s/njk7dj9073udjlp/higado.wav";
                showAudio(producto);
                break;
            case R.id.boton4euskC:
                producto="https://www.dl.dropboxusercontent.com/s/ufi8z68mawjob2u/gibela.wav";
                showAudio(producto);
                break;
            case R.id.boton5castC:
                producto="https://www.dl.dropboxusercontent.com/s/bo73jbiq3j7cgq0/carnepicada.wav";
                showAudio(producto);
                break;
            case R.id.boton5euskC:
                producto="https://www.dl.dropboxusercontent.com/s/o9ztrltqywptbq8/haragitxikitua.wav";
                showAudio(producto);
                break;
            case R.id.boton6castC:
                producto="https://www.dl.dropboxusercontent.com/s/https://www.dropbox.com/s/343lespne1jshl7/filete.wav";
                showAudio(producto);
                break;
            case R.id.boton6euskC:
                producto="https://www.dl.dropboxusercontent.com/s/36w9crbf2j0dbyd/haragixerra.wav";
                showAudio(producto);
                break;
            case R.id.boton7castC:
                producto="https://www.dl.dropboxusercontent.com/s/https://www.dropbox.com/s/lduvgvhoivzrs05/beicon.wav";
                showAudio(producto);
                break;
            case R.id.boton7euskC:
                producto="https://www.dl.dropboxusercontent.com/s/59hbqj9c63pqcgi/hirugiharra.wav";
                showAudio(producto);
                break;
            case R.id.boton8castC:
                producto="https://www.dl.dropboxusercontent.com/s/i24kf5ecy0tarvz/lengua.wav";
                showAudio(producto);
                break;
            case R.id.boton8euskC:
                producto="https://www.dl.dropboxusercontent.com/s/ft5x628b0hzglwi/mihia.wav";
                showAudio(producto);
                break;
            case R.id.boton9castC:
                producto="https://www.dl.dropboxusercontent.com/s/unbikgn3t9dqnb3/morcilla.wav";
                showAudio(producto);
                break;
            case R.id.boton9euskC:
                producto="https://www.dl.dropboxusercontent.com/s/8d76z7o3v1ldef8/odolostea.wav";
                showAudio(producto);
                break;
        }

    }

    public void showAudio(String producto){

        View view=new View(this);
        AudioPlayer audio=new AudioPlayer(view);
        ViewGroup.LayoutParams params=new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(params);

        try{
            audio.setAudioUri(Uri.parse(producto));
        }
        catch (IOException e){
            e.printStackTrace();
        }
        ViewGroup layout=(ViewGroup)findViewById(R.id.diccionarioCarniceria);
        layout.addView(view);
        audio.start();
    }
}
