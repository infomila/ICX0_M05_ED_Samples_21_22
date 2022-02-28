/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Professor
 */
public abstract class Forma {



    private TipusForma tipusForma;
    private double mida;

    public Forma(TipusForma _tipusForma, double _mida) {
        this.tipusForma = _tipusForma;
        this.mida = _mida;
    }

    public double getMidaCostat() {
        return mida;
    }

    public TipusForma getTipusForma() {
        return tipusForma;
    }

    public abstract double getArea();
    public abstract String getNom();
    
    /*
    double getArea() {
        double area = 0;
        switch (tipusForma) {
            case Forma.QUADRAT:
                area = mida * mida;
                break;
            case Forma.CERCLE:
                area = Math.PI * mida * mida;
                break;
            case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                area = mida * mida / 2.0;
                break;
        }
        return area;
    }*/
/*
    String getNom() {
        switch (tipusForma) {
            case Forma.QUADRAT:
                return "Quadrat"; 
            case Forma.CERCLE:
                return "Cercle";
            case Forma.TRIANGLE_RECTANGLE_ISOSCELES:
                return "Triangle";
        }
        return null;
    }
*/
}
