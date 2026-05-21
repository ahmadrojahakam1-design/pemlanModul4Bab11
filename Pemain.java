package pemlanModul4Bab11;

public class Pemain {
    int id;
    String namaTim;
    int tinggiBadan;
    int beratBadan;

    public Pemain(String namaTim, int id, int tinggiBadan, int beratBadan) {
        this.namaTim = namaTim;
        this.id = id;
        this.tinggiBadan = tinggiBadan;
        this.beratBadan = beratBadan;
    }

    @Override
    public String toString() {
        return namaTim + " (No " + id + ") -> Tinggi: " + tinggiBadan + " cm, Berat: " + beratBadan + " kg";
    }
}