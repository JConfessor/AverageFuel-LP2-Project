package br.ufrn.imd.file;

import br.ufrn.imd.vehicle.EscortVehicle;

import java.util.Map;

public class Console {
    public void PrintMap(Map m){
        for(Object id: m.keySet()){
            EscortVehicle ev = (EscortVehicle) m.get(id);

            System.out.println("/// " + ev.getFleetNumber() + " - " + ev.getLicensePlate() + " ///");
            System.out.println("LITERS: " + ev.getLiters());
            System.out.println("AVG LT COST: " + ev.getAverageLtCost());
            System.out.println("MONTHLY ODOMETER: " + ev.getMonthlyOdometer());
            System.out.println("TOTAL COST: " + ev.getTotalCost());
            System.out.println();
        }
    }
}
