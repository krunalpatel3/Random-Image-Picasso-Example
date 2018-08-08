package krunal.com.example.picassoapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private ImageView mImageView;

    private Button mNext;

    private TextView mConnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);

        mNext = findViewById(R.id.buttonNext);

        mConnection = findViewById(R.id.textViewInternet);

        // Check for internet Connection.
        if (isNetworkAvailable()){
            mConnection.setVisibility(View.GONE);
            mImageView.setVisibility(View.VISIBLE);
            mNext.setVisibility(View.VISIBLE);

            mNext.setOnClickListener(v -> {
                if (isNetworkAvailable()){
                    // get image from url set it to imageView.
                    Picasso.get().load(Utility.getWebUrl()).into(mImageView);
                }else {
                    // if there is No Internet Connection then we set imageView and button to gone.
                    mConnection.setVisibility(View.VISIBLE);
                    mImageView.setVisibility(View.GONE);
                    mNext.setVisibility(View.GONE);
                }

            });

        }else {
            // if there is No Internet Connection then we set imageView and button to gone.
            mConnection.setVisibility(View.VISIBLE);
            mImageView.setVisibility(View.GONE);
            mNext.setVisibility(View.GONE);
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
