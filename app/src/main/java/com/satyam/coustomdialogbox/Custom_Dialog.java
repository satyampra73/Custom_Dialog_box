package com.satyam.coustomdialogbox;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialogFragment;

public class Custom_Dialog extends AppCompatDialogFragment {
    EditText editText1,editText2;
    CustomDialogInterface dialogInterface;

    @Override
    public Dialog onCreateDialog( Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.layout_dialog,null);
        builder.setView(view).setTitle("This is an example").setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        }).setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String text1=editText1.getText().toString();
                String text2=editText2.getText().toString();
                dialogInterface.applyTexts(text1,text2);
            }
        });
        editText1=view.findViewById(R.id.editText1);
        editText2=view.findViewById(R.id.editText2);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dialogInterface=(CustomDialogInterface) context;
    }

    public interface CustomDialogInterface{
        Void applyTexts(String textOne,String textTwo);
    }
}
