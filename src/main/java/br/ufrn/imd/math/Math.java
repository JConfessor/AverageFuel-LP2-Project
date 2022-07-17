package br.ufrn.imd.math;

public class Math {

    public double CalcAverageLTCost(double TotalCost, double TotalLiters){
        return TotalCost/TotalLiters;
    }

    public double CalcKmPerLiter(double TotalLiters, int KmsTraveled){
        return KmsTraveled/TotalLiters;
    }




}
