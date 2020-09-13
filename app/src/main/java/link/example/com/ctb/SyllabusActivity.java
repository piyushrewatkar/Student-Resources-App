package link.example.com.ctb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class SyllabusActivity extends AppCompatActivity {
    String sub;
    TextView syllabus,subname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);

        Toolbar toolbar=(Toolbar) findViewById(R.id.toolbar);
//        toolbar.setTitle(R.string.app_name);
        toolbar.setNavigationIcon(R.mipmap.ic_arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                onBackPressed();
            }
        });
        syllabus=findViewById(R.id.syllabus);
        subname=findViewById(R.id.subname);
        sub=getIntent().getStringExtra("subject");
        if(sub.equals("fom")){
            subname.setText("Fundamental of Management");
            syllabus.setText("\nUnit 1: Principles of Management \n\nEvolution of Management Thought : Scientific, Classical, Neo Classical and Modern Theory of Management, Defintion Meaning and Concept of Management, Functions of Managment : Planning, Organizing, Directing Coordinating and Controlling. Motivation Theory, Leadership\n\nUnit 2: Legal Aspects of Management\n\nThe Indian Contract Act, 1872 – Formation of Valid Contract, Discharge of Contract, Quasi Contract, Indemnity and Guarantee. The Indian Partnership Act, 1932- Essentials of Partnership, Types of Partners, Right and Duties of Partners, Registration and Dissolution of firm, The Companies Act – Nature and Definition of Company, Registration and Incorporation, Memorandum and Article of Association, Kinds of companies, Directors : Powers and duties, Winding up of the Company \n\nUnit 3: Human Resource \n\nHuman Resource Management-Meaning, Nature and Scope, Principles of HRD, Human Resource Planning, Job Analysis – Job Description and Job Specification, Job Enrichment, Job Rotation, Training and Development – Purpose and Methods, Performance Appraisal- Purpose, Procedure and Techniques, Discipline and Grievance Procedure.\n\nUnit 4:Project management\n\nConcept, Classification and Characteristics of Project, Project Life Cycle, Project Proposal, Project Management, Tools and Techniques of Project Management, SWOT Analysis, Project Risk Analysis, Project cost, Project Planning, Project Control, Network techniques - Introduction and Use of CPM and PERT for planning. \n\nUnit 5: Marketing Management\n\nMarketing Management - Definition and scope, Selling and Modern Concepts of Marketing, Market Research, Rural Marketing, Marketing Environment, Customer Behaviors, Product Launching, Sales Promotion, Pricing, Channels of Distribution, Advertising, Market Segmentation, Marketing Mix, Positioning, Targeting\n\nUnit 6: Financial Management\n\nDefinition and Functions of Finance department, Sources of finance , Financing organizations, Types of capital, Profit maximization vs. Wealth maximization, Functions of Finance Manager in Modern Age, Concept of Risk and Return , Break Even Analysis, Budgets and Budgetary Control, Make or Buy Analysis, Introduction to financial statement – profit and loss A/c and Balance Sheet.\n\nTEXT BOOKS:\n\n" +
                    "1. S.C.Saxena, Business Management and Administration, Sahitya Bhawan Publication\n" +
                    "2. P. Subba Rao, Management -- Theory and Practice (Text and Cases) ( Himalaya Publication)\n" +
                    "3. Kuchhal M.C. - Business Law (Vikas Publication, 4 th Edition)\n" +
                    "4. P.S Rao , Essentials of Human Resource Managemen & IR, Himalaya , Mumbai\n5. Avraham Shtub and Jonathan F. Bard, Project Management: Processes, Methodologies, and Economics (2nd Edition)\n" +
                    "6. Kotler, Keller, Koshy & Jha, Marketing Management, Pearson, New Delhi\n" +
                    "7. R.K. Sharma, Shashi K Gupta, Management Accounting,. Kalyani Publishers. ");
        }else
        if(sub.equals("se")) {
            subname.setText("Software Engineering");

        }else
        if(sub.equals("psosn")) {
            subname.setText("Privacy and Security in Online Social Networks");

        }else
        if(sub.equals("gis")) {
            subname.setText("Geographical Information\n" +
                    "System");

        }else
        if(sub.equals("bi")) {
            subname.setText("Business Intelligence");

        }else
        if(sub.equals("mos")) {
            subname.setText("Mobile Operating System");

        }else
        if(sub.equals("lp")) {
            subname.setText("Language Processors");

        }
        if(sub.equals("daa")) {
            subname.setText("Design and Analysis of Algorithm");

        }
        if(sub.equals("ns")) {
            subname.setText("Network Security");

        }
        if(sub.equals("es")) {
            subname.setText("Embedded Systems");

        }
        if(sub.equals("ai")) {
            subname.setText("Artificial Intelligence");

        }
        if(sub.equals("cc")) {
            subname.setText("Cloud Computing");

        }
        if(sub.equals("nnfl")) {
            subname.setText("Neural Network & Fuzzy Logic");

        }
        if(sub.equals("pc")) {
            subname.setText("Parallel Computing");

        }
        if(sub.equals("awn")) {
            subname.setText("Ad-hoc Wireless Network");

        }
        if(sub.equals("or")) {
            subname.setText("Operations Research");

        }
        if(sub.equals("ads")) {
            subname.setText("Advanced Data Structures");

        }
        if(sub.equals("dmgt")) {
            subname.setText("Discrete Mathematics & Graph");

        }
        if(sub.equals("sp")) {
            subname.setText("System Programming");

        }
        if(sub.equals("cao")) {
            subname.setText("Computer Architecture And Organisation");

        }
        if(sub.equals("plcc")) {
            subname.setText("Programming Language Concepts & " +
                    "Constructs");

        }
    }
}
