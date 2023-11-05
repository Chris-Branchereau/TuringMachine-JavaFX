package esi.atl.bmr.model;

public enum LifeStyle {
    SEDENTAIRE("Sédentaire", 1.2), PEU_ACTIF("Peu actif",1.375),
    ACTIF("Actif",1.55), FORT_ACTIF("Fort actif",1.725),
    EXTREM("Extrêmement actif", 1.9);
    private String name;
    private double need;
    LifeStyle(String name, double need){
        this.name = name;
        this.need =need;
    }

    public double getNeed() {
        return need;
    }

    public String getName() {
        return name;
    }
}
