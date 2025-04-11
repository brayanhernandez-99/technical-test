package com.hackerrank.tradingplatform.dto;

import com.hackerrank.tradingplatform.model.Trader;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class TraderDTO {
    private final Long id;
    private final String name;
    private final String email;
    private final Double balance;
    private final String createdAt;
    private final String updatedAt;

    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public TraderDTO(Trader trader) {
        this.id = trader.getId();
        this.name = trader.getName();
        this.email = trader.getEmail();
        this.balance = trader.getBalance();
        this.createdAt = formatTimestamp(trader.getCreatedAt());
        this.updatedAt = trader.getUpdatedAt() != null ? formatTimestamp(trader.getUpdatedAt()) : "";
    }

    private String formatTimestamp(Timestamp timestamp) {
        return timestamp != null ? formatter.format(timestamp) : "";
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Double getBalance() {
        return balance;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

}
