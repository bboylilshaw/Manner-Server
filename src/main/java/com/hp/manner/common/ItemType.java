package com.hp.manner.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ItemType {

    A("Action"),
    R("Reminder"),
    T("Task"),
    SA("Shared Action"),
    ST("Shared Task"),
    N("News");

    ItemType(String text) {
        this.text = text;
    }

    private String text;

    @JsonValue
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return this.getText();
    }

}
