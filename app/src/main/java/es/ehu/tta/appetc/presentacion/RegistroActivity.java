package es.ehu.tta.appetc.presentacion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class RegistroActivity extends AppCompatActivity {

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


}
