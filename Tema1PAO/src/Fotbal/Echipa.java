package Fotbal;

public class Echipa implements Comparable<Echipa>{
    private String nume;
    private int puncte = 0;
    private int goluriInscrise = 0;
    private int goluriPrimite = 0;

    public Echipa(String nume)
    {
        try
        {
            for(int i = 0; i < nume.length(); i++)
            {
                char c = nume.charAt(i);
                if(!Character.isLetter(c)) throw new Exception("Numele echipei trebuie sa aiba doar litere!");
            }
            this.nume = nume;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public Echipa(Echipa echipa)
    {
        this.nume = echipa.nume;
        this.puncte = echipa.puncte;
        this.goluriInscrise = echipa.goluriInscrise;
        this.goluriPrimite = echipa.goluriPrimite;
    }

    @Override
    public int compareTo(Echipa compareTeam) {
        int compare=compareTeam.getPuncte();
        /* For Ascending order*/
        return compare - this.puncte;
    }

    public String getNume() {
        return nume;
    }

    public int getPuncte() {
        return puncte;
    }

    public void setPuncte(int puncte) {
        this.puncte += puncte;
    }

    public int getGoluriInscrise() {
        return goluriInscrise;
    }

    public void setGoluriInscrise(int goluriInscrise) {
        this.goluriInscrise += goluriInscrise;
    }

    public int getGoluriPrimite() {
        return goluriPrimite;
    }

    public void setGoluriPrimite(int goluriPrimite) {
        this.goluriPrimite += goluriPrimite;
    }

    @Override
    public String toString() {
        return nume +
                ", puncte = " + puncte +
                ", goluri inscrise = " + goluriInscrise +
                ", goluri primite = " + goluriPrimite;
    }
}
