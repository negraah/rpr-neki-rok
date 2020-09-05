package ba.unsa.etf.rpr;

import java.time.LocalDate;

public class Srednjoskolac extends Ucenik implements Slavljenik{
    private int[] ocjeneSrednja = new int[100];
    private int kapacitetSrednja = 100;
    private int dodanoSrednja=0;

    public Srednjoskolac(String imePrezime) {
        super(imePrezime);
        ocjeneSrednja = new int[100];
        kapacitetSrednja = 100;
        dodanoSrednja=0;
    }


    public void dodajOcjenuSrednja(int ocjena) throws IlegalnaOcjena {
        if(!(ocjena>=1 && ocjena<=5)) throw new IlegalnaOcjena("Ilegalna ocjena "+ ocjena);
        if(kapacitetSrednja==dodanoSrednja) throw new IlegalnaOcjena("Dosegnut maksimalan broj ocjena");
        ocjeneSrednja[dodanoSrednja] = ocjena;
        dodanoSrednja++;
    }

    public double prosjekSrednja() {
        if(dodanoSrednja==0) return 0;
        double suma = 0;
        for(int i=0; i<dodanoSrednja; i++){
            suma = suma + ocjeneSrednja[i];
        }
        double rezultat = suma/dodanoSrednja;
        return rezultat;

    }

    public double prosjek(){
        double suma = 0;
        int brojac = dodanoSrednja;
        int brojac2 = getDodano();
        if(brojac+brojac2==0) return 0;
        int[] niz = new int[brojac+brojac2];
        int[] niz2 = getOcjene();

        for(int i =0; i<brojac2; i++){
            niz[i] = niz2[i];
        }
        for(int i =brojac2; i<brojac+brojac2; i++){
            niz[i] = ocjeneSrednja[i-brojac2];
        }

        for(int i=0; i<(brojac+brojac2); i++){
            suma = suma+niz[i];
        }
        double rezultat = suma/(brojac+brojac2);
        return rezultat;
    }

    @Override
    public String toString() {
        return "Učenik srednje škole "+ getImePrezime()+" ("+getBrojKnjizice()+"), prosjek ocjena: "+ Math.round(prosjek()*10)/10.0;
    }
    public String rodjendan(LocalDate datum) {
        String rez ="";
        if(LocalDate.now().getDayOfMonth()==datum.getDayOfMonth() && LocalDate.now().getMonth().equals(datum.getMonth()))
            return "Sretan rodjendan!";

        return rez;
    }

}
