package com.hp.manner.common;

public enum ItemType {

    A("Action"),
    P("Personal Item"),
    N("News");

    ItemType(String text) {
        this.text = text;
    }

    private String text;

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
