package com.camilomontoya.cuposicesi;

import android.app.DialogFragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PassengerActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private Toolbar toolbar;
    private TextView titleToolbar;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passenger);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setElevation(12);

        titleToolbar = (TextView) findViewById(R.id.toolbar_title);
        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);
        titleToolbar.setTextColor(getResources().getColor(R.color.colorPrimary));

        List items = new ArrayList();

        items.add(new CupoCard(R.drawable.card_cupo_0, 0));
        items.add(new CupoCard(R.drawable.card_cupo_1, 1));
        items.add(new CupoCard(R.drawable.card_cupo_2, 2));
        items.add(new CupoCard(R.drawable.card_cupo_3, 3));
        items.add(new CupoCard(R.drawable.card_cupo_4, 4));
        items.add(new CupoCard(R.drawable.card_cupo_5, 5));
        items.add(new CupoCard(R.drawable.card_cupo_6, 6));
        items.add(new CupoCard(R.drawable.card_cupo_7, 7));
        items.add(new CupoCard(R.drawable.card_cupo_8, 8));
        items.add(new CupoCard(R.drawable.card_cupo_9, 9));

        recycler = (RecyclerView) findViewById(R.id.cupos);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new CupoAdapter(items, new CupoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CupoCard item) {
                new RequestCupo().execute(item.getId());
            }
        });
        recycler.setAdapter(adapter);
    }

    private class RequestCupo extends AsyncTask<Integer, Void, Void> {

        private int ident;

        @Override
        protected void onPreExecute() {
            progress = ProgressDialog.show(PassengerActivity.this, "Pidiendo cupo...", "Esperando confirmacion");
        }

        @Override
        protected Void doInBackground(Integer... integers) {
            ident = integers[0];
            if(ident!=0 && ident!=6) {
                try {
                    Thread.currentThread();
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                progress.setCanceledOnTouchOutside(true);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            Intent intent = new Intent(PassengerActivity.this,ResultActivity.class);
            switch (ident) {
                case 1:
                    intent.putExtra("MESSAGE","Llegaste a tiempo\nPara presentar tu evaluacion\n:)");
                    break;
                case 2:
                    intent.putExtra("MESSAGE","El carro se varo en el camino\nLlegaste 20 min tarde a tu evaluacion");
                    break;
                case 3:
                    intent.putExtra("MESSAGE","El carro tuvo un accidente\nNo llegaste a tu evaluacion");
                    break;
                case 4:
                    intent.putExtra("MESSAGE","Llegaste a tiempo\nPara presentar tu evaluacion\n:)");
                    break;
                case 5:
                    intent.putExtra("MESSAGE","Llegaste a tiempo\nPara presentar tu evaluacion\n:)");
                    break;
                case 7:
                    intent.putExtra("MESSAGE","El carro se varo en el camino\nLlegaste 20 min tarde a tu evaluacion");
                    break;
                case 8:
                    intent.putExtra("MESSAGE","El carro tuvo un accidente\nNo llegaste a tu evaluacion");
                    break;
                case 9:
                    intent.putExtra("MESSAGE","Llegaste a tiempo\nPara presentar tu evaluacion\n:)");
                    break;
            };

            if(ident!=0 && ident!=6) {
                progress.dismiss();
                startActivity(intent);
            }
        }
    }
}
