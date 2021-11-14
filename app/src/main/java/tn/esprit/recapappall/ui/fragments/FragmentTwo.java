package tn.esprit.recapappall.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.ui.activities.MainActivity;

public class FragmentTwo extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_two,container,false);

        Button openWebSite = rootView.findViewById(R.id.btn_openWeb);

        Button openCamera = rootView.findViewById(R.id.btn_openCamera);

        openCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE));
            }
        });

        openWebSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getArguments().getString(MainActivity.TAG_NUMBER))));
            }
        });

        return rootView;
    }
}
