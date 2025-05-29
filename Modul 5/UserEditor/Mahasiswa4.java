package Modul4.UserEditor;

import Modul4.Actions4.*;
import Modul4.MainModul4.LoginSystem4;

import java.util.ArrayList;
import java.util.Scanner;

public class Mahasiswa4 extends User4 implements MahasiswaActions {

    public Mahasiswa4(String username, String password) {
        super(username, password);
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return this.username.equals(inputUsername) && this.password.equals(inputPassword);
    }

    @Override
    public void displayAppMenu() {
        try (Scanner scanner = new Scanner(System.in)) {
            int choice;
            do {
                System.out.println("\n=== Menu Mahasiswa ===");
                System.out.println("1. Laporkan Barang Temuan/Hilang");
                System.out.println("2. Lihat Daftar Laporan");
                System.out.println("0. Logout");
                System.out.print("Pilih menu: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> reportItem();
                    case 2 -> viewReportedItems();
                    case 0 -> System.out.println("Logout...");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } while (choice != 0);
        }
    }

    @Override
    public void reportItem() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Nama Barang: ");
            String nama = scanner.nextLine();
            System.out.print("Deskripsi Barang: ");
            String deskripsi = scanner.nextLine();
            System.out.print("Lokasi Terakhir/Ditemukan: ");
            String lokasi = scanner.nextLine();

            Item4 item = new Item4(nama, deskripsi, lokasi, "Reported");
            LoginSystem4.reportedItems.add(item);
        }
        System.out.println(">> Barang berhasil dilaporkan.");
    }

    @Override
    public void viewReportedItems() {
        ArrayList<Item4> items = LoginSystem4.reportedItems;

        boolean ada = false;
        for (Item4 item : items) {
            if (item.getStatus().equals("Reported")) {
                ada = true;
                System.out.println("Nama: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("Status: " + item.getStatus());
                System.out.println("-------------------------");
            }
        }

        if (!ada) {
            System.out.println(">> Belum ada laporan barang.");
        }
    }
}
