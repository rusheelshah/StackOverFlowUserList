package com.example.userlist;


import java.util.List;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;


class UserListService {
    private static final String BASE_URL = "https://api.stackexchange.com";
    private static final String SITE_PARAM = "stackoverflow";
    private UserListRepository repository;

    UserListService() {
        Retrofit.Builder builder =
                new Retrofit.Builder()
                        .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                        .addConverterFactory(JacksonConverterFactory.create())
                        .baseUrl(BASE_URL);
        Retrofit retrofit = builder.build();
        this.repository = retrofit.create(UserListRepository.class);
    }
    Observable<UserModel> fetchUserData() {
        return repository.fetchUserData(SITE_PARAM);
    }
}
