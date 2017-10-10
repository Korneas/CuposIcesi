package com.camilomontoya.cuposicesi;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * Created by Camilo Montoya on 10/7/2017.
 */

public class FbCard {
    private int img;
    private int id;

    public FbCard(int img, int id) {
        this.img = img;
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public int getId() {
        return id;
    }
}
