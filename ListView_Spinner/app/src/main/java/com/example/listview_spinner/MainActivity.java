package com.example.listview_spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiple_fragment);
        setTitle("GridView");
    }

}
//4/10/22
//    String[] listItems;
//    List<SanPham> listSP;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_multiple_fragment);
//        setTitle("GridView");
//    }

//        listSP = new ArrayList<>();
////        ListView lv = findViewById(R.id.listview_traicay);
////
//
//
////        //lấy danh sách item
////        listItems= getResources().getStringArray(R.array.traicay_array);
////
////        //sử dujgn adapter để đưau
////        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
////        lv.setAdapter(adapter);
//
////        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
////            @Override
////            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                String st = listItems[i];
////                Toast.makeText(MainActivity.this, st    , Toast.LENGTH_SHORT).show();
////            }
////        });
////        Spinner spinner = findViewById(R.id.spinner_traicay);
//////
//////
////        listItems= getResources().getStringArray(R.array.traicay_array);
//////
//////        //sử dujgn adapter để đưau
////        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
////        spinner.setAdapter(adapter);
////        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
////            @Override
////            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////                String st = listItems[i];
////                Toast.makeText(MainActivity.this, st    , Toast.LENGTH_SHORT).show();
////            }
////
////            @Override
////            public void onNothingSelected(AdapterView<?> adapterView) {
////
////            }
////        });
////        init()
//        GridView gv_traicay = findViewById(R.id.gridView);
//        //tạo list sp
//        listSP.add(new SanPham("Thùng 48 hộp sữa tươi hương dâu", 206000, "Sữa tươi hương dâu", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinadau, "Tốt cho trẻ em"));
//        listSP.add(new SanPham("Thùng 48 hộp sữa tươi socola", 208000, "Sữa tươi socola", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinasocola, "Tốt cho trẻ em"));
//        listSP.add(new SanPham("Thùng 48 hộp sữa dinh dưỡng lúa mạch", 210000, "Sữa dinh dưỡng lúa mạch", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinaluamach, "Tốt cho trẻ em"));
//        listSP.add(new SanPham("Thùng 48 hộp sữa tươi ít đường Vinamilk", 220000, "Sữa tươi ít đường", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinamilitduong, "Tốt cho trẻ em"));
//
////         set adapter
//        CustomAdapter adapter = new CustomAdapter(MainActivity.this, listSP);
//
////        listItems = getResources().getStringArray(R.array.traicay_array);
////        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
//        gv_traicay.setAdapter(adapter);
//
//        gv_traicay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i <= listSP.size()) {
//                    Intent intent = new Intent(MainActivity.this, ChitietSP.class);
//                    intent.putExtra("ten", listSP.get(i).getTen());
//                    intent.putExtra("gia", listSP.get(i).getGia());
//                    intent.putExtra("loaisp", listSP.get(i).getLoaisua());
//                    intent.putExtra("dungtich", listSP.get(i).getDungtich());
//                    intent.putExtra("thuonghieu", listSP.get(i).getThuonghieu());
//                    intent.putExtra("noisx", listSP.get(i).getNoisx());
//                    intent.putExtra("ttbosung", listSP.get(i).getTtbosung());
//                    intent.putExtra("img", (listSP.get(i).getImgSP()) );
////                    intent.putExtra("sp", listSP.get(i));
////                    intent.putExtra("sp", listSP.get(i));
////                    intent.putExtra("imgsp", listSP.get(i).getImgSP());
//                    startActivity(intent);
//                } else {
//                    Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
////        gv_traicay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
////            @Override
////              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
////    //              Toast.makeText(MainActivity.this, "listItems[i]", Toast.LENGTH_SHORT).show();
////                  if(i <=listSP.size()){
////                      Intent intent = new Intent(MainActivity.this, ChitietSP.class );
////                      intent.putExtra("ten", listSP.get(i).getTen());
////                      intent.putExtra("gia", listSP.get(i).getGia());
////                      intent.putExtra("loaisp", listSP.get(i).getLoaisua());
////                      intent.putExtra("dungtich", listSP.get(i).getDungtich());
////                      intent.putExtra("thuonghieu", listSP.get(i).getThuonghieu());
////                      intent.putExtra("noisx", listSP.get(i).getNoisx());
////                      intent.putExtra("ttbosung",  listSP.get(i).getTtbosung() );
////                      startActivity(intent);
////                  }else{
////                      Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
////                  }
////              }
////
////              @Override
////              public void onNothingSelected(AdapterView<?> adapterView) {
////
////              }
////      });
////    }
//    }
//
//    public byte[] ConvertBitmaptoByteArray(int resId){
//        Bitmap bmp = BitmapFactory.decodeResource(getResources(), resId);
//        ByteArrayOutputStream stream = new ByteArrayOutputStream();
////        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
//        byte[] byteArray = stream.toByteArray();
//        return byteArray;
//    }
//}