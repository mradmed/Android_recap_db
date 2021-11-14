package tn.esprit.recapappall.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.ui.fragments.FragmentOne;
import tn.esprit.recapappall.ui.fragments.FragmentThree;
import tn.esprit.recapappall.ui.fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 10;
    public static final String TAG_NUMBER = "NUMBER";

    private TextView txtFirstName, txtLastName,txtEmail,txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtFirstName = findViewById(R.id.txtMainFirstName);
        txtLastName = findViewById(R.id.txtMainLastName);
        txtEmail = findViewById(R.id.txtMainEmail);
        txtPhoneNumber = findViewById(R.id.txtMainPhoneNumber);
        checkAndFillData(getIntent());

        showFragment(new FragmentOne());

    }

    public void goToUpdateProfile(View view) {
        Intent intent = new Intent(this, UpdateProfileActivity.class);
        intent.putExtra(SignInActivity.FNAME_KEY, txtFirstName.getText().toString());
        intent.putExtra(SignInActivity.LNAME_KEY, txtLastName.getText().toString());
        intent.putExtra(SignInActivity.EMAIL_KEY, txtEmail.getText().toString());
        intent.putExtra(SignInActivity.PHONE_KEY, txtPhoneNumber.getText().toString());
        startActivityForResult(intent, REQUEST_CODE);
    }

    public void showFragment(Fragment fragment){
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,fragment)
                .commit();
    }

    public void openFragOne(View view) {
        showFragment(new FragmentOne());
    }

    public void openFragTwo(View view) {
        Bundle bundle = new Bundle();
        bundle.putString(TAG_NUMBER, txtPhoneNumber.getText().toString());
        FragmentTwo fragmentTwo = new FragmentTwo();
        fragmentTwo.setArguments(bundle);
        showFragment(fragmentTwo);
    }

    public void openFragThree(View view) {
        showFragment(new FragmentThree());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE  && resultCode == RESULT_OK){
            checkAndFillData(data);
        }
    }

    public void checkAndFillData(Intent intent){

        if( intent.hasExtra(SignInActivity.FNAME_KEY) ){
            txtFirstName.setText( intent.getStringExtra(SignInActivity.FNAME_KEY));
        }

        if( intent.hasExtra(SignInActivity.LNAME_KEY) ){
            txtLastName.setText( intent.getStringExtra(SignInActivity.LNAME_KEY));
        }

        if( intent.hasExtra(SignInActivity.EMAIL_KEY) ){
            txtEmail.setText( intent.getStringExtra(SignInActivity.EMAIL_KEY));
        }

        if( intent.hasExtra(SignInActivity.PHONE_KEY) ){
            txtPhoneNumber.setText( String.valueOf(intent.getIntExtra(SignInActivity.PHONE_KEY, 0)));
        }
    }
}
