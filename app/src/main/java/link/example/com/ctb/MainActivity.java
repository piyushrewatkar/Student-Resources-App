package link.example.com.ctb;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SearchRecentSuggestionsProvider;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private ListView listView;
    FirebaseAuth mAuth;
    public String sem;
    TextView semester;
    ProgressDialog progressDialog;
    DatabaseReference databaseReference;
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mAuth=FirebaseAuth.getInstance();
        databaseReference= FirebaseDatabase.getInstance().getReference();
        uid=mAuth.getUid();
        semester=findViewById(R.id.current_semester);
        progressDialog=new ProgressDialog(this);


        DatabaseReference ref=databaseReference.child("users").child(uid).child("semester");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
//
                sem=dataSnapshot.getValue(String.class);
                semester=findViewById(R.id.current_semester);
                if(sem.equals("VI")){semester.setText("Sixth Semester");}
                if(sem.equals("VIII")){semester.setText("Eighth Semester");}
                if(sem.equals("IV")){semester.setText("Fourth Semester");}

//0.
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
//                Toast.makeText(MainActivity.this, "error "+databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }

        });


        setUIViews();
        setupListView();





    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
//            super.onBackPressed();
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
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you want to exit?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();
        }
//        finish();
//        if (exit) {
//            finish(); // finish activity
//        } else {
//            Toast.makeText(this, "Press Back again to Exit.",
//                    Toast.LENGTH_SHORT).show();
//            exit = true;
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    exit = false;
//                }
//            }, 3 * 1000);
//
//        }
    }
    //    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_about) {
            Toast.makeText(this, "CT DEPT Version 1.0", Toast.LENGTH_LONG).show();
            // Handle the camera action
        } else
        if (id == R.id.nav_developer) {
            Intent intent = new Intent(MainActivity.this, DeveloperActivity.class);
            startActivity(intent);
        }
        if (id == R.id.nav_logout) {

            DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    switch (which){
                        case DialogInterface.BUTTON_POSITIVE:
                            //Yes button clicked
                            mAuth.signOut();
                            finish();
                            startActivity(new Intent(MainActivity.this,LoginActivity.class));

                            break;

                        case DialogInterface.BUTTON_NEGATIVE:
                            //No button clicked


                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you want to logout?").setPositiveButton("Yes", dialogClickListener)
                    .setNegativeButton("No", dialogClickListener).show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void setUIViews(){
        toolbar= findViewById(R.id.ToolbarMain);
        listView= findViewById(R.id.lvMain);
//        toolbar.setTitle("Section B");

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){

                    Intent intent = new Intent(MainActivity.this, TimetableActivity.class);
                    startActivity(intent);
                }
                else if(i==1){
                    if(chkStatus()){
                    Intent intent = new Intent(MainActivity.this, SubjectsActivity.class);
                    startActivity(intent);
                    }}

                else if(i==2){

                    Intent intent = new Intent(MainActivity.this, AttendanceActivity.class);
                    startActivity(intent);
                }
                else if(i==3){
                    Intent intent = new Intent(MainActivity.this, FacultyActivity.class);
                    startActivity(intent);
                }
                else if(i==4){
                    Intent intent = new Intent(MainActivity.this, ResourceActivity.class);
                    startActivity(intent);
                }  else if(i==5){

                    Intent intent = new Intent(MainActivity.this, EventsActivity.class);
                    startActivity(intent);


                }

                }

        });

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


    private void setupListView(){
        String[] title = getResources().getStringArray(R.array.Main);
        String[] description= getResources().getStringArray(R.array.Description);

        SimpleAdapter simpleAdapter=new SimpleAdapter(this, title,description);
        listView.setAdapter(simpleAdapter);
    }
    public static class SimpleAdapter extends BaseAdapter {

        private Context mContext;
        private LayoutInflater layoutInflater;
        private TextView title, description;
        private String[] titleArray;
        private String[] descriptionArray;
        private ImageView imageView;

        public SimpleAdapter(Context context, String[] title, String[] description) {
            mContext = context;
            titleArray = title;
            descriptionArray = description;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return titleArray.length;
        }

        @Override
        public Object getItem(int position) {
            return titleArray[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.main_activity_single_item, null);
            }
            title = convertView.findViewById(R.id.tvMain);
            description = convertView.findViewById(R.id.tvDescription);
            imageView = convertView.findViewById(R.id.ivMain);

            title.setText(titleArray[position]);
            description.setText(descriptionArray[position]);

            if (titleArray[position].equalsIgnoreCase("Timetable")) {
                imageView.setImageResource(R.drawable.calendarday7);
            } else if (titleArray[position].equalsIgnoreCase("Subjects")) {
                imageView.setImageResource(R.drawable.booksstack);
            } else if (titleArray[position].equalsIgnoreCase("Faculty")) {
                imageView.setImageResource(R.drawable.teacher);
            } else if (titleArray[position].equalsIgnoreCase("Resources")) {
                imageView.setImageResource(R.drawable.youtube);
            } else if (titleArray[position].equalsIgnoreCase("Events")) {
                imageView.setImageResource(R.drawable.events);
            } else if (titleArray[position].equalsIgnoreCase("Attendance")) {
                imageView.setImageResource(R.drawable.icon);
            }
            return convertView;
        }
    }}




