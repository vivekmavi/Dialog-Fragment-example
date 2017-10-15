package com.example.paras.dialogfragmentexample1;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements MyDialogFragmentClass.Communicator
{
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.show_Dialog_Btn);
    }

    public void showDialog(View view)
    {
        Toast.makeText(this, "show button clicked", Toast.LENGTH_SHORT).show();

        FragmentManager fragmentManager = getSupportFragmentManager();
        MyDialogFragmentClass dialogClassObject = new MyDialogFragmentClass();
        dialogClassObject.show(fragmentManager,"dialog_1_tag");
    }

    @Override
    public void respond(String response)
    {
        Toast.makeText(this, response, Toast.LENGTH_SHORT).show();
    }
}
