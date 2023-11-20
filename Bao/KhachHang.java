import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Scanner;

public class KhachHang implements Serializable {
    private String ma;
    private String ho;
    private String ten;
    private String phai;
    private String ngaysinh;

    transient Scanner sc = new Scanner(System.in);

    public KhachHang() {

    }

    public KhachHang(String ma, String ho, String ten, String phai, String ngaysinh) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
    }

    public KhachHang(KhachHang a) {
        ma = a.ma;
        ho = a.ho;
        ten = a.ten;
        phai = a.phai;
        ngaysinh = a.ngaysinh;
    }

    public void nhap() {
        System.out.print("Nhap ma khach hang: ");
        ma=sc.nextLine();
        System.out.print("Nhap ho: ");
        ho=sc.nextLine();
        System.out.print("Nhap ten:");
        ten=sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        phai=sc.nextLine();
        System.out.print("Nhap ngay sinh: ");
        ngaysinh=sc.nextLine();
    }

    public void xuat() {
        System.out.format("%13s | ", ma);
        System.out.format("%10s | ", ho);
        System.out.format("%15s | ",ten);
        System.out.format("%5s | ", phai);
        System.out.format("%10s%n", ngaysinh);
    }

    public int getTuoi() {
        String[] tach = ngaysinh.split("/");
        String nam = tach[tach.length-1];
        int namsinh = Integer.parseInt(nam);
        Calendar a = Calendar.getInstance();
        int namhientai = a.get(Calendar.YEAR);
        int tuoi = namhientai - namsinh;
        return tuoi;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getMa() {
        return ma;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getHo() {
        return ho;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTen() {
        return ten;
    }

    public void setPhai(String phai) {
        this.phai = phai;
    }

    public String getPhai() {
        return phai;
    }

    public void setNgaysinh(String ngaysinh) {
        this.ngaysinh = ngaysinh;
    }

    public String getNgaysinh() {
        return ngaysinh;
    }

    @Override
    public String toString() {
        return ma + "\t" + ho + "\t" + ten + "\t" + phai + "\t" + ngaysinh;
    }
}
