import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Random;

//import java.security.MessageDigest;

public class Passenger {

    private String name;
    private int numberBags;
    private Boolean onFlight;
    private String seatNumber;

    public Passenger(String name, int numberBags) {
        this.name = name;
        this.numberBags = numberBags;
        this.onFlight = false;
        this.seatNumber = null;
    }

    public String getName() {
        return this.name;
    }

    public int getNumberBags() {
        return this.numberBags;
    }

    public Boolean getOnFlight() {
        return this.onFlight;
    }

    public String getSeatNumber() {
        return this.seatNumber;
    }

    public void setOnFlight(Boolean onFlight) {
        this.onFlight = onFlight;
    }

    public void setSeatNumber() throws NoSuchAlgorithmException {
        this.seatNumber = this.generateHash();
    }

    public String generateHash() throws NoSuchAlgorithmException {
        String message = this.name + this.numberBags;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(message.getBytes());
        byte[] digest = md.digest();
        //Converting the byte array in to HexString format
        StringBuffer hexString = new StringBuffer();
        for (int i = 0; i<digest.length; i++) {
            hexString.append(Integer.toHexString(0xFF & digest[i]));
        }
        String hash = hexString.toString();
        return hash;
    }

}
