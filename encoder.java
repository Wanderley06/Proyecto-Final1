package Clases;

import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

public class encoder {

        String SecretKey = "Wanderley";

    public String ecnode(String SecretKey, String cadena, byte[] plainTextBytes) {
        String encriptacion = "";
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] llavecontraseña = md5.digest(SecretKey.getBytes("utf-8"));
            byte[] BytesKey = Arrays.copyOf(llavecontraseña, 24);
            SecretKey key = new SecretKeySpec(BytesKey, "DESede");
            Cipher cifrado = Cipher.getInstance("DESede");
            cifrado.init(Cipher.ENCRYPT_MODE,key);
            
            byte [] plaintTextBytes = cadena.getBytes("utf-8");
            byte [] buf = cifrado.doFinal(plainTextBytes);
            byte [] base64Bytes = Base64.encodeBase64(buf);
            encriptacion = new String(base64Bytes);
        } catch (Exception ext) {
            JOptionPane.showMessageDialog(null, "Algo salio mal al encriptar");
        }
        return encriptacion;
    }

    public String deecnode(String SecretKey, String cadenaEncriptada, byte[] PlainText) {
       String desencriptacion = "";
        try {
            byte [] message = Base64.decodeBase64(cadenaEncriptada.getBytes("utf-8"));
             MessageDigest md5 = MessageDigest.getInstance("MD5");
             byte [] digestOfcontraseña = md5.digest(SecretKey.getBytes("utf-8"));
             byte [] keyBytes = Arrays.copyOf(digestOfcontraseña, 24);
             SecretKey key= new SecretKeySpec(keyBytes,"DESede");
             Cipher decipher = Cipher.getInstance("DESede");
             decipher.init(Cipher.DECRYPT_MODE,key);
             byte [] plaintText = decipher.doFinal(message);
             desencriptacion = new String(PlainText, "UTF-8"); 
             
        }catch (Exception ext) {
            JOptionPane.showMessageDialog(null, "Algo salio mal");
            }
       return desencriptacion;
       
    }

    public String ecnode(String trim) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    }

    


