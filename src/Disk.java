import java.io.File;
import javax.swing.*;

public class Disk {
    public static void main(String[] args){
        File file = new File("C:");
        long totolSpace = file.getTotalSpace();
        long usableSpace = file.getUsableSpace();
        long freeSpace = file.getFreeSpace();

        String message = "=== Disk Bilgileri ===\n"
                + "Toplam Alan:" + totolSpace / 1024 / 1024 + " MB\n"
                + "Kullanılabilir: " + usableSpace / 1024 / 1024 + " MB\n"
                + "Boş Alan: " + freeSpace / 1024 / 1024 + " MB";

        JOptionPane.showMessageDialog(null, message,"Disk Bilgileri",JOptionPane.INFORMATION_MESSAGE);
    }
}