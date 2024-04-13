package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {
    private String[][ ] packages={
            {"Package1:Full Body Checkup","","","","999"},
            {"Package2:Blood Glucose Fasting","","","","299"},
            {"Package3:Covid-19 Antibody","IgG","","","899"},
            {"Package4:Thyroid Check","","","","499"},
            {"Package5:Immunity Check","","","","699"},
    };
    private String[] package_details={
            "Blood Sugar Levels, Cholesterol\n",
            " Kidney and Liver Function\n",
            " Thyroid Gland Function\n",
            "Lipid Profile\n",
            "Urine Routine\n ",
            "COVID-19 AntiBody IgG\n",
            "Blood Glucose Fasting\n",
            "Thyroid-Profile-Total(T3,T4&TSH Ultra Sensitive)\n"
    };
    private ArrayList<HashMap<String, String>> List = new ArrayList<>();
    SimpleAdapter sa;
    Button BtnGC,Btnback;
    ListView listView;
    @Override
    protected  void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);
BtnGC=findViewById(R.id.buttonltcart);
Btnback=findViewById(R.id.buttonltback);
listView=findViewById(R.id.listViewlt);
Btnback.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(LabTestActivity.this,Home.class));
    }
});
for(int i = 0; i<packages.length; i++){
    HashMap<String, String> item = new HashMap<>();
    item.put("line1", packages[i][0]);
    item.put("line2", packages[i][1]);
    item.put("line3", packages[i][2]);
    item.put("line4", packages[i][3]);
    item.put("line5","Total Cost:"+ packages[i][4]+"/-");
    List.add(item);
}
        sa = new SimpleAdapter(this,List,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);
    }
}
