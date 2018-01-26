package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

import es.ehu.tta.appetc.R;

public class DiccionarioPescaderiaActivity extends AppCompatActivity {

    private String producto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diccionario_pescaderia);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void reproducir(View view){

        switch (view.getId()){
            case R.id.boton1castP:
                producto="https://www.dl.dropboxusercontent.com/s/ph7hsw557xpjjfp/bacalao.wav";
                showAudio(producto);
                break;
            case R.id.boton1euskP:
                producto="https://www.dl.dropboxusercontent.com/s/o3243rjpzisqnbr/bakailaoa.wav";
                showAudio(producto);
                break;
            case R.id.boton2castP:
                producto="https://www.dl.dropboxusercontent.com/s/lz323auz73ynkef/salmonete.wav";
                showAudio(producto);
                break;
            case R.id.boton2euskP:
                producto="https://www.dl.dropboxusercontent.com/s/4p7vqahtapj4npr/barbarina.wav";
                showAudio(producto);
                break;
            case R.id.boton3castP:
                producto="https://www.dl.dropboxusercontent.com/s/ghg3ajm9n7x7is3/berdel.wav";
                showAudio(producto);
                break;
            case R.id.boton3euskP:
                producto="https://www.dl.dropboxusercontent.com/s/lmo1e5naungkdi0/berdela.wav";
                showAudio(producto);
                break;
            case R.id.boton4castP:
                producto="https://www.dl.dropboxusercontent.com/s/k9x60uo2hxci3z1/besugo.wav";
                showAudio(producto);
                break;
            case R.id.boton4euskP:
                producto="https://www.dl.dropboxusercontent.com/s/snokcnzjykdxvbr/bisigua.wav";
                showAudio(producto);
                break;
            case R.id.boton5castP:
                producto="https://www.dl.dropboxusercontent.com/s/azc99gj2tkepwcd/anchoa.wav";
                showAudio(producto);
                break;
            case R.id.boton5euskP:
                producto="https://www.dl.dropboxusercontent.com/s/cqo0u5z53nxmeje/bokarta.wav";
                showAudio(producto);
                break;
            case R.id.boton6castP:
                producto="https://www.dl.dropboxusercontent.com/s/yzfhkwz7up1l5hf/rodaballo.wav";
                showAudio(producto);
                break;
            case R.id.boton6euskP:
                producto="https://www.dl.dropboxusercontent.com/s/vfxskur2ohyy9s1/erreboiloa.wav";
                showAudio(producto);
                break;
            case R.id.boton7castP:
                producto="https://www.dl.dropboxusercontent.com/s/qbbekldo4kb2oje/vieira.wav";
                showAudio(producto);
                break;
            case R.id.boton7euskP:
                producto="https://www.dl.dropboxusercontent.com/s/brvo514i526k4k6/erromezmazkorra.wav";
                showAudio(producto);
                break;
            case R.id.boton8castP:
                producto="https://www.dl.dropboxusercontent.com/s/apdtr0igocl7mvf/pezespada.wav";
                showAudio(producto);
                break;
            case R.id.boton8euskP:
                producto="https://www.dl.dropboxusercontent.com/s/rowztnj9lhq1p8l/ezpataarraina.wav";
                showAudio(producto);
                break;
            case R.id.boton9castP:
                producto="https://www.dl.dropboxusercontent.com/s/x7luaquxyr64gxx/bonito.wav";
                showAudio(producto);
                break;
            case R.id.boton9euskP:
                producto="https://www.dl.dropboxusercontent.com/s/c1jtluq2p2qfonx/hegaluzea.wav";
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
        ViewGroup layout=(ViewGroup)findViewById(R.id.diccionarioPescaderia);
        layout.addView(view);
        audio.start();
    }
}
