package com.example.model;

public class LichKhamDaht {
    private String HospitalNamedht, HospitalTimedht, HospitalDatedht;

    public LichKhamDaht(String hospitalNamedht, String hospitalTimedht, String hospitalDatedht) {
        HospitalNamedht = hospitalNamedht;
        HospitalTimedht = hospitalTimedht;
        HospitalDatedht = hospitalDatedht;
    }

    public String getHospitalNamedht() {
        return HospitalNamedht;
    }

    public void setHospitalNamedht(String hospitalNamedht) {
        HospitalNamedht = hospitalNamedht;
    }

    public String getHospitalTimedht() {
        return HospitalTimedht;
    }

    public void setHospitalTimedht(String hospitalTimedht) {
        HospitalTimedht = hospitalTimedht;
    }

    public String getHospitalDatedht() {
        return HospitalDatedht;
    }

    public void setHospitalDatedht(String hospitalDatedht) {
        HospitalDatedht = hospitalDatedht;
    }
}
