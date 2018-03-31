import java.util.List;

import static java.lang.Math.pow;

public class Wyrazenie {

    private double wyniczek;

    public Wyrazenie()
    {
        wyniczek = 0;
    }

    public double polynomialValue(double x, double ... coefficients) {
            this.wyniczek=0;
        for (int i=0;i<coefficients.length;i++ ) {

        wyniczek+=coefficients[i]*pow(x,i);

        }

       return getWyniczek();

    }

    public double getWyniczek() {
        return wyniczek;
    }




}
