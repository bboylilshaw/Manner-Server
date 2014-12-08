package com.hp.manner.common;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Priority {

    LOW("Low"),
    MEDIUM("Medium"),
    HIGH("High"),
    URGENT("Urgent");

    Priority(String text) {
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
