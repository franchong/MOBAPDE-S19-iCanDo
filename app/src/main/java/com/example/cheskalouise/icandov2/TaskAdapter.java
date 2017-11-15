package com.example.cheskalouise.icandov2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Asus PC on 11/13/2017.
 */

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskViewHolder> {

    ArrayList<Tasks> data;

    public TaskAdapter(ArrayList<Tasks> data) {
        this.data = data;
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new TaskViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final TaskViewHolder holder, int position) {
        final Tasks currentTask = data.get(position);
        holder.tvTask.setText(currentTask.getTitle());
        holder.tvDue.setText(currentTask.getDueDate() + " " + currentTask.getDay());

        holder.itemView.setTag(currentTask);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tasks t = (Tasks) view.getTag();
                onItemClickListener.onItemClick(t);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder {

        TextView tvTask;
        TextView tvDue;

        public TaskViewHolder(View itemView) {
            super(itemView);
            tvTask = (TextView) itemView.findViewById(R.id.tv_task);
            tvDue = (TextView) itemView.findViewById(R.id.tv_due);
        }

    }

    public interface OnItemClickListener {
        public void onItemClick(Tasks t);
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
