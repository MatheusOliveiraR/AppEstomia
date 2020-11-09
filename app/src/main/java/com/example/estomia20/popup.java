package com.example.estomia20;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class popup extends AppCompatDialogFragment {
    private EditText peso;
    private popupListener listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceStance){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_popup,null);


        builder.setView(view)
                .setTitle("editar")
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Editar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        String pesos = peso.getText().toString();
                        listener.apllyTexts(pesos);

                    }
                });

        peso = view.findViewById(R.id.peso);
                return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            listener = (popupListener)context;
        } catch (ClassCastException e) {
            throw new ClassCastException((context.toString()));
        }
    }

    public interface popupListener{
        void apllyTexts(String peso);
    }
}