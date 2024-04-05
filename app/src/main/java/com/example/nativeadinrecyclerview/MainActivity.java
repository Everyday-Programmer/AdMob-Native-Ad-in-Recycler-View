package com.example.nativeadinrecyclerview;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.rvadapter.AdmobNativeAdAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        ArrayList<Model> arrayList = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            Model model = new Model();
            model.setTitle("Title " + i);
            model.setSubTitle("Sub Title " + i);
            arrayList.add(model);
        }
        Adapter adapter = new Adapter(MainActivity.this, arrayList);

        AdmobNativeAdAdapter admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.Companion.with("ca-app-pub-3940256099942544/2247696110", adapter, "small")
                .adItemIterval(5).build();
        recyclerView.setAdapter(admobNativeAdAdapter);
    }
}