package br.ufrn.imd;
// Local
import br.ufrn.imd.file.XLSX;

// Java
import java.io.FileNotFoundException;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        XLSX reader = new XLSX("./src/Resource/Test1.xlsx");

    }
}
