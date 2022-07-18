package br.ufrn.imd.file;

import br.ufrn.imd.math.SortTypes;
import br.ufrn.imd.vehicle.EscortVehicle;

import java.io.IOException;
import java.util.Map;

import br.ufrn.imd.math.Sort;

public class Console {

    public void PrintMap(Map m, int amountToPrint, SortTypes sortingType, int SortOrder) {
        Sort Sorter = new Sort();
        ClearConsole();
        System.out.println("C L E A R");
        for (EscortVehicle ev : Sorter.Sort(m, sortingType, SortOrder)) {
            if (amountToPrint == 0) {
                break;
            }
            System.out.println("/// FT " + ev.getFleetNumber() + " - " + ev.getLicensePlate() + " - " + ev.getVehicleModel() + " ///");
            System.out.printf("[#] LITERS: %,.2f%n", ev.getLiters());
            System.out.println("[#] MONTHLY ODOMETER: " + ev.getMonthlyOdometer());
            System.out.printf("[#] KM/LITER: %,.3f%n", ev.getKmPerLiter());
            System.out.printf("[$] AVG LT COST: %,.2f%n", ev.getAverageLtCost());
            System.out.printf("[$] TOTAL COST: %,.2f%n", ev.getTotalCost());
            System.out.println();
            amountToPrint -= 1;
        }
    }

    public static void ClearConsole(){
        try{
            String operatingSystem = System.getProperty("os.name"); //Check the current operating system

            if(operatingSystem.contains("Windows")){
                ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "cls");
                Process startProcess = pb.inheritIO().start();
                startProcess.waitFor();
            } else {
                ProcessBuilder pb = new ProcessBuilder("clear");
                Process startProcess = pb.inheritIO().start();

                startProcess.waitFor();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
