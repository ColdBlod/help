package com.gamegenius.help;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.QuickContactBadge;
import android.widget.TextView;

public class MainActivity extends Activity{
    public Database db = new Database();
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);
        setContentView(R.layout.main);
        ini_main();
    }

    public void ini_main(){
        // inizialization
        Button math_semes = findViewById(R.id.main_math);
        // end

        math_semes.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);calendar_math_semes();}});
    }

    public void calendar_math_semes(){
        // inzialization
        Button back = findViewById(R.id.calendar_back);
        Button list = findViewById(R.id.calendar_list);
        LinearLayout vert_ly = findViewById(R.id.calendar_calendar_vert);
        // end

        back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.main);ini_main();}});

        list.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.show_list);show_list(3);}});
    }

    public void show_list(int category){
        // inizialization
        Button back = findViewById(R.id.list_back);
        TextView textView = findViewById(R.id.list_text);
        // end
        String text="";
        if (category == 3){
            back.setOnClickListener(new View.OnClickListener() {@Override public void onClick(View v) {setContentView(R.layout.calendar);calendar_math_semes();}});
            for (int i=0;i<db.math_semes.length;i++){
                text = text + (i+1) + ")" + db.math_semes[i] + "\n\n";
            }
        }
        textView.setText(text);
    }
}
