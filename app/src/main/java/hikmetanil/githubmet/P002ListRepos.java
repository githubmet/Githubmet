package hikmetanil.githubmet;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;

import java.io.IOException;
import java.util.List;

import hikmetanil.githubmet.adapter.P002ArrayAdapter;
import hikmetanil.githubmet.communication.P002Inteerface;
import hikmetanil.githubmet.model.P002Strong;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class P002ListRepos extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("https://api.github.com");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();
        P002Inteerface p002Inteerface= retrofit.create(P002Inteerface.class);
        Call<List<P002Strong>> p002StrongListCall= p002Inteerface.p002StrongListCall("githubmet");

        p002StrongListCall.enqueue(new Callback<List<P002Strong>>() {
            @Override
            public void onResponse(Call<List<P002Strong>> call, Response<List<P002Strong>> response) {

                List<P002Strong> p002StrongList= response.body();
                ArrayAdapter arrayAdapter =new P002ArrayAdapter(P002ListRepos.this,p002StrongList);
                setListAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<P002Strong>> call, Throwable t) {

            }
        });


    }
}
