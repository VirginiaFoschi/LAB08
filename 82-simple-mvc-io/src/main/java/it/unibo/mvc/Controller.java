package it.unibo.mvc;

import java.io.*;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private static final String SEP = File.separator;
    public static final String FILE_NAME = System.getProperty("user.home")+ SEP+"output.txt";
    private File f = new File(Controller.FILE_NAME);

    public File getFile() {
        return this.f;
    }

    public String getPath() {
        return this.f.getPath();
    }

    public void saveString(final String s) throws IOException {
        try(final BufferedWriter w=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f)))){
            w.write(s);
        }catch(IOException e) {
            System.out.println(e.toString());
        }

    }

    public void changeFile(final File f) {
        this.f = f;
    }

    public void printContent() {
        try (BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(f)))) {
            
            String line =null;
            while((line=r.readLine()) != null) {
                System.out.println(line);
            }
        }catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
