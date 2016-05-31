package cn.mycommons.xiaoxiazhihu.business.api.retrofit;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import cn.mycommons.xiaoxiazhihu.business.api.ZhihuApi;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetAllThemesRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetLastThemeRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetLongCommentsRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetNewsRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetShortCommentsRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetStartInfoRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetStoryExtraRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.request.ext.GetThemeRequest;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetAllThemesResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLastThemeResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetLongCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetNewsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetShortCommentsResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStartInfoResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetStoryExtraResponse;
import cn.mycommons.xiaoxiazhihu.business.pojo.response.ext.GetThemeResponse;
import cn.mycommons.xiaoxiazhihu.core.log.XLog;
import cn.mycommons.xiaoxiazhihu.core.net.NetWorkException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * ZhihuApiRetrofitImpl <br/>
 * Created by xiaqiulei on 2016-01-10.
 */
public class ZhihuApiRetrofitImpl implements ZhihuApi {

    IZhihuHttpApi httpApi;

    public ZhihuApiRetrofitImpl() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        // set time out interval
        builder.readTimeout(15, TimeUnit.MINUTES);
        builder.connectTimeout(15, TimeUnit.MINUTES);
        builder.writeTimeout(15, TimeUnit.MINUTES);
        builder.interceptors().add(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);
                XLog.i("Interceptor:request = %s, response = %s", request, response);
                return response;
            }
        });

        httpApi = new Retrofit
                .Builder()
                .client(builder.build())
                .baseUrl("http://news-at.zhihu.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(IZhihuHttpApi.class);
    }

    @Override
    public GetStartInfoResponse getStartInfoResponse(final GetStartInfoRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getStartInfoResponse request = " + request);

        return new RetrofitAdapter<GetStartInfoResponse>() {
            @Override
            GetStartInfoResponse call() throws Exception {
                return httpApi.getStartInfoResponse(request.getWidth(), request.getHeight()).execute().body();
            }
        }.get();
    }

    @Override
    public GetAllThemesResponse getAllThemesResponse(GetAllThemesRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getAllThemesResponse request = " + request);
        return new RetrofitAdapter<GetAllThemesResponse>() {
            @Override
            GetAllThemesResponse call() throws Exception {
                return httpApi.getAllThemesResponse().execute().body();
            }
        }.get();
    }

    @Override
    public GetLastThemeResponse getLastThemeResponse(GetLastThemeRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getLastThemeResponse request = " + request);
        return new RetrofitAdapter<GetLastThemeResponse>() {
            @Override
            GetLastThemeResponse call() throws Exception {
                return httpApi.getLastThemeResponse().execute().body();
            }
        }.get();
    }

    @Override
    public GetNewsResponse getNewsResponse(final GetNewsRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getNewsResponse request = " + request);
        return new RetrofitAdapter<GetNewsResponse>() {
            @Override
            GetNewsResponse call() throws Exception {
                return httpApi.getNewsResponse(request.getId()).execute().body();
            }
        }.get();
    }

    @Override
    public GetThemeResponse getThemeResponse(final GetThemeRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getThemeResponse request = " + request);
        return new RetrofitAdapter<GetThemeResponse>() {
            @Override
            GetThemeResponse call() throws Exception {
                return httpApi.getThemeResponse(request.getId()).execute().body();
            }
        }.get();
    }

    @Override
    public GetStoryExtraResponse getStoryExtraResponse(final GetStoryExtraRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getStoryExtraResponse request = " + request);
        return new RetrofitAdapter<GetStoryExtraResponse>() {
            @Override
            GetStoryExtraResponse call() throws Exception {
                return httpApi.getStoryExtraResponse(request.id).execute().body();
            }
        }.get();
    }

    @Override
    public GetShortCommentsResponse getShortComments(final GetShortCommentsRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.getShortComments request = " + request);
        return new RetrofitAdapter<GetShortCommentsResponse>() {
            @Override
            GetShortCommentsResponse call() throws Exception {
                return httpApi.getShortComments(request.getId()).execute().body();
            }
        }.get();
    }

    @Override
    public GetLongCommentsResponse getLongComments(final GetLongCommentsRequest request) throws NetWorkException {
        XLog.i("ZhihuApiRetrofitImpl.GetStartInfoResponse request = " + request);
        return new RetrofitAdapter<GetLongCommentsResponse>() {
            @Override
            GetLongCommentsResponse call() throws Exception {
                return httpApi.getLongComments(request.getId()).execute().body();
            }
        }.get();
    }
}