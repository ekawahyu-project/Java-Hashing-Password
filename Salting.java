import java.security.*;
import java.util.*;

public class Salting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Masukkan Password     : ");
        String passwordGwah = in.nextLine();

        try {
            SecureRandom rdm = new SecureRandom();
            byte[] salt = new byte[16];
            rdm.nextBytes(salt);

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(salt);
            byte[] encodedhash = digest.digest(passwordGwah.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : encodedhash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            StringBuilder saltHex = new StringBuilder();
            for (byte b : salt){
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1){
                    saltHex.append('0');
                }
                saltHex.append(hex);
            }
            System.out.println("My Password Asli GWah : " + passwordGwah);
            System.out.println("Hasil Hash            : " + hexString );
            System.out.println("Hasil Salt            : " + saltHex.toString());

        } catch (NoSuchAlgorithmException e){
            System.out.println("Algorithm not found...");
        }
    }
}