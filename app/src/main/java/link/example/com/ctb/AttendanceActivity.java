package link.example.com.ctb;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class AttendanceActivity extends AppCompatActivity {

    Spinner spinner;
    RelativeLayout relativeLayout;
    TextView t1,t2,t3,t4,t5,t6;
    CheckBox c1,c2,c3,c4,c5,c6;
    Button check,submit;

    public String s,userid;
    int date, month,realmonth,year;
    FirebaseAuth mAuth;
    DatabaseReference databaseReference;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        Toolbar t = findViewById(R.id.toolbar);
        t.setNavigationIcon(R.mipmap.ic_arrow);
        t.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });


        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        t1=findViewById(R.id.textView1);
        t2=findViewById(R.id.textView2);
        t3=findViewById(R.id.textView3);
        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
//        t6=findViewById(R.id.textView6);
        t1.setClickable(true);
        t2.setClickable(true);
        t3.setClickable(true);
        t4.setClickable(true);
        t5.setClickable(true);
        c1=findViewById(R.id.checkbox1);
        c2=findViewById(R.id.checkbox2);
        c3=findViewById(R.id.checkbox3);
        c4=findViewById(R.id.checkbox4);
        c5=findViewById(R.id.checkbox5);
//        c6=findViewById(R.id.checkbox6);
        submit=findViewById(R.id.Submit);
        check=findViewById(R.id.Check);

        date = Calendar.getInstance().get(Calendar.DATE);
        month =Calendar.getInstance().get(Calendar.MONTH);
        realmonth=month+1;
        year =Calendar.getInstance().get(Calendar.YEAR);
        s=year+"/"+realmonth+"/"+date;



        databaseReference = FirebaseDatabase.getInstance().getReference();

        relativeLayout=findViewById(R.id.subjectlist);
        relativeLayout.setVisibility(View.GONE);
        spinner = findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {


                if(i==0){
                    relativeLayout.setVisibility(View.GONE);
                }

                if(i==1){
                    userid=mAuth.getUid();
                    relativeLayout.setVisibility(View.VISIBLE);
                    t1.setText("Professional Elective Lab");
                    t2.setText("Open Elective");
                    t3.setText("Language Processor");
                    t4.setText("Design & Analysis of Algorithm");
                    t5.setText("Fundamental of Management");
                    t5.setVisibility(View.VISIBLE);
                    c5.setVisibility(View.VISIBLE);
//                    t6.setText("Analysis of Algorithm");

//                        DatabaseReference ref=databaseReference.child(s).push();
//                        ref.setValue("Language Processor");
                        submit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                if(chkStatus()){
                                if(c1.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                        ref.setValue("Professional Elective Lab");

                                    }

                                if(c2.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Open Elective");

                                    }
                                if(c3.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processor");

                                    }
                                if(c4.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Design & Analysis of Algorithm");

                                    }
                                if(c5.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Fundamental of Management");

                                    }
//                                if(c6.isChecked()){
//                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
//                                    ref.setValue("Analysis of Algorithm");
//
//                                    }

                                Toast.makeText(AttendanceActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                            }}
                        });


                }
                if(i==2){
                    relativeLayout.setVisibility(View.VISIBLE);
                    userid=mAuth.getUid();
                    t1.setText("Fundamental of Management");
                    t2.setText("Open Elective");
                    t3.setText("Software Engineering");
                    t4.setText("Software Engineering Lab");
                    t5.setText("Language Processors Lab");
                    t5.setVisibility(View.VISIBLE);
                    c5.setVisibility(View.VISIBLE);
//                    t6.setText("Language Processors");

                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (chkStatus()) {
                                if (c1.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Fundamental of Management");

                                }

                                if (c2.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Open Elective");

                                }
                                if (c3.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering");

                                }
                                if (c4.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering Lab");
//
                                }
                                if (c5.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processors Lab");

                                }
////                                if (c6.isChecked()) {
////                                    DatabaseReference ref = databaseReference.child(s).push();
////                                    ref.setValue("Analysis of Algorithm1");
//
////                                }
//                                Toast.makeText(AttendanceActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
//
//
                }
                if(i==3){
                    relativeLayout.setVisibility(View.VISIBLE);
                    t1.setText("Software Engineering Lab");
                    t2.setText("Language Processors Lab");
                    t3.setText("Open Elective");
                    t4.setText("Software Engineering");
                    t5.setText("Design & Analysis of Algorithm");
                    t5.setVisibility(View.VISIBLE);
                    c5.setVisibility(View.VISIBLE);
                    userid=mAuth.getUid();
//                    t6.setText("Language Processors");
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (chkStatus()) {
                                if (c1.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering Lab");

                                }

                                if (c2.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processors Lab");

                                }
                                if (c3.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Open Elective");

                                }
                                if (c4.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering");

                                }
                                if (c5.isChecked()) {
                                    DatabaseReference ref = databaseReference.child(userid).child(s).push();
                                    ref.setValue("Design & Analysis of Algorithm");

                                }
//                                if (c6.isChecked()) {
//                                    DatabaseReference ref = databaseReference.child(s).push();
//                                    ref.setValue("Analysis of Algorithm1");

//                                }
                                Toast.makeText(AttendanceActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                }
                if(i==4){
                    relativeLayout.setVisibility(View.VISIBLE);
                    t1.setText("Professional Elective");
                    t2.setText("Software Engineering");
                    t3.setText("Language Processors");
                    t4.setText("Language Processors Lab");
                    t5.setText("Software Engineering Lab");
                    t5.setVisibility(View.VISIBLE);
                    c5.setVisibility(View.VISIBLE);
                    userid=mAuth.getUid();
//                    t6.setText("Language Processors");
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(chkStatus()){
                                if(c1.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Professional Elective");

                                }

                                if(c2.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering");

                                }
                                if(c3.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processor");

                                }
                                if(c4.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processors Lab");

                                }
                                if(c5.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering Lab");

                                }
//                                if(c6.isChecked()){
//                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
//                                    ref.setValue("Analysis of Algorithm");
//
//                                    }

                                Toast.makeText(AttendanceActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                            }}
                    });


                }
                if(i==5){
                    relativeLayout.setVisibility(View.VISIBLE);
                    t1.setText("Professional Elective");
                    t2.setText("Design & Analysis of Algorithm");
                    t3.setText("Language Processors");
                    t4.setText("Professional Elective Lab");
                    t5.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    userid=mAuth.getUid();
//                    t5.setText("Professional Elective ");
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(chkStatus()){
                                userid=mAuth.getUid();
                                if(c1.isChecked()){
                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Professional Elective");

                                }

                                if(c2.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Design & Analysis of Algorithm");

                                }
                                if(c3.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processor");

                                }
                                if(c4.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Professional Elective Lab");

                                }
//                                if(c5.isChecked()){
//                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
//                                    ref.setValue("Software Engineering Lab");
//
//                                }
//                                if(c6.isChecked()){
//                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
//                                    ref.setValue("Analysis of Algorithm");
//
//                                    }

                                Toast.makeText(AttendanceActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                            }}
                    });

                }
                if(i==6){
                    relativeLayout.setVisibility(View.VISIBLE);
                    t1.setText("Fundamental of Management");
                    t2.setText("Language Processors");
                    t3.setText("Software Engineering");
                    t4.setText("Design & Analysis of Algorithm");
                    t5.setVisibility(View.GONE);
                    c5.setVisibility(View.GONE);
                    userid=mAuth.getUid();
//                    t5.setText("Language Processors");
//                    t6.setText("Language Processors");
                    submit.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {

                            if(chkStatus()){
                                if(c1.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Fundamental of Management");

                                }

                                if(c2.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Language Processors");

                                }
                                if(c3.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Software Engineering");

                                }
                                if(c4.isChecked()){

                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
                                    ref.setValue("Design & Analysis of Algorithm");

                                }
//                                if(c5.isChecked()){
//                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
//                                    ref.setValue("Software Engineering Lab");
//
//                                }
//                                if(c6.isChecked()){
//                                    DatabaseReference ref=databaseReference.child(userid).child(s).push();
//                                    ref.setValue("Analysis of Algorithm");
//
////                                    }

                                Toast.makeText(AttendanceActivity.this, "Submitted successfully", Toast.LENGTH_SHORT).show();
                            }}
                    });

                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

//    setSubmit();
    setCheck();
    }
        public boolean chkStatus() {
    final ConnectivityManager connMgr = (ConnectivityManager)
            this.getSystemService(Context.CONNECTIVITY_SERVICE);
    final android.net.NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    final android.net.NetworkInfo mobile = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
    if (wifi.isConnectedOrConnecting ()) {
//            Toast.makeText(this, "Wifi", Toast.LENGTH_LONG).show();
        return true;
    } else if (mobile.isConnectedOrConnecting ()) {
//            Toast.makeText(this, "Mobile 3G ", Toast.LENGTH_LONG).show();
        return true;
    } else {
        Toast.makeText(this, "No Network ", Toast.LENGTH_SHORT).show();
    return false;
    }
    }


    private void setCheck() {
//
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AttendanceActivity.this,CheckAttenActivity.class));
            }
        });
    }
    public void subjectClicked(View view){
        int id=view.getId();
        if( id == R.id.textView1){
            if(c1.isChecked()){c1.setChecked(false);}else
            c1.setChecked(true);
        }
        if( id == R.id.textView2){
            if(c2.isChecked()){c2.setChecked(false);}else
            c2.setChecked(true);
        }
        if( id == R.id.textView3){
            if(c3.isChecked()){c3.setChecked(false);}else
            c3.setChecked(true);
        }
        if( id == R.id.textView4){
            if(c4.isChecked()){c4.setChecked(false);}else
            c4.setChecked(true);
        }
        if( id == R.id.textView5){
            if(c5.isChecked()){c5.setChecked(false);}else
            c5.setChecked(true);
        }

    }


}
