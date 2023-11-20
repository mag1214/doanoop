import java.util.Scanner;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class DSCTKH {
    private ChiTietKeHoach [] a;
    private int n;
    Scanner sc= new Scanner (System.in);

    DSCTKH(){}

    DSCTKH(ChiTietKeHoach []a,int n){
        this.a=a;
        this.n=n;
    }

    public void nhap(){
        System.out.print("Nhap n chi tiet ke hoach dau tien: ");
        n = sc.nextInt();
        sc.nextLine();
        a = new ChiTietKeHoach[n];
        for(int i = 0; i < n; i++){
            a[i]= new ChiTietKeHoach();
            a[i].nhap();
        }
    }

    public void xuat() {
        n = a.length;
        System.out.println("Danh sach cac chi tiet ke hoach: ");
        for(int i = 0; i < n; i++) {
            a[i].xuat();
        }
    }

    public void them() {
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new ChiTietKeHoach();
        System.out.println("Nhap thong tin khach hang can them: ");
        a[n].nhap();
        n++;
    }

    public void them(ChiTietKeHoach ctkh){
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new ChiTietKeHoach(ctkh);
        n++;
    }

    public void sua(){
        System.out.print("Nhap ma hoa don can duoc sua: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahoadon().equals(ma)) {
                isExisted = true;
                System.out.print("Ma nha hang duoc sua thanh: ");
                String manh = sc.nextLine();
                a[i].setManhahang(manh);
                System.out.print("Ma khach san duoc sua thanh: ");
                String maks = sc.nextLine();
                a[i].setMakhachsan(maks);
                System.out.print("Ma khu vui choi duoc sua thanh: ");
                String khuvc = sc.nextLine();
                a[i].setMakhuvuichoi(khuvc);
                System.out.print("Ma hoa don duoc sua thanh: ");
                String mahd = sc.nextLine();
                a[i].setMahoadon(mahd);
                System.out.print("Ngay duoc sua thanh: ");
                String ngay=sc.nextLine();
                a[i].setNgay(ngay);
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don !");
    }

    public void sua(String ma) {
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
              if(a[i].getMahoadon().equals(ma)) {
                isExisted = true;
                System.out.print("Ma nha hang duoc sua thanh: ");
                String manh = sc.nextLine();
                a[i].setManhahang(manh);
                System.out.print("Ma khach san duoc sua thanh: ");
                String maks = sc.nextLine();
                a[i].setMakhachsan(maks);
                System.out.print("Ma khu vui choi duoc sua thanh: ");
                String khuvc = sc.nextLine();
                a[i].setMakhuvuichoi(khuvc);
                System.out.print("Ma hoa don duoc sua thanh: ");
                String mahd = sc.nextLine();
                a[i].setMahoadon(mahd);
                System.out.print("Ngay duoc sua thanh: ");
                String ngay=sc.nextLine();
                a[i].setNgay(ngay);
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don !");
    }

    public void timkiem(){
        System.out.print("Nhap ma hoa don muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahoadon().equals(ma)) {
                isExisted = true;
                System.out.println("Thong tin chi tiet ke hoach can tim: ");
                a[i].xuat();
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don!");
    }
    
    public int timkiemma(String ma){
        n = a.length;
        int vitri = -1;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahoadon().equals(ma)) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public ChiTietKeHoach timkiem(String ma){
        n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i].getMahoadon().equals(ma)) {
                return a[i];
            }
        }  
        return null;
    }

    public void timkiemks(){
        System.out.print("Nhap ma khach san muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakhachsan().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach san!");
    }

    public void timkiemks(String ma){
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakhachsan().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach san!");
    }

    public void timkiemnh(){
        System.out.print("Nhap ma nha hang muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getManhahang().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma nha hang!");
    }

    public void timkiemnh(String ma){
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getManhahang().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma nha hang!");
    }

    public void timkiemvc(){
        System.out.print("Nhap ma khu vui choi muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakhuvuichoi().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khu vui choi!");
    }

    public void timkiemvc(String ma){
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakhuvuichoi().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khu vui choi!");
    }
    
    public void xoa(){
        System.out.print("Nhap ma hoa don muon xoa: ");
        String id = sc.nextLine();
        n = a.length;
        int vitri = timkiemma(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma hoa don!");
        else {
            a = Arrays.copyOf(a, n + 2);
            for(int i = vitri; i < n; i++) {
                a[i] = a[i + 1];
            }
            a = Arrays.copyOf(a, n - 1);
            n--;
        }
    }
    
    public void xoa(String id){
        n = a.length;
        int vitri = timkiemma(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma hoa don!");
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
            if (a[i].getTongchiphi() > gioiHanChiphi) {
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
            if (a[i].getTongchiphi() > gioiHanChiphi) {
                a[i].xuat();
            }
        }
        sc.close();
    }
    public void thongKeMaHoaDon() {
        Map<String, Integer> thongKe = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String maHoaDon = a[i].getMahoadon();

            
            if (thongKe.containsKey(maHoaDon)) {
                
                thongKe.put(maHoaDon, thongKe.get(maHoaDon) + 1);
            } else {
                
                thongKe.put(maHoaDon, 1);
            }
        }

        System.out.println("Thong ke ma hoa don:");
        System.out.format("%10s | %15s%n", "Ma Hoa Don", "So Luong");
        for (Map.Entry<String, Integer> entry : thongKe.entrySet()) {
            System.out.format("%10s | %15s%n", entry.getKey(), entry.getValue());
        }
    }
}
