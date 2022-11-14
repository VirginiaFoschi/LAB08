package it.unibo.mvc;

import java.io.*;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {

    private File f;
    private static final String SEP = File.separator;
    public static final String FILE_NAME = System.getProperty("user.home")+ SEP+"output.txt";

    public Controller() {
        this.f = new File(Controller.FILE_NAME);
    }

    public Controller(final File f) {
        this.f= f;
    }

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


}
