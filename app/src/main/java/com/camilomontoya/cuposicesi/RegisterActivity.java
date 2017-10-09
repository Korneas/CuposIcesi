package com.camilomontoya.cuposicesi;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ResourceBundle;

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView titleToolbar;

    EditText name, age, model, idcar, colorCar, capacity, startPoint, availableCupos, timeStart, timeEnd;
    CheckBox fails,deviation;
    ImageButton photoProfile, photoCar;

    TextView desCar,desCupo,aditionalInfo;

    Button register;

    Spinner spinner;
    String[] items = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        titleToolbar = (TextView) toolbar.findViewById(R.id.toolbar_title);

        name = (EditText) findViewById(R.id.nombre);
        age = (EditText) findViewById(R.id.edad);
        model = (EditText) findViewById(R.id.tiempoConducido);
        idcar = (EditText) findViewById(R.id.placa);
        colorCar = (EditText) findViewById(R.id.colorCar);
        capacity = (EditText) findViewById(R.id.capacity);
        startPoint = (EditText) findViewById(R.id.partida);
        availableCupos = (EditText) findViewById(R.id.availableCupos);
        timeStart = (EditText) findViewById(R.id.timeStart);
        timeEnd = (EditText) findViewById(R.id.timeEnd);

        fails = (CheckBox) findViewById(R.id.fallos);
        deviation = (CheckBox) findViewById(R.id.desvios);

        photoProfile = (ImageButton) findViewById(R.id.fotoPerfil);
        photoCar = (ImageButton) findViewById(R.id.fotoAuto);

        desCar = (TextView) findViewById(R.id.carDescription);
        desCupo = (TextView) findViewById(R.id.cuposDes);
        aditionalInfo = (TextView) findViewById(R.id.disposicion);

        register = (Button) findViewById(R.id.register);

        spinner = (Spinner) findViewById(R.id.rol);

        toolbar.setElevation(12);

        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);
        titleToolbar.setTextColor(getResources().getColor(R.color.colorPrimary));

        name.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        age.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        model.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        idcar.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        register.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        colorCar.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        capacity.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        startPoint.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        availableCupos.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        timeStart.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        timeEnd.setTypeface(ControlTipografia.getInstance().getTypeMsg());

        fails.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        deviation.setTypeface(ControlTipografia.getInstance().getTypeMsg());

        desCar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        desCupo.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        aditionalInfo.setTypeface(ControlTipografia.getInstance().getTypeTitle());

        desCar.setTextSize(18);
        desCupo.setTextSize(18);
        aditionalInfo.setTextSize(18);

        name.setElevation(6);
        age.setElevation(6);
        model.setElevation(6);
        idcar.setElevation(6);
        colorCar.setElevation(6);
        capacity.setElevation(6);
        startPoint.setElevation(6);
        availableCupos.setElevation(6);
        timeStart.setElevation(6);
        timeEnd.setElevation(6);

        fails.setElevation(6);
        deviation.setElevation(6);

        photoProfile.setElevation(6);
        photoCar.setElevation(6);

        items[0] = "- Selecciona un rol -";
        items[1] = "Estudiante";
        items[2] = "Profesor";
        items[3] = "Personal administrativo";

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items) {
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                ((TextView) v).setTypeface(ControlTipografia.getInstance().getTypeMsg());

                return v;
            }

            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View v = super.getDropDownView(position, convertView, parent);

                ((TextView) v).setTypeface(ControlTipografia.getInstance().getTypeMsg());

                return v;
            }
        };

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setElevation(6);
        spinner.setAdapter(adapter);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!name.getText().toString().isEmpty() && !age.getText().toString().isEmpty() &&
                        !idcar.getText().toString().isEmpty()) {
                    if (!name.getText().toString().contains(" ")) {
                        aviso("El nombre debe estar con apellidos");
                        return;
                    } else if (Integer.parseInt(age.getText().toString()) < 18) {
                        aviso("Debes ser mayor de edad para registrarte");
                        return;
                    } else if (spinner.getSelectedItem().toString().contains("rol")) {
                        aviso("Selecciona un rol");
                    } else if (!(idcar.getText().toString().length() == 6)) {
                        aviso("Escribe la placa con 3 letras y 3 numeros");
                        return;
                    } else {
                        Intent i = new Intent(RegisterActivity.this, PrivateActivity.class);
                        i.putExtra("NAME", name.getText().toString());
                        i.putExtra("AGE", age.getText().toString());
                        i.putExtra("EXPERIENCE", model.getText().toString());
                        i.putExtra("ROL", spinner.getSelectedItem().toString());
                        i.putExtra("IDCAR", idcar.getText().toString());
                        i.putExtra("COLORCAR", colorCar.getText().toString());
                        i.putExtra("CAPACITY", capacity.getText().toString());
                        i.putExtra("STARTPOINT", startPoint.getText().toString());
                        i.putExtra("AVCUPOS", availableCupos.getText().toString());
                        i.putExtra("TIMESTART", timeStart.getText().toString());
                        i.putExtra("TIMEEND", timeEnd.getText().toString());
                        i.putExtra("DEVIATION", deviation.isChecked());
                        i.putExtra("FAILS", fails.isChecked());
                        startActivity(i);
                        finish();
                    }
                } else {
                    aviso("Completa todos los campos");
                }
                /*startActivity(new Intent(RegisterActivity.this, PrivateActivity.class));
                finish();*/
            }
        });
    }

    private void aviso(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
