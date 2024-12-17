package com.ruoyi.api.mapper;

import java.util.List;

import com.ruoyi.api.domian.OrderInterInfo;
import com.ruoyi.api.domian.OrderPlatInfo;

/**
 * 接口信息Mapper接口
 *
 * @author kyrie
 * @date 2024-03-15
 */
public interface OrderInterInfoMapper {
    /**
     * 查询接口信息
     *
     * @param id 接口信息主键
     * @return 接口信息
     */
    OrderInterInfo selectOrderInterInfoById(Long id);

    /**
     * 查询接口信息列表
     *
     * @param orderInterInfo 接口信息
     * @return 接口信息集合
     */
    List<OrderInterInfo> selectOrderInterInfoList(OrderInterInfo orderInterInfo);

    /**
     * 新增接口信息
     *
     * @param orderInterInfo 接口信息
     * @return 结果
     */
    int insertOrderInterInfo(OrderInterInfo orderInterInfo);

    /**
     * 修改接口信息
     *
     * @param orderInterInfo 接口信息
     * @return 结果
     */
    int updateOrderInterInfo(OrderInterInfo orderInterInfo);

    /**
     * 删除接口信息
     *
     * @param id 接口信息主键
     * @return 结果
     */
    int deleteOrderInterInfoById(Long id);

    /**
     * 批量删除接口信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteOrderInterInfoByIds(Long[] ids);


    /**
     * 获取平台已授权的接口列表
     * @param orderInterInfo
     * @return
     */
    List<OrderInterInfo> getAuthInterface(OrderInterInfo orderInterInfo);

    /**
     * 查询平台未授权接口列表
     * @param platId
     * @return
     */
    List<OrderInterInfo> getNoAuthInterList(Long platId);

    /**
     * 批量插入平台授权的接口列表
     * @param orderPlatInters
     * @return
     */
    int batchPlatInter(List<OrderPlatInfo> orderPlatInters);


    /** 取消接口授权 **/
    int cancelInterAuth(OrderInterInfo orderInterInfo);
}
