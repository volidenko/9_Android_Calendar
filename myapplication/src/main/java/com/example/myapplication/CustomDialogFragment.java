package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class CustomDialogFragment extends DialogFragment {
    private Removable removable;
    @Override
    public void onAttach(Context context){
        super.onAttach(context);
        removable=(Removable) context;
    }
    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState){
        String phone=getArguments().getString("phone");
        AlertDialog.Builder builder= new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Dialog Window")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Do you want to remove?"+phone)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        removable.remove(phone);
                    }
                })
                .setNegativeButton("Cancel",null)
                .create();
    }
}
