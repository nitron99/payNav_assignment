package com.example.paynav_assignment.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.paynav_assignment.Adapters.FriendlistAdapter;
import com.example.paynav_assignment.R;

import java.util.List;

public class returnFragment extends Fragment {

    FriendlistAdapter friendlistAdapter;
    ListView friend_listView;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public returnFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment returnFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static returnFragment newInstance(String param1, String param2) {
        returnFragment fragment = new returnFragment();
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

            String[] friend_names = new String[]{
                    "Ananya Rao","Rajashi Prakash"
                    ,"Harshada Nikam","John Born"
            };

            friend_listView = getActivity().findViewById(R.id.friend_listview);
            friend_listView.setAdapter(friendlistAdapter = new FriendlistAdapter(getContext(), R.layout.friends_list_item, friend_names));

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        View view =  inflater.inflate(R.layout.fragment_return, container, false);



        return view;
    }

}