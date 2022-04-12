package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class AuthorActivity extends AppCompatActivity {
    DBHelper dbHelper= new DBHelper(this);
    List<Author> listAuthor = new ArrayList<>();
    ListView lv;
    List<Author> listAu;
    private GridView gv_Author;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_author);

        EditText et_id= findViewById(R.id.et_id);
        EditText et_name= findViewById(R.id.et_name);
        EditText et_email= findViewById(R.id.et_email);
        EditText et_diachi= findViewById(R.id.et_address);

//        lv= findViewById(R.id.lv);

         gv_Author=  findViewById(R.id.gridView_AuthorList);



        Button bt_save = findViewById(R.id.btn_save);
        Button bt_exit = findViewById(R.id.btn_exit);
        Button bt_select = findViewById(R.id.btn_select);
        Button bt_update = findViewById(R.id.btn_update);
        Button bt_delete = findViewById(R.id.btn_delete);
        loadListAuthor();
        bt_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author=  new Author();
                author.setId(Integer.parseInt(et_id.getText().toString()));
                author.setTen(et_name.getText().toString());
                author.setDiachi(et_diachi.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbHelper.insertAuthor(author)>0){
                    Toast.makeText(getApplicationContext(),"Bạn đã lưu thành công",Toast.LENGTH_SHORT);
                }else
                    Toast.makeText(getApplicationContext(),"Bạn đã lưu không thành công",Toast.LENGTH_SHORT);

                loadListAuthor();
            }
        });

        bt_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ArrayList<Author> list_author = new ArrayList<>();
                ArrayList<String> list_String = new ArrayList<>();
                list_String.add("Id");
                list_String.add("Name");
                list_String.add("Address");
                list_String.add("Email");
                if(et_id.getText().toString().equals("")){
                    list_author= dbHelper.getAllAuthor();
                }else {
                    Author au = dbHelper.getIdAuthor(Integer.parseInt(et_id.getText().toString()));
                    list_String.add(au.getId() + "");
                    list_String.add(au.getTen() + "");
                    list_String.add(au.getDiachi() + "");
                    list_String.add(au.getEmail() + "");
//                    ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1, list_String);
//                    gv_Author.setAdapter(adapter);
                }
                for(Author au:list_author){
                    list_String.add(au.getId()+"");
                    list_String.add(au.getTen()+"");
                    list_String.add(au.getDiachi()+"");
                    list_String.add(au.getEmail()+"");
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1,list_String);
                gv_Author.setAdapter(adapter);
            }
        });

        bt_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bt_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Author author=  new Author();
                author.setId(Integer.parseInt(et_id.getText().toString()));
                author.setTen(et_name.getText().toString());
                author.setDiachi(et_diachi.getText().toString());
                author.setEmail(et_email.getText().toString());
                if(dbHelper.updateAuthor(author)>0){
                    Toast.makeText(getApplicationContext(),"Bạn đã sửa thành công",Toast.LENGTH_SHORT);
                }else
                    Toast.makeText(getApplicationContext(),"Sửa không thành công",Toast.LENGTH_SHORT);
                loadListAuthor();
            }
        });

        bt_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(et_id.getText().toString().trim().equals("")){
                    dbHelper.deleteAllAuthors();
                    loadListAuthor();
                }else {
                    int authorId= (Integer.parseInt(et_id.getText().toString()));
                    dbHelper.deleteAuthor(authorId);
                    loadListAuthor();
                }
            }
        });
//        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if(i >=0) {
//                    et_id.setText(String.valueOf(listAu.get(i).getId()));
//                    et_name.setText((listAu.get(i).getTen()));
//                    et_diachi.setText((listAu.get(i).getDiachi()));
//                    et_email.setText((listAu.get(i).getEmail()));
//                }
//            }
//        });
    }

    public void loadListAuthor(){
        ArrayList<Author> list_author = new ArrayList<>();
        ArrayList<String> list_String = new ArrayList<>();

        list_author= dbHelper.getAllAuthor();
//load title cho gridview
        list_String.add("Id");
        list_String.add("Name");
        list_String.add("Address");
        list_String.add("Email");

        for(Author au:list_author){
            list_String.add(au.getId()+"");
            list_String.add(au.getTen()+"");
            list_String.add(au.getDiachi()+"");
            list_String.add(au.getEmail()+"");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(AuthorActivity.this, android.R.layout.simple_list_item_1,list_String);
        gv_Author.setAdapter(adapter);
//        for(Author a: listAu){
//           listStrAuthors.add(a.toString());
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter(AuthorActivity.this, android.R.layout.simple_list_item_1, listAu);
//        lv.setAdapter(adapter);

    }
}