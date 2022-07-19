package br.ufrn.imd.file;

import br.ufrn.imd.math.SortTypes;
import br.ufrn.imd.vehicle.EscortVehicle;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import br.ufrn.imd.math.Sort;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Console {

    public void PrintMap(Map m, int amountToPrint, SortTypes sortingType, int SortOrder) {
        Sort Sorter = new Sort();
        table(m,amountToPrint,sortingType,SortOrder);
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

    public void table(Map m, int amountToPrint, SortTypes sortingType, int SortOrder){
        Sort Sorter = new Sort();
        Object[] columns = {"1","2","3","4","5","6","7","8"};
        List<EscortVehicle> data = Sorter.Sort(m, sortingType, SortOrder);
        DefaultTableModel model = new DefaultTableModel(new Object[0][0], columns);
        for(EscortVehicle adv : data){
            Object[] o = new Object[8];
            o[0] = adv.getVehicleModel();
            o[1] = adv.getKmPerLiter();
            o[2] = adv.getLiters();
            o[3] = adv.getFleetNumber();
            o[4] = adv.getAverageLtCost();
            o[5] = adv.getTotalCost();
            o[6] = adv.getMonthlyOdometer();
            o[7] = adv.getLicensePlate();
            model.addRow(o);
        }


        JTable jtable = new JTable(model);
        JFrame jframe = new JFrame();
        jframe.setSize(455,300);
        jframe.add(jtable);
        jframe.setVisible(true);

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
