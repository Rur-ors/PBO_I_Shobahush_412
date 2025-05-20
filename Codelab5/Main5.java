package Codelab5;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {
        ArrayList<barang5> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Tambahkan data awal
        daftarBarang.add(new barang5("Pensil", 50));
        daftarBarang.add(new barang5("Buku Tulis", 30));

        boolean running = true;

        while (running) {
            System.out.println("\n=== MENU ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine(); // bersihkan buffer

                switch (pilihan) {
                    case 1:
                        System.out.print("Nama Barang: ");
                        String nama = scanner.nextLine();

                        System.out.print("Stok Awal: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();

                        daftarBarang.add(new barang5(nama, stok));
                        System.out.println("Barang berhasil ditambahkan!");
                        break;

                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                        } else {
                            System.out.println("\n--- Daftar Barang ---");
                            for (barang5 b : daftarBarang) {
                                System.out.println("- " + b.getNama() + " | Stok: " + b.getStok());
                            }
                        }
                        break;

                        case 3:
                         if (daftarBarang.isEmpty()) {
                             System.out.println("Tidak ada barang untuk dikurangi.");
                         break;
                        }

                            System.out.println("\n--- Daftar Barang ---");
                            for (int i = 0; i < daftarBarang.size(); i++) {
                             System.out.println((i + 1) + ". " + daftarBarang.get(i).getNama() + " (Stok: " + daftarBarang.get(i).getStok() + ")");
    }

                            System.out.print("Pilih nomor barang: ");
                             int pilihanUser = scanner.nextInt();
                             int indeks = pilihanUser - 1;
                            scanner.nextLine();

                        try {
                        barang5 barang = daftarBarang.get(indeks);

                            System.out.println("\nApa yang ingin Anda lakukan?");
                            System.out.println("1. Kurangi jumlah stok");
                            System.out.println("2. Hapus barang dari daftar");
                            System.out.print("Pilih opsi: ");
                            int opsi = scanner.nextInt();
                            scanner.nextLine();

                         if (opsi == 1) {
                            System.out.print("Jumlah stok yang dikurangi: ");
                                int jumlahKurang = scanner.nextInt();
                            scanner.nextLine();

                        if (jumlahKurang > barang.getStok()) {
                            throw new StokTidakCukup5("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                         }

                            barang.setStok(barang.getStok() - jumlahKurang);
                            System.out.println("Stok berhasil dikurangi.");

                        } else if (opsi == 2) {
                             daftarBarang.remove(indeks);
                             System.out.println("Barang berhasil dihapus dari daftar.");
                        } else {
                             System.out.println("Opsi tidak valid.");
                        }

                        } catch (IndexOutOfBoundsException e) {
                             System.out.println("Nomor barang tidak valid.");
                        } catch (InputMismatchException e) {
                            System.out.println("Input harus berupa angka!");
                             scanner.nextLine();
                        } catch (StokTidakCukup5 e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 0:
                        System.out.println("Terima kasih!");
                        running = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                        break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine(); // bersihkan input salah
            }
        }

        scanner.close();
    }
}
