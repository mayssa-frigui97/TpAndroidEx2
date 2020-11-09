package com.example.tp1_ex2;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityConversion extends AppCompatActivity {

    private TextView moneyConverted;
    private ImageButton back;
    private ImageButton call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion);
        this.moneyConverted = (TextView) this.findViewById(R.id.moneyConverted) ;
        this.back = (ImageButton) this.findViewById(R.id.back) ;
        this.call = (ImageButton) this.findViewById(R.id.call) ;
        Double info =getIntent().getDoubleExtra("result",0);
        Double input =getIntent().getDoubleExtra("entree",0);
        this.moneyConverted.setText(info.toString());
        this.call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri telephone = Uri.parse("tel:123");
                Intent i = new Intent(Intent.ACTION_DIAL, telephone);
                startActivity(i);
            }
        });
        this.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityConversion.this, MainActivity.class);
                i.putExtra("entree",input);
                startActivity(i);
            }
        });
    }
}