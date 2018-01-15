package es.ehu.tta.appetc.presentacion;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

import es.ehu.tta.appetc.R;

public class RegistroActivity extends AppCompatActivity {

    private Uri pictureUri;
    final int PICTURE_REQUEST_CODE=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    public void registro(View view){
        Intent intent=new Intent(this,SesionActivity.class);
        String nombre=((EditText)findViewById(R.id.nombre)).getText().toString();
        String dni=((EditText)findViewById(R.id.dni)).getText().toString();
        String edad=((EditText)findViewById(R.id.edad)).getText().toString();
        String poblacion=((EditText)findViewById(R.id.poblacion)).getText().toString();
        String lenguaMaterna=((EditText)findViewById(R.id.lenguaMaterna)).getText().toString();
        String contraseña=((EditText)findViewById(R.id.contraseña)).getText().toString();
        if(nombre.matches("")||dni.matches("")||edad.matches("")||poblacion.matches("")||lenguaMaterna.matches("")||contraseña.matches("")){
            // int edadUsuario=Integer.parseInt(edad);
            Toast.makeText(
                    this,
                    "Usuario no registrado",
                    Toast.LENGTH_SHORT
            ).show();
        }
        else
            //intent.putExtra(SesionActivity.EXTRA_LOGIN,login);
            Toast.makeText(
                    this,
                    "Usuario registrado",
                    Toast.LENGTH_SHORT
            ).show();
        startActivity(intent);

    }

    public void takePhoto(View view){

        if(!getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA)){
            Toast.makeText(this,"El dispositivo no tiene camara",Toast.LENGTH_SHORT).show();
        }
        else{
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            if(intent.resolveActivity(getPackageManager())!=null){
                File dir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                try{
                    File file=File.createTempFile("login",".jpg",dir);
                    pictureUri= Uri.fromFile(file);
                    intent.putExtra(MediaStore.EXTRA_OUTPUT,pictureUri);
                    startActivityForResult(intent,PICTURE_REQUEST_CODE);
                }
                catch (IOException e){

                }
            }
            else{
                Toast.makeText(this,"No hay ningun programa para sacer fotos",Toast.LENGTH_SHORT).show();;
            }
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(resultCode!= Activity.RESULT_OK){
            return;
        }
        switch (requestCode){
            case PICTURE_REQUEST_CODE:
                // dumpImageMetaData(pictureUri);
                break;
        }
    }


}
