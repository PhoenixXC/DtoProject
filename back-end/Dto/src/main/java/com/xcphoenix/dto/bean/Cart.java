package com.xcphoenix.dto.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

/**
 * @author xuanc
 * @version 1.0
 * @date 2019/10/9 下午9:55
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    Long cartId;
    Long userId;
    Long restaurantId;
    float discountAmount;
    float originalTotal;
    float total;
    int totalWeight;
    List<CartItem> cartItems;

    /**
     * 初始化数据
     */
    public void init() {
        this.discountAmount = 0;
        this.originalTotal = 0;
        this.total = 0;
        this.totalWeight = 0;
    }

    public void computeDiscount() {
        this.discountAmount = this.originalTotal - this.total;
    }

    public void compute(CartItem cartItem) {
        this.totalWeight += cartItem.getQuantity();
        this.total += cartItem.getSellingPrice();
        this.originalTotal += cartItem.getOriginalPrice();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cart)) {
            return false;
        }
        Cart cart = (Cart) o;
        return Float.compare(cart.getDiscountAmount(), getDiscountAmount()) == 0 &&
                Float.compare(cart.getOriginalTotal(), getOriginalTotal()) == 0 &&
                Float.compare(cart.getTotal(), getTotal()) == 0 &&
                getTotalWeight() == cart.getTotalWeight() &&
                getCartId().equals(cart.getCartId()) &&
                getUserId().equals(cart.getUserId()) &&
                getRestaurantId().equals(cart.getRestaurantId()) &&
                getCartItems().containsAll(cart.getCartItems()) &&
                cart.getCartItems().containsAll(getCartItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCartId(), getUserId(), getRestaurantId(), getDiscountAmount(), getOriginalTotal(), getTotal(), getTotalWeight(), getCartItems());
    }
}
