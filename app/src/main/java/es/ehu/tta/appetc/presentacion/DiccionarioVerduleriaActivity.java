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

public class DiccionarioVerduleriaActivity extends AppCompatActivity {

    private String producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario_verduleria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void reproducir(View view){

        switch (view.getId()){
            case R.id.boton1castV:
                producto="https://www.dl.dropboxusercontent.com/s/i8y5xj2xonz2155/pi%C3%B1a.wav";
                showAudio(producto);
                break;
            case R.id.boton1euskV:
                producto="https://www.dl.dropboxusercontent.com/s/8apucev9fpuwxh7/anana.wav";
                showAudio(producto);
                break;
            case R.id.boton2castV:
                producto="https://www.dl.dropboxusercontent.com/s/kme7vffsmim8w70/albaricoque.wav";
                showAudio(producto);
                break;
            case R.id.boton2euskV:
                producto="https://www.dl.dropboxusercontent.com/s/7i6b3rpmtatgq62/arbeletxekoa.wav";
                showAudio(producto);
                break;
            case R.id.boton3castV:
                producto="https://www.dl.dropboxusercontent.com/s/6aetkukdtgqaebe/coliflor.wav";
                showAudio(producto);
                break;
            case R.id.boton3euskV:
                producto="https://www.dl.dropboxusercontent.com/s/hv5eflmciyto7ws/azalorea.wav";
                showAudio(producto);
                break;
            case R.id.boton4castV:
                producto="https://www.dl.dropboxusercontent.com/s/vp70cz3h1197j9n/zanahoria.wav";
                showAudio(producto);
                break;
            case R.id.boton4euskV:
                producto="https://www.dl.dropboxusercontent.com/s/gkgx4q48rqql17q/azenarioa.wav";
                showAudio(producto);
                break;
            case R.id.boton5castV:
                producto="https://www.dl.dropboxusercontent.com/s/m7idz088dj1xf9d/platano.wav";
                showAudio(producto);
                break;
            case R.id.boton5euskV:
                producto="https://www.dl.dropboxusercontent.com/s/b030dlsinozhb6i/banana.wav";
                showAudio(producto);
                break;
            case R.id.boton6castV:
                producto="https://www.dl.dropboxusercontent.com/s/13fxif7p9pr7nou/acelga.wav";
                showAudio(producto);
                break;
            case R.id.boton6euskV:
                producto="https://www.dl.dropboxusercontent.com/s/tjpbpcj0hmeplvn/beleta.wav";
                showAudio(producto);
                break;
            case R.id.boton7castV:
                producto="https://www.dl.dropboxusercontent.com/s/jvglm76gqh6lkv1/ajo.wav";
                showAudio(producto);
                break;
            case R.id.boton7euskV:
                producto="https://www.dl.dropboxusercontent.com/s/pky8bvi44octmth/berakatxa.wav";
                showAudio(producto);
                break;
            case R.id.boton8castV:
                producto="https://www.dl.dropboxusercontent.com/s/osau7onfdpukie4/brocoloi.wav";
                showAudio(producto);
                break;
            case R.id.boton8euskV:
                producto="https://www.dl.dropboxusercontent.com/s/t54p1t4rg3wbn94/brokolia.wav";
                showAudio(producto);
                break;
            case R.id.boton9castV:
                producto="https://www.dl.dropboxusercontent.com/s/9ksidg8toxqbe71/lenteja.wav";
                showAudio(producto);
                break;
            case R.id.boton9euskV:
                producto="https://www.dl.dropboxusercontent.com/s/iwoh1sgnz2mz5uf/dilista.wav";
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
        ViewGroup layout=(ViewGroup)findViewById(R.id.diccionarioVerduleria);
        layout.addView(view);
        audio.start();
    }
}
