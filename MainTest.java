package pemlanModul4Bab11;

import java.util.ArrayList;
import java.util.Collections;

public class MainTest {
    public static void main(String[] args) {
        int[][] dataTimA = {{168, 50}, {170, 60}, {165, 56}, {168, 55}, {172, 60}, {170, 70}, {169, 66}, {165, 56}, {171, 72}, {166, 56}};
        int[][] dataTimB = {{170, 66}, {167, 60}, {165, 59}, {166, 58}, {168, 58}, {175, 71}, {172, 68}, {171, 68}, {168, 65}, {169, 60}};

        ArrayList<Pemain> timA = new ArrayList<Pemain>();
        ArrayList<Pemain> timB = new ArrayList<Pemain>();

        for (int i = 0; i < 10; i++) {
            timA.add(new Pemain("Tim A", i + 1, dataTimA[i][0], dataTimA[i][1]));
            timB.add(new Pemain("Tim B", i + 1, dataTimB[i][0], dataTimB[i][1]));
        }

        ArrayList<Pemain> gabungan = new ArrayList<Pemain>();
        gabungan.addAll(timA);
        gabungan.addAll(timB);
        
        System.out.println("\n=== TINGGI BADAN ASCENDING ===");
        Collections.sort(gabungan, new UrutTinggi());
        for (int i = 0; i < gabungan.size(); i++) System.out.println(gabungan.get(i));
        System.out.println();
        
        System.out.println("=== TINGGI BADAN DESCENDING ===");
        Collections.sort(gabungan, Collections.reverseOrder(new UrutTinggi()));
        for (int i = 0; i < gabungan.size(); i++) System.out.println(gabungan.get(i));
        System.out.println();
        
        System.out.println("=== BERAT BADAN ASCENDING ===");
        Collections.sort(gabungan, new UrutBerat());
        for (int i = 0; i < gabungan.size(); i++) System.out.println(gabungan.get(i));
        System.out.println();
        
        System.out.println("==== BERAT BADAN DESCENDING ===");
        Collections.sort(gabungan, Collections.reverseOrder(new UrutBerat()));
        for (int i = 0; i < gabungan.size(); i++) System.out.println(gabungan.get(i));
        System.out.println();

        System.out.println("=== NILAI MAKSIMUM & MINIMUM ===");
        ProsesData.tampilkanMaxMin(timA, "Tim A");
        ProsesData.tampilkanMaxMin(timB, "Tim B");
        System.out.println();

        System.out.println("=== HASIL COPY TIM B KE TIM C ===");
        ArrayList<Pemain> timC = new ArrayList<Pemain>(timB);
        for (int i = 0; i < timC.size(); i++) System.out.println(timC.get(i));
        System.out.println();

        System.out.println("=== BINARY SEARCH TINGGI TIM B ===");
        Collections.sort(timB, new UrutTinggi());
        ProsesData.cariTinggiBinary(timB, 168);
        ProsesData.cariTinggiBinary(timB, 160);
        System.out.println();

        System.out.println("=== BINARY SEARCH BERAT TIM A ===");
        Collections.sort(timA, new UrutBerat());
        ProsesData.cariBeratBinary(timA, 56);
        ProsesData.cariBeratBinary(timA, 53);
        System.out.println();

        System.out.println("=== KESAMAAN DATA ANTAR TIM ===");
        ProsesData.cekKesamaanTim(timA, timB);
    }
}