package com.example.deepakp.test_project.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.deepakp.test_project.R;
import com.example.deepakp.test_project.adapters.RecyclerViewCustomAdapter;

import java.util.ArrayList;
import java.util.HashMap;


public class ContactFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    RecyclerView recyclerView;
    RecyclerViewCustomAdapter recyclerViewCustomAdapter;
    Context context;
    ArrayList<HashMap<String, String>> alContacts;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getContext();
        alContacts = new ArrayList<HashMap<String, String>>();

        recyclerViewCustomAdapter = new RecyclerViewCustomAdapter(context, alContacts);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_contact, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.contactRecyclerView);
        recyclerView.setAdapter(recyclerViewCustomAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));

        return view;
    }
}
