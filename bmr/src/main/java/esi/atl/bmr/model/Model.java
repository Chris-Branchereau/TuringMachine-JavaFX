package esi.atl.bmr.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private Person person = new Person();
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public void addObserver(PropertyChangeListener observer) {
        pcs.addPropertyChangeListener(observer);
    }
    public void error(){
        pcs.firePropertyChange("error", false, true);
    }

    public void calculBMR(int size, int weight, int age, boolean ismen, LifeStyle lifeStyle) {
        if(getBMR(size,weight,age,ismen)<=0) {
            return;
        }
        double oldBMR = getBMR();
        double oldCalories = getCalories();

        pcs.firePropertyChange("size", person.getSize(), size);
        person.setSize(size);

        pcs.firePropertyChange("weight", person.getWeight(), weight);
        person.setWeight(weight);

        pcs.firePropertyChange("age", person.getAge(), age);
        person.setAge(age);

        pcs.firePropertyChange("ismen", person.isMen(), ismen);
        person.setMen(ismen);

        pcs.firePropertyChange("lifestyle", person.getLifeStyle(), lifeStyle);
        person.setLifeStyle(lifeStyle);

        pcs.firePropertyChange("BMR", oldBMR, getBMR());
        pcs.firePropertyChange("Calories", oldCalories, getCalories());
    }

    public double getBMR() {
        return getBMR(person.getSize(), person.getWeight(), person.getAge(), person.isMen());
    }

    public double getBMR(int size, int weight, int age, boolean ismen) {
        return ismen ? (13.7 * weight + 5 * size - 6.8 * age + 66)
                : (9.6 * weight + 1.8 * size - 4.7 * age + 665);
    }

    public double getCalories() {
        return person.getLifeStyle().getNeed() * getBMR();
    }

}
