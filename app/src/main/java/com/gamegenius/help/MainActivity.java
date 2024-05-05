package com.gamegenius.help;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Window;

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
        
    }
}
