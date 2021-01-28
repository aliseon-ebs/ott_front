package com.aliseon.ott;

import com.aliseon.ott.API.AtrendDetail;
import com.aliseon.ott.API.Auth;
import com.aliseon.ott.API.Cart;
import com.aliseon.ott.API.Categories;
import com.aliseon.ott.API.CreatorMyInfo;
import com.aliseon.ott.API.Popular;
import com.aliseon.ott.API.PopularDetail;
import com.aliseon.ott.API.ProductBuy;
import com.aliseon.ott.API.ProductDetail;
import com.aliseon.ott.API.ProductInfo;
import com.aliseon.ott.API.RecommendCreator;
import com.aliseon.ott.API.SubscribeFrom;
import com.aliseon.ott.API.MyList;
import com.aliseon.ott.API.SubscribePost;
import com.aliseon.ott.API.SubscribeTo;
import com.aliseon.ott.API.TvottAddUser;
import com.aliseon.ott.API.TvottLanguageSetting;
import com.aliseon.ott.API.TvottUsers;
import com.aliseon.ott.API.Atrend;
import com.aliseon.ott.API.UserDelete;
import com.aliseon.ott.API.UserPhone;
import com.aliseon.ott.API.Voyage;
import com.aliseon.ott.API.VoyageDetail;
import com.aliseon.ott.API.VoyageResult;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AliseonAPI {

    @FormUrlEncoded
    @POST("auth")
    Call<Auth> AuthPost(
            @Field("device_id") String device_id,
            @Field("region") String region
    );

    @FormUrlEncoded
    @POST("tvott/users/add")
    Call<TvottAddUser> TvottAddUserPost(
            @Field("access_token") String access_token,
            @Field("user_id") int user_id
    );

    @FormUrlEncoded
    @POST("tvott/users")
    Call<TvottUsers> TvottUsersPost(
            @Field("access_token") String access_token
    );

    @FormUrlEncoded
    @POST("usersetting")
    Call<TvottLanguageSetting> TvottLanguageSettingPost(
            @Field("access_token") String access_token,
            @Field("user_id") int id,
            @Field("lang") String lang,
            @Field("country") String country,
            @Field("currency") String currency
    );

    @FormUrlEncoded
    @POST("usersetting/user/phone")
    Call<UserPhone> UserPhonePost(
            @Field("access_token") String access_token,
            @Field("calling_code") String calling_code,
            @Field("phone") String phone
    );

    @FormUrlEncoded
    @POST("tvott/users/delete")
    Call<UserDelete> UserDeletePost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("atrend")
    Call<Atrend> AtrendPost(
            @Field("access_token") String access_token,
            @Field("start") int start,
            @Field("limit") int limit,
            @Field("lang") String lang,
            @Field("currency") String currency,
            @Field("is_ott") int is_ott
    );

    @FormUrlEncoded
    @POST("atrend/detail")
    Call<AtrendDetail> AtrendDetailPost(
            @Field("access_token") String access_token,
            @Field("user_id") int user_id,
            @Field("atrend_id") String atrend_id,
            @Field("lang") String lang,
            @Field("currency") String currency
    );

    @FormUrlEncoded
    @POST("tvott/popular")
    Call<Popular> PopularPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id,
            @Field("category") int category,
            @Field("start") int start,
            @Field("limit") int limit
    );

    @FormUrlEncoded
    @POST("tvott/popular/detail")
    Call<PopularDetail> PopularDetailPost(
            @Field("access_token") String access_token,
            @Field("voyage_id") String voyage_id,
            @Field("lang") String lang,
            @Field("currency") String currency
    );

    @FormUrlEncoded
    @POST("voyage")
    Call<Voyage> VoyagePost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id,
            @Field("is_ott") int is_ott,
            @Field("category") int category,
            @Field("start") int start,
            @Field("limit") int limit,
            @Field("lang") String lang
    );

    @FormUrlEncoded
    @POST("voyage/detail")
    Call<VoyageDetail> VoyageDetailPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id,
            @Field("voyage_id") String voyage_id,
            @Field("is_ott") int is_ott,
            @Field("lang") String lang,
            @Field("currency") String currency
    );

    @FormUrlEncoded
    @POST("voyage")
    Call<VoyageResult> VoyageSearchPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id,
            @Field("is_ott") int is_ott,
            @Field("category") int category,
            @Field("start") int start,
            @Field("limit") int limit,
            @Field("lang") String lang,
            @Field("keyword") String keyword
    );

    @FormUrlEncoded
    @POST("category")
    Call<Categories> CategoriesPost(
            @Field("access_token") String access_token,
            @Field("lang") String lang,
            @Field("dept") int dept
    );
    @FormUrlEncoded
    @POST("subscribe/post")
    Call<SubscribePost> SubscribePost(
            @Field("access_token") String access_token,
            @Field("from_id") String user_id,
            @Field("to_id") String to_user_id,
            @Field("type") String type
    );
    @FormUrlEncoded
    @POST("subscribe/from")
    Call<SubscribeFrom> SubscribeFromPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id
    );
    @FormUrlEncoded
    @POST("subscribe/to")
    Call<SubscribeTo> SubscribeToPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id
    );
    @FormUrlEncoded
    @POST("my/list")
    Call<MyList> MyListPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id,
            @Field("is_ott") int is_ott,
            @Field("category") int category,
            @Field("start") int start,
            @Field("limit") int limit
    );

    @FormUrlEncoded
    @POST("recommend/creator")
    Call<RecommendCreator> RecommendCreatorPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("my/info")
    Call<CreatorMyInfo> CreatorMyInfoPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("cart")
    Call<Cart> CartPost(
            @Field("access_token") String access_token,
            @Field("user_id") String user_id
    );

    @FormUrlEncoded
    @POST("product/info")
    Call<ProductInfo> ProductInfoPost(
            @Field("access_token") String access_token,
            @Field("product_id") String product_id,
            @Field("lang") String lang,
            @Field("currency") String currency
    );

    @FormUrlEncoded
    @POST("product/detail")
    Call<ProductDetail> ProductDetailPost(
            @Field("access_token") String access_token,
            @Field("product_id") String product_id,
            @Field("lang") String lang,
            @Field("currency") String currency
    );

    @FormUrlEncoded
    @POST("product/buy")
    Call<ProductBuy> ProductBuyPost(
            @Field("access_token") String access_token,
            @Field("product_id") String product_id
    );

}
