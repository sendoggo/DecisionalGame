/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Francesco
 */
public class QuestionStruct {
    private int id;
    private String question, answer1, answer2;

    private int answer1points[] = new int[2];
    
    private int answer2points[] = new int[2];

    public QuestionStruct(int id, String question, String answer1, String answer2) {
        this.id = id;
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public int[] getAnswer1points() {
        return answer1points;
    }

    public void setAnswer1points(int popPoints, int earnPoints) {
        this.answer1points[0] = popPoints;
        this.answer1points[1] = earnPoints;
    }

    public int[] getAnswer2points() {
        return answer2points;
    }

    public void setAnswer2points(int popPoints, int earnPoints) {
        this.answer2points[0] = popPoints;
        this.answer2points[1] = earnPoints;
    }

    @Override
    public String toString() {
        return "QuestionStruct{" + "id=" + id + ", question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2 + ", answer1points=" + answer1points + ", answer2points=" + answer2points + '}';
    }
    
    
    
    
}
