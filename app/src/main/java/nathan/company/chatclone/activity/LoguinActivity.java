package nathan.company.chatclone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import nathan.company.chatclone.R;


public class LoguinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loguin);
    }

    public void criaConta(View view){

        Intent intent = new Intent(LoguinActivity.this, cadastoActivity.class);
startActivity(intent);
    }

}