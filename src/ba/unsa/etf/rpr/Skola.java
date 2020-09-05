package ba.unsa.etf.rpr;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Skola {
    private ArrayList<Osoba> osobe = new ArrayList<>();


    public void dodajOsobu(Osoba o) {
        osobe.add(o);
    }

    @Override
    public String toString() {
        String s = "";
        for (Osoba os : osobe) {
            s +=os.toString()+"\n";
        }
        return s.trim();
    }

    public Set<Ucenik> ucenici() {
    Set<Ucenik> rez = new TreeSet<>();
        for (Osoba os : osobe) {
            if(os instanceof Ucenik){
                rez.add((Ucenik) os);
            }
        }
        return rez;
    }

    public List<Osoba> filtriraj(Function<Osoba, Boolean> f) {
        return osobe.stream().filter(x->f.apply(x)).collect(Collectors.toList());
    }

    public List<Osnovac> topOsnovac() {
        // filtriraj();
      return filtriraj(x-> x instanceof Osnovac && ((Osnovac)x).prosjek()>=4).stream().map(x -> (Osnovac) x).collect(Collectors.toList());
    }

    public List<Slavljenik> slavljenici() {
        return filtriraj(x-> ((x instanceof Ucitelj || x instanceof Srednjoskolac ))).stream().map(x -> (Slavljenik) x).collect(Collectors.toList());
    }
}
