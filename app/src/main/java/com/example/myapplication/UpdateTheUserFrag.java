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
public class UpdateTheUserFrag extends Fragment {
    private EditText uId_update,uName_update,uEmail_update;
    private Button bn_update;

    public UpdateTheUserFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View view = inflater.inflate(R.layout.fragment_update_the_user, container, false);

         uId_update = view.findViewById(R.id.edit_updateuid);
         uName_update = view.findViewById(R.id.update_uname);
         uEmail_update = view.findViewById(R.id.update_email);

         bn_update = view.findViewById(R.id.btn_update);

         bn_update.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 int id_update = Integer.parseInt(uId_update.getText().toString());
                 String name_update = uName_update.getText().toString();
                 String email_update = uEmail_update.getText().toString();
                 User user = new User();
                 user.setId(id_update);
                 user.setName(name_update);
                 user.setEmail(email_update);
                 MainActivity.mAppDatabase.myDao().updateUser(user);
                 Toast.makeText(getActivity(), "User Updated Successfully", Toast.LENGTH_SHORT).show();
                 uId_update.setText("");
                 uName_update.setText("");
                 uEmail_update.setText("");
             }
         });




    return view;
    }
}
