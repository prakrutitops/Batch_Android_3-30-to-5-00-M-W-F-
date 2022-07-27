package com.example.retrofitex;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Apiinterface
{
    //Annotation
    @FormUrlEncoded
    @POST("mobileproductinsert.php")
    Call<Model> insertdata
    (
            @Field("p_name")  String prodct_name,
            @Field("p_price") String product_price,
            @Field("p_des") String product_description
    );


    @GET("mobileview.php")
    Call<List<Model>> viewdata();
}
