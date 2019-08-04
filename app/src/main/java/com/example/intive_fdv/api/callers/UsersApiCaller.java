package com.example.intive_fdv.api.callers;

import com.example.intive_fdv.api.definitions.UserRestApi;
import com.example.intive_fdv.models.ListUserResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class UsersApiCaller extends ApiCaller<UserRestApi> {

    private String seed;
    private Integer page;
    private Integer results;

    public UsersApiCaller(UserRestApi api, Integer results, Integer page, String seed) {
        super(api);
        this.results = results;
        this.page = page;
        this.seed = seed;
    }

    @Override
    public Observable<ListUserResponse> callApi() {
        return API.getUsers(results, page, seed)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
