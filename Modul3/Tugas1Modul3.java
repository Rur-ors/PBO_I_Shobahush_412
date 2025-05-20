package Modul3;

import java.util.Scanner;

// Superclass
class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public boolean login(String input1, String input2) {
        // Default login, bisa di-override
        return false;
    }

    public void displayInfo() {
        // Default display info
        System.out.println("User info.");
    }
}

// Subclass Admin
class Admin extends User {
    private String username;
    private String password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public boolean login(String inputUsername, String inputPassword) {
        return inputUsername.equals(username) && inputPassword.equals(password);
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
        System.out.println("Username: " + username);
    }
}

// Subclass Mahasiswa
class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public boolean login(String inputNama, String inputNim) {
        return inputNama.equals(getNama()) && inputNim.equals(getNim());
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }
}

// Kelas utama
public class Tugas1Modul3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Buat objek Admin dan Mahasiswa
        Admin admin = new Admin("ruri", "412", "Rurs", "2909");
        Mahasiswa mhs = new Mahasiswa("Sururi", "412");

        System.out.println("==== Sistem Login ====");
        System.out.print("Login sebagai (Admin/Mahasiswa): ");
        String pilihan = scanner.nextLine();

        if (pilihan.equalsIgnoreCase("Admin")) {
            System.out.print("Username : ");
            String inputUser = scanner.nextLine();
            System.out.print("Password : ");
            String inputPass = scanner.nextLine();

            if (admin.login(inputUser, inputPass)) {
                admin.displayInfo();
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }

        } else if (pilihan.equalsIgnoreCase("Mahasiswa")) {
            System.out.print("Nama : ");
            String inputNama = scanner.nextLine();
            System.out.print("NIM  : ");
            String inputNim = scanner.nextLine();

            if (mhs.login(inputNama, inputNim)) {
                mhs.displayInfo();
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }

        } else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
