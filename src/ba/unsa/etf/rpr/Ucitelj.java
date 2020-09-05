package ba.unsa.etf.rpr;

import java.time.LocalDate;

public class Ucitelj extends Nastavnik implements Slavljenik {
    public Ucitelj(String imePrezime) {
        super(imePrezime);
    }

    @Override
    public String toString() {
        return "Učitelj " + getImePrezime();
    }

    public String rodjendan(LocalDate datum) {
        String rez ="";
        if(LocalDate.now().getDayOfMonth()==datum.getDayOfMonth() && LocalDate.now().getMonth().equals(datum.getMonth())) return "Sretan rodjendan!";

        return rez;
    }
}
