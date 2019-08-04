package com.example.intive_fdv.ui.home;

import android.content.Context;

import com.example.intive_fdv.R;
import com.example.intive_fdv.api.callers.UsersApiCaller;
import com.example.intive_fdv.api.observer.CallbackHandlingObserver;
import com.example.intive_fdv.api.services.UserRestService;
import com.example.intive_fdv.models.ListUserResponse;

public class HomePresenter implements HomeContract.Presenter {

    private Context context;
    private HomeContract.View mView;
    private CallbackHandlingObserver<ListUserResponse> observableUsers;


    public HomePresenter(Context context, HomeContract.View mView) {
        this.context = context;
        this.mView = mView;
    }


    @Override
    public void getUserService(Integer results, Integer page, String seed) {
        setObservableUsers();

        final UsersApiCaller caller = UserRestService.getUserApiCaller(results, page, seed);

        caller.callApi().subscribeWith(observableUsers);

    }

    private void setObservableUsers() {
        observableUsers = new CallbackHandlingObserver<ListUserResponse>(HomePresenter.this, UsersApiCaller.class) {
            @Override
            protected void onSuccess(ListUserResponse data) {
                mView.showUser(data.getUsers());
            }
        };
    }

    @Override
    public void onUnknownError(String error, Class caller) {
        if(caller.equals(UsersApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onTimeoutError(Class caller) {
        if(caller.equals(UsersApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_time_out));
        }
    }

    @Override
    public void onNetworkError(Class caller) {
        if(caller.equals(UsersApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_ocurred));
        }
    }

    @Override
    public void onBadRequestError(Class caller, String messageError) {
        if(caller.equals(UsersApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }

    @Override
    public void onServerError(Class caller) {
        if(caller.equals(UsersApiCaller.class)){
            mView.showErrorMessage(context.getString(R.string.error_accessing_server));
        }
    }
}
