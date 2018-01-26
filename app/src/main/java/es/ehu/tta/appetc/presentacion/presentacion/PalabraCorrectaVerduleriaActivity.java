package es.ehu.tta.appetc.presentacion.presentacion;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import es.ehu.tta.appetc.R;

public class PalabraCorrectaVerduleriaActivity extends AppCompatActivity {

    String[] answers={"Platanoa","Anana","Laranja","Banana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palabra_correcta_verduleria);

        Intent intent=getIntent();
        TextView textLogin=(TextView)findViewById(R.id.menu_login);
        textLogin.setText("Login: "+intent.getStringExtra(SesionActivity.EXTRA_LOGIN));

        RadioGroup group=(RadioGroup)findViewById(R.id.test_choices3);
        for(int i=0;i<answers.length;i++){
            RadioButton radio=new RadioButton(this);
            radio.setText(answers[i]);
            radio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    findViewById(R.id.button_send_test3).setVisibility(View.VISIBLE);
                }
            });
            group.addView(radio);
        }
    }

    public void send(View v){

        int correcto=3;

        RadioGroup group=(RadioGroup)findViewById(R.id.test_choices3);
        int choice=group.getChildCount();
        for(int i=0;i<choice;i++){
            group.getChildAt(i).setEnabled(false);
        }

        group.getChildAt(correcto).setBackgroundColor(Color.GREEN);
        int selected=group.indexOfChild(group.findViewById(group.getCheckedRadioButtonId()));

        if(selected!=correcto){
            group.getChildAt(selected).setBackgroundColor(Color.RED);
            Toast.makeText(getApplicationContext(),"¡Has fallado!",Toast.LENGTH_SHORT).show();;
        }
        else
            Toast.makeText(getApplicationContext(),"¡Correcto!",Toast.LENGTH_SHORT).show();;
    }

}
