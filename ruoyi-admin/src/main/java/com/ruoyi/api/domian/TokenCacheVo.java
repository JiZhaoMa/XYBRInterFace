package com.ruoyi.api.domian;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author kyriemtx
 * @version 1.0
 * @date 2024/3/20  11:00
 * @Filename：TokenCacheVo
 */
@Data
public class TokenCacheVo {

    /** 平台信息 **/
    private OrderPlatInfo orderPlatInfo;
    /** 授权接口列表信息 **/
    private List<OrderInterInfo> orderInterInfos;
    /** 存入緩存時間 **/
    private Date createTime;

}
