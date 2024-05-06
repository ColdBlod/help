package com.gamegenius.help;

import android.app.Activity;
import android.graphics.Color;
import android.icu.util.LocaleData;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends Activity{
    public Database db = new Database();
    public void onCreate(Bundle savedInstanceState){
        System.out.println("--------------------------app started---------------------------------------------------------------");
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        setContentView(R.layout.main);
        ini_main();
    }

    public void ini_main(){
        // inizialization
        Button math_semes = findViewById(R.id.main_math);
        Button russian = findViewById(R.id.main_russian);
        Button physis_semes = findViewById(R.id.main_physis);
        Button program_semes = findViewById(R.id.main_program);
        // end

        math_semes.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);calendar_math_semes();}});
        russian.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);russian();}});
        physis_semes.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);physis_semes();}});
        program_semes.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);programirovanie_semes();}});
    }

    public void calendar_math_semes(){
        // inzialization
        Button back = findViewById(R.id.calendar_back);
        Button list = findViewById(R.id.calendar_list);
        LinearLayout vert_ly = findViewById(R.id.calendar_calendar_vert);
        // end

        back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.main);ini_main();}});

        list.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.show_list);show_list(3);}});

        int today=-1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
            today = dateTime.getDayOfMonth();
            System.out.println(today);
        }


        for (int week=1;week<=6;week++){
            LinearLayout week_ly = new LinearLayout(getApplicationContext());
            week_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            for (int day=1;day<=7;day++){
                if (week != 1 ) {
                    if (week == 4 & day == 1) {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setText("20\n\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/");
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        week_ly.addView(day_ly);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32)
                            day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        System.out.println((today == week * 7 + day - 9));
                        if (today == week * 7 + day - 9)
                            day_ly.setText(String.valueOf(week * 7 + day - 9) + "\n\n\\\n  \\\n    \\/");
                        week_ly.addView(day_ly);
                    }
                } else {
                    if (day == 1 || day == 2){
                        TextView textView = new TextView(getApplicationContext());
                        textView.setText(String.valueOf(20-today) + " дней\nосталось");
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
                        week_ly.addView(textView);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32) day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        System.out.println((today == week * 7 + day - 9));
                        if (today == week * 7 + day - 9) {day_ly.setText(String.valueOf(week*7+day-9) + "\n\n\\\n  \\\n    \\/");}
                        week_ly.addView(day_ly);
                    }
                }
            }
            vert_ly.addView(week_ly);
        }
    }
    public void russian(){
        // inzialization
        Button back = findViewById(R.id.calendar_back);
        Button list = findViewById(R.id.calendar_list);
        LinearLayout vert_ly = findViewById(R.id.calendar_calendar_vert);
        // end

        back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.main);ini_main();}});

        list.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.show_list);show_list(2);}});

        int today=-1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
            today = dateTime.getDayOfMonth();
        }


        for (int week=1;week<=6;week++){
            LinearLayout week_ly = new LinearLayout(getApplicationContext());
            week_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            for (int day=1;day<=7;day++){
                if (week != 1 ) {
                    if (week == 3 & day == 1) {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setText("13\n\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/");
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        week_ly.addView(day_ly);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32)
                            day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        if (today == week * 7 + day - 9) day_ly.setText(String.valueOf(week * 7 + day - 9) + "\n\n\\\n  \\\n    \\/");
                        week_ly.addView(day_ly);
                    }
                } else {
                    if (day == 1 || day == 2){
                        TextView textView = new TextView(getApplicationContext());
                        textView.setText(String.valueOf(13-today) + " дней\nосталось");
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
                        week_ly.addView(textView);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32) day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        if (today == week * 7 + day - 9) {day_ly.setText(String.valueOf(week*7+day-9) + "\n\n\\\n  \\\n    \\/");}
                        week_ly.addView(day_ly);
                    }
                }
            }
            vert_ly.addView(week_ly);
        }
    }
    public void physis_semes(){
        // inzialization
        Button back = findViewById(R.id.calendar_back);
        Button list = findViewById(R.id.calendar_list);
        LinearLayout vert_ly = findViewById(R.id.calendar_calendar_vert);
        // end

        back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.main);ini_main();}});

        list.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.show_list);show_list(4);}});

        int today=-1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
            today = dateTime.getDayOfMonth();
        }


        for (int week=1;week<=6;week++){
            LinearLayout week_ly = new LinearLayout(getApplicationContext());
            week_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            for (int day=1;day<=7;day++){
                if (week != 1 ) {
                    if (week == 3 & day == 4) {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setText("16\n\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/");
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        week_ly.addView(day_ly);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32)
                            day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        if (today == week * 7 + day - 9) day_ly.setText(String.valueOf(week * 7 + day - 9) + "\n\n\\\n  \\\n    \\/");
                        week_ly.addView(day_ly);
                    }
                } else {
                    if (day == 1 || day == 2){
                        TextView textView = new TextView(getApplicationContext());
                        textView.setText(String.valueOf(16-today) + " дней\nосталось");
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
                        week_ly.addView(textView);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32) day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        if (today == week * 7 + day - 9) {day_ly.setText(String.valueOf(week*7+day-9) + "\n\n\\\n  \\\n    \\/");}
                        week_ly.addView(day_ly);
                    }
                }
            }
            vert_ly.addView(week_ly);
        }
    }
    public void programirovanie_semes(){
        // inzialization
        Button back = findViewById(R.id.calendar_back);
        Button list = findViewById(R.id.calendar_list);
        LinearLayout vert_ly = findViewById(R.id.calendar_calendar_vert);
        // end

        back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.main);ini_main();}});

        list.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.show_list);show_list(5);}});

        int today=-1;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            java.time.LocalDateTime dateTime = java.time.LocalDateTime.now();
            today = dateTime.getDayOfMonth();
        }


        for (int week=1;week<=6;week++){
            LinearLayout week_ly = new LinearLayout(getApplicationContext());
            week_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
            for (int day=1;day<=7;day++){
                if (week != 1 ) {
                    if (week == 3 & day == 6) {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setText("18\n\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/\\/\n\\/\\/\\/\\/");
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        week_ly.addView(day_ly);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32)
                            day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        if (today == week * 7 + day - 9) day_ly.setText(String.valueOf(week * 7 + day - 9) + "\n\n\\\n  \\\n    \\/");
                        week_ly.addView(day_ly);
                    }
                } else {
                    if (day == 1 || day == 2){
                        TextView textView = new TextView(getApplicationContext());
                        textView.setText(String.valueOf(18-today) + " дней\nосталось");
                        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, 1.0f));
                        week_ly.addView(textView);
                    } else {
                        Button day_ly = new Button(getApplicationContext());
                        day_ly.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1.0f));
                        day_ly.setGravity(Gravity.TOP);
                        if (week * 7 + day - 9 < 32) day_ly.setText(String.valueOf(week * 7 + day - 9));
                        else day_ly.setText(String.valueOf(week * 7 + day - 40));
                        if (today == week * 7 + day - 9) {day_ly.setText(String.valueOf(week*7+day-9) + "\n\n\\\n  \\\n    \\/");}
                        week_ly.addView(day_ly);
                    }
                }
            }
            vert_ly.addView(week_ly);
        }
    }

    public void show_list(int category){
        // inizialization
        Button back = findViewById(R.id.list_back);
        TextView textView = findViewById(R.id.list_text);
        // end
        String text="";
        if (category == 5){
            back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);programirovanie_semes();}});
            for (int i=0;i<db.program_semes.length;i++){
                text = text + (i+1) + ")" + db.program_semes[i] + "\n\n";
            }
            textView.setText(text);
        }
        if (category == 4){
            back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);physis_semes();}});
            for (int i=0;i<db.physis_semes.length;i++){
                text = text + (i+1) + ")" + db.physis_semes[i] + "\n\n";
            }
            textView.setText(text);
        }
        if (category == 2){
            back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);russian();}});
            for (int i=0;i<db.russian.length;i++){
                text = text + (i+1) + ")" + db.russian[i] + "\n\n";
            }
        textView.setText(text);
        }
        if (category == 3){
            back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);calendar_math_semes();}});
            for (int i=0;i<db.math_semes.length;i++){
                text = text + (i+1) + ")" + db.math_semes[i] + "\n\n";
            }
        }
        textView.setText(text);
    }
}
