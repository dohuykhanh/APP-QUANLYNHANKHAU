/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Nguoidung;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import context.DBContext;
import java.util.ArrayList;


/**
 *
 * @author ACER
 */
public class NguoidungDao {
    public Nguoidung checklogin(String Tendangnhap, String Matkhau)throws Exception{
        
        String sql="select Tendangnhap, Matkhau, Vaitro from [TAI KHOAN]"
                + "where Tendangnhap=? and Matkhau=?";
        try(
                Connection conn = new DBContext().getConnection();
                PreparedStatement pstmt= conn.prepareStatement(sql);
                
                ){
            pstmt.setString(1, Tendangnhap);
            pstmt.setString(2, Matkhau);
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    Nguoidung nd = new Nguoidung();
                    nd.setTendangnhap(Tendangnhap);
                    nd.setVaitro(rs.getString("Vaitro"));
                    return nd;
                }
            }
            
        }
        return null;
    }
}
