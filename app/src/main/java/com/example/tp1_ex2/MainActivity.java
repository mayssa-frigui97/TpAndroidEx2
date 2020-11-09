package com.example.tp1_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button bconvert;
    private EditText eEntry;
    private TextView titre;
    private RadioButton EuroDinar;
    private RadioButton DinarEuro;
    public static final int REQUEST_CODE=1;
    public static final int RESULT_OK=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.titre = (TextView) this.findViewById(R.id.titre) ;
        this.bconvert = (Button) this.findViewById(R.id.bconvert) ;
        this.eEntry = (EditText) this.findViewById(R.id.e_entry) ;
        this.EuroDinar = (RadioButton) this.findViewById(R.id.EuroDinar) ;
        this.DinarEuro = (RadioButton) this.findViewById(R.id.DinarEuro) ;
        Double info =getIntent().getDoubleExtra("entree",0);
        this.eEntry.setText(info.toString());
        this.bconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Le premier paramètre est le nom de l'activité actuelle
                // Le second est le nom de l'activité de destination
                Intent i = new Intent(MainActivity.this, ActivityConversion.class);
                double result=convert(v);
                double entree=Integer.parseInt(eEntry.getText().toString());
                i.putExtra("result",result);
                i.putExtra("entree",entree);
                //startActivityForResult(i,REQUEST_CODE);
                startActivity(i);
            }
        });
    }
    /*@Override
    protected void onActivityResult(int requestCode,int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if(requestCode == REQUEST_CODE){
            if(resultCode == RESULT_OK){
                Toast.makeText(this,"entree ="+intent.getIntExtra("entree",0),Toast.LENGTH_LONG).show();
            }
        }
    }*/

    public double convert(View v){
        double result=0;
        double moneyToConvert =Integer.parseInt(eEntry.getText().toString());
        if (DinarEuro.isChecked() ){
            result=moneyToConvert/3.26;
        }
        else if (EuroDinar.isChecked() ){
            result=moneyToConvert*3.26;
        }
        return(result);
    }
}