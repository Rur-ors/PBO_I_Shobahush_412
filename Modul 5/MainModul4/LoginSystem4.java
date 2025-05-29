package Modul4.MainModul4;

import Modul4.UserEditor.*;
import Modul4.Actions4.Item4;

import java.util.ArrayList;
import java.util.Scanner;

public class LoginSystem4 {
    public static ArrayList<User4> userList = new ArrayList<>();
    public static ArrayList<Item4> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data default
        userList.add(new Admin4("Rur", "Rur1"));
        userList.add(new Mahasiswa4("Shobahush", "Rur123"));
        userList.add(new Mahasiswa4("Sururi", "Rur29"));

        System.out.println("=== Wellcome ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilih jenis user (1/2): ");

        int roleChoice;
        try {
            roleChoice = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Input harus berupa angka 1 atau 2.");
            return;
        }

        String userType = (roleChoice == 1) ? "Admin" : (roleChoice == 2) ? "Mahasiswa" : null;

        if (userType == null) {
            System.out.println("Pilihan tidak valid.");
            return;
        }

        System.out.print("Username: ");
        String username = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();

        User4 currentUser = null;

        for (User4 u : userList) {
            boolean isTypeMatch = (roleChoice == 1 && u instanceof Admin4)
                                || (roleChoice == 2 && u instanceof Mahasiswa4);
            if (isTypeMatch && u.login(username, password)) {
                currentUser = u;
                break;
            }
        }

        if (currentUser == null) {
            System.out.println("Login gagal. Username atau password salah.");
        } else {
            System.out.println("\nLogin berhasil sebagai " + userType + "!");
            currentUser.displayAppMenu();
        }

        scanner.close();
    }
}
