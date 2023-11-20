import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSHDT {
    static HoaDonThu[] a;
    int n;

    Scanner sc = new Scanner(System.in);

    public DSHDT() {
    }

    public DSHDT(int n) {
        this.n = n;
        a = new HoaDonThu[n];
    }

    public void nhap(){
        System.out.print("Nhap n hoa don dau tien: ");
        n = sc.nextInt();
        sc.nextLine();
        a = new HoaDonThu[n];
        for(int i = 0; i < n; i++){
            a[i]= new HoaDonThu();
            a[i].nhap();
        }
    }

    public void xuat() {
        n = a.length;
        System.out.println("Danh sach cac hoa don: ");
        for(int i = 0; i < n; i++) {
            a[i].xuat();
        }
    }

    public void them() {
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new HoaDonThu();
        System.out.println("Nhap thong tin hoa don can them: ");
        a[n].nhap();
        n++;
    }

    public void them(HoaDonThu x){
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new HoaDonThu(x);
        n++;
    }
    
    public void sua(){
        System.out.print("Nhap ma hoa don can duoc sua: ");
        String id = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(id)) {
                isExisted = true;
                System.out.print("Ma hoa don duoc sua thanh: ");
                String mahd = sc.nextLine();
                a[i].setMahd(mahd);
                System.out.print("Ma khach hang duoc sua thanh: ");
                String makh = sc.nextLine();
                a[i].setMakh(makh);
                System.out.print("Ma nhan vien duoc sua thanh: ");
                String manv = sc.nextLine();
                a[i].setManv(manv);
                System.out.print("Ngay mua duoc sua thanh: ");
                String ngaymua = sc.nextLine();
                a[i].setNgaymua(ngaymua);
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don!");
    }

    public void sua(String id) {
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(id)) {
                isExisted = true;
                System.out.print("Ma hoa don duoc sua thanh: ");
                String mahd = sc.nextLine();
                a[i].setMahd(mahd);
                System.out.print("Ma khach hang duoc sua thanh: ");
                String makh = sc.nextLine();
                a[i].setMakh(makh);
                System.out.print("Ma nhan vien duoc sua thanh: ");
                String manv = sc.nextLine();
                a[i].setManv(manv);
                System.out.print("Ngay mua duoc sua thanh: ");
                String ngaymua = sc.nextLine();
                a[i].setNgaymua(ngaymua);
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don!");
    }
    
    public void timkiem(){
        System.out.print("Nhap ma hoa don muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(ma)) {
                isExisted = true;
                System.out.println("Thong tin hoa don can tim: ");
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
            if(a[i].getMahd().equals(ma)) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public HoaDonThu timkiem(String ma){
        n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i].getMahd().equals(ma)) {
                return a[i];
            }
        }  
        return null;
    }
    
    public void timkiemkh(){
        System.out.print("Nhap ma khach hang co hoa don muon tim: ");
        String makh = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakh().equals(makh)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach hang!");
    }

    public void timkiemkh(String makh){
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakh().equals(makh)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach hang!");
    }

    public void timkiemnv(){
        System.out.print("Nhap ma nhan vien thu tien hoa don muon tim: ");
        String manv = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getManv().equals(manv)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma nhan vien!");
    }

    public void timkiemnv(String manv) {
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getManv().equals(manv)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma nhan vien!");
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

    public void writeDataToFile() throws IOException {
        n = a.length;
        DataOutputStream out = new DataOutputStream(new FileOutputStream("datakh.txt"));
        for(int i = 0; i < n; i++) {
            out.writeUTF(a[i].getMahd());
            out.writeUTF(a[i].getMakh());
            out.writeUTF(a[i].getNgaymua());
            out.writeUTF(a[i].getManv());
        }
        out.close();
    }

    public void readDataFromFile() {
        a = new HoaDonThu[500];
        int i = 0;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("datakh.txt"));
            try {
                while(true) {
                    a[i] = new HoaDonThu();
                    a[i].setMahd(in.readUTF());
                    a[i].setMakh(in.readUTF());
                    a[i].setNgaymua(in.readUTF());
                    a[i].setManv(in.readUTF());
                    i++;
                }
            } catch (EOFException e) {

            } finally {
                n = i;
                a = Arrays.copyOf(a, n);
                in.close();
            }
        } catch (IOException e) {
       
        }
    }
}
