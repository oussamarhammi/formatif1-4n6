package com.example.formatifparthtml;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.formatifparthtml.databinding.ActivityMainBinding;
import com.example.formatifparthtml.htttp.RetroUtil;
import com.example.formatifparthtml.htttp.Service;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    RecycleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);


        binding.button.setOnClickListener(view3 -> {
            {

                this.initRecycler1();
                this.remplirRecycler1();
            }
        });
    }



    private void remplirRecycler1() {
        Service service = RetroUtil.get();

        service.listRepos(Integer.parseInt(binding.editText1.getText().toString())).enqueue(new Callback<List<nombre>>() {
            @Override
            public void onResponse(Call<List<nombre>> call, Response<List<nombre>> response) {
                if (response.isSuccessful()) {
                    List<nombre> x1 = response.body();
                    adapter.list.addAll(x1);
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<nombre>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "testeRE", Toast.LENGTH_SHORT).show();
            }

        });
    }
    private void initRecycler1() {
        RecyclerView recyclerView1 = findViewById(R.id.recycleView);


        recyclerView1.setHasFixedSize(true);
        recyclerView1.addItemDecoration(new DividerItemDecoration(recyclerView1.getContext(), DividerItemDecoration.VERTICAL));

        // use a linear layout manager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView1.setLayoutManager(layoutManager);

        // specify an adapter (see also next example)
        adapter = new RecycleAdapter();
        recyclerView1.setAdapter(adapter);
    }


}