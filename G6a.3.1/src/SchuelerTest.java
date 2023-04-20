import com.sun.source.tree.Tree;
import com.sun.source.util.Trees;

import java.util.Set;
import java.util.TreeSet;

/**
 * Testen von Schueler
 *
 * @author Marcel Turetschek
 * @version 30.03.23
 */
public class SchuelerTest {
    public static void main(String[] args) {
        Schueler schueler1 = new Schueler(1, "Timur", "Visne", Gruppe.Volksschule);
        schueler1.noteHinzu(Gegenstand.AM, Note.Note_1);
        schueler1.noteHinzu(Gegenstand.D, Note.Note_3);
        schueler1.noteHinzu(Gegenstand.E1, Note.Note_2);
        schueler1.noteHinzu(Gegenstand.SEW, Note.Note_3);
        schueler1.noteHinzu(Gegenstand.SYT, Note.Note_1);
        schueler1.noteHinzu(Gegenstand.MEDT, Note.Note_2);

        Schueler schueler2 = new Schueler(10, "Julian", "Neuwirth", Gruppe.Volksschule);
        schueler2.noteHinzu(Gegenstand.AM, Note.Note_2);
        schueler2.noteHinzu(Gegenstand.D, Note.Note_1);
        schueler2.noteHinzu(Gegenstand.E1, Note.Note_4);
        schueler2.noteHinzu(Gegenstand.SEW, Note.Note_4);
        schueler2.noteHinzu(Gegenstand.SYT, Note.Note_4);
        schueler2.noteHinzu(Gegenstand.MEDT, Note.Note_3);

        Schueler schueler3 = new Schueler(20, "Mario", "Paia", Gruppe.Oberstufe);
        schueler3.noteHinzu(Gegenstand.AM, Note.Note_2);
        schueler3.noteHinzu(Gegenstand.D, Note.Note_1);
        schueler3.noteHinzu(Gegenstand.E1, Note.Note_4);
        schueler3.noteHinzu(Gegenstand.SEW, Note.Note_4);
        schueler3.noteHinzu(Gegenstand.SYT, Note.Note_4);
        schueler3.noteHinzu(Gegenstand.MEDT, Note.Note_3);

        // Duplikatserkennung und Sortierung
        Set<Schueler> schueler = new TreeSet<>();
        schueler.add(schueler3);
        schueler.add(schueler2);
        schueler.add(schueler1);
        schueler.add(schueler1);


        for (Schueler s : schueler) {
            System.out.println(s.toString());
        }


    }
}
