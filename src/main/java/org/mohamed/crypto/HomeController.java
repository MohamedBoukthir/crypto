package org.mohamed.crypto;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    // Navigate to the Text Encryption
    @FXML
    private void goToTextEncryptionPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("TextEncryption.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    // Navigate to the File Encryption
    @FXML
    private void goToFileEncryptionPage(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("FileEncryption.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
