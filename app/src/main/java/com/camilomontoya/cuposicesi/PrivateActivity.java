package com.camilomontoya.cuposicesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PrivateActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView titleToolbar;

    TextView namePriv,agePriv,modelPriv,idcarPriv;
    Button test;

    String nameOrg,ageOrg,modelOrg,idcarOrg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);

        Bundle info = getIntent().getExtras();
        nameOrg = info.getString("NAME");
        ageOrg = info.getString("AGE");
        modelOrg = info.getString("MODEL");
        if(!info.getString("IDCAR").contains("-")) {
            String placaLetras = info.getString("IDCAR").substring(0, 3);
            String placaNum = info.getString("IDCAR").substring(3);
            idcarOrg = placaLetras.toUpperCase() + "-" + placaNum;
        } else {
            String placaLetras = info.getString("IDCAR").split("-")[0];
            String placaNum = info.getString("IDCAR").split("-")[1];
            idcarOrg = placaLetras.toUpperCase() + "-" + placaNum;
        }

        toolbar = (Toolbar) findViewById(R.id.toolbarPriv);
        titleToolbar = (TextView) toolbar.findViewById(R.id.toolbar_titlePriv);

        toolbar.setElevation(12);

        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);
        titleToolbar.setTextColor(getResources().getColor(R.color.colorPrimary));

        namePriv = (TextView) findViewById(R.id.nombrePriv);
        agePriv = (TextView) findViewById(R.id.edadPriv);
        modelPriv = (TextView) findViewById(R.id.modeloPriv);
        idcarPriv = (TextView) findViewById(R.id.placaPriv);

        namePriv.setElevation(6);
        agePriv.setElevation(6);
        modelPriv.setElevation(6);
        idcarPriv.setElevation(6);

        test = (Button) findViewById(R.id.testPriv);

        namePriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        agePriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        modelPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        idcarPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());

        namePriv.setText(nameOrg);
        agePriv.setText(ageOrg);
        modelPriv.setText(modelOrg);
        idcarPriv.setText(idcarOrg);
    }
}