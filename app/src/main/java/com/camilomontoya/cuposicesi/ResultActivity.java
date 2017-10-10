package com.camilomontoya.cuposicesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextView titleToolbar;
    private TextView react;
    private String mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Bundle info = getIntent().getExtras();
        mensaje = info.getString("MESSAGE");

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setElevation(12);

        titleToolbar = (TextView) findViewById(R.id.toolbar_title);
        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);
        titleToolbar.setTextColor(getResources().getColor(R.color.colorPrimary));

        react = (TextView) findViewById(R.id.reaction);

        react.setTypeface(ControlTipografia.getInstance().getTypeSubtitle());
        react.setText(mensaje);
    }
}
