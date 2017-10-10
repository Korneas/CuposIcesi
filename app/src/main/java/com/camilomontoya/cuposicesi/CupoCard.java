package com.camilomontoya.cuposicesi;

import android.app.ProgressDialog;
import android.os.AsyncTask;

/**
 * Created by Camilo Montoya on 10/7/2017.
 */

public class CupoCard {
    private int img;
    private int id;

    public CupoCard(int img, int id) {
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
