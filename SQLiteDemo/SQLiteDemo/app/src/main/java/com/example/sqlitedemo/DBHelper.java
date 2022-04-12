package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    public DBHelper(@Nullable Context context) {
        super(context, "MYDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
     sqLiteDatabase.execSQL("CREATE TABLE Authors(id interger primary key,name text,address text,email text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Authors");
        onCreate(sqLiteDatabase);
    }
    //Thêm-xoá-sưả-truy vấn author
    public int insertAuthor(Author author){

        SQLiteDatabase db= getWritableDatabase();

        ContentValues content= new ContentValues();

        content.put("id",author.getId());
        content.put("name",author.getTen());
        content.put("address",author.getDiachi());
        content.put("email",author.getEmail());
        int res= (int)db.insert("Authors",null,content);
        if (res >0)
            Log.e("add", "add thanh cong");
        db.close();
        return res;
    }
    public ArrayList<Author> getAllAuthor(){
        ArrayList<Author> list=new ArrayList<>();
        String sql="Select * from Authors";
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery(sql,null);
        if(cursor != null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                list.add(new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3)));
                cursor.moveToNext();
            }
        }
        return list;
    }
    public Author getIdAuthor(int id_Author){
        Author author= new Author();

        String sql="Select * from Authors where id="+id_Author;

        SQLiteDatabase db= getReadableDatabase();

        Cursor cursor= db.rawQuery(sql,null);
        if(cursor != null){
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                author =new Author(cursor.getInt(0),cursor.getString(1),cursor.getString(2),
                        cursor.getString(3));
                cursor.moveToNext();
            }
        }
        return author;
    }

    public int updateAuthor(Author author){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("id", author.getId());
        values.put("name", author.getTen());
        values.put("address", author.getDiachi());
        values.put("email", author.getEmail());

        return db.update("Authors", values,"id = ?" , new String[] {String.valueOf(author.getId())});
    }

    public void deleteAuthor(int authorId){
        SQLiteDatabase db = getWritableDatabase();
        db.delete("Authors", "id=?", new String[] {String.valueOf(authorId)});
        db.close();
    }

    // Deleting all countries
    public void deleteAllAuthors() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Authors",null,null);
        db.close();
    }
    // Getting countries Count
    public int getCountriesCount() {
        String countQuery = "SELECT  * FROM Authors";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }
}
