package br.ufrn.imd.math;
import br.ufrn.imd.vehicle.EscortVehicle;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class Sort {
    public List<EscortVehicle> Sort(Map m, SortTypes sortingType){
        List<EscortVehicle> SortedList = Casting(m);
        switch (sortingType){
            case FLEET -> SortFleetNumber(SortedList);
            case LITERS -> SortLiters(SortedList);
            case TOTALCOST -> SortTotalCost(SortedList);
            case AVGLTCOST -> SortAvgLtCost(SortedList);
        }

        return SortedList;
    }


    private List<EscortVehicle> Casting(Map m){
        return new ArrayList<>(m.values());
    }

    private void SortFleetNumber(List SortedList){
        SortedList.sort(Comparator.comparingInt(EscortVehicle::getFleetNumber));
    }

    private void SortLiters(List SortedList){
        SortedList.sort(Comparator.comparingDouble(EscortVehicle::getLiters));
    }

    private void SortTotalCost(List SortedList){
        SortedList.sort(Comparator.comparingDouble(EscortVehicle::getTotalCost));
    }

    private void SortAvgLtCost(List SortedList){
        SortedList.sort(Comparator.comparingDouble(EscortVehicle::getAverageLtCost));
    }

}
