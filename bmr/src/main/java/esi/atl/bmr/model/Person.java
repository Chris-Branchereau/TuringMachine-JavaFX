package esi.atl.bmr.model;

public class Person {
    private int size;
    private int weight;
    private int age;
    private boolean isMen;
    private LifeStyle lifeStyle = LifeStyle.SEDENTAIRE;

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public boolean isMen() {
        return isMen;
    }
    public void setMen(boolean isMen){
        this.isMen = isMen;
    }

    public LifeStyle getLifeStyle() {
        return lifeStyle;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setMan(boolean man) {
        isMen = man;
    }

    public void setLifeStyle(LifeStyle lifeStyle) {
        this.lifeStyle = lifeStyle;
    }
}
