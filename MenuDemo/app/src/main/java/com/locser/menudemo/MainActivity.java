package com.locser.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.mymenu, menu);
        //Đói số 1 là nhóm
//        Đối số 2 là ID cho menuItem
//        Đối số 3 là thứ tự xuất hiện của Menu Item
//        /ĐỐi số 4 là tiêu đề cho menuItem

        int itemId = 113;
        menu.add(0,itemId,0, "Menu 1");
        itemId = 114;
        menu.add(0,itemId,1, "Menu 2");
        SubMenu sub3= menu.addSubMenu("Menu 3");
        itemId = 115;
        sub3.add(0,itemId,0, "Menu 3_1");
        itemId = 116;
        sub3.add(0,itemId,1, "Menu 3_2");
        itemId = 117;
        sub3.add(0,itemId,2, "Menu 3_3");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnxemds: {
                Toast.makeText(this,"Xem danh sasch" , Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.mnxemdslh: {
                Toast.makeText(this,"Xem danh sasch lowps hoc" , Toast.LENGTH_SHORT).show();
                return true;
            }
            case R.id.mnsuads: {
                Toast.makeText(this,"Sua danh sach" , Toast.LENGTH_SHORT).show();
                return true;
            }
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}