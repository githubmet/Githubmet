package hikmetanil.githubmet.communication;

import java.util.List;

import hikmetanil.githubmet.model.P004Strong;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface P004Interface {
    @GET("/users/{username}/followers")
    Call<List<P004Strong>> p004StrongListCall(@Path("username") String username);
}
