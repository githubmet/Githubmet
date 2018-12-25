package hikmetanil.githubmet;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;

import java.util.List;

import hikmetanil.githubmet.adapter.P004ArrayAdapter;
import hikmetanil.githubmet.communication.P004Interface;
import hikmetanil.githubmet.model.P004Strong;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class P004Followers extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());
        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("https://api.github.com");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        P004Interface p004Interface=retrofit.create(P004Interface.class);
        Call<List<P004Strong>> p004StrongListCall= p004Interface.p004StrongListCall("githubmet");
        p004StrongListCall.enqueue(new Callback<List<P004Strong>>() {
            @Override
            public void onResponse(Call<List<P004Strong>> call, Response<List<P004Strong>> response) {
                List<P004Strong> p004StrongList= response.body();
                P004ArrayAdapter p004ArrayAdapter=new P004ArrayAdapter(P004Followers.this,p004StrongList);
                setListAdapter(p004ArrayAdapter);
            }

            @Override
            public void onFailure(Call<List<P004Strong>> call, Throwable t) {

            }
        });
    }
}
