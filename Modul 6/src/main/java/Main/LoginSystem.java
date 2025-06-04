package Main;
import Users.Admin;
import Users.Mahasiswa;
import Users.User;
import data.Item;
import javafx.scene.control.TableView;


import java.util.ArrayList;
public class LoginSystem {
    public static TableView<User> userList = new TableView<>();
    public static TableView<Item> itemList = new TableView<>();

    static {
        itemList.getItems().addAll(
                new Item("Hape", "Redmi Note 11", "Lab A-B"),
                new Item("Buku", "Warna Hijau", "Lab C-D")
        );
    };

    static  {
        userList.getItems().addAll(
        new Mahasiswa("rur", "412"),
        new Mahasiswa("hest", "413"),
        new Admin("Admin", "admin123")
        );
    }
}
