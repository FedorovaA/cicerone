package com.example.ciceroneapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {

    List<User> mUsers = new ArrayList<>();
    onClickListener mListener;

    public UserAdapter(onClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewHolder = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
        final ViewHolder viewHolder1 = new ViewHolder(viewHolder);
        viewHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = viewHolder1.getAdapterPosition();
                final User user = mUsers.get(pos);
                mListener.onClick(user.getId());
            }
        });
        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final User user= mUsers.get(position);
        holder.bind(user);
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public void setList(List<User> userList) {
        mUsers = userList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtId = itemView.findViewById(R.id.txt_id);
        }

        public void bind(User user) {
            txtId.setText(String.valueOf(user.getId()));
        }
    }

    public interface onClickListener {
        void onClick(Integer id);
    }
}
