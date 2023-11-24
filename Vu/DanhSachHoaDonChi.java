import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachHoaDonChi
{
    HoaDonChi[] a;
    int n;
    Scanner sc = new Scanner(System.in);
    public DanhSachHoaDonChi()
    {

    }
    public DanhSachHoaDonChi (HoaDonChi[] a,int n)
    {
        this.a = a;
        this.n = n;
    }
    public void nhap()
    {
        System.out.print("Nhap n danh sach hoa don chi dau tien: ");
        n = sc.nextInt();
        sc.nextLine();
        a = new HoaDonChi[n];
        for (int i = 0 ; i<n ; i++)
        {
            a[i] = new HoaDonChi();
            a[i].nhap();
        }
    }
    public void xuat()
    {
        System.out.println("Danh sach hoa don chi la: ");
        n = a.length;
        for (int i = 0 ; i<n ; i++)
        {
            a[i].xuat();
        }
    }
    public void them()
    {
        n = a.length;
        a = Arrays.copyOf(a, n+1);
        a[n] = new HoaDonChi();
        System.out.print("Nhap thong tin hoa don chi can them: ");
        a[n].nhap();
        n++;
    } 
    public void them(HoaDonChi x)
    {
        n = a.length;
        a = Arrays.copyOf(a, n+1);
        a[n] = new HoaDonChi(x);
        n++;
    }
    public void sua()
    {
        System.out.print("Nhap ma hoa don can duoc sua: ");
        String id = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaHoaDon().equals(id))
            {
                isExisted = true;
                System.out.print("Ma hoa don duoc sua thanh: ");
                String mahd = sc.nextLine();
                a[i].setMahoadon(mahd);
                System.out.print("Ma khach hang duoc sua la: ");
                String makh = sc.nextLine();
                a[i].setMakhachhang(makh);
                System.out.print("Ma ke hoach tua duoc sua la: ");
                String makht = sc.nextLine();
                a[i].setMakehoachtua(makht);
                System.out.print("Ma nhan vien duoc sua la: ");
                String manv = sc.nextLine();
                a[i].setManhanvien(manv);
                break;
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay ma hoa don.");
            }
            
        }

    }
    public void sua(String id)
    {
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaHoaDon().equals(id))
            {
                isExisted = true;
                System.out.print("Ma hoa don duoc sua thanh: ");
                String mahd = sc.nextLine();
                a[i].setMahoadon(mahd);
                System.out.print("Ma khach hang duoc sua la: ");
                String makh = sc.nextLine();
                a[i].setMakhachhang(makh);
                System.out.print("Ma ke hoach tua duoc sua la: ");
                String makht = sc.nextLine();
                a[i].setMakehoachtua(makht);
                System.out.print("Ma nhan vien duoc sua la: ");
                String manv = sc.nextLine();
                a[i].setManhanvien(manv);
                break;
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay ma hoa don.");
            }
            
        }

    }
    public void timkiem()
    {
        System.out.print("Nhap ma hoa don can tim kiem: ");
        String ma = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for (int i = 0; i < n; i++) {
            if(a[i].getMaHoaDon().equals(ma)) {
                isExisted = true;
                System.out.println("Thong tin hoa don chi can tim: ");
                a[i].xuat();
                break;
            }
        }
        if(!isExisted) 
            System.out.println("Khong tim thay ma hoa don chi!");
    }
       public HoaDonChi timkiem(String ma){
        n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i].getMaHoaDon().equals(ma)) {
                return a[i];
            }
        }  
        return null;
    }
    public int timkiemma(String ma){
        n = a.length;
        int vitri = -1;
        for (int i = 0; i < n; i++) {
            if(a[i].getMaHoaDon().equals(ma)) {
                vitri = i;
                break;
            }
        }
        return vitri;
    }
    public void timkiemmakhachhang()
    {
        System.out.print("Nhap ma khach hang can tim: ");
        String makh = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaKhachHang().equals(makh))
            {
                isExisted = true;
                a[i].xuat();
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay hoa don chi cua ma khach hang can tim!");
            }
        }
    }
    public void timkiemmakhachhang(String makh)
    {
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaKhachHang().equals(makh))
            {
                isExisted = true;
                a[i].xuat();
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay hoa don chi cua ma khach hang can tim!");
            }
        }
    }
    public void timkiemmakehoachtua()
    {
        System.out.print("Nhap ma ke hoach tua can tim: ");
        String makht = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaKeHoachTua().equals(makht))
            {
                isExisted = true;
                a[i].xuat();
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay hoa don cua ma ke hoach tua can tim!");
            }
        }
    }
    public void timkiemmakehoachtua(String makht)
    {
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
             if(a[i].getMaKeHoachTua().equals(makht))
            {
                isExisted = true;
                a[i].xuat();
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay hoa don cua ma ke hoach tua can tim!");
            }
        }
    }
    public void timkiemmanhanvien()
    {
        System.out.print("Nhap ma nhan vien can tim: ");
        String manv = sc.nextLine();
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaNhanVien().equals(manv))
            {
                isExisted = true;
                a[i].xuat();
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay hoa don cua ma nhan vien can tim!");
            }
        }
    }
    public void timkiemmanhanvien(String manv)
    {
        boolean isExisted = false;
        n = a.length;
        for(int i = 0 ; i<n ; i++)
        {
            if(a[i].getMaNhanVien().equals(manv))
            {
                isExisted = true;
                a[i].xuat();
            }
            if(!isExisted)
            {
                System.out.print("Khong tim thay hoa don cua ma nhan vien can tim!");
            }
        }
    }
    
    public void xoa(){
        System.out.print("Nhap ma hoa don muon xoa: ");
        String id = sc.nextLine();
        n = a.length;
        int vitri = timkiemma(id);
        if(vitri == -1) 
            System.out.println("Khong tim thay ma hoa don!");
        else {
            a = Arrays.copyOf(a, n + 1);
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
        DataOutputStream out = new DataOutputStream(new FileOutputStream("dataKh.txt"));
        for(int i = 0; i < n; i++) {
            out.writeUTF(a[i].getMaHoaDon());
            out.writeUTF(a[i].getMaKeHoachTua());
            out.writeUTF(a[i].getMaKhachHang());
            out.writeUTF(a[i].getMaNhanVien());
        }
        out.close();
    }

    public void readDataFromFile() {
        a = new HoaDonChi[500];
        int i = 0;
        try {
            DataInputStream in = new DataInputStream(new FileInputStream("dataKh.txt"));
            try {
                while(true) {
                    a[i] = new HoaDonChi();
                    a[i].setMahoadon(in.readUTF());
                    a[i].setMakehoachtua(in.readUTF());
                    a[i].setMakhachhang(in.readUTF());
                    a[i].setManhanvien(in.readUTF());
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