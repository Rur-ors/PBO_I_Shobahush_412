package Codelab.REMIDI;


public class Mahasiswa {
  
    private String nama;
    private String nim;
    private String prodi;
    private boolean sudahDaftar;
    
  
    public Mahasiswa(String nama, String nim, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.prodi = prodi;
        this.sudahDaftar = true;
    }
    
  
    public String getNama() {
        return nama;
    }
    
    public String getNim() {
        return nim;
    }
    
    public String getProdi() {
        return prodi;
    }
    
    public boolean isSudahDaftar() {
        return sudahDaftar;
    }
    
   
    public void setNama(String nama) {
        this.nama = nama;
    }
    
    public void setNim(String nim) {
        this.nim = nim;
    }
    
    public void setProdi(String prodi) {
        this.prodi = prodi;
    }
    
    public void setSudahDaftar(boolean sudahDaftar) {
        this.sudahDaftar = sudahDaftar;
    }
    
    
    public void tampilkanInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM: " + nim);
        System.out.println("Prodi: " + prodi);
        System.out.println("Status: " + (sudahDaftar ? "Sudah Terdaftar" : "Belum Terdaftar"));
    }
}