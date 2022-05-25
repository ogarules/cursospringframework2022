package com.example.demo.tarea3;

public class NumericalEng implements INumerical {
    private final String[] UNITS_en = { "", "one", "two", "three", "four", "five",
    "six", "seven", "eight", "nine" };

private final String[] DOZENS_en = { "ten", "eleven", "twlve", "thirteen",
    "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
    "nineteen", "twenty", "thirty", "fourty", "fifty",
    "sixty", "seventy", "eighty", "ninety" };

private final String[] HUNDREDS_en = { "", "one hundred", "two hundred",
    "three hundred", "four hundred", "five hundred", "six hundred",
    "seven hundred", "eight hundred", "nine hundred" };

    public String[] getUnits() {
        return UNITS_en;
    }

    public String[] getDozens() {
        return DOZENS_en;
    }

    public String[] getHundreds() {
        return HUNDREDS_en;
    }

    public String getZero() {
        return "zero";
    }

    public String getOneHundred() {
        return "hundred";
    }

    public String getAnd() {
        return "";
    }

    public String getOneThousand() {
        return "thousenf";
    }

    public String getOneMillion() {
        return "million";
    }

    public String getMillions() {
        return "millions";
    }

    @Override
    public String getLanguage() {
        return "eng";
    }
}
