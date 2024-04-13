package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetails extends AppCompatActivity {
    private String[][] doctor_details1 = { {"Doctor Name:Dr.Ashok Jain","Hospital Address:Pune","Ph_no.:9425786251","Consultation_Fees:500rs"},
            {"Doctor Name:Dr.Vikas Jain","Hospital Address:Pune","Ph_no.:9425786252","Consultation_Fees:600rs"},
            {"Doctor Name:Dr.Sharad Pawar","Hospital Address:Pune","Ph_no.:9425786253","Consultation_Fees:300rs"},
            {"Doctor Name:Dr. Anmol Sharma","Hospital Address:Pune","Ph_no.:9425786254","Consultation_Fees:700rs"},
            {"Doctor Name:Dr. Subham Gupta","Hospital Address:Pune","Ph_no.:9425786256","Consultation_Fees:450rs"} };
    private String[][] doctor_details2 = { {"Doctor Name:Dr.Ashok Jain","Hospital Address:Pune","Ph_no.:9425786251","Consultation_Fees:500rs"},
            {"Doctor Name:Dr.Vikas Jain","Hospital Address:Pune","Ph_no.:9425786252","Consultation_Fees:600rs"},
            {"Doctor Name:Dr.Sharad Pawar","Hospital Address:Pune","Ph_no.:9425786253","Consultation_Fees:300rs"},
            {"Doctor Name:Dr. Anmol Sharma","Hospital Address:Pune","Ph_no.:9425786254","Consultation_Fees:700rs"},
            {"Doctor Name:Dr. Subham Gupta","Hospital Address:Pune","Ph_no.:9425786256","Consultation_Fees:450rs"} };
    private String[][] doctor_details3 = { {"Doctor Name:Dr.Ashok Jain","Hospital Address:Pune","Ph_no.:9425786251","Consultation_Fees:500rs"},
            {"Doctor Name:Dr.Vikas Jain","Hospital Address:Pune","Ph_no.:9425786252","Consultation_Fees:600rs"},
            {"Doctor Name:Dr.Sharad Pawar","Hospital Address:Pune","Ph_no.:9425786253","Consultation_Fees:300rs"},
            {"Doctor Name:Dr. Anmol Sharma","Hospital Address:Pune","Ph_no.:9425786254","Consultation_Fees:700rs"},
            {"Doctor Name:Dr. Subham Gupta","Hospital Address:Pune","Ph_no.:9425786256","Consultation_Fees:450rs"} };
    private String[][] doctor_details4 = { {"Doctor Name:Dr.Ashok Jain","Hospital Address:Pune","Ph_no.:9425786251","Consultation_Fees:500rs"},
            {"Doctor Name:Dr.Vikas Jain","Hospital Address:Pune","Ph_no.:9425786252","Consultation_Fees:600rs"},
            {"Doctor Name:Dr.Sharad Pawar","Hospital Address:Pune","Ph_no.:9425786253","Consultation_Fees:300rs"},
            {"Doctor Name:Dr. Anmol Sharma","Hospital Address:Pune","Ph_no.:9425786254","Consultation_Fees:700rs"},
            {"Doctor Name:Dr. Subham Gupta","Hospital Address:Pune","Ph_no.:9425786256","Consultation_Fees:450rs"} };
    private String[][] doctor_details5 = { {"Doctor Name:Dr.Ashok Jain","Hospital Address:Pune","Ph_no.:9425786251","Consultation_Fees:500rs"},
            {"Doctor Name:Dr.Vikas Jain","Hospital Address:Pune","Ph_no.:9425786252","Consultation_Fees:600rs"},
            {"Doctor Name:Dr.Sharad Pawar","Hospital Address:Pune","Ph_no.:9425786253","Consultation_Fees:300rs"},
            {"Doctor Name:Dr. Anmol Sharma","Hospital Address:Pune","Ph_no.:9425786254","Consultation_Fees:700rs"},
            {"Doctor Name:Dr. Subham Gupta","Hospital Address:Pune","Ph_no.:9425786256","Consultation_Fees:450rs"} };
    String[][] doctor_details={};
    TextView tv1;
    Button btn;
    private ArrayList<HashMap<String, String>> dataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv1=findViewById(R.id.textView_title);
        btn=findViewById(R.id.buttonltback);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv1.setText(title);
        if(title.compareTo("Family Physicians")==0)
            doctor_details=doctor_details1;
        else if(title.compareTo("Dieticians")==0)
            doctor_details=doctor_details2;
        else if(title.compareTo("Dentists")==0)
            doctor_details=doctor_details3;
        else if(title.compareTo("Surgeons")==0)
            doctor_details=doctor_details4;
        else
            doctor_details=doctor_details5;
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetails.this, FindDoctor.class));
            }
        });
        for (String[] details : doctor_details) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", details[0]);
            item.put("line2", details[1]);
            item.put("line3", details[2]);
            item.put("line4", "Cons. Fees: " + details[3] + "-/-");
            dataList.add(item);
        }
        SimpleAdapter adapter = new SimpleAdapter(this,dataList,R.layout.multi_lines,new String[]{"line1","line2","line3","line4","line5"},new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        // Set the adapter to your ListView
        ListView listView = findViewById(R.id.listViewlt);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Intent it=new Intent(DoctorDetails.this, BookAppointment.class);
                        it.putExtra("text1",title);
                        it.putExtra("text2",doctor_details[position][0]);
                        it.putExtra("text3",doctor_details[position][1]);
                        it.putExtra("text4",doctor_details[position][2]);
                        it.putExtra("text5",doctor_details[position][3]);
                        startActivity(it);
                    }
                }
        );
    }
}
