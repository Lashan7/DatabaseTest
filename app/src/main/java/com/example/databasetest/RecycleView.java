package com.example.databasetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class RecycleView extends AppCompatActivity {

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        getImageBitMaps();


        //get intent as a object of item
        Intent intent = getIntent();
        Item item = (Item)intent.getSerializableExtra("Item");
        System.out.println(item);

        Log.d("testitem",item.getName() + item.getDes());


    }

    private void getImageBitMaps(){

        mImageUrls.add("https://images.unsplash.com/photo-1494790108377-be9c29b29330?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=707b9c33066bf8808c934c8ab394dff6");
        mNames.add("Kavishka Herath");

        mImageUrls.add("https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=a72ca28288878f8404a795f39642a46f");
        mNames.add("Ashen S");

        mImageUrls.add("https://images.unsplash.com/photo-1506794778202-cad84cf45f1d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=74daec1914d1d105202bca8a310a6a71");
        mNames.add("Dimuthu Abesighe");

        mImageUrls.add("https://images.unsplash.com/photo-1544973810-7ecf787e9608?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE3Nzg0fQ");
        mNames.add("Loku Aiya");


        mImageUrls.add("https://images.unsplash.com/photo-1511485977113-f34c92461ad9?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE3Nzg0fQ");
        mNames.add("Kaveesha Gimhana");

        mImageUrls.add("https://images.unsplash.com/photo-1542131596-dea5384842c7?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE3Nzg0fQ");
        mNames.add("Thushan Isuru");


        mImageUrls.add("https://images.unsplash.com/photo-1542393881816-df51684879df?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE3Nzg0fQ");
        mNames.add("Eranda Perera");

        mImageUrls.add("https://images.unsplash.com/photo-1520810627419-35e362c5dc07?ixlib=rb-1.2.1&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&ixid=eyJhcHBfaWQiOjE3Nzg0fQ");
        mNames.add("Kasun Chamara");


        initRecycleView();
    }

    private void initRecycleView(){

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        recyclerView = findViewById(R.id.rv);

        recyclerView.setLayoutManager(linearLayoutManager);

        RecycleViewAdapter recycleViewAdapter = new RecycleViewAdapter(this,mNames,mImageUrls);

        recyclerView.setAdapter(recycleViewAdapter);
    }

}
