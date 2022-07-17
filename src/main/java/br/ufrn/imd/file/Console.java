package br.ufrn.imd.file;

import br.ufrn.imd.vehicle.EscortVehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import br.ufrn.imd.math.Math;

public class Console {
    Math Calculator = new Math();
    public void PrintMap(Map m) {

        List <EscortVehicle> SortedList = new ArrayList<>(m.values());
        SortedList.sort(Comparator.comparingInt(EscortVehicle::getFleetNumber));

        for(EscortVehicle ev: SortedList){
            System.out.println("/// " + ev.getFleetNumber() + " - " + ev.getLicensePlate() + " ///");
            System.out.printf("LITERS: %,.2f%n", ev.getLiters());
            System.out.printf("AVG LT COST: %,.2f%n", ev.getAverageLtCost());
            System.out.println("MONTHLY ODOMETER: " + ev.getMonthlyOdometer());
            System.out.printf("TOTAL COST: %,.2f%n", ev.getTotalCost());
            System.out.println();
        }
    }
}
