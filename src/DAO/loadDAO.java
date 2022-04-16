/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.quanlytamtru;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import context.DBContext;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

/**
 *
 * @author ACER
 */
public class loadDAO {
    Connection conn = null;// mo ket noi toiws sql
    PreparedStatement ps=null;// nem cau lenh query sang sql
    ResultSet rs=null;// nhan ket qua
    
    public List<quanlytamtru>getALLquanlytamtru(){
        String query="select * from [TAM TRU]";
        List<quanlytamtru> list = new ArrayList<>();
        try {
            conn= new DBContext().getConnection();// mo ket noi
            ps=conn.prepareStatement(query);
            rs=ps.executeQuery();
            while(rs.next()){
                list.add(new quanlytamtru(rs.getString(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9)));//pải lấy đủ hết cột trong database nó mới chạy.
            }
            return list;
        } catch (Exception e) {
        }
        return null;
    }
    
    //them sinh vien
//    public void insert(String maTamTru, String HoTen, Date NTNS, String GioiTinh, String NoiOTamTru, String NgayDangKy, String NgayChuyenDen, String NgayRoiDi, String maSoNhanKHau){
//         String query="insert into [TAM TRU](maTamTru, HoTen, NTNS, GioiTinh, NoiOTamTru, NgayDangKy, NgayChuyenDen, NgayRoiDi, maSoNhanKhau) values(?,?,?,?,?,?,?,?,?)";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//         try {
//            conn= new DBContext().getConnection();
//            ps = conn.prepareStatement(query);
//            ps.setString(1, maTamTru);
//            ps.setString(2, HoTen);
//            ps.setDate(3, NTNS);
//            ps.setString(4, GioiTinh);
//            ps.setString(5, NoiOTamTru);
//            ps.setString(6, NgayDangKy);
//            ps.setString(7, NgayChuyenDen);
//            ps.setString(8, NgayRoiDi);
//            ps.setString(9, maSoNhanKHau);
//            ps.executeUpdate();
//        } catch (Exception e) {
//        }
//    }
    public boolean insert(quanlytamtru qltt) throws Exception{
        String query="insert into [TAM TRU](maTamTru, HoTen, NTNS, GioiTinh, NoiOTamTru, NgayDangKy, NgayChuyenDen, NgayRoiDi, maSoNhanKhau) values(?,?,?,?,?,?,?,?,?)";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlhk.getNgaycap());
//            DateFormat df = new  SimpleDateFormat("dd-MM-yyy");
//            Date dateNTNS =df.parse(qltt.getNTNS());
            ps.setString(1, qltt.getMaTamTru());
            ps.setString(2, qltt.getHoTen());
            ps.setString(3, qltt.getNTNS());
            ps.setString(4, qltt.getGioiTinh());
            ps.setString(5, qltt.getNoiOTamTru());
            ps.setString(6, qltt.getNgayDangKy());
            ps.setString(7, qltt.getNgayChuyenDen());
            ps.setString(8, qltt.getNgayRoiDi());
            ps.setString(9, qltt.getMaSoNhanKhau());
            
//              ps.setString(1, qltt.getMaTamTru());
//            ps.setString(2, qltt.getHoTen());
//            ps.setDate(3, qltt.getNTNS());
//            ps.setString(4, qltt.getGioiTinh());
//            ps.setString(5, qltt.getNoiOTamTru());
//            ps.setString(6, qltt.getNgayDangKy());
//            ps.setString(7, qltt.getNgayChuyenDen());
//            ps.setString(8, qltt.getNgayRoiDi());
//            ps.setString(9, qltt.getMaSoNhanKhau());
            
          
            return ps.executeUpdate()> 0;

        }
       
        } 
    
//    //tìm kiếm 
    public quanlytamtru findByid(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where maTamTru=? ";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          if(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


//              
            return qltt;
          }
            return null;

        }
       
        } 
 
 
     //    //tìm kiếm
    public ArrayList<quanlytamtru> findByGioiTinh(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where GioiTinh=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
    
    //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNam(String Namm) throws Exception{
        String query="select * from [TAM TRU]";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
//            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
        String ngaychuyenden= rs.getString("NgayChuyenDen");
        String ngayroidi= rs.getString("NgayRoiDi");
	LocalDate dateBefore = LocalDate.parse(ngaychuyenden);
	LocalDate dateAfter = LocalDate.parse(ngayroidi);
		
	long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        long nam=0;
        long ngay=noOfDaysBetween;
        long thang=0;
        while(ngay>=365){
        
            nam= nam +1;
            ngay= ngay-365;
            
        
        }
//        while(ngay>=30){
//        
//            thang= thang +1;
//            ngay= ngay-30;
//            
//        
//        }
		
//	System.out.println(noOfDaysBetween);
//        String timeer = String.valueOf(noOfDaysBetween);
        String timeerss = String.valueOf(nam);
//        String timeersss = String.valueOf(thang);

//        txtotrongbaolau.setText(timeer);
//        txtotrongnhiunam.setText(timeerss);
//        txtobaonhiuthang.setText(timeersss);

            if(Namm.equals(timeerss)){
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            }
          }
            return quanlytamtrulist;

        }
       
        } 
    
    //    //tìm kiếm
    public ArrayList<quanlytamtru> findByThang(String Namm) throws Exception{
        String query="select * from [TAM TRU]";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
//            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
        String ngaychuyenden= rs.getString("NgayChuyenDen");
        String ngayroidi= rs.getString("NgayRoiDi");
	LocalDate dateBefore = LocalDate.parse(ngaychuyenden);
	LocalDate dateAfter = LocalDate.parse(ngayroidi);
		
	long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
        long nam=0;
        long ngay=noOfDaysBetween;
        long thang=0;
//        while(ngay>=365){
//        
//            nam= nam +1;
//            ngay= ngay-365;
//            
//        
//        }
        while(ngay>=30){
        
            thang= thang +1;
            ngay= ngay-30;
            
        
        }
		
//	System.out.println(noOfDaysBetween);
//        String timeer = String.valueOf(noOfDaysBetween);
        String timeerss = String.valueOf(thang);
//        String timeersss = String.valueOf(thang);

//        txtotrongbaolau.setText(timeer);
//        txtotrongnhiunam.setText(timeerss);
//        txtobaonhiuthang.setText(timeersss);

            if(Namm.equals(timeerss)){
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            }
          }
            return quanlytamtrulist;

        }
       
        } 
    
     //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNgay(String Namm) throws Exception{
        String query="select * from [TAM TRU]";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
//            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
        String ngaychuyenden= rs.getString("NgayChuyenDen");
        String ngayroidi= rs.getString("NgayRoiDi");
	LocalDate dateBefore = LocalDate.parse(ngaychuyenden);
	LocalDate dateAfter = LocalDate.parse(ngayroidi);
		
	long noOfDaysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
       
        long ngay=noOfDaysBetween;
       
//        while(ngay>=365){
//        
//            nam= nam +1;
//            ngay= ngay-365;
//            
//        
//        }
//        while(ngay>=30){
//        
//            thang= thang +1;
//            ngay= ngay-30;
//            
//        
//        }
		
//	System.out.println(noOfDaysBetween);
//        String timeer = String.valueOf(noOfDaysBetween);
        String timeerss = String.valueOf(ngay);
//        String timeersss = String.valueOf(thang);

//        txtotrongbaolau.setText(timeer);
//        txtotrongnhiunam.setText(timeerss);
//        txtobaonhiuthang.setText(timeersss);

            if(Namm.equals(timeerss)){
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            }
          }
            return quanlytamtrulist;

        }
       
        } 
     //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNgayChuyenDen(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where NgayChuyenDen=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
    
    //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNgayRoiDi(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
    
    //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNgayDangKy(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where NgayDangKy=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
     //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNTNS(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where NTNS=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
    //    //tìm kiếm
    public ArrayList<quanlytamtru> findByHoTen(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where HoTen=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
     //    //tìm kiếm
    public ArrayList<quanlytamtru> findByNoiOTamTru(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where NoiOTamTru=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 
    
    //    //tìm kiếm
    public ArrayList<quanlytamtru> findBymaSoNhanKhau(String MATamTru) throws Exception{
        String query="select * from [TAM TRU] where maSoNhanKhau=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
//        String query="select * from [TAM TRU] where GioiTinh=? or HoTen=? or maTamTru=? or NTNS=? or NoiOTamTru=? or NgayDangKy=? or NgayChuyenDen=? or NgayRoiDi=?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        ArrayList<quanlytamtru> quanlytamtrulist = new ArrayList<quanlytamtru>();
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlshk.getNgaycap());
            ps.setString(1, MATamTru);
//            ps.setString(2, MATamTru);
//            ps.setString(3, MATamTru);
//            ps.setString(4, MATamTru);
//            ps.setString(5, MATamTru);
//            ps.setString(6, MATamTru);
//            ps.setString(7, MATamTru);
//            ps.setString(8, MATamTru);
            
            
          ResultSet rs = ps.executeQuery();
          
          while(rs.next()){
//              SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");// muốn dùng dc date time thì pải có hai dòng này dòng 1
//            String dateNTNS = sdf.format(txtNTNS.getDate());// dòng 2.
//            String dateNgaychuyenden=sdf.format(txtNgaychuyenden.getDate());
//            String dateNgaydangky =sdf.format(txtNgaydangky.getDate());
//            String dateNgayroidi =sdf.format(txtNgayroidi.getDate());
            quanlytamtru qltt = new quanlytamtru();
//            qltt.setSoSHK(Integer.parseInt(txtSoSHK.getText()));
//            qlshk.setNgaycap(date);
//            qlshk.setNoithuongtru(txtNoithuongtru.getText());
//            qlshk.setTenchuho(txtTenchuho.getText());
            qltt.setMaTamTru(rs.getString("mATamTru"));

            qltt.setHoTen(rs.getString("HoTen"));
            qltt.setNTNS(rs.getString("NTNS"));
            qltt.setGioiTinh(rs.getString("GioiTinh"));
             qltt.setNoiOTamTru(rs.getString("NoiOTamTru"));
             qltt.setNgayDangKy(rs.getString("NgayDangKy"));
             qltt.setNgayChuyenDen(rs.getString("NgayChuyenDen"));
             qltt.setNgayRoiDi(rs.getString("NgayRoiDi"));
            qltt.setMaSoNhanKhau(rs.getString("MaSoNhanKhau"));
          


            quanlytamtrulist.add(qltt);
            
          }
            return quanlytamtrulist;

        }
       
        } 




    //// sửa
    public boolean update(quanlytamtru qltt) throws Exception{
        String query="update [TAM TRU]"
                + " SET HoTen = ?, NTNS = ?, GioiTinh = ?, NoiOTamTru = ?, NgayDangKy = ?, NgayChuyenDen = ?, NgayRoiDi = ?, maSoNhanKhau = ?"
                + " where maTamTru = ?";//insert into QUANLYSOHOKHAU(SoSHK,Noithuongtru,Tenchuho,Ngaycap) value(?,?,?,?)
        
        try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement ps = conn.prepareStatement(query))
        {
//            ps.setInt(1, qlshk.getSoSHK());
//            ps.setString(2, qlshk.getNoithuongtru());
//            ps.setString(3, qlshk.getTenchuho());
//            ps.setString(4, qlhk.getNgaycap());
//            DateFormat df = new  SimpleDateFormat("dd-MM-yyy");
//            Date dateNTNS =df.parse(qltt.getNTNS());
            ps.setString(9, qltt.getMaTamTru());
            ps.setString(1, qltt.getHoTen());
            ps.setString(2, qltt.getNTNS());
            ps.setString(3, qltt.getGioiTinh());
            ps.setString(4, qltt.getNoiOTamTru());
            ps.setString(5, qltt.getNgayDangKy());
            ps.setString(6, qltt.getNgayChuyenDen());
            ps.setString(7, qltt.getNgayRoiDi());
            ps.setString(8, qltt.getMaSoNhanKhau());
            
//              ps.setString(1, qltt.getMaTamTru());
//            ps.setString(2, qltt.getHoTen());
//            ps.setDate(3, qltt.getNTNS());
//            ps.setString(4, qltt.getGioiTinh());
//            ps.setString(5, qltt.getNoiOTamTru());
//            ps.setString(6, qltt.getNgayDangKy());
//            ps.setString(7, qltt.getNgayChuyenDen());
//            ps.setString(8, qltt.getNgayRoiDi());
//            ps.setString(9, qltt.getMaSoNhanKhau());
            
          
            return ps.executeUpdate()> 0;

        }
       
        } 
    // XÓA
    
    public boolean Delete(String matamtru) throws Exception{
        
        String query="delete [TAM TRU]"
                + " where maTamTru = ?";
         try (
            Connection conn = new DBContext().getConnection(); // mo ket noi
        PreparedStatement pstmt = conn.prepareStatement(query))
        {

            pstmt.setString(1, matamtru);// cái matamtru này là cái ở trên chỗ delete truyền vào;
          
            return pstmt.executeUpdate()> 0;

        }
    }
}
