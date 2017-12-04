package com.mrice.txl.appthree.http;


import com.mrice.txl.appthree.bean.AoMenBean;
import com.mrice.txl.appthree.bean.DiscoverBean;
import com.mrice.txl.appthree.bean.FrontpageBean;
import com.mrice.txl.appthree.bean.GankIoDayBean;
import com.mrice.txl.appthree.bean.LoginResponse;
import com.mrice.txl.appthree.bean.LotteryDetailBean;
import com.mrice.txl.appthree.bean.NewAoMenBean;
import com.mrice.txl.appthree.bean.NewsBean;
import com.mrice.txl.appthree.bean.NiceBean;
import com.mrice.txl.appthree.bean.SaiChengBean;
import com.example.http.HttpUtils;
import com.mrice.txl.appthree.bean.SwitchBean;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by cai on 16/11/21.
 * 网络请求类（一个接口一个方法）
 */
public interface RetrofitHttpClient {

    class Builder {
        public static RetrofitHttpClient getDouBanService() {
            return HttpUtils.getInstance().getDouBanServer(RetrofitHttpClient.class);
        }

        public static RetrofitHttpClient getTingServer() {
            return HttpUtils.getInstance().getTingServer(RetrofitHttpClient.class);
        }

        public static RetrofitHttpClient getGankIOServer() {
            return HttpUtils.getInstance().getGankIOServer(RetrofitHttpClient.class);
        }

        public static RetrofitHttpClient getYunServer() {
            return HttpUtils.getInstance().getYunServer(RetrofitHttpClient.class);
        }

        public static RetrofitHttpClient getAoMenServer() {
            return HttpUtils.getInstance().getAoMenServer(RetrofitHttpClient.class);
        }

        public static RetrofitHttpClient getSwitchServer() {
            return HttpUtils.getInstance().getSwitchServer(RetrofitHttpClient.class);
        }

        public static RetrofitHttpClient getSportServer() {
            return HttpUtils.getInstance().getSportServer(RetrofitHttpClient.class);
        }
    }

    /**
     * 首页轮播图
     */
    @GET("ting?from=android&version=5.8.1.0&channel=ppzs&operator=3&method=baidu.ting.plaza.index&cuid=89CF1E1A06826F9AB95A34DC0F6AAA14")
    Observable<FrontpageBean> getFrontpage();

    /**
     * 每日数据： http://gank.io/api/day/年/月/日
     * eg:http://gank.io/api/day/2015/08/06
     */
    @GET("day/{year}/{month}/{day}")
    Observable<GankIoDayBean> getGankIoDay(@Path("year") String year, @Path("month") String month, @Path("day") String day);

    /**
     * 登录接口
     *
     * @param body
     * @return
     */
    @POST("login/")
    Observable<LoginResponse> login(@Body RequestBody body);

    /**
     * 注册接口
     *
     * @param body
     * @return
     */
    @POST("login/register")
    Observable<LoginResponse> register(@Body RequestBody body);

    /**
     * 获取验证码接口
     *
     * @param body
     * @return
     */
    @POST("login/getValidMM")
    Observable<LoginResponse> getVerifyCode(@Body RequestBody body);

    @POST("login/updatePwd")
    Observable<LoginResponse> modifyPwd(@Body RequestBody body);

    /**
     * http://localhost/yxsm_api/technicalInformation/list
     *
     * @param body
     * @return
     */
    @POST("technicalInformation/list1")
    Observable<DiscoverBean> getDiscoverList(@Body RequestBody body);

    /**
     * pageNum  type
     *
     * @param
     * @return
     */
    @POST("cp/list")
    Observable<LotteryDetailBean> getCaiList(@Body RequestBody body);

    /**
     * http://localhost:8081/yxsm_api/roll/list
     *
     * @param
     * @return
     */

    @POST("roll/list")
    Observable<NiceBean> getBannerImage(@Body RequestBody body);


    @POST("appgl/appShow/getInfo")
    Observable<AoMenBean> getAoMenPage(@Body RequestBody body);

    @POST("appgl/cp/getApp?appId=2017112700002")
    Observable<NewAoMenBean> switchOnOff();

    @GET("get_init_data.php?type=android&appid=cp20171124003")
    Observable<SwitchBean> switchCheck();

    @POST("league")
    Observable<SaiChengBean> getSaiCheng(@Body RequestBody body);

    @GET("league?")
    Observable<SaiChengBean> getSaiCheng1(@Query("key") String key, @Query("league") String league, @Query("dtype") String dtype);

    @GET("index?")
    Observable<NewsBean> getNews(@Query("type") String type, @Query("key") String key);
}