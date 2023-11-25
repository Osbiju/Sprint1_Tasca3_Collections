package n1exercici1;

public class Month {
    private String nom;

    public Month(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String toString() {
        return this.getNom();
    }
}
