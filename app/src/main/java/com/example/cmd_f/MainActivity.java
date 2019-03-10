package com.example.cmd_f;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.location.Geocoder;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void geocode()throws IOException{
    Geocoder gc = new Geocoder(context);
if(gc.isPresent()) {
    List<address> list = gc.getFromLocation(37.42279, -122.08506, 1);
    Address address = list.get(0);
    StringBuffer str = new StringBuffer();
    str.append("Name: "+address.getLocality() + '\n');
    str.append("Sub - Admin Ares: "+address.getSubAdminArea() + '\n');
    str.append("Admin Area: "+address.getAdminArea() + '\n');
    str.append("Country: "+address.getCountryName() + '\n');
    str.append("Country Code: "+address.getCountryCode() + '\n');
    String strAddress = str.toString();
}
    }
}
