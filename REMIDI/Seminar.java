package Codelab.REMIDI;

import java.util.ArrayList;


public class Seminar {
    private ArrayList<Mahasiswa> daftarPeserta;
    
   
    public Seminar() {
        this.daftarPeserta = new ArrayList<>();
    }
    
   
    public void tambahPeserta(Mahasiswa mhs) {
        // Cek apakah NIM sudah ada
        for (Mahasiswa peserta : daftarPeserta) {
            if (peserta.getNim().equals(mhs.getNim())) {
                System.out.println("Error: Mahasiswa dengan NIM " + mhs.getNim() + " sudah terdaftar!");
                return;
            }
        }
        
        daftarPeserta.add(mhs);
        System.out.println("Mahasiswa " + mhs.getNama() + " berhasil ditambahkan ke daftar peserta seminar!");
    }
    
  
    public void tampilkanDaftar() {
        if (daftarPeserta.isEmpty()) {
            System.out.println("Belum ada peserta yang terdaftar.");
            return;
        }
        
        System.out.println("\n=== DAFTAR PESERTA SEMINAR ===");
        System.out.println("Total peserta: " + daftarPeserta.size());
        System.out.println("----------------------------------------");
        
        for (int i = 0; i < daftarPeserta.size(); i++) {
            System.out.println("Peserta ke-" + (i + 1) + ":");
            daftarPeserta.get(i).tampilkanInfo();
            System.out.println("----------------------------------------");
        }
    }
    
    
    public void cariPeserta(String nim) {
        for (Mahasiswa peserta : daftarPeserta) {
            if (peserta.getNim().equals(nim)) {
                System.out.println("\n=== PESERTA DITEMUKAN ===");
                peserta.tampilkanInfo();
                return;
            }
        }
        System.out.println("Peserta dengan NIM " + nim + " tidak ditemukan.");
    }
    
   
    public int getJumlahPeserta() {
        return daftarPeserta.size();
    }
}