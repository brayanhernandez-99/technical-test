package com.hackerrank.tradingplatform.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class AddMoneyTraderDTO {
    @Email
    @NotBlank
    private String email;

    @NotNull
    @Min(0)
    private Double amount;

    public AddMoneyTraderDTO() {}

    public AddMoneyTraderDTO(String email, Double amount) {
        this.email = email;
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
