package ru.android.hedgehogs.network.api;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import ru.android.hedgehogs.network.response_object.TokenRO;
import ru.android.hedgehogs.network.response_object.VideoRO;

/**
 * Created by yasina on 06.04.18.
 */

public interface API2 {

    @GET("/Yasinaaa/HedgehogsAndroid/blob/master/app/src/main/videoplayback.mp4?raw=true")
    Call<ResponseBody> downloadVideo();
}
