package com.example.testuxproject.homepage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testuxproject.GlobalData;
import com.example.testuxproject.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

public class Slide_adapter extends RecyclerView.Adapter<Slide_adapter.SlideViewHolder>{
    private List<Slideitem> slideItems;
    private ViewPager2 viewPager2;

    Slide_adapter(List<Slideitem> slideItems, ViewPager2 viewPager2) {
        this.slideItems = slideItems;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SlideViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SlideViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.slide_item_container, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SlideViewHolder holder, int position) {
        holder.setImage(slideItems.get(position));
        if (position == slideItems.size()-2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return slideItems.size();
    }

    class  SlideViewHolder extends RecyclerView.ViewHolder {
        private RoundedImageView imageView;
        private View v;

        SlideViewHolder(@NonNull View itemView) {
            super(itemView);
            v = itemView;
            imageView = itemView.findViewById(R.id.imageSlide);
        }

        void setImage(Slideitem slideItem) {
            imageView.setImageBitmap(GlobalData.decodeSampledBitmapFromResource(v.getResources(), slideItem.getImage(), 100, 100));
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            slideItems.addAll(slideItems);
            notifyDataSetChanged();
        }
    };
}
