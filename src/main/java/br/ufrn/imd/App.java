package br.ufrn.imd;

// Local

// Java
import br.ufrn.imd.ui.UI;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
//        JFileChooser FC = new JFileChooser();
//        int returnVal = FC.showOpenDialog(null);
//        if (returnVal == JFileChooser.APPROVE_OPTION) {
//            File f = FC.getSelectedFile();
//
//
//            XLSX reader = new XLSX(f.getPath());
//            var escortvehicles = reader.readXLSX();
//
//
//            Console TestConsole = new Console();
//            TestConsole.PrintMap(escortvehicles, -1, SortTypes.FLEET, 1);
//        }else{
//            System.out.printf("No file was selected.");
//        }

        UI gui = new UI();
    }
}
