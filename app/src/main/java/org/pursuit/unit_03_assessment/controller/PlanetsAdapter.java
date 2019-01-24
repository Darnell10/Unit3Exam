package org.pursuit.unit_03_assessment.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.pursuit.unit_03_assessment.R;

import org.pursuit.unit_03_assessment.model.Planets;
import org.pursuit.unit_03_assessment.view.PlanetsViewHolder;

import java.util.List;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsViewHolder> {
    private List<Planets> planetsList;

    public PlanetsAdapter(List<Planets> planetsList) {
        this.planetsList = planetsList;
    }

    @NonNull
    @Override
    public PlanetsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view_layout,viewGroup,false);
        return new PlanetsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetsViewHolder planetsViewHolder, int i) {
        Planets planets = planetsList.get(i);
        planetsViewHolder.onBind(planets);
    }

    @Override
    public int getItemCount() {
        return planetsList.size();
    }
}
