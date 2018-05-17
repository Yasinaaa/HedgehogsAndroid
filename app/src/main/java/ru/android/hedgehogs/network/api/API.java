package ru.android.hedgehogs.network.api;

import java.util.List;

import okhttp3.Credentials;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
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

    @GET("/videos")
    Call<List<VideoRO>> getVideo(@Header("Authorization") String token);

    @FormUrlEncoded
    @POST("/enrollment")
    Call<ResponseBody> registration(@Field("email") String email, @Field("password") String password);

    @Multipart
    @POST("/load")
    Call<ResponseBody> loadVideo(@Part MultipartBody.Part filePart,
                                 @Part("title") String title,
                                 @Part("quality") int quality,
                                 @Part("originalSize") int originalSize,
                                 @Part("originalSizeType") String originalSizeType,
                                 @Header("Authorization") String token,
                                 @Part("deviceId") String deviceId);

    @GET("/download")
    Call<ResponseBody> downloadVideo(@Query("videoId") int videoId, @Header("Authorization") String token);

    @POST("/enrollment")
    Call<ResponseBody> enrollment(@Query("email") String email, @Query("password") String password);
}
