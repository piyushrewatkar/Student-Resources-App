package link.example.com.ctb;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class FacultyScrollingActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_scrolling);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        toolbar.setNavigationIcon(R.mipmap.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });


        listView = findViewById(R.id.listview);
        setupList();
    }

    private void setupList() {
        String[] name= getResources().getStringArray(R.array.facultynames);
        String[] email=getResources().getStringArray(R.array.designation);

        FacultyScrollingActivity.SimpleAdapter simpleAdapter = new FacultyScrollingActivity.SimpleAdapter(this,name,email);
        listView.setAdapter(simpleAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
//                    AlertDialog.Builder builder=new AlertDialog.Builder(FacultyActivity.this);
//                    builder.setMessage("Phone no.- 8484649497\nEmail - smita7@gmail.com").setCancelable(true );
//                    AlertDialog alert = builder.create();
//                    alert.setTitle("Smita Rajesh Kapse");
//                    alert.show();

                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case DialogInterface.BUTTON_POSITIVE:
                                    //Yes button clicked
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:8793371195"));
                                    startActivity(intent);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
//                                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
//                                    sendIntent.setType("plain/text");
//                                    sendIntent.setData(Uri.parse("test@gmail.com"));
//                                    sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
//                                    sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "test@gmail.com" });
//                                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "test");
//                                    sendIntent.putExtra(Intent.EXTRA_TEXT, "hello. this is a message sent from my demo app :-)");
//                                    startActivity(sendIntent);
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(FacultyScrollingActivity.this);
                    builder.setTitle("Smita Rajesh Kapse");
                    builder.setMessage("Phone no.- 8484649497\nEmail - smita7@gmail.com").setPositiveButton("Call", dialogClickListener)
                            .setNegativeButton("Email", dialogClickListener).show();

                }
                if(i==1){
//                    AlertDialog.Builder builder=new AlertDialog.Builder(FacultyActivity.this);
//                    builder.setMessage("Phone no.- 8484649497\nEmail - smita7@gmail.com").setCancelable(true );
//                    AlertDialog alert = builder.create();
//                    alert.setTitle("Smita Rajesh Kapse");
//                    alert.show();

                    DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            switch (which){
                                case DialogInterface.BUTTON_POSITIVE:
                                    //Yes button clicked
                                    Intent intent = new Intent(Intent.ACTION_DIAL);
                                    intent.setData(Uri.parse("tel:8793371195"));
                                    startActivity(intent);
                                    break;

                                case DialogInterface.BUTTON_NEGATIVE:
                                    //No button clicked
                                    Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                                    sendIntent.setType("plain/text");
                                    sendIntent.setData(Uri.parse("test@gmail.com"));
                                    sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                                    sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "test@gmail.com" });
                                    sendIntent.putExtra(Intent.EXTRA_SUBJECT, "test");
                                    sendIntent.putExtra(Intent.EXTRA_TEXT, "hello. this is a message sent from my demo app :-)");
                                    startActivity(sendIntent);
                                    break;
                            }
                        }
                    };
                    AlertDialog.Builder builder = new AlertDialog.Builder(FacultyScrollingActivity.this);
                    builder.setMessage("Phone no.- 8484649497\nEmail - smita7@gmail.com").setPositiveButton("Call", dialogClickListener)
                            .setNegativeButton("Email", dialogClickListener).show();

                }
            }

        });



    }

    public class SimpleAdapter extends BaseAdapter {
        Context mcontext;
        TextView name,email,phone;
        String[] arrayName,arrayEmail,arrayPhone;
        LayoutInflater layoutInflater;
        ImageView imageView;
        public SimpleAdapter(Context context,String[] names,String[] emails){
            mcontext=context;
            arrayEmail=emails;
            arrayName=names;

            layoutInflater=LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return arrayName.length;
        }

        @Override
        public Object getItem(int i) {
            return arrayName[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            if(view==null){
                view=layoutInflater.inflate(R.layout.faculty_list,null);
            }
            name= view.findViewById(R.id.textView1);
            email= view.findViewById(R.id.textView2);
            imageView= view.findViewById(R.id.imageView);


            name.setText(arrayName[i]);
//            email.setText(arrayEmail[i]);


            if (arrayName[i].equalsIgnoreCase("Smita Rajesh Kapse")) {
                imageView.setImageResource(R.drawable.smita);
            }
            return view;
        }
    }
}
