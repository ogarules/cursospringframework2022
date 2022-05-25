package com.example.demo.tarea3;

public class CurrencyEng implements ICurrency {
    @Override
    public String getLanguage() {
        return "eng";
    }

    @Override
    public String getPluralCurrency() {
        return "dollars";
    }

    @Override
    public String getSingularCurrency() {
        return "dollar";
    }
}
