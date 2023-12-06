package Main;

import Class.DanhSachTour;
import Class.Tour;
import Class.TourNgoaiNuoc;

public class test {
    public static void main(String [] args)
    {
        DanhSachTour ds = new DanhSachTour();
        
        ds.NhapCung();
        TourNgoaiNuoc  tnc = new TourNgoaiNuoc("T3", "ád", "ádasd", "sad", "fsd", "fds", "fsd");
        ds.Them(tnc);
        ds.Xuat();
    }
}
