package br.ufrn.imd.file;

import br.ufrn.imd.math.SortTypes;
import br.ufrn.imd.vehicle.EscortVehicle;

import java.util.List;
import java.util.Map;

import br.ufrn.imd.math.Sort;

import javax.swing.table.DefaultTableModel;

public class Console {

    public void PrintMap(Map m, int amountToPrint, SortTypes sortingType, int SortOrder) {
        Sort Sorter = new Sort();
        //table(m,amountToPrint,sortingType,SortOrder);
        //ClearConsole();
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

    public DefaultTableModel table(Map m, int amountToPrint, SortTypes sortingType, int SortOrder){
        Sort Sorter = new Sort();
        Object[] columns = {"FT","LICENSE PLATE","VEHICLE MODEL","LITERS","MONTHLY ODOMETER","KM/L","AVG LT COST","TOTAL COST"};
        List<EscortVehicle> data = Sorter.Sort(m, sortingType, SortOrder);
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columns);

        for(EscortVehicle adv : data){
            if(amountToPrint == 0){
                break;
            }
            Object[] o = new Object[8];
            o[0] = adv.getFleetNumber();
            o[1] = adv.getLicensePlate();
            o[2] = adv.getVehicleModel();
            o[3] = String.format("%,.2f", adv.getLiters());
            o[4] = adv.getMonthlyOdometer();
            o[5] = String.format("%,.3f", adv.getKmPerLiter());
            o[6] = String.format("%,.2f", adv.getAverageLtCost());
            o[7] = String.format("%,.2f", adv.getTotalCost());
            model.addRow(o);
            amountToPrint -= 1;
        }


        return model;
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
