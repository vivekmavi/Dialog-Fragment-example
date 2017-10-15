package com.example.paras.dialogfragmentexample1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


public class MyDialogFragmentClass extends DialogFragment implements View.OnClickListener
{
    Button btn1 ;  //yes
    Button btn2 ;   //no
    Communicator communicator ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState)
    {
        setCancelable(false);
        View view = inflater.inflate(R.layout.fragment_my_dialog_frag_class, container, false);
            return view ;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);

        btn1 = (Button) view.findViewById(R.id.button1);
        btn2 = (Button) view.findViewById(R.id.button2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);

    }

    @Override
    public void onAttach(Context context)
    {
        super.onAttach(context);
        setCommunicator((Communicator) context);
    }

    @Override
    public void onClick(View view)
    {
        if (view.getId()==R.id.button1)
        {
            communicator.respond("yes");
            dismiss();
        }
        if (view.getId()==R.id.button2)
        {
            communicator.respond("no");
            dismiss();
        }
    }
    public void setCommunicator(Communicator communicator1)
    {
        communicator=communicator1;
    }
    interface Communicator
    {
        public void respond(String response);
    }
}
