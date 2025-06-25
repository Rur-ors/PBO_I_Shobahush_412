package Codelab.REMIDI;

import java.util.Scanner;


public class MainSeminar {
    private static Scanner scanner = new Scanner(System.in);
    private static Seminar seminarEvent = new Seminar();
    
    public static void main(String[] args) {
        System.out.println("=== SISTEM PENCATATAN PESERTA SEMINAR ===");
        
        int pilihan;
        do {
            tampilkanMenu();
            System.out.print("Pilih menu (1-4): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (pilihan) {
                case 1:
                    tambahPesertaBaru();
                    break;
                case 2:
                    seminarEvent.tampilkanDaftar();
                    break;
                case 3:
                    cariPesertaByNIM();
                    break;
                case 4:
                    System.out.println("Terima kasih! Program selesai.");
                    System.out.println("Total peserta terdaftar: " + seminarEvent.getJumlahPeserta());
                    break;
                default:
                    System.out.println("Pilihan tidak valid! Silakan pilih 1-4.");
            }
            
            if (pilihan != 4) {
                System.out.println("\nTekan Enter untuk melanjutkan...");
                scanner.nextLine();
            }
            
        } while (pilihan != 4);
        
        scanner.close();
    }
    
   
    private static void tampilkanMenu() {
        System.out.println("\n=== MENU UTAMA ===");
        System.out.println("1. Tambah Peserta");
        System.out.println("2. Lihat Daftar Peserta");
        System.out.println("3. Cari Peserta (berdasarkan NIM)");
        System.out.println("4. Keluar");
        System.out.println("==================");
    }
    
   
    private static void tambahPesertaBaru() {
        System.out.println("\n=== TAMBAH PESERTA BARU ===");
        
    
        System.out.print("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine().trim();
        
       
        if (nama.isEmpty()) {
            System.out.println("Error: Nama tidak boleh kosong!");
            return;
        }
        
       
        String nim;
        do {
            System.out.print("Masukkan NIM mahasiswa: ");
            nim = scanner.nextLine().trim();
            
            if (nim.isEmpty()) {
                System.out.println("Error: NIM tidak boleh kosong! Silakan masukkan NIM lagi.");
            }
        } while (nim.isEmpty());
        
       
        System.out.print("Masukkan program studi: ");
        String prodi = scanner.nextLine().trim();
        
       
        if (prodi.isEmpty()) {
            System.out.println("Error: Program studi tidak boleh kosong!");
            return;
        }
        
        
        Mahasiswa mahasiswaBaru = new Mahasiswa(nama, nim, prodi);
        
        
        seminarEvent.tambahPeserta(mahasiswaBaru);
    }
    
   
    private static void cariPesertaByNIM() {
        System.out.println("\n=== CARI PESERTA ===");
        
       
        String nim;
        do {
            System.out.print("Masukkan NIM yang dicari: ");
            nim = scanner.nextLine().trim();
            
            if (nim.isEmpty()) {
                System.out.println("Error: NIM tidak boleh kosong! Silakan masukkan NIM lagi.");
            }
        } while (nim.isEmpty());
        
    
        seminarEvent.cariPeserta(nim);
    }
}