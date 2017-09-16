package com.camilomontoya.cuposicesi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import serial.Validacion;


public class HomeActivity extends AppCompatActivity implements Observer{

    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Cliente.getInstance().setObserver(this);

        enter = (Button) findViewById(R.id.btn);

        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Cliente.getInstance().enviar(new Validacion(true,1,"Maigod"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void aviso(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * Metodo para salir de la app si se esta en el Home y no devolverlo al Log in
     */
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    /**
     * Metodo en donde se reconocen los parametros por el servidor y este le manda la respuesta de que
     * puede logearse
     * @param o
     * @param arg
     */
    @Override
    public void update(Observable o, Object arg) {

    }
}
