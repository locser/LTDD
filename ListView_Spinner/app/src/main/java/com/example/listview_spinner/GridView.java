package com.example.listview_spinner;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;


    public class GridView extends Fragment{
        @Nullable
        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
            View retView = inflater.inflate(R.layout.fragment_left, container);

            // Get Fragment belonged Activity
            final FragmentActivity fragmentBelongActivity = getActivity();
            List<SanPham> listSP = new ArrayList<>();

            listSP.add(new SanPham("Thùng 48 hộp sữa tươi hương dâu", 206000, "Sữa tươi hương dâu", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinadau, "Tốt cho trẻ em"));
            listSP.add(new SanPham("Thùng 48 hộp sữa tươi socola", 208000, "Sữa tươi socola", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinasocola, "Tốt cho trẻ em"));
            listSP.add(new SanPham("Thùng 48 hộp sữa dinh dưỡng lúa mạch", 210000, "Sữa dinh dưỡng lúa mạch", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinaluamach, "Tốt cho trẻ em"));
            listSP.add(new SanPham("Thùng 48 hộp sữa tươi ít đường Vinamilk", 220000, "Sữa tươi ít đường", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinamilitduong, "Tốt cho trẻ em"));
            listSP.add(new SanPham("Cocacola", 10000, "Nước uống có ga", 400, "Cocacola", "Việt Nam", R.drawable.coca, "Nước giải khát, ngon hơn khi uống lạnh"));
            listSP.add(new SanPham("Nước ép dưa hấu", 15000, "Nước uống hoa quả", 400, "OFK", "Việt Nam", R.drawable.nuocepduahau, "Nước giải khát, ngon hơn khi uống lạnh"));
            listSP.add(new SanPham("Nước ép dưa lưới", 15000, "Nước uống hoa quả", 400, "OFK", "Việt Nam", R.drawable.nuocepdualuoinhadam, "Nước giải khát, ngon hơn khi uống lạnh"));

            android.widget.GridView gridView = retView.findViewById(R.id.lgridView);
            CustomAdapter adapter = new CustomAdapter(inflater, listSP);
            gridView.setAdapter(adapter);

            if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT ){
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        if (i <= listSP.size()) {
                            Intent intent = new Intent(getActivity(), ChitietSP.class);
                            intent.putExtra("ten", listSP.get(i).getTen());
                            intent.putExtra("gia", listSP.get(i).getGia());
                            intent.putExtra("loaisp", listSP.get(i).getLoaisua());
                            intent.putExtra("dungtich", listSP.get(i).getDungtich());
                            intent.putExtra("thuonghieu", listSP.get(i).getThuonghieu());
                            intent.putExtra("noisx", listSP.get(i).getNoisx());
                            intent.putExtra("ttbosung", listSP.get(i).getTtbosung());
                            intent.putExtra("img", (listSP.get(i).getImgSP()) );
//                    intent.putExtra("sp", listSP.get(i));
//                    intent.putExtra("sp", listSP.get(i));
//                    intent.putExtra("imgsp", listSP.get(i).getImgSP());
                            startActivity(intent);
                        } else {
//                    Toast.makeText(this, "Lỗi", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }else{
                gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        // Do not use fragmentBelongActivity.getFragmentManager() method which is not compatible with older android os version. .
                        FragmentManager fragmentManager =  fragmentBelongActivity.getSupportFragmentManager();

                        // Get right Fragment object.
                        Fragment rightFragment = fragmentManager.findFragmentById(R.id.fragmentRight);
                        //get Component Object in right fragment
                        final TextView tvten = (TextView) rightFragment.requireView().findViewById(R.id.rtvtensp);
                        final TextView tvgia = (TextView) rightFragment.requireView().findViewById(R.id.rtvgia);
                        final TextView tvloaisp = (TextView) rightFragment.requireView().findViewById(R.id.rtvloaisp);
                        final TextView tvdungtich = (TextView) rightFragment.requireView().findViewById(R.id.rtvdungtich);
                        final TextView tvthuonghieu = (TextView) rightFragment.requireView().findViewById(R.id.rtvthuonghieu);
                        final TextView  tvnoisx = (TextView) rightFragment.requireView().findViewById(R.id.rtvnoisanxuat);
                        final TextView tvttbs= (TextView) rightFragment.requireView().findViewById(R.id.rtvthongtinbosung);
                        final ImageView imgSP = (ImageView) rightFragment.requireView().findViewById(R.id.rimageView);

                        SanPham sp = listSP.get(i);
                        tvten.setText(sp.getTen());
                        tvgia.setText(sp.getGia() + " đ");
                        tvloaisp.setText(sp.getLoaisua());
                        tvdungtich.setText(sp.getDungtich() + "ml");
                        tvthuonghieu.setText(sp.getThuonghieu());
                        tvnoisx.setText(sp.getNoisx());
                        tvttbs.setText(sp.getTtbosung());
                        imgSP.setImageResource(sp.getImgSP());
                    }
                });
            }

            return retView;
        }
    }

//public class GridView extends AppCompatActivity{
//    List<SanPham> listSP = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        setTitle("GridView");
//
//
//        android.widget.GridView gv = findViewById(R.id.gridView);
//        //tạo list sp
//        listSP.add(new SanPham("Thùng 48 hộp sữa tươi hương dâu", 206000, "Sữa tươi hương dâu", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinadau, "Tốt cho trẻ em"));
//        listSP.add(new SanPham("Thùng 48 hộp sữa tươi socola", 208000, "Sữa tươi socola", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinasocola, "Tốt cho trẻ em"));
//        listSP.add(new SanPham("Thùng 48 hộp sữa dinh dưỡng lúa mạch", 210000, "Sữa dinh dưỡng lúa mạch", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinaluamach, "Tốt cho trẻ em"));
//        listSP.add(new SanPham("Thùng 48 hộp sữa tươi ít đường Vinamilk", 220000, "Sữa tươi ít đường", 110, "Vinamilk (Việt Nam)", "Việt Nam", R.drawable.vinamilitduong, "Tốt cho trẻ em"));
//
////         set adapter
//        CustomAdapter adapter = new CustomAdapter(GridView.this, listSP);
//
////        listItems = getResources().getStringArray(R.array.traicay_array);
////        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listItems);
//        gv.setAdapter(adapter);
////
//        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                if (i <= listSP.size()) {
//                    Intent intent = new Intent(GridView.this, ChitietSP.class);
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
//                    Toast.makeText(GridView.this, "Lỗi", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//////        gv_traicay.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//////            @Override
//////              public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//////    //              Toast.makeText(MainActivity.this, "listItems[i]", Toast.LENGTH_SHORT).show();
//////                  if(i <=listSP.size()){
//////                      Intent intent = new Intent(MainActivity.this, ChitietSP.class );
//////                      intent.putExtra("ten", listSP.get(i).getTen());
//////                      intent.putExtra("gia", listSP.get(i).getGia());
//////                      intent.putExtra("loaisp", listSP.get(i).getLoaisua());
//////                      intent.putExtra("dungtich", listSP.get(i).getDungtich());
//////                      intent.putExtra("thuonghieu", listSP.get(i).getThuonghieu());
//////                      intent.putExtra("noisx", listSP.get(i).getNoisx());
//////                      intent.putExtra("ttbosung",  listSP.get(i).getTtbosung() );
//////                      startActivity(intent);
//////                  }else{
//////                      Toast.makeText(MainActivity.this, "Lỗi", Toast.LENGTH_SHORT).show();
//////                  }
//////              }
//////
//////              @Override
//////              public void onNothingSelected(AdapterView<?> adapterView) {
//////
//////              }
//////      });
//////    }
////    }
//    }
//
//}
