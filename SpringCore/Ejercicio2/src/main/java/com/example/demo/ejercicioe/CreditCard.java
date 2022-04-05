package com.example.demo.ejercicioe;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditCard {
    private String rawCardNumber;
    private Integer bankId;
    private Integer accountNo;
    private Integer checkCode;
}
