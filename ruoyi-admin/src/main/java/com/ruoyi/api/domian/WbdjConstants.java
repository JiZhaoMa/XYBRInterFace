package com.ruoyi.api.domian;



/**
 * 外部对接相关配置常量累
 */
public class WbdjConstants {

    public static final String YT_PWD_SEC_KEY = "xnsnwzc";


    /** 云天APP **/
    public static final String WBDJ_SYSTEM_YT = "ytAPp";

    public static final String WBDJ_SYSTEM_NXJC = "nxjc";

    /** 云天需要的接口来源方  固定值101 **/
    public static final String YUNTIAN_SOURCE = "101";

    /** 云天接口成功响应码 **/
    public static final Integer YUNTIAN_INTER_CODE_SUCCESS = 200;
    /** 云天接口失败响应码 **/
    public static final Integer YUNTIAN_INTER_CODE_FAIL = 400;

    /** 是否自动登录云天账号   是 **/
    public static final int YUNTIAN_AUTO_1 = 1;
    /** 是否自动登录云天账号   否 **/
    public static final int YUNTIAN_AUTO_0 = 0;


    //我找车接口响应码 0 代表成功
    public static final Integer WZC_INTER_CODE_0 = 0;


    //我找车新增司机接口响应码 200 代表成功
    public static final Integer WZC_INTER_CODE_SUCCESS = 200;



    //外部系统申请token所用字符
    public static final String SECRET_KEY = "abcdefghijklmnopqrstuvwxyz";


    /**  我找车运单运输状态 0:接单 **/
    public static final String WZC_TRANS_STATUS_0 = "0";
    /**  我找车运单运输状态 1:开启运单 **/
    public static final String WZC_TRANS_STATUS_1 = "1";
    /**  我找车运单运输状态 2:预约装货 **/
    public static final String WZC_TRANS_STATUS_2 = "2";
    /**  我找车运单运输状态 3:装货签到/抵港待装 **/
    public static final String WZC_TRANS_STATUS_3 = "3";
    /**  我找车运单运输状态 4:装货确认/装船拍照 **/
    public static final String WZC_TRANS_STATUS_4 = "4";
    /**  我找车运单运输状态 5:预约卸货 **/
    public static final String WZC_TRANS_STATUS_5 = "5";
    /**  我找车运单运输状态 6:卸货签到/抵港待卸 **/
    public static final String WZC_TRANS_STATUS_6 = "6";
    /**  我找车运单运输状态 7:卸货确认/卸货拍照 **/
    public static final String WZC_TRANS_STATUS_7 = "7";
    /**  我找车运单运输状态 8:货主签收 **/
    public static final String WZC_TRANS_STATUS_8 = "8";
    /**  我找车运单运输状态 11:开航 **/
    public static final String WZC_TRANS_STATUS_11 = "11";




    public static final String TEMP_CODE= "500";


}
