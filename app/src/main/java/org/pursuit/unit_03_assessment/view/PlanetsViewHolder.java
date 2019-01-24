package org.pursuit.unit_03_assessment.view;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.pursuit.unit_03_assessment.DisplayActivity;
import org.pursuit.unit_03_assessment.model.Planets;
import org.pursuit.unit_03_assessment.R;

public class PlanetsViewHolder extends RecyclerView.ViewHolder {

    public static final String PLANETS_NAME = "PlanetsName";
    public static final String PLANETS_NUM = "PlanetsNum";
    public static final String PLANET_URL = "PlanetURL";

    private TextView planetNameTextView;

    public PlanetsViewHolder(@NonNull View itemView) {
        super(itemView);
        planetNameTextView = itemView.findViewById(R.id.planets_name);
    }

    public void onBind(final Planets planets){
        planetNameTextView.setText(planets.getName());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(itemView.getContext(),DisplayActivity.class);
                intent.putExtra(PLANETS_NAME, planets.getName());
                intent.putExtra(PLANETS_NUM, planets.getNumber());
                intent.putExtra(PLANET_URL,planets.getImage());
                itemView.getContext().startActivity(intent);

            }
        });

    }}
