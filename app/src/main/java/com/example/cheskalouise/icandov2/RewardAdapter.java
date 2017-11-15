package com.example.cheskalouise.icandov2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by CheskaLouise on 11/15/2017.
 */

public class RewardAdapter extends RecyclerView.Adapter<RewardAdapter.RewardViewHolder> {

    ArrayList<Rewards> data;

    public RewardAdapter(ArrayList<Rewards> data) {
        this.data = data;
    }

    @Override
    public RewardAdapter.RewardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_reward, parent, false);
        return new RewardAdapter.RewardViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final RewardViewHolder holder, int position) {
        final Rewards currentReward = data.get(position);
        holder.tvReward.setText(currentReward.getTitle());
        holder.tvPoints.setText(currentReward.getPoints() + " points");

        holder.itemView.setTag(currentReward);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Rewards r = (Rewards) view.getTag();
                onItemClickListener.onItemClick(r);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class RewardViewHolder extends RecyclerView.ViewHolder {

        TextView tvReward;
        TextView tvPoints;

        public RewardViewHolder(View itemView) {
            super(itemView);
            tvReward = (TextView) itemView.findViewById(R.id.tv_reward);
            tvPoints = (TextView) itemView.findViewById(R.id.tv_points);
        }

    }

    public interface OnItemClickListener {
        public void onItemClick(Rewards r);
    }

    private RewardAdapter.OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(RewardAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
