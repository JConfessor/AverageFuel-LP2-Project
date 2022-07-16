package br.ufrn.imd.vehicle;

public class EscortVehicle {
    private String licensePlate;
    private String vehicleModel;
    private int fleetNumber;
    private double liters = 0;
    private double averageLtCost = 0;
    private int monthlyOdometer = 0;
    private double totalCost = 0;

    EscortVehicle(String licensePlate, String vehicleModel, int fleetNumber){
        this.licensePlate = licensePlate;
        this.vehicleModel = vehicleModel;
        this.fleetNumber = fleetNumber;
    }



    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public int getFleetNumber() {
        return fleetNumber;
    }

    public void setFleetNumber(int fleetNumber) {
        this.fleetNumber = fleetNumber;
    }


    public double getLiters() {
        return liters;
    }

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
