package com.locser.thtuan3_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnshow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnshow = findViewById(R.id.btnShow);
        registerForContextMenu(btnshow);

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menudemo, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        switch (id){
            case R.id.itemRed: {
                btnshow.setTextColor(getResources().getColor(R.color.clrred));
                break;
            }
            case R.id.itemBlue: {
                btnshow.setTextColor(getResources().getColor(R.color.clrblue));
                break;
            }
            case R.id.itemGreen: {
                btnshow.setTextColor(getResources().getColor(R.color.clrgreen));
                break;
            }
        }
        return super.onContextItemSelected(item);
    }
}