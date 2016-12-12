package br.com.anymarket.sdk.stock.dto;

import br.com.anymarket.sdk.AnymarketPojo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

import static java.util.Objects.isNull;


/**
 * This class represents Stock info to be sent to AnyMarket by API v2
 */
public class Stock implements AnymarketPojo {

    @JsonProperty("id")
    private Long id;
    @JsonProperty("partnerId")
    private String partnerId;
    @JsonProperty("quantity")
    private BigDecimal quantity;
    @JsonProperty("cost")
    private BigDecimal costPrice;


    private Stock(Builder builder) {
        if (isNull(builder.id) && isNull(builder.partnerId)) {
            throw new IllegalArgumentException(
                "It must be filled the id or partnerId");
        }
        if (isNull(builder.quantity) && isNull(builder.costPrice)) {
            throw new IllegalArgumentException(
                "It must be filled the quantity or cost");
        }
        this.id = builder.id;
        this.partnerId = builder.partnerId;
        this.quantity = builder.quantity;
        this.costPrice = builder.costPrice;
    }

    public static Builder builder() {
        return new Builder();
    }

    public Long getId() {
        return id;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    @Override
    public String getPathURI() {
        return "/stocks";
    }

    public static class Builder {

        private Long id;
        private String partnerId;
        private BigDecimal quantity;
        private BigDecimal costPrice;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withPartnerId(String partnerId) {
            this.partnerId = partnerId;
            return this;
        }

        public Builder withQuantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder withCostPrice(BigDecimal costPrice) {
            this.costPrice = costPrice;
            return this;
        }

        public Stock build() {
            return new Stock(this);
        }

    }

}