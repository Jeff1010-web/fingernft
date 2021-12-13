package com.fingerchar.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fingerchar.base.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableField;

/**
 * @Description FcOrder
 * @Author 
 * @Date 2021-12-11
 * @Version 2.1
 */
@TableName("`fc_order`")
public class FcOrder extends BaseEntity {


    /**
     * order发起者
     */
    @TableField("`owner`")
    private String owner;

    /**
     * 售卖token地址
     */
    @TableField("`sell_token`")
    private String sellToken;

    /**
     * 售卖token id
     */
    @TableField("`sell_token_id`")
    private String sellTokenId;

    /**
     * 售卖token类型
     */
    @TableField("`sell_type`")
    private Integer sellType;

    /**
     * 售卖token价格
     */
    @TableField("`sell_value`")
    private String sellValue;

    /**
     * 购买token地址
     */
    @TableField("`buyer_token`")
    private String buyerToken;

    /**
     * 购买token id
     */
    @TableField("`buyer_token_id`")
    private String buyerTokenId;

    /**
     * 购买token类型
     */
    @TableField("`buyer_type`")
    private Integer buyerType;

    /**
     * 购买token价格
     */
    @TableField("`buyer_value`")
    private String buyerValue;

    /**
     * 盐
     */
    @TableField("`salt`")
    private String salt;

    /**
     * 签名
     */
    @TableField("`signature`")
    private String signature;

    /**
     * 状态0 未完成， 1完成
     */
    @TableField("`status`")
    private Integer status;

    /**
     * 是否过期
     */
    @TableField("`expired`")
    private Boolean expired;

    /**
     * 订单类型
     */
    @TableField("`order_type`")
    private Integer orderType;

    /**
     * usdt价格
     */
    @TableField("`usdt_price`")
    private String usdtPrice;

    /**
     * 已经售卖数量
     */
    @TableField("`sells`")
    private Long sells;


    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSellToken() {
        return sellToken;
    }

    public void setSellToken(String sellToken) {
        this.sellToken = sellToken;
    }

    public String getSellTokenId() {
        return sellTokenId;
    }

    public void setSellTokenId(String sellTokenId) {
        this.sellTokenId = sellTokenId;
    }

    public Integer getSellType() {
        return sellType;
    }

    public void setSellType(Integer sellType) {
        this.sellType = sellType;
    }

    public String getSellValue() {
        return sellValue;
    }

    public void setSellValue(String sellValue) {
        this.sellValue = sellValue;
    }

    public String getBuyerToken() {
        return buyerToken;
    }

    public void setBuyerToken(String buyerToken) {
        this.buyerToken = buyerToken;
    }

    public String getBuyerTokenId() {
        return buyerTokenId;
    }

    public void setBuyerTokenId(String buyerTokenId) {
        this.buyerTokenId = buyerTokenId;
    }

    public Integer getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(Integer buyerType) {
        this.buyerType = buyerType;
    }

    public String getBuyerValue() {
        return buyerValue;
    }

    public void setBuyerValue(String buyerValue) {
        this.buyerValue = buyerValue;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Boolean getExpired() {
        return expired;
    }

    public void setExpired(Boolean expired) {
        this.expired = expired;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public String getUsdtPrice() {
        return usdtPrice;
    }

    public void setUsdtPrice(String usdtPrice) {
        this.usdtPrice = usdtPrice;
    }

    public Long getSells() {
        return sells;
    }

    public void setSells(Long sells) {
        this.sells = sells;
    }

    public static final String OWNER = "`owner`";

    public static final String SELL_TOKEN = "`sell_token`";

    public static final String SELL_TOKEN_ID = "`sell_token_id`";

    public static final String SELL_TYPE = "`sell_type`";

    public static final String SELL_VALUE = "`sell_value`";

    public static final String BUYER_TOKEN = "`buyer_token`";

    public static final String BUYER_TOKEN_ID = "`buyer_token_id`";

    public static final String BUYER_TYPE = "`buyer_type`";

    public static final String BUYER_VALUE = "`buyer_value`";

    public static final String SALT = "`salt`";

    public static final String SIGNATURE = "`signature`";

    public static final String STATUS = "`status`";

    public static final String EXPIRED = "`expired`";

    public static final String ORDER_TYPE = "`order_type`";

    public static final String USDT_PRICE = "`usdt_price`";

    public static final String SELLS = "`sells`";

    @Override
    public String toString() {
        return "FcOrder{" +
        "owner=" + owner +
        ", sellToken=" + sellToken +
        ", sellTokenId=" + sellTokenId +
        ", sellType=" + sellType +
        ", sellValue=" + sellValue +
        ", buyerToken=" + buyerToken +
        ", buyerTokenId=" + buyerTokenId +
        ", buyerType=" + buyerType +
        ", buyerValue=" + buyerValue +
        ", salt=" + salt +
        ", signature=" + signature +
        ", status=" + status +
        ", expired=" + expired +
        ", orderType=" + orderType +
        ", usdtPrice=" + usdtPrice +
        ", sells=" + sells +
        "}";
    }
}
