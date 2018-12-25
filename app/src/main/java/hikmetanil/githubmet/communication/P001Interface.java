package hikmetanil.githubmet.communication;

import hikmetanil.githubmet.model.P001Strong;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface P001Interface {

    @GET("/users/{username}")
    Call<P001Strong> getP001Strong(@Path("username") String username);
}
