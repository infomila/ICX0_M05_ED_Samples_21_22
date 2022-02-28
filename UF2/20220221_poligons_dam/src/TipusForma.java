
/**
 *
 * @author Usuari
 */
public enum TipusForma {
    QUADRAT("Quadrats"), CERCLE("Cercles"), TRIANGLE_RECTANGLE_ISOSCELES("triangles");

    String plural;

    public String getPlural() {
        return plural;
    }

    TipusForma(String plural) {
        this.plural = plural;
    }
}
