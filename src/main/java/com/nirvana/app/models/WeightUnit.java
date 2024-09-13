package com.nirvana.app.models;

public enum WeightUnit {
    KG("kg"),
    LBS("lbs");

    private final String abbreviation;

    WeightUnit(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static WeightUnit fromAbbreviation(String abbreviation) {
        for (WeightUnit unit : WeightUnit.values()) {
            if (unit.getAbbreviation().equalsIgnoreCase(abbreviation)) {
                return unit;
            }
        }
        throw new IllegalArgumentException("unknown unit: " + abbreviation);
    }
}
