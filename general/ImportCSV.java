package general;

import java.text.ParseException;

public class ImportCSV {

    private String filePath;
    private String data[][];
    private String head[];
    private int nb_lignes;
    private int nb_colonnes;

    public ImportCSV(String filePath) {
        this.filePath = filePath;

        In in1 = new In(filePath);

        String lignes[];

        lignes = in1.readAllLines();

        nb_lignes = (lignes.length - 1);

        nb_colonnes = lignes[0].split(";").length;

        head = new String[nb_colonnes];

        head = lignes[0].split(";");

        if (nb_lignes > 0) {
            data = new String[nb_lignes][nb_colonnes];

            for (int i = 1; i < nb_lignes; i++) {
                String ligne[];
                ligne = lignes[i].split(";");
                int l = ligne.length;
                for (int j = 0; j < l; j++) {
                    data[i - 1][j] = ligne[j];
                }
            }
        }
    }

    public String getFilePath() {
        return filePath;
    }

    public String[][] getData() {
        return data;
    }

    public String[] getHead() {
        return head;
    }

    public int getNb_lignes() {
        return nb_lignes;
    }

    public int getNb_colonnes() {
        return nb_colonnes;
    }

    public static void main(String[] args) {

        String dir = new String(
                "D:/shared/a.teffal/Mes documents/TEFFAL/Fonds Mutuel/Projet FM/Modèles Calcul Engagement et Analyse Groupe Ouvert/Application Java/Files");

        String r01[][];
        ImportCSV importcsv = new ImportCSV(dir + "/" + "data - Copie.csv");

        int n = importcsv.getNb_lignes();
        int p = importcsv.getNb_colonnes();

        System.out.println("nombre de colonnes : " + p);
        System.out.println("nombre de lignes : " + n);

        r01 = importcsv.getData();

        for (int j = 0; j < p; j++) {
            System.out.print(importcsv.getHead()[j] + "   ");
        }

        System.out.print("\n");

        for (int i = 0; i < 10; i++) {

            // System.out.print("Ligne numero : "+i+"\n");
            for (int j = 0; j < p; j++) {
                System.out.print(r01[i][j] + "   ");
            }
            System.out.print("\n");

        }

    }

}
