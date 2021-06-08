package com.e2group.roadsigns.Adapters;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.e2group.roadsigns.R;

import com.e2group.roadsigns.Model.CategoriesSign;

import java.util.ArrayList;
import java.util.List;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoryViewHolder> {
    private List<CategoriesSign> categoriesSigns = new ArrayList<>();
    private Context context;

    public CategoriesAdapter(Context context){
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item,parent,false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
            CategoriesSign current = categoriesSigns.get(position);
            holder.tvTextSign.setText(current.getText());
            Glide.with(holder.itemView.getContext())
                .load(Uri.parse("file:///android_asset/image/categories/" +current.getImage()))
                .into(holder.ivCategorySign);

            //file:///android_asset/icon/
            holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, DescriptionActivity.class);
//                intent.putExtra("descriptionArticle",current.getArticleText());
//                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
            return categoriesSigns.size();
    }

    public void setArticles(List<CategoriesSign> articles ){
        this.categoriesSigns = articles;
        notifyDataSetChanged();
    }

    public  class CategoryViewHolder extends RecyclerView.ViewHolder {
        public CardView cardView;
        public TextView tvTextSign;
        public ImageView ivCategorySign;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.cardViewCategory);
            tvTextSign = itemView.findViewById(R.id.tvCategory);
            ivCategorySign = itemView.findViewById(R.id.ivCategory);
        }
    }
}
