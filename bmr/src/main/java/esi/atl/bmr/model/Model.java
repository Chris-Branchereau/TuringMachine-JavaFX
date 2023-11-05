package esi.atl.bmr.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Model {
    private Person person = new Person();
    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    /**
     * method to add Observer (OO DP)
     *
     * @param observer
     */
    public void addObserver(PropertyChangeListener observer) {
        pcs.addPropertyChangeListener(observer);
    }

    /**
     * change property "error" to true
     */
    public void error() {
        pcs.firePropertyChange("error", false, true);
    }

    /**
     * compute the bmr and change every attribut with new ones
     *
     * @param size      = new size
     * @param weight    = new weight
     * @param age       = new age
     * @param ismen     = new ismen
     * @param lifeStyle = new lifestyle
     */
    public void calculBMR(int size, int weight, int age, boolean ismen, LifeStyle lifeStyle) {
        if (getBMR(size, weight, age, ismen) <= 0) {
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

    /**
     * get the BMR using the next method
     *
     * @return the BMR
     */
    public double getBMR() {
        return getBMR(person.getSize(), person.getWeight(), person.getAge(), person.isMen());
    }

    /**
     * get the BMR using men formule : 13.7 * weight + 5 * size - 6.8 * age + 66
     * and women formule : 9.6 * weight + 1.8 * size - 4.7 * age + 665
     *
     * @param size   = user's size
     * @param weight = user's weight
     * @param age    = user's age
     * @param ismen  = user's sexe
     * @return the bmr
     */
    public double getBMR(int size, int weight, int age, boolean ismen) {
        return ismen ? (13.7 * weight + 5 * size - 6.8 * age + 66)
                : (9.6 * weight + 1.8 * size - 4.7 * age + 665);
    }

    /**
     * get user's calories needs  in terms of his lifeStyle
     *
     * @return user's calories needs
     */
    public double getCalories() {
        return person.getLifeStyle().getFactor() * getBMR();
    }

}
