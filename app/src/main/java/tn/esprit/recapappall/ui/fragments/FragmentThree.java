package tn.esprit.recapappall.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.adapters.UsersAdapter;
import tn.esprit.recapappall.database.AppDataBase;
import tn.esprit.recapappall.entity.User;

public class FragmentThree extends Fragment {

    private AppDataBase database ;

    private List<User> userList = new ArrayList<User>();

    private RecyclerView mRecyclerView;
    private UsersAdapter usersAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_three,container,false);

        database = AppDataBase.getAppDatabase(getActivity().getApplicationContext());

        mRecyclerView = rootView.findViewById(R.id.recycler_users);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        userList = database.userDao().getAll();

        usersAdapter = new UsersAdapter(getActivity(), userList);

        mRecyclerView.setAdapter(usersAdapter);


        return rootView;
    }
}
