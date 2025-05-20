package Modul4.MainModul4;

import Modul4.UserEditor.*;
import java.util.Scanner;

public class LoginSystem4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Admin4 admin = new Admin4("Rur", "Rur29");
        Mahasiswa4 mhs = new Mahasiswa4("mahasiswa", "mhs123");

        System.out.print("Username: ");
        String user = scanner.nextLine();
        System.out.print("Password: ");
        String pass = scanner.nextLine();

        User4 currentUser = null;

        if (admin.login(user, pass)) {
            currentUser = admin;
        } else if (mhs.login(user, pass)) {
            currentUser = mhs;
        } else {
            System.out.println("Login gagal. Username atau password salah.");
            return;
        }

        currentUser.displayAppMenu();
    }
}