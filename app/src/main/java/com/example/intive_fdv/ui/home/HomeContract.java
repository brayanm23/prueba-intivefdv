package com.example.intive_fdv.ui.home;

import com.example.intive_fdv.api.observer.BaseContract;
import com.example.intive_fdv.models.User;
import java.util.List;

public interface HomeContract {

    interface View {

        void showUser(List<User> users);

        void showErrorMessage(String message);

    }

    interface Presenter extends BaseContract.ServicePresenter{

        void getUserService(Integer results);

    }
}
