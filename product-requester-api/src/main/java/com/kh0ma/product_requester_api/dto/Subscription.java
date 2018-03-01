package com.kh0ma.product_requester_api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.MoreObjects;

import java.time.LocalDate;

public class Subscription {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("status")
    private StatusEnum status;
    @JsonProperty("valid_from")
    private LocalDate validFrom;
    @JsonProperty("valid_to")
    private LocalDate validTo;
    @JsonProperty("product_id")
    private Long productId;
    @JsonProperty("bill_cycle_id")
    private Long billCycleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public LocalDate getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(LocalDate validFrom) {
        this.validFrom = validFrom;
    }

    public LocalDate getValidTo() {
        return validTo;
    }

    public void setValidTo(LocalDate validTo) {
        this.validTo = validTo;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getBillCycleId() {
        return billCycleId;
    }

    public void setBillCycleId(Long billCycleId) {
        this.billCycleId = billCycleId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("status", status)
                .add("validFrom", validFrom)
                .add("validTo", validTo)
                .add("productId", productId)
                .add("billCycleId", billCycleId)
                .toString();
    }

    public enum StatusEnum {
        DRAFT("DRAFT"),

        ACTIVE("ACTIVE"),

        EXPIRED("EXPIRED");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @JsonCreator
        public static StatusEnum fromValue(String text) {
            for (StatusEnum b : StatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        @Override
        @JsonValue
        public String toString() {
            return String.valueOf(value);
        }
    }
}

