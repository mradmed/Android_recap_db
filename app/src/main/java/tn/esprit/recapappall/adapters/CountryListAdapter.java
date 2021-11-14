package tn.esprit.recapappall.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.entity.Country;

public class CountryListAdapter extends RecyclerView.Adapter<CountryListAdapter.WordViewHolder>  {

    private final ArrayList<Country> countries;
    private Context mContext;

    public CountryListAdapter(Context mContext, ArrayList<Country> countries) {
        this.mContext = mContext ;
        this.countries = countries;
    }

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = LayoutInflater.from(mContext).inflate(R.layout.country_list_item, parent, false);

        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        final Country singleItem = countries.get(position);

        holder.countryName.setText(singleItem.getName());

        holder.countryImage.setBackgroundResource(singleItem.getUrlPicture());

        holder.countryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext,singleItem.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class WordViewHolder extends RecyclerView.ViewHolder {

        public final TextView countryName;
        public final ImageView countryImage;
        final CountryListAdapter mAdapter;

        public WordViewHolder(@NonNull View itemView, CountryListAdapter mAdapter) {
            super(itemView);

            this.countryName = itemView.findViewById(R.id.countryName);
            this.countryImage = itemView.findViewById(R.id.countryImage);

            this.mAdapter = mAdapter;
        }

    }
}
