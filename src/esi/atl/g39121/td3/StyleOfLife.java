package esi.atl.g39121.td3;

/**
 * Created by audric on 26.02.16.
 */
public enum StyleOfLife {
    SEDENTAIRE(1.2),
    PEUACTIF(1.375),
    ACTIF(1.55),
    FORTACTIF(1.725),
    EXTREM(1.9);

    private double val;

    StyleOfLife(double val) {
        this.val = val;
    }

    double getVal() {
        return this.val;
    }
}
