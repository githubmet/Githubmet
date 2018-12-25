package hikmetanil.githubmet.communication;

import java.util.List;

import hikmetanil.githubmet.model.P003Strong;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface P003Interface  {

    @GET("/users/{username}/starred")
    Call<List<P003Strong>> p003StrongListCall(@Path("username") String username);
}
