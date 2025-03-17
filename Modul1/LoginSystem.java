package Tugas.Modul1;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Pilih Jenis Login:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        
        int pilihan = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (pilihan) {
            case 1:
                
                System.out.print("Masukkan Username: ");
                String adminUsername = scanner.nextLine();
                System.out.print("Masukkan Password: ");
                String adminPassword = scanner.nextLine();
                
                if (adminUsername.equals("Rur412") && adminPassword.equals("Rurs412")) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;
            
            case 2:
                
                System.out.print("Masukkan Nama: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = scanner.nextLine();
                
                if (nama.equals("Mohamad Shobahush Sururi Sya'ban") && nim.equals("412")) {
                    System.out.println("Login Mahasiswa berhasil!");
                    System.out.println("Nama: " + nama);
                    System.out.println("NIM: " + nim);
                } else {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
                break;
            
            default:
                System.out.println("Pilihan tidak valid.");
        }
        
        scanner.close();
    }
}

