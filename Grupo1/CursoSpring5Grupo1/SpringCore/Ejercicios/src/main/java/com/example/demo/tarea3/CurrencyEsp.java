package com.example.demo.tarea3;

public class CurrencyEsp implements ICurrency {

    @Override
    public String getLanguage() {
        return "esp";
    }

    @Override
    public String getPluralCurrency() {
        return "pesos";
    }

    @Override
    public String getSingularCurrency() {
        return "peso";
    }
    
}
