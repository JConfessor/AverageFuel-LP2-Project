package br.ufrn.imd.vehicle;

public class EscortVehicle implements Vehicle{
    private final String licensePlate;
    private String vehicleModel;
    private final int fleetNumber;
    private double liters = 0;
    private double averageLtCost = 0;
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

    public int getFleetNumber(){return fleetNumber;}

    public double getLiters() {return liters;}

    public void setLiters(double liters) {
        this.liters += liters;
    }

    public double getAverageLtCost() {
        return averageLtCost;
    }

    public void setAverageLtCost(double averageLtCost) {
        this.averageLtCost += averageLtCost;
    }

    public int getMonthlyOdometer() {
        return monthlyOdometer;
    }

    public void setMonthlyOdometer(int monthlyOdometer) {
        this.monthlyOdometer = monthlyOdometer;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }



}
