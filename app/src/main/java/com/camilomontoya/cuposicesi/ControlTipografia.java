package com.camilomontoya.cuposicesi;

import android.graphics.Typeface;

/**
 * Created by CamiloMontoya on 4/10/17.
 */

public class ControlTipografia {
    public static ControlTipografia ref;

    Typeface typeTitle;
    Typeface typeSubtitle;
    Typeface typeMsg;

    private ControlTipografia(){

    }

    public static ControlTipografia getInstance(){
        if(ref==null){
            ref = new ControlTipografia();
        }
        return ref;
    }

    public Typeface getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(Typeface typeTitle) {
        this.typeTitle = typeTitle;
    }

    public Typeface getTypeSubtitle() {
        return typeSubtitle;
    }

    public void setTypeSubtitle(Typeface typeSubtitle) {
        this.typeSubtitle = typeSubtitle;
    }

    public Typeface getTypeMsg() {
        return typeMsg;
    }

    public void setTypeMsg(Typeface typeMsg) {
        this.typeMsg = typeMsg;
    }
}
