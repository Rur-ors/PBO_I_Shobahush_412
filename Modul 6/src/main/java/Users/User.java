package Users;

public abstract class User {
    private String nama;
    private String nim;

    public User(String nama, String nim){
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama(){
        return nama;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNim(){
        return nim;
    }

    public void setNim(){
        this.nim = nim;
    }


    public void displayInfo(){
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }


}
