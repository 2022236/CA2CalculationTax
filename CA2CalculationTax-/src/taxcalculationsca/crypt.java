/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taxcalculationsca;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.SecureRandom;
import java.util.Base64;


/**
 *
 * @author lizandra 2022236 and Taciana 2022404
 */

public class crypt {

    // Gera uma chave secreta
    public static SecretKey gerarChave() throws Exception {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = new SecureRandom();
        keyGenerator.init(secureRandom);
        return keyGenerator.generateKey();
    }

    // Criptografa os dados
    public static byte[] criptografar(Key chave, String dados) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        return cipher.doFinal(dados.getBytes(StandardCharsets.UTF_8));
    }

    // Descriptografa os dados
    public static String descriptografar(Key chave, byte[] dadosCriptografados) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] dadosDescriptografados = cipher.doFinal(dadosCriptografados);
        return bytesParaString(dadosDescriptografados);
    }

    // Converte bytes para uma representação de string (Base64)
    private static String bytesParaString(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
    
    

}
