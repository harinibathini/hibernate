package org.example;

import javax.persistence.*;

@Entity
public class Answer1toM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int answerId;
    private String answer;
    @ManyToOne
    private Question1toM question1toM;

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Question1toM getQuestion1toM() {
        return question1toM;
    }

    public void setQuestion1toM(Question1toM question1toM) {
        this.question1toM = question1toM;
    }
}
