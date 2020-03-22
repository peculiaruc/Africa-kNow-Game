
package com.pecpacker.africaknow_game.Model;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GameModel implements Serializable {

    private final static long serialVersionUID = 759768620779783568L;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("questions")
    @Expose
    private List<Question> questions = null;

    /**
     * No args constructor for use in serialization
     */
    public GameModel() {
    }

    /**
     * @param questions
     * @param message
     */
    public GameModel(String message, List<Question> questions) {
        super();
        this.message = message;
        this.questions = questions;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

}
