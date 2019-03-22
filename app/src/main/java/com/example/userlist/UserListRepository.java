package com.example.userlist;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserListRepository {
    @GET("/2.2/users")
    Observable<UserModel> fetchUserData(
            @Query("site") String site
    );
}