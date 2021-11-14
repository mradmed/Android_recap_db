package tn.esprit.recapappall.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.entity.Country;

public class NewAdapter extends RecyclerView.Adapter<NewAdapter.NewClass> {

    List<Country>  countries ;
    Context mCtx;

    public NewAdapter(List<Country> countries, Context mCtx) {
        this.countries = countries;
        this.mCtx = mCtx;
    }

    @NonNull
    @Override
    public NewClass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mv = LayoutInflater.from(mCtx).inflate(R.layout.country_list_item,parent,false);

        return new NewClass(mv);
    }

    @Override
    public void onBindViewHolder(@NonNull NewClass holder, int position) {

        holder.img1.setBackgroundResource(countries.get(position).getUrlPicture());

    }

    @Override
    public int getItemCount() {
        return countries.size();
    }

    public class NewClass extends RecyclerView.ViewHolder {
        private TextView mt1;
        private ImageView img1;

        public NewClass(@NonNull View itemView) {
            super(itemView);
            mt1 = itemView.findViewById(R.id.countryName);
            img1 = itemView.findViewById(R.id.countryImage);
        }
    }
}
