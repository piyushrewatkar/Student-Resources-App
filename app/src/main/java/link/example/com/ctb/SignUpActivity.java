package link.example.com.ctb;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText email,password,rpassword;
   private Button signup;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    FirebaseAuth.AuthStateListener mauthListener;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        Toolbar t = findViewById(R.id.toolbar);
        t.setNavigationIcon(R.mipmap.ic_arrow);
        t.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        mAuth=FirebaseAuth.getInstance();
        progressDialog=new ProgressDialog(this);
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        rpassword=findViewById(R.id.et_rpassword);
        spinner=findViewById(R.id.sem);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        signup=findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Registering User...");
                progressDialog.setCancelable(false);
                progressDialog.show();
                Signup();

            }
        });
//        mauthListener=new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                if(firebaseAuth.getCurrentUser()!=null){
//                    progressDialog.dismiss();
//
//                    Toast.makeText(SignUpActivity.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
//                    startActivity(new Intent(SignUpActivity.this,MainActivity.class));
//
//
//                }
//            }
//        };


    }
//    @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        mAuth.addAuthStateListener(mauthListener);
//
//    }
    private void Signup(){

        String Email=email.getText().toString();
        String Pass=password.getText().toString();
        String Rpass=rpassword.getText().toString();
        final String semester= (String)  spinner.getSelectedItem();
//        Toast.makeText(this, ""+semester, Toast.LENGTH_SHORT).show();

        if(TextUtils.isEmpty(Email)||TextUtils.isEmpty(Pass)||TextUtils.isEmpty(Rpass)){
            progressDialog.dismiss();

            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
        }else if(Pass.equals(Rpass)){
        mAuth.createUserWithEmailAndPassword(Email, Pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            progressDialog.dismiss();
                            // Sign in success, update UI with the signed-in user's information
////                            Log.d(TAG, "createUserWithEmail:success");
                            usersemester user = new usersemester(semester);
                            databaseReference.child("users").child(String.valueOf(mAuth.getUid())).setValue(user);
//                            DatabaseReference ref=databaseReference.child("users").push();
//                            ref.child("semester").setValue(semester);
                            Toast.makeText(SignUpActivity.this, "Registered. Please Login", Toast.LENGTH_SHORT).show();
                            finish();
                            mAuth.signOut();
                            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
//                            FirebaseUser user = mAuth.getCurrentUser();


                        } else {
                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            progressDialog.dismiss();
                            Toast.makeText(SignUpActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }else{progressDialog.dismiss();
            Toast.makeText(this, "Passwords don't match.", Toast.LENGTH_SHORT).show();
        }
    }
}
