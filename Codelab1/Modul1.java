package Codelab;

import java.util.Scanner;
import java.time.LocalDateTime;
public class Modul1{

    public static void main(String[] args) {
        String firstnameString;
        int tahun;
        String JenisKelamin;
        Scanner objInput = new Scanner (System.in);

        System.out.print("Masukkan Nama Anda:");
        firstnameString = objInput.nextLine();

        System.out.print("Masukkan Tahun Lahir Anda: ");
        tahun = objInput.nextInt();


        System.out.println("Apakah Anda (P/L): ");
        JenisKelamin = objInput.nextLine();

        switch (JenisKelamin) {
            case "L":
            System.out.println("Selamat Anda Laki-Laki");
                break;
            case "P":
            System.out.println("Selamat Anda Perempuan");
            default:
            System.out.println("Jenis Kelamin Anda Tidak diKetahui");
                break;
        }
        LocalDateTime dateTime= LocalDateTime.now();
        int umur = dateTime.getYear() - tahun;
        
        System.out.println("Nama :" + firstnameString);
        System.out.println("Umur :" + umur);
        System.out.println("Jenis Kelamin :" + JenisKelamin);
        

    }
}
