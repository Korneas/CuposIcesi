package com.camilomontoya.cuposicesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.TextView;

public class PrivateActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView titleToolbar;

    TextView namePriv, agePriv, modelPriv, rolPriv, idcarPriv, colorCarPriv, capacityPriv, startPointPriv, avCuposPriv, timeStartPriv, timeEndPriv;
    CheckedTextView deviationPriv, failsPriv;
    Button test;

    String nameOrg, ageOrg, rolOrg, modelOrg, avCupos, capacty, idcarOrg, colorCar, startPoint, timeStart, timeEnd;
    boolean deviation, fails;

    TextView datosCar,datosCupo,addInfo;

    ProgressBar progressBar;
    Switch sAge, sModel, sRol, sIdcar, sCar, sProfile, sColorCar, sCapcty, sInsurance, sPoint, sCupos, sTimeStart, sTimeEnd, sDev, sFail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_private);

        Bundle info = getIntent().getExtras();
        nameOrg = info.getString("NAME");
        ageOrg = info.getString("AGE");
        modelOrg = info.getString("EXPERIENCE")+" de experiencia";
        if (!info.getString("IDCAR").contains("-")) {
            String placaLetras = info.getString("IDCAR").substring(0, 3);
            String placaNum = info.getString("IDCAR").substring(3);
            idcarOrg = placaLetras.toUpperCase() + "-" + placaNum;
        } else {
            String placaLetras = info.getString("IDCAR").split("-")[0];
            String placaNum = info.getString("IDCAR").split("-")[1];
            idcarOrg = placaLetras.toUpperCase() + "-" + placaNum;
        }
        rolOrg = info.getString("ROL");
        capacty = info.getString("CAPACITY") + " personas";
        colorCar = info.getString("COLORCAR");
        startPoint = info.getString("STARTPOINT");
        avCupos = info.getString("AVCUPOS") + " cupos";
        timeStart = info.getString("TIMESTART");
        timeEnd = info.getString("TIMEEND");

        deviation = info.getBoolean("DEVIATION");
        fails = info.getBoolean("FAILS");

        toolbar = (Toolbar) findViewById(R.id.toolbarPriv);
        titleToolbar = (TextView) toolbar.findViewById(R.id.toolbar_titlePriv);

        toolbar.setElevation(12);

        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);
        titleToolbar.setTextColor(getResources().getColor(R.color.colorPrimary));

        namePriv = (TextView) findViewById(R.id.nombrePriv);
        agePriv = (TextView) findViewById(R.id.edadPriv);
        modelPriv = (TextView) findViewById(R.id.modeloPriv);
        rolPriv = (TextView) findViewById(R.id.rolPriv);
        idcarPriv = (TextView) findViewById(R.id.placaPriv);
        colorCarPriv = (TextView) findViewById(R.id.colorCarPriv);
        capacityPriv = (TextView) findViewById(R.id.capacityPriv);
        startPointPriv = (TextView) findViewById(R.id.startPointPriv);
        avCuposPriv = (TextView) findViewById(R.id.availableCuposPriv);
        timeStartPriv = (TextView) findViewById(R.id.timeStartPriv);
        timeEndPriv = (TextView) findViewById(R.id.timeEndPriv);

        deviationPriv = (CheckedTextView) findViewById(R.id.deviationPriv);
        failsPriv = (CheckedTextView) findViewById(R.id.failsPriv);

        datosCar = (TextView) findViewById(R.id.carDesPriv);
        datosCupo = (TextView) findViewById(R.id.cuposDesPriv);
        addInfo = (TextView) findViewById(R.id.addInfoPriv);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        sAge = (Switch) findViewById(R.id.switchAge);
        sModel = (Switch) findViewById(R.id.switchModel);
        sIdcar = (Switch) findViewById(R.id.switchIdcar);
        sRol = (Switch) findViewById(R.id.switchRol);
        sCar = (Switch) findViewById(R.id.switchCar);
        sProfile = (Switch) findViewById(R.id.switchProfile);
        sColorCar = (Switch) findViewById(R.id.switchColorCar);
        sCapcty = (Switch) findViewById(R.id.switchCapacity);
        sInsurance = (Switch) findViewById(R.id.switchSecure);
        sPoint = (Switch) findViewById(R.id.switchPoint);
        sCupos = (Switch) findViewById(R.id.switchCupos);
        sTimeStart = (Switch) findViewById(R.id.switchTimeStart);
        sTimeEnd = (Switch) findViewById(R.id.switchTimeEnd);
        sDev = (Switch) findViewById(R.id.switchDeviation);
        sFail = (Switch) findViewById(R.id.switchFails);

        namePriv.setElevation(6);
        agePriv.setElevation(6);
        modelPriv.setElevation(6);
        rolPriv.setElevation(6);
        capacityPriv.setElevation(6);
        idcarPriv.setElevation(6);
        colorCarPriv.setElevation(6);
        startPointPriv.setElevation(6);
        avCuposPriv.setElevation(6);
        timeStartPriv.setElevation(6);
        timeEndPriv.setElevation(6);

        test = (Button) findViewById(R.id.testing);

        namePriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        agePriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        modelPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        rolPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        capacityPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        idcarPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        colorCarPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        startPointPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        timeStartPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        timeEndPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        test.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        deviationPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        failsPriv.setTypeface(ControlTipografia.getInstance().getTypeMsg());

        datosCar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        datosCupo.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        addInfo.setTypeface(ControlTipografia.getInstance().getTypeTitle());

        namePriv.setText(nameOrg);
        agePriv.setText(ageOrg);
        modelPriv.setText(modelOrg);
        rolPriv.setText(rolOrg);
        capacityPriv.setText(capacty);
        idcarPriv.setText(idcarOrg);
        colorCarPriv.setText(colorCar);
        startPointPriv.setText(startPoint);
        avCuposPriv.setText(avCupos);
        timeStartPriv.setText(timeStart);
        timeEndPriv.setText(timeEnd);

        if (deviation) {
            deviationPriv.setChecked(true);
            deviationPriv.setCheckMarkDrawable(getResources().getDrawable(android.R.drawable.presence_online));
        }

        if (fails) {
            failsPriv.setChecked(true);
            failsPriv.setCheckMarkDrawable(getResources().getDrawable(android.R.drawable.presence_online));
        }

        progressBar.setProgress(96);

        sProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sProfile.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 79);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 79);
                }
            }
        });

        sAge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sAge.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 20);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 20);
                }
            }
        });

        sModel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sModel.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 36);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 36);
                }
            }
        });

        sRol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sRol.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 46);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 46);
                }
            }
        });

        sColorCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sColorCar.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 49);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 49);
                }
            }
        });

        sIdcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sIdcar.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 102);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 102);
                }
            }
        });

        sCapcty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sCapcty.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 26);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 26);
                }
            }
        });

        sCar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sCar.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 63);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 63);
                }
            }
        });

        sInsurance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sInsurance.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 59);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 59);
                }
            }
        });

        sPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sPoint.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 69);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 69);
                }
            }
        });

        sCupos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sCupos.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 72);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 72);
                }
            }
        });

        sTimeStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sTimeStart.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 96);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 96);
                }
            }
        });

        sTimeEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sTimeEnd.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 82);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 82);
                }
            }
        });

        sDev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sDev.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 72);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 72);
                }
            }
        });

        sFail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sFail.isChecked()) {
                    progressBar.setProgress(progressBar.getProgress() + 33);
                } else {
                    progressBar.setProgress(progressBar.getProgress() - 33);
                }
            }
        });
    }
}
