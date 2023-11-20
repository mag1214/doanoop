import java.util.Arrays;
import java.util.Scanner;

public class DSVe {
    static Ve[] a;
    int n;

    Scanner sc = new Scanner(System.in);

    public DSVe(){

    }

    public DSVe(Ve[] a, int n){
        this.a=a;
        this.n=n;
    }

    public void nhap(){
        System.out.print("Nhap n ve dau tien: ");
        n = sc.nextInt();
        sc.nextLine();
        a = new Ve[n];
        for(int i = 0; i < n; i++){
            a[i]= new Ve();
            a[i].nhap();
        }
    }

    public void xuat() {
        n = a.length;
        System.out.println("Danh sach cac ve: ");
        for(int i = 0; i < n; i++) {
            a[i].xuat();
        }
    }

    public void them() {
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new Ve();
        System.out.println("Nhap thong tin ve can them: ");
        a[n].nhap();
        n++;
    }

    public void them(Ve x){
        n = a.length;
        a = Arrays.copyOf(a, n + 1);
        a[n] = new Ve(x);
        n++;
    }
    
    public void sua(){
        System.out.print("Nhap ma ve can duoc sua: ");
        String id = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMave().equals(id)) {
                isExisted = true;
                System.out.print("Ma khach hang duoc sua thanh: ");
                String makh = sc.nextLine();
                a[i].setMakh(makh);
                System.out.print("Ma tour duoc sua thanh: ");
                String matour = sc.nextLine();
                a[i].setMatour(matour);
                System.out.print("Ma ve duoc sua thanh: ");
                String mave = sc.nextLine();
                a[i].setMave(mave);
                System.out.print("Loai ve duoc sua thanh: ");
                String loai = sc.nextLine();
                a[i].setLoaive(loai);
                System.out.print("Gia ve duoc sua thanh: ");
                String gia=sc.nextLine();
                a[i].setGiave(gia);
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma ve!");
    }

    public void sua(String id) {
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMave().equals(id)) {
                isExisted = true;
                System.out.print("Ma khach hang duoc sua thanh: ");
                String makh = sc.nextLine();
                a[i].setMakh(makh);
                System.out.print("Ma tour duoc sua thanh: ");
                String matour = sc.nextLine();
                a[i].setMatour(matour);
                System.out.print("Ma ve duoc sua thanh: ");
                String mave = sc.nextLine();
                a[i].setMave(mave);
                System.out.print("Loai ve duoc sua thanh: ");
                String loai = sc.nextLine();
                a[i].setLoaive(loai);
                System.out.print("Gia ve duoc sua thanh: ");
                String gia=sc.nextLine();
                a[i].setGiave(gia);
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma ve!");
    }
    
    public void timkiem(){
        System.out.print("Nhap ma ve muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMave().equals(ma)) {
                isExisted = true;
                System.out.println("Thong tin ve can tim: ");
                a[i].xuat();
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma ve!");
    }
    
    public int timkiemma(String ma){
        n = a.length;
        int vitri = -1;
        for (int i = 0; i < n; i++) {
            if(a[i].getMave().equals(ma)) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public Ve timkiem(String ma){
        n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i].getMave().equals(ma)) {
                return a[i];
            }
        }  
        return null;
    }
    
    public void timkiemkh(){
        System.out.print("Nhap ma khach hang muon tim: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakh().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach hang! ");
    }

    public void timkiemkh(String ma){
        boolean isExisted = false;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if (a[i].getMakh().equals(ma)) {
                isExisted = true;
                a[i].xuat();
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma khach hang! ");
    }

    public int timkiemmakh(String ma){
        n = a.length;
        int vitri = -1;
        for (int i = 0; i < n; i++) {
            if(a[i].getMakh().equals(ma)) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    
    public void xoa(){
        System.out.print("Nhap ma ve muon xoa: ");
        String id = sc.nextLine();
        n = a.length;
        int vitri = timkiemma(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma ve!");
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
            System.out.println("Khong tim thay ma ve!");
        else {
            a = Arrays.copyOf(a, n + 2);
            for(int i = vitri; i < n; i++) {
                a[i] = a[i + 1];
            }
            a = Arrays.copyOf(a, n - 1);
            n--;
        }
    }

    public void xoamakh(){
        System.out.print("Nhap ma khach hang muon xoa ve: ");
        String id = sc.nextLine();
        n = a.length;
        int vitri = timkiemmakh(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma khach hang!");
        else {
            a = Arrays.copyOf(a, n + 2);
            for(int i = vitri; i < n; i++) {
                a[i] = a[i + 1];
            }
            a = Arrays.copyOf(a, n - 1);
            n--;
        }
    }
    
    public void xoamakh(String id){
        n = a.length;
        int vitri = timkiemmakh(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma khach hang!");
        else {
            a = Arrays.copyOf(a, n + 2);
            for(int i = vitri; i < n; i++) {
                a[i] = a[i + 1];
            }
            a = Arrays.copyOf(a, n - 1);
            n--;
        }
    }

    public void thongkeloaive() {
        int count1 = 0;
        int count2 = 0;
        n = a.length;
        for(int i = 0; i < n; i++) {
            if(a[i].getLoaive().equals("Tre em"))
                count1++;
            if(a[i].getLoaive().equals("Nguoi Lon"))
                count2++;
        }
        System.out.println("Ve nguoi lon: " + count2);
        System.out.println("Ve tre em: " + count1);
    }
}
