package org.poc.drools.model;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: cam
 * Date: 30/03/14
 * Time: 6:37 PM
 * To change this template use File | Settings | File Templates.
 */
public class DroolsModel implements Serializable{
    private String name;
    private int age;
    private double premium;
    private int basePremium;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPremium() {
        return premium;
    }

    public void setPremium(double premium) {
        this.premium = premium;
    }

    public int getBasePremium() {
        return basePremium;
    }

    public void setBasePremium(int basePremium) {
        this.basePremium = basePremium;
    }

    public static DroolsModel aMinorDroolsModel() {
        DroolsModel droolsModel = new DroolsModel();
        droolsModel.setAge(18);
        droolsModel.setBasePremium(100);
        return droolsModel;
    }
    public static DroolsModel aAdultDroolsModel() {
        DroolsModel droolsModel = new DroolsModel();
        droolsModel.setAge(32);
        droolsModel.setBasePremium(100);
        return droolsModel;
    }
}
