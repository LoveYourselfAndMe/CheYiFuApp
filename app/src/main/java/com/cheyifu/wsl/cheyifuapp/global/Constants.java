package com.cheyifu.wsl.cheyifuapp.global;



/**
 *
 * 常量池
 * 缓存路径，存储路径，常量
 */
public class Constants {
    /**忘记密码*/
    public static final String ACTIVITY_FORGET = "activity_forget";
    public static final String ACTIVITY_FORGETMORE = "activity_forgetmore";
    /**注册的手机号码*/
    public static final String PHONE_NUM = "phone_num";
    /**发照片，发文字*/
    public static final String PIC_PATH = "pic_path_edit";
    public static final String CHOOSE_PHOTO = "choose_photo_edit";
    public static final String SPLASH_KEY = "splash_key";
    /**第三方登录和普通登录判别*/
    public static final String GENERALLOGIN = "generallogin";
    public static final String THIRDPARTYLOGIN = "thirdpartylogin";
    public static final String AUTHTYPE = "authtype";//平台授权标志
    public static final String QQ = "qq";
    public static final String WEIBO = "weibo";
    public static final String WEIXIN = "weixin";

    //微信，微博，QQ的key
    public static final String WEIBO_KEY = "1940878030";
    public static final String WEIBO_CALLBACK_URL = "http://sns.whalecloud.com/sina2/callback";
    public static final String WRCHAT_KEY = "wx02c9e9ed7e8295a6";
    public static final String WRCHAT_SECRET = "fdfe0ebe38d0f8e12adb7e0eeb671b4a";
    public static final String QQ_KEY = "1104900258";

    //标记
    public static String FLAG_FRAGMENT ="flag";
    public final static int TYPE_PULLREFRESH = 1;
    public final static int TYPE_UPLOADREFRESH = 2;
    //我的界面储存的一些值
    public static final String EASEUI_HEADURL = "easeui_headurl";
    public static  String my_name="";
    public static  String my_sex="";
    public static String my_bitmap="";
    public static  String my_email="";
    public static  String my_phone="";
    public static  String my_signature="";
    //界面跳转标记
    public static final String VIDEO_THUMB = "video_thumb";
    public static final int STARTACTIVITY_CODE = 1;
    public static final String RECTITY_BEAN = "rectity_bean";
    public static final String RECTITY_BEAN_LATLNG = "rectity_bean_latlng";
    public static final int LOCATION = 2;
    public static final String IMAGE_UNSPECIFIED = "image/*";
    public static final int CODE_NATIVE_REQUEST = 0xa3;//本地
    public static final String IMAGE_FILE_NAME = "my_head_image.jpg";
    public static final int CODE_CAMERA_REQUEST = 0xa1;//拍照
    public static final int CODE_RESULT_REQUEST = 0xa4;//最终剪切的结果


    //SP存储key
    public static final String TOPIC_DETAILS_KEY = "topic_details_key";
    public static final String CURRENT_MY_LOCATION_CITY = "current_my_location_city";
    public static final String CURRENT_MYLAT_SP = "current_my_lat";
    public static final String CURRENT_MYLONGI_SP = "current_my_longi";
    public static final String CHOOSE_PHOTO_CACHE = "choose_photo_cache";
    public static final String VIDEO_PATH = "video_path";
    public static final String EDIT_TEXT = "edit_text";
    public static final String SP_SEX = "sex";
    public static final String SP_PHONE_NUM_KEY = "phone_num";
    public static final String SP_USERID = "userId";
    public static final String SP_USERNAME = "userName";
    public static final String SP_PET_COUNT = "pet_count";
    public static final String PET_FRIEND_INFO_CACHE = "pet_friend_info_cache";
    public static final String PET_CIRCLE_INFO_CACHE = "pet_circle_info_cache";
    public static final String SINGLE_INFO_PAGE = "single_info_page";
    public static final String SINGLE_INFO_PAGE_NAME = "single_info_page_name";
    public static final String SP_PET_PUSH_NOTIFICATION = "open_close";
    public static final String SP_PET_MESSAGE_PUSH_VOICE = "voice_switch";
    public static final String SP_PETINFO_TIME = "petinfo_time";
    public static final String SP_PETINFO_ISFIRST = "petinfo_isfirst";
    public static final String SP_PRIVACY_ATTENTION = "privacy_attention";
    public static final String SP_PRIVACY_ATTENTION_STATE = "privacy_attention_state";
    public static final String SP_PRIVACY_DONGTAI = "privacy_dongtai";
    public static final String SP_PRIVACY_DONGTAI_STATE = "privacy_dongtai_state";

    //小视频
    public final static String FILE_START_NAME = "runda_";
    public final static String VIDEO_EXTENSION = ".mp4";
    public final static String VIDEO_FOLDER = "/video";
    public static final String IMAGE_EXTENSION = ".png";
    public final static String IMAGE_FOLDER = "/image";
    //资讯界面数据传递标志
    public static final String URL="tabinfo_htmlurl";
    public static final String POSITION="tabinfo_position";
    public static final String USERID="tabinfo_userid";
    public static final String INFOMATIONID="tabinfo_infomationid";
    public static final String ISLIKE="tabinfo_islike";
    public static final String ISCOLLECT="tabinfo_iscollect";
    public static final String CONTENT="tabinfo_content";
    public static final String IMAGEURL="tabinfo_imageurl";

    /**
     * 环信所用到的常量
     */
    public static final String EASECHATPWD="111111";//环信用户统一用一个密码注册

    public static final String NEW_FRIENDS_USERNAME = "item_new_friends";
    public static final String GROUP_USERNAME = "item_groups";
    public static final String CHAT_ROOM = "item_chatroom";
    public static final String ACCOUNT_REMOVED = "account_removed";
    public static final String ACCOUNT_CONFLICT = "conflict";
    public static final String ACCOUNT_FORBIDDEN = "user_forbidden";
    public static final String CHAT_ROBOT = "item_robots";
    public static final String MESSAGE_ATTR_ROBOT_MSGTYPE = "msgtype";
    public static final String ACTION_GROUP_CHANAGED = "action_group_changed";
    public static final String ACTION_CONTACT_CHANAGED = "action_contact_changed";
   //环信所用常量结束


    /**
     * 用户登录
     */
    public final static String USER_LOGIN = "login";
    /**
     *获取验证码
     */
    public final static String GET_CODE = "appRegSms";




}
