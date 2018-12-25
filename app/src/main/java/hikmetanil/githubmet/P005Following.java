package hikmetanil.githubmet;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.ArrayAdapter;

import java.util.List;

import hikmetanil.githubmet.adapter.P005ArrayAdapter;
import hikmetanil.githubmet.communication.P005Interface;
import hikmetanil.githubmet.model.P005Strong;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class P005Following extends ListActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().build());

        Retrofit.Builder builder=new Retrofit.Builder();
        builder.baseUrl("https://api.github.com");
        builder.addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit= builder.build();

        P005Interface p005Interface= retrofit.create(P005Interface.class);
        Call<List<P005Strong>> p005StrongListCall=p005Interface.p005StrongListCall("githubmet");

        p005StrongListCall.enqueue(new Callback<List<P005Strong>>() {
            @Override
            public void onResponse(Call<List<P005Strong>> call, Response<List<P005Strong>> response) {
                List<P005Strong> p005StrongList= response.body();
                ArrayAdapter arrayAdapter=new P005ArrayAdapter(P005Following.this,p005StrongList);
                setListAdapter(arrayAdapter);
            }

            @Override
            public void onFailure(Call<List<P005Strong>> call, Throwable t) {

            }
        });
    }
}
