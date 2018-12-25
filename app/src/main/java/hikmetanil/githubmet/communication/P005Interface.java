package hikmetanil.githubmet.communication;

import java.util.List;

import hikmetanil.githubmet.model.P005Strong;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface P005Interface {

    @GET("/users/{username}/following")
    Call<List<P005Strong>> p005StrongListCall(@Path("username") String username);


}
