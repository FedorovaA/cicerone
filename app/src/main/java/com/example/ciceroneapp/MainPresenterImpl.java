package com.example.ciceroneapp;

import ru.terrakok.cicerone.Router;

public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    public MainPresenterImpl() {
    }

    @Override
    protected void onBackPressed() {
        mRouter.exit();
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onFirstFragment() {
        mRouter.navigateTo(new Screens.FirstScreen());
    }


}
