package ru.gibdd.course.entity;

import javax.persistence.*;

@Entity
@Table(name = "Penalty_history")
public class PenaltyHistory {
    @Id
    @Column(name = "Decree_number")
    private String decreeNumber;

    @Column(name = "VIN")
    private String VIN;

    @Column(name = "Driver_license_phys")
    private String Driver_license_phys;

    @Column(name = "INN")
    private String INN;

    @Column(name = "State_number")
    private String State_number;

    @OneToOne
    @MapsId("Decree_number")
    @JoinColumn(name = "Decree_number", referencedColumnName = "Decree_number")
    private Penalty penalty;

    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    public PenaltyHistory() {
    }

    public PenaltyHistory(String decreeNumber, String VIN, String driver_license_phys, String INN, String state_number) {
        this.decreeNumber = decreeNumber;
        this.VIN = VIN;
        Driver_license_phys = driver_license_phys;
        this.INN = INN;
        State_number = state_number;
    }

    public String getDecreeNumber() {
        return decreeNumber;
    }

    public void setDecreeNumber(String decreeNumber) {
        this.decreeNumber = decreeNumber;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getDriver_license_phys() {
        return Driver_license_phys;
    }

    public void setDriver_license_phys(String driver_license_phys) {
        Driver_license_phys = driver_license_phys;
    }

    public String getINN() {
        return INN;
    }

    public void setINN(String INN) {
        this.INN = INN;
    }

    public String getState_number() {
        return State_number;
    }

    public void setState_number(String state_number) {
        State_number = state_number;
    }
}
