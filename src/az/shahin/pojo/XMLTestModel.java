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
public class XMLTestModel {

    private int id;
    private List<Integer> tests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getTests() {
        return tests;
    }

    public void setTests(List<Integer> tests) {
        this.tests = tests;
    }

    public XMLTestModel(int id, List<Integer> tests) {
        this.id = id;
        this.tests = tests;
    }

    @Override
    public String toString() {
        return "TestsPojo{" + "id=" + id + ", tests=" + tests.get(0) + '}'+tests.get(1);
    }

    public XMLTestModel() {
        
    }
}
