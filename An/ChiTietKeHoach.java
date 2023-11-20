import java.util.Scanner;

public class ChiTietKeHoach{
    private String manhahang;
    private String makhachsan;
    private String makhuvuichoi;
    private String mahoadon;
    private double tongchiphi;
    private String ngay;
    private NhaHang nh;
    private KhachSan ks;
    private VuiChoi vc;

    Scanner sc= new Scanner(System.in);

    public ChiTietKeHoach(){}

    public ChiTietKeHoach(String manhahang, String makhachsan, String makhuvuichoi, String mahoadon,double tongchiphi,String ngay,NhaHang nh,KhachSan ks,VuiChoi vc){
        this.manhahang=manhahang;
        this.makhachsan=makhachsan;
        this.makhuvuichoi=makhuvuichoi;
        this.mahoadon=mahoadon;
        this.tongchiphi=tongchiphi;
        this.ngay=ngay;
        this.nh=nh;
        this.ks=ks;
        this.vc=vc;
        tinhtongchiphi();
    }
    

    public ChiTietKeHoach(ChiTietKeHoach CTKH){
        this.manhahang=CTKH.manhahang;
        this.makhachsan=CTKH.makhachsan;
        this.makhuvuichoi=CTKH.makhuvuichoi;
        this.mahoadon=CTKH.mahoadon;
        this.ngay=CTKH.ngay;
        this.nh=CTKH.nh;
        this.ks=CTKH.ks;
        this.vc=CTKH.vc;
        tinhtongchiphi();
    }

    private void tinhtongchiphi() {
        this.tongchiphi = 0.0;
        if (nh != null) {
            this.tongchiphi += nh.getChiPhi();
        }
        if (vc != null) {
            this.tongchiphi += vc.getChiphi();
        }
        if (ks != null) {
            this.tongchiphi += ks.getChiphi();
        }
    }


    public String getManhahang() {
        return manhahang;
    }

    public void setManhahang(String manhahang) {
        this.manhahang = manhahang;
    }

    public String getMakhachsan() {
        return makhachsan;
    }

    public void setMakhachsan(String makhachsan) {
        this.makhachsan = makhachsan;
    }

    public String getMakhuvuichoi() {
        return makhuvuichoi;
    }

    public void setMakhuvuichoi(String makhuvuichoi) {
        this.makhuvuichoi = makhuvuichoi;
    }

    public String getMahoadon(){
        return mahoadon;
    }

    public void setMahoadon(String mahoadon){
        this.mahoadon=mahoadon;
    }

    public Double getTongchiphi(){
        return tongchiphi;
    }

    public void setTongchiphi(Double tongchiphi){
        this.tongchiphi=tongchiphi;
    }

    public String getNgay(){
        return ngay;
    }

    public void setNgay(String ngay){
        this.ngay=ngay;
    }

    public void nhap() {
        System.out.print("Nhap ma nha hang: ");
        manhahang = sc.nextLine();
        System.out.print("Nhap ma khach san: ");
        makhachsan = sc.nextLine();
        System.out.print("Nhap ma khu vui choi: ");
        makhuvuichoi = sc.nextLine();
        System.out.print("Nhap ma hoa don: ");
        mahoadon = sc.nextLine();
        System.out.print("Nhap ngay :");
        ngay=sc.nextLine();
    }

    public void xuat() {
        System.out.format("%10s | ", manhahang);
        System.out.format("%10s | ", makhachsan);
        System.out.format("%10s | ",makhuvuichoi);
        System.out.format("%10s | ", mahoadon);
        System.out.format("%10s | ", tongchiphi);
        System.out.format("%15s%n", ngay);
    }
}