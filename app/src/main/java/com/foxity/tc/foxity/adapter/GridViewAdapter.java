package com.foxity.tc.foxity.adapter;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.foxity.tc.foxity.pojo.GridViewDataPojo;
import com.foxity.tc.foxity.R;

import java.util.ArrayList;

/**
 * Created by tc on 7/23/16.
 */

public class GridViewAdapter extends ArrayAdapter<GridViewDataPojo> {

        int resourceId;
        Context context;
        AnimatorSet set ;
        ArrayList<GridViewDataPojo> dataArrayList;

        public GridViewAdapter(Context context, int resource, ArrayList<GridViewDataPojo> object) {
            super(context, resource, object);
            this.context=context;
            dataArrayList =object;
            resourceId=resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {

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
            }else{
                holder=(ViewHolder)row.getTag();
            }


            holder.text.setText(dataArrayList.get(position).getText());
            holder.linearLayoutItem.setBackgroundColor(dataArrayList.get(position).getColor());


            Animation rotateAnim = AnimationUtils.loadAnimation(context, R.anim.rotate);
            LayoutAnimationController animController = new LayoutAnimationController(rotateAnim, 0);
            holder.linearLayoutItem.setLayoutAnimation(animController);

            Display display = ((Activity)context).getWindowManager().getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            int width = size.x;
            width = width / 3;
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, width);
            holder.linearLayoutItem.setLayoutParams(params);

            holder.linearLayoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    set = (AnimatorSet) AnimatorInflater.loadAnimator(context,R.animator.flip);
                    set.setTarget(holder.linearLayoutItem);
                    set.start();
                    set.addListener(new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animator) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animator) {
                            dataArrayList.remove(position);
                            notifyDataSetChanged();
                        }

                        @Override
                        public void onAnimationCancel(Animator animator) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animator) {

                        }
                    });


                }});


            return row;
            }

    class ViewHolder {
         TextView text;
         LinearLayout linearLayoutItem;
    }

}
