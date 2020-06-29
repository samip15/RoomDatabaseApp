package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserReadFragment extends Fragment {
    TextView txtInfo;

    public UserReadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_user_read, container, false);
        txtInfo = view.findViewById(R.id.txt_userRead);
        List<User> users = MainActivity.mAppDatabase.myDao().getUsers();
        String info = "";
        for (User usr: users){
            int id = usr.getId();
            String name = usr.getName();
            String email = usr.getEmail();
            info = info+"\n\n"+"Id :"+id+"\n Name :"+name+"\n"+"Email :"+email;

        }
        txtInfo.setText(info);
        return view;

    }

}
