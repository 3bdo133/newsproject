package com.example.abdelrahmanhesham.news;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Abdelrahman Hesham on 3/8/2018.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private ArrayList<New> news;
    private NewsAdapter.OnItemClick onItemClick;

    public NewsAdapter(ArrayList<New> news, NewsAdapter.OnItemClick onItemClick) {
        this.news = news;
        this.onItemClick = onItemClick;
    }



    @Override
    public NewsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item,null);
        NewsAdapter.ViewHolder holder=new NewsAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsAdapter.ViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return news.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView title;
        TextView description;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            description = itemView.findViewById(R.id.description);
            itemView.setOnClickListener(this);
        }
        public void bind(int position){
            title.setText(news.get(position).getTitle());
            description.setText(news.get(position).getDescription());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onItemClick.setOnItemClick(position);
        }
    }

    public interface OnItemClick {
        void setOnItemClick(int position);
    }

}

