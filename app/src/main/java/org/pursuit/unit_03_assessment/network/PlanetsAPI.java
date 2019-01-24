package org.pursuit.unit_03_assessment.network;

import org.pursuit.unit_03_assessment.model.PlanetResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PlanetsAPI{

    @GET("JDVila/storybook/master/planets.json")
    Call<PlanetResponse> getResponse();
}
