package com.nocturnaldev.viewstubexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private ViewStub credentials;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        credentials = (ViewStub) findViewById(R.id.credentials);
    }
    
    public void onSkipClick(View view) {
        Toast.makeText(this, R.string.login_skipped, Toast.LENGTH_SHORT).show();
        finish();
    }
    
    public void onLogInClick(View view) {
        if (!isCredentialsVisible()) {
            credentials.inflate();
            Button button = (Button) view;
            button.setText(R.string.log_in);
        } else {
            TextView userName = (TextView) findViewById(R.id.user_name);
            TextView password = (TextView) findViewById(R.id.password);
            String toast = getString(R.string.credentials_entered, userName.getText(), password.getText());
            Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    private boolean isCredentialsVisible() {
        return credentials.getVisibility() == View.VISIBLE;
    }

}
