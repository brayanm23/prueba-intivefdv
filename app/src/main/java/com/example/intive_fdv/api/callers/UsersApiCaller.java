package com.example.intive_fdv.api.callers;

import com.example.intive_fdv.api.definitions.UserRestApi;
import com.example.intive_fdv.models.ListUserResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UsersApiCaller extends ApiCaller<UserRestApi> {

    private Integer results;

    public UsersApiCaller(UserRestApi api, Integer results) {
        super(api);
        this.results = results;
    }

    @Override
    public Observable<ListUserResponse> callApi() {
        return API.getUsers(results)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
