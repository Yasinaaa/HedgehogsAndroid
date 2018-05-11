package ru.android.hedgehogs.main.videos.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ru.android.hedgehogs.R;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 22.03.18.
 */

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.VideoViewHolder> {

    private List<VideoRO> mData;
    private ItemClickListener mItemClickListener;
    private Context mContext;

    public VideosAdapter(List<VideoRO> mData, ItemClickListener mItemClickListener) {
        this.mData = mData;
        this.mItemClickListener = mItemClickListener;
    }

    @Override
    public VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        return new VideoViewHolder(LayoutInflater.from(mContext)
                .inflate(R.layout.item_video, parent, false));
    }

    @Override
    public void onBindViewHolder(VideoViewHolder holder, int position) {
        VideoRO video = mData.get(position);
        holder.mTvTitle.setText(video.getTitle());
        //holder.mIvVideo.setImageResource(R.drawable.ex3);
        holder.mTvQuality.setText(mContext.getString(R.string.quality) + video.getQuality());
        holder.mTvOriginalSize.setText(mContext.getString(R.string.original_size) + video.getOriginalSize()
                + video.getOriginalSizeType());
        holder.mTvCurrentSize.setText(mContext.getString(R.string.current_size) + video.getCurrentSize()
                + video.getCurrentSizeType());
        /*holder.mTvTitle.setText(video.getTitle());
        if(position !=0)
            holder.mIvVideo.setImageResource(video.getImageTemp());
        holder.mTvQuality.setText(mContext.getString(R.string.quality) + video.getQuality());
        holder.mTvOriginalSize.setText(mContext.getString(R.string.original_size) + video.getOriginalSize()
        + video.getOriginalSizeType());
        holder.mTvCurrentSize.setText(mContext.getString(R.string.current_size) + video.getCurrentSize()
        + video.getCurrentSizeType());*/

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onClick(video);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.iv_video)
        ImageView mIvVideo;
        @BindView(R.id.iv_play)
        ImageView mIvPlay;
        @BindView(R.id.tv_title)
        TextView mTvTitle;
        @BindView(R.id.tv_quality)
        TextView mTvQuality;
        @BindView(R.id.tv_original_size)
        TextView mTvOriginalSize;
        @BindView(R.id.tv_current_size)
        TextView mTvCurrentSize;

        public VideoViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface ItemClickListener{
        void onClick(VideoRO video);
    }
}
