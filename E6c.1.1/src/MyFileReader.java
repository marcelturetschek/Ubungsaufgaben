import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * File und Ordner anzeigen, wenn es sich um einen Ordner handelt, dann auch die Unterordner und Dateien (rekursiv)
 * @author Marcel Turetschek
 * @version 06.06.2023
 */
public class MyFileReader {
    public static void main(String[] args) {
        File file = new File("/Users/marcel06/Library/CloudStorage/OneDrive-tgm-DieSchulederTechnik/Schule/SEW/Ubungsaufgaben/E6c.1.1");
        listFile(file, 0);
    }

    /**
     * listet alle Dateien und Ordner auf
     * @param file File oder Ordner
     * @param einzug anfänglicher Einzug
     */
    public static void listFile(File file, int einzug) {
        if (file.isFile()) {
            printFileDetails(file, einzug);
        } else if (file.isDirectory()) {
            printDirectory(file, einzug);
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    listFile(subFile, einzug + 1);
                }
            }
        }
    }

    /**
     * gibt die Details einer Datei aus
     * @param file das File
     * @param einzug der Einzug
     */
    public static void printFileDetails(File file, int einzug) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy - HH:mm:ss");
        String einzugText = createEinzug(einzug);
        System.out.println(einzugText + file.getName() + " - " + sdf.format(new Date(file.lastModified())) +
                " - " + file.length() + " Byte");
    }

    /**
     * gibt den Namen eines Ordners aus
     * @param directory der Ordner
     * @param einzug der Einzug
     */
    public static void printDirectory(File directory, int einzug) {
        String einzugText = createEinzug(einzug);
        System.out.println(einzugText + "+" + directory.getName());
    }

    /**
     * erstellt den Einzug
     * @param einzug
     * @return Einzug als String
     */
    private static String createEinzug(int einzug) {
        String einzugText = "";
        for (int i = 0; i < einzug; i++) {
            einzugText += "  ";
        }
        return einzugText;
    }
}
