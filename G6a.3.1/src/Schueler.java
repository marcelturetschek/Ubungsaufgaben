import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Lorem Ipsum :)
 *
 * @author Marcel Turetschek
 * @version 30.03.23
 */
public class Schueler implements Comparable<Schueler>, Serializable {
    private int katalognummer;
    private String vorname;
    private String nachname;
    private Gruppe gruppe;
    private Map<Gegenstand, Note> notenliste = new HashMap<>();

    public Schueler() {
        this(0, "Max", "Mustermann", Gruppe.Volksschule);
    }

    public Schueler(int katalognummer, String vorname, String nachname, Gruppe gruppe) {
        setKatalognummer(katalognummer);
        setVorname(vorname);
        setNachname(nachname);
        setGruppe(gruppe);
    }

    public int getKatalognummer() {
        return katalognummer;
    }

    public void setKatalognummer(int katalognummer) {
        this.katalognummer = katalognummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Gruppe getGruppe() {
        return gruppe;
    }

    public void setGruppe(Gruppe gruppe) {
        this.gruppe = gruppe;
    }

    public String notenListe() {
        String erg = "";
        for (Gegenstand g : notenliste.keySet()) {
            erg += g + ": (" + g.getLangbezeichnung() + "): " + notenliste.get(g) + ", ";
        }
        return erg;
    }

    public Note note(Gegenstand g) {
        return this.notenliste.get(g);
    }

    public void noteHinzu(Gegenstand g, Note note) {
        this.notenliste.put(g, note);
    }

    /**
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     * @apiNote It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     */
    @Override
    public int compareTo(Schueler o) {
        if (this.katalognummer == o.katalognummer) {
            return 0;
        }
        return (this.katalognummer > o.katalognummer) ? 1 : -1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Schueler schueler = (Schueler) o;
        return katalognummer == schueler.katalognummer && vorname.equals(schueler.vorname) && nachname.equals(schueler.nachname) && gruppe == schueler.gruppe && Objects.equals(notenliste, schueler.notenliste);
    }

    @Override
    public int hashCode() {
        return Objects.hash(katalognummer, vorname, nachname, gruppe, notenliste);
    }
}
