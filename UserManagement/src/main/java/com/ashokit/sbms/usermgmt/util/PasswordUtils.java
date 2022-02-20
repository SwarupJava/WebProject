
package com.ashokit.sbms.usermgmt.util;

import javax.crypto.SecretKey;

import java.security.spec.KeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.security.spec.AlgorithmParameterSpec;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import java.util.Random;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PasswordUtils
{
    private final String SECRET_KEY = "my_super_secret_key_ho_ho_ho";
    private final String SALT = "ssshhhhhhhhhhh!!!!";
    
    public String generateRandomString() {
        final int leftLimit = 48;
        final int rightLimit = 122;
        final int targetStringLength = 10;
        final Random random = new Random();
        final String generatedPassword = random.ints(48, 123).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(10L).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedPassword;
    }
    
    public String encryptPassword(final String password) {
        try {
            final byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            final IvParameterSpec ivspec = new IvParameterSpec(iv);
            final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            final KeySpec spec = new PBEKeySpec("my_super_secret_key_ho_ho_ho".toCharArray(), "ssshhhhhhhhhhh!!!!".getBytes(), 65536, 256);
            final SecretKey tmp = factory.generateSecret(spec);
            final SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(1, secretKey, ivspec);
            return Base64.getEncoder().encodeToString(cipher.doFinal(password.getBytes(StandardCharsets.UTF_8)));
        }
        catch (Exception e) {
            System.out.println("Error while encrypting: " + e.toString());
            return null;
        }
    }
    
    public String decryptPassword(final String encryptedPassword) {
        try {
            final byte[] iv = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
            final IvParameterSpec ivspec = new IvParameterSpec(iv);
            final SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            final KeySpec spec = new PBEKeySpec("my_super_secret_key_ho_ho_ho".toCharArray(), "ssshhhhhhhhhhh!!!!".getBytes(), 65536, 256);
            final SecretKey tmp = factory.generateSecret(spec);
            final SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
            final Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(2, secretKey, ivspec);
            return new String(cipher.doFinal(Base64.getDecoder().decode(encryptedPassword)));
        }
        catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
            return null;
        }
    }
    
    public Boolean verifyPassword(final String password, final String encryptedPassword) {
        return this.decryptPassword(encryptedPassword).equals(password);
    }
}
