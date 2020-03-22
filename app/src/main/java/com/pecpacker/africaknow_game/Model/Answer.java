
package com.pecpacker.africaknow_game.Model;

import java.io.Serializable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer implements Serializable {

    private final static long serialVersionUID = -3316745765848051030L;
    @SerializedName("option")
    @Expose
    private String option;
    @SerializedName("value")
    @Expose
    private boolean value;

    /**
     * No args constructor for use in serialization
     */
    public Answer() {
    }

    /**
     * @param value
     * @param option
     */
    public Answer(String option, boolean value) {
        super();
        this.option = option;
        this.value = value;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

}
