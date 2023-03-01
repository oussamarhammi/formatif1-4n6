package com.example.formatifparthtml;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter  extends RecyclerView.Adapter<RecycleAdapter.MyViewHolder> {
    public List<nombre> list;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView1;
        public TextView textView2;
        public TextView textView3;



        public MyViewHolder(LinearLayout v) {
            super(v);

            textView1 = v.findViewById(R.id.tew111);
            textView2 = v.findViewById(R.id.tew112);
            textView3 = v.findViewById(R.id.tew113);


        }
    }
    // Provide a suitable constructor (depends on the kind of dataset) np
    public RecycleAdapter() {
        list = new ArrayList<>();
    }

    // Create new views (invoked by the layout manager)np sauf ligne 47
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        // create a new view
        LinearLayout v = (LinearLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager) ch
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        nombre nombreList = list.get(position);
        holder.textView1.setText(Long.toString(nombreList.nombre));
        holder.textView2.setText(nombreList.description);
        holder.textView3.setText(nombreList.representation);

    }

    // renvoie la taille de la liste np
    @Override
    public int getItemCount() {
        return list.size();
    }
}
