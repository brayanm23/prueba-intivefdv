package com.example.intive_fdv.api.services;

import com.example.intive_fdv.api.callers.UsersApiCaller;
import com.example.intive_fdv.api.definitions.UserRestApi;

public class UserRestService extends AbstractRestService<UserRestApi>{

    private static UserRestService serviceInstance;

    @Override
    protected Class<UserRestApi> getRestApiDefinitionInterface() {
        return UserRestApi.class;
    }

    private static UserRestService getInstance() {
        serviceInstance = new UserRestService();
        return serviceInstance;
    }

    @Override
    protected String getServiceEndPoint() {
        return UserRestApi.url;
    }

    public static UsersApiCaller getUserApiCaller(Integer results, Integer page, String seed) {
        return new UsersApiCaller(getInstance().getService(), results, page, seed);
    }
}
