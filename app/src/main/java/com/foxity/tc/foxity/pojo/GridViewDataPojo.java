package com.foxity.tc.foxity.pojo;

/**
 * Created by tc on 7/23/16.
 */

public class GridViewDataPojo {

    int color;
    String text;

    public GridViewDataPojo(int color, String text) {
        this.color = color;
        this.text = text;
    }


    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
