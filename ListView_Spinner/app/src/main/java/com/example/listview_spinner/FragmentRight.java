package com.example.listview_spinner;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentRight extends Fragment {

    TextView tvten, tvgia, tvloaisp, tvdungtich, tvthuonghieu,tvnoisx, tvttbs;
    ImageView imgSP;
    ImageButton imgButton;
    Button btnDatHang;

    // This method will be invoked when the Fragment view object is created.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.fragment_right, container);

        tvten = retView.findViewById(R.id.rtvtensp);
        tvgia = retView.findViewById(R.id.rtvgia);
        tvloaisp = retView.findViewById(R.id.rtvloaisp);
        tvdungtich = retView.findViewById(R.id.rtvdungtich);
        tvthuonghieu = retView.findViewById(R.id.rtvthuonghieu);
        tvnoisx = retView.findViewById(R.id.rtvnoisanxuat);
        tvttbs= retView.findViewById(R.id.rtvthongtinbosung);
        imgSP = retView.findViewById(R.id.rimageView);
        imgButton = retView.findViewById(R.id.rimgButton);

        return retView;
    }
}
