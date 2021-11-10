package com.example.model;

public class LichKhamDaHuy {
    private String HospitalNamedahuy, HospitalTimedahuy, HospitalDatedahuy;

    public LichKhamDaHuy(String hospitalNamedahuy, String hospitalTimedahuy, String hospitalDatedahuy) {
        HospitalNamedahuy = hospitalNamedahuy;
        HospitalTimedahuy = hospitalTimedahuy;
        HospitalDatedahuy = hospitalDatedahuy;
    }

    public String getHospitalNamedahuy() {
        return HospitalNamedahuy;
    }

    public void setHospitalNamedahuy(String hospitalNamedahuy) {
        HospitalNamedahuy = hospitalNamedahuy;
    }

    public String getHospitalTimedahuy() {
        return HospitalTimedahuy;
    }

    public void setHospitalTimedahuy(String hospitalTimedahuy) {
        HospitalTimedahuy = hospitalTimedahuy;
    }

    public String getHospitalDatedahuy() {
        return HospitalDatedahuy;
    }

    public void setHospitalDatedahuy(String hospitalDatedahuy) {
        HospitalDatedahuy = hospitalDatedahuy;
    }
}
