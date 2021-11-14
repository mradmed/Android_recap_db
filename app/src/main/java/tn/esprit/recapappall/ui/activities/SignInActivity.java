package tn.esprit.recapappall.ui.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.database.AppDataBase;
import tn.esprit.recapappall.entity.User;

public class SignInActivity extends AppCompatActivity {

    public static final String FNAME_KEY = "FNAME";
    public static final String LNAME_KEY = "LNAME";
    public static final String EMAIL_KEY = "EMAIL";

    public static final String PWD_KEY = "PWD";
    public static final String PHONE_KEY = "PHONE";
    public static final String CHECKED_KEY = "CHECKED";

    public static final String sharedPrefFile = "tn.esprit.recapappall";
    public static final String sharedPrefFile1 = "tn.esprit.recapappall1";
    public static final String sharedPrefFile2 = "tn.esprit.recapappall2";

    private AppDataBase database ;

    private SharedPreferences mPreferences;
    private EditText edSignInEmail, edSignInPassword;
    private CheckBox cbRememberMe;

    public static User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        database = AppDataBase.getAppDatabase(this);

        edSignInEmail = findViewById(R.id.edSignInEmail);
        edSignInPassword = findViewById(R.id.edSignInPassword);
        cbRememberMe = findViewById(R.id.cbRememberMe);

        //TODO 1 get SharedPref And set EditText
        mPreferences = getSharedPreferences(sharedPrefFile, MODE_PRIVATE);
//applo
        edSignInEmail.setText( mPreferences.getString(EMAIL_KEY,"") );
        edSignInPassword.setText( mPreferences.getString(PWD_KEY,"") );
        cbRememberMe.setChecked( mPreferences.getBoolean(CHECKED_KEY, false) );

    }

    public void goToSignUp(View view) {
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }

    public void doSignIn(View view) {
        if(validator()) {

            //TODO 3 Save SharedPref
            if (cbRememberMe.isChecked()){
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString(EMAIL_KEY, edSignInEmail.getText().toString());
                preferencesEditor.putString(PWD_KEY, edSignInPassword.getText().toString());
                preferencesEditor.putBoolean(CHECKED_KEY, true);
                preferencesEditor.apply();
            }else {
                SharedPreferences.Editor preferencesEditor = mPreferences.edit();
                preferencesEditor.putString(EMAIL_KEY, "");
                preferencesEditor.putString(PWD_KEY, "");
                preferencesEditor.putBoolean(CHECKED_KEY, false);

                //preferencesEditor.clear();
                preferencesEditor.apply();
            }

            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra(FNAME_KEY, currentUser.getFirstName());
            intent.putExtra(LNAME_KEY, currentUser.getLastName());
            intent.putExtra(EMAIL_KEY, currentUser.getEmail());
            intent.putExtra(PHONE_KEY, currentUser.getPhoneNumber());
            startActivity(intent);
            finish();
        }
    }

    public boolean validator(){

        if (edSignInEmail.getText().toString().length() == 0
                || edSignInPassword.getText().toString().length() == 0 ){
            Toast.makeText(this, "Email and password must not be empty !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!edSignInEmail.getText().toString().contains("@")){
            Toast.makeText(this, "Email is not valid !", Toast.LENGTH_SHORT).show();
            return false;
        }

        //TODO 2 Check user existance in database

        currentUser = database.userDao()
                .findByEmailAndPassword(
                        edSignInEmail.getText().toString(),
                        edSignInPassword.getText().toString());

        if (currentUser == null){
            Toast.makeText(this, "Wrong credential !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}
