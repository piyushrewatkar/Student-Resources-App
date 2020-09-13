package link.example.com.ctb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SubjectsActivity extends AppCompatActivity {

    Button sub1,sub2,sub3,sub4,sub5,sub6,sub7,sub8;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    String uid,sem;
    ProgressDialog progressDialog;
    LinearLayout subjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);


        Toolbar toolbar= findViewById(R.id.toolbar);
//        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        progressDialog.setCancelable(false);

        subjects=findViewById(R.id.subjects);
        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        uid=mAuth.getUid();
        DatabaseReference ref=databaseReference.child("users").child(uid).child("semester");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                sem=dataSnapshot.getValue(String.class);
//                progressDialog.dismiss();
                setUI();

//
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(SubjectsActivity.this, "error "+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });

        sub1= findViewById(R.id.sub1);
        sub2=findViewById(R.id.sub2);
        sub3=findViewById(R.id.sub3);
        sub4=findViewById(R.id.sub4);
        sub5=findViewById(R.id.sub5);
        sub6=findViewById(R.id.sub6);
        sub7=findViewById(R.id.sub7);
        sub8=findViewById(R.id.sub8);

    }

    private void setUI() {
        if(sem.equals("VI")){
            sub1.setText("Fundamental of Management");
            sub2.setText("Design and Analysis of Algorithm");
            sub3.setText("Language Processors");
            sub4.setText("Software Engineering");
            sub5.setText("Mobile Operating System");
            sub6.setVisibility(View.VISIBLE);
            sub7.setVisibility(View.VISIBLE);
            sub8.setVisibility(View.VISIBLE);
            sub6.setText("Business Intelligence");
            sub7.setText("Geographical Information\n" +
                    "System");
            sub8.setText("Privacy and Security in Online Social Networks");
            progressDialog.dismiss();
            subjects.setVisibility(View.VISIBLE);
            setSubjects();
        }else
            if(sem.equals("IV")){
                sub1.setText("Computer Architecture And Organisation");
                sub2.setText("Discrete Mathematics & Graph");
                sub3.setText("Advanced Data Structures");
                sub4.setText("System Programming ");
                sub5.setText("Programming Language Concepts & " +
                        "Constructs");
//                sub6.setVisibility(View.GONE);
//                sub7.setVisibility(View.GONE);
//                sub8.setVisibility(View.GONE);
                progressDialog.dismiss();
                subjects.setVisibility(View.VISIBLE);
                setSubjects();
            }
            else
            if(sem.equals("VIII")){
                sub1.setText("Network Security");
                sub2.setText("Artificial Intelligence");
                sub3.setText("Embedded Systems");
                sub4.setText("Neural Network & Fuzzy Logic");
                sub5.setText("Ad-hoc Wireless Network");
                sub6.setVisibility(View.VISIBLE);
                sub7.setVisibility(View.VISIBLE);
                sub8.setVisibility(View.VISIBLE);
                sub6.setText("Cloud Computing");
                sub7.setText("Operations Research");
                sub8.setText("Parallel Computing");
                progressDialog.dismiss();
                subjects.setVisibility(View.VISIBLE);
                setSubjects();
            }
    }

    private void setSubjects() {
        Animation animation= AnimationUtils.loadAnimation(this,R.anim.hyperspace_jump);
        sub1.startAnimation(animation);
        Animation animation2=AnimationUtils.loadAnimation(this,R.anim.two);
        sub2.startAnimation(animation2);
        Animation animation3=AnimationUtils.loadAnimation(this,R.anim.three);
        sub3.startAnimation(animation3);
        Animation animation4=AnimationUtils.loadAnimation(this,R.anim.four);
        sub4.startAnimation(animation4);
        Animation animation5=AnimationUtils.loadAnimation(this,R.anim.five);
        sub5.startAnimation(animation5);
        Animation animation6=AnimationUtils.loadAnimation(this,R.anim.six);
        sub6.startAnimation(animation6);
        Animation animation7=AnimationUtils.loadAnimation(this,R.anim.seven);
        sub7.startAnimation(animation7);
        Animation animation8=AnimationUtils.loadAnimation(this,R.anim.eight);
        sub8.startAnimation(animation8);
    }

    public void sub_clicked(View view) {
        int id = view.getId();
        if (sem.equals("VI")) {
            if (id == R.id.sub1) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "fom");
                startActivity(intent);
            } else if (id == R.id.sub2) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "daa");
                startActivity(intent);
            } else if (id == R.id.sub3) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "lp");
                startActivity(intent);
            } else if (id == R.id.sub4) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "se");
                startActivity(intent);
            } else if (id == R.id.sub5) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "mos");
                startActivity(intent);
            } else if (id == R.id.sub6) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "bi");
                startActivity(intent);
            } else if (id == R.id.sub7) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "gis");
                startActivity(intent);
            } else if (id == R.id.sub8) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "psosn");
                startActivity(intent);
            }
            } else
                if (sem.equals("VIII")) {
            if (id == R.id.sub1) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "ns");
                startActivity(intent);
            } else if (id == R.id.sub2) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "ai");
                startActivity(intent);
            } else if (id == R.id.sub3) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "es");
                startActivity(intent);
            } else if (id == R.id.sub4) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "nnfl");
                startActivity(intent);
            } else if (id == R.id.sub5) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "awn");
                startActivity(intent);
            } else if (id == R.id.sub6) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "cc");
                startActivity(intent);
            } else if (id == R.id.sub7) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "or");
                startActivity(intent);
            } else if (id == R.id.sub8) {
                Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                intent.putExtra("subject", "pc");
                startActivity(intent);
            }

        }else
                if (sem.equals("IV")) {
                    if (id == R.id.sub1) {
                        Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                        intent.putExtra("subject", "cao");
                        startActivity(intent);
                    } else if (id == R.id.sub2) {
                        Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                        intent.putExtra("subject", "dmgt");
                        startActivity(intent);
                    } else if (id == R.id.sub3) {
                        Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                        intent.putExtra("subject", "ads");
                        startActivity(intent);
                    } else if (id == R.id.sub4) {
                        Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                        intent.putExtra("subject", "sp");
                        startActivity(intent);
                    } else if (id == R.id.sub5) {
                        Intent intent = new Intent(SubjectsActivity.this, SyllabusActivity.class);
                        intent.putExtra("subject", "plcc");
                        startActivity(intent);
                    }
                }
    }
}
