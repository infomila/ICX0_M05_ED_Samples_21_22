
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
     
}
