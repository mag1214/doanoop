import java.util.Scanner;

public class Ve {
    private String mave;
    private String matour;
    private String loaive;
    private String giave;
    DanhSachTour tour;

    Scanner sc = new Scanner(System.in);

    public Ve() {

    }

    public Ve(String mave, String matour, String loaive, String giave) {
        this.mave = mave;
        this.matour = matour;
        this.loaive = loaive;
        this.giave = giave;
    }

    public Ve(Ve v1) {
        mave = v1.mave;
        matour = v1.matour;
        loaive = v1.loaive;
        giave = v1.giave;
    }

    public void nhap() {
        System.out.print("Nhap ma tour: ");
        matour = sc.nextLine();
        while(true) {
            tour.DocDuLieuTuFile();
            if(tour.TimKiemMaTour(matour) != -1) {
                break;
            }
            System.err.println("Ma tour vua nhap khong ton tai!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            tour.Xuat();
            System.out.println("Nhap lai ma tour:");
            String id = sc.nextLine();
            setMatour(id);
        }
        System.out.print("Nhap ma ve: ");
        mave = sc.nextLine();
        System.out.print("Nhap loai ve: ");
        loaive = sc.nextLine();
        while(true) {
            if(loaive.equals("Tre em") || loaive.equals("Nguoi Lon")) {
                break;
            }
            System.err.println("Chi co ve 'Nguoi lon' va 'Tre em'!!!");
            System.err.println("Nhan Enter de nhap lai!!!");
            sc.nextLine();
            System.out.println("Nhap lai loai ve: ");
            String lv = sc.nextLine();
            setLoaive(lv);
        }
        System.out.print("Nhap gia ve: ");
        giave = sc.nextLine();
    }

    public void xuat() {
        System.out.format(" %10s | %10s | %10s | %15s ||\n", matour, mave, loaive, giave);
    }

    public void setMatour(String matour) {
        this.matour = matour;
    }

    public String getMatour() {
        return matour;
    }

    public void setMave(String mave) {
        this.mave = mave;
    }

    public String getMave() {
        return mave;
    }

    public void setLoaive(String loaive) {
        this.loaive = loaive;
    }

    public String getLoaive() {
        return loaive;
    }

    public void setGiave(String giave) {
        this.giave = giave;
    }

    public String getGiave() {
        return giave;
    }
}