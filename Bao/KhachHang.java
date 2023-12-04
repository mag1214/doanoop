import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class KhachHang {
    private String ma;
    private String ho;
    private String ten;
    private String phai;
    private String ngaysinh;
    private String sdt;

    transient Scanner sc = new Scanner(System.in);

    public KhachHang() {

    }

    public KhachHang(String ma, String ho, String ten, String phai, String ngaysinh, String sdt) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.phai = phai;
        this.ngaysinh = ngaysinh;
        this.sdt = sdt;
    }

    public KhachHang(KhachHang a) {
        ma = a.ma;
        ho = a.ho;
        ten = a.ten;
        phai = a.phai;
        ngaysinh = a.ngaysinh;
        sdt = a.sdt;
    }

    public void nhap() {
        System.out.print("Nhap ma khach hang: ");
        ma = sc.nextLine();
        System.out.print("Nhap ho: ");
        ho = sc.nextLine();
        System.out.print("Nhap ten:");
        ten = sc.nextLine();
        System.out.print("Nhap gioi tinh: ");
        phai = sc.nextLine();
        while(true) {
            if(phai.equals("Nam") || phai.equals("Nu")) {
                break;
            }
            System.err.println("Gioi tinh chi duoc nhap 'Nam' hoac 'Nu'!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            System.out.println("Nhap lai gioi tinh cua khach hang: ");
            String gt = sc.nextLine();
            setPhai(gt);
        }
        System.out.print("Nhap ngay sinh: ");
        ngaysinh = sc.nextLine();
        while(true) {
            if(checkDate(ngaysinh)) {
                break;
            }
            System.err.println("Dinh dang cua ngay phai la dd/MM/yyyy!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            System.out.println("Nhap lai ngay sinh cua khach hang: ");
            String ns = sc.nextLine();
            setNgaysinh(ns);
        }
        System.out.print("Nhap so dien thoai: ");
        sdt = sc.nextLine();
        while(true) {
            if(sdt.length() == 10) {
                break;
            }
            System.err.println("So dien thoai khong du 10 so!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            System.out.println("Nhap lai so dien thoai cua khach hang: ");
            String dt = sc.nextLine();
            setSdt(dt);
        }
    }

    public void xuat() {
        System.out.format(" %10s | %8s | %20s | %10s | %9s | %11s ||\n", ma, ho, ten, ngaysinh, phai, sdt);
    }

    public boolean checkDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
		try {
			sdf.parse(date);
		}catch(ParseException e) {
			return false;
		}
		return true;
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

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getSdt() {
        return sdt;
    }
}
