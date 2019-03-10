package com.example.cmd_f;

import android.content.Context;
import android.content.DialogInterface;
import android.location.*;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = findViewById(R.id.textView);
        try {
            alertDialog();
            tv.setText(geocode(this));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String geocode(Context context)throws IOException{
            String str = "";
        Geocoder gc = new Geocoder(context);
        if(gc.isPresent()) {
            List<Address> list = gc.getFromLocation(46.42279, -123.08506, 1);
            Address address = list.get(0);
            str += "Name: "+address.getLocality() + '\n';
            str += "Sub - Admin Ares: "+address.getSubAdminArea() + '\n';
            str += "Admin Area: "+address.getAdminArea() + '\n';
            str += "Country: "+address.getCountryName() + '\n';
            str += "Country Code: "+address.getCountryCode() + '\n';


    }
    return str;
    }
    private void alertDialog() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle( "ALERT" )
                .setMessage("Someone nearby is in danger!")

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }

}
