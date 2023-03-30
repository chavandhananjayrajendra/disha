package com.example.disa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.disa.databinding.ActivityD1Binding;
import java.util.ArrayList;


public class d1 extends AppCompatActivity {
  ActivityD1Binding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityD1Binding.inflate(getLayoutInflater());

        int[] imageList = {R.drawable.finance1, R.drawable.finance2};
        int[] categoryList = {R.string.financecategory ,R.string.finance2category};
        int[] descList = {R.string.financeDesc,R.string.finance2Desc};
        int[] benefitList ={R.string.financebenefits,R.string.finance2benefits};
        int[] eligibilityList = {R.string.financeeligibility,R.string.finance2eligibility};
        String[] nameList = {"Pasta", "Maggi", "Cake", "Pancake", "Pizza","Burgers", "Fries"};

        for (int i = 0; i < imageList.length; i++){
            listData = new ListData(nameList[i],categoryList[i], descList[i],benefitList[i],imageList[i]);
            dataArrayList.add(listData);
        }
        listAdapter = new ListAdapter(d1.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(d1.this, DetailedActivity.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("category",categoryList[i]);

                intent.putExtra("description", descList[i]);
                intent.putExtra("benefit",benefitList[i]);

                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}

