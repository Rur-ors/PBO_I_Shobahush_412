package Tugas.Modul1;

import java.util.Scanner;

public class TugasModul1 {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

            System.out.println("Pilihan menu");
            System.out.println("1. Admin ");
            System.out.println("2. Mahasiswa" );
            System.out.print("Masukkan Pilihan :");
        

            String AdminPassword;
            String AdminUsername;
            String Nama;
            String NIM;
            int Pilihan = scanner.nextInt();
            scanner.nextLine(); 
            switch (Pilihan) {

                case 1:

                System.out.print("Masukkan Username : ");
                AdminUsername = scanner.nextLine();
                System.out.print("Masukkan Password : ");
                AdminPassword = scanner.nextLine();
                
                if (AdminUsername.equals("Rur412") && AdminPassword.equals("Rurs412")) {
                    System.out.println("Login Admin berhasil!");
                } else {
                    System.out.println("Login gagal! Username atau password salah.");
                }
                break;

            case 2: 

                System.out.print("Masukkan Nama : ");
                Nama = scanner.nextLine();
                System.out.print("Masukkan NIM : ");
            
                NIM = scanner.nextLine();
                

                if (Nama.equals("Mohamad Shobahush Sururi Sya'ban") && NIM.equals("412")) {
                    System.out.println("--------Selamat Datang-------");
                    System.out.println("Nama: " + Nama);
                    System.out.println("NIM: " + NIM);
                } else {
                    System.out.println("Login Gagal, Nama atau NIM salah");
                }
                break;
            
                default:
                System.out.println("Pilihan tidak valid.");
            }
            scanner.close(); 
        }    
    }  

