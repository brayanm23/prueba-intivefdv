package com.example.intive_fdv.api.definitions;



import com.example.intive_fdv.models.ListUserResponse;
import com.example.intive_fdv.models.User;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserRestApi {

    public static String url = "https://randomuser.me/api/";

    @GET("1.2/")
    Observable<ListUserResponse> getUsers(@Query("results") Integer results);

}
