package kr.ac.ssu.bon.ui;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import kr.ac.ssu.bon.R;

/**
 * Created by lk on 15. 12. 7..
 */
public class ViewHolderStory extends RecyclerView.ViewHolder {

    public ViewHolder mRecycleHolder;

    static class ViewHolder {

        public TextView mTitle;             // Recipe Name
        public NetworkImageView mImage;     // Cooking Thumbnail
        public Button mlikeButton;          // Like Button
        public Button mDonateButton;
        public TextView mContext;
    }

    public ViewHolderStory(View itemView) {
        super(itemView);
        setHolder(itemView);
    }

    private void setHolder(View itemView) {
        mRecycleHolder = new ViewHolder();
        mRecycleHolder.mTitle = (TextView) itemView.findViewById(R.id.tv_recycle_title);
        mRecycleHolder.mContext = (TextView) itemView.findViewById(R.id.tv_recycle_context);
        mRecycleHolder.mImage = (NetworkImageView) itemView.findViewById(R.id.iv_recycle_img);
        mRecycleHolder.mlikeButton = (Button) itemView.findViewById(R.id.bt_recycle_story_more);
        mRecycleHolder.mDonateButton = (Button) itemView.findViewById(R.id.bt_recycle_story_donate);
    }
}