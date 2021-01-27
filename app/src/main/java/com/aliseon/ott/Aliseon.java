package com.aliseon.ott;

import android.app.Application;
import android.content.SharedPreferences;

import java.util.ArrayList;

public class Aliseon extends Application {

    // 주소

    private String imageurl = "https://2020aliseon.s3.ap-northeast-2.amazonaws.com";

    private String aliseonapi = "http://api.aliseon.com/api/";

    private String api_auth = aliseonapi + "/auth";
    private String api_usersetting_user_phone = aliseonapi + "/usersetting/user/phone";
    private String api_category = aliseonapi + "/category";
    private String api_tvott_users = aliseonapi + "/tvott/users";
    private String api_tvott_users_add = aliseonapi + "/tvott/users/add";
    private String api_tvott_deluser = aliseonapi + "/tvott/users/delete";
    private String api_atrend = aliseonapi + "/atrend";
    private String api_voyage = aliseonapi + "/voyage";
    private String api_atrend_detail = aliseonapi + "/atrend/detail";
    private String api_voyage_detail = aliseonapi + "/voyage/detail";
    private String api_subscribe_from = aliseonapi + "/subscribe/from";
    private String api_subscribe_to = aliseonapi + "/subscribe/to";
    private String api_cart = aliseonapi + "/cart";
    private String api_my_info = aliseonapi + "/my/info";
    private String api_tvott_popular = aliseonapi + "/tvott/popular";
    private String api_tvott_popular_detail = aliseonapi + "/tvott/popular/detail";
    private String api_recommend_creator = aliseonapi + "/recommend/creator";
    private String api_product_info = aliseonapi + "/product/info";
    private String api_product_detail = aliseonapi + "/product/detail";
    private String api_product_buy = aliseonapi + "/product/buy";
    private String api_subscribe_post = aliseonapi + "/subscribe/post";
    private String api_subscribe_unsubscribe = aliseonapi + "/subscribe/unsubscribe";
    private String api_usersetting = aliseonapi + "/usersetting";
    private String api_my_list = aliseonapi + "/my/list";

    //Auth 필수 값
    private String android_id;
    private String access_token;

    // 사용자 정보 저장
    private ArrayList<Integer> userinfouid;
    private ArrayList<String> userinfo;

    // shared preferences 로그인 세션
    private SharedPreferences pref;

    // 로그인 변수
    private int loginid;
    private String logincurrency;
    private String loginlanguage;
    private String logincountry;

    // 구독 하고있는지 아닌지 체크
    private int subscribe_checker;
    private int refresh_num;

    //Player Activity 구분 select
    private int select; /* 영상 index */
    private int typeselector; /* Atrend, Popular, Voyage 구분 */

    private int childlist = 0; /* 영상 플레이어의 상품 표시에 필요함 */
    private int contentcounter = 0; /* 영상 플레이어 하단의 related에 필요함 */

    //카테고리 번호 기본 : 0
    private int category_num = 0;
    private int category_id = 0;

    //검색
    private String keyword = null;

    // 보야지 페이지 카테고리 리스트
    private ArrayList<Integer> cate_number;
    private ArrayList<String> cate_name;

    // 영상 플레이어 내에서 사용?
    private String maintitle = null;
    private String subtitle = null;
    private String creatortitle = null;
    private String creatorprofile = null;
    private String creatorauthorid = null;

    // API 스타트 리미트 값 4X3 배열을 기준으로 스타트 0 리미트 12부터 보통 시작
    private int atrendstart = 0;
    private int atrendlimit = 20;
    private int popularstart = 0;
    private int popularlimit = 23;
    private int voyagestart = 0;
    private int voyagelimit = 12;

    // API 로드 0 = 로드안됨, 1 = 로드됨     초기 값 = 0
    private int homeapiload = 0;
    private int adduserapiload = 0;
    private int voyageapiload = 0;
    private int voyagecategoryapiload = 0;
    private int voyagefocusapiload = 0;

    // API 로드 0 = 로드안됨, 1 = 로드됨     초기 값 = 0
    private int subscribeapiload = 0;
    private int subscribefocusapiload = 0;
    private int voyageresultapiload = 0;
    private int settinguseraccountmanagementapiload = 0;
    private int cartapiload = 0;
    private int cartdetailapiload = 0;
    private int myapiload = 0;
    private int creatorapiload = 0;
    private int mydetailapiload = 0;
    private int creatordetailapiload = 0;
    private int usersettinglanguageapiload = 0;

    // API 스타트 리미트 값 4X3 배열을 기준으로 스타트 0 리미트 12부터 보통 시작
    private int subscribevoyagestart = 0;
    private int subscribevoyagelimit = 12;
    private int creatorstart = 0;
    private int creatorlimit = 12;
    private int mystart = 0;
    private int mylimit = 12;
    private int voyageresultstart = 0;
    private int voyageresultlimit = 12;


    //API에서 불러온 데이터를 저장하는 ArrayList
    //------------------------------------------------ 시작 ----------------------------------------------------상

    // A-Trend
    private ArrayList<String> atrend_id = new ArrayList<>();
    private ArrayList<String> atrend_user_id = new ArrayList<>();
    private ArrayList<String> atrend_type = new ArrayList<>();
    private ArrayList<String> atrend_product_id = new ArrayList<>();
    private ArrayList<String> atrend_contents_id = new ArrayList<>();
    private ArrayList<String> atrend_title = new ArrayList<>();
    private ArrayList<String> atrend_subtitle = new ArrayList<>();
    private ArrayList<String> atrend_description = new ArrayList<>();
    private ArrayList<String> atrend_summary = new ArrayList<>();
    private ArrayList<Integer> atrend_view = new ArrayList<>();
    private ArrayList<Integer> atrend_like = new ArrayList<>();
    private ArrayList<String> atrend_color = new ArrayList<>();
    private ArrayList<String> atrend_start_at = new ArrayList<>();
    private ArrayList<String> atrend_create_at = new ArrayList<>();
    private ArrayList<String> atrend_update_at = new ArrayList<>();
    private ArrayList<String> atrend_opacity = new ArrayList<>();
    private ArrayList<Integer> atrend_status = new ArrayList<>();
    private ArrayList<String> atrend_background = new ArrayList<>();
    private ArrayList<String> atrend_thumbnail = new ArrayList<>();

    // 인기동영상
    private ArrayList<String> popular_id = new ArrayList<>();
    private ArrayList<String> popular_user_id = new ArrayList<>();
    private ArrayList<String> popular_product_id = new ArrayList<>();
    private ArrayList<String> popular_contents_id = new ArrayList<>();
    private ArrayList<String> popular_contents_type = new ArrayList<>();
    private ArrayList<String> popular_category_id = new ArrayList<>();
    private ArrayList<Integer> popular_status = new ArrayList<>();
    private ArrayList<String> popular_description = new ArrayList<>();
    private ArrayList<String> popular_create_at = new ArrayList<>();
    private ArrayList<String> popular_update_at = new ArrayList<>();
    private ArrayList<Integer> popular_like_count = new ArrayList<>();
    private ArrayList<Integer> popular_view_count = new ArrayList<>();
    private ArrayList<Integer> popular_comment_count = new ArrayList<>();
    private ArrayList<String> popular_category_en = new ArrayList<>();
    private ArrayList<String> popular_category_kr = new ArrayList<>();
    private ArrayList<String> popular_nickname = new ArrayList<>();
    private ArrayList<String> popular_photo = new ArrayList<>();
    private ArrayList<ArrayList<String>> popular_p_thumbnail = new ArrayList<>();
    private ArrayList<String> popular_c_thumbnail;

    //voyage
    private ArrayList<String> voyage_id;
    private ArrayList<String> voyage_user_id;
    private ArrayList<String> voyage_product_id;
    private ArrayList<String> voyage_contents_id;
    private ArrayList<String> voyage_contents_type;
    private ArrayList<String> voyage_category_id;
    private ArrayList<Integer> voyage_status;
    private ArrayList<String> voyage_description;
    private ArrayList<String> voyage_create_at;
    private ArrayList<String> voyage_update_at;
    private ArrayList<Integer> voyage_like_count;
    private ArrayList<Integer> voyage_view_count;
    private ArrayList<Integer> voyage_comment_count;
    private ArrayList<String> voyage_category_en;
    private ArrayList<String> voyage_category_kr;
    private ArrayList<String> voyage_nickname;
    private ArrayList<String> voyage_photo;
    private ArrayList<ArrayList<String>> voyage_p_thumbnail;
    private ArrayList<String> voyage_c_thumbnail;

    //플레이어
    private ArrayList<String> player_feed_list_author_id;
    private ArrayList<String> player_feed_list_crop;
    private ArrayList<String> player_feed_list_id;
    private ArrayList<String> player_feed_list_content;
    private ArrayList<String> player_feed_list_author_picture;
    private ArrayList<String> player_feed_list_author_nickname;
    private ArrayList<Integer> player_feed_list_views;

    private String atrend_detail_title;
    private ArrayList<String> atrend_detail_maincontent;
    private ArrayList<String> atrend_detail_detp_html;
    private ArrayList<String> atrend_detail_product_id;
    private ArrayList<String> atrend_detail_product_name;
    private ArrayList<String> atrend_detail_product_brand;
    private ArrayList<String> atrend_detail_product_thumbnail;
    private ArrayList<String> atrend_detail_product_price;
    private ArrayList<String> atrend_detail_product_previous_price;

    private ArrayList<String> atrend_related_id;
    private ArrayList<String> atrend_related_user_id;
    private ArrayList<String> atrend_related_type;
    private ArrayList<String> atrend_related_product_id;
    private ArrayList<String> atrend_related_contents_id;
    private ArrayList<String> atrend_related_title;
    private ArrayList<String> atrend_related_subtitle;
    private ArrayList<String> atrend_related_description;
    private ArrayList<String> atrend_related_summary;
    private ArrayList<String> atrend_related_view;
    private ArrayList<String> atrend_related_like;
    private ArrayList<String> atrend_related_color;
    private ArrayList<String> atrend_related_start_at;
    private ArrayList<String> atrend_related_create_at;
    private ArrayList<String> atrend_related_update_at;
    private ArrayList<String> atrend_related_opacity;
    private ArrayList<String> atrend_related_status;
    private ArrayList<String> atrend_related_background;
    private ArrayList<String> atrend_related_thumbnail;

    private ArrayList<String> popular_detail_id;
    private ArrayList<String> popular_detail_user_id;
    private ArrayList<String> popular_detail_product_id;
    private ArrayList<String> popular_detail_contents_id;
    private ArrayList<String> popular_detail_contents_type;
    private ArrayList<String> popular_detail_category_id;
    private ArrayList<String> popular_detail_status;
    private ArrayList<String> popular_detail_description;
    private ArrayList<String> popular_detail_create_at;
    private ArrayList<String> popular_detail_update_at;
    private ArrayList<String> popular_detail_like_count;
    private ArrayList<String> popular_detail_view_count;
    private ArrayList<String> popular_detail_comment_count;
    private ArrayList<String> popular_detail_category_en;
    private ArrayList<String> popular_detail_category_kr;
    private ArrayList<String> popular_detail_name;
    private ArrayList<String> popular_detail_photo;
    private ArrayList<String> popular_detail_contents;
    private ArrayList<String> popular_detail_items;

    private ArrayList<String> popular_detail_item_id;
    private ArrayList<String> popular_detail_item_name;
    private ArrayList<String> popular_detail_item_brand;
    private ArrayList<String> popular_detail_item_thumbnail;
    private ArrayList<String> popular_detail_item_price;
    private ArrayList<String> popular_detail_item_previous_price;

    private ArrayList<String> popular_related_id;
    private ArrayList<String> popular_related_user_id;
    private ArrayList<String> popular_related_status;
    private ArrayList<String> popular_related_description;
    private ArrayList<String> popular_related_create_at;
    private ArrayList<String> popular_related_update_at;
    private ArrayList<String> popular_related_like_count;
    private ArrayList<String> popular_related_view_count;
    private ArrayList<String> popular_related_comment_count;
    private ArrayList<String> popular_related_contents;

    private ArrayList<String> voyage_detail_id;
    private ArrayList<String> voyage_detail_user_id;
    private ArrayList<String> voyage_detail_product_id;
    private ArrayList<String> voyage_detail_contents_id;
    private ArrayList<String> voyage_detail_contents_type;
    private ArrayList<String> voyage_detail_category_id;
    private ArrayList<String> voyage_detail_status;
    private ArrayList<String> voyage_detail_description;
    private ArrayList<String> voyage_detail_create_at;
    private ArrayList<String> voyage_detail_update_at;
    private ArrayList<String> voyage_detail_like_count;
    private ArrayList<String> voyage_detail_view_count;
    private ArrayList<String> voyage_detail_comment_count;
    private ArrayList<String> voyage_detail_category_en;
    private ArrayList<String> voyage_detail_category_kr;
    private ArrayList<String> voyage_detail_nickname;
    private ArrayList<String> voyage_detail_photo;
    private ArrayList<String> voyage_detail_contents;
    private ArrayList<String> voyage_detail_items;

    private ArrayList<String> voyage_detail_item_id;
    private ArrayList<String> voyage_detail_item_name;
    private ArrayList<String> voyage_detail_item_brand;
    private ArrayList<String> voyage_detail_item_thumbnail;
    private ArrayList<String> voyage_detail_item_price;
    private ArrayList<String> voyage_detail_item_previous_price;

    private ArrayList<String> voyage_related_id;
    private ArrayList<String> voyage_related_user_id;
    private ArrayList<String> voyage_related_status;
    private ArrayList<String> voyage_related_description;
    private ArrayList<String> voyage_related_create_at;
    private ArrayList<String> voyage_related_update_at;
    private ArrayList<String> voyage_related_like_count;
    private ArrayList<String> voyage_related_view_count;
    private ArrayList<String> voyage_related_comment_count;
    private ArrayList<String> voyage_related_contents;

    //피드 검색결과 나중에 쓰임
    private ArrayList<String> voyageresult_id;
    private ArrayList<String> voyageresult_user_id;
    private ArrayList<String> voyageresult_product_id;
    private ArrayList<String> voyageresult_contents_id;
    private ArrayList<String> voyageresult_contents_type;
    private ArrayList<String> voyageresult_category_id;
    private ArrayList<Integer> voyageresult_status;
    private ArrayList<String> voyageresult_description;
    private ArrayList<String> voyageresult_create_at;
    private ArrayList<String> voyageresult_update_at;
    private ArrayList<Integer> voyageresult_like_count;
    private ArrayList<Integer> voyageresult_view_count;
    private ArrayList<Integer> voyageresult_comment_count;
    private ArrayList<String> voyageresult_category_en;
    private ArrayList<String> voyageresult_category_kr;
    private ArrayList<String> voyageresult_photo;
    private ArrayList<String> voyageresult_nickname;
    private ArrayList<ArrayList<String>> voyageresult_p_thumbnail;
    private ArrayList<String> voyageresult_c_thumbnail;

    private ArrayList<String> cart_shop_id;
    private ArrayList<String> cart_shop_photo;
    private ArrayList<String> cart_shop_nickname;
    private ArrayList<String> cart_shop_shop_name;
    private ArrayList<ArrayList<String>> cart_items_p_cart_id;
    private ArrayList<ArrayList<String>> cart_items_p_user_id;
    private ArrayList<ArrayList<String>> cart_items_p_option_value;
    private ArrayList<ArrayList<String>> cart_items_p_option_price;
    private ArrayList<ArrayList<String>> cart_items_p_option_stock;
    private ArrayList<ArrayList<String>> cart_items_p_product_id;
    private ArrayList<ArrayList<String>> cart_items_p_status;
    private ArrayList<ArrayList<String>> cart_items_p_vendor_id;
    private ArrayList<ArrayList<String>> cart_items_p_name;
    private ArrayList<ArrayList<String>> cart_items_p_thumbnail;
    private ArrayList<ArrayList<String>> cart_items_p_ship;
    private ArrayList<ArrayList<String>> cart_items_p_previous_price;
    private ArrayList<ArrayList<String>> cart_items_p_price;
    private ArrayList<String> cart_items_c_cart_id;
    private ArrayList<String> cart_items_c_user_id;
    private ArrayList<String> cart_items_c_option_value;
    private ArrayList<String> cart_items_c_option_price;
    private ArrayList<String> cart_items_c_option_stock;
    private ArrayList<String> cart_items_c_product_id;
    private ArrayList<String> cart_items_c_status;
    private ArrayList<String> cart_items_c_vendor_id;
    private ArrayList<String> cart_items_c_name;
    private ArrayList<String> cart_items_c_thumbnail;
    private ArrayList<String> cart_items_c_ship;
    private ArrayList<String> cart_items_c_previous_price;
    private ArrayList<String> cart_items_c_price;

    //카트 자세히보기
    //product info API
    private int cartdetail_productinfo_id;
    private String cartdetail_productinfo_desc;
    //product detail API
    private int cartdetail_productdetail_id;
    private int cartdetail_productdetail_vendor_id;
    private String cartdetail_productdetail_thumbnail;
    private String cartdetail_productdetail_title;
    private String cartdetail_productdetail_sub_title;
    private int cartdetail_productdetail_previous_price;
    private int cartdetail_productdetail_complete_price;
    private int cartdetail_productdetail_basic_shipping;
    private int cartdetail_productdetail_free_shipping;
    //product buy API
    private ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_name;
    private ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_original_value;
    private ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_original_price;
    private ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_value;
    private ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_price;
    private ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_stock;
    private ArrayList<String> cartdetail_productbuy_c_option_original_value;
    private ArrayList<String> cartdetail_productbuy_option_name;
    private ArrayList<Integer> cartdetail_productbuy_c_option_original_price;
    private ArrayList<String> cartdetail_productbuy_c_option_value;
    private ArrayList<Integer> cartdetail_productbuy_c_option_price;
    private ArrayList<Integer> cartdetail_productbuy_c_option_stock;
    private ArrayList<Integer> cartdetail_productbuy_option_connection;

    // on working
    private ArrayList<Integer> subscribe_creator_list_id;
    private ArrayList<String> subscribe_creator_list_nickname;
    private ArrayList<String> subscribe_creator_list_photo;
    private ArrayList<String> subscribe_voyage_list_id;
    private ArrayList<String> subscribe_voyage_list_user_id;
    private ArrayList<String> subscribe_voyage_list_product_id;
    private ArrayList<String> subscribe_voyage_list_contents_id;
    private ArrayList<String> subscribe_voyage_list_contents_type;
    private ArrayList<String> subscribe_voyage_list_category_id;
    private ArrayList<Integer> subscribe_voyage_list_status;
    private ArrayList<String> subscribe_voyage_list_create_at;
    private ArrayList<String> subscribe_voyage_list_update_at;
    private ArrayList<Integer> subscribe_voyage_list_like_count;
    private ArrayList<Integer> subscribe_voyage_list_view_count;
    private ArrayList<Integer> subscribe_voyage_list_comment_count;
    private ArrayList<String> subscribe_voyage_list_category_en;
    private ArrayList<String> subscribe_voyage_list_category_kr;
    private ArrayList<String> subscribe_voyage_list_nickname;
    private ArrayList<String> subscribe_voyage_list_photo;
    private ArrayList<String> subscribe_voyage_list_description;
    private ArrayList<ArrayList<String>> subscribe_voyage_list_p_thumbnail;
    private ArrayList<String> subscribe_voyage_list_c_thumbnail;

    private int creator_id;
    private String creator_nickname;
    private String creator_photo;
    private String creator_zip;
    private String creator_city;
    private String creator_state;
    private String creator_address;
    private int creator_subscribeto_cnt;
    private int creator_contents_cnt;
    private String creator_desc;
    private ArrayList<String> creator_list_id;
    private ArrayList<String> creator_list_user_id;
    private ArrayList<Integer> creator_list_status;
    private ArrayList<String> creator_list_description;
    private ArrayList<String> creator_list_create_at;
    private ArrayList<String> creator_list_update_at;
    private ArrayList<Integer> creator_list_like_count;
    private ArrayList<Integer> creator_list_view_count;
    private ArrayList<Integer> creator_list_comment_count;
    private ArrayList<ArrayList<String>> creator_list_p_thumbnail;
    private ArrayList<String> creator_list_c_thumbnail;
    private ArrayList<String> creator_list_nickname;
    private ArrayList<String> creator_list_profile;

    private ArrayList<Integer> creatordetail_list_id;
    private ArrayList<String> creatordetail_list_nickname;
    private ArrayList<String> creatordetail_list_photo;
    private ArrayList<Integer> creatordetail_list_subscribeto_cnt;
    private ArrayList<Integer> creatordetail_list_contents_cnt;
    private ArrayList<Integer> creatordetail_list_is_subscribe;

    private ArrayList<Integer> mydetail_list_id;
    private ArrayList<String> mydetail_list_nickname;
    private ArrayList<String> mydetail_list_photo;
    private ArrayList<Integer> mydetail_list_subscribeto_cnt;
    private ArrayList<Integer> mydetail_list_contents_cnt;
    private ArrayList<Integer> mydetail_list_is_subscribe;

    public static ArrayList<Integer> from_fav_channel_id;
    public static ArrayList<String> from_fav_channel_nickname;
    public static ArrayList<String> from_fav_channel_photo;

    public static ArrayList<Integer> to_fav_channel_id;
    public static ArrayList<String> to_fav_channel_nickname;
    public static ArrayList<String> to_fav_channel_photo;

    private ArrayList<String> recommend_id;
    private ArrayList<String> recommend_nickname;
    private ArrayList<String> recommend_photo;
    private ArrayList<String> recommend_subscribeto_cnt;
    private ArrayList<String> recommend_contents_cnt;

    private String my_id;
    private String my_nickname;
    private String my_photo;
    private String my_zip;
    private String my_city;
    private String my_state;
    private String my_address;
    private String my_subscribeto_cnt;
    private String my_contents_cnt;
    private String my_desc;
    private ArrayList<String> my_list_id;
    private ArrayList<String> my_list_user_id;
    private ArrayList<Integer> my_list_status;
    private ArrayList<String> my_list_description;
    private ArrayList<String> my_list_create_at;
    private ArrayList<String> my_list_update_at;
    private ArrayList<Integer> my_list_like_count;
    private ArrayList<Integer> my_list_view_count;
    private ArrayList<Integer> my_list_comment_count;
    private ArrayList<ArrayList<String>> my_list_p_thumbnail;
    private ArrayList<String> my_list_c_thumbnail;
    private ArrayList<String> my_list_nickname;
    private ArrayList<String> my_list_profile;

    //------------------------------------------------- 끝 ---------------------------------------------------

    // 사용자 휴대폰 번호 확인
    private String phone_number;

    //국가코드
    private String countrycode;

    //설정 페이지 카테고리 리스트
    public static ArrayList<String> usersetting_category;

    //infocheck 변수
    private int infocheck_id;
    private int myuid;

    // Atrend 변수
    private String param_atrend_id;

    //Product Info 변수
    private String param_product_id;

    //Creator Info 변수
    private int param_creator_info;

    //구독하기, 구독해제하기 판단 switch 변수
    private String param_subscribe_type;
    private int param_subscribe_to_id;
    private int param_subscribe_activity;

    //장바구니 디테일 옵션 갯수
    public static int param_cartdetail_optionname_size = 0;



    public static int selected_num;

    //구독페이지 어떤 크리에이터 선택되었는지 알게하는 변수
    private int subscribe_select_creator_id;
    private int subscribe_select_creator_num;

    //장바구니 자세히보기에서 옵션 추가할때 옛날에 썻엇음
    private ArrayList<String> addoption;
    static String addoptionsize;
    private ArrayList<ArrayList<String>> cartitemoption;

    private String select_voyage_id;

    // 영상 플레이어 데이터 변수
    private int playerdataload = 0; /* API 로드 여부 */

    private String nowurl;
    private ArrayList<String> playerfeedid;
    private ArrayList<String> playerfeedimage;
    private ArrayList<String> playerfeedname;
    private ArrayList<String> playerfeedpricecomputed;

    public void CreatorClear() {


        try {
            aliseon_setCreatorAPIload(0);
            aliseon_setCreator_id(0);
            aliseon_setCreator_nickname(null);
            aliseon_setCreator_photo(null);
            aliseon_setCreator_zip(null);
            aliseon_setCreator_city(null);
            aliseon_setCreator_state(null);
            aliseon_setCreator_address(null);
            aliseon_setCreator_subscribeto_cnt(0);
            aliseon_setCreator_contents_cnt(0);
            aliseon_setCreator_desc(null);
            creator_list_id.clear();
            creator_list_user_id.clear();
            creator_list_status.clear();
            creator_list_create_at.clear();
            creator_list_update_at.clear();
            creator_list_like_count.clear();
            creator_list_view_count.clear();
            creator_list_comment_count.clear();
            creator_list_nickname.clear();
            creator_list_profile.clear();
            creator_list_description.clear();
            creator_list_p_thumbnail.clear();
        } catch (Exception e) {
            e.printStackTrace();
        }

//        creator_nickname = null;
//        creator_photo = null;
//        creator_zip = null;
//        creator_city = null;
//        creator_state = null;
//        creator_address = null;
//        creator_subscribeto_cnt = 0;
//        creator_contents_cnt = 0;
//        creator_desc = null;


    }

    public static void CreatorDetailClear() {

//        creatordetailapiload = 0;
//        creatordetail_list_id.clear();
//        creatordetail_list_nickname.clear();
//        creatordetail_list_photo.clear();
//        creatordetail_list_subscribeto_cnt.clear();
//        creatordetail_list_contents_cnt.clear();
//        creatordetail_list_is_subscribe.clear();
//        subscribe_creator_list_id.clear();
//        subscribe_creator_list_nickname.clear();
//        subscribe_creator_list_photo.clear();

    }


    public void MyDetailClear() {

        aliseon_setMyDetailAPIload(0);
        mydetail_list_id.clear();
        mydetail_list_nickname.clear();
        mydetail_list_photo.clear();
        mydetail_list_subscribeto_cnt.clear();
        mydetail_list_contents_cnt.clear();
        mydetail_list_is_subscribe.clear();
        subscribe_creator_list_id.clear();
        subscribe_creator_list_nickname.clear();
        subscribe_creator_list_photo.clear();

    }


    //api 주소 정의
    public String aliseon_getAliseonapi(){
        return aliseonapi;
    }

    public String aliseon_getImageURL(){
        return imageurl;
    }

    //api load
    //get
    public int aliseon_getHomeAPIload(){
        return homeapiload;
    }
    public int aliseon_getAddUserAPIload(){
        return adduserapiload;
    }
    public int aliseon_getVoyageAPIload(){
        return voyageapiload;
    }
    public int aliseon_getVoyageCategoryAPIload(){
        return voyagecategoryapiload;
    }
    public int aliseon_getVoyageFocusAPIload(){
        return voyagefocusapiload;
    }
    public int aliseon_getVoyageResultAPIload() { return voyageresultapiload; }
    public int aliseon_getSubscribeAPIload(){
        return subscribeapiload;
    }
    public int aliseon_getSubscribeFocusAPIload(){
        return subscribefocusapiload;
    }
    public int aliseon_getSettinguseraccountmanagementapiload() { return settinguseraccountmanagementapiload; }
    public int aliseon_getCartAPIload() { return cartapiload; }
    public int aliseon_getCartdetailAPIload() { return cartdetailapiload; }
    public int aliseon_getMyAPIload() { return myapiload; }
    public int aliseon_getCreatorAPIload(){
        return creatorapiload;
    }
    public int aliseon_getMyDetailAPIload() { return mydetailapiload; }
    public int aliseon_getUsersettinglanguageAPIload() { return usersettinglanguageapiload; }

    //set
    public void aliseon_setHomeAPIload(int homeapiload){
        this.homeapiload = homeapiload;
    }
    public void aliseon_setAddUserAPIload(int adduserapiload){
        this.adduserapiload = adduserapiload;
    }
    public void aliseon_setVoyageAPIload(int voyageapiload){
        this.voyageapiload = voyageapiload;
    }
    public void aliseon_setVoyageCategoryAPIload(int voyagecategoryapiload){
        this.voyagecategoryapiload = voyagecategoryapiload;
    }
    public void aliseon_setVoyageFocusAPIload(int voyagefocusapiload){
        this.voyagefocusapiload = voyagefocusapiload;
    }
    public void aliseon_setVoyageResultAPIload(int voyageresultapiload) { this.voyageresultapiload = voyageresultapiload; }
    public void aliseon_setSubscribeAPIload(int subscribeapiload) {
        this.subscribeapiload = subscribeapiload;
    }
    public void aliseon_setSubscribeFocusAPIload(int subscribefocusapiload) {
        this.subscribefocusapiload = subscribefocusapiload;
    }
    public void aliseon_setMyAPIload(int myapiload) { this.myapiload = myapiload; }
    public void aliseon_setSettinguseraccountmanagementapiload(int settinguseraccountmanagementapiload) { this.settinguseraccountmanagementapiload = settinguseraccountmanagementapiload; }
    public void aliseon_setCartAPIload(int cartapiload) {
        this.cartapiload = cartapiload;
    }
    public void aliseon_setCartdetailAPIload(int cartdetailapiload) {
        this.cartdetailapiload = cartdetailapiload;
    }
    public void aliseon_setCreatorAPIload(int creatorapiload) {
        this.creatorapiload = creatorapiload;
    }
    public void aliseon_setMyDetailAPIload(int mydetailapiload) { this.mydetailapiload = mydetailapiload; }
    public void aliseon_setUsersettinglanguageAPIload(int usersettinglanguageapiload) {
        this.usersettinglanguageapiload = usersettinglanguageapiload;
    }

    //common
    //get
    public String aliseon_getPhone_number() { return phone_number; }
    public String aliseon_getCountrycode() { return countrycode; }

    public int aliseon_getInfocheck_id() {
        return infocheck_id;
    }
    public int aliseon_getMyuid() { return myuid; }

    public int aliseon_getLoginid(){
        return loginid;
    }
    public String aliseon_getLoginlanguage(){
        return loginlanguage;
    }
    public String aliseon_getLogincountry(){
        return logincountry;
    }
    public String aliseon_getLogincurrency(){
        return logincurrency;
    }

    public String aliseon_getKeyword(){
        return keyword;
    }

    //set
    public void aliseon_setPhone_number(String phone_number) { this.phone_number = phone_number; }
    public void aliseon_setCountrycode(String countrycode) { this.countrycode = countrycode; }

    public void aliseon_setInfocheck_id(int infocheck_id) {
        this.infocheck_id = infocheck_id;
    }
    public void aliseon_setMyuid(int myuid) { this.myuid = myuid; }

    public void aliseon_setLoginid(int loginid){
        this.loginid = loginid;
    }
    public void aliseon_setLoginlanguage(String loginlanguage){
        this.loginlanguage = loginlanguage;
    }
    public void aliseon_setLogincountry(String logincountry){
        this.logincountry = logincountry;
    }
    public void aliseon_setLogincurrency(String logincurrency){
        this.logincurrency = logincurrency;
    }

    public void aliseon_setKeyword(String keyword){
        this.logincurrency = logincurrency;
    }


    //auth api
    public String aliseon_getApi_auth(){
        return api_auth;
    }
    public String aliseon_getAndroidid(){
        return android_id;
    }
    //access_token
    public String aliseon_getAccesstoken(){
        return access_token;
    }

    public void aliseon_setAndroid_id(String android_id){
        this.android_id = android_id;
    }
    public void aliseon_setAccesstoken(String access_token){
        this.access_token = access_token;
    }

    //tvottusers api
    public ArrayList<Integer> aliseon_getTvott_userinfouid(){
        return userinfouid;
    }
    public ArrayList<String> aliseon_getTvott_userinfo(){
        return userinfo;
    }

    public void aliseon_setTvott_userinfouid(ArrayList<Integer> userinfouid){
        this.userinfouid = userinfouid;
    }
    public void aliseon_setTvott_userinfo(ArrayList<String> userinfo){
        this.userinfo = userinfo;
    }

    //atrend api
    //get
    public String aliseon_getParam_atrend_id() { return param_atrend_id; }

    public int aliseon_getAtrendStart(){
        return atrendstart;
    }
    public int aliseon_getAtrendLimit(){
        return atrendlimit;
    }

    public ArrayList<String> aliseon_getAtrend_id(){
        return atrend_id;
    }
    public ArrayList<String> aliseon_getAtrend_user_id(){
        return atrend_user_id;
    }
    public ArrayList<String> aliseon_getAtrend_type(){
        return atrend_type;
    }
    public ArrayList<String> aliseon_getAtrend_product_id(){
        return atrend_product_id;
    }
    public ArrayList<String> aliseon_getAtrend_contents_id(){
        return atrend_contents_id;
    }
    public ArrayList<String> aliseon_getAtrend_title(){
        return atrend_title;
    }
    public ArrayList<String> aliseon_getAtrend_sub_title(){
        return atrend_subtitle;
    }
    public ArrayList<String> aliseon_getAtrend_description(){
        return atrend_description;
    }
    public ArrayList<String> aliseon_getAtrend_summary(){
        return atrend_summary;
    }
    public ArrayList<Integer> aliseon_getAtrend_view(){
        return atrend_view;
    }
    public ArrayList<Integer> aliseon_getAtrend_like(){
        return atrend_like;
    }
    public ArrayList<String> aliseon_getAtrend_color(){
        return atrend_color;
    }
    public ArrayList<String> aliseon_getAtrend_start_at(){
        return atrend_start_at;
    }
    public ArrayList<String> aliseon_getAtrend_create_at(){
        return atrend_create_at;
    }
    public ArrayList<String> aliseon_getAtrend_update_at(){
        return atrend_update_at;
    }
    public ArrayList<String> aliseon_getAtrend_opacity(){
        return atrend_opacity;
    }
    public ArrayList<Integer> aliseon_getAtrend_status(){
        return atrend_status;
    }
    public ArrayList<String> aliseon_getAtrend_background(){
        return atrend_background;
    }
    public ArrayList<String> aliseon_getAtrend_thumbnail(){
        return atrend_thumbnail;
    }

    //set
    public void aliseon_setParam_atrend_id(String param_atrend_id) { this.param_atrend_id = param_atrend_id; }

    public void aliseon_setAtrendStart(int atrendstart){
        this.atrendstart = atrendstart;
    }
    public void aliseon_setAtrendLimit(int atrendlimit){
        this.atrendlimit = atrendlimit;
    }

    public void aliseon_setAtrend_id(ArrayList<String> atrend_id){
        this.atrend_id = atrend_id;
    }
    public void aliseon_setAtrend_user_id(ArrayList<String> atrend_user_id){
        this.atrend_user_id = atrend_user_id;
    }
    public void aliseon_setAtrend_type(ArrayList<String> atrend_type){
        this.atrend_type = atrend_type;
    }
    public void aliseon_setAtrend_product_id(ArrayList<String> atrend_product_id){
        this.atrend_product_id = atrend_product_id;
    }
    public void aliseon_setAtrend_contents_id(ArrayList<String> atrend_contents_id){
        this.atrend_contents_id = atrend_contents_id;
    }
    public void aliseon_setAtrend_title(ArrayList<String> atrend_title){
        this.atrend_title = atrend_title;
    }
    public void aliseon_setAtrend_sub_title(ArrayList<String> atrend_subtitle){
        this.atrend_subtitle = atrend_subtitle;
    }
    public void aliseon_setAtrend_description(ArrayList<String> atrend_description){
        this.atrend_description = atrend_description;
    }
    public void aliseon_setAtrend_summary(ArrayList<String> atrend_summary){
        this.atrend_summary = atrend_summary;
    }
    public void aliseon_setAtrend_view(ArrayList<Integer> atrend_view){
        this.atrend_view = atrend_view;
    }
    public void aliseon_setAtrend_like(ArrayList<Integer> atrend_like){
        this.atrend_like = atrend_like;
    }
    public void aliseon_setAtrend_color(ArrayList<String> atrend_color){
        this.atrend_color = atrend_color;
    }
    public void aliseon_setAtrend_start_at(ArrayList<String> atrend_start_at){
        this.atrend_start_at = atrend_start_at;
    }
    public void aliseon_setAtrend_create_at(ArrayList<String> atrend_create_at){
        this.atrend_create_at = atrend_create_at;
    }
    public void aliseon_setAtrend_update_at(ArrayList<String> atrend_update_at){
        this.atrend_update_at = atrend_update_at;
    }
    public void aliseon_setAtrend_opacity(ArrayList<String> atrend_opacity){
        this.atrend_opacity = atrend_opacity;
    }
    public void aliseon_setAtrend_status(ArrayList<Integer> atrend_status){
        this.atrend_status = atrend_status;
    }
    public void aliseon_setAtrend_background(ArrayList<String> atrend_background){
        this.atrend_background = atrend_background;
    }
    public void aliseon_setAtrend_thumbnail(ArrayList<String> atrend_thumbnail){
        this.atrend_thumbnail = atrend_thumbnail;
    }

    // AtrendDetail
    // get
    public String aliseon_getAtrend_detail_title() { return atrend_detail_title; }
    public ArrayList<String> aliseon_getAtrend_detail_maincontent() { return atrend_detail_maincontent; }
    public ArrayList<String> aliseon_getAtrend_detail_detp_htmp() { return atrend_detail_detp_html; }
    public ArrayList<String> aliseon_getAtrend_detail_product_id() { return atrend_detail_product_id; }
    public ArrayList<String> aliseon_getAtrend_detail_product_name() { return atrend_detail_product_name; }
    public ArrayList<String> aliseon_getAtrend_detail_product_brand() { return atrend_detail_product_brand; }
    public ArrayList<String> aliseon_getAtrend_detail_product_thumbnail() { return atrend_detail_product_thumbnail; }
    public ArrayList<String> aliseon_getAtrend_detail_product_price() { return atrend_detail_product_price; }
    public ArrayList<String> aliseon_getAtrend_detail_product_previous_price() { return atrend_detail_product_previous_price; }

    // set
    public void aliseon_setAtrend_detail_title(String atrend_detail_title) { this.atrend_detail_title = atrend_detail_title; }
    public void aliseon_setAtrend_detail_maincontent (ArrayList<String> atrend_detail_maincontent) { this.atrend_detail_maincontent = atrend_detail_maincontent;}
    public void aliseon_setAtrend_detail_detp_html (ArrayList<String> atrend_detail_detp_html) { this.atrend_detail_detp_html = atrend_detail_detp_html;}
    public void aliseon_setAtrend_detail_product_id (ArrayList<String> atrend_detail_product_id) { this.atrend_detail_product_id = atrend_detail_product_id;}
    public void aliseon_setAtrend_detail_product_name (ArrayList<String> atrend_detail_product_name) { this.atrend_detail_product_name = atrend_detail_product_name;}
    public void aliseon_setAtrend_detail_product_brand (ArrayList<String> atrend_detail_product_brand) { this.atrend_detail_product_brand = atrend_detail_product_brand;}
    public void aliseon_setAtrend_detail_product_thumbnail (ArrayList<String> atrend_detail_product_thumbnail) { this.atrend_detail_product_thumbnail = atrend_detail_product_thumbnail;}
    public void aliseon_setAtrend_detail_product_price (ArrayList<String> atrend_detail_product_price) { this.atrend_detail_product_price = atrend_detail_product_price;}
    public void aliseon_setAtrend_detail_product_previous_price (ArrayList<String> atrend_detail_product_previous_price) { this.atrend_detail_product_previous_price = atrend_detail_product_previous_price;}

    // AtrendRelated
    // get
    public ArrayList<String> aliseon_getAtrend_related_id() { return atrend_related_id; }
    public ArrayList<String> aliseon_getAtrend_related_user_id() { return atrend_related_user_id; }
    public ArrayList<String> aliseon_getAtrend_related_type() { return atrend_related_type; }
    public ArrayList<String> aliseon_getAtrend_related_product_id() { return atrend_related_product_id; }
    public ArrayList<String> aliseon_getAtrend_related_contents_id() { return atrend_related_contents_id; }
    public ArrayList<String> aliseon_getAtrend_related_title() { return atrend_related_title; }
    public ArrayList<String> aliseon_getAtrend_related_subtitle() { return atrend_related_subtitle; }
    public ArrayList<String> aliseon_getAtrend_related_description() { return atrend_related_description; }
    public ArrayList<String> aliseon_getAtrend_related_summary() { return atrend_related_summary; }
    public ArrayList<String> aliseon_getAtrend_related_view() { return atrend_related_view; }
    public ArrayList<String> aliseon_getAtrend_related_like() { return atrend_related_like; }
    public ArrayList<String> aliseon_getAtrend_related_color() { return atrend_related_color; }
    public ArrayList<String> aliseon_getAtrend_related_start_at() { return atrend_related_start_at; }
    public ArrayList<String> aliseon_getAtrend_related_create_at() { return atrend_related_create_at; }
    public ArrayList<String> aliseon_getAtrend_related_update_at() { return atrend_related_update_at; }
    public ArrayList<String> aliseon_getAtrend_related_opacity() { return atrend_related_opacity; }
    public ArrayList<String> aliseon_getAtrend_related_status() { return atrend_related_status; }
    public ArrayList<String> aliseon_getAtrend_related_background() { return atrend_related_background; }
    public ArrayList<String> aliseon_getAtrend_related_thumbnail() { return atrend_related_thumbnail; }

    // set
    public void aliseon_setAtrend_related_id(ArrayList<String> atrend_related_id ) { this.atrend_related_id = atrend_related_id; }
    public void aliseon_setAtrend_related_user_id(ArrayList<String> atrend_related_user_id ) { this.atrend_related_user_id = atrend_related_user_id; }
    public void aliseon_setAtrend_related_type(ArrayList<String> atrend_related_type ) { this.atrend_related_type = atrend_related_type; }
    public void aliseon_setAtrend_related_product_id(ArrayList<String> atrend_related_product_id ) { this.atrend_related_product_id = atrend_related_product_id; }
    public void aliseon_setAtrend_related_contents_id(ArrayList<String> atrend_related_contents_id ) { this.atrend_related_contents_id = atrend_related_contents_id; }
    public void aliseon_setAtrend_related_title(ArrayList<String> atrend_related_title ) { this.atrend_related_title = atrend_related_title; }
    public void aliseon_setAtrend_related_subtitle(ArrayList<String> atrend_related_subtitle ) { this.atrend_related_subtitle = atrend_related_subtitle; }
    public void aliseon_setAtrend_related_description(ArrayList<String> atrend_related_description ) { this.atrend_related_description = atrend_related_description; }
    public void aliseon_setAtrend_related_summary(ArrayList<String> atrend_related_summary ) { this.atrend_related_summary = atrend_related_summary; }
    public void aliseon_setAtrend_related_view(ArrayList<String> atrend_related_view ) { this.atrend_related_view = atrend_related_view; }
    public void aliseon_setAtrend_related_like(ArrayList<String> atrend_related_like ) { this.atrend_related_like = atrend_related_like; }
    public void aliseon_setAtrend_related_color(ArrayList<String> atrend_related_color ) { this.atrend_related_color = atrend_related_color; }
    public void aliseon_setAtrend_related_start_at(ArrayList<String> atrend_related_start_at ) { this.atrend_related_start_at = atrend_related_start_at; }
    public void aliseon_setAtrend_related_create_at(ArrayList<String> atrend_related_create_at ) { this.atrend_related_create_at = atrend_related_create_at; }
    public void aliseon_setAtrend_related_update_at(ArrayList<String> atrend_related_update_at ) { this.atrend_related_update_at = atrend_related_update_at; }
    public void aliseon_setAtrend_related_opacity(ArrayList<String> atrend_related_opacity ) { this.atrend_related_opacity = atrend_related_opacity; }
    public void aliseon_setAtrend_related_status(ArrayList<String> atrend_related_status ) { this.atrend_related_status = atrend_related_status; }
    public void aliseon_setAtrend_related_background(ArrayList<String> atrend_related_background ) { this.atrend_related_background = atrend_related_background; }
    public void aliseon_setAtrend_related_thumbnail(ArrayList<String> atrend_related_thumbnail ) { this.atrend_related_thumbnail = atrend_related_thumbnail; }

    //popular
    //get
    public int aliseon_getPopularStart(){
        return popularstart;
    }
    public int aliseon_getPopularLimit(){
        return popularlimit;
    }

    public ArrayList<String> aliseon_getPopular_id(){
        return popular_id;
    }
    public ArrayList<String> aliseon_getPopular_user_id(){
        return popular_user_id;
    }
    public ArrayList<String> aliseon_getPopular_product_id(){
        return popular_product_id;
    }
    public ArrayList<String> aliseon_getPopular_contents_id(){
        return popular_contents_id;
    }
    public ArrayList<String> aliseon_getPopular_contents_type(){
        return popular_contents_type;
    }
    public ArrayList<String> aliseon_getPopular_category_id(){
        return popular_category_id;
    }
    public ArrayList<Integer> aliseon_getPopular_status(){
        return popular_status;
    }
    public ArrayList<String> aliseon_getPopular_description(){
        return popular_description;
    }
    public ArrayList<String> aliseon_getPopular_create_at(){
        return popular_create_at;
    }
    public ArrayList<String> aliseon_getPopular_update_at(){
        return popular_update_at;
    }
    public ArrayList<Integer> aliseon_getPopular_like_count(){
        return popular_like_count;
    }
    public ArrayList<Integer> aliseon_getPopular_view_count(){
        return popular_view_count;
    }
    public ArrayList<Integer> aliseon_getPopular_comment_count(){
        return popular_comment_count;
    }
    public ArrayList<String> aliseon_getPopular_category_en(){
        return popular_category_en;
    }
    public ArrayList<String> aliseon_getPopular_category_kr(){
        return popular_category_kr;
    }
    public ArrayList<String> aliseon_getPopular_nickname(){
        return popular_nickname;
    }
    public ArrayList<String> aliseon_getPopular_photo(){
        return popular_photo;
    }
    public ArrayList<ArrayList<String>> aliseon_getPopular_p_thumbnail(){ return popular_p_thumbnail; }
    public ArrayList<String> aliseon_getPopular(){
        return popular_c_thumbnail;
    }

    //set
    public void aliseon_setPopularStart(int popularstart){
        this.popularstart = popularstart;
    }
    public void aliseon_setPopularLimit(int popularlimit){
        this.popularlimit = popularlimit;
    }

    public void aliseon_setPopular_id(ArrayList<String> popular_id){
        this.popular_id = popular_id;
    }
    public void aliseon_setPopular_user_id(ArrayList<String> popular_user_id){
        this.popular_user_id = popular_user_id;
    }
    public void aliseon_setPopular_product_id(ArrayList<String> popular_product_id){
        this.popular_product_id = popular_product_id;
    }
    public void aliseon_setPopular_contents_id(ArrayList<String> popular_contents_id){
        this.popular_contents_id = popular_contents_id;
    }
    public void aliseon_setPopular_contents_type(ArrayList<String> popular_contents_type){
        this.popular_contents_type = popular_contents_type;
    }
    public void aliseon_setPopular_category_id(ArrayList<String> popular_category_id){
        this.popular_category_id = popular_category_id;
    }
    public void aliseon_setPopular_status(ArrayList<Integer> popular_status){
        this.popular_status = popular_status;
    }
    public void aliseon_setPopular_description(ArrayList<String> popular_description){
        this.popular_description = popular_description;
    }
    public void aliseon_setPopular_create_at(ArrayList<String> popular_create_at){
        this.popular_create_at = popular_create_at;
    }
    public void aliseon_setPopular_update_at(ArrayList<String> popular_update_at){
        this.popular_update_at = popular_update_at;
    }
    public void aliseon_setPopular_like_count(ArrayList<Integer> popular_like_count){
        this.popular_like_count = popular_like_count;
    }
    public void aliseon_setPopular_view_count(ArrayList<Integer> popular_view_count){
        this.popular_view_count = popular_view_count;
    }
    public void aliseon_setPopular_comment_count(ArrayList<Integer> popular_comment_count){
        this.popular_comment_count = popular_comment_count;
    }
    public void aliseon_setPopular_category_en(ArrayList<String> popular_category_en){
        this.popular_category_en = popular_category_en;
    }
    public void aliseon_setPopular_category_kr(ArrayList<String> popular_category_kr){
        this.popular_category_kr = popular_category_kr;
    }
    public void aliseon_setPopular_nickname(ArrayList<String> popular_nickname){
        this.popular_nickname = popular_nickname;
    }
    public void aliseon_setPopular_photo(ArrayList<String> popular_photo){
        this.popular_photo = popular_photo;
    }
    public void aliseon_setPopular_p_thumbnail(ArrayList<ArrayList<String>> popular_p_thumbnail){
        this.popular_p_thumbnail = popular_p_thumbnail;
    }

    // PopularDetail
    // get
    public ArrayList<String> aliseon_getPopular_detail_id(){ return popular_detail_id; }
    public ArrayList<String> aliseon_getPopular_detail_user_id(){ return popular_detail_user_id; }
    public ArrayList<String> aliseon_getPopular_detail_product_id(){ return popular_detail_product_id; }
    public ArrayList<String> aliseon_getPopular_detail_contents_id(){ return popular_detail_contents_id; }
    public ArrayList<String> aliseon_getPopular_detail_contents_type(){ return popular_detail_contents_type; }
    public ArrayList<String> aliseon_getPopular_detail_category_id(){ return popular_detail_category_id; }
    public ArrayList<String> aliseon_getPopular_detail_status(){ return popular_detail_status; }
    public ArrayList<String> aliseon_getPopular_detail_description(){ return popular_detail_description; }
    public ArrayList<String> aliseon_getPopular_detail_create_at(){ return popular_detail_create_at; }
    public ArrayList<String> aliseon_getPopular_detail_update_at(){ return popular_detail_update_at; }
    public ArrayList<String> aliseon_getPopular_detail_like_count(){ return popular_detail_like_count; }
    public ArrayList<String> aliseon_getPopular_detail_view_count(){ return popular_detail_view_count; }
    public ArrayList<String> aliseon_getPopular_detail_comment_count(){ return popular_detail_comment_count; }
    public ArrayList<String> aliseon_getPopular_detail_category_en(){ return popular_detail_category_en; }
    public ArrayList<String> aliseon_getPopular_detail_category_kr(){ return popular_detail_category_kr; }
    public ArrayList<String> aliseon_getPopular_detail_name(){ return popular_detail_name; }
    public ArrayList<String> aliseon_getPopular_detail_photo(){ return popular_detail_photo; }
    public ArrayList<String> aliseon_getPopular_detail_contents(){ return popular_detail_contents; }
    public ArrayList<String> aliseon_getPopular_detail_items(){ return popular_detail_items; }

    public ArrayList<String> aliseon_getPopular_detail_item_id() { return popular_detail_item_id;}
    public ArrayList<String> aliseon_getPopular_detail_item_name() { return popular_detail_item_name;}; public ArrayList<String> aliseon_getPopular_detail_item_brand() { return popular_detail_item_brand;}
    public ArrayList<String> aliseon_getPopular_detail_item_thumbnail() { return popular_detail_item_thumbnail;}
    public ArrayList<String> aliseon_getPopular_detail_item_price() { return popular_detail_item_price;}
    public ArrayList<String> aliseon_getPopular_detail_item_previous_price() { return popular_detail_item_previous_price;}

    // set
    public void aliseon_setPopular_detail_id(ArrayList<String> popular_detail_id){ this.popular_detail_id = popular_detail_id; }
    public void aliseon_setPopular_detail_user_id(ArrayList<String> popular_detail_user_id){ this.popular_detail_user_id = popular_detail_user_id; }
    public void aliseon_setPopular_detail_product_id(ArrayList<String> popular_detail_product_id){ this.popular_detail_product_id = popular_detail_product_id; }
    public void aliseon_setPopular_detail_contents_id(ArrayList<String> popular_detail_contents_id){ this.popular_detail_contents_id = popular_detail_contents_id; }
    public void aliseon_setPopular_detail_contents_type(ArrayList<String> popular_detail_contents_type){ this.popular_detail_contents_type = popular_detail_contents_type; }
    public void aliseon_setPopular_detail_category_id(ArrayList<String> popular_detail_category_id){ this.popular_detail_category_id = popular_detail_category_id;}
    public void aliseon_setPopular_detail_status(ArrayList<String> popular_detail_status){ this.popular_detail_status = popular_detail_status; }
    public void aliseon_setPopular_detail_description(ArrayList<String> popular_detail_description){ this.popular_detail_description = popular_detail_description;}
    public void aliseon_setPopular_detail_create_at(ArrayList<String> popular_detail_create_at){ this.popular_detail_create_at = popular_detail_create_at;}
    public void aliseon_setPopular_detail_update_at(ArrayList<String> popular_detail_update_at){ this.popular_detail_update_at = popular_detail_update_at;}
    public void aliseon_setPopular_detail_like_count(ArrayList<String> popular_detail_like_count){this.popular_detail_like_count = popular_detail_like_count;}
    public void aliseon_setPopular_detail_view_count(ArrayList<String> popular_detail_view_count){ this.popular_detail_view_count = popular_detail_view_count;}
    public void aliseon_setPopular_detail_comment_count(ArrayList<String> popular_detail_comment_count){ this.popular_detail_comment_count = popular_detail_comment_count;}
    public void aliseon_setPopular_detail_category_en(ArrayList<String> popular_detail_category_en){this.popular_detail_category_en = popular_detail_category_en; }
    public void aliseon_setPopular_detail_category_kr(ArrayList<String> popular_detail_category_kr){this.popular_detail_category_kr = popular_detail_category_kr;}
    public void aliseon_setPopular_detail_name(ArrayList<String> popular_detail_name){ this.popular_detail_name = popular_detail_name; }
    public void aliseon_setPopular_detail_photo(ArrayList<String> popular_detail_photo){ this.popular_detail_photo = popular_detail_photo;}
    public void aliseon_setPopular_detail_contents(ArrayList<String> popular_detail_contents){ this.popular_detail_contents = popular_detail_contents; }
    public void aliseon_setPopular_detail_items(ArrayList<String> popular_detail_items){ this.popular_detail_items = popular_detail_items; }

    public void aliseon_setPopular_detail_item_id(ArrayList<String> popular_detail_item_id){ this.popular_detail_item_id = popular_detail_item_id; }
    public void aliseon_setPopular_detail_item_name(ArrayList<String> popular_detail_item_name){ this.popular_detail_item_name = popular_detail_item_name; }
    public void aliseon_setPopular_detail_item_brand(ArrayList<String> popular_detail_item_brand){ this.popular_detail_item_brand = popular_detail_item_brand; }
    public void aliseon_setPopular_detail_item_thumbnail(ArrayList<String> popular_detail_item_thumbnail){ this.popular_detail_item_thumbnail = popular_detail_item_thumbnail; }
    public void aliseon_setPopular_detail_item_price(ArrayList<String> popular_detail_item_price){ this.popular_detail_item_price = popular_detail_item_price; }
    public void aliseon_setPopular_detail_item_previous_price(ArrayList<String> popular_detail_item_previous_price){ this.popular_detail_item_previous_price = popular_detail_item_previous_price; }

    // PopularRelated
    // get
    public ArrayList<String> aliseon_getPopular_related_id() { return popular_related_id; }
    public ArrayList<String> aliseon_getPopular_related_user_id() { return popular_related_user_id; }
    public ArrayList<String> aliseon_getPopular_related_status() { return popular_related_status; }
    public ArrayList<String> aliseon_getPopular_related_description() { return popular_related_description; }
    public ArrayList<String> aliseon_getPopular_related_create_at() { return popular_related_create_at; }
    public ArrayList<String> aliseon_getPopular_related_update_at() { return popular_related_update_at; }
    public ArrayList<String> aliseon_getPopular_related_like_count() { return popular_related_like_count; }
    public ArrayList<String> aliseon_getPopular_related_view_count() { return popular_related_view_count; }
    public ArrayList<String> aliseon_getPopular_related_comment_count() { return popular_related_comment_count; }
    public ArrayList<String> aliseon_getPopular_related_contents() { return popular_related_contents; }

    // set
    public void aliseon_setPopular_related_id(ArrayList<String> popular_related_id ) { this.popular_related_id = popular_related_id; }
    public void aliseon_setPopular_related_user_id(ArrayList<String> popular_related_user_id ) { this.popular_related_user_id = popular_related_user_id; }
    public void aliseon_setPopular_related_status(ArrayList<String> popular_related_status ) { this.popular_related_status = popular_related_status; }
    public void aliseon_setPopular_related_description(ArrayList<String> popular_related_description ) { this.popular_related_description = popular_related_description; }
    public void aliseon_setPopular_related_create_at(ArrayList<String> popular_related_create_at ) { this.popular_related_create_at = popular_related_create_at; }
    public void aliseon_setPopular_related_update_at(ArrayList<String> popular_related_update_at ) { this.popular_related_update_at = popular_related_update_at; }
    public void aliseon_setPopular_related_like_count(ArrayList<String> popular_related_like_count ) { this.popular_related_like_count = popular_related_like_count; }
    public void aliseon_setPopular_related_view_count(ArrayList<String> popular_related_view_count ) { this.popular_related_view_count = popular_related_view_count; }
    public void aliseon_setPopular_related_comment_count(ArrayList<String> popular_related_comment_count ) { this.popular_related_comment_count = popular_related_comment_count; }
    public void aliseon_setPopular_related_contents(ArrayList<String> popular_related_contents ) { this.popular_related_contents = popular_related_contents; }


    //voyage
    //get
    public int aliseon_getVoyageStart(){
        return voyagestart;
    }
    public int aliseon_getVoyageLimit(){
        return voyagestart;
    }

    public ArrayList<String> aliseon_getVoyage_id(){
        return voyage_id;
    }
    public ArrayList<String> aliseon_getVoyage_user_id(){
        return voyage_user_id;
    }
    public ArrayList<String> aliseon_getVoyage_product_id(){
        return voyage_product_id;
    }
    public ArrayList<String> aliseon_getVoyage_contents_id(){
        return voyage_contents_id;
    }
    public ArrayList<String> aliseon_getVoyage_contents_type(){
        return voyage_contents_type;
    }
    public ArrayList<String> aliseon_getVoyage_category_id(){
        return voyage_category_id;
    }
    public ArrayList<Integer> aliseon_getVoyage_status(){
        return voyage_status;
    }
    public ArrayList<String> aliseon_getVoyage_description(){
        return voyage_description;
    }
    public ArrayList<String> aliseon_getVoyage_create_at(){
        return voyage_create_at;
    }
    public ArrayList<String> aliseon_getVoyage_update_at(){
        return voyage_update_at;
    }
    public ArrayList<Integer> aliseon_getVoyage_like_count(){
        return voyage_like_count;
    }
    public ArrayList<Integer> aliseon_getVoyage_view_count(){
        return voyage_view_count;
    }
    public ArrayList<Integer> aliseon_getVoyage_comment_count(){
        return voyage_comment_count;
    }
    public ArrayList<String> aliseon_getVoyage_category_en(){
        return voyage_category_en;
    }
    public ArrayList<String> aliseon_getVoyage_category_kr(){
        return voyage_category_kr;
    }
    public ArrayList<String> aliseon_getVoyage_nickname(){
        return voyage_nickname;
    }
    public ArrayList<String> aliseon_getVoyage_photo(){
        return voyage_photo;
    }
    public ArrayList<ArrayList<String>> aliseon_getVoyage_p_thumbnail(){ return voyage_p_thumbnail; }
    public ArrayList<String> aliseon_getVoyage_c_thumbnail(){
        return voyage_c_thumbnail;
    }

    public ArrayList<String> aliseon_getVoyage_cate_name(){
        return cate_name;
    }
    public ArrayList<Integer> aliseon_getVoyage_cate_number(){
        return cate_number;
    }

    //set
    public void aliseon_setVoyageStart(int voyagestart){
        this.voyagestart = voyagestart;
    }
    public void aliseon_setVoyageLimit(int voyagelimit){
        this.voyagelimit = voyagelimit;
    }

    public void aliseon_setVoyage_id(ArrayList<String> voyage_id){
        this.voyage_id = voyage_id;
    }
    public void aliseon_setVoyage_user_id(ArrayList<String> voyage_user_id){
        this.voyage_user_id = voyage_user_id;
    }
    public void aliseon_setVoyage_product_id(ArrayList<String> voyage_product_id){
        this.voyage_product_id = voyage_product_id;
    }
    public void aliseon_setVoyage_contents_id(ArrayList<String> voyage_contents_id){
        this.voyage_contents_id = voyage_contents_id;
    }
    public void aliseon_setVoyage_contents_type(ArrayList<String> voyage_contents_type){
        this.voyage_contents_type = voyage_contents_type;
    }
    public void aliseon_setVoyage_cateogory_id(ArrayList<String> voyage_category_id){
        this.voyage_category_id = voyage_category_id;
    }
    public void aliseon_setVoyage_status(ArrayList<Integer> voyage_status){
        this.voyage_status = voyage_status;
    }
    public void aliseon_setVoyage_description(ArrayList<String> voyage_description){
        this.voyage_description = voyage_description;
    }
    public void aliseon_setVoyage_create_at(ArrayList<String> voyage_create_at){
        this.voyage_create_at = voyage_create_at;
    }
    public void aliseon_setVoyage_update_at(ArrayList<String> voyage_update_at){
        this.voyage_update_at = voyage_update_at;
    }
    public void aliseon_setVoyage_like_count(ArrayList<Integer> voyage_like_count){
        this.voyage_like_count = voyage_like_count;
    }
    public void aliseon_setVoyage_view_count(ArrayList<Integer> voyage_view_count){
        this.voyage_view_count = voyage_view_count;
    }
    public void aliseon_setVoyage_comment_count(ArrayList<Integer> voyage_comment_count){
        this.voyage_comment_count = voyage_comment_count;
    }
    public void aliseon_setVoyage_category_en(ArrayList<String> voyage_category_en){
        this.voyage_category_en = voyage_category_en;
    }
    public void aliseon_setVoyage_category_kr(ArrayList<String> voyage_category_kr){
        this.voyage_category_kr = voyage_category_kr;
    }
    public void aliseon_setVoyage_nickname(ArrayList<String> voyage_nickname){
        this.voyage_nickname = voyage_nickname;
    }
    public void aliseon_setVoyage_photo(ArrayList<String> voyage_photo){
        this.voyage_photo = voyage_photo;
    }
    public void aliseon_setVoyage_p_thumbnail(ArrayList<ArrayList<String>> voyage_p_thumbnail){
        this.voyage_p_thumbnail = voyage_p_thumbnail;
    }

    public void aliseon_setVoyage_cate_name(ArrayList<String> cate_name){
        this.cate_name = cate_name;
    }
    public void aliseon_setVoyage_cate_number(ArrayList<Integer> cate_number){
        this.cate_number = cate_number;
    }

    // VoyageDetail
    // get
    public ArrayList<String> aliseon_getVoyage_detail_id() { return voyage_detail_id; }
    public ArrayList<String> aliseon_getVoyage_detail_user_id() { return voyage_detail_user_id; }
    public ArrayList<String> aliseon_getVoyage_detail_product_id() { return voyage_detail_product_id; }
    public ArrayList<String> aliseon_getVoyage_detail_contents_id() { return voyage_detail_contents_id; }
    public ArrayList<String> aliseon_getVoyage_detail_contents_type() { return voyage_detail_contents_type; }
    public ArrayList<String> aliseon_getVoyage_detail_category_id() { return voyage_detail_category_id; }
    public ArrayList<String> aliseon_getVoyage_detail_status() { return voyage_detail_status; }
    public ArrayList<String> aliseon_getVoyage_detail_description() { return voyage_detail_description; }
    public ArrayList<String> aliseon_getVoyage_detail_create_at() { return voyage_detail_create_at; }
    public ArrayList<String> aliseon_getVoyage_detail_update_at() { return voyage_detail_update_at; }
    public ArrayList<String> aliseon_getVoyage_detail_like_count() { return voyage_detail_like_count; }
    public ArrayList<String> aliseon_getVoyage_detail_view_count() { return voyage_detail_view_count; }
    public ArrayList<String> aliseon_getVoyage_detail_comment_count() { return voyage_detail_comment_count; }
    public ArrayList<String> aliseon_getVoyage_detail_category_en() { return voyage_detail_category_en; }
    public ArrayList<String> aliseon_getVoyage_detail_category_kr() { return voyage_detail_category_kr; }
    public ArrayList<String> aliseon_getVoyage_detail_nickname() { return voyage_detail_nickname; }
    public ArrayList<String> aliseon_getVoyage_detail_photo() { return voyage_detail_photo; }
    public ArrayList<String> aliseon_getVoyage_detail_contents() { return voyage_detail_contents; }
    public ArrayList<String> aliseon_getVoyage_detail_items() { return voyage_detail_items; }

    public ArrayList<String> aliseon_getVoyage_detail_item_id() { return voyage_detail_item_id; }
    public ArrayList<String> aliseon_getVoyage_detail_item_name() { return voyage_detail_item_name; }
    public ArrayList<String> aliseon_getVoyage_detail_item_brand() { return voyage_detail_item_brand; }
    public ArrayList<String> aliseon_getVoyage_detail_item_thumbnail() { return voyage_detail_item_thumbnail; }
    public ArrayList<String> aliseon_getVoyage_detail_item_price() { return voyage_detail_item_price; }
    public ArrayList<String> aliseon_getVoyage_detail_item_previous_price() { return voyage_detail_item_previous_price; }

    // set
    public void aliseon_setVoyage_detail_id(ArrayList<String> voyage_detail_id) { this.voyage_detail_id = voyage_detail_id; }
    public void aliseon_setVoyage_detail_user_id(ArrayList<String> voyage_detail_user_id) { this.voyage_detail_user_id = voyage_detail_user_id; }
    public void aliseon_setVoyage_detail_product_id(ArrayList<String> voyage_detail_product_id) { this.voyage_detail_product_id = voyage_detail_product_id; }
    public void aliseon_setVoyage_detail_contents_id(ArrayList<String> voyage_detail_contents_id) { this.voyage_detail_contents_id = voyage_detail_contents_id; }
    public void aliseon_setVoyage_detail_contents_type(ArrayList<String> voyage_detail_contents_type) { this.voyage_detail_contents_type = voyage_detail_contents_type; }
    public void aliseon_setVoyage_detail_category_id(ArrayList<String> voyage_detail_category_id) { this.voyage_detail_category_id = voyage_detail_category_id; }
    public void aliseon_setVoyage_detail_status(ArrayList<String> voyage_detail_status) { this.voyage_detail_status = voyage_detail_status; }
    public void aliseon_setVoyage_detail_description(ArrayList<String> voyage_detail_description) { this.voyage_detail_description = voyage_detail_description; }
    public void aliseon_setVoyage_detail_create_at(ArrayList<String> voyage_detail_create_at) { this.voyage_detail_create_at = voyage_detail_create_at; }
    public void aliseon_setVoyage_detail_update_at(ArrayList<String> voyage_detail_update_at) { this.voyage_detail_update_at = voyage_detail_update_at; }
    public void aliseon_setVoyage_detail_like_count(ArrayList<String> voyage_detail_like_count) { this.voyage_detail_like_count = voyage_detail_like_count; }
    public void aliseon_setVoyage_detail_view_count(ArrayList<String> voyage_detail_view_count) { this.voyage_detail_view_count = voyage_detail_view_count; }
    public void aliseon_setVoyage_detail_comment_count(ArrayList<String> voyage_detail_comment_count) { this.voyage_detail_comment_count = voyage_detail_comment_count; }
    public void aliseon_setVoyage_detail_category_en(ArrayList<String> voyage_detail_category_en) { this.voyage_detail_category_en = voyage_detail_category_en; }
    public void aliseon_setVoyage_detail_category_kr(ArrayList<String> voyage_detail_category_kr) { this.voyage_detail_category_kr = voyage_detail_category_kr; }
    public void aliseon_setVoyage_detail_nickname(ArrayList<String> voyage_detail_nickname) { this.voyage_detail_nickname = voyage_detail_nickname; }
    public void aliseon_setVoyage_detail_photo(ArrayList<String> voyage_detail_photo) { this.voyage_detail_photo = voyage_detail_photo; }
    public void aliseon_setVoyage_detail_contents(ArrayList<String> voyage_detail_contents) { this.voyage_detail_contents = voyage_detail_contents; }
    public void aliseon_setVoyage_detail_items(ArrayList<String> voyage_detail_items) { this.voyage_detail_items = voyage_detail_items; }

    public void aliseon_setVoyage_detail_item_id(ArrayList<String> voyage_detail_item_id) { this.voyage_detail_item_id = voyage_detail_item_id; }
    public void aliseon_setVoyage_detail_item_name(ArrayList<String> voyage_detail_item_name) { this.voyage_detail_item_name = voyage_detail_item_name; }
    public void aliseon_setVoyage_detail_item_brand(ArrayList<String> voyage_detail_item_brand) { this.voyage_detail_item_brand = voyage_detail_item_brand; }
    public void aliseon_setVoyage_detail_item_thumbnail(ArrayList<String> voyage_detail_item_thumbnail) { this.voyage_detail_item_thumbnail = voyage_detail_item_thumbnail; }
    public void aliseon_setVoyage_detail_item_price(ArrayList<String> voyage_detail_item_price) { this.voyage_detail_item_price = voyage_detail_item_price; }
    public void aliseon_setVoyage_detail_item_previous_price(ArrayList<String> voyage_detail_item_previous_price) { this.voyage_detail_item_previous_price = voyage_detail_item_previous_price; }

    // VoyageRelated
    // get
    public ArrayList<String> aliseon_getVoyage_related_id() { return voyage_related_id; }
    public ArrayList<String> aliseon_getVoyage_related_user_id() { return voyage_related_user_id; }
    public ArrayList<String> aliseon_getVoyage_related_status() { return voyage_related_status; }
    public ArrayList<String> aliseon_getVoyage_related_description() { return voyage_related_description; }
    public ArrayList<String> aliseon_getVoyage_related_create_at() { return voyage_related_create_at; }
    public ArrayList<String> aliseon_getVoyage_related_update_at() { return voyage_related_update_at; }
    public ArrayList<String> aliseon_getVoyage_related_like_count() { return voyage_related_like_count; }
    public ArrayList<String> aliseon_getVoyage_related_view_count() { return voyage_related_view_count; }
    public ArrayList<String> aliseon_getVoyage_related_comment_count() { return voyage_related_comment_count; }
    public ArrayList<String> aliseon_getVoyage_related_contents() { return voyage_related_contents; }

    // set
    public void aliseon_setVoyage_related_id(ArrayList<String> voyage_related_id) { this.voyage_related_id = voyage_related_id; }
    public void aliseon_setVoyage_related_user_id(ArrayList<String> voyage_related_user_id) { this.voyage_related_user_id = voyage_related_user_id; }
    public void aliseon_setVoyage_related_status(ArrayList<String> voyage_related_status) { this.voyage_related_status = voyage_related_status; }
    public void aliseon_setVoyage_related_description(ArrayList<String> voyage_related_description) { this.voyage_related_description = voyage_related_description; }
    public void aliseon_setVoyage_related_create_at(ArrayList<String> voyage_related_create_at) { this.voyage_related_create_at = voyage_related_create_at; }
    public void aliseon_setVoyage_related_update_at(ArrayList<String> voyage_related_update_at) { this.voyage_related_update_at = voyage_related_update_at; }
    public void aliseon_setVoyage_related_like_count(ArrayList<String> voyage_related_like_count) { this.voyage_related_like_count = voyage_related_like_count; }
    public void aliseon_setVoyage_related_view_count(ArrayList<String> voyage_related_view_count) { this.voyage_related_view_count = voyage_related_view_count; }
    public void aliseon_setVoyage_related_comment_count(ArrayList<String> voyage_related_comment_count) { this.voyage_related_comment_count = voyage_related_comment_count; }
    public void aliseon_setVoyage_related_contents(ArrayList<String> voyage_related_contents) { this.voyage_related_contents = voyage_related_contents; }

    //aliseon player
    //get
    public ArrayList<String> aliseon_getPlayer_feed_list_author_id(){
        return player_feed_list_author_id;
    }
    public ArrayList<String> aliseon_getPlayer_feed_list_crop(){
        return player_feed_list_crop;
    }
    public ArrayList<String> aliseon_getPlayer_feed_list_id(){
        return player_feed_list_id;
    }
    public ArrayList<String> aliseon_getPlayer_feed_list_content(){
        return player_feed_list_content;
    }
    public ArrayList<String> aliseon_getPlayer_feed_list_author_picture(){
        return player_feed_list_author_picture;
    }
    public ArrayList<String> aliseon_getPlayer_feed_list_author_nickname(){
        return player_feed_list_author_nickname;
    }
    public ArrayList<Integer> aliseon_getPlayer_feed_list_views(){
        return player_feed_list_views;
    }

    //set
    public void aliseon_setPlayer_feed_list_author_id(ArrayList<String> player_feed_list_author_id){
        this.player_feed_list_author_id = player_feed_list_author_id;
    }
    public void aliseon_setPlayer_feed_list_crop(ArrayList<String> player_feed_list_crop){
        this.player_feed_list_crop = player_feed_list_crop;
    }
    public void aliseon_setPlayer_feed_list_id(ArrayList<String> player_feed_list_id){
        this.player_feed_list_id = player_feed_list_id;
    }
    public void aliseon_setPlayer_feed_list_content(ArrayList<String> player_feed_list_content){
        this.player_feed_list_content = player_feed_list_content;
    }
    public void aliseon_setPlayer_feed_list_author_picture(ArrayList<String> player_feed_list_author_picture){
        this.player_feed_list_author_picture = player_feed_list_author_picture;
    }
    public void aliseon_setPlayer_feed_list_author_nickname(ArrayList<String> player_feed_list_author_nickname){
        this.player_feed_list_author_nickname = player_feed_list_author_nickname;
    }
    public void aliseon_setPlayer_feed_list_views(ArrayList<Integer> player_feed_list_views){
        this.player_feed_list_views = player_feed_list_views;
    }

    public void aliseon_clearPlayer_feed_list_author_id(){
        player_feed_list_author_id.clear();
    }
    public void aliseon_clearPlayer_feed_list_crop(){
        player_feed_list_crop.clear();
    }
    public void aliseon_clearPlayer_feed_list_id(){
        player_feed_list_id.clear();
    }
    public void aliseon_clearPlayer_feed_list_content(){
        player_feed_list_content.clear();
    }
    public void aliseon_clearPlayer_feed_list_author_picture(){
        player_feed_list_author_picture.clear();
    }
    public void aliseon_clearPlayer_feed_list_author_nickname(){
        player_feed_list_author_nickname.clear();
    }
    public void aliseon_clearPlayer_feed_list_views(){
        player_feed_list_views.clear();
    }

    //Player 변수
    // 구독 하고있는지 아닌지 체크
    //get
    public int aliseon_getSubscribe_checker(){
        return subscribe_checker;
    }
    public int aliseon_getRefresh_num(){
        return refresh_num;
    }

    public int aliseon_getSelect(){
        return select;
    }
    public int aliseon_getType_selector(){
        return typeselector;
    }

    public String  aliseon_getMain_title(){
        return maintitle;
    }
    public String aliseon_getSub_title(){
        return subtitle;
    }
    public String aliseon_getCreator_title(){
        return creatortitle;
    }
    public String aliseon_getCreator_profile(){
        return creatorprofile;
    }
    public String aliseon_getCreator_author_id(){
        return creatorauthorid;
    }

    public int aliseon_getChild_list(){
        return childlist;
    }
    public int aliseon_getContent_counter(){
        return contentcounter;
    }

    public int aliseon_getCategory_num(){
        return category_num;
    }
    public int aliseon_getCategory_id(){
        return category_id;
    }

    //set
    public void aliseon_setSubscribe_checker(int subscribe_checker){
        this.subscribe_checker = subscribe_checker;
    }
    public void aliseon_setRefresh_num(int refresh_num){
        this.refresh_num = refresh_num;
    }

    public void aliseon_setMain_title(String maintitle){
        this.maintitle = maintitle;
    }
    public void aliseon_setSub_title(String subtitle){
        this.subtitle = subtitle;
    }
    public void aliseon_setCreator_title(String creatortitle){
        this.creatortitle = creatortitle;
    }
    public void aliseon_setCreator_profile(String creatorprofile){
        this.creatorprofile = creatorprofile;
    }
    public void aliseon_setCreator_author_id(String creatorauthorid){
        this.creatorauthorid = creatorauthorid;
    }

    public void aliseon_setType_selector(int typeselector){
        this.typeselector = typeselector;
    }
    public void aliseon_setSelect(int select){
        this.select = select;
    }

    public void aliseon_setChild_list(int childlist){
        this.childlist = childlist;
    }
    public void aliseon_setContent_count(int contentcounter){
        this.contentcounter = contentcounter;
    }

    public void aliseon_setCategory_num(int category_num){
        this.category_num = category_num;
    }
    public void aliseon_setCategory_id(int category_id){
        this.category_id = category_id;
    }


    // subscribe param
    // get
    public int aliseon_getSubscribe_select_creator_id() {
        return subscribe_select_creator_id;
    }
    public int aliseon_getSubscribe_select_creator_num() {
        return subscribe_select_creator_num;
    }
    public int aliseon_getParam_creator_info() {return param_creator_info;}
    public String aliseon_getParam_subscribe_type() {return param_subscribe_type;}
    public int aliseon_getParam_subscribe_to_id() {return param_subscribe_to_id;}
    public int aliseon_getParam_subscribe_activity() { return param_subscribe_activity; }


    // set
    public void aliseon_setSubscribe_select_creator_id(int subscribe_select_creator_id) {
        this.subscribe_select_creator_id = subscribe_select_creator_id;
    }
    public void aliseon_setSubscribe_select_creator_num(int subscribe_select_creator_num) {
        this.subscribe_select_creator_num = subscribe_select_creator_num;
    }
    public void aliseon_setParam_creator_info(int param_creator_info) {this.param_creator_info = param_creator_info;}
    public void aliseon_setParam_subscribe_type(String param_subscribe_type) {
        this.param_subscribe_type = param_subscribe_type;
    }
    public void aliseon_setParam_subscribe_to_id(int param_subscribe_to_id) {
        this.param_subscribe_to_id = param_subscribe_to_id;
    }
    public void aliseon_setParam_subscribe_activity(int param_subscribe_activity) {
        this.param_subscribe_activity = param_subscribe_activity;
    }

    // Subscribe From
    // get
    public ArrayList<Integer> aliseon_getSubscribe_creator_list_id() {
        return subscribe_creator_list_id;
    }
    public ArrayList<String> aliseon_getSubscribe_creator_list_nickname() {
        return subscribe_creator_list_nickname;
    }
    public ArrayList<String> aliseon_getSubscribe_creator_list_photo() {
        return subscribe_creator_list_photo;
    }

    // set
    public void aliseon_setSubscribe_creator_list_id(ArrayList<Integer> subscribe_creator_list_id) {
        this.subscribe_creator_list_id = subscribe_creator_list_id;
    }
    public void aliseon_setSubscribe_creator_list_nickname(ArrayList<String> subscribe_creator_list_nickname) {
        this.subscribe_creator_list_nickname = subscribe_creator_list_nickname;
    }
    public void aliseon_setSubscribe_creator_list_photo(ArrayList<String> subscribe_creator_list_photo) {
        this.subscribe_creator_list_photo = subscribe_creator_list_photo;
    }

    // subscribe_voyage
    // get
    public int aliseon_getSubscribeVoyageStart() {
        return subscribevoyagestart;
    }
    public int aliseon_getSubscribeVoyageLimit() {
        return subscribevoyagelimit;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_id() {
        return subscribe_voyage_list_id;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_user_id() {
        return subscribe_voyage_list_user_id;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_product_id() {
        return subscribe_voyage_list_product_id;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_contents_id() {
        return subscribe_voyage_list_contents_id;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_contents_type() {
        return subscribe_voyage_list_contents_type;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_category_id() {
        return subscribe_voyage_list_category_id;
    }
    public ArrayList<Integer> aliseon_getSubscribe_voyage_list_status() {
        return subscribe_voyage_list_status;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_create_at() {
        return subscribe_voyage_list_create_at;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_update_at() {
        return subscribe_voyage_list_update_at;
    }
    public ArrayList<Integer> aliseon_getSubscribe_voyage_list_like_count() {
        return subscribe_voyage_list_like_count;
    }
    public ArrayList<Integer> aliseon_getSubscribe_voyage_list_view_count() {
        return subscribe_voyage_list_view_count;
    }
    public ArrayList<Integer> aliseon_getSubscribe_voyage_list_comment_count() {
        return subscribe_voyage_list_comment_count;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_category_en() {
        return subscribe_voyage_list_category_en;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_category_kr() {
        return subscribe_voyage_list_category_kr;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_nickname() {
        return subscribe_voyage_list_nickname;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_photo() {
        return subscribe_voyage_list_photo;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_description() {
        return subscribe_voyage_list_description;
    }
    public ArrayList<ArrayList<String>> aliseon_getSubscribe_voyage_list_p_thumbnail() {
        return subscribe_voyage_list_p_thumbnail;
    }
    public ArrayList<String> aliseon_getSubscribe_voyage_list_c_thumbnail() {
        return subscribe_voyage_list_c_thumbnail;
    }

    // set
    public void aliseon_setSubscribeVoyageStart(int subscribevoyagestart) {
        this.subscribevoyagestart = subscribevoyagestart;
    }
    public void aliseon_setSubscribeVoyageLimit(int subscribevoyagelimit) {
        this.subscribevoyagelimit = subscribevoyagelimit;
    }
    public void aliseon_setSubscribe_voyage_list_id(ArrayList<String> subscribe_voyage_list_id) {
        this.subscribe_voyage_list_id = subscribe_voyage_list_id;
    }
    public void aliseon_setSubscribe_voyage_list_user_id(ArrayList<String> subscribe_voyage_list_user_id) {
        this.subscribe_voyage_list_user_id = subscribe_voyage_list_user_id;
    }
    public void aliseon_setSubscribe_voyage_list_product_id(ArrayList<String> subscribe_voyage_list_product_id) {
        this.subscribe_voyage_list_product_id = subscribe_voyage_list_product_id;
    }
    public void aliseon_setSubscribe_voyage_list_contents_id(ArrayList<String> subscribe_voyage_list_contents_id) {
        this.subscribe_voyage_list_contents_id = subscribe_voyage_list_contents_id;
    }
    public void aliseon_setSubscribe_voyage_list_contents_type(ArrayList<String> subscribe_voyage_list_contents_type) {
        this.subscribe_voyage_list_contents_type = subscribe_voyage_list_contents_type;
    }
    public void aliseon_setSubscribe_voyage_list_category_id(ArrayList<String> subscribe_voyage_list_category_id) {
        this.subscribe_voyage_list_category_id = subscribe_voyage_list_category_id;
    }
    public void aliseon_setSubscribe_voyage_list_status(ArrayList<Integer> subscribe_voyage_list_status) {
        this.subscribe_voyage_list_status = subscribe_voyage_list_status;
    }
    public void aliseon_setSubscribe_voyage_list_create_at(ArrayList<String> subscribe_voyage_list_create_at) {
        this.subscribe_voyage_list_create_at = subscribe_voyage_list_create_at;
    }
    public void aliseon_setSubscribe_voyage_list_update_at(ArrayList<String> subscribe_voyage_list_update_at) {
        this.subscribe_voyage_list_update_at = subscribe_voyage_list_update_at;
    }
    public void aliseon_setSubscribe_voyage_list_like_count(ArrayList<Integer> subscribe_voyage_list_like_count) {
        this.subscribe_voyage_list_like_count = subscribe_voyage_list_like_count;
    }
    public void aliseon_setSubscribe_voyage_list_view_count(ArrayList<Integer> subscribe_voyage_list_view_count) {
        this.subscribe_voyage_list_view_count = subscribe_voyage_list_view_count;
    }
    public void aliseon_setSubscribe_voyage_list_comment_count(ArrayList<Integer> subscribe_voyage_list_comment_count) {
        this.subscribe_voyage_list_comment_count = subscribe_voyage_list_comment_count;
    }
    public void aliseon_setSubscribe_voyage_list_category_en(ArrayList<String> subscribe_voyage_list_category_en) {
        this.subscribe_voyage_list_category_en = subscribe_voyage_list_category_en;
    }
    public void aliseon_setSubscribe_voyage_list_category_kr(ArrayList<String> subscribe_voyage_list_category_kr) {
        this.subscribe_voyage_list_category_kr = subscribe_voyage_list_category_kr;
    }
    public void aliseon_setSubscribe_voyage_list_nickname(ArrayList<String> subscribe_voyage_list_nickname) {
        this.subscribe_voyage_list_nickname = subscribe_voyage_list_nickname;
    }
    public void aliseon_setSubscribe_voyage_list_photo(ArrayList<String> subscribe_voyage_list_photo) {
        this.subscribe_voyage_list_photo = subscribe_voyage_list_photo;
    }
    public void aliseon_setSubscribe_voyage_list_description(ArrayList<String> subscribe_voyage_list_description) {
        this.subscribe_voyage_list_description = subscribe_voyage_list_description;
    }
    public void aliseon_setSubscribe_voyage_list_p_thumbnail(ArrayList<ArrayList<String>> subscribe_voyage_list_p_thumbnail) {
        this.subscribe_voyage_list_p_thumbnail = subscribe_voyage_list_p_thumbnail;
    }
    public void aliseon_setSubscribe_voyage_list_c_thumbnail(ArrayList<String> subscribe_voyage_list_c_thumbnail) {
        this.subscribe_voyage_list_c_thumbnail = subscribe_voyage_list_c_thumbnail;
    }

    // recommend
    // get
    public ArrayList<String> aliseon_getRecommend_id() { return recommend_id; }
    public ArrayList<String> aliseon_getRecommend_nickname() { return recommend_nickname; }
    public ArrayList<String> aliseon_getRecommend_photo() { return recommend_photo; }
    public ArrayList<String> aliseon_getRecommend_subscribeto_cnt() { return recommend_subscribeto_cnt; }
    public ArrayList<String> aliseon_getRecommend_contnets_cnt() { return recommend_contents_cnt; }

    // set
    public void aliseon_setRecommend_id(ArrayList<String> recommend_id) { this.recommend_id = recommend_id; }
    public void aliseon_setRecommend_nickname(ArrayList<String> recommend_nickname) { this.recommend_nickname = recommend_nickname; }
    public void aliseon_setRecommend_photo(ArrayList<String> recommend_photo) { this.recommend_photo = recommend_photo; }
    public void aliseon_setRecommend_subscribeto_cnt(ArrayList<String> recommend_subscribeto_cnt) { this.recommend_subscribeto_cnt = recommend_subscribeto_cnt; }
    public void aliseon_setRecommend_contents_cnt(ArrayList<String> recommend_contents_cnt) { this.recommend_contents_cnt = recommend_contents_cnt; }

    // My
    // get
    public int aliseon_getMystart() {
        return mystart;
    }
    public int aliseon_getMylimit() {
        return mylimit;
    }
    public String aliseon_getMy_id() { return my_id; }
    public String aliseon_getMy_nickname() { return my_nickname; }
    public String aliseon_getMy_photo() { return my_photo; }
    public String aliseon_getMy_zip() { return my_zip; }
    public String aliseon_getMy_city() { return my_city; }
    public String aliseon_getMy_state() { return my_state; }
    public String aliseon_getMy_address() { return my_address; }
    public String aliseon_getMy_subscribeto_cnt() { return my_subscribeto_cnt; }
    public String aliseon_getMy_contents_cnt() { return my_contents_cnt; }
    public String aliseon_getMy_desc() { return my_desc; }
    public ArrayList<String> aliseon_getMy_list_id() { return my_list_id; }
    public ArrayList<String> aliseon_getMy_list_user_id() { return my_list_user_id; }
    public ArrayList<Integer> aliseon_getMy_status() { return my_list_status; }
    public ArrayList<String> aliseon_getMy_list_description() { return my_list_description; }
    public ArrayList<String> aliseon_getMy_list_create_at() { return my_list_create_at; }
    public ArrayList<String> aliseon_getMy_list_update_at() { return my_list_update_at; }
    public ArrayList<Integer> aliseon_getMy_list_like_count() { return my_list_like_count; }
    public ArrayList<Integer> aliseon_getMy_list_view_count() { return my_list_view_count; }
    public ArrayList<Integer> aliseon_getMy_list_comment_count() { return my_list_comment_count; }
    public ArrayList<ArrayList<String>> aliseon_getMy_list_p_thumbnail() { return my_list_p_thumbnail; }
    public ArrayList<String> aliseon_getMy_list_nickname() { return my_list_nickname; }
    public ArrayList<String> aliseon_getMy_list_profile() { return my_list_profile; }

    // set
    public void aliseon_setMystart(int mystart) {
        this.mystart = mystart;
    }
    public void aliseon_setMylimit(int mylimit) {
        this.mylimit = mylimit;
    }
    public void aliseon_setMy_id(String my_id) { this.my_id = my_id; }
    public void aliseon_setMy_nickname(String my_nickname) { this.my_nickname = my_nickname; }
    public void aliseon_setMy_photo(String my_photo) { this.my_photo = my_photo; }
    public void aliseon_setMy_zip(String my_zip) { this.my_zip = my_zip; }
    public void aliseon_setMy_city(String my_city) { this.my_city = my_city; }
    public void aliseon_setMy_state(String my_state) { this.my_state = my_state; }
    public void aliseon_setMy_address(String my_address) { this.my_address = my_address; }
    public void aliseon_setMy_subscribeto_cnt(String my_subscribeto_cnt) { this.my_subscribeto_cnt = my_subscribeto_cnt; }
    public void aliseon_setMy_contents_cnt(String my_contents_cnt) { this.my_contents_cnt = my_contents_cnt; }
    public void aliseon_setMy_desc(String my_desc) { this.my_desc = my_desc; }
    public void aliseon_setMy_list_id(ArrayList<String> my_list_id) { this.my_list_id = my_list_id; }
    public void aliseon_setMy_list_user_id(ArrayList<String> my_list_user_id) { this.my_list_user_id = my_list_user_id; }
    public void aliseon_setMy_list_status(ArrayList<Integer> my_list_status) { this.my_list_status = my_list_status; }
    public void aliseon_setMy_list_description(ArrayList<String> my_list_description) { this.my_list_description = my_list_description; }
    public void aliseon_setMy_list_create_at(ArrayList<String> my_list_create_at) { this.my_list_create_at = my_list_create_at; }
    public void aliseon_setMy_list_update_at(ArrayList<String> my_list_update_at) { this.my_list_update_at = my_list_update_at; }
    public void aliseon_setMy_list_like_count(ArrayList<Integer> my_list_like_count) { this.my_list_like_count = my_list_like_count; }
    public void aliseon_setMy_list_view_count(ArrayList<Integer> my_list_view_count) { this.my_list_view_count = my_list_view_count; }
    public void aliseon_setMy_list_comment_count(ArrayList<Integer> my_list_comment_count) { this.my_list_comment_count = my_list_comment_count; }
    public void aliseon_setMy_list_p_thumbnail(ArrayList<ArrayList<String>> my_list_p_thumbnail) { this.my_list_p_thumbnail = my_list_p_thumbnail; }
    public void aliseon_setMy_list_nickname(ArrayList<String> my_list_nickname) { this.my_list_nickname = my_list_nickname; }
    public void aliseon_setMy_list_profile(ArrayList<String> my_list_profile) { this.my_list_profile = my_list_profile; }

    // MyDetail
    // get
    public ArrayList<Integer> aliseon_getMydetail_list_id() { return mydetail_list_id; }
    public ArrayList<String> aliseon_getMydetail_list_nickname() { return mydetail_list_nickname;}
    public ArrayList<String> aliseon_getMydetail_list_photo() { return mydetail_list_photo;}
    public ArrayList<Integer> aliseon_getMydetail_list_subscribeto_cnt() { return mydetail_list_subscribeto_cnt; }
    public ArrayList<Integer> aliseon_getMydetail_list_contents_cnt() { return mydetail_list_contents_cnt;}
    public ArrayList<Integer> aliseon_getMydetail_list_is_subscribe() { return mydetail_list_is_subscribe;}

    // set
    public void aliseon_setMydetail_list_id(ArrayList<Integer> mydetail_list_id) { this.mydetail_list_id = mydetail_list_id; }
    public void aliseon_setMydetail_list_nickname(ArrayList<String> mydetail_list_nickname) { this.mydetail_list_nickname = mydetail_list_nickname; }
    public void aliseon_setMydetail_list_photo(ArrayList<String> mydetail_list_photo) { this.mydetail_list_photo = mydetail_list_photo; }
    public void aliseon_setMydetail_list_subscribeto_cnt(ArrayList<Integer> mydetail_list_subscribeto_cnt) { this.mydetail_list_subscribeto_cnt = mydetail_list_subscribeto_cnt; }
    public void aliseon_setMydetail_list_contents_cnt (ArrayList<Integer> mydetail_list_contents_cnt) { this.mydetail_list_contents_cnt = mydetail_list_contents_cnt; }
    public void aliseon_setMydetail_list_is_subscribe(ArrayList<Integer> mydetail_list_is_subscribe) { this.mydetail_list_is_subscribe = mydetail_list_is_subscribe; }

    // Creator
    // get
    public int aliseon_getCreatorstart() { return creatorstart; }
    public int aliseon_getCreatorlimit() { return creatorlimit; }
    public int aliseon_getCreator_id() { return creator_id; }
    public String aliseon_getCreator_nickname() { return creator_nickname; }
    public String aliseon_getCreator_photo() { return creator_photo; }
    public String aliseon_getCreator_zip() { return creator_zip; }
    public String aliseon_getCreator_city() { return creator_city; }
    public String aliseon_getCreator_state() { return creator_state; }
    public String aliseon_getCreator_address() { return creator_address; }
    public int aliseon_getCreator_subscribeto_cnt() { return creator_subscribeto_cnt; }
    public int aliseon_getCreator_contents_cnt() { return creator_contents_cnt; }
    public String aliseon_getCreator_desc() { return creator_desc; }
    public ArrayList<String> aliseon_getCreator_list_id() { return creator_list_id; }
    public ArrayList<String> aliseon_getCreator_list_user_id() { return creator_list_user_id; }
    public ArrayList<Integer> aliseon_getCreator_list_status() { return creator_list_status; }
    public ArrayList<String> aliseon_getCreator_list_description() { return creator_list_description; }
    public ArrayList<String> aliseon_getCreator_list_create_at() { return creator_list_create_at; }
    public ArrayList<String> aliseon_getCreator_list_update_at() { return creator_list_update_at; }
    public ArrayList<Integer> aliseon_getCreator_list_like_count() { return creator_list_like_count; }
    public ArrayList<Integer> aliseon_getCreator_list_view_count() { return creator_list_view_count; }
    public ArrayList<Integer> aliseon_getCreator_list_comment_count() { return creator_list_comment_count; }
    public ArrayList<ArrayList<String>> aliseon_getCreator_list_p_thumbnail() { return creator_list_p_thumbnail; }
    public ArrayList<String> aliseon_getCreator_list_c_thumbnail() { return creator_list_c_thumbnail; }
    public ArrayList<String> aliseon_getCreator_list_nickname() { return creator_list_nickname; }
    public ArrayList<String> aliseon_getCreator_list_profile() { return creator_list_profile; }

    // set
    public void aliseon_setCreatorstart(int creatorstart) { this.creatorstart = creatorstart; }
    public void aliseon_setCreatorlimit(int creatorlimit) { this.creatorlimit = creatorlimit; }
    public void aliseon_setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }
    public void aliseon_setCreator_nickname(String creator_nickname) {
        this.creator_nickname = creator_nickname;
    }
    public void aliseon_setCreator_photo(String creator_photo) {
        this.creator_photo = creator_photo;
    }
    public void aliseon_setCreator_zip(String creator_zip) {
        this.creator_zip = creator_zip;
    }
    public void aliseon_setCreator_city(String creator_city) {
        this.creator_city = creator_city;
    }
    public void aliseon_setCreator_state(String creator_state) {
        this.creator_state = creator_state;
    }
    public void aliseon_setCreator_address(String creator_address) {
        this.creator_address = creator_address;
    }
    public void aliseon_setCreator_subscribeto_cnt(int creator_subscribeto_cnt) {
        this.creator_subscribeto_cnt = creator_subscribeto_cnt;
    }
    public void aliseon_setCreator_contents_cnt(int creator_contents_cnt) {
        this.creator_contents_cnt = creator_contents_cnt;
    }
    public void aliseon_setCreator_desc(String creator_desc) {
        this.creator_desc = creator_desc;
    }
    public void aliseon_setCreator_list_id(ArrayList<String> creator_list_id) {
        this.creator_list_id = creator_list_id;
    }
    public void aliseon_setCreator_list_user_id(ArrayList<String> creator_list_user_id) {
        this.creator_list_user_id = creator_list_user_id;
    }
    public void aliseon_setCreator_list_status(ArrayList<Integer> creator_list_status) {
        this.creator_list_status = creator_list_status;
    }
    public void aliseon_setCreator_list_description(ArrayList<String> creator_list_description) {
        this.creator_list_description = creator_list_description;
    }
    public void aliseon_setCreator_list_create_at(ArrayList<String> creator_list_create_at) {
        this.creator_list_create_at = creator_list_create_at;
    }
    public void aliseon_setCreator_list_update_at(ArrayList<String> creator_list_update_at) {
        this.creator_list_update_at = creator_list_update_at;
    }
    public void aliseon_setCreator_list_like_count(ArrayList<Integer> creator_list_like_count) {
        this.creator_list_like_count = creator_list_like_count;
    }
    public void aliseon_setCreator_list_view_count(ArrayList<Integer> creator_list_view_count) {
        this.creator_list_view_count = creator_list_view_count;
    }
    public void aliseon_setCreator_list_comment_count(ArrayList<Integer> a) {
        this.creator_list_comment_count = creator_list_comment_count;
    }
    public void aliseon_setCreator_list_p_thumbnail(ArrayList<ArrayList<String>> creator_list_p_thumbnail) {
        this.creator_list_p_thumbnail = creator_list_p_thumbnail;
    }
    public void aliseon_setCreator_list_c_thumbnail(ArrayList<String> creator_list_c_thumbnail) {
        this.creator_list_c_thumbnail = creator_list_c_thumbnail;
    }
    public void aliseon_setCreator_list_nickname(ArrayList<String> creator_list_nickname) {
        this.creator_list_nickname = creator_list_nickname;
    }
    public void aliseon_setCreator_list_profile(ArrayList<String> creator_list_profile) {
        this.creator_list_profile = creator_list_profile;
    }


    // CreatorDetail
    // get
    public int aliseon_getCreatorDetailAPIload() { return creatordetailapiload; }
    public ArrayList<Integer> aliseon_getCreatordetail_list_id() { return creatordetail_list_id; }
    public ArrayList<String> aliseon_getCreatordetail_list_nickname() { return creatordetail_list_nickname; }
    public ArrayList<String> aliseon_getCreatordetail_list_photo() { return creatordetail_list_photo; }
    public ArrayList<Integer> aliseon_getCreatordetail_list_subscribeto_cnt() { return creatordetail_list_subscribeto_cnt; }
    public ArrayList<Integer> aliseon_getCreatordetail_list_contents_cnt() { return creatordetail_list_contents_cnt; }
    public ArrayList<Integer> aliseon_getCreatordetail_list_is_subscribe() { return creatordetail_list_is_subscribe; }

    // set
    public void aliseon_setCreatorDetailAPIload(int creatordetailapiload) { this.creatordetailapiload = creatordetailapiload; }
    public void aliseon_setCreatordetail_list_id(ArrayList<Integer> creatordetail_list_id) {
        this.creatordetail_list_id = creatordetail_list_id;
    }
    public void aliseon_setCreatordetail_list_nickname(ArrayList<String> creatordetail_list_nickname) {
        this.creatordetail_list_nickname = creatordetail_list_nickname;
    }
    public void aliseon_setCreatordetail_list_photo(ArrayList<String> creatordetail_list_photo) {
        this.creatordetail_list_photo = creatordetail_list_photo;
    }
    public void aliseon_setCreatordetail_list_subscribeto_cnt(ArrayList<Integer> creatordetail_list_subscribeto_cnt) {
        this.creatordetail_list_subscribeto_cnt = creatordetail_list_subscribeto_cnt;
    }
    public void aliseon_setCreatordetail_list_contents_cnt(ArrayList<Integer> creatordetail_list_contents_cnt) {
        this.creatordetail_list_contents_cnt = creatordetail_list_contents_cnt;
    }
    public void aliseon_setCreatordetail_list_is_subscribe(ArrayList<Integer> creatordetail_list_is_subscribe) {
        this.creatordetail_list_is_subscribe = creatordetail_list_is_subscribe;
    }

    // VoyageResultActivity
    // get
    public Integer aliseon_getVoyageresultstart() { return voyageresultstart; }
    public Integer aliseon_getVoyageresultlimit() { return voyageresultlimit; }
    public ArrayList<String> aliseon_getVoyageresult_id() { return voyageresult_id; }
    public ArrayList<String> aliseon_getVoyageresult_user_id() { return voyageresult_user_id; }
    public ArrayList<String> aliseon_getVoyageresult_product_id() { return voyageresult_product_id; }
    public ArrayList<String> aliseon_getVoyageresult_contents_id() { return voyageresult_contents_id; }
    public ArrayList<String> aliseon_getVoyageresult_contents_type() { return voyageresult_contents_type; }
    public ArrayList<String> aliseon_getVoyageresult_category_id() { return voyageresult_category_id; }
    public ArrayList<Integer> aliseon_getVoyageresult_status() { return voyageresult_status; }
    public ArrayList<String> aliseon_getVoyageresult_description() { return voyageresult_description; }
    public ArrayList<String> aliseon_getVoyageresult_create_at() { return voyageresult_create_at; }
    public ArrayList<String> aliseon_getVoyageresult_update_at() { return voyageresult_update_at; }
    public ArrayList<Integer> aliseon_getVoyageresult_like_count() { return voyageresult_like_count; }
    public ArrayList<Integer> aliseon_getVoyageresult_view_count() { return voyageresult_view_count; }
    public ArrayList<Integer> aliseon_getVoyageresult_comment_count() { return voyageresult_comment_count; }
    public ArrayList<String> aliseon_getVoyageresult_category_en() { return voyageresult_category_en; }
    public ArrayList<String> aliseon_getVoyageresult_category_kr() { return voyageresult_category_kr; }
    public ArrayList<String> aliseon_getVoyageresult_photo() { return voyageresult_photo; }
    public ArrayList<String> aliseon_getVoyageresult_nickname() { return voyageresult_nickname; }
    public ArrayList<ArrayList<String>> aliseon_getVoyageresult_p_thumbnail() { return voyageresult_p_thumbnail; }
    public ArrayList<String> aliseon_getVoyageresult_c_thumbnail() { return voyageresult_c_thumbnail; }

    // set
    public void aliseon_setVoyageresultstart(Integer voyageresultstart) { this.voyageresultstart = voyageresultstart; }
    public void aliseon_setVoyageresultlimit(Integer voyageresultlimit) { this.voyageresultlimit = voyageresultlimit; }
    public void aliseon_setVoyageresult_id (ArrayList<String> voyageresult_id) { this.voyageresult_id = voyageresult_id; }
    public void aliseon_setVoyageresult_user_id (ArrayList<String> voyageresult_user_id) { this.voyageresult_user_id = voyageresult_user_id; }
    public void aliseon_setVoyageresult_product_id (ArrayList<String> voyageresult_products_id) { this.voyageresult_product_id = voyageresult_product_id; }
    public void aliseon_setVoyageresult_contents_id (ArrayList<String> voyageresult_contents_id) { this.voyageresult_contents_id = voyageresult_contents_id; }
    public void aliseon_setVoyageresult_contents_type (ArrayList<String> voyageresult_contents_type) { this.voyageresult_contents_type = voyageresult_contents_type; }
    public void aliseon_setVoyageresult_category_id (ArrayList<String> voyageresult_category_id) { this.voyageresult_category_id = voyageresult_category_id; }
    public void aliseon_setVoyageresult_status (ArrayList<Integer> voyageresult_status) { this.voyageresult_status = voyageresult_status; }
    public void aliseon_setVoyageresult_description (ArrayList<String> voyageresult_description) { this.voyageresult_description = voyageresult_description; }
    public void aliseon_setVoyageresult_create_at (ArrayList<String> voyageresult_create_at) { this.voyageresult_create_at = voyageresult_create_at; }
    public void aliseon_setVoyageresult_update_at (ArrayList<String> voyageresult_update_at) { this.voyageresult_update_at = voyageresult_update_at; }
    public void aliseon_setVoyageresult_like_count (ArrayList<Integer> voyageresult_like_count) { this.voyageresult_like_count = voyageresult_like_count; }
    public void aliseon_setVoyageresult_view_count (ArrayList<Integer> voyageresult_category_id) { this.voyageresult_view_count = voyageresult_view_count; }
    public void aliseon_setVoyageresult_comment_count (ArrayList<Integer> voyageresult_comment_count) { this.voyageresult_comment_count = voyageresult_comment_count; }
    public void aliseon_setVoyageresult_category_en (ArrayList<String> voyageresult_category_en) { this.voyageresult_category_en = voyageresult_category_en; }
    public void aliseon_setVoyageresult_category_kr (ArrayList<String> voyageresult_category_kr) { this.voyageresult_category_kr = voyageresult_category_kr; }
    public void aliseon_setVoyageresult_photo (ArrayList<String> voyageresult_photo) { this.voyageresult_photo = voyageresult_photo; }
    public void aliseon_setVoyageresult_nickname (ArrayList<String> voyageresult_nickname) { this.voyageresult_nickname = voyageresult_nickname; }
    public void aliseon_setVoyageresult_p_thumbnail (ArrayList<ArrayList<String>> voyageresult_p_thumbnail) { this.voyageresult_p_thumbnail = voyageresult_p_thumbnail; }
    public void aliseon_setVoyageresult_c_thumbnail (ArrayList<String> voyageresult_c_thumbnail) { this.voyageresult_c_thumbnail = voyageresult_contents_type; }


    // CartActivity
    // get
    public ArrayList<String> aliseon_getAddoption() { return addoption; }
    public ArrayList<ArrayList<String>> aliseon_getCartitemoption() { return cartitemoption; }

    public ArrayList<String> aliseon_getCart_shop_id() { return cart_shop_id; }
    public ArrayList<String> aliseon_getCart_shop_photo() { return cart_shop_photo; }
    public ArrayList<String> aliseon_getCart_shop_nickname() { return cart_shop_nickname; }
    public ArrayList<String> aliseon_getCart_shop_name() { return cart_shop_shop_name; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_cart_id() { return cart_items_p_cart_id; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_user_id() { return cart_items_p_user_id; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_option_value() { return cart_items_p_option_value; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_option_price() { return cart_items_p_option_price; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_option_stock() { return cart_items_p_option_stock; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_product_id() { return cart_items_p_product_id; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_status() { return cart_items_p_status; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_vendor_id() { return cart_items_p_vendor_id; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_name() { return cart_items_p_name; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_thumbnail() { return cart_items_p_thumbnail; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_ship() { return cart_items_p_ship; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_previous_price() { return cart_items_p_previous_price; }
    public ArrayList<ArrayList<String>> aliseon_getCart_items_p_price() { return cart_items_p_price; }
    public ArrayList<String> aliseon_getCart_items_c_cart_id() { return cart_items_c_cart_id; }
    public ArrayList<String> aliseon_getCart_items_c_user_id() { return cart_items_c_user_id; }
    public ArrayList<String> aliseon_getCart_items_c_option_value() { return cart_items_c_option_value; }
    public ArrayList<String> aliseon_getCart_items_c_option_price() { return cart_items_c_option_price; }
    public ArrayList<String> aliseon_getCart_items_c_option_stock() { return cart_items_c_option_stock; }
    public ArrayList<String> aliseon_getCart_items_c_product_id() { return cart_items_c_product_id; }
    public ArrayList<String> aliseon_getCart_items_c_status() { return cart_items_c_status; }
    public ArrayList<String> aliseon_getCart_items_c_vendor_id() { return cart_items_c_vendor_id; }
    public ArrayList<String> aliseon_getCart_items_c_name() { return cart_items_c_name; }
    public ArrayList<String> aliseon_getCart_items_c_thumbnail() { return cart_items_c_thumbnail; }
    public ArrayList<String> aliseon_getCart_items_c_ship() { return cart_items_c_ship; }
    public ArrayList<String> aliseon_getCart_items_c_previous_price() { return cart_items_c_previous_price;}
    public ArrayList<String> aliseon_getCart_items_c_price() { return cart_items_c_price; }

    // set

    public void aliseon_setAddoption(ArrayList<String> addoption) { this.addoption = addoption; }
    public void aliseon_setCartitemoption(ArrayList<ArrayList<String>> cartitemoption) { this.cartitemoption = cartitemoption; }

    public void aliseon_setCart_shop_id(ArrayList<String> cart_shop_id) {
        this.cart_shop_id = cart_shop_id;
    }
    public void aliseon_setCart_shop_photo(ArrayList<String> cart_shop_photo) {
        this.cart_shop_photo = cart_shop_photo;
    }
    public void aliseon_setCart_shop_nickname(ArrayList<String> cart_shop_nickname) {
        this.cart_shop_nickname = cart_shop_nickname;
    }
    public void aliseon_setCart_shop_name(ArrayList<String> cart_shop_shop_name) {
        this.cart_shop_shop_name = cart_shop_shop_name;
    }
    public void aliseon_setCart_items_p_cart_id(ArrayList<ArrayList<String>> cart_items_p_cart_id) {
        this.cart_items_p_cart_id = cart_items_p_cart_id;
    }
    public void aliseon_setCart_items_p_user_id(ArrayList<ArrayList<String>> cart_items_p_user_id) {
        this.cart_items_p_user_id = cart_items_p_user_id;
    }
    public void aliseon_setCart_items_p_option_value(ArrayList<ArrayList<String>> cart_items_p_option_value) {
        this.cart_items_p_option_value = cart_items_p_option_value;
    }
    public void aliseon_setCart_items_p_option_price(ArrayList<ArrayList<String>> cart_items_p_option_price) {
        this.cart_items_p_option_price = cart_items_p_option_price;
    }
    public void aliseon_setCart_items_p_option_stock(ArrayList<ArrayList<String>> cart_items_p_option_stock) {
        this.cart_items_p_option_stock = cart_items_p_option_stock;
    }
    public void aliseon_setCart_items_p_product_id(ArrayList<ArrayList<String>> cart_items_p_product_id) {
        this.cart_items_p_product_id = cart_items_p_product_id;
    }
    public void aliseon_setCart_items_p_status(ArrayList<ArrayList<String>> cart_items_p_status) {
        this.cart_items_p_status = cart_items_p_status;
    }
    public void aliseon_setCart_items_p_vendor_id(ArrayList<ArrayList<String>> cart_items_p_vendor_id) {
        this.cart_items_p_vendor_id = cart_items_p_vendor_id;
    }
    public void aliseon_setCart_items_p_name(ArrayList<ArrayList<String>> cart_items_p_name) {
        this.cart_items_p_name = cart_items_p_name;
    }
    public void aliseon_setCart_items_p_thumbnail(ArrayList<ArrayList<String>> cart_items_p_thumbnail) {
        this.cart_items_p_thumbnail = cart_items_p_thumbnail;
    }
    public void aliseon_setCart_items_p_ship(ArrayList<ArrayList<String>> cart_items_p_ship) {
        this.cart_items_p_ship = cart_items_p_ship;
    }
    public void aliseon_setCart_items_p_previous_price(ArrayList<ArrayList<String>> cart_items_p_previous_price) {
        this.cart_items_p_previous_price = cart_items_p_previous_price;
    }
    public void aliseon_setCart_items_p_price(ArrayList<ArrayList<String>> cart_items_p_price) {
        this.cart_items_p_price = cart_items_p_price;
    }
    public void aliseon_setCart_items_c_cart_id(ArrayList<String> cart_items_c_cart_id) {
        this.cart_items_c_cart_id = cart_items_c_cart_id;
    }
    public void aliseon_setCart_items_c_user_id(ArrayList<String> cart_items_c_user_id) {
        this.cart_items_c_user_id = cart_items_c_user_id;
    }
    public void aliseon_setCart_items_c_option_value(ArrayList<String> cart_items_c_option_value) {
        this.cart_items_c_option_value = cart_items_c_option_value;
    }
    public void aliseon_setCart_items_c_option_price(ArrayList<String> cart_items_c_option_price) {
        this.cart_items_c_option_price = cart_items_c_option_price;
    }
    public void aliseon_setCart_items_c_option_stock(ArrayList<String> cart_items_c_option_stock) {
        this.cart_items_c_option_stock = cart_items_c_option_stock;
    }
    public void aliseon_setCart_items_c_product_id(ArrayList<String> cart_items_c_product_id) {
        this.cart_items_c_product_id = cart_items_c_product_id;
    }
    public void aliseon_setCart_items_c_status(ArrayList<String> cart_items_c_status) {
        this.cart_items_c_status = cart_items_c_status;
    }
    public void aliseon_setCart_items_c_vendor_id(ArrayList<String> cart_items_c_vendor_id) {
        this.cart_items_c_vendor_id = cart_items_c_vendor_id;
    }
    public void aliseon_setCart_items_c_name(ArrayList<String> cart_items_c_name) {
        this.cart_items_c_name = cart_items_c_name;
    }
    public void aliseon_setCart_items_c_thumbnail(ArrayList<String> cart_items_c_thumbnail) {
        this.cart_items_c_thumbnail = cart_items_c_thumbnail;
    }
    public void aliseon_setCart_items_c_ship(ArrayList<String> cart_items_c_ship) {
        this.cart_items_c_ship = cart_items_c_ship;
    }
    public void aliseon_setCart_items_c_previous_price(ArrayList<String> cart_items_c_previous_price) {
        this.cart_items_c_previous_price = cart_items_c_previous_price;
    }
    public void aliseon_setCart_items_c_price(ArrayList<String> cart_items_c_price) {
        this.cart_items_c_price = cart_items_c_price;
    }

    // CartDetail
    // get
    public String aliseon_getParam_product_id() { return param_product_id; }

    public int aliseon_getCartdetail_productinfo_id() { return cartdetail_productinfo_id; }
    public String aliseon_getCartdetail_productinfo_desc() { return cartdetail_productinfo_desc; }
    public int aliseon_getCartdetail_productdetail_id() { return cartdetail_productdetail_id; }
    public int aliseon_getCartdetail_productdetail_vendor_id() { return cartdetail_productdetail_vendor_id; }
    public String aliseon_getCartdetail_productdetail_thumbnail() { return cartdetail_productdetail_thumbnail; };
    public String aliseon_getCartdetail_productdetail_title() { return cartdetail_productdetail_title; }
    public String aliseon_getCartdetail_productdetail_sub_title() { return cartdetail_productdetail_sub_title; }
    public int aliseon_getCartdetail_productdetail_previous_price() { return cartdetail_productdetail_previous_price; }
    public int aliseon_getCartdetail_productdetail_complete_price() { return cartdetail_productdetail_complete_price; }
    public int aliseon_getCartdetail_productdetail_basic_shipping() { return cartdetail_productdetail_basic_shipping; }
    public int aliseon_getCartdetail_productdetail_free_shipping() { return cartdetail_productdetail_free_shipping; }
    public ArrayList<ArrayList<String>> aliseon_getCartdetail_productbuy_p_option_name() { return cartdetail_productbuy_p_option_name; }
    public ArrayList<ArrayList<String>> aliseon_getCartdetail_productbuy_p_option_original_value() { return cartdetail_productbuy_p_option_original_value; }
    public ArrayList<ArrayList<Integer>> aliseon_getCartdetail_productbuy_p_option_original_price() { return cartdetail_productbuy_p_option_original_price; }
    public ArrayList<ArrayList<String>> aliseon_getCartdetail_productbuy_p_option_value() { return cartdetail_productbuy_p_option_value; }
    public ArrayList<ArrayList<Integer>> aliseon_getCartdetail_productbuy_p_option_price() { return cartdetail_productbuy_p_option_price; }
    public ArrayList<ArrayList<Integer>> aliseon_getCartdetail_productbuy_p_option_stock() { return cartdetail_productbuy_p_option_stock; }
    public ArrayList<String> aliseon_getCartdetail_productbuy_c_option_original_value() { return cartdetail_productbuy_c_option_original_value; }
    public ArrayList<String> aliseon_getCartdetail_productbuy_option_name() { return cartdetail_productbuy_option_name; }
    public ArrayList<Integer> aliseon_getCartdetail_productbuy_c_option_original_price() { return cartdetail_productbuy_c_option_original_price; }
    public ArrayList<String> aliseon_getCartdetail_productbuy_c_option_value() { return cartdetail_productbuy_c_option_value; }
    public ArrayList<Integer> aliseon_getCartdetail_productbuy_c_option_price() { return cartdetail_productbuy_c_option_price; }
    public ArrayList<Integer> aliseon_getCartdetail_productbuy_c_option_stock() { return cartdetail_productbuy_c_option_stock; }
    public ArrayList<Integer> aliseon_getCartdetail_productbuy_option_connection() { return cartdetail_productbuy_option_connection; }

    // set
    public void aliseon_setParam_product_id(String param_product_id) { this.param_product_id = param_product_id; }

    public void aliseon_setCartdetail_productinfo_id(int cartdetail_productinfo_id) { this.cartdetail_productinfo_id = cartdetail_productinfo_id; }
    public void aliseon_setCartdetail_productinfo_desc(String cartdetail_productinfo_desc) { this.cartdetail_productinfo_desc = cartdetail_productinfo_desc; }
    public void aliseon_setCartdetail_productdetail_id(int cartdetail_productdetail_id) { this.cartdetail_productdetail_id = cartdetail_productdetail_id; }
    public void aliseon_setCartdetail_productdetail_vendor_id(int cartdetail_productdetail_vendor_id) { this.cartdetail_productdetail_vendor_id = cartdetail_productdetail_vendor_id; }
    public void aliseon_setCartdetail_productdetail_thumbnail(String cartdetail_productdetail_thumbnail) { this.cartdetail_productdetail_thumbnail = cartdetail_productdetail_thumbnail; }
    public void aliseon_setCartdetail_productdetail_title(String cartdetail_productdetail_title) { this.cartdetail_productdetail_title = cartdetail_productdetail_title; }
    public void aliseon_setCartdetail_productdetail_sub_title(String cartdetail_productdetail_sub_title) { this.cartdetail_productdetail_sub_title = cartdetail_productdetail_sub_title; }
    public void aliseon_setCartdetail_productdetail_previous_price(int cartdetail_productdetail_previous_price) { this.cartdetail_productdetail_previous_price = cartdetail_productdetail_previous_price; }
    public void aliseon_setCartdetail_productdetail_complete_price(int cartdetail_productdetail_complete_price) { this.cartdetail_productdetail_complete_price = cartdetail_productdetail_complete_price; }
    public void aliseon_setCartdetail_productdetail_basic_shipping(int cartdetail_productdetail_basic_shipping) { this.cartdetail_productdetail_basic_shipping = cartdetail_productdetail_basic_shipping; }
    public void aliseon_setCartdetail_productdetail_free_shipping(int cartdetail_productdetail_free_shipping) { this.cartdetail_productdetail_free_shipping = cartdetail_productdetail_free_shipping; }
    public void aliseon_setCartdetail_productbuy_p_option_name(ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_name) { this.cartdetail_productbuy_p_option_name = cartdetail_productbuy_p_option_name; }
    public void aliseon_setCartdetail_productbuy_p_option_original_value(ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_original_value) { this.cartdetail_productbuy_p_option_original_value = cartdetail_productbuy_p_option_original_value; }
    public void aliseon_setCartdetail_productbuy_p_option_original_price(ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_original_price) { this.cartdetail_productbuy_p_option_original_price = cartdetail_productbuy_p_option_original_price; }
    public void aliseon_setCartdetail_productbuy_p_option_value(ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_value) { this.cartdetail_productbuy_p_option_value = cartdetail_productbuy_p_option_value; }
    public void aliseon_setCartdetail_productbuy_p_option_price(ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_price) { this.cartdetail_productbuy_p_option_price = cartdetail_productbuy_p_option_price; }
    public void aliseon_setCartdetail_productbuy_p_option_stock(ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_stock) { this.cartdetail_productbuy_p_option_stock = cartdetail_productbuy_p_option_stock; }
    public void aliseon_setCartdetail_productbuy_c_option_original_value(ArrayList<String> cartdetail_productbuy_c_option_original_value) { this.cartdetail_productbuy_c_option_original_value = cartdetail_productbuy_c_option_original_value; }
    public void aliseon_setCartdetail_productbuy_option_name(ArrayList<String> cartdetail_productbuy_option_name) { this.cartdetail_productbuy_option_name = cartdetail_productbuy_option_name; }
    public void aliseon_setCartdetail_productbuy_c_option_original_price(ArrayList<Integer> cartdetail_productbuy_c_option_original_price) { this.cartdetail_productbuy_c_option_original_price = cartdetail_productbuy_c_option_original_price; }
    public void aliseon_setCartdetail_productbuy_c_option_value(ArrayList<String> cartdetail_productbuy_c_option_value) { this.cartdetail_productbuy_c_option_value = cartdetail_productbuy_c_option_value; }
    public void aliseon_setCartdetail_productbuy_c_option_price(ArrayList<Integer> cartdetail_productbuy_c_option_price) { this.cartdetail_productbuy_c_option_price = cartdetail_productbuy_c_option_price; }
    public void aliseon_setCartdetail_productbuy_c_option_stock(ArrayList<Integer> cartdetail_productbuy_c_option_stock) { this.cartdetail_productbuy_c_option_stock = cartdetail_productbuy_c_option_stock; }
    public void aliseon_setCartdetail_productbuy_option_connection(ArrayList<Integer> cartdetail_productbuy_option_connection) { this.cartdetail_productbuy_option_connection = cartdetail_productbuy_option_connection; }

    // player
    // get

    public String aliseon_getSelect_voyage_id() { return select_voyage_id; }

    public int aliseon_getPlayerdataload() { return playerdataload; }
    public String aliseon_getNowurl() { return nowurl; }
    public ArrayList<String> aliseon_getPlayerfeedid() { return playerfeedid; }
    public ArrayList<String> aliseon_getPlayerfeedimage() { return playerfeedimage; }
    public ArrayList<String> aliseon_getPlayerfeedname() { return playerfeedname; }
    public ArrayList<String> aliseon_getPlayerfeedpricecomputed() { return playerfeedpricecomputed; }

    // set
    public void aliseon_setSelect_voyage_id(String select_voyage_id) { this.select_voyage_id = select_voyage_id; }
    public void aliseon_setPlayerdataload(int playerdataload) { this.playerdataload = playerdataload; }
    public void aliseon_setNowurl(String nowurl) { this.nowurl = nowurl; }
    public void aliseon_setPlayerfeedid(ArrayList<String> playerfeedid) { this.playerfeedid = playerfeedid; }
    public void aliseon_setPlayerfeedimage(ArrayList<String> playerfeedimage) { this.playerfeedimage = playerfeedimage; }
    public void aliseon_setPlayerfeedname(ArrayList<String> playerfeedname) { this.playerfeedname = playerfeedname; }
    public void aliseon_setPlayerfeedpricecomputed(ArrayList<String> playerfeedpricecomputed) { this.playerfeedpricecomputed = playerfeedpricecomputed; }

    public void aliseon_clearVoyage() {

        voyage_id.clear();
        voyage_user_id.clear();
        voyage_product_id.clear();
        voyage_contents_id.clear();
        voyage_contents_type.clear();
        voyage_category_id.clear();
        voyage_status.clear();
        voyage_description.clear();
        voyage_create_at.clear();
        voyage_update_at.clear();
        voyage_like_count.clear();
        voyage_view_count.clear();
        voyage_comment_count.clear();
        voyage_category_en.clear();
        voyage_category_kr.clear();
        voyage_nickname.clear();
        voyage_photo.clear();
        voyage_p_thumbnail.clear();
//        voyage_c_thumbnail.clear();

    }

    public void aliseon_clearSubscribeCreator() {
        subscribe_creator_list_id.clear();
        subscribe_creator_list_nickname.clear();
        subscribe_creator_list_photo.clear();
    }

    public void aliseon_clearSubscribeVoyage() {
        subscribe_voyage_list_id.clear();
        subscribe_voyage_list_user_id.clear();
        subscribe_voyage_list_product_id.clear();
        subscribe_voyage_list_contents_id.clear();
        subscribe_voyage_list_contents_type.clear();
        subscribe_voyage_list_category_id.clear();
        subscribe_voyage_list_status.clear();
        subscribe_voyage_list_create_at.clear();
        subscribe_voyage_list_update_at.clear();
        subscribe_voyage_list_like_count.clear();
        subscribe_voyage_list_view_count.clear();
        subscribe_voyage_list_comment_count.clear();
        subscribe_voyage_list_category_en.clear();
        subscribe_voyage_list_category_kr.clear();
        subscribe_voyage_list_nickname.clear();
        subscribe_voyage_list_photo.clear();
        subscribe_voyage_list_description.clear();
        subscribe_voyage_list_p_thumbnail.clear();
    }

}
