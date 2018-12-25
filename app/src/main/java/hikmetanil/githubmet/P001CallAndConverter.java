package hikmetanil.githubmet;

import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;

import java.io.IOException;

import hikmetanil.githubmet.communication.P001Interface;
import hikmetanil.githubmet.model.P001Strong;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class P001CallAndConverter extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.p001call_and_converter);

        TextView textViewP001 = findViewById(R.id.textViewP001);
        TextView textView2P001 = findViewById(R.id.textView2P001);
        TextView textView3P001 = findViewById(R.id.textView3P001);
        TextView textView4P001 = findViewById(R.id.textView4P001);
        TextView textView5P001 = findViewById(R.id.textView5P001);
        TextView textView6P001 = findViewById(R.id.textView6P001);
        TextView textView7P001 = findViewById(R.id.textView7P001);
        TextView textView8P001 = findViewById(R.id.textView8P001);
        TextView textView9P001 = findViewById(R.id.textView9P001);
        TextView textView10P001 = findViewById(R.id.textView10P001);
        TextView textView11P001 = findViewById(R.id.textView11P001);
        TextView textView12P001 = findViewById(R.id.textView12P001);


        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        Retrofit.Builder builder = new Retrofit.Builder();
        builder.baseUrl("https://api.github.com");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        P001Interface p001Interface = retrofit.create(P001Interface.class);
        Call<P001Strong> p001StrongCall = p001Interface.getP001Strong("githubmet");
        try {
            P001Strong p001Strong = p001StrongCall.execute().body();
            textViewP001.setText("Id="+p001Strong.getId());
            textView2P001.setText("Login="+p001Strong.getLogin());
            textView3P001.setText("Avatar url="+p001Strong.getAvatar_url());
            textView4P001.setText("Html url="+p001Strong.getHtml_url());
            textView5P001.setText("Name="+p001Strong.getName());
            textView6P001.setText("Location="+p001Strong.getLocation());
            textView7P001.setText("Bio="+p001Strong.getBio());
            textView8P001.setText("Repos="+p001Strong.getPublic_repos());
            textView9P001.setText("Gists="+p001Strong.getPublic_gists());
            textView10P001.setText("Followers="+p001Strong.getFollowers());
            textView11P001.setText("Following="+p001Strong.getFollowing());
            textView12P001.setText("Created at="+p001Strong.getCreated_at());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

