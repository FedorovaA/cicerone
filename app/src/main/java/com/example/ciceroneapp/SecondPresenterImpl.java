package com.example.ciceroneapp;

import ru.terrakok.cicerone.Router;

public class SecondPresenterImpl extends BasePresenter<SecondView> implements SecondPresenter {
    User mUser;

    public SecondPresenterImpl() {
    }

    @Override
    protected void onBackPressed() {
        mRouter.exit();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void getUser(Integer id) {
        mUser = Condition.getUserList().get(1);
        view.setUser(mUser);
    }

}
