package com.example.ciceroneapp;

import java.util.ArrayList;
import java.util.List;

import ru.terrakok.cicerone.Router;

public class FirstPresenterImpl extends BasePresenter<FirstView> implements FirstPresenter {


    List<User> userList;

    public FirstPresenterImpl() {
        userList = new ArrayList<>();
    }

    @Override
    protected void onBackPressed() {
        mRouter.exit();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getUser() {
        userList = Condition.getUserList();
        view.setUser(userList);
    }

    @Override
    public void onSecondFragment(Integer id) {
        mRouter.navigateTo(new Screens.SecondScreen(id));
    }


}
