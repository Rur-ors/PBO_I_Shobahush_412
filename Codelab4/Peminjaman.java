package Codelab4;

public interface Peminjaman {
    void pinjamBuku(String judul);
    void pinjamBuku(String judul, int durasi);  
    void kembalikanBuku(String judul);
}