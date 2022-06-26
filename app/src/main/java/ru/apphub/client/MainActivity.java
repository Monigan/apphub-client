package ru.apphub.client;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import ru.apphub.client.Utility.RecyclerItemClickListener;
import ru.apphub.client.adapters.AppAdapter;
import ru.apphub.client.model.Application;

public class MainActivity extends AppCompatActivity {

    private AppAdapter adapter = new AppAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = findViewById(R.id.list);

        LinearLayoutManager linearLayout
                = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayout);

        adapter.setPersons(testApps());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "Hello short", Toast.LENGTH_LONG).show();
                        //TODO сделать переход на фрагмент с страничкой приложения
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        Toast.makeText(MainActivity.this, "Hello long", Toast.LENGTH_LONG).show();
                        //TODO сделать открытие контекстного меню
                    }
                })
        );
    }


    private List<Application> testApps() {
        final List<Application> result = new ArrayList<>();

        result.add(new Application(0, "app1", "descr1"));
        result.add(new Application(1, "app2", "descr2"));
        result.add(new Application(2, "app3", "descr3"));
        result.add(new Application(3, "app4", "descr4"));
        result.add(new Application(4, "app5", "descr5"));
        result.add(new Application(5, "app6", "descr6"));
        result.add(new Application(6, "app7", "descr7"));

        return result;
    }
}