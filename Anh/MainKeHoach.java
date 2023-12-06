package Main;


import Class.DanhSachKeHoachTour;
import Class.DanhSachTour;
public class MainKeHoach {
    public static void main(String [] args)
    {
        DanhSachTour dst = new DanhSachTour();
        DanhSachKeHoachTour ds = new DanhSachKeHoachTour();
       // ds.Nhap();
        //ds.DocDuLieuTuFile();
        //ds.GhiDuLieuVaoFile();
        dst.NhapCung();
        ds.DuLieuCung();
        ds.TimKiemNamToChuc();
        ds.Xuat();
    }
    
    
}
