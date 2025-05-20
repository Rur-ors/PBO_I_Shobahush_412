package Codelab4;

import Codelab4.*;

public class Main {
    public static void main(String[] args) {
        
        Buku buku1 = new Nonfiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");
        Buku buku2 = new Fiksi("Hainuwele: Sang Putri Kelapa", "Litius Hu", "Dongeng");

        
        buku1.displayInfo();
        buku2.displayInfo();

        System.out.println();

        
        Anggota anggota1 = new Anggota("Shobahush Sururi", "ID: 412");
        Anggota anggota2 = new Anggota("Hesti", "ID: 808");

        anggota1.tampilkanInfo();
        anggota2.tampilkanInfo();

        System.out.println();

        anggota1.pinjamBuku("Madilog");
        anggota2.pinjamBuku("Hainuwele: Sang Putri Kelapa", 7);

        System.out.println ("===========================");
        
        anggota1.kembalikanBuku("Madilog");
        anggota2.kembalikanBuku("Hainuwele: Sang Putri Kelapa");
    }
}