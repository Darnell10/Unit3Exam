package org.pursuit.unit_03_assessment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.pursuit.unit_03_assessment.R;

public class LoginActivity extends AppCompatActivity {

    private EditText emailView;
    private EditText passwordView;
    private CheckBox usernameCheckbox;
    public static final String USERNAME_TAG = "username";
    public static final String PASSWORD_TAG = "password";
    public static final String SHARED_PREFS_KEY = "unit3Exam";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailView = (EditText) findViewById(R.id.email_edittext);
        passwordView = (EditText) findViewById(R.id.password_edittext);
        usernameCheckbox = (CheckBox) findViewById(R.id.remember_username_checkbox);
        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY,MODE_PRIVATE);
        passwordView.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int id, KeyEvent keyEvent) {
                if (id == EditorInfo.IME_ACTION_DONE || id == EditorInfo.IME_NULL) {
                    attemptLogin();
                    return true;
                }
                return false;
            }
        });

        if(!sharedPreferences.getString(USERNAME_TAG,"Error").equals("Error")){
            emailView.setText(sharedPreferences.getString(USERNAME_TAG,"error"));
            usernameCheckbox.setChecked(sharedPreferences.getBoolean(PASSWORD_TAG,false));
        }

        Button mEmailSignInButton = (Button) findViewById(R.id.email_sign_in_button);
        mEmailSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });
    }

    private void attemptLogin() {

        emailView.setError(null);
        passwordView.setError(null);

        String email = emailView.getText().toString();
        String password = passwordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            passwordView.setError(getString(R.string.error_invalid_password));
            focusView = passwordView;
            cancel = true;
        }
        if (TextUtils.isEmpty(email)) {
            emailView.setError(getString(R.string.error_field_required));
            focusView = emailView;
            cancel = true;
        } else if (!isEmailValid(email)) {
            emailView.setError(getString(R.string.error_invalid_email));
            focusView = emailView;
            cancel = true;
        } else {

            if(email.equals(getString(R.string.dummy_username)) && password.equals(getString(R.string.dummy_password))){
                if(usernameCheckbox.isChecked()){
                    sharedPreferences.edit()
                            .putString(USERNAME_TAG,email)
                            .putBoolean(PASSWORD_TAG,usernameCheckbox.isChecked()).apply();
                }else{
                    sharedPreferences.edit().clear().apply();
                }

                Intent intent = new Intent(LoginActivity.this,RecyclerActivity.class);
                startActivity(intent);

            }else{
                Toast.makeText(this, "NA Brah", Toast.LENGTH_SHORT).show();
            }
        }

        if (cancel) {
            focusView.requestFocus();
        }
    }

    private boolean isEmailValid(String email) {
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        return password.length() > 4;
    }
}

