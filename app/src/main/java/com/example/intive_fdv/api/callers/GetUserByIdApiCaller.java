package com.example.intive_fdv.api.callers;

import com.example.intive_fdv.api.definitions.UserRestApi;

import io.reactivex.Observable;

public class GetUserByIdApiCaller extends ApiCaller<UserRestApi> {

    public GetUserByIdApiCaller(UserRestApi api) {
        super(api);
    }

    @Override
    public Observable<?> callApi() {
        return null;
    }
}
