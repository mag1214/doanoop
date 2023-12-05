import java.util.Scanner;

public class ChiTietHDT {
    private String mahd;
    private String mave;
    private int soluong;
    DSVe ve;
    private int dongia = Integer.parseInt(ve.timkiem(mave).getGiave()) * soluong;

    DSHDT hd;

    Scanner sc = new Scanner(System.in);

    public ChiTietHDT() {
        
    }   

    public ChiTietHDT(String mahd,String mave, int soluong) {
        this.mahd = mahd;
        this.soluong = soluong;
        this.mave = mave;
    }

    public ChiTietHDT(ChiTietHDT a) {
        mahd = a.mahd;
        mave = a.mave;
        soluong = a.soluong;
    }

    public void nhap() {
        System.out.println("Nhap ma hoa don: ");
        mahd = sc.nextLine();
        while(true) {
            hd.readDataFromFile();
            if(hd.timkiemma(mahd) != -1) {
                break;
            }
            System.err.println("Ma hoa don vua nhap khong ton tai!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            hd.xuat();
            System.out.println("Nhap lai ma hoa don:");
            String id = sc.nextLine();
            setMahd(id);
        }
        System.out.println("Nhap ma ve: ");
        mave = sc.nextLine();
        while(true) {
            ve.readDataFromFile();
            if(ve.timkiemma(mave) != -1) {
                break;
            }
            System.err.println("Ma ve vua nhap khong ton tai!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            ve.xuat();
            System.out.println("Nhap lai ma ve:");
            String id = sc.nextLine();
            setMave(id);
        }
        System.out.println("Nhap so luong: ");
        soluong = sc.nextInt();
        sc.nextLine();
    }

    public void xuat() {
        System.out.format(" %10s | %10s | %8s | %15s ||\n", mahd, mave, soluong, dongia);
    }

    public void setMahd(String mahd) {
        this.mahd = mahd;
    }

    public String getMahd() {
        return mahd;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMave() {
        return mave;
    }

    public void setSoluong(int soluong) {
        this.soluong = soluong;
    }

    public int getSoluong() {
        return soluong;
    }
    
    public int getDongia() {
        return dongia;
    }
}
