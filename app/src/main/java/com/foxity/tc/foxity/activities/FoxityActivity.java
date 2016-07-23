package com.foxity.tc.foxity.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridView;

import com.foxity.tc.foxity.adapter.GridViewAdapter;
import com.foxity.tc.foxity.pojo.GridViewDataPojo;
import com.foxity.tc.foxity.R;

import java.util.ArrayList;

public class FoxityActivity extends AppCompatActivity {


    GridView gridView;
    GridViewAdapter gridViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        gridView = (GridView) findViewById(R.id.gridViewId);

        ArrayList<GridViewDataPojo> dataArrayList =new ArrayList<>();
        dataArrayList.add(new GridViewDataPojo(Color.BLUE,"1"));
        dataArrayList.add(new GridViewDataPojo(Color.RED,"2"));
        dataArrayList.add(new GridViewDataPojo(Color.DKGRAY,"3"));
        dataArrayList.add(new GridViewDataPojo(Color.GRAY,"4"));
        dataArrayList.add(new GridViewDataPojo(Color.GREEN,"5"));
        dataArrayList.add(new GridViewDataPojo(Color.YELLOW,"6"));
        dataArrayList.add(new GridViewDataPojo(Color.CYAN,"7"));
        dataArrayList.add(new GridViewDataPojo(Color.MAGENTA,"8"));
        dataArrayList.add(new GridViewDataPojo(Color.LTGRAY,"9"));

        gridViewAdapter = new GridViewAdapter(FoxityActivity.this,R.layout.inflate_gridview, dataArrayList);
        gridView.setAdapter(gridViewAdapter);


    }


}
