package com.ridecrew.ridecrew;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScheduleFragment extends Fragment {
    ListView lv;
    ArrayAdapter<String> adapter;
    String[] test = {"a","b","c"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule,container,false);

        lv = view.findViewById(R.id.list);
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,test);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getActivity(),test[i],Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}



