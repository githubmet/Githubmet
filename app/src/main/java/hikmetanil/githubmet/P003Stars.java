package hikmetanil.githubmet;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;

import java.util.List;

import hikmetanil.githubmet.adapter.P003ArrayAdapter;
import hikmetanil.githubmet.communication.P003Interface;
import hikmetanil.githubmet.model.P003Strong;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class P003Stars extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("https://api.github.com");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        P003Interface p003Interface= retrofit.create(P003Interface.class);
        Call<List<P003Strong>> p003StrongListCall= p003Interface.p003StrongListCall("githubmet");

        p003StrongListCall.enqueue(new Callback<List<P003Strong>>() {
            @Override
            public void onResponse(Call<List<P003Strong>> call, Response<List<P003Strong>> response) {
                List<P003Strong> p003StrongList=response.body();
                P003ArrayAdapter p003ArrayAdapter=new P003ArrayAdapter(P003Stars.this,p003StrongList);
                setListAdapter(p003ArrayAdapter);
            }

            @Override
            public void onFailure(Call<List<P003Strong>> call, Throwable t) {

            }
        });
    }
}
