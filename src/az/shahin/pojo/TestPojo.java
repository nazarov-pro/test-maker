/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.shahin.pojo;

import java.util.List;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class TestPojo {

    private int mode;
    private int answer;
    private List<String> answers;
    private int testId;
    private int myselected;

    public int getTestId() {
        return testId;
    }

    public void setTestId(int testId) {
        this.testId = testId;
    }

    public int getMyselected() {
        return myselected;
    }

    public void setMyselected(int myselected) {
        this.myselected = myselected;
    }

    public TestPojo() {
    }

    public TestPojo(int mode, int answer, List<String> answers) {
        this.mode = mode;
        this.answer = answer;
        this.answers = answers;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

}
