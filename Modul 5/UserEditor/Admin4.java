package Modul4.UserEditor;

import Modul4.Actions4.*;
import Modul4.MainModul4.LoginSystem4;

import java.util.ArrayList;
import java.util.Scanner;

public class Admin4 extends User4 implements AdminActions4 {

    public Admin4(String username, String password) {
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
                System.out.println("\n=== Menu Admin ===");
                System.out.println("1. Kelola Laporan Barang");
                System.out.println("2. Kelola Data Mahasiswa");
                System.out.println("0. Logout");
                System.out.print("Pilih menu: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> manageItems();
                    case 2 -> manageUsers();
                    case 0 -> System.out.println("Logout...");
                    default -> System.out.println("Pilihan tidak valid!");
                }
            } while (choice != 0);
        }
    }

    @Override
    public void manageItems() {
        try (Scanner scanner = new Scanner(System.in)) {
            ArrayList<Item4> items = LoginSystem4.reportedItems;

            System.out.println("\n--- Daftar Laporan ---");
            if (items.isEmpty()) {
                System.out.println("Belum ada laporan barang.");
                return;
            }

            for (int i = 0; i < items.size(); i++) {
                Item4 item = items.get(i);
                System.out.println(i + ". " + item.getItemName() + " (" + item.getStatus() + ")");
            }

            System.out.print("\nMasukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");
            try {
                int index = scanner.nextInt();
                scanner.nextLine(); // buang newline
                Item4 selected = items.get(index);
                if (selected.getStatus().equals("Claimed")) {
                    System.out.println("Barang sudah ditandai sebagai Claimed.");
                } else {
                    selected.setStatus("Claimed");
                    System.out.println("Status barang berhasil diubah menjadi Claimed.");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Indeks tidak valid!");
            } catch (Exception e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }
    }

    @Override
    public void manageUsers() {
        try (Scanner scanner = new Scanner(System.in)) {
            int pilihan;

            do {
                System.out.println("\n--- Kelola Mahasiswa ---");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Hapus Mahasiswa");
                System.out.println("0. Kembali");
                System.out.print("Pilih opsi: ");
                try {
                    pilihan = scanner.nextInt();
                    scanner.nextLine(); // buang newline

                    switch (pilihan) {
                        case 1 -> {
                            System.out.print("Nama Mahasiswa: ");
                            String nama = scanner.nextLine();
                            System.out.print("Password: ");
                            String pass = scanner.nextLine();
                            Mahasiswa4 m = new Mahasiswa4(nama, pass);
                            LoginSystem4.userList.add(m);
                            System.out.println("Mahasiswa berhasil ditambahkan.");
                        }
                        case 2 -> {
                            System.out.print("Masukkan nama Mahasiswa yang ingin dihapus: ");
                            String nama = scanner.nextLine();
                            boolean removed = LoginSystem4.userList.removeIf(u ->
                                    u instanceof Mahasiswa4 && ((Mahasiswa4) u).username.equals(nama));
                            if (removed) {
                                System.out.println("Mahasiswa berhasil dihapus.");
                            } else {
                                System.out.println("Mahasiswa tidak ditemukan.");
                            }
                        }
                        case 0 -> System.out.println("Kembali ke menu utama.");
                        default -> System.out.println("Pilihan tidak valid.");
                    }
                } catch (Exception e) {
                    System.out.println("Input harus berupa angka!");
                    scanner.nextLine();
                    pilihan = -1;
                }
            } while (pilihan != 0);
        }
    }
}
