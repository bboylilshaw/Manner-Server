package com.hp.manner.common;

public enum Status {

    NEW("New"),
    WORK_IN_PROGRESS("Work In Progress"),
    COMPLETE("Complete");

    Status(String text) {
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
