package br.ufrn.imd.math;
import br.ufrn.imd.vehicle.EscortVehicle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Sort {
    public List<EscortVehicle> Sort(Map m, SortTypes sortingType, int Order){
        List<EscortVehicle> SortedList = Casting(m);
        switch (sortingType){
            case FLEET -> SortFleetNumber(SortedList, Order);
            case LITERS -> SortLiters(SortedList, Order);
            case TOTALCOST -> SortTotalCost(SortedList, Order);
            case AVGLTCOST -> SortAvgLtCost(SortedList, Order);
            case KMPERLITER -> SortKmPerLiter(SortedList, Order);
        }

        return SortedList;
    }


    private List<EscortVehicle> Casting(Map m){
        return new ArrayList<>(m.values());
    }

    private void SortFleetNumber(List<EscortVehicle> SortedList, int SortOrder){
        switch (SortOrder){
            case -1 -> SortedList.sort((a,b) -> Integer.compare(b.getFleetNumber(), a.getFleetNumber()));
            case 1 -> SortedList.sort((a,b) -> Integer.compare(a.getFleetNumber(), b.getFleetNumber()));
        }
    }

    private void SortLiters(List<EscortVehicle> SortedList, int SortOrder){
        switch (SortOrder){
            case -1 -> SortedList.sort((a,b) -> Double.compare(b.getLiters(), a.getLiters()));
            case 1 -> SortedList.sort((a,b) -> Double.compare(a.getLiters(), b.getLiters()));
        }
    }

    private void SortTotalCost(List<EscortVehicle> SortedList, int SortOrder){
        switch (SortOrder){
            case -1 -> SortedList.sort((a,b) -> Double.compare(b.getTotalCost(), a.getTotalCost()));
            case 1 -> SortedList.sort((a,b) -> Double.compare(a.getTotalCost(), b.getTotalCost()));
        }
    }

    private void SortAvgLtCost(List<EscortVehicle> SortedList, int SortOrder){
        switch (SortOrder){
            case -1 -> SortedList.sort((a,b) -> Double.compare(b.getAverageLtCost(), a.getAverageLtCost()));
            case 1 -> SortedList.sort((a,b) -> Double.compare(a.getAverageLtCost(), b.getAverageLtCost()));
        }
    }

    private void SortKmPerLiter(List<EscortVehicle> SortedList, int SortOrder){
        switch (SortOrder){
            case -1 -> SortedList.sort((a,b) -> Double.compare(b.getKmPerLiter(), a.getKmPerLiter()));
            case 1 -> SortedList.sort((a,b) -> Double.compare(a.getKmPerLiter(), b.getKmPerLiter()));
        }
    }

}
