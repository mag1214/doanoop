import java.util.Scanner;
public class NhaHang {
    private String manhahang;
    private String diadiem;
    private double chiphi;
    private String ten;
    Scanner scanner =new Scanner (System.in);
    public NhaHang(){

    }
    public NhaHang(String manhahang, String diadiem, double chiphi,String ten) {
        this.manhahang = manhahang;
        this.diadiem = diadiem;
        this.chiphi = chiphi;
        this.ten=ten;
    }
    public NhaHang(NhaHang nh){
        manhahang=nh.manhahang;
        diadiem=nh.diadiem;
        chiphi=nh.chiphi;
        ten=nh.ten;
    }

    public String getManhahang() {
        return manhahang;
    }

    public void setMaNhaHang(String manhahang) {
        this.manhahang = manhahang;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiaDiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public double getChiPhi() {
        return chiphi;
    }

    public void setChiPhi(double chiphi) {
        this.chiphi = chiphi;
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten=ten;
    }

    public void nhap (){
        System.out.print("Nhap ma nha hang: ");
        manhahang= scanner.nextLine();

        System.out.print("Nhap dia diem: ");
        diadiem = scanner.nextLine();

        System.out.print("Nhap ten : ");
        ten= scanner.nextLine();

        System.out.print("Nhap chi phi: ");
        chiphi = scanner.nextDouble();

    }

    public void xuat() {
        System.out.format("%10s | ", manhahang);
        System.out.format("%10s | ", diadiem);
        System.out.format("%10s | ",ten);
        System.out.format("%15s%n", chiphi);
    }
}
