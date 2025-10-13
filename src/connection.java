import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.PortUnreachableException;
import java.net.URL;

public class connection {
    public static void ersi () {
        boolean connectivity = false;
        try {
            URL url = new URL("https://teknoloji.mu.edu.tr/");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setConnectTimeout(5000);
            conn.connect();

            int responsecode = conn.getResponseCode();
            if (responsecode == 200){
                connectivity =true;
            }

        } catch (IOException e){
            connectivity = false;
        }
        if (connectivity){
            System.out.println("Bağlantı var");
        } else {
            System.out.println("bağlantı yok");
        }
    }
    public static void main(String[] args){
        ersi();
    }
}
