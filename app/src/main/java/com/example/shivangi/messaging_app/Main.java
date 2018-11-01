package com.example.shivangi.messaging_app;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;


public class Main extends AppCompatActivity {
    ImageView image;
    Button button;
    int clickcount;
    long start1;
    long end1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

    public void addListenerOnButton() {

        image = findViewById(R.id.imageView1);

        button = findViewById(R.id.btnChangeImage);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                clickcount=clickcount+1;
                if(clickcount%2==1)
                {
                    start1 = System.currentTimeMillis();
                    image.setImageResource(R.drawable.img2);
                    //Toast.makeText(getApplicationContext(),"Button clicked first time!", Toast.LENGTH_LONG).show();
                }
                else if(clickcount%2==0)
                {
                    end1 = System.currentTimeMillis();
                    image.setImageResource(R.drawable.img3);
                    //Toast.makeText(getApplicationContext(),"Button clicked count is"+clickcount, Toast.LENGTH_LONG).show();

                    long time = end1 - start1;
                    Log.d("TAG", Long.toString(time));
                    Toast.makeText(getApplicationContext(),"Time from one click to next: "+time, Toast.LENGTH_LONG).show();
                }

            }

        });

    }
}
