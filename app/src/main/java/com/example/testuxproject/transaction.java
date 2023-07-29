package com.example.testuxproject;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.testuxproject.homepage.GameItems;
import com.example.testuxproject.homepage.HomeInterface;
import com.example.testuxproject.homepage.Home_game_adapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragment_console#newInstance} factory method to
 * create an instance of this fragment.
 */
public class transaction extends Fragment implements HomeInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ArrayList<TransactionModel> transactions = GlobalData.transactions;

    public transaction() {
        // Required empty public constructor
    }

    public static transaction newInstance(String param1, String param2) {
        transaction fragment = new transaction();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_transaction, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewPastTransaction);

        TransactionRecyclerViewAdapter adapter = new TransactionRecyclerViewAdapter(view.getContext(), transactions, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));

        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ItemPage.class);

        Bundle bundle = new Bundle();
//        bundle.putParcelableArrayList("Items", games.get(position).getItems());
//        bundle.putString("gameName", games.get(position).getGameName());
//        bundle.putInt("gameIcon", games.get(position).getGameImage2());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}