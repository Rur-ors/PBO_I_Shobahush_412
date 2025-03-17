package Tugas.Modul1;

import java.util.Scanner;

public class TugasPBOclass1 {
    public static void main (String[]args) {
        Scanner scanner = new Scanner (System.in);

        int Pilihan = scanner.nextInt();
        String Admin = scanner.nextLine();
        String Password = scanner.nextLine();

        System.out.println("Pilih Menu :");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");

            switch (Pilihan) {
                case 1 :

                System.out.print("Masukkan Username :");
                System.out.println("Masukkan Password Anda");
                    if (Admin.equals("Shobahush412") && Password.equals("Rurs2909")){
                    System.out.println("Selamat Anda Berhasil Login");
                    } else {
                        System.out.println("Maaf Anda Gagal Login");
                    }
                    break;
            
            }
    }
    
}
