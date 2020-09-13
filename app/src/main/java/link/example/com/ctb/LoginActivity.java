package link.example.com.ctb;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    public EditText email,password;
    ProgressDialog progressDialog;
    Button login;
    Button signup;
    DatabaseReference databaseReference;
    private FirebaseAuth.AuthStateListener mAuthListener;
    ImageView showpassword;

    int eye=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.et_email);
        password=findViewById(R.id.et_password);
        signup=findViewById(R.id.signUp);
        login=findViewById(R.id.login);
//        showsem=findViewById(R.id.showsem);
        databaseReference= FirebaseDatabase.getInstance().getReference();
        showpassword=findViewById(R.id.show_password);
        showpassword.setClickable(true);

        showpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(eye==1){
                showpassword.setImageResource(R.drawable.ic_eye);
                password.setTransformationMethod(null);
                eye=0;}else
                if(eye==0){
                    showpassword.setImageResource(R.drawable.ic_eye_closed);
                    eye=1;
                    password.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }


            }
        });


        progressDialog = new ProgressDialog(LoginActivity.this);


        signup.setClickable(true);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog.setMessage("Logging In...");
                progressDialog.show();
                progressDialog.setCancelable(false);
        if(chkStatus()){
                SignIn();}
                else{ progressDialog.dismiss();}


            }
        });


        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {



                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
//                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
//                    Toast.makeText(LoginActivity.this, "signed in", Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(LoginActivity.this,MainActivity.class);

                    startActivity(intent);
                } else {
                    // User is signed out
//                    Log.d(TAG, "onAuthStateChanged:signed_out");
//                    Toast.makeText(LoginActivity.this, "not signed in", Toast.LENGTH_SHORT).show();
                }
                // ...
            }
        };

    }
    @Override
    public void onBackPressed() {
//            finish();

        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which){
                    case DialogInterface.BUTTON_POSITIVE:
                        //Yes button clicked
                        finish();
//                            System.exit(0);
                        moveTaskToBack(true);
                        break;

                    case DialogInterface.BUTTON_NEGATIVE:
                        //No button clicked


                        break;
                }
            }
        };
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Do you want to exit?").setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();


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

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser firebaseUser=mAuth.getCurrentUser();
//        if (firebaseUser!=null){

//            Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//            startActivity(intent);
//        }
        mAuth.addAuthStateListener(mAuthListener);
    }



    private void SignIn(){
        String Email=email.getText().toString();
        String Password=password.getText().toString();


//        if(TextUtils.isEmpty(Email)||TextUtils.isEmpty(Password)){
//            progressDialog.dismiss();
//            Toast.makeText(this, "Empty fields", Toast.LENGTH_SHORT).show();
//        }
        if(TextUtils.isEmpty(Email)){progressDialog.dismiss();email.setError("Empty");}
        else if(TextUtils.isEmpty(Password)){progressDialog.dismiss();
            Toast.makeText(this, "Empty password", Toast.LENGTH_SHORT).show();}

        else {
            mAuth.signInWithEmailAndPassword(Email, Password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                progressDialog.dismiss();
//                                Toast.makeText(LoginActivity.this, "logged in.", Toast.LENGTH_SHORT).show();
                                finish();
                                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                                finish();
                                startActivity(intent);
                                finish();


                            } else {
                                // If sign in fails, display a message to the user.
                                progressDialog.dismiss();
                                Toast.makeText(LoginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                        }
                    });

        }
    }

}

