package br.ufrn.imd.file;

import br.ufrn.imd.math.SortTypes;
import br.ufrn.imd.vehicle.EscortVehicle;

import java.util.Map;

import br.ufrn.imd.math.Sort;

public class Console {

    public void PrintMap(Map m, int amountToPrint, SortTypes sortingType, int SortOrder) {
        Sort Sorter = new Sort();

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
}
