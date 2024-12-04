package org.mohamed.crypto.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TextEncryptionLogic {
    private static final String ALGORITHM = "Blowfish";

    @FXML
    private TextField plainInputText, keyInput, result, cypherTextInput, decryptionKeyInput, decryptionResult;

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
