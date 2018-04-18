package ru.android.hedgehogs.network.api;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ru.android.hedgehogs.network.response_object.TokenRO;

/**
 * Created by yasina on 06.04.18.
 */

public interface API {

    @POST("/oauth/token")
    Call<TokenRO> getToken(@Query("username") String extended,
            @Query("password") String password,
            @Query("grant_type") String grant_type);
}
