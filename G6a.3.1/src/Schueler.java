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
     * Note: this class has a natural ordering that is
     * inconsistent with equals." - es wird zuerst nach Gruppe sortiert,
     * wenn beide objekte in selber gruppe, wird nach katalognummer sortiert
     * @param o zu vergleichende Objekt
     * @return das Ergebnis des Vergleichs (siehe Note)
     */
    @Override
    public int compareTo(Schueler o) {
        if (this.gruppe.compareTo(o.gruppe) != 0) {
            return this.gruppe.compareTo(o.gruppe);
        }

        return Integer.compare(this.katalognummer, o.katalognummer);
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

    @Override
    public String toString() {
        return "Schueler{" +
                "katalognummer=" + katalognummer +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", gruppe=" + gruppe +
                ", notenliste=" + notenliste +
                '}';
    }
}
