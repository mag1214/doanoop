import java.util.Scanner;

public class VuiChoi {
    private String makhuvuichoi;
    private String diadiem;
    private double chiphi;
    private String ten;
    Scanner scanner =new Scanner (System.in);

    public VuiChoi(){

    }
    public VuiChoi(String makhuvuichoi, String diadiem,String ten, double chiphi) {
        this.makhuvuichoi=makhuvuichoi;
        this.diadiem = diadiem;
        this.ten=ten;
        this.chiphi = chiphi;
    }
    public VuiChoi(VuiChoi vc){
        this.makhuvuichoi=vc.makhuvuichoi;
        this.diadiem=vc.diadiem;
        this.ten=vc.ten;
        this.chiphi=vc.chiphi;
    }


    public String getMakhuvuichoi() {
        return makhuvuichoi;
    }

    public void setMakhuvuichoi(String makhuvuichoi) {
        this.makhuvuichoi = makhuvuichoi;
    }

    public String getDiadiem() {
        return diadiem;
    }

    public void setDiadiem(String diadiem) {
        this.diadiem = diadiem;
    }

    public double getChiphi() {
        return chiphi;
    }

    public void setChiphi(double chiphi) {
        this.chiphi = chiphi;
    }

    public String getTen(){
        return ten;
    }

    public void setTen(String ten){
        this.ten=ten;
    }

    public void nhap (){
        System.out.print("Nhap ma khach san: ");
        makhuvuichoi= scanner.nextLine();

        System.out.print("Nhap dia diem: ");
        diadiem = scanner.nextLine();

        System.out.print("Nhap ten: ");
        ten= scanner.nextLine();

        System.out.print("Nhap chi phi: ");
        chiphi = scanner.nextDouble();

    }

    public void xuat() {
        System.out.format("%10s | ", makhuvuichoi);
        System.out.format("%10s | ", diadiem);
        System.out.format("%10s | ", ten);
        System.out.format("%15s%n", chiphi);
    }
}