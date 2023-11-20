import java.util.Scanner;

public class Ve {
    private String makh;
    private String mave;
    private String matour;
    private String loaive;
    private String giave;

    Scanner sc = new Scanner(System.in);

    public Ve() {

    }

    public Ve(String makh, String mave, String matour, String loaive, String giave) {
        this.makh = makh;
        this.mave = mave;
        this.matour = matour;
        this.loaive = loaive;
        this.giave = giave;
    }

    public Ve(Ve v1) {
        makh = v1.makh;
        mave = v1.mave;
        matour = v1.matour;
        loaive = v1.loaive;
        giave = v1.giave;
    }

    public void nhap() {
        System.out.print("Nhap ma khach hang: ");
        makh = sc.nextLine();
        System.out.print("Nhap ma tour: ");
        matour = sc.nextLine();
        System.out.print("Nhap ma ve: ");
        mave = sc.nextLine();
        System.out.print("Nhap loai ve: ");
        loaive = sc.nextLine();
        System.out.print("Nhap gia ve: ");
        giave = sc.nextLine();
    }

    public void xuat() {
        System.out.format("%10s | ", makh);
        System.out.format("%10s | ", mave);
        System.out.format("%10s | ",matour);
        System.out.format("%10s | ", loaive);
        System.out.format("%15s%n", giave);
    }

    public void setMakh(String makh) {
        this.makh = makh;
    }

    public String getMakh() {
        return makh;
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