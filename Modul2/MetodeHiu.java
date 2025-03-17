package Tugas.Modul2;

public class MetodeHiu {
    // Metode untuk aksi Hiu
    public void berenang() {
        System.out.println("Hiu berenang dengan menggerakkan ekor ke samping.");
    }

    public void berburu() {
        System.out.println("Hiu berburu mangsa seperti ikan kecil, mamalia laut, dan anjing laut dengan kecepatan dan ketajaman giginya.");
    }

    public void berkembangBiak() {
        System.out.println("Hiu berkembang biak dengan cara ovovivipar, yaitu bertelur dan melahirkan anak secara bersamaan.");
    }

    public static void main(String[] args) {
        MetodeHiu hiu = new MetodeHiu();
        hiu.berenang();
        hiu.berburu();
        hiu.berkembangBiak();
    }
}
