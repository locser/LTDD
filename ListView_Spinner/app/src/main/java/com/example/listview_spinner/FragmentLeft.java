package com.example.listview_spinner;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.listview_spinner.R;

public class FragmentLeft extends Fragment {


    // This method will be invoked when the Fragment view object is created.
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

        GridView gridView = retView.findViewById(R.id.lgridView);
        CustomAdapter adapter = new CustomAdapter(inflater, listSP);
        gridView.setAdapter(adapter);

//            init()
//                    final TextView tvten, tvgia, tvloaisp, tvdungtich, tvthuonghieu,tvnoisx, tvttbs;
//                    final ImageView imgSP;
//                    final Button btnDatHang;

            //Get the TextView object in right Fragment.
//          final TextView rightFragmentTextView = (TextView)rightFragment.getView().findViewById(R.id.fragmentRightTextView);
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
//            androidButton.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//
//                    // Do not use fragmentBelongActivity.getFragmentManager() method which is not compatible with older android os version. .
//                    FragmentManager fragmentManager = fragmentBelongActivity.getSupportFragmentManager();
//
//                    // Get right Fragment object.
//                    Fragment rightFragment = fragmentManager.findFragmentById(R.id.fragmentRight);
//
//                    // Get the TextView object in right Fragment.
//                    final TextView rightFragmentTextView = (TextView)rightFragment.getView().findViewById(R.id.fragmentRightTextView);
//
//                    // Set text in right Fragment TextView.
//                    rightFragmentTextView.setText("You click Android button.");
//                }
//            });

        return retView;
    }

}
