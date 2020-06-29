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
public class AddUserFragment extends Fragment {
    private EditText uId,uName,uEmail;
    private Button bnSave;

    public AddUserFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_add_fragment, container, false);
        uId = view.findViewById(R.id.user_id);
        uName = view.findViewById(R.id.user_name);
        uEmail = view.findViewById(R.id.user_email);
        bnSave = view.findViewById(R.id.btn_save);
        bnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             int userId = Integer.parseInt(uId.getText().toString());
             String username = uName.getText().toString().trim();
             String userEmail = uEmail.getText().toString().trim();
             User user  = new User();
             user.setId(userId);
             user.setEmail(userEmail);
             user.setName(username);
             MainActivity.mAppDatabase.myDao().addUser(user);
                Toast.makeText(getActivity(), "User Added Successfully", Toast.LENGTH_SHORT).show();
                uId.setText("");
                uName.setText("");
                uEmail.setText("");
            }
        });
        return view;
    }
}
