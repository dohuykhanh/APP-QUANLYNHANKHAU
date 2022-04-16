/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author ACER
 */
public class Nguoidung {
    private String Tendangnhap, Matkhau, Vaitro;

    public Nguoidung() {
    }

    public Nguoidung(String Tendangnhap, String Matkhau, String Vaitro) {
        this.Tendangnhap = Tendangnhap;
        this.Matkhau = Matkhau;
        this.Vaitro = Vaitro;
    }

    public String getTendangnhap() {
        return Tendangnhap;
    }

    public void setTendangnhap(String Tendangnhap) {
        this.Tendangnhap = Tendangnhap;
    }

    public String getMatkhau() {
        return Matkhau;
    }

    public void setMatkhau(String Matkhau) {
        this.Matkhau = Matkhau;
    }

    public String getVaitro() {
        return Vaitro;
    }

    public void setVaitro(String Vaitro) {
        this.Vaitro = Vaitro;
    }


    
    
}
