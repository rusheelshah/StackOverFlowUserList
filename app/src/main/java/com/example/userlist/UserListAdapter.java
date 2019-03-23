package com.example.userlist;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<User> dataset;

    UserListAdapter(List<User> dataset) {
        this.dataset = dataset;
    }

    public static class UserListViewHolder extends RecyclerView.ViewHolder {
        TextView displayName;
        TextView bronzeCount;
        TextView silverCount;
        TextView goldCount;
        ImageView profileImage;
        ProgressBar progressBar;
        UserListViewHolder(View itemView) {
            super(itemView);
            this.displayName = itemView.findViewById(R.id.text_view);
            this.bronzeCount = itemView.findViewById(R.id.badge_bronze_value);
            this.silverCount = itemView.findViewById(R.id.badge_silver_value);
            this.goldCount = itemView.findViewById(R.id.badge_gold_value);
            this.profileImage = itemView.findViewById(R.id.image_view);
            this.progressBar = itemView.findViewById(R.id.circular_progress);
        }
    }
    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.user_list_item, viewGroup, false);
        return new UserListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        UserListViewHolder holder = (UserListViewHolder) viewHolder;
        addImageToViewHolder(holder, i);
        updateViewHolderTextViews(holder, i);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    private void updateViewHolderTextViews(UserListViewHolder holder, int position) {
        holder.displayName.setText(dataset.get(position).display_name);
        holder.bronzeCount.setText(String.valueOf(dataset.get(position).badge_counts.bronze));
        holder.silverCount.setText(String.valueOf(dataset.get(position).badge_counts.silver));
        holder.goldCount.setText(String.valueOf(dataset.get(position).badge_counts.gold));
    }

    private void addImageToViewHolder(UserListViewHolder holder, int position) {
        Glide.with(holder.profileImage.getContext())
                .load(Uri.parse(dataset.get(position).profile_image))
                .override(150, 150)
                .listener(new RequestListener<Drawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                        holder.progressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .into(holder.profileImage);
    }
}
