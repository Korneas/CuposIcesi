package com.camilomontoya.cuposicesi;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class FacebookActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager lManager;

    private Toolbar toolbar;
    private TextView titleToolbar;

    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setElevation(12);

        titleToolbar = (TextView) findViewById(R.id.toolbar_title);
        titleToolbar.setTypeface(ControlTipografia.getInstance().getTypeTitle());
        titleToolbar.setTextSize(20);

        List items = new ArrayList();

        items.add(new FbCard(R.drawable.facebook_0, 0));
        items.add(new FbCard(R.drawable.facebook_1, 1));
        items.add(new FbCard(R.drawable.facebook_2, 2));
        items.add(new FbCard(R.drawable.facebook_3, 3));
        items.add(new FbCard(R.drawable.facebook_4, 4));
        items.add(new FbCard(R.drawable.facebook_5, 5));
        items.add(new FbCard(R.drawable.facebook_6, 6));
        items.add(new FbCard(R.drawable.facebook_7, 7));
        items.add(new FbCard(R.drawable.facebook_8, 8));
        items.add(new FbCard(R.drawable.facebook_9, 9));
        items.add(new FbCard(R.drawable.facebook_10, 9));
        items.add(new FbCard(R.drawable.facebook_11, 9));
        items.add(new FbCard(R.drawable.facebook_12, 9));

        recycler = (RecyclerView) findViewById(R.id.cuposFb);
        recycler.setHasFixedSize(true);

        lManager = new LinearLayoutManager(this);
        recycler.setLayoutManager(lManager);

        adapter = new FbAdapter(items, new FbAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(FbCard item) {
                aviso("Sugeee");
            }
        });
        recycler.setAdapter(adapter);
    }

    private void aviso(String text) {
        Toast.makeText(getApplicationContext(), text, Toast.LENGTH_LONG).show();
    }
}
