package com.foxity.tc.foxity.adapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.view.animation.Transformation;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.foxity.tc.foxity.pojo.GridViewDataPojo;
import com.foxity.tc.foxity.R;

import java.util.ArrayList;

/**
 * Created by tc on 7/23/16.
 */

public class GridViewAdapter extends ArrayAdapter<GridViewDataPojo> {

        int resourceId;
        Context context;
        ArrayList<GridViewDataPojo> dataArrayList;

        public GridViewAdapter(Context context, int resource, ArrayList<GridViewDataPojo> object) {
            super(context, resource, object);
            this.context=context;
            dataArrayList =object;
            resourceId=resource;
        }

        @Override
        public View getView(final int position, final View convertView, ViewGroup parent) {

            final ViewHolder holder;
            View row = convertView;
            if(row==null) {

                LayoutInflater inflater = (LayoutInflater) context
                        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                row = inflater.inflate(resourceId, parent, false);
                holder=new ViewHolder();
                holder.text = (TextView) row.findViewById(R.id.textViewId);
                holder.linearLayoutItem = (LinearLayout) row.findViewById(R.id.linearLayoutId);
                row.setTag(holder);
            }
            else{
                holder=(ViewHolder)row.getTag();
            }

            holder.text.setText(dataArrayList.get(position).getText());
            holder.linearLayoutItem.setBackgroundColor(dataArrayList.get(position).getColor());

            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            width = width / 4;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, width);
            holder.linearLayoutItem.setLayoutParams(params);

            holder.linearLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    final ViewPropertyAnimator viewPropertyAnimator= holder.linearLayoutItem.animate();
                    viewPropertyAnimator.setDuration(500);
                    viewPropertyAnimator.rotationY(90);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    viewPropertyAnimator.setDuration(0);
                                    viewPropertyAnimator.rotationY(-90);
                                    dataArrayList.remove(position);
                                    notifyDataSetChanged();
                                }
                            }, 500);
                }});

            return row;

            }



    class ViewHolder {
         TextView text;
         LinearLayout linearLayoutItem;
    }


}
