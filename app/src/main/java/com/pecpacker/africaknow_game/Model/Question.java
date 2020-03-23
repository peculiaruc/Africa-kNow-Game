
package com.pecpacker.africaknow_game.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "question_table")
public class Question implements Serializable {
    @PrimaryKey(autoGenerate = true)
    @NonNull

    private final static long serialVersionUID = -8642606268815438541L;
    @SerializedName("answers")
    @Expose
    private List<Answer> answers = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("question")
    @Expose
    private String question;
    @SerializedName("__v")
    @Expose
    private int v;

    /**
     * No args constructor for use in serialization
     */
    public Question() {
    }

    /**
     * @param question
     * @param v
     * @param answers
     * @param id
     */
    public Question(List<Answer> answers, String id, String question, int v) {
        super();
        this.answers = answers;
        this.id = id;
        this.question = question;
        this.v = v;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

}
