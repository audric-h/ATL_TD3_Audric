package esi.atl.g39121.td3;

/**
 * Created by audric on 26.02.16.
 */
public class BmrCalcul {
    public static double bmr(int poids, int taille, int age, boolean sexe) {
        double r;
        if(sexe) {
            r = (9.6 * poids);
            r += (1.8 * taille);
            r -= (4.7 * age);
            r += 655;
        } else {
            r = 13.7 * poids;
            r += 5 * taille;
            r -= 6.8 * age;
            r += 66;
        }
        return r;
    }
}
