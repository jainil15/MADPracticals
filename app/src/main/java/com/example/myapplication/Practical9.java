package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

import java.util.concurrent.atomic.AtomicInteger;

public class Practical9 extends AppCompatActivity {

    private ImageView image_slide;
    private Button prevButton;
    private Button nextButton;

    String[] imageUrl = {
            "https://images.pexels.com/photos/459203/pexels-photo-459203.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            "https://images.pexels.com/photos/414612/pexels-photo-414612.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            "https://images.pexels.com/photos/417074/pexels-photo-417074.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            "https://images.pexels.com/photos/206359/pexels-photo-206359.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2",
            "https://images.pexels.com/photos/1266810/pexels-photo-1266810.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical9);

        image_slide = (ImageView) findViewById(R.id.image_slide);
        prevButton = (Button) findViewById(R.id.prevButton);
        nextButton = (Button) findViewById(R.id.nextButton);

        AtomicInteger i = new AtomicInteger(0);

        Picasso.get()
                .load(imageUrl[i.get()])
                .into(image_slide);

        nextButton.setOnClickListener(view -> {
            if (i.get() < imageUrl.length-1) {
                i.incrementAndGet();
                Log.d("TAG11", "onCreate: " + i);
                Picasso.get()
                        .load(imageUrl[i.get()])
                        .into(image_slide);
                Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
                image_slide.startAnimation(fadein);
            }

        });

        prevButton.setOnClickListener(view -> {
            if (i.get() > 0) {
                i.getAndDecrement();
                Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fadein);
                image_slide.startAnimation(fadein);
                Picasso.get()
                        .load(imageUrl[i.get()])
                        .into(image_slide);

            }

        });

    }
}
