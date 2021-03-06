package com.xcphoenix.dto.mapper;

import com.xcphoenix.dto.bean.ao.OrderModify;
import com.xcphoenix.dto.bean.dao.Order;
import com.xcphoenix.dto.bean.dao.OrderItem;
import org.apache.ibatis.annotations.Param;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author xuanc
 * @version 1.0
 * @date 2019/10/22 下午9:23
 */
public interface OrderMapper {

    /**
     * 添加订单
     *
     * @param order 订单基本属性
     *              地址信息
     *              支付方式
     *              店铺id
     *              数量
     *              商品id 数量 价格
     *              费用
     *              备注
     */
    void addOrder(@Param("order") Order order);

    /**
     * 添加订单商品项
     *
     * @param orderItem 订单项信息
     * @param orderCode 订单编号
     */
    void addOrderItem(@Param("orderItem") OrderItem orderItem, @Param("orderCode") Long orderCode);

    /**
     * 修改订单信息
     *
     * @param userId    用户id
     * @param orderCode 订单编号
     * @param moData    订单信息
     */
    void updateOrder(@Param("userId") Long userId, @Param("orderCode") Long orderCode, @Param("moData") OrderModify moData);

    /**
     * 获取订单详情
     *
     * @param orderId 订单id
     * @param userId  用户id
     * @return 订单信息
     */
    Order getOrderById(@Param("userId") Long userId, @Param("orderId") Long orderId);

    /**
     * 根据订单获取指定订单的商品信息
     *
     * @param orderCode 订单号
     * @return 商品信息
     */
    List<OrderItem> getItemByOrderCode(@Param("orderCode") Long orderCode);

    /**
     * 获取订单数量
     *
     * @param userId 用户id
     * @return 订单数量
     */
    Integer getOrderNum(@Param("userId") Long userId);

    /**
     * 获取全部订单 <br />
     * <strong>必须使用分页</strong>
     *
     * @param userId 用户id
     * @return 用户的历史订单
     */
    List<Order> getOrders(@Param("userId") Long userId);

    /**
     * 获取当前的订单列表
     *
     * @param userId 用户id
     * @param status 当前订单状态集
     * @return 用户的当前订单信息
     */
    List<Order> getCurrentOrders(@Param("userId") Long userId, @Param("status") List<Integer> status);

    /**
     * 获取历史订单列表
     *
     * @param userId 用户id
     * @param status 当前订单状态集
     * @return 历史订单信息
     */
    List<Order> getHistoryOrders(@Param("userId") Long userId, @Param("status") List<Integer> status);

    /**
     * 获取指定状态的订单数量
     *
     * @param userId 用户id
     * @param status 指定的状态列表
     * @return 符合条件的订单数量
     */
    Integer getOrderInStatus(@Param("userId") Long userId, @Param("status") List<Integer> status);

    /**
     * 修改订单状态
     *
     * @param userId  用户id
     * @param orderId 订单id
     * @param type    类型
     */
    void changeOrderStatus(@Param("userId") Long userId, @Param("orderId") Long orderId, @Param("type") int type);

    /**
     * 获取订单状态
     *
     * @param userId  用户id
     * @param orderId 订单id
     * @return 订单状态
     */
    Integer getOrderStatus(@Param("userId") Long userId, @Param("orderId") Long orderId);

    /**
     * 删除已取消的订单
     *
     * @param userId    用户id
     * @param orderCode 订单编号
     */
    void delCanceledOrder(@Param("userId") Long userId, @Param("orderCode") Long orderCode);

    /**
     * 更新支付时间
     *
     * @param userId    用户id
     * @param orderCode 订单编号
     * @param payType   支付方式
     */
    void updatePayTime(@Param("userId") Long userId, @Param("orderCode") Long orderCode, @Param("payType") int payType);

    /**
     * 获取订单失效时间
     * @param userId 用户id
     * @param orderCode 订单编号
     * @return 过期时间
     */
    Timestamp getOrderInvalidTime(@Param("userId") Long userId, @Param("orderCode") Long orderCode);

}
