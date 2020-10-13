package com.aliseon.ott;

import android.content.SharedPreferences;

import java.util.ArrayList;

public class Variable {

    // 주소
    public static String imageurl = "https://2020aliseon.s3.ap-northeast-2.amazonaws.com";

    static String aliseonapi = "http://api.aliseon.com/api";

    public static String api_auth = aliseonapi + "/auth";
    public static String api_usersetting_user_phone = aliseonapi + "/usersetting/user/phone";
    public static String api_category = aliseonapi + "/category";
    public static String api_tvott_users = aliseonapi + "/tvott/users";
    public static String api_tvott_users_add = aliseonapi + "/tvott/users/add";
    public static String api_tvott_deluser = aliseonapi + "/tvott/users/delete";
    public static String api_atrend = aliseonapi + "/atrend";
    public static String api_voyage = aliseonapi + "/voyage";
    public static String api_atrend_detail = aliseonapi + "/atrend/detail";
    public static String api_voyage_detail = aliseonapi + "/voyage/detail";
    public static String api_subscribe_from = aliseonapi + "/subscribe/from";
    public static String api_subscribe_to = aliseonapi + "/subscribe/to";
    public static String api_cart = aliseonapi + "/cart";
    public static String api_my_info = aliseonapi + "/my/info";
    public static String api_tvott_popular = aliseonapi + "/tvott/popular";
    public static String api_tvott_popular_detail = aliseonapi + "/tvott/popular/detail";
    public static String api_recommend_creator = aliseonapi + "/recommend/creator";
    public static String api_product_info = aliseonapi + "/product/info";
    public static String api_product_detail = aliseonapi + "/product/detail";
    public static String api_product_buy = aliseonapi + "/product/buy";
    public static String api_subscribe_post = aliseonapi + "/subscribe/post";
    public static String api_subscribe_unsubscribe = aliseonapi + "/subscribe/unsubscribe";
    public static String api_usersetting = aliseonapi + "/usersetting";
    public static String api_my_list = aliseonapi + "/my/list";

    // API 로드 0 = 로드안됨, 1 = 로드됨     초기 값 = 0
    public static int adduserapiload = 0;
    public static int homeapiload = 0;
    public static int voyageapiload = 0;
    public static int voyagecategoryapiload = 0;
    public static int voyagefocusapiload = 0;
    public static int subscribeapiload = 0;
    public static int subscribefocusapiload = 0;
    public static int voyageresultapiload = 0;
    public static int settinguseraccountmanagementapiload = 0;
    public static int cartapiload = 0;
    public static int cartdetailapiload = 0;
    public static int myapiload = 0;
    public static int creatorapiload = 0;
    public static int mydetailapiload = 0;
    public static int creatordetailapiload = 0;
    public static int usersettinglanguageapiload = 0;

    // API 스타트 리미트 값 4X3 배열을 기준으로 스타트 0 리미트 12부터 보통 시작
    public static int homepopularstart = 0;
    public static int homepopularlimit = 23;
    public static int subscribevoyagestart = 0;
    public static int subscribevoyagelimit = 12;
    public static int creatorstart = 0;
    public static int creatorlimit = 12;
    public static int mystart = 0;
    public static int mylimit = 12;
    public static int voyageresultstart = 0;
    public static int voyageresultlimit = 12;
    public static int voyagestart = 0;
    public static int voyagelimit = 12;


    //API에서 불러온 데이터를 저장하는 ArrayList
    //------------------------------------------------ 시작 ----------------------------------------------------
    public static ArrayList<String> atrend_id;
    public static ArrayList<String> atrend_user_id;
    public static ArrayList<String> atrend_type;
    public static ArrayList<String> atrend_product_id;
    public static ArrayList<String> atrend_contents_id;
    public static ArrayList<String> atrend_title;
    public static ArrayList<String> atrend_subtitle;
    public static ArrayList<String> atrend_description;
    public static ArrayList<String> atrend_summary;
    public static ArrayList<Integer> atrend_view;
    public static ArrayList<Integer> atrend_like;
    public static ArrayList<String> atrend_color;
    public static ArrayList<String> atrend_start_at;
    public static ArrayList<String> atrend_create_at;
    public static ArrayList<String> atrend_update_at;
    public static ArrayList<String> atrend_opacity;
    public static ArrayList<Integer> atrend_status;
    public static ArrayList<String> atrend_background;
    public static ArrayList<String> atrend_thumbnail;

    public static ArrayList<String> atrend_detail_detp_html;
    public static ArrayList<String> atrend_detail_maincontent;
    public static ArrayList<String> atrend_detail_product_id;
    public static ArrayList<String> atrend_detail_product_name;
    public static ArrayList<String> atrend_detail_product_brand;
    public static ArrayList<String> atrend_detail_product_thumbnail;
    public static ArrayList<String> atrend_detail_product_price;
    public static ArrayList<String> atrend_detail_product_previous_price;

    public static ArrayList<String> atrend_related_id;
    public static ArrayList<String> atrend_related_user_id;
    public static ArrayList<String> atrend_related_type;
    public static ArrayList<String> atrend_related_product_id;
    public static ArrayList<String> atrend_related_contents_id;
    public static ArrayList<String> atrend_related_title;
    public static ArrayList<String> atrend_related_subtitle;
    public static ArrayList<String> atrend_related_description;
    public static ArrayList<String> atrend_related_summary;
    public static ArrayList<String> atrend_related_view;
    public static ArrayList<String> atrend_related_like;
    public static ArrayList<String> atrend_related_color;
    public static ArrayList<String> atrend_related_start_at;
    public static ArrayList<String> atrend_related_create_at;
    public static ArrayList<String> atrend_related_update_at;
    public static ArrayList<String> atrend_related_opacity;
    public static ArrayList<String> atrend_related_status;
    public static ArrayList<String> atrend_related_background;
    public static ArrayList<String> atrend_related_thumbnail;

    public static ArrayList<String> popular_id;
    public static ArrayList<String> popular_user_id;
    public static ArrayList<String> popular_product_id;
    public static ArrayList<String> popular_contents_id;
    public static ArrayList<String> popular_contents_type;
    public static ArrayList<String> popular_category_id;
    public static ArrayList<Integer> popular_status;
    public static ArrayList<String> popular_description;
    public static ArrayList<String> popular_create_at;
    public static ArrayList<String> popular_update_at;
    public static ArrayList<Integer> popular_like_count;
    public static ArrayList<Integer> popular_view_count;
    public static ArrayList<Integer> popular_comment_count;
    public static ArrayList<String> popular_category_en;
    public static ArrayList<String> popular_category_kr;
    public static ArrayList<String> popular_nickname;
    public static ArrayList<String> popular_photo;
    public static ArrayList<ArrayList<String>> popular_p_thumbnail;
    public static ArrayList<String> popular_c_thumbnail;

    public static ArrayList<String> popular_detail_id;
    public static ArrayList<String> popular_detail_user_id;
    public static ArrayList<String> popular_detail_product_id;
    public static ArrayList<String> popular_detail_contents_id;
    public static ArrayList<String> popular_detail_contents_type;
    public static ArrayList<String> popular_detail_category_id;
    public static ArrayList<String> popular_detail_status;
    public static ArrayList<String> popular_detail_description;
    public static ArrayList<String> popular_detail_create_at;
    public static ArrayList<String> popular_detail_update_at;
    public static ArrayList<String> popular_detail_like_count;
    public static ArrayList<String> popular_detail_view_count;
    public static ArrayList<String> popular_detail_comment_count;
    public static ArrayList<String> popular_detail_category_en;
    public static ArrayList<String> popular_detail_category_kr;
    public static ArrayList<String> popular_detail_name;
    public static ArrayList<String> popular_detail_photo;
    public static ArrayList<String> popular_detail_contents;
    public static ArrayList<String> popular_detail_items;

    public static ArrayList<String> popular_detail_item_id;
    public static ArrayList<String> popular_detail_item_name;
    public static ArrayList<String> popular_detail_item_brand;
    public static ArrayList<String> popular_detail_item_thumbnail;
    public static ArrayList<String> popular_detail_item_price;
    public static ArrayList<String> popular_detail_item_previous_price;

    public static ArrayList<String> popular_related_id;
    public static ArrayList<String> popular_related_user_id;
    public static ArrayList<String> popular_related_status;
    public static ArrayList<String> popular_related_description;
    public static ArrayList<String> popular_related_create_at;
    public static ArrayList<String> popular_related_update_at;
    public static ArrayList<String> popular_related_like_count;
    public static ArrayList<String> popular_related_view_count;
    public static ArrayList<String> popular_related_comment_count;
    public static ArrayList<String> popular_related_contents;

    public static ArrayList<String> voyage_id;
    public static ArrayList<String> voyage_user_id;
    public static ArrayList<String> voyage_product_id;
    public static ArrayList<String> voyage_contents_id;
    public static ArrayList<String> voyage_contents_type;
    public static ArrayList<String> voyage_category_id;
    public static ArrayList<Integer> voyage_status;
    public static ArrayList<String> voyage_description;
    public static ArrayList<String> voyage_create_at;
    public static ArrayList<String> voyage_update_at;
    public static ArrayList<Integer> voyage_like_count;
    public static ArrayList<Integer> voyage_view_count;
    public static ArrayList<Integer> voyage_comment_count;
    public static ArrayList<String> voyage_category_en;
    public static ArrayList<String> voyage_category_kr;
    public static ArrayList<String> voyage_nickname;
    public static ArrayList<String> voyage_photo;
    public static ArrayList<ArrayList<String>> voyage_p_thumbnail;
    public static ArrayList<String> voyage_c_thumbnail;

    public static ArrayList<String> voyage_detail_id;
    public static ArrayList<String> voyage_detail_user_id;
    public static ArrayList<String> voyage_detail_product_id;
    public static ArrayList<String> voyage_detail_contents_id;
    public static ArrayList<String> voyage_detail_contents_type;
    public static ArrayList<String> voyage_detail_category_id;
    public static ArrayList<String> voyage_detail_status;
    public static ArrayList<String> voyage_detail_description;
    public static ArrayList<String> voyage_detail_create_at;
    public static ArrayList<String> voyage_detail_update_at;
    public static ArrayList<String> voyage_detail_like_count;
    public static ArrayList<String> voyage_detail_view_count;
    public static ArrayList<String> voyage_detail_comment_count;
    public static ArrayList<String> voyage_detail_category_en;
    public static ArrayList<String> voyage_detail_category_kr;
    public static ArrayList<String> voyage_detail_nickname;
    public static ArrayList<String> voyage_detail_photo;
    public static ArrayList<String> voyage_detail_contents;
    public static ArrayList<String> voyage_detail_items;

    public static ArrayList<String> voyage_detail_item_id;
    public static ArrayList<String> voyage_detail_item_name;
    public static ArrayList<String> voyage_detail_item_brand;
    public static ArrayList<String> voyage_detail_item_thumbnail;
    public static ArrayList<String> voyage_detail_item_price;
    public static ArrayList<String> voyage_detail_item_previous_price;

    public static ArrayList<String> voyage_related_id;
    public static ArrayList<String> voyage_related_user_id;
    public static ArrayList<String> voyage_related_status;
    public static ArrayList<String> voyage_related_description;
    public static ArrayList<String> voyage_related_create_at;
    public static ArrayList<String> voyage_related_update_at;
    public static ArrayList<String> voyage_related_like_count;
    public static ArrayList<String> voyage_related_view_count;
    public static ArrayList<String> voyage_related_comment_count;
    public static ArrayList<String> voyage_related_contents;

    //피드 검색결과 나중에 쓰임
    public static ArrayList<String> voyageresult_id;
    public static ArrayList<String> voyageresult_user_id;
    public static ArrayList<String> voyageresult_product_id;
    public static ArrayList<String> voyageresult_contents_id;
    public static ArrayList<String> voyageresult_contents_type;
    public static ArrayList<String> voyageresult_category_id;
    public static ArrayList<Integer> voyageresult_status;
    public static ArrayList<String> voyageresult_description;
    public static ArrayList<String> voyageresult_create_at;
    public static ArrayList<String> voyageresult_update_at;
    public static ArrayList<Integer> voyageresult_like_count;
    public static ArrayList<Integer> voyageresult_view_count;
    public static ArrayList<Integer> voyageresult_comment_count;
    public static ArrayList<String> voyageresult_category_en;
    public static ArrayList<String> voyageresult_category_kr;
    public static ArrayList<String> voyageresult_photo;
    public static ArrayList<String> voyageresult_nickname;
    public static ArrayList<ArrayList<String>> voyageresult_p_thumbnail;
    public static ArrayList<String> voyageresult_c_thumbnail;

    public static ArrayList<String> cart_shop_id;
    public static ArrayList<String> cart_shop_photo;
    public static ArrayList<String> cart_shop_nickname;
    public static ArrayList<String> cart_shop_shop_name;
    public static ArrayList<ArrayList<String>> cart_items_p_cart_id;
    public static ArrayList<ArrayList<String>> cart_items_p_user_id;
    public static ArrayList<ArrayList<String>> cart_items_p_option_value;
    public static ArrayList<ArrayList<String>> cart_items_p_option_price;
    public static ArrayList<ArrayList<String>> cart_items_p_option_stock;
    public static ArrayList<ArrayList<String>> cart_items_p_product_id;
    public static ArrayList<ArrayList<String>> cart_items_p_status;
    public static ArrayList<ArrayList<String>> cart_items_p_vendor_id;
    public static ArrayList<ArrayList<String>> cart_items_p_name;
    public static ArrayList<ArrayList<String>> cart_items_p_thumbnail;
    public static ArrayList<ArrayList<String>> cart_items_p_ship;
    public static ArrayList<ArrayList<String>> cart_items_p_previous_price;
    public static ArrayList<ArrayList<String>> cart_items_p_price;
    public static ArrayList<String> cart_items_c_cart_id;
    public static ArrayList<String> cart_items_c_user_id;
    public static ArrayList<String> cart_items_c_option_value;
    public static ArrayList<String> cart_items_c_option_price;
    public static ArrayList<String> cart_items_c_option_stock;
    public static ArrayList<String> cart_items_c_product_id;
    public static ArrayList<String> cart_items_c_status;
    public static ArrayList<String> cart_items_c_vendor_id;
    public static ArrayList<String> cart_items_c_name;
    public static ArrayList<String> cart_items_c_thumbnail;
    public static ArrayList<String> cart_items_c_ship;
    public static ArrayList<String> cart_items_c_previous_price;
    public static ArrayList<String> cart_items_c_price;

    //카트 자세히보기
    //product info API
    public static int cartdetail_productinfo_id;
    public static String cartdetail_productinfo_desc;
    //product detail API
    public static int cartdetail_productdetail_id;
    public static int cartdetail_productdetail_vendor_id;
    public static String cartdetail_productdetail_thumbnail;
    public static String cartdetail_productdetail_title;
    public static String cartdetail_productdetail_sub_title;
    public static int cartdetail_productdetail_previous_price;
    public static int cartdetail_productdetail_complete_price;
    public static int cartdetail_productdetail_basic_shipping;
    public static int cartdetail_productdetail_free_shipping;
    //product buy API
    public static ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_name;
    public static ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_original_value;
    public static ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_original_price;
    public static ArrayList<ArrayList<String>> cartdetail_productbuy_p_option_value;
    public static ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_price;
    public static ArrayList<ArrayList<Integer>> cartdetail_productbuy_p_option_stock;
    public static ArrayList<String> cartdetail_productbuy_c_option_original_value;
    public static ArrayList<String> cartdetail_productbuy_option_name;
    public static ArrayList<Integer> cartdetail_productbuy_c_option_original_price;
    public static ArrayList<String> cartdetail_productbuy_c_option_value;
    public static ArrayList<Integer> cartdetail_productbuy_c_option_price;
    public static ArrayList<Integer> cartdetail_productbuy_c_option_stock;
    public static ArrayList<Integer> cartdetail_productbuy_option_connection;

    public static ArrayList<Integer> subscribe_creator_list_id;
    public static ArrayList<String> subscribe_creator_list_nickname;
    public static ArrayList<String> subscribe_creator_list_photo;
    public static ArrayList<String> subscribe_voyage_list_id;
    public static ArrayList<String> subscribe_voyage_list_user_id;
    public static ArrayList<String> subscribe_voyage_list_product_id;
    public static ArrayList<String> subscribe_voyage_list_contents_id;
    public static ArrayList<String> subscribe_voyage_list_contents_type;
    public static ArrayList<String> subscribe_voyage_list_category_id;
    public static ArrayList<Integer> subscribe_voyage_list_status;
    public static ArrayList<String> subscribe_voyage_list_create_at;
    public static ArrayList<String> subscribe_voyage_list_update_at;
    public static ArrayList<Integer> subscribe_voyage_list_like_count;
    public static ArrayList<Integer> subscribe_voyage_list_view_count;
    public static ArrayList<Integer> subscribe_voyage_list_comment_count;
    public static ArrayList<String> subscribe_voyage_list_category_en;
    public static ArrayList<String> subscribe_voyage_list_category_kr;
    public static ArrayList<String> subscribe_voyage_list_name;
    public static ArrayList<String> subscribe_voyage_list_photo;
    public static ArrayList<String> subscribe_voyage_list_description;
    public static ArrayList<ArrayList<String>> subscribe_voyage_list_p_thumbnail;
    public static ArrayList<String> subscribe_voyage_list_c_thumbnail;

    public static int creator_id;
    public static String creator_nickname;
    public static String creator_photo;
    public static String creator_zip;
    public static String creator_city;
    public static String creator_state;
    public static String creator_address;
    public static int creator_subscribeto_cnt;
    public static int creator_contents_cnt;
    public static String creator_desc;
    public static ArrayList<String> creator_list_id;
    public static ArrayList<String> creator_list_user_id;
    public static ArrayList<Integer> creator_list_status;
    public static ArrayList<String> creator_list_description;
    public static ArrayList<String> creator_list_create_at;
    public static ArrayList<String> creator_list_update_at;
    public static ArrayList<Integer> creator_list_like_count;
    public static ArrayList<Integer> creator_list_view_count;
    public static ArrayList<Integer> creator_list_comment_count;
    public static ArrayList<ArrayList<String>> creator_list_p_thumbnail;
    public static ArrayList<String> creator_list_c_thumbnail;
    public static ArrayList<String> creator_list_nickname;
    public static ArrayList<String> creator_list_profile;

    public static ArrayList<Integer> creatordetail_list_id;
    public static ArrayList<String> creatordetail_list_nickname;
    public static ArrayList<String> creatordetail_list_photo;
    public static ArrayList<Integer> creatordetail_list_subscribeto_cnt;
    public static ArrayList<Integer> creatordetail_list_contents_cnt;
    public static ArrayList<Integer> creatordetail_list_is_subscribe;

    public static ArrayList<Integer> mydetail_list_id;
    public static ArrayList<String> mydetail_list_nickname;
    public static ArrayList<String> mydetail_list_photo;
    public static ArrayList<Integer> mydetail_list_subscribeto_cnt;
    public static ArrayList<Integer> mydetail_list_contents_cnt;
    public static ArrayList<Integer> mydetail_list_is_subscribe;

    public static ArrayList<Integer> from_fav_channel_id;
    public static ArrayList<String> from_fav_channel_nickname;
    public static ArrayList<String> from_fav_channel_photo;

    public static ArrayList<Integer> to_fav_channel_id;
    public static ArrayList<String> to_fav_channel_nickname;
    public static ArrayList<String> to_fav_channel_photo;

    public static ArrayList<String> recommend_id;
    public static ArrayList<String> recommend_nickname;
    public static ArrayList<String> recommend_photo;
    public static ArrayList<String> recommend_subscribeto_cnt;
    public static ArrayList<String> recommend_contents_cnt;

    public static String my_id;
    public static String my_nickname;
    public static String my_photo;
    public static String my_zip;
    public static String my_city;
    public static String my_state;
    public static String my_address;
    public static String my_subscribeto_cnt;
    public static String my_contents_cnt;
    public static String my_desc;
    public static ArrayList<String> my_list_id;
    public static ArrayList<String> my_list_user_id;
    public static ArrayList<Integer> my_list_status;
    public static ArrayList<String> my_list_description;
    public static ArrayList<String> my_list_create_at;
    public static ArrayList<String> my_list_update_at;
    public static ArrayList<Integer> my_list_like_count;
    public static ArrayList<Integer> my_list_view_count;
    public static ArrayList<Integer> my_list_comment_count;
    public static ArrayList<ArrayList<String>> my_list_p_thumbnail;
    public static ArrayList<String> my_list_c_thumbnail;
    public static ArrayList<String> my_list_nickname;
    public static ArrayList<String> my_list_profile;

    //------------------------------------------------- 끝 ---------------------------------------------------

    // shared preferences 로그인 세션
    public static SharedPreferences pref;

    // 로그인 변수
    public static int loginid;
    public static String logincurrency;
    public static String loginlanguage;
    public static String logincountry;

    //Auth 필수 값
    public static String android_id;
    public static String access_token;

    // 사용자 휴대폰 번호 확인
    public static String phone_number;

    // 사용자 정보 저장
    public static ArrayList<Integer> userinfouid;
    public static ArrayList<String> userinfo;

    //국가코드
    public static String countrycode;

    //카테고리 번호 기본 : 0
    public static int category_num = 0;

    // 보야지 페이지 카테고리 리스트
    public static ArrayList<String> cate_number;
    public static ArrayList<String> cate_name;

    //설정 페이지 카테고리 리스트
    public static ArrayList<String> usersetting_category;

    //검색
    public static String keyword = null;

    //infocheck 변수
    public static int infocheck_id;
    public static int myuid;

    // Atrend 변수
    public static String param_atrend_id;

    //Product Info 변수
    public static String param_product_id;

    //Product Info 변수
    public static int param_creator_info;

    //구독하기, 구독해제하기 판단 switch 변수
    public static String param_subscribe_type;
    public static int param_subscribe_to_id;
    public static int param_subscribe_activity;

    //장바구니 디테일 옵션 갯수
    public static int param_cartdetail_optionname_size = 0;

    public static String nowurl;

    public static int selected_num;

    // 구독 하고있는지 아닌지 체크
    public static int subscribe_checker;
    public static int refresh_num;

    //구독페이지 어떤 크리에이터 선택되었는지 알게하는 변수
    public static int subscribe_select_creator_id;
    public static int subscribe_select_creator_num;

    //장바구니 자세히보기에서 옵션 추가할때 옛날에 썻엇음
    public static ArrayList<String> addoption;
    static String addoptionsize;
    public static ArrayList<ArrayList<String>> cartitemoption;

    // 영상 플레이어 내에서 사용?
    public static String title;
    public static String maintitle = null;
    public static String subtitle = null;
    public static String creatortitle = null;
    public static String creatorprofile = null;
    public static String creatorauthorid = null;

    public static String select_voyage_id;
    public static int childlist = 0; /* 영상 플레이어의 상품 표시에 필요함 */
    public static int contentcounter = 0; /* 영상 플레이어 하단의 related에 필요함 */
    public static int select; /* 영상 index */
    public static int typeselector; /* Atrend, Popular, Voyage 구분 */
    public static int playerdataload = 0; /* API 로드 여부 */
    public static ArrayList<String> playerfeedimage;
    public static ArrayList<String> playerfeedname;
    public static ArrayList<String> playerfeedpricecomputed;

    public static ArrayList<String> player_feed_list_author_id;
    public static ArrayList<String> player_feed_list_crop;
    public static ArrayList<String> player_feed_list_id;
    public static ArrayList<String> player_feed_list_content;
    public static ArrayList<String> player_feed_list_author_picture;
    public static ArrayList<String> player_feed_list_author_nickname;
    public static ArrayList<String> player_feed_list_views;

    public static int focusing;

    // 배열 재사용을 위한 배열 초기화

    public static void AllClear()
    {

        adduserapiload = 0;
        homeapiload = 0;
        voyageapiload = 0;
        voyagecategoryapiload = 0;
        voyagefocusapiload = 0;
        subscribeapiload = 0;
        subscribefocusapiload = 0;
        voyageresultapiload = 0;
        settinguseraccountmanagementapiload = 0;
        cartapiload = 0;
        cartdetailapiload = 0;
        myapiload = 0;
        creatorapiload = 0;
        mydetailapiload = 0;
        creatordetailapiload = 0;
        usersettinglanguageapiload = 0;

        // API 스타트 리미트 값 4X3 배열을 기준으로 스타트 0 리미트 12부터 보통 시작
        homepopularstart = 0;
        homepopularlimit = 23;
        subscribevoyagestart = 0;
        subscribevoyagelimit = 12;
        creatorstart = 0;
        creatorlimit = 12;
        mystart = 0;
        mylimit = 12;
        voyageresultstart = 0;
        voyageresultlimit = 0;
        voyagestart = 0;
        voyagelimit = 12;

        atrend_id.clear();
        atrend_user_id.clear();
        atrend_type.clear();
        atrend_product_id.clear();
        atrend_contents_id.clear();
        atrend_title.clear();
        atrend_subtitle.clear();
        atrend_description.clear();
        atrend_summary.clear();
        atrend_view.clear();
        atrend_like.clear();
        atrend_color.clear();
        atrend_start_at.clear();
        atrend_create_at.clear();
        atrend_update_at.clear();
        atrend_opacity.clear();
        atrend_status.clear();
        atrend_background.clear();
        atrend_thumbnail.clear();

        atrend_detail_detp_html.clear();
        atrend_detail_maincontent.clear();
        atrend_detail_product_id.clear();
        atrend_detail_product_name.clear();
        atrend_detail_product_brand.clear();
        atrend_detail_product_thumbnail.clear();
        atrend_detail_product_price.clear();
        atrend_detail_product_previous_price.clear();

        atrend_related_id.clear();
        atrend_related_user_id.clear();
        atrend_related_type.clear();
        atrend_related_product_id.clear();
        atrend_related_contents_id.clear();
        atrend_related_title.clear();
        atrend_related_subtitle.clear();
        atrend_related_description.clear();
        atrend_related_summary.clear();
        atrend_related_view.clear();
        atrend_related_like.clear();
        atrend_related_color.clear();
        atrend_related_start_at.clear();
        atrend_related_create_at.clear();
        atrend_related_update_at.clear();
        atrend_related_opacity.clear();
        atrend_related_status.clear();
        atrend_related_background.clear();
        atrend_related_thumbnail.clear();

        popular_id.clear();
        popular_user_id.clear();
        popular_product_id.clear();
        popular_contents_id.clear();
        popular_contents_type.clear();
        popular_category_id.clear();
        popular_status.clear();
        popular_description.clear();
        popular_create_at.clear();
        popular_update_at.clear();
        popular_like_count.clear();
        popular_view_count.clear();
        popular_comment_count.clear();
        popular_category_en.clear();
        popular_category_kr.clear();
        popular_nickname.clear();
        popular_photo.clear();
        popular_p_thumbnail.clear();
        popular_c_thumbnail.clear();

        popular_detail_id.clear();
        popular_detail_user_id.clear();
        popular_detail_product_id.clear();
        popular_detail_contents_id.clear();
        popular_detail_contents_type.clear();
        popular_detail_category_id.clear();
        popular_detail_status.clear();
        popular_detail_description.clear();
        popular_detail_create_at.clear();
        popular_detail_update_at.clear();
        popular_detail_like_count.clear();
        popular_detail_view_count.clear();
        popular_detail_comment_count.clear();
        popular_detail_category_en.clear();
        popular_detail_category_kr.clear();
        popular_detail_name.clear();
        popular_detail_photo.clear();
        popular_detail_contents.clear();
        popular_detail_items.clear();

        popular_detail_item_id.clear();
        popular_detail_item_name.clear();
        popular_detail_item_brand.clear();
        popular_detail_item_thumbnail.clear();
        popular_detail_item_price.clear();
        popular_detail_item_previous_price.clear();

        popular_related_id.clear();
        popular_related_user_id.clear();
        popular_related_status.clear();
        popular_related_description.clear();
        popular_related_create_at.clear();
        popular_related_update_at.clear();
        popular_related_like_count.clear();
        popular_related_view_count.clear();
        popular_related_comment_count.clear();
        popular_related_contents.clear();

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
        voyage_c_thumbnail.clear();

        voyage_detail_id.clear();
        voyage_detail_user_id.clear();
        voyage_detail_product_id.clear();
        voyage_detail_contents_id.clear();
        voyage_detail_contents_type.clear();
        voyage_detail_category_id.clear();
        voyage_detail_status.clear();
        voyage_detail_description.clear();
        voyage_detail_create_at.clear();
        voyage_detail_update_at.clear();
        voyage_detail_like_count.clear();
        voyage_detail_view_count.clear();
        voyage_detail_comment_count.clear();
        voyage_detail_category_en.clear();
        voyage_detail_category_kr.clear();
        voyage_detail_nickname.clear();
        voyage_detail_photo.clear();
        voyage_detail_contents.clear();
        voyage_detail_items.clear();

        voyage_detail_item_id.clear();
        voyage_detail_item_name.clear();
        voyage_detail_item_brand.clear();
        voyage_detail_item_thumbnail.clear();
        voyage_detail_item_price.clear();
        voyage_detail_item_previous_price.clear();

        voyage_related_id.clear();
        voyage_related_user_id.clear();
        voyage_related_status.clear();
        voyage_related_description.clear();
        voyage_related_create_at.clear();
        voyage_related_update_at.clear();
        voyage_related_like_count.clear();
        voyage_related_view_count.clear();
        voyage_related_comment_count.clear();
        voyage_related_contents.clear();

        voyageresult_id.clear();
        voyageresult_user_id.clear();
        voyageresult_product_id.clear();
        voyageresult_contents_id.clear();
        voyageresult_contents_type.clear();
        voyageresult_category_id.clear();
        voyageresult_status.clear();
        voyageresult_description.clear();
        voyageresult_create_at.clear();
        voyageresult_update_at.clear();
        voyageresult_like_count.clear();
        voyageresult_view_count.clear();
        voyageresult_comment_count.clear();
        voyageresult_category_en.clear();
        voyageresult_category_kr.clear();
        voyageresult_photo.clear();
        voyageresult_nickname.clear();
        voyageresult_p_thumbnail.clear();

        cart_shop_id.clear();
        cart_shop_photo.clear();
        cart_shop_nickname.clear();
        cart_shop_shop_name.clear();
        cart_items_p_cart_id.clear();
        cart_items_p_user_id.clear();
        cart_items_p_option_value.clear();
        cart_items_p_option_price.clear();
        cart_items_p_option_stock.clear();
        cart_items_p_product_id.clear();
        cart_items_p_status.clear();
        cart_items_p_vendor_id.clear();
        cart_items_p_name.clear();
        cart_items_p_thumbnail.clear();
        cart_items_p_ship.clear();
        cart_items_p_previous_price.clear();
        cart_items_p_price.clear();
        cart_items_c_cart_id.clear();
        cart_items_c_user_id.clear();
        cart_items_c_option_value.clear();
        cart_items_c_option_price.clear();
        cart_items_c_option_stock.clear();
        cart_items_c_product_id.clear();
        cart_items_c_status.clear();
        cart_items_c_vendor_id.clear();
        cart_items_c_name.clear();
        cart_items_c_thumbnail.clear();
        cart_items_c_ship.clear();
        cart_items_c_previous_price.clear();
        cart_items_c_price.clear();

        subscribe_creator_list_id.clear();
        subscribe_creator_list_nickname.clear();
        subscribe_creator_list_photo.clear();
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
        subscribe_voyage_list_name.clear();
        subscribe_voyage_list_photo.clear();
        subscribe_voyage_list_description.clear();
        subscribe_voyage_list_p_thumbnail.clear();
        subscribe_voyage_list_c_thumbnail.clear();

        creator_id = 0;
        creator_nickname = null;
        creator_photo = null;
        creator_zip = null;
        creator_city = null;
        creator_state = null;
        creator_address = null;
        creator_subscribeto_cnt = 0;
        creator_contents_cnt = 0;
        creator_desc = null;
        creator_list_id.clear();
        creator_list_user_id.clear();
        creator_list_status.clear();
        creator_list_description.clear();
        creator_list_create_at.clear();
        creator_list_update_at.clear();
        creator_list_like_count.clear();
        creator_list_view_count.clear();
        creator_list_comment_count.clear();
        creator_list_p_thumbnail.clear();
        creator_list_c_thumbnail.clear();
        creator_list_nickname.clear();
        creator_list_profile.clear();

        recommend_id.clear();
        recommend_nickname.clear();
        recommend_photo.clear();
        recommend_subscribeto_cnt.clear();
        recommend_contents_cnt.clear();

        my_id = null;
        my_nickname = null;
        my_photo = null;
        my_zip = null;
        my_city = null;
        my_state = null;
        my_address = null;
        my_subscribeto_cnt = null;
        my_contents_cnt = null;
        my_desc = null;
        my_list_id.clear();
        my_list_user_id.clear();
        my_list_status.clear();
        my_list_description.clear();
        my_list_create_at.clear();
        my_list_update_at.clear();
        my_list_like_count.clear();
        my_list_view_count.clear();
        my_list_comment_count.clear();
        my_list_p_thumbnail.clear();
        my_list_c_thumbnail.clear();
        my_list_nickname.clear();
        my_list_profile.clear();

        //그 외 설정변수
        category_num = 0;
        cate_number.clear();
        cate_name.clear();
        usersetting_category.clear();
        String keyword = null;
        param_atrend_id = null;
        nowurl = null;
        selected_num = 0;
        subscribe_checker = 0;
        refresh_num = 0;
        subscribe_select_creator_id = 0;
        subscribe_select_creator_num = 0;
        addoption.clear();
        addoptionsize = null;
        cartitemoption.clear();
        title = null;
        maintitle = null;
        subtitle = null;
        creatortitle = null;
        creatorprofile = null;
        creatorauthorid = null;
        select_voyage_id = null;
        childlist = 0; /* 영상 플레이어의 상품 표시에 필요함 */
        contentcounter = 0; /* 영상 플레이어 하단의 related에 필요함 */
        select = 0; /* 영상 index */
        typeselector = 0; /* Atrend, Popular, Voyage 구분 */
        playerdataload = 0; /* API 로드 여부 */
        playerfeedimage.clear();
        playerfeedname.clear();
        playerfeedpricecomputed.clear();
        player_feed_list_author_id.clear();
        player_feed_list_crop.clear();
        player_feed_list_id.clear();
        player_feed_list_content.clear();
        player_feed_list_author_picture.clear();
        player_feed_list_author_nickname.clear();
        player_feed_list_views.clear();
        focusing = 0;

    }

    public static void CreatorClear() {

        creatorapiload = 0;
        creator_id = 0;
        creator_nickname = null;
        creator_photo = null;
        creator_zip = null;
        creator_city = null;
        creator_state = null;
        creator_address = null;
        creator_subscribeto_cnt = 0;
        creator_contents_cnt = 0;
        creator_desc = null;
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

    }

    public static void CreatorDetailClear() {

        creatordetailapiload = 0;
        creatordetail_list_id.clear();
        creatordetail_list_nickname.clear();
        creatordetail_list_photo.clear();
        creatordetail_list_subscribeto_cnt.clear();
        creatordetail_list_contents_cnt.clear();
        creatordetail_list_is_subscribe.clear();
        subscribe_creator_list_id.clear();
        subscribe_creator_list_nickname.clear();
        subscribe_creator_list_photo.clear();

    }


    public static void MyDetailClear() {

        mydetailapiload = 0;
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
}
