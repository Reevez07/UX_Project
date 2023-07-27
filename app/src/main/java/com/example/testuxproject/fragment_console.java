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
public class fragment_console extends Fragment implements HomeInterface {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ArrayList<GameItems> games = GlobalData.filterGameByType("Console");

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragment_console() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragment_console.
     */
    // TODO: Rename and change types and number of parameters
    public static fragment_console newInstance(String param1, String param2) {
        fragment_console fragment = new fragment_console();
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
        View view = inflater.inflate(R.layout.fragment_console, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.home_rv);

        Home_game_adapter adapter = new Home_game_adapter(view.getContext(), games, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(view.getContext(), 2));

        return view;
    }

    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(getActivity(), ItemPage.class);

        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("Items", games.get(position).getItems());
        bundle.putString("gameName", games.get(position).getGameName());
        bundle.putInt("gameIcon", games.get(position).getGameImage2());

        intent.putExtras(bundle);
        startActivity(intent);
    }
}