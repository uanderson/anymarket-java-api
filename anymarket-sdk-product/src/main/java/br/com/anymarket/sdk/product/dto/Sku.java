package br.com.anymarket.sdk.product.dto;


import br.com.anymarket.sdk.product.dto.deserializer.VariationDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Sku {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("partnerId")
    private String partnerId;

    @JsonProperty("amount")
    private BigDecimal stockAmount;

    @JsonProperty("ean")
    private String ean;

    @JsonProperty("title")
    private String title;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty(value = "variations")
    @JsonDeserialize(using = VariationDeserializer.class)
    private Map<String, String> variations = new HashMap<String, String>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getStockAmount() {
        return stockAmount;
    }

    public void setStockAmount(BigDecimal stockAmount) {
        this.stockAmount = stockAmount;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Map<String, String> getVariations() {
        return variations;
    }

    public void setVariations(Map<String, String> variations) {
        this.variations = variations;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
            .add("partnerId", partnerId)
            .add("stockAmount", stockAmount)
            .add("ean", ean)
            .add("title", title)
            .add("price", price)
            .add("variations", variations)
            .toString();
    }
}