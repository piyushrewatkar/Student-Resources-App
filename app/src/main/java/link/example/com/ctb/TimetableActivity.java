package link.example.com.ctb;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TimetableActivity extends AppCompatActivity {
    private ExpandableListView listview;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String,List<String>> listHash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timetable);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        listview = (ExpandableListView)findViewById(R.id.lvExp);
        initData();
        listAdapter = new ExpandableListAdapter(this,listDataHeader,listHash);
        listview.setAdapter(listAdapter);
        listview.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i1, long l) {
//                if(i==0 && i1==0){
//                    Intent intent = new Intent(TimetableActivity.this,SyllabusActivity.class );
//                startActivity(intent);}
                return true;
            }
        });
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("MONDAY");
        listDataHeader.add("TUESDAY");
        listDataHeader.add("WEDNESDAY");
        listDataHeader.add("THURSDAY");
        listDataHeader.add("FRIDAY");
        listDataHeader.add("SATURDAY");

        List<String> monday = new ArrayList<>();
        monday.add("8-9am MOS/BI/GIS/PSONS");
        monday.add("9-10am MOS/BI/GIS/PSONS");
        monday.add("10-11pm Open Elective");
        monday.add("12-1pm Language Processor");
        monday.add("1-2pm Design and Analysis of Alogorithm");
        monday.add("2-3pm Fundamental of Managenement");

        List<String> tuesday = new ArrayList<>();
        tuesday.add("8-9am GRAMMER");
        tuesday.add("9-10am Fundamental of Managenement");
        tuesday.add("10-11pm Open Elective");
        tuesday.add("12-1pm Sotware Engineering");
        tuesday.add("1-2pm SE/LP Lab");
        tuesday.add("2-3pm SE/LP Lab");


        List<String> wednesday = new ArrayList<>();
        wednesday.add("8-9am SE/LP Lab");
        wednesday.add("9-10am SE/LP Lab");
        wednesday.add("10-11pm Open Elective");
        wednesday.add("12-1pm GRAMMER");
        wednesday.add("1-2pm Software Engineering");
        wednesday.add("2-3pm Design and Analysis of Alogorithm");


        List<String> thursday = new ArrayList<>();
        thursday.add("8-9am MOS/BI/GIS/PSONS");
        thursday.add("9-10am MOS/BI/GIS/PSONS");
        thursday.add("11-12pm Software Engineering");
        thursday.add("12-1pm Language Processor");
        thursday.add("1-2pm SE/LP Lab");
        thursday.add("2-3pm SE/LP Lab");


        List<String> friday = new ArrayList<>();
        friday.add("8-9am MOS/BI/GIS/PSONS");
        friday.add("9-10am MOS/BI/GIS/PSONS");
        friday.add("11-12pm Design and Analysis of Alogorithm");
        friday.add("12-1pm Language Processor");
        friday.add("1-2pm BI/PSONS Lab");
        friday.add("2-3pm BI/PSONS Lab");


        List<String> saturday = new ArrayList<>();
        saturday.add("8-9am Fundamental of Managenement");
        saturday.add("9-10am Language Processor");
        saturday.add("10-11pm Design and Analysis of Alogorithm");
        saturday.add("11-12pm GRAMMER");
        saturday.add("12-1pm Software Engineering");
//        saturday.add("2-3pm Software Engineering Lab");
        listHash.put(listDataHeader.get(0),monday);
        listHash.put(listDataHeader.get(1),tuesday);
        listHash.put(listDataHeader.get(2),wednesday);
        listHash.put(listDataHeader.get(3),thursday);
        listHash.put(listDataHeader.get(4),friday);
        listHash.put(listDataHeader.get(5),saturday);


    }
}
