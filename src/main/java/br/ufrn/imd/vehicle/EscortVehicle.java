package br.ufrn.imd.vehicle;
import br.ufrn.imd.math.Math;

public class EscortVehicle implements Vehicle{
    Math Calculator = new Math();


    private final String licensePlate;
    private final String vehicleModel;
    private final int fleetNumber;
    private double liters = 0;
    private double averageLtCost = 0;
    private double kmPerLiter = 0;
    private int monthlyOdometer = 0;
    private double totalCost = 0;

    // case int fleet number
    public EscortVehicle(String licensePlate, String vehicleModel, int fleetNumber){
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
        this.fleetNumber = fleetNumber;
    }

    // case string fleet number
    public EscortVehicle(String licensePlate, String vehicleModel, String fleetNumber){
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
        this.fleetNumber = Integer.parseInt(fleetNumber);
    }

    @Override
    public String getLicensePlate(){return licensePlate;}

    @Override
    public String getVehicleModel(){return vehicleModel;}

    public int getFleetNumber(){return fleetNumber;}

    public double getLiters() {return liters;}

    public void setLiters(double liters) {
        this.liters += liters;
    }

    public double getAverageLtCost() {
        return averageLtCost = Calculator.CalcAverageLTCost(this.totalCost, this.liters);
    }

    public double getKmPerLiter(){
        return kmPerLiter = Calculator.CalcKmPerLiter(this.liters, this.monthlyOdometer);
    }

    public int getMonthlyOdometer() {
        return monthlyOdometer;
    }

    public void setMonthlyOdometer(int monthlyOdometer) {
        this.monthlyOdometer += monthlyOdometer;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost += totalCost;
    }



}
