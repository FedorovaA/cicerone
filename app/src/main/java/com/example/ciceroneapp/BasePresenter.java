package com.example.ciceroneapp;

import ru.terrakok.cicerone.Router;

public abstract class BasePresenter<T extends BaseView> implements LifePresenter {
    protected T view;
    protected Router mRouter;

    public BasePresenter() {
    }

    public void setView(T view) {
        this.view = view;
        mRouter = App.INSTANCE.getRouter();
    }

    protected abstract void onBackPressed();

}
