package com.example.model;


import java.io.Serializable;

public class BenhVien implements Serializable {
    private  int imvBenhVien;
    private String txtName;
    private String txtAddress;

    public BenhVien(int imvBenhVien, String txtName, String txtAddress) {
        this.imvBenhVien = imvBenhVien;
        this.txtName = txtName;
        this.txtAddress = txtAddress;
    }

    public int getImvBenhVien() {
        return imvBenhVien;
    }

    public void setImvBenhVien(int imvBenhVien) {
        this.imvBenhVien = imvBenhVien;
    }

    public String getTxtName() {
        return txtName;
    }

    public void setTxtName(String txtName) {
        this.txtName = txtName;
    }

    public String getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(String txtAddress) {
        this.txtAddress = txtAddress;
    }


}

