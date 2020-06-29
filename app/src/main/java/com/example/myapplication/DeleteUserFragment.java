package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteUserFragment extends Fragment {
    EditText txtUserId;
    Button deleteUser;

    public DeleteUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);
        txtUserId = view.findViewById(R.id.editText_uid);
        deleteUser = view.findViewById(R.id.buttondel);
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id = Integer.parseInt(txtUserId.getText().toString());
                User user = new User();
                user.setId(id);
                MainActivity.mAppDatabase.myDao().deleteUser(user);
                Toast.makeText(getActivity(), "User Deleted Successfully", Toast.LENGTH_SHORT).show();
                txtUserId.setText("");

            }
        });

        return view;

    }
}
