package com.kh0ma.product_requester_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.MoreObjects;

import java.math.BigDecimal;

public class Invoicedto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("balance")
    private BigDecimal balance;
    @JsonProperty("subscription_id")
    private Long subscriptionId;
    @JsonProperty("bill_cycle_run_id")
    private Long billCycleRunId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Long getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(Long subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public Long getBillCycleRunId() {
        return billCycleRunId;
    }

    public void setBillCycleRunId(Long billCycleRunId) {
        this.billCycleRunId = billCycleRunId;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("balance", balance)
                .add("subscriptionId", subscriptionId)
                .add("billCycleRunId", billCycleRunId)
                .toString();
    }
}

