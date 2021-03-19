package Fotbal;

import java.util.*;

public class Campionat {
    private final int nrEchipe;
    private final int nrMeciuri;
    private List<Echipa> echipaList = new ArrayList<>();

    public Campionat(int nrEchipe, int nrMeciuri)
    {
        this.nrEchipe = nrEchipe;
        this.nrMeciuri = nrMeciuri;
    }

    public int getNrMeciuri() {
        return nrMeciuri;
    }

    public void adaugaEchipa(Echipa echipa){
        boolean exista = false;
        for(Echipa e : echipaList)
        {
            if (e.getNume().equals(echipa.getNume())) {
                e.setPuncte(echipa.getPuncte());
                e.setGoluriInscrise(echipa.getGoluriInscrise());
                e.setGoluriPrimite(echipa.getGoluriPrimite());
                exista = true;
                break;
            }
        }
        if(!exista)
            echipaList.add(new Echipa(echipa));
    }

    public void calculeazaScor(Echipa e1, int n1, Echipa e2, int n2)
    {
        e1.setGoluriInscrise(n1);
        e2.setGoluriInscrise(n2);
        e1.setGoluriPrimite(n2);
        e2.setGoluriPrimite(n1);
        if (n1 > n2)
            e1.setPuncte(3);
        else if (n2 > n1)
            e2.setPuncte(3);
            else {
                e1.setPuncte(1);
                e2.setPuncte(1);
            }
        adaugaEchipa(e1);
        adaugaEchipa(e2);
    }

    public void afiseazaScoruri()
    {
        for(Echipa e : echipaList)
            System.out.println(e.toString());
    }

    public void sorteazaEchipe()
    {
        Collections.sort(echipaList);
    }

    public boolean verif()
    {
        return echipaList.size() == nrEchipe;
    }
}
