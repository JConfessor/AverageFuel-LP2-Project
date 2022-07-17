package br.ufrn.imd.file;

import br.ufrn.imd.vehicle.EscortVehicle;

import javax.sound.midi.Soundbank;
import java.util.*;

public class Console {
    public void PrintMap(Map m) {

        List <EscortVehicle> SortedList = new ArrayList<>(m.values());
        SortedList.sort((a, b) -> Integer.compare(a.getFleetNumber(), b.getFleetNumber()));

        for(EscortVehicle ev: SortedList){
            System.out.println("/// " + ev.getFleetNumber() + " - " + ev.getLicensePlate() + " ///");
            System.out.println(String.format("LITERS: %,.2f" , ev.getLiters()));
            System.out.println(String.format("AVG LT COST: %,.2f", ev.getAverageLtCost()));
            System.out.println("MONTHLY ODOMETER: " + ev.getMonthlyOdometer());
            System.out.println(String.format("TOTAL COST: %,.2f", ev.getTotalCost()));
            System.out.println();
        }
    }
}
