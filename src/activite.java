import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class activite {
    public static void main(String[] args){
        String os = System.getProperty("os.name").toLowerCase();
        String line;
        Process p;
        if(os.contains("win")){
            try {
                p = Runtime.getRuntime().exec("tasklist.exe");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                List<String[]> rows = new ArrayList<>();
                int linecount = 0;
                System.out.printf("| %-30s | %-8s |\n", "Process Name", "PID");
                while((line = input.readLine()) != null) {
                    linecount++;
                    if(linecount <= 2) continue;
                    String[] parts = line.trim().split("\\s+");
                    if(parts.length > 1) {
                        String processName = parts[0];
                        String pid = parts[1];
                        rows.add(new String[]{processName, pid});
                    }
                }
                for (String[] row : rows){
                    System.out.printf("| %-30s | %-8s |\n", row[0], row[1]);
                }
                input.close();
            }catch (IOException e){
                e.printStackTrace();
            }


        }else {
            try {
                p = Runtime.getRuntime().exec("ps -e");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                List<String[]> rows = new ArrayList<>();
                while((line = input.readLine()) != null) {
                    if(line.startsWith("PID")) continue;
                    String[] parts = line.trim().split("\\s+");
                    if(parts.length > 1) {
                        String processName = parts[1];
                        String pid = parts[0];
                        rows.add(new String[]{processName, pid});
                    }
                }
                for (String[] row : rows){
                    System.out.printf("| %-30s | %-8s |\n", row[0], row[1]);
                }

                input.close();
            }catch (IOException e){
            e.printStackTrace();
        }



        }
    }
}
