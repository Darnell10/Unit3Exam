package org.pursuit.unit_03_assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.pursuit.unit_03_assessment.R;
import org.pursuit.unit_03_assessment.controller.PlanetsAdapter;
import org.pursuit.unit_03_assessment.model.PlanetResponse;
import org.pursuit.unit_03_assessment.network.PlanetsAPI;
import org.pursuit.unit_03_assessment.network.RetrofitSingleton;
import org.pursuit.unit_03_assessment.model.Planets;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RecyclerActivity extends AppCompatActivity {

    private List<Planets> planetsList;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        recyclerView = findViewById(R.id.recycler_view_planets);

        Retrofit retrofit = RetrofitSingleton.getInstance();
        PlanetsAPI planetsAPI = retrofit.create(PlanetsAPI.class);
        Call<PlanetResponse> planetsAPICall = planetsAPI.getResponse();
        planetsAPICall.enqueue(new Callback<PlanetResponse>() {
            @Override
            public void onResponse(Call<PlanetResponse> call, Response<PlanetResponse> response) {
                planetsList = response.body().getPlanets();
                recyclerView.setAdapter(new PlanetsAdapter(planetsList));
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL, false));
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<PlanetResponse> call, Throwable t) {
                Log.v("uchiha", t.toString());

            }
        });



        /*
         * TODO: Add logic that will:
         * TODO 1. Make Retrofit instance for this endpoint: https://raw.githubusercontent.com/JDVila/storybook/master/planets.json
         * TODO 2. Make data model objects based on JSON
         * TODO 3. Make a service interface with method(s) to make a GET request
         * TODO 4. Make a request to the JSON endpoint using the Retrofit instance and the service
         * TODO 5. Subclass a RecyclerView Adapter
         * TODO 6. Subclass a RecyclerView ViewHolder
         * TODO 7. Pass list to RecyclerView
         * TODO 8. Display planet name in a RecyclerView tile
         * TODO 9. Implement an OnClickListener for the itemview
         * TODO 10. Pass the Planet Name, Number, and Image URL data to DisplayActivity when tile is clicked
         */

    }
}
