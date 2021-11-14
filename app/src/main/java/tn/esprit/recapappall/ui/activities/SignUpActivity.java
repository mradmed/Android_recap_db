package tn.esprit.recapappall.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import tn.esprit.recapappall.R;
import tn.esprit.recapappall.database.AppDataBase;
import tn.esprit.recapappall.entity.User;

public class SignUpActivity extends AppCompatActivity {

    private AppDataBase database ;
    private EditText edSignUpFirstName, edSignUpLastName, edSignUpEmail, edSignUpPassword, edSignUpPhoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        database = AppDataBase.getAppDatabase(this);

        edSignUpFirstName = findViewById(R.id.edSignUpFirstName);
        edSignUpLastName = findViewById(R.id.edSignUpLastName);
        edSignUpEmail = findViewById(R.id.edSignUpEmail);
        edSignUpPassword = findViewById(R.id.edSignUpPassword);
        edSignUpPhoneNumber = findViewById(R.id.edSignUpPhoneNumber);

    }

    public void doSignUp(View view) {

        if(validator()) {
            //TODO CHECK EMAIL AND ADD USER

            User tmpUser = new User(edSignUpFirstName.getText().toString(), edSignUpLastName.getText().toString(),
                    edSignUpEmail.getText().toString(), edSignUpPassword.getText().toString(),
                    Integer.parseInt(edSignUpPhoneNumber.getText().toString()));

            database.userDao().insertOne(tmpUser);

            finish();
        }
    }


    public boolean validator(){

        if (edSignUpFirstName.getText().toString().length() == 0
                || edSignUpLastName.getText().toString().length() == 0
                || edSignUpEmail.getText().toString().length() == 0
                || edSignUpPassword.getText().toString().length() == 0
                || edSignUpPhoneNumber.getText().toString().length() == 0){
            Toast.makeText(this, "Data must not be empty !", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (!edSignUpEmail.getText().toString().contains("@")){
            Toast.makeText(this, "Email is not valid !", Toast.LENGTH_SHORT).show();
            return false;
        }

        //TODO 2 Check user existance in database

        User tmpUser = AppDataBase.getAppDatabase(getApplicationContext()).userDao().findByEmail(edSignUpEmail.getText().toString());

        if (tmpUser != null){
            Toast.makeText(this, "User exist in database !", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

}
