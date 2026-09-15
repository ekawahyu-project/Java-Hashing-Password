import java.security.*;

public class PasswordHash {
    public static void main(String[] args) {
        String passwordGwah = "ekawahyu123";
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
            System.out.println("My Password GWah : " + passwordGwah);
            System.out.println("Hasil Hashing    : " + hexString );

        } catch (NoSuchAlgorithmException e){
            System.out.println("Algorithm not found...");
        }
    }
}