package com.example.ciceroneapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class SecondFragment extends Fragment implements SecondView {
    private static final String ARG_PARAM1 = "param1";
    TextView txt;
    SecondPresenterImpl mSecondPresenter;

    // TODO: Rename and change types of parameters
    private Integer mParam1;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(Integer param1) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, String.valueOf(param1));
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = Integer.valueOf(getArguments().getString(ARG_PARAM1));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        txt = view.findViewById(R.id.txt_name);
        mSecondPresenter.getUser(mParam1);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mSecondPresenter = new SecondPresenterImpl();
        mSecondPresenter.setView(this);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mSecondPresenter = null;
    }

    @Override
    public void setUser(User user) {
        txt.setText(user.getName());
    }
//
//    @Override
//    public boolean onBackPressed() {
//        mSecondPresenter.onBackPressed();
//        return true;
//    }
}
