package es.ehu.tta.appetc.presentacion.presentacion;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class ResponderExpresionActivity extends AppCompatActivity {

    final int AUDIO_REQUEST_CODE = 2;
    final int READ_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_expresion);

        Intent intent = getIntent();
        TextView textLogin = (TextView) findViewById(R.id.menu_login);
        textLogin.setText("Login: " + intent.getStringExtra(SesionActivity.EXTRA_LOGIN));
    }

    public void AudioRecord(View view) {

        if (!getPackageManager().hasSystemFeature(PackageManager.FEATURE_MICROPHONE)) {
            Toast.makeText(this, "El dispositivo no tiene microfono", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent(MediaStore.Audio.Media.RECORD_SOUND_ACTION);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivityForResult(intent, AUDIO_REQUEST_CODE);
            } else {
                Toast.makeText(this, "No hay ningun programa para grabar audio", Toast.LENGTH_SHORT).show();
                ;
            }
        }

    }

    public void completarExpresion(View view) {

        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("*/*");
        startActivityForResult(intent, READ_REQUEST_CODE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        switch (requestCode) {
            case READ_REQUEST_CODE:
                Uri uri = data.getData();
                //fileName=dumpMetaData(uri);
                break;
            case AUDIO_REQUEST_CODE:
                //sendFile(data.getData());
                break;
        }

    }

}
