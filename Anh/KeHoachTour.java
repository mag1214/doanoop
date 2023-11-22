import java.util.Scanner;
public class KeHoachTour
{
    private String MaKeHoach, MaTour, MaNhanVien, NgayDi, NgayVe;

    Scanner sc = new Scanner(System.in);
    public KeHoachTour(){}
    public KeHoachTour(String MaKeHoach, String MaTour, String MaNhanVien, String NgayDi, String NgayVe)
    {
        this.MaKeHoach=MaKeHoach;
        this.MaTour=MaTour;
        this.MaNhanVien=MaNhanVien;
        this.NgayDi=NgayDi;
        this.NgayVe=NgayVe;
    }
    public KeHoachTour(KeHoachTour kh)
    {
        MaKeHoach=kh.MaKeHoach;
        MaTour=kh.MaTour;
        MaNhanVien=kh.MaNhanVien;
        NgayDi=kh.NgayDi;
        NgayVe=kh.NgayVe; 
    }
    public String getMaKeHoach()
    {
        return MaKeHoach;
    }
    public void setMaKeHoach(String MaKeHoach)
    {
        this.MaKeHoach=MaKeHoach;
    }
    public String getMaTour()
    {
        return MaTour;
    }
    public void setMaTour(String MaTour)
    {
        this.MaTour=MaTour;
    }
    public String getMaNhanVien()
    {
        return MaNhanVien;
    }
    public void setMaNhanVien(String MaNhanVien)
    {
        this.MaNhanVien=MaNhanVien;
    }
    public String getNgaydi()
    {
        return NgayDi;
    }
    public void setNgaydi(String NgayDi)
    {
        this.NgayDi=NgayDi;
    }
     public String getNgayVe()
    {
        return NgayVe;
    }
    public void setNgayVe(String NgayVe)
    {
        this.NgayVe=NgayVe;
    }
    public void Nhap()
    {
        System.out.print("Nhap ma ke hoach: ");
        MaKeHoach=sc.nextLine();
        System.out.print("Nhap ma tour: ");
        MaTour=sc.nextLine();
        System.out.print("Nhap ma nhan vien tour: ");
        MaNhanVien=sc.nextLine();
        System.out.print("Nhap ngay di: ");
        NgayDi=sc.nextLine();
        System.out.print("Nhap ngay ve: ");
        NgayVe=sc.nextLine();
    }
    public void Xuat()
    {
        System.out.println("Ma ke hoach: "+MaKeHoach);
        System.out.println("Ten tour: "+MaTour);
        System.out.println("Noi khoi hanh: "+MaNhanVien);
        System.out.println("Ngay di: "+NgayDi);
        System.out.println("Ngay ve: "+NgayVe);
    }
}