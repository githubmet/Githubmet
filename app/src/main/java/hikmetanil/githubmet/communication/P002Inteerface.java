package hikmetanil.githubmet.communication;

import java.util.List;

import hikmetanil.githubmet.model.P002Strong;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface P002Inteerface {

    @GET("/users/{username}/repos")
    Call<List<P002Strong>> p002StrongListCall (@Path("username") String username);
}
