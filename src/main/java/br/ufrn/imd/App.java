package br.ufrn.imd;
// Local
import br.ufrn.imd.file.XLSX;
import br.ufrn.imd.vehicle.EscortVehicle;
import br.ufrn.imd.file.Console;

// Java
import java.io.IOException;
import java.util.Map;

public class App {
    public static void main(String[] args) throws IOException {
        XLSX reader = new XLSX("./src/Resource/Test1.xlsx");
        var escortvehicles = reader.readXLSX();

        Console TestConsole = new Console();
        TestConsole.PrintMap(escortvehicles);
    }
}
