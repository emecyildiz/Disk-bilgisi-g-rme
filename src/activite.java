import java.io.*;

public class activite {
    public static void main(String[] args){
        String os = System.getProperty("os.name").toLowerCase();
        String line;
        Process p;
        if(os.contains("win")){
            try {
                p = Runtime.getRuntime().exec("tasklist.exe");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                input.close();
            }catch (IOException e){
                e.printStackTrace();
            }


        }else {
            try {
                p = Runtime.getRuntime().exec("ps -e");
                BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
                while((line = input.readLine()) != null) {
                    System.out.println(line);
                }
                input.close();
            }catch (IOException e){
            e.printStackTrace();
        }



        }
    }
}
