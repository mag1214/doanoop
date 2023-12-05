import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DSChiTietHDT {
    static ChiTietHDT[] a;
    int n;

    Scanner sc = new Scanner(System.in);

    public DSChiTietHDT() {

    }

    public DSChiTietHDT(int n) {
        this.n = n;
        a = new ChiTietHDT[n];
    }

    public void changeIdVe(String maveCu, String maveMoi) {
        for(int i = 0; i < n; i++) {
            if(a[i].getMave().equals(maveCu)) {
                a[i].setMave(maveMoi);
            }
        }
    }

    public void changeIdHd(String mahdCu, String mahdMoi) {
        for(int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(mahdCu)) {
                a[i].setMahd(mahdMoi);
            }
        }
    }

    public void nhap() throws IOException{
        System.out.print("Nhap n chi tiet hoa don dau tien: ");
        n = sc.nextInt();
        sc.nextLine();
        a = new ChiTietHDT[n];
        for(int i = 0; i < n; i++){
            a[i]= new ChiTietHDT();
            a[i].nhap();
        }
        writeDataToFile();
    }

    public void xuat() {
        System.out.println("----------------------------Danh sach chi tiet hoa don----------------------------");
        System.out.println("----------------------------------------------------------------------------------");
		System.out.format("|| %5s | %10s | %10s | %8s | %15s ||\n", "Stt", "Ma hoa don", "Ma ve", "So luong", "Don gia");
        for(int i = 0; i < n; i++) {
            System.out.format("|| %5d |", i + 1);
            a[i].xuat();
        }
    }

    public void them() throws IOException{
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new ChiTietHDT();
        System.out.println("Nhap thong tin chi tiet hoa don can them: ");
        a[n].nhap();
        n++;
        writeDataToFile();
    }

    public void them(ChiTietHDT x) throws IOException{
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new ChiTietHDT(x);
        n++;
        writeDataToFile();
    }
    
    public void sua() throws IOException{
        System.out.print("Nhap ma hoa don can duoc sua: ");
        String id = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(id)) {
                isExisted = true;
                a[i].nhap();
                writeDataToFile();
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don!");
    }

    public void sua(String id) throws IOException{
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(id)) {
                isExisted = true;
                a[i].nhap();
                writeDataToFile();
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
                System.out.println("Thong tin chi tiet hoa don can tim: ");
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
    
    public ChiTietHDT timkiem(String ma){
        n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i].getMahd().equals(ma)) {
                return a[i];
            }
        }  
        return null;
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

    public int tongtien(String mahd) {
        int sum = 0;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if(a[i].getMahd().equals(mahd))
                sum += a[i].getDongia();
        }
        return sum;
    }

    public void writeDataToFile() throws IOException {
        n = a.length;
        DataOutputStream out = new DataOutputStream(new FileOutputStream("dataCtHdt.txt"));
        for(int i = 0; i < n; i++) {
            out.writeUTF(a[i].getMahd());
            out.writeUTF(a[i].getMave());
            out.writeInt(a[i].getSoluong());
        }
        out.close();
    }

    public void readDataFromFile() {
        a = new ChiTietHDT[500];
        int i = 0;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("dataCtHdt.txt"));
            try {
                while(true) {
                    a[i] = new ChiTietHDT();
                    a[i].setMahd(in.readUTF());
                    a[i].setMave(in.readUTF());
                    a[i].setSoluong(in.readInt());
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

    //Menu quan li

    public void showMenu() {
        System.out.println("---------------Option---------------");
        System.out.println("1. Them chi tiet hoa don.");
        System.out.println("2. Xoa chi tiet hoa don.");
        System.out.println("3. Sua thong tin chi tiet hoa don.");
        System.out.println("4. Tim kiem chi tiet hoa don.");
        System.out.println("5. Xem danh sach chi tiet hoa don.");
        System.out.println("0. Thoat.");
        System.out.println("------------------------------------");
        System.out.print("Choose: ");
    }

    public void Menu() throws IOException {
        String choose = null;
        boolean exit = false;
        showMenu();
        while (true) {
            choose = sc.nextLine();
            switch (choose) {
            case "1":
                them();
                break;
            case "2":
                xoa();
                break;
            case "3":
                sua();
                break;
            case "4":
                timkiem();
                break;
            case "5":
                xuat();
                break;
            case "0":
                System.out.println("Da thoat!");
                exit = true;
                break;
            default:
                System.err.println("Loi! Hay chon lai:");
                break;
            }
            if (exit) {
                break;
            }
            showMenu();
        }
    }
}
