package com.camilomontoya.cuposicesi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class PassengerActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private Toolbar toolbar;
    private TextView titleToolbar;

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

        items.add(new CupoCard(R.drawable.card_cupo_0));
        items.add(new CupoCard(R.drawable.card_cupo_1));
        items.add(new CupoCard(R.drawable.card_cupo_2));
        items.add(new CupoCard(R.drawable.card_cupo_3));
        items.add(new CupoCard(R.drawable.card_cupo_4));
        items.add(new CupoCard(R.drawable.card_cupo_5));
        items.add(new CupoCard(R.drawable.card_cupo_6));
        items.add(new CupoCard(R.drawable.card_cupo_7));
        items.add(new CupoCard(R.drawable.card_cupo_8));
        items.add(new CupoCard(R.drawable.card_cupo_9));

        recycler = (RecyclerView) findViewById(R.id.cupos);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new CupoAdapter(items);
        recycler.setAdapter(adapter);

        
    }
}
