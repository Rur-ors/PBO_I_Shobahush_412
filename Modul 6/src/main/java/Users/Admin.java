package Users;

import java.util.Optional;
import java.util.Scanner;
import Action.AdminAction;
import data.Item;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import static Main.LoginSystem.*;
import static tugas_javafx.HelloApplication.loginMenu;


public class Admin extends User implements AdminAction {
    private String username;
    private String password;
    Scanner input = new Scanner(System.in);

    public Admin (String username, String password){
        super(username, password);
        this.username = username;
        this.password = password;
    }
    public Admin (){
        super("","");
        //
    }
    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public void displayAdmin(){
        VBox root = new VBox(10);
        root.setStyle("-fx-background-color: #2b0526;");
        VBox kiri = new VBox(5);
        kiri.setAlignment(Pos.CENTER_LEFT);
        VBox kanan = new VBox(5);
        kanan.setAlignment(Pos.CENTER_RIGHT);
        HBox table = new HBox(10);
        table.setAlignment(Pos.CENTER);
        HBox kurleb = new HBox(5);


        Label halo = new Label();
        halo.setText("Hallo min");
        halo.setStyle("-fx-text-fill: white; -fx-font-weight: bold;" +
                "-fx-font-size: 16px");

        TableColumn<User, String> mahasiswaCol = new TableColumn<>("Nama");
        mahasiswaCol.setCellValueFactory(new PropertyValueFactory<>("nama"));

        TableColumn<User, String> nimCol = new TableColumn<>("NIM");
        nimCol.setCellValueFactory(new PropertyValueFactory<>("nim"));

        TextField inNama = new TextField();
        inNama.setPromptText("Nama");
        inNama.setStyle("-fx-background-color: #170214;" +
                "-fx-border-color: #7d2aa1; " +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 10px; " +
                "-fx-prompt-text-fill:white;" +
                "-fx-text-fill: white;");

        TextField inNim = new TextField();
        inNim.setPromptText("NIM");
        inNim.setStyle("-fx-background-color: #170214;" +
                "-fx-border-color: #7d2aa1; " +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 10px; " +
                "-fx-prompt-text-fill:white;" +
                "-fx-text-fill: white;");

        Button remove = new Button("Hapus");
        remove.setStyle("-fx-text-fill: white; " +
                "-fx-background-color: #7d2aa1");

        Button add = new Button("Tambah");
        add.setStyle("-fx-text-fill: white; " +
                "-fx-background-color: #7d2aa1");

        userList.getColumns().addAll(mahasiswaCol,nimCol);

        kurleb.getChildren().addAll(inNama,inNim,add,remove);

        kiri.getChildren().addAll(halo,userList,kurleb);

        //============================================================================

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Item, String> deskirpCol = new TableColumn<>("Deskripsi");
        deskirpCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> locationCol = new TableColumn<>("Lokasi");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item,String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        itemList.getColumns().addAll(namaCol, deskirpCol, locationCol, statusCol);

        Button claimed = new Button("Tandai Claimed");
        claimed.setStyle("-fx-text-fill: white; " +
                "-fx-background-color: #7d2aa1");

        Button logOut = new Button("Logout");
        logOut.setStyle("-fx-text-fill: white; " +
                "-fx-background-color: #7d2aa1");

        kanan.getChildren().addAll(itemList, claimed);

        //======================================================================

        table.getChildren().addAll(kiri,kanan);

        root.getChildren().addAll(table,logOut);

        claimed.setOnAction(event -> {
            manageItems();
        });

        add.setOnAction(event -> {
            userList.getItems().addAll(new Mahasiswa(inNama.getText(),inNim.getText()));
            manageUsers(true, inNama.getText(),inNim.getText());
        });
        remove.setOnAction(event -> {
            User selectedUser = userList.getSelectionModel().getSelectedItem();
            if (selectedUser != null){
                Alert confirm = new Alert(Alert.AlertType.CONFIRMATION);
                confirm.setTitle("konfirmasi hapus");
                confirm.setHeaderText("Menghapus item");
                confirm.setContentText("apakah anda yakin menghapus " + selectedUser.getNama() + "?" );

                Optional<ButtonType> result = confirm.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    userList.getItems().remove(selectedUser);

                    manageUsers(false,selectedUser.getNama(),selectedUser.getNim());
                }

            }
        });

        Scene scene = new Scene(root,800,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

        logOut.setOnAction(event -> {
            stage.close();
            loginMenu();
        });
    }

    @Override
    public void manageItems() {
        Item selecetedItem = itemList.getSelectionModel().getSelectedItem();

        if(selecetedItem != null){
            selecetedItem.setStatus("Claimed");
            itemList.refresh();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Status Updated");
            alert.setHeaderText("Item Status Telah Diubah");
            alert.setContentText("Status Item '" + selecetedItem.getItemName() + "' Telah diubah");
            alert.showAndWait();

        }
        else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No Selection");
            alert.setHeaderText("Tidak ada Item yang di ubah");
            alert.setContentText("Pilih item terlebih dahulu lalu tekan 'Claimed'");
            alert.showAndWait();
        }
    }

    @Override
    public void manageUsers(Boolean bool,String nama,String nim) {
        if(bool){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mahasiswa Baru");
            alert.setHeaderText("Mahasiswa Baru telat ditambahkan");
            alert.setContentText("Mahasiswa " + nama + " dengan nim "+ nim + "telah ditambahkan");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mahasiswa Lama");
            alert.setHeaderText("Mahasiswa telah di hapus");
            alert.setContentText("Mahasiswa " + nama + " dengan nim "+ nim + "telah dihapus");
            alert.showAndWait();
        }
    }
}
