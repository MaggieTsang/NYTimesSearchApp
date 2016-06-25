package com.codepath.nytimessearch;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Created by mbytsang on 6/20/16.
 */
public class ArticleArrayAdapter extends ArrayAdapter<Article> {

    public ArticleArrayAdapter(Context context, List<Article> articles) {
        super(context, android.R.layout.simple_list_item_1, articles);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //get data item for position
        Article article = this.getItem(position);

        //check if existing view is being reused
        //not using recycled view --> inflate layout
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.item_article_result, parent, false);
        }
        //find image view
        ImageView imageView = (ImageView) convertView.findViewById(R.id.ivImage);

        //clear recycled image from convertView from last time
        imageView.setImageResource(0);

        TextView tvTitle = (TextView) convertView.findViewById(R.id.tvTitle);

        tvTitle.setText(article.getHeadline());

        //populate thumbnail image
        //remote download image in background

        String thumbnail = article.getThumbnail();

        if (!TextUtils.isEmpty(thumbnail)) {
            Picasso.with(getContext()).load(thumbnail).into(imageView);
        } else {
            //String gif = "https://upload.wikimedia.org/wikipedia/commons/b/b1/Loading_icon.gif";
            String gif = "https://d13yacurqjgara.cloudfront.net/users/12755/screenshots/1037374/hex-loader2.gif";
            Glide.with(getContext())
                    .load(gif)
                    .into(imageView);
        }

        return convertView;
    }


}
