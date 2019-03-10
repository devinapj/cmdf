package com.example.cmd_f;
//hello
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

//        TextView tv = findViewById(R.id.textView);
        try {
            alertDialog(geocode(this));
//            tv.setText(geocode(this));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String geocode(Context context)throws IOException{
            String str = "";
        Geocoder gc = new Geocoder(context);
        if(gc.isPresent()) {
            List<Address> list = gc.getFromLocation(49.265188333333334, -123.25329333333333, 1);
            Address address = list.get(0);
            str += "City: "+address.getLocality() + '\n';
            str += "Sub - Admin Ares: "+address.getSubAdminArea() + '\n';
            str += "Admin Area: "+address.getAdminArea() + '\n';
            str += "Country: "+address.getCountryName() + '\n';
            str += "Country Code: "+address.getCountryCode() + '\n';


    }
    return str;
    }
    private void alertDialog(String msg) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle( "ALERT! Someone's in danger!" )
                .setMessage(msg)

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialoginterface, int i) {
                    }
                }).show();
    }

}
