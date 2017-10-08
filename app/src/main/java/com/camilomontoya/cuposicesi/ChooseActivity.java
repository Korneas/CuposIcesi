package com.camilomontoya.cuposicesi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ChooseActivity extends AppCompatActivity {

    ToggleButton pasajero,conductor;
    Button continuar;

    TextView subtitle,subConductor, subPasajero;

    Typeface typeTitle, typeSubtitle, type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose);

        pasajero = (ToggleButton) findViewById(R.id.pasajero);
        conductor = (ToggleButton) findViewById(R.id.conductor);

        continuar = (Button) findViewById(R.id.continuar);

        subConductor = (TextView) findViewById(R.id.subConductor);
        subPasajero = (TextView) findViewById(R.id.subPasajero);
        subtitle = (TextView) findViewById(R.id.usarCupos);

        typeTitle = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        typeSubtitle = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        type = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        ControlTipografia.getInstance().setTypeTitle(typeTitle);
        ControlTipografia.getInstance().setTypeSubtitle(typeSubtitle);
        ControlTipografia.getInstance().setTypeMsg(type);

        subConductor.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        subPasajero.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        subtitle.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        continuar.setTypeface(ControlTipografia.getInstance().getTypeMsg());

        pasajero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pasajero.isChecked()){
                    conductor.setChecked(false);
                }
            }
        });

        conductor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(conductor.isChecked()){
                    pasajero.setChecked(false);
                }
            }
        });

        continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(pasajero.isChecked() || conductor.isChecked()){
                    if(pasajero.isChecked()){
                        startActivity(new Intent(ChooseActivity.this,PassengerActivity.class));
                        finish();
                    } else if(conductor.isChecked()){
                        startActivity(new Intent(ChooseActivity.this,RegisterActivity.class));
                        finish();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Elige una de las spinner", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
