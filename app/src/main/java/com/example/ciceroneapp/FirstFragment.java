package com.example.ciceroneapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;



public class FirstFragment extends Fragment implements FirstView {

    FirstPresenterImpl mFirstPresenter;
    UserAdapter mUserAdapter;

    UserAdapter.onClickListener mOnClickListener = new UserAdapter.onClickListener() {
        @Override
        public void onClick(Integer id) {
            mFirstPresenter.onSecondFragment(id);
//            SecondFragment secondFragment = SecondFragment.newInstance(id);
//            getFragmentManager().beginTransaction().add(R.id.container_frag, secondFragment).addToBackStack(null).commit();
        }
    };

    public FirstFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance() {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.rv);
        mUserAdapter = new UserAdapter(mOnClickListener);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(mUserAdapter);

        mFirstPresenter.getUser();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mFirstPresenter = new FirstPresenterImpl();
        mFirstPresenter.setView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mFirstPresenter = null;

    }

//    @Override
//    public boolean onBackPressed() {
//        mFirstPresenter.onBackPressed();
//        return true;
//    }

    @Override
    public void setUser(List<User> userList) {
        mUserAdapter.setList(userList);
    }
}
