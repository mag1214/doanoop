import java.util.Scanner;

public class HoaDonChi {

    private String makhachhang;
    private String makehoachtua;
    private String manhanvien;
    private String mahoadon;
    private double tongchiphi;
    Scanner sc = new Scanner(System.in);
    public HoaDonChi()
    {

    }
    public HoaDonChi(String mahoadon,String makhachhang, String makehoachtua, String manhanvien)
    {
        this.mahoadon = mahoadon;
        this.makhachhang = makhachhang;
        this.makehoachtua = makehoachtua;
        this.manhanvien = manhanvien;
    }
    public HoaDonChi(HoaDonChi hdc)
    {
        this.mahoadon = hdc.mahoadon;
        this.makhachhang = hdc.makhachhang;
        this.makehoachtua = hdc.makehoachtua;
        this.manhanvien = hdc.manhanvien;
    }
    public String getMaHoaDon()
    {
        return mahoadon;
    }
    public void setMahoadon(String mahoadon)
    {
        this.mahoadon = mahoadon;
    }
    public String getMaKhachHang()
    {
        return makhachhang;
    }
    public void setMakhachhang(String makhachhang)
    {
        this.makhachhang = makhachhang;
    }
    public String getMaKeHoachTua()
    {
        return makehoachtua;
    }
    public void setMakehoachtua(String makehoachtua)
    {
        this.makehoachtua = makehoachtua;
    }
    public String getMaNhanVien()
    {
        return manhanvien;
    }
    public void setManhanvien(String manhanvien)
    {
        this.manhanvien = manhanvien;
    }
     public static void setTongchiphi(double tongchiphi2) {
    }

    public void nhap()
    {
        System.out.print("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        makhachhang = sc.nextLine();
        System.out.print("Nhap ma ke hoach tua: ");
        makehoachtua = sc.nextLine();
        System.out.print("Nhap ma nhan vien: ");
        manhanvien = sc.nextLine();

    }
    public void xuat()
    {
        System.out.format("%12s | ", mahoadon);
        System.out.format("%13s | ", makhachhang);
        System.out.format("%13s | ", makehoachtua);
        System.out.format("%13s%n ", manhanvien);
        System.out.format("%15s%n", tongchiphi);  // Hiển thị tổng chi phí
    }
}
