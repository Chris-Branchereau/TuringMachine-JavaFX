package esi.atl.bmr.model;

public enum LifeStyle {
    SEDENTAIRE("Sédentaire", 1.2), PEU_ACTIF("Peu actif", 1.375),
    ACTIF("Actif", 1.55), FORT_ACTIF("Fort actif", 1.725),
    EXTREM("Extrêmement actif", 1.9);
    private String name;
    private double factor;

    LifeStyle(String name, double factor) {
        this.name = name;
        this.factor = factor;
    }

    /**
     * get the factor of the lifeStyle
     *
     * @return factor of the lifeStyle
     */
    public double getFactor() {
        return factor;
    }

    /**
     * toString method
     *
     * @return the name
     */
    @Override
    public String toString() {
        return name;
    }
}
