import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class HoaDonThu {
    private String mahd;
    private String makh;
    private String ngaymua;
    private String manv;
    static DSChiTietHDT a;
    private int tonggia = a.tongtien(makh);

    Scanner sc = new Scanner(System.in);

    public HoaDonThu() {

    }

    public HoaDonThu(String mahd, String makh, String ngaymua, String manv) {
        this.mahd = mahd;
        this.makh = makh;
        this.ngaymua = ngaymua;
        this.manv = manv;
    }

    public HoaDonThu(HoaDonThu a) {
        mahd = a.mahd;
        makh = a.makh;
        ngaymua = a.ngaymua;
        manv = a.manv;
    }

    public void nhap() {
        System.out.print("Nhap ma hoa don: ");
        mahd = sc.nextLine();
        System.out.print("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.print("Nhap ngay mua:");
        ngaymua = sc.nextLine();
        while(true) {
            if(checkDate(ngaymua)) {
                break;
            }
            System.err.println("Dinh dang cua ngay phai la dd/MM/yyyy!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            System.out.println("Nhap lai ngay mua: ");
            String nm = sc.nextLine();
            setNgaymua(nm);
        }
        System.out.print("Nhap ma nhan vien: ");
        manv = sc.nextLine();
    }

    public void xuat() {
        System.out.format(" %10s | %13s | %12s | %10s | %15s ||\n", mahd, makh, manv, ngaymua, tonggia); 
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

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMakh() {
        return makh;
    }

    public void setManv(String manv) {
        this.manv = manv;
    }

    public String getManv() {
        return manv;
    }

    public void setNgaymua(String ngaymua) {
        this.ngaymua = ngaymua;
    }

    public String getNgaymua() {
        return ngaymua;
    }

    public int getTonggia() {
        return tonggia;
    }
}
