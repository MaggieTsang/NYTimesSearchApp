package com.codepath.nytimessearch;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mbytsang on 6/24/16.
 */
// Create the basic adapter extending from RecyclerView.Adapter
// Note that we specify the custom ViewHolder which gives us access to our views
public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ViewHolder> {

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Your holder should contain a member variable
        // for any view that will be set as you render a row
        public TextView text;
        public ImageView image;

        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each subview
        public ViewHolder(View itemView) {
            // Stores the itemView in a public final member variable that can be used
            // to access the context from any ViewHolder instance.
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.tvTitle);
            image = (ImageView) itemView.findViewById(R.id.ivImage);
        }
    }


        // Store a member variable for the contacts
        private List<Article> mContacts;
        // Store the context for easy access
        private Context mContext;

        // Pass in the contact array into the constructor
        public ArticleAdapter(Context context, List<Article> contacts) {
            mContacts = contacts;
            mContext = context;
        }

        // Easy access to the context object in the recyclerview
        private Context getContext() {
            return mContext;
        }

        // Usually involves inflating a layout from XML and returning the holder
        @Override
        public ArticleAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext();
            LayoutInflater inflater = LayoutInflater.from(context);

            // Inflate the custom layout
            View contactView = inflater.inflate(R.layout.content_search, parent, false);

            // Return a new holder instance
            ViewHolder viewHolder = new ViewHolder(contactView);
            return viewHolder;
        }

        // Involves populating data into the item through holder
        @Override
        public void onBindViewHolder(ArticleAdapter.ViewHolder viewHolder, int position) {
            // Get the data model based on position
            Article article = mContacts.get(position);

            // Set item views based on your views and data model
            TextView textView = viewHolder.text;
            textView.setText(article.getHeadline());
            ImageView image = viewHolder.image;
        }

        // Returns the total count of items in the list
        @Override
        public int getItemCount() {
            return mContacts.size();
        }

    }

