package com.example.a32gbfoodorderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class mainCourseList extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_course_list);


        lv = (ListView) findViewById(R.id.mainCourseList);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(mainCourseList.this, mainCourseDetail.class);
                Bundle b = new Bundle();
                b.putInt("mainCourseName", position);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }
    public void back(View view)
    {
        startActivity(new Intent(this,MainActivity.class));
    }
}
