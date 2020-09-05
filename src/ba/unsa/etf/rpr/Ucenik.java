package ba.unsa.etf.rpr;

import java.time.LocalDate;

import static java.lang.Math.round;

public class Ucenik extends Osoba implements Comparable {
    private String brojKnjizice ="";
    private int[] ocjene = new int[100];
    private int kapacitet = 100;
    private int dodano=0;

    public int[] getOcjene() {
        return ocjene;
    }

    public int getKapacitet() {
        return kapacitet;
    }

    public int getDodano() {
        return dodano;
    }

    public Ucenik(String imePrezime) {
        super(imePrezime);
    }

    public void setBrojKnjizice(String s) {
        this.brojKnjizice = s;
    }

    public String getBrojKnjizice() {
        return brojKnjizice;
    }

    public void dodajOcjenu(int ocjena) throws IlegalnaOcjena {
        if(!(ocjena>=1 && ocjena<=5)) throw new IlegalnaOcjena("Ilegalna ocjena "+ ocjena);
        if(kapacitet==dodano) throw new IllegalArgumentException("Dosegnut maksimalan broj ocjena");

        ocjene[dodano] =  ocjena;
        dodano++;
    }


    public double prosjek() {
        if(dodano==0) return 0;
        double suma = 0;
        for(int i =0; i<dodano; i++){
            suma = suma + ocjene[i];
        }
        double rezultat = suma/dodano;
        return rezultat;
    }


    @Override
    public int compareTo(Object o) {
        if(this.prosjek()>((Ucenik)o).prosjek()) return -1;
        else return 1;
    }


}
