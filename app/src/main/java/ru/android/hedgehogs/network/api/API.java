package ru.android.hedgehogs.network.api;

import java.util.List;

import okhttp3.Credentials;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.android.hedgehogs.network.response_object.TokenRO;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 06.04.18.
 */

public interface API {

    @FormUrlEncoded
    @POST("/oauth/token")
    Call<TokenRO> getToken(@Field("username") String extended,
                           @Field("password") String password,
                           @Field("grant_type") String grant_type,
                           @Header("Authorization") String token);

    @POST("/springjwt/videos")
    Call<List<VideoRO>> getVideo(@Header("Authorization") String token);
}
