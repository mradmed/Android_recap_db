package tn.esprit.recapappall.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import tn.esprit.recapappall.R;

public class UpdateProfileActivity extends AppCompatActivity {

    private EditText txtLastName, txtFirstName, txtEmail, txtPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        txtLastName = findViewById(R.id.ed_last_name);
        txtFirstName = findViewById(R.id.ed_first_name);
        txtEmail = findViewById(R.id.ed_email);
        txtPhoneNumber = findViewById(R.id.ed_phone_number);

        Button btn_next = findViewById(R.id.btn_save);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(SignInActivity.LNAME_KEY, txtLastName.getText().toString());
                intent.putExtra(SignInActivity.FNAME_KEY, txtFirstName.getText().toString());
                intent.putExtra(SignInActivity.EMAIL_KEY, txtEmail.getText().toString());
                intent.putExtra(SignInActivity.PHONE_KEY, Integer.parseInt(txtPhoneNumber.getText().toString()));
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        checkAndFillData(getIntent());

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
            txtPhoneNumber.setText( intent.getStringExtra(SignInActivity.PHONE_KEY));
        }
    }

    @Override
    public void finish() {
        super.finish();
    }
}
