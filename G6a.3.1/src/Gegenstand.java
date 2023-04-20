/**
 * Enum, mit Gegenständen und Langbezeichnung als Konstanten
 *
 * @author Marcel Turetschek
 * @version 30.03.23
 */
public enum Gegenstand {
    AM("Mathematik"),
    E1("Englisch"),
    D("Deutsch"),
    SYT("Systemtechnik"),
    MEDT("Medientechnik"),
    SEW("Softwareentwicklung");

    private String langbezeichnung;

    private Gegenstand(String langbezeichnung) {
        this.langbezeichnung = langbezeichnung;
    }

    public String getLangbezeichnung() {
        return this.langbezeichnung;
    }
}
