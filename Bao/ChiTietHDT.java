import java.util.Scanner;

public class ChiTietHDT {
    private String mahd;
    private String makh;
    private String mave;
    private int soluong;
    static DSVe a;
    private int dongia = Integer.parseInt(a.timkiem(mave).getGiave()) * soluong;


    Scanner sc = new Scanner(System.in);

    public ChiTietHDT() {

    }

    public ChiTietHDT(String mahd, String makh,String mave, int soluong, DSVe a) {
        this.mahd = mahd;
        this.makh = makh;
        this.soluong = soluong;
        this.mave = mave;
        this.a = a;
    }

    public ChiTietHDT(ChiTietHDT a) {
        mahd = a.mahd;
        makh = a.makh;
        mave = a.mave;
        soluong = a.soluong;
        this.a = a.a;
    }

    public void nhap() {
        System.out.println("Nhap ma hoa don: ");
        mahd = sc.nextLine();
        System.out.println("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.println("Nhap ma ve: ");
        mave = sc.nextLine();
        System.out.println("Nhap so luong: ");
        soluong = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.format("%10s | ", mahd);
        System.out.format("%10s |", makh);
        System.out.format("%10s%n", mave);
        System.out.println("Don gia: " + dongia);
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

    public int getDongia() {
        return dongia;
    }
}
