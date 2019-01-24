package org.pursuit.unit_03_assessment.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static Retrofit singleInstance;

    private RetrofitSingleton(){}

    public static Retrofit getInstance (){
        if(singleInstance != null){
            return singleInstance;
        }else{
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://raw.githubusercontent.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            singleInstance = retrofit;
            return singleInstance;
        }

    }
}
