import java.security.*;
import java.util.*;

public class PasswordHash {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Password     : ");
        String passwordGwah = in.nextLine();
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(passwordGwah.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            System.out.println("My Password Asli GWah : " + passwordGwah);
            System.out.println("Hasil Hashing         : " + hexString );

        } catch (NoSuchAlgorithmException e){
            System.out.println("Algorithm not found...");
        }
    }
}