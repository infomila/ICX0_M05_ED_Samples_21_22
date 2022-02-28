
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Professor
 */
public class ColeccioFormes {

    private Vector<Forma> formes;

    public ColeccioFormes() {
        formes = new Vector<Forma>();
    }

    public void addForma(Forma f) {
        formes.add(f);
    }

    public static void main(String args[]) {
        /*  ColeccioFormes c = new ColeccioFormes();
        c.addForma(new Forma(Forma.TRIANGLE_RECTANGLE_ISOSCELES, 2));
        c.addForma(new Forma(Forma.CERCLE, 2));
        c.addForma(new Forma(Forma.CERCLE, 3));
        c.addForma(new Forma(Forma.QUADRAT, 3));
        c.addForma(new Forma(Forma.TRIANGLE_RECTANGLE_ISOSCELES, 4));
        c.addForma(new Forma(Forma.QUADRAT, 3));
        c.addForma(new Forma(Forma.QUADRAT, 1));

        System.out.println(c.informeFormes());*/
    }

    public String informeFormes() {
        //int quadrats = 0, cercles = 0, triangles = 0, 
        int total = 0;
        //double areaQuadrats = 0, areaCercles = 0, areaTriangles = 0;
        double areaAcumulada = 0, midaCostat;
        //double costatAcumulatQuadrats=0, costatAcumulatCercles=0, costatAcumulatTriangles=0;

        int numFig = 1;
        String informe = "";
        NumberFormat nf = DecimalFormat.getNumberInstance(new Locale("ca", "es"));
        nf.setMaximumFractionDigits(2);
        informe += "========================\n";
        int numFiguresPerTipus[] = new int[TipusForma.values().length];
        double areaFiguresPerTipus[] = new double[TipusForma.values().length];
        double costatAcumulatPerTipus[] = new double[TipusForma.values().length];
        for (Forma f : formes) {

            TipusForma tipus = f.getTipusForma();
            total++;
            numFig++;
            informe += "- Figura <" + numFig + ">: ";
            informe += f.getNom();
            informe += "\t costat - " + f.getMidaCostat() + " - area " + nf.format(f.getArea()) + "\n";
            areaAcumulada += f.getArea();
            //    Q C T
            //   _______
            //   |0|0|0|
            midaCostat = f.getMidaCostat();
            double area = f.getArea();
            numFiguresPerTipus[tipus.ordinal()]++;
            areaFiguresPerTipus[tipus.ordinal()] += area;
            costatAcumulatPerTipus[tipus.ordinal()] += midaCostat;

        } // end foreach forma
        // ---------------------- totalitzacions --------------------------
        informe += "========================\n";
        informe += "Total figures:" + total + ", area total:" + nf.format(areaAcumulada) + "\n";
        informe += "========================\n";        
        for (int n = 0; n < TipusForma.values().length; n++) {
            TipusForma tip = TipusForma.values()[n];            
            informe += "Total "+tip.getPlural()+":" + numFiguresPerTipus[n] + ", area final:" + nf.format(areaFiguresPerTipus[n]) + ", costat mig:" + nf.format(costatAcumulatPerTipus[n] / (float) numFiguresPerTipus[n]) + "\n";                       
            informe += "========================\n";
        }//end for       
        return informe;
    }
}
