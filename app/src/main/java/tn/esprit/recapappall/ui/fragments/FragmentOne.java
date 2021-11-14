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

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.adapters.CountryListAdapter;
import tn.esprit.recapappall.entity.Country;

public class FragmentOne extends Fragment {

    private RecyclerView recyclerView;
    private ArrayList<Country> countries = new ArrayList<Country>();
    private CountryListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container,false);

        recyclerView = rootView.findViewById(R.id.recycler_list);

        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.VERTICAL, false));

        fillData();

        mAdapter = new CountryListAdapter(getActivity(), countries);

        recyclerView.setAdapter(mAdapter);

        return rootView;
    }

    public void fillData(){
        countries.add(new Country(1,"Algeria", R.drawable.algeria));
        countries.add(new Country(2,"Argentina", R.drawable.argentina));
        countries.add(new Country(3,"Australia", R.drawable.australia));
        countries.add(new Country(4,"Belgium", R.drawable.belgium));
        countries.add(new Country(5,"Brazil", R.drawable.brazil));
        countries.add(new Country(6,"Cameroon", R.drawable.cameroon));
        countries.add(new Country(7,"Canada", R.drawable.canada));
        countries.add(new Country(8,"Colombia", R.drawable.colombia));
        countries.add(new Country(9,"Croatia", R.drawable.croatia));
        countries.add(new Country(10,"Egypt", R.drawable.egypt));
        countries.add(new Country(11,"England", R.drawable.england));
        countries.add(new Country(12,"France", R.drawable.france));
        countries.add(new Country(13,"Germany", R.drawable.germany));
        countries.add(new Country(14,"Japan", R.drawable.japan));
        countries.add(new Country(15,"Spain", R.drawable.spain));
        countries.add(new Country(16,"Switzerland", R.drawable.switzerland));
        countries.add(new Country(17,"Tunisia", R.drawable.tunisia));
        countries.add(new Country(18,"Turkey", R.drawable.turkey));
        countries.add(new Country(19,"United State Of America", R.drawable.usa));
    }
}
