package Codelab.Modul2;

public class Codelab1Modul2 {
    String Nama;
    String Jenis;
    String Suara;

    
    public Codelab1Modul2(String nama, String jenis, String suara) {
        this.Nama = nama;
        this.Jenis = jenis;
        this.Suara = suara;
    }

    public void TampilkanInfo() {
        System.out.println("Nama: " + Nama);
        System.out.println("Jenis: " + Jenis);
        System.out.println("Suara: " + Suara);
        System.out.println();
    }

    public static void main(String[] args) {
        Codelab1Modul2 hewan1 = new Codelab1Modul2("Kucing", "Mamalia", "Miauwwwww");
        Codelab1Modul2 hewan2 = new Codelab1Modul2("Anjing", "Mamalia", "Woof-Woof!");

        hewan1.TampilkanInfo();
        hewan2.TampilkanInfo();
    }
}