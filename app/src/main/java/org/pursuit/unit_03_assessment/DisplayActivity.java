package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.view.PlanetsViewHolder;

public class DisplayActivity extends AppCompatActivity {

    private TextView planetName;
    private TextView planetNum;
    private ImageView planetImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        planetName = findViewById(R.id.display_planets_name);
        planetImage = findViewById(R.id.display_planets_image);
        planetNum = findViewById(R.id.display_planets_number);

        Intent intent = getIntent();
        String planetNameString = intent.getStringExtra(PlanetsViewHolder.PLANETS_NAME);
        String planetsImageString = intent.getStringExtra(PlanetsViewHolder.PLANET_URL);
        Integer planetsNumberInt = intent.getIntExtra(PlanetsViewHolder.PLANETS_NUM,-1);

        planetName.setText(planetNameString);
        Picasso.get().load(planetsImageString).into(planetImage);
        planetNum.setText(String.valueOf(planetsNumberInt));

        /*
        * TODO: Add logic that will:
        * TODO 1. Receive values from sending intent
        * TODO 2. Create a TextView instance for the Planet Name
        * TODO 3. Create a TextView instance for the Planet Number count
        * TODO 4. Create an ImageView for the image url
        * TODO 5. Display each value in views - Strings for TextViews, and Picasso for the ImageView
        */
    }
}
