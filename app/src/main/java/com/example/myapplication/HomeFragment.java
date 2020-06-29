package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    Button btnAddUser,bnReadUser,bnDelete,bnUpdate;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
     View view  = inflater.inflate(R.layout.fragment_home, container, false);
     btnAddUser = view.findViewById(R.id.btnAdd);
     btnAddUser.setOnClickListener(this);
     bnReadUser = view.findViewById(R.id.btnView);
     bnReadUser.setOnClickListener(this);
     bnDelete = view.findViewById(R.id.btnDelete);
     bnDelete.setOnClickListener(this);
     bnUpdate = view.findViewById(R.id.btnUpdate);
     bnUpdate.setOnClickListener(this);
     return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAdd:
                MainActivity.mFragmentManager.beginTransaction().replace(R.id.fragment_container,new AddUserFragment()).addToBackStack(null).commit();
                break;

            case R.id.btnView:
                MainActivity.mFragmentManager.beginTransaction().replace(R.id.fragment_container,new UserReadFragment()).addToBackStack(null).commit();
                break;

            case R.id.btnDelete:
                MainActivity.mFragmentManager.beginTransaction().replace(R.id.fragment_container,new DeleteUserFragment()).addToBackStack(null).commit();
                break;


            case R.id.btnUpdate:
                MainActivity.mFragmentManager.beginTransaction().replace(R.id.fragment_container,new UpdateTheUserFrag()).addToBackStack(null).commit();
                break;



        }

    }
}
