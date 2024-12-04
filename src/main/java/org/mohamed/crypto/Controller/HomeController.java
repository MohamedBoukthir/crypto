package org.mohamed.crypto.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {
    private Stage stage;

    // Navigate to the Text Encryption
    @FXML
    private void goToTextEncryptionPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("TextEncryption.fxml"));
        Scene textEncryptionScene = new Scene(loader.load());
        stage.setScene(textEncryptionScene);
    }

    // Navigate to the File Encryption
    @FXML
    private void goToFileEncryptionPage() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FileEncryption.fxml"));
        Scene fileEncryptionScene = new Scene(loader.load());
        stage.setScene(fileEncryptionScene);
    }
}
