package lift.waibiwaibi.community.provider;

import lift.waibiwaibi.community.dto.AccessTokenDTO;
import lift.waibiwaibi.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO){
         MediaType JSON = MediaType.get("application/json; charset=utf-8");
         OkHttpClient client = new OkHttpClient();

         RequestBody body = RequestBody.create(json, JSON);
         Request request = new Request.Builder()
                    .url("https://github.com/login/oauth/access_token")
                    .post(body)
                    .build();

         try (Response response = client.newCall(request).execute()){
                 String string = response.body().string();
                 System.out.println(string);
                 return response.body().string();
             } catch (IOException e) {
             }
             return null;
    }
    public GithubUser getUser(String accessToken){
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token="+ accessToken)
                .build();

        try {
            Response response = client.newCall(request).execute();

        } catch (IOException e) {
        }

    }
}