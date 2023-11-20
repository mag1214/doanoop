import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class DSKS {
    private KhachSan[]a;
    private int n;
    Scanner sc= new Scanner (System.in);
    
    public DSKS(){

    }

    public DSKS(KhachSan[] a,int n){
        this.a=a;
        this.n=n;
    }
    public void xuat() {
        n = a.length;
        System.out.println("Danh sach cac khách sạn : ");
        for(int i = 0; i < n; i++) {
            a[i].xuat();
        }
    }
    public void them() {
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new KhachSan();
        System.out.println("Nhap thong tin khach san can them: ");
        a[n].nhap();
        n++;
    }
    public void them(KhachSan ks){
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new KhachSan(ks);
        n++;
    }
    public void sua(){
        System.out.print("Nhap ma khach san can duoc sua: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMakhachsan().equals(ma)) {
                isExisted = true;
                System.out.print("Ma khach san duoc sua thanh: ");
                String maks = sc.nextLine();
                a[i].setMakhachsan(maks);
                System.out.print("Dia diem duoc sua thanh: ");
                String diadien = sc.nextLine();
                a[i].setDiadiem(diadien);
                System.out.print("ten duoc sua thanh: ");
                String ten= sc.nextLine();
                a[i].setTen(ten);
                System.out.print("Chi phi duoc sua thanh ");
                Double chiphi = sc.nextDouble();
                a[i].setChiphi(chiphi);;
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach san!");
    }

    public void sua(String ma) {
        boolean isExisted = false;
        n = a.length;
         for (int i = 0; i < n; i++) {
            if(a[i].getMakhachsan().equals(ma)) {
                isExisted = true;
                System.out.print("Ma khach san duoc sua thanh: ");
                String maks = sc.nextLine();
                a[i].setMakhachsan(maks);
                System.out.print("Dia diem duoc sua thanh: ");
                String diadien = sc.nextLine();
                a[i].setDiadiem(diadien);
                System.out.print("ten duoc sua thanh: ");
                String ten= sc.nextLine();
                a[i].setTen(ten);
                System.out.print("Chi phi duoc sua thanh ");
                Double chiphi = sc.nextDouble();
                a[i].setChiphi(chiphi);;
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach san!");
    }
    public void timkiem(){
        System.out.print("Nhap ma khach san don muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMakhachsan().equals(ma)) {
                isExisted = true;
                System.out.println("Thong tin khach san can tim: ");
                a[i].xuat();
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach san!");
    }
    
    public int timkiemma(String ma){
        n = a.length;
        int vitri = -1;
        for (int i = 0; i < n; i++) {
            if(a[i].getMakhachsan().equals(ma)) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public KhachSan timkiem(String ma){
        n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i].getMakhachsan().equals(ma)) {
                return a[i];
            }
        }  
        return null;
    }
    public void xoa(){
        System.out.print("Nhap ma khach san muon xoa: ");
        String id = sc.nextLine();
        n = a.length;
        int vitri = timkiemma(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma khach san!");
        else {
            a = Arrays.copyOf(a, n + 2);
            for(int i = vitri; i < n; i++) {
                a[i] = a[i + 1];
            }
            a = Arrays.copyOf(a, n - 1);
            n--;
        }
    }
    
    public void xoa(String ma){
        n = a.length;
        int vitri = timkiemma(ma);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma khach san !");
        else {
            a = Arrays.copyOf(a, n + 2);
            for(int i = vitri; i < n; i++) {
                a[i] = a[i + 1];
            }
            a = Arrays.copyOf(a, n - 1);
            n--;
        }
    }
    public void timKiemChiPhiLonHon(double gioiHanChiphi) {
        System.out.format("Cac khu vui choi co chi phi lon hon %.2f:%n", gioiHanChiphi);
        System.out.format("%10s | %10s | %10s | %15s%n", "Ma Khu", "Dia Diem", "Ten", "Chi Phi");
        for (int i = 0; i < n   ; i++) {
            if (a[i].getChiphi() > gioiHanChiphi) {
                a[i].xuat();
            }
        }
    }
    public void timKiemChiPhiLonHon() {
        System.out.print("Nhap gioi han chi phi tu ban phim: ");
        double gioiHanChiphi = sc.nextDouble();

        System.out.format("Cac khu vui choi co chi phi lon hon %.2f:%n", gioiHanChiphi);
        System.out.format("%10s | %10s | %10s | %15s%n", "Ma Khu", "Dia Diem", "Ten", "Chi Phi");
        for (int i = 0; i < n; i++) {
            if (a[i].getChiphi() > gioiHanChiphi) {
                a[i].xuat();
            }
        }
        sc.close();
    }
    public void thongKeTen() {
        Map<String, Integer> thongKe = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String ten =a[i].getTen();

            if (thongKe.containsKey(ten)) {
                thongKe.put(ten, thongKe.get(ten) + 1);
            } else {
                thongKe.put(ten, 1);
            }
        }

        System.out.println("Thong ke ten cac khu vui choi:");
        System.out.format("%10s | %15s%n", "Ten", "So Luong");
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            System.out.format("%10s | %15s%n", entry.getKey(), entry.getValue());
        }
    }
    public void thongke_Ma_lonhon_7() {
        Map<String, Integer> thongKe = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String ma = a[i].getMakhachsan();

            if (thongKe.containsKey(ma)) {

                thongKe.put(ma, thongKe.get(ma) + 1);

            } else {
                thongKe.put(ma, 1);
            }
        }

        System.out.println("Thong ke ma khu vui choi:");
        System.out.format("%10s | %15s%n", "Ma Khu", "So Luong");
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            if (entry.getValue() >= 7) {
                System.out.format("%10s | %15s%n", entry.getKey(), entry.getValue());
            }
        }
    }
    public void timKiemTheoTen(String tenCanTim) {
        System.out.println("Ket qua tim kiem theo ten: " + tenCanTim);
        System.out.format("%10s | %10s | %10s | %15s%n", "Ma ", "Dia Diem", "Ten", "Chi Phi");
        boolean result = false;
        
        for (int i = 0; i < n; i++) {
            if (a[i].getTen().equalsIgnoreCase(tenCanTim)) {
                a[i].xuat();
                result = true;
            }
        }

        if (!result) {
            System.out.println("Khong tim thay ket qua cho ten: " + tenCanTim);
        }
    }
}

