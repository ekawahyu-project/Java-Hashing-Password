import java.security.*;
import java.util.*;

public class LoginValidator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String dbSaltHex = "2084477bfd3fde434ffca30ed6d13dca";
        String dbHashHex = "9328c46cd69df74a18d7570162bf68376fff5c1eef9f5ed310eda53b506b0c5a";

        // PASSWORD : ekawahyu
        System.out.print("Masukkan Password : ");
        String inputPassword = in.nextLine();

        try {
            byte[] saltBytes = HexFormat.of().parseHex(dbSaltHex);

            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            digest.update(saltBytes); 

            byte[] inputHashBytes = digest.digest(inputPassword.getBytes());

            String inputHashHex = HexFormat.of().formatHex(inputHashBytes);

            System.out.println("Hash di Database : " + dbHashHex);
            System.out.println("Hash Input User  : " + inputHashHex);
            System.out.println("------------------------------------------------");

            byte[] dbHashBytes = HexFormat.of().parseHex(dbHashHex);
            
            if (MessageDigest.isEqual(inputHashBytes, dbHashBytes)) {
                System.out.println("Status: LOGIN BERHASIL! Akses diberikan.");
            } else {
                System.out.println("Status: LOGIN GAGAL! Password salah.");
            }

        } catch (Exception e) {
            System.out.println("Terjadi kesalahan sistem: " + e.getMessage());
        }
    }
}