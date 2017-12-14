package com.darveshart.app.friend;

import android.content.Context;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.lang.Object;
import java.util.List;

/**
 * Created by zamee on 12/5/2017.
 */


public class MessageListAdapter extends RecyclerView.Adapter<MessageListAdapter.MyViewHolder> {

    private List<BaseMessage> mBaseMessageList;
    private Context mContext;
    private int lastPosition = -1;
    private static TextView messageTv;


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            messageTv = view.findViewById(R.id.text_message_body);
           // imageView = (ImageView) view.findViewById(R.id.recentPhoto);

        }
    }



    public MessageListAdapter(List<BaseMessage> recentPhotoList, Context context) {
        this.mBaseMessageList = recentPhotoList;
        this.mContext = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_message_received, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
    }

    @Override
    public void onBindViewHolder( MessageListAdapter.MyViewHolder holder, int position, List<Object> payloads) {
        BaseMessage recentPhoto = mBaseMessageList.get(position);
        messageTv.setText(recentPhoto.getMessage());
        //Picasso.with(mContext).load(recentPhoto.getBitmap()).rotate(90).fit().centerInside().into(holder.imageView);
        setAnimation(holder.itemView, position);

    }

    @Override
    public int getItemCount() {
        return mBaseMessageList.size();
    }

    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition )
        {
            Animation animation = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }
    public void updateEmployeeListItems(List<BaseMessage> recentPhotoList) {
        //final MessageListDiffCall diffCallback = new MessageListDiffCall(this.mBaseMessageList, recentPhotoList);
        //final DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(diffCallback);
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new MessageListDiffCall(this.mBaseMessageList, recentPhotoList));
        diffResult.dispatchUpdatesTo(this);
        /*
        this.mBaseMessageList.removeAll(mBaseMessageList);
        this.mBaseMessageList.addAll(recentPhotoList);
        diffResult.dispatchUpdatesTo(RecentPhotoAdapter.this);*/
    }
}