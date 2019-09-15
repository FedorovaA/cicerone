package com.example.ciceroneapp;

import androidx.fragment.app.Fragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static final class FirstScreen extends SupportAppScreen {
        @Override
        public Fragment getFragment() {
            return FirstFragment.newInstance();
        }
    }

    public static final class SecondScreen extends SupportAppScreen {
        private final Integer number;

        public SecondScreen(Integer number) {
            this.number = number;
        }

        @Override
        public Fragment getFragment() {
            return SecondFragment.newInstance(number);
        }
    }
}
