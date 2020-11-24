package com.kh0ma.product_requester_api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.google.common.base.MoreObjects;

import java.time.LocalDate;

public class BillCycleRunDto {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("status")
    private StatusEnum status;
    @JsonProperty("start_date")
    private LocalDate startDate;
    @JsonProperty("end_date")
    private LocalDate endDate;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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
                .add("startDate", startDate)
                .add("endDate", endDate)
                .add("billCycleId", billCycleId)
                .toString();
    }

    public enum StatusEnum {
        CREATED("CREATED"),

        IN_QUEUE("IN_QUEUE"),

        COMPLETED("COMPLETED"),

        ERROR("ERROR");

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

