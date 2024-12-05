package org.mohamed.crypto.Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.util.Base64;

public class TextEncryptionLogic {
    private static final String ALGORITHM = "Blowfish";

    @FXML
    private TextField  keyInput, decryptionKeyInput;
    @FXML
    private TextArea plainInputText,cypherTextInput, decryptionResult, result;
    @FXML
    private Button EncryptionBtn, DecryptionBtn, HomeBtn;

    // Method to encrypt text
    public String encryptText(String text, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(text.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    // Method to decrypt text
    public String decryptText(String encryptedText, String key) throws Exception {
        SecretKey secretKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedText);
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);
        return new String(decryptedBytes);
    }

    public void goBackToHome(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/org/mohamed/crypto/HomePage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void handleEncrypt() {
        String text = plainInputText.getText();
        String key = keyInput.getText();

        try {
            if (key.length() < 4) {
                result.setText("Key must be at least 4 characters long.");
                return;
            }
            String encryptedText = encryptText(text, key);
            result.setText(encryptedText);
        } catch (Exception e) {
            result.setText("Encryption failed: " + e.getMessage());
        }
    }

    @FXML
    private void handleDecrypt() {
        String encryptedText = cypherTextInput.getText();
        String key = decryptionKeyInput.getText();

        try {
            if (key.length() < 4) {
                decryptionResult.setText("Key must be at least 4 characters long.");
                return;
            }
            String decryptedText = decryptText(encryptedText, key);
            decryptionResult.setText(decryptedText);
        } catch (Exception e) {
            decryptionResult.setText("Decryption failed: " + e.getMessage());
        }
    }
}
