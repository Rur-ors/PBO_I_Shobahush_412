package Codelab4;

public class Nonfiksi extends Buku {
    private String bidang;

    public Nonfiksi(String judul, String penulis, String bidang) {
        super(judul, penulis);
        this.bidang = bidang;
    }

    @Override
    public void displayInfo() {
        System.out.println("BUKU Non-Fiksi: " + judul + " oleh " + penulis + " (Bidang: " + bidang + " )");
    }
}