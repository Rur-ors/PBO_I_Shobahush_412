package Users;

import data.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import Action.MahasiswaAction;
import tugas_javafx.*;

import java.util.Scanner;


import static Main.LoginSystem.itemList;
import static tugas_javafx.HelloApplication.loginMenu;

public class Mahasiswa extends User implements MahasiswaAction {
    private String nama;
    private String nim;
    Scanner input = new Scanner(System.in);
    
    public Mahasiswa(String nama, String nim){
        super(nama, nim);
        this.nama = nama;
        this.nim = nim;
    }
    public Mahasiswa(){
        super("","");
    }

    public void displayMahasiswa(){
        VBox root = new VBox(10);
        root.setStyle("-fx-background-color: #170214;");

        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);

        Label hello = new Label();
        hello.setText("Hallo, " + nama);
        hello.setStyle("-fx-text-fill: white; -fx-font-size: 16px;");

        Label title = new Label();
        title.setText("Laporkan Barang hilang/temuan 📦");
        title.setStyle("-fx-text-fill: white; -fx-font-size: 16px; -fx-font-weight: bold;");

        TextField inBarang = new TextField();
        inBarang.setPromptText("Nama Barang");
        inBarang.setStyle("-fx-background-color: #2b0526;" +
                "-fx-border-color: #7d2aa1; " +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 10px; " +
                "-fx-prompt-text-fill:white;" +
                "-fx-text-fill: white;");

        TextField inDeskripsi = new TextField();
        inDeskripsi.setPromptText("Deskripsi");
        inDeskripsi.setStyle("-fx-background-color: #2b0526;" +
                "-fx-border-color: #7d2aa1; " +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 10px; " +
                "-fx-prompt-text-fill:white;" +
                "-fx-text-fill: white;");

        TextField inLokasi = new TextField();
        inLokasi.setPromptText("Lokasi");
        inLokasi.setStyle("-fx-background-color: #2b0526;" +
                "-fx-border-color: #7d2aa1; " +
                "-fx-border-width: 1px;" +
                "-fx-border-radius: 10px; " +
                "-fx-prompt-text-fill:white;" +
                "-fx-text-fill: white;");

        Button lapor = new Button();
        lapor.setText("Laporkan");
        lapor.setStyle("-fx-text-fill: white; " +
                "-fx-background-color: #7d2aa1");

        Button logOut = new Button("Logout");
        logOut.setStyle("-fx-text-fill: white; " +
                "-fx-background-color: #7d2aa1");

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(new PropertyValueFactory<>("itemName"));

        TableColumn<Item, String> deskirpCol = new TableColumn<>("Deskripsi");
        deskirpCol.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Item, String> locationCol = new TableColumn<>("Lokasi");
        locationCol.setCellValueFactory(new PropertyValueFactory<>("location"));

        TableColumn<Item,String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        itemList.getColumns().addAll(namaCol, deskirpCol, locationCol, statusCol);

        hbox.getChildren().addAll(inBarang,inDeskripsi,inLokasi,lapor);
        root.getChildren().addAll(hello,title,hbox,itemList,logOut);


        lapor.setOnAction(event -> {
            reportItem(inBarang.getText(),inDeskripsi.getText(),inLokasi.getText());
        });

        Scene scene = new Scene(root,800,600);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Mahasiswa");
        stage.show();

        logOut.setOnAction(event -> {
            stage.close();
            loginMenu();
        });

    }

    @Override
    public void reportItem(String barang, String deskripsi, String lokasi) {
        itemList.getItems().add(new Item(barang,deskripsi,lokasi));

    }


}
