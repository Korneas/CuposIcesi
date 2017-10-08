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

public class RegisterActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView titleToolbar;

    Typeface typeTitle, typeSubtitle, type;

    EditText name, age, model, idcar, colorCar, capacity, startPoint, availableCupos, timeStart, timeEnd;
    CheckBox fails,deviation;
    ImageButton photoProfile, photoCar;

    TextView desCar,desPhotoCar,desSecure,desCupo,aditionalInfo;

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

        register = (Button) findViewById(R.id.register);

        spinner = (Spinner) findViewById(R.id.rol);

        typeTitle = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Bold.ttf");
        typeSubtitle = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");
        type = Typeface.createFromAsset(getAssets(), "fonts/Montserrat-Regular.ttf");

        ControlTipografia.getInstance().setTypeTitle(typeTitle);
        ControlTipografia.getInstance().setTypeSubtitle(typeSubtitle);
        ControlTipografia.getInstance().setTypeMsg(type);

        toolbar.setElevation(12);

        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);
        titleToolbar.setTextColor(getResources().getColor(R.color.colorPrimary));

        name.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        age.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        model.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        idcar.setTypeface(ControlTipografia.getInstance().getTypeMsg());
        register.setTypeface(ControlTipografia.getInstance().getTypeMsg());

        name.setElevation(6);
        age.setElevation(6);
        model.setElevation(6);
        idcar.setElevation(6);

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
                        i.putExtra("ROL", spinner.getSelectedItem().toString());
                        i.putExtra("IDCAR", idcar.getText().toString());
                        startActivity(i);
                        finish();
                    }
                } else {
                    aviso("Completa todos los campos");
                }
            }
        });
    }

    private void aviso(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
