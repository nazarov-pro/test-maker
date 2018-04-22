/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package az.shahin.pojo;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class BarCharPojo {
private String name;
private int value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public BarCharPojo() {
    }

    public BarCharPojo(String name, int value) {
        this.name = name;
        this.value = value;
    }

 
}
