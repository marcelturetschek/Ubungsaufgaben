/**
 * Notenunum
 *
 * @author Marcel Turetschek
 * @version 30.03.23
 */
public enum Note {
    Note_1("Sehr Gut"),
    Note_2("Gut"),
    Note_3("Befriedigend"),
    Note_4("Genügend"),
    Note_5("Nicht Genügend");

    private String langbezeichnung;

    private Note(String langbezeichnung) {
        this.langbezeichnung = langbezeichnung;
    }

    public String getLangbezeichnung() {
        return langbezeichnung;
    }
}
