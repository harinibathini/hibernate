package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Question1toM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int questionId;
    private String question;
//    @OneToMany     extra table having list of all questions and ansr will get created
//    private List<Answer1toM> answer1toM;

    @OneToMany(mappedBy = "question1toM",fetch = FetchType.EAGER)  //no extra table will get created as already both tables have relation(by extra column)
    private List<Answer1toM> answer1toM;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<Answer1toM> getAnswer1toM() {
        return answer1toM;
    }

    public void setAnswer1toM(List<Answer1toM> answer1toM) {
        this.answer1toM = answer1toM;
    }

    @Override
    public String toString() {
        return "Question1toM{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer1toM=" + answer1toM +
                '}';
    }
}
