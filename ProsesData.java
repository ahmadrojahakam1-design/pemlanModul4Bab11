package pemlanModul4Bab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class UrutTinggi implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) {
        return a.tinggiBadan - b.tinggiBadan;
    }
}

class UrutBerat implements Comparator<Pemain> {
    public int compare(Pemain a, Pemain b) {
        return a.beratBadan - b.beratBadan;
    }
}

public class ProsesData {

    public static void tampilkanMaxMin(ArrayList<Pemain> tim, String namaTim) {
        Pemain maxTinggi = Collections.max(tim, new UrutTinggi());
        Pemain minTinggi = Collections.min(tim, new UrutTinggi());
        Pemain maxBerat = Collections.max(tim, new UrutBerat());
        Pemain minBerat = Collections.min(tim, new UrutBerat());

        System.out.println("[" + namaTim + "]");
        System.out.println("Tinggi Maksimum: " + maxTinggi.tinggiBadan + " cm (No " + maxTinggi.id + ")");
        System.out.println("Tinggi Minimum : " + minTinggi.tinggiBadan + " cm (No " + minTinggi.id + ")");
        System.out.println("Berat Maksimum : " + maxBerat.beratBadan + " kg (No " + maxBerat.id + ")");
        System.out.println("Berat Minimum  : " + minBerat.beratBadan + " kg (No " + minBerat.id + ")");
    }

    public static void cariTinggiBinary(ArrayList<Pemain> tim, int targetTinggi) {
        int count = 0;
        Pemain dummy = new Pemain("", 0, targetTinggi, 0);
        int index = Collections.binarySearch(tim, dummy, new UrutTinggi());

        if (index >= 0) {
            count++;
            int kiri = index - 1;
            while (kiri >= 0 && tim.get(kiri).tinggiBadan == targetTinggi) { count++; kiri--; }
            int kanan = index + 1;
            while (kanan < tim.size() && tim.get(kanan).tinggiBadan == targetTinggi) { count++; kanan++; }
        }
        System.out.println("Jumlah pemain dengan tinggi " + targetTinggi + " cm: " + count);
    }

    public static void cariBeratBinary(ArrayList<Pemain> tim, int targetBerat) {
        int count = 0;
        Pemain dummy = new Pemain("", 0, 0, targetBerat);
        int index = Collections.binarySearch(tim, dummy, new UrutBerat());

        if (index >= 0) {
            count++;
            int kiri = index - 1;
            while (kiri >= 0 && tim.get(kiri).beratBadan == targetBerat) { count++; kiri--; }
            int kanan = index + 1;
            while (kanan < tim.size() && tim.get(kanan).beratBadan == targetBerat) { count++; kanan++; }
        }
        System.out.println("Jumlah pemain dengan berat " + targetBerat + " kg: " + count);
    }

    public static void cekKesamaanTim(ArrayList<Pemain> timA, ArrayList<Pemain> timB) {
        Collections.sort(timB, new UrutTinggi());
        for (int i = 0; i < timA.size(); i++) {
            Pemain pA = timA.get(i);
            int idx = Collections.binarySearch(timB, new Pemain("", 0, pA.tinggiBadan, 0), new UrutTinggi());
            if (idx >= 0) {
                System.out.println("Tinggi sama: Tim A No " + pA.id + " & Tim B No " + timB.get(idx).id + " (" + pA.tinggiBadan + " cm)");
                break;
            }
        }

        Collections.sort(timB, new UrutBerat());
        for (int i = 0; i < timA.size(); i++) {
            Pemain pA = timA.get(i);
            int idx = Collections.binarySearch(timB, new Pemain("", 0, 0, pA.beratBadan), new UrutBerat());
            if (idx >= 0) {
                System.out.println("Berat sama: Tim A No " + pA.id + " & Tim B No " + timB.get(idx).id + " (" + pA.beratBadan + " kg)");
                break;
            }
        }
    }
}