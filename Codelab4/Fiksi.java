package Codelab4;

public class Fiksi extends Buku {
    private String genre;

    public Fiksi(String judul, String penulis, String genre) {
        super(judul, penulis);
        this.genre = genre;
    }

    @Override
    public void displayInfo() {
        System.out.println("BUKU Fiksi: " + judul + " oleh " + penulis + " (Genre: " + genre + " )");
    }
}
