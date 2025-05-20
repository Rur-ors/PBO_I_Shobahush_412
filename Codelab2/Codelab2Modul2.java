package Codelab.Modul2;

import java.text.NumberFormat;
import java.util.Locale;

public class Codelab2Modul2 {

    private String nomorRekening;
    private String namaPemilik;
    private double saldo;

    public Codelab2Modul2(String nomorRekening, String namaPemilik, double saldo) {
        this.nomorRekening = nomorRekening;
        this.namaPemilik = namaPemilik;
        this.saldo = saldo;
    }

    public void setorUang(double jumlah) {
        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Setoran berhasil. Saldo sekarang: " + formatRupiah(saldo));
        } else {
            System.out.println("Jumlah setoran harus lebih dari 0.");
        }
    }

    public void tarikUang(double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            saldo -= jumlah;
            System.out.println("Penarikan berhasil. Saldo sekarang: " + formatRupiah(saldo));
        } else {
            System.out.println("Penarikan gagal. Pastikan saldo cukup dan jumlah valid.");
        }
    }

    public void transfer(Codelab2Modul2 tujuan, double jumlah) {
        if (jumlah > 0 && jumlah <= saldo) {
            this.tarikUang(jumlah);
            tujuan.setorUang(jumlah);
            System.out.println("Transfer sebesar " + formatRupiah(jumlah) + " ke " + tujuan.namaPemilik + " berhasil.");
        } else {
            System.out.println("Transfer gagal. Pastikan saldo cukup dan jumlah valid.");
        }
    }

    public void tampilkanInfoRekening() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: " + formatRupiah(saldo));
        System.out.println();
    }

    private String formatRupiah(double jumlah) {
        NumberFormat formatRupiah = NumberFormat.getCurrencyInstance(new Locale("id", "ID"));
        return formatRupiah.format(jumlah);
    }

    public static void main(String[] args) {
        // Membuat dua akun
        Codelab2Modul2 akun1 = new Codelab2Modul2("12345678", "Sururi", 1000000);
        Codelab2Modul2 akun2 = new Codelab2Modul2("87654321", "Aulia", 500000);

        // Menampilkan info awal kedua akun
        System.out.println("Informasi Awal Rekening:");
        akun1.tampilkanInfoRekening();
        akun2.tampilkanInfoRekening();

        // Setor dan tarik uang
        akun1.setorUang(500000);
        akun2.tarikUang(200000);

        // Transfer dari akun1 ke akun2
        akun1.transfer(akun2, 300000);

        // Menampilkan info setelah transaksi
        System.out.println("Informasi Rekening Setelah Transaksi:");
        akun1.tampilkanInfoRekening();
        akun2.tampilkanInfoRekening();
    }
}
