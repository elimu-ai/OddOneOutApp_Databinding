package com.example.root.demobind1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by root on 9/10/17.
 */

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private final List<User> users;
    private Context c;


    public UserAdapter(List<User> users,Context c) {
        this.users = users;
        this.c = c;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        
        LayoutInflater inflater = LayoutInflater.from(c);
        View statusContainer = inflater.inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(statusContainer);
    }


    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {

        holder.bind(users.get(position));
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(c, "hai", Toast.LENGTH_SHORT).show();
                User usr1 = new User("ChintanRathod", 28, "https://openclipart.org/image/90px/svg_to_png/220150/Tiere-coloured.png");
                User usr2 = new User("MaulikRathod", 25, "https://openclipart.org/image/90px/svg_to_png/232003/Winteraktiv-coloured.png");

                users.clear();
                users.add(usr1);
                users.add(usr2);
                UserAdapter.this.notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }
}


