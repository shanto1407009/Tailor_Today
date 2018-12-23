package today.tailor.tt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

public class Login extends AppCompatActivity {


    private LinearLayout Continue_;
    private LinearLayout LoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_login);

        init();
    }

    public void init()
    {

        //Toast.makeText(getApplicationContext(), String.valueOf(SplashScreen.FullProductImage.size()), Toast.LENGTH_SHORT).show();

        Continue_ = (LinearLayout) findViewById(R.id.continue_);
        LoginButton = (LinearLayout) findViewById(R.id.loginButton);



        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Upload.class);
                startActivity(intent);
            }
        });

        Continue_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainTab.class);
                startActivity(intent);
            }
        });

    }
}
