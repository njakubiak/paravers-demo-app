package com.parasoft.demoapp.model.global;

public enum LanguageType {

    DEFAULT("en"), EN("en"), ZH("zh");

    private String value;

    private LanguageType(String type) {
        this.value = type;
    }

    public String getValue() {
        return value;
    }
}
