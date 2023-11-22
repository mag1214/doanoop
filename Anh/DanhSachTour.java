import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTour {
    int n;
    Tour[] dst = new Tour[n];
    int SoTour=0;
    Scanner sc = new Scanner(System.in);
    public DanhSachTour(){}
    public DanhSachTour(int n, Tour[] dst)
    {
        this.n=n;
        this.dst=dst;
    }
    public DanhSachTour(DanhSachTour ds)
    {
        n=ds.n;
        dst=ds.dst;
    }
    public int getN()
    {
        return n;
    }
    public void setN(int n)
    {
        this.n=n;
    }
    public void Nhap()
    {
        System.out.print("Nhap so tour: ");
        n = sc.nextInt();
        dst= new Tour[n];
        int number=-1;
        while(SoTour<n)
        {
            System.out.println("**********-Menu-NhapSinhVien*******");
            System.out.println("*       1.Nhap tour trong nuoc    *");
            System.out.println("*       2.Nhap tour trong nuoc    *");
            System.out.println("*              0.Thoat            *");
            System.out.println("***********************************");
            System.out.print("Nhap loai tour ");
            number=sc.nextInt();
            switch(number)
            {
                case 1:
                        System.out.print("Nhap Tour thu: "+SoTour);
                        System.out.println();
                        dst[SoTour]=new TourTrongNuoc();
                        dst[SoTour].Nhap();
                        SoTour++;
                    break;
                case 2:
                        System.out.print("Nhap Tour thu: "+SoTour);
                        System.out.println();
                        dst[SoTour]=new TourNgoaiNuoc();
                        dst[SoTour].Nhap();
                        SoTour++;
                    break;
                case 0:
                    SoTour=n;
                    break;   
                default:
                    System.out.println("Nhap sai so vui long nhap lai!!!"); 
            }
        }
    }
    public void NhapCung()
    {

        n=5;
        dst =new Tour[n];
        dst[0]= new TourTrongNuoc("T1","A","X1","X01","15h","Y1");
        dst[1]= new TourNgoaiNuoc("T2","B","X2","X02","3h","My","24/12/2023");
        dst[2]= new TourTrongNuoc("T3","C","X3","X03","2h","Y1");
        dst[3]= new TourNgoaiNuoc("T4","B","X4","X04","17h","An Do","23/1/2024");
        dst[4]= new TourNgoaiNuoc("T5","A","X5","X05","20h","Anh","6/7/2023");

    }
    public void Xuat()
    {
        System.out.println("Danh sach cac tour");
        for(int i=0; i<n; i++)
        {
            dst[i].Xuat();
          //  dst[i].PhuongTien();
        }
    }
    public void Them()
    {
        int number=-1,ThemCuoi=n;
            System.out.println("***********-Them-************");
            System.out.println("*  1.Them Tour trong nuoc   *");
            System.out.println("*   2.Them tour ngoai nuoc  *");
            System.out.println("*         0.Thoat           *");
            System.out.println("*****************************");
            System.out.print("Nhap tour can them vao: ");
            number=sc.nextInt();
            switch(number)
            {
                case 1:
                        dst = Arrays.copyOf(dst,n+1);
                        System.out.print("Nhap Tour: "+SoTour);
                        System.out.println();
                        dst[ThemCuoi]=new TourTrongNuoc();
                        dst[ThemCuoi].Nhap();
                        n++;
                        System.out.println("**********Da them tour vao danh sach**********");
                    break;
                case 2:
                        dst = Arrays.copyOf(dst,n+1);
                        System.out.print("Nhap tour thu: "+SoTour);
                        System.out.println();
                        dst[ThemCuoi]=new TourNgoaiNuoc();
                        dst[ThemCuoi].Nhap();
                        n++;
                        System.out.println("**********Da them tour vao danh sach**********");
                case 0:
                    break;
            }
    }
    public void Them(TourTrongNuoc x)
    {
        n=dst.length;
        dst = Arrays.copyOf(dst,n+1);
        dst[n]=new TourTrongNuoc();
        Tour dst2 = new TourTrongNuoc(x);
        dst[n]=dst2;
        n++;
        System.out.println("**********Da them Tour vao danh sach**********");
    }
    public void Them(TourNgoaiNuoc x)
    {
        n=dst.length;
        dst = Arrays.copyOf(dst,n+1);
        dst[n]=new TourNgoaiNuoc();
        Tour dst2 = new TourNgoaiNuoc(x);
        dst[n]=dst2;
        n++;
        System.out.println("**********Da them Tour vao danh sach**********");
    }
    public void XoaMa()
    {
        n=dst.length;
        int a;
        String MaSo;
        System.out.print("Nhap ma so tour can xoa: ");
        MaSo=sc.nextLine();
        a=TimKiemMaTour(MaSo);
        if(a!=-1)
        {
            for(int i=a; i<n-1; i++)
                dst[i]=dst[i+1];
            dst = Arrays.copyOf(dst,n-1);
            n--;
        }
        else
        {
            System.out.println("Khong tim thay tour");
        }
    }
    //Xoa 1 tour theo ma so co tham so
    public void XoaMa(String Ma)
    {
        n=dst.length;
        int a=TimKiemMaTour(Ma);
        if(a!=-1)
        {
            for(int i=a; i<n-1; i++)
                dst[i]=dst[i+1];
            dst = Arrays.copyOf(dst,n-1);
            n--;
        }
        else 
            System.out.println("Khong tim thay tour");
    }
    public void Sua()
    {
        int number=-1;
        int ViTri;
        String MaSo;
        System.out.print("Nhap ma so tour can sua: ");
        MaSo=sc.nextLine();
        ViTri=TimKiemMaTour(MaSo);
        if(ViTri!=-1)
        {
            System.out.println("*****************-Sua-*****************");
            System.out.println("*         1.Sua Tour trong nuoc       *");
            System.out.println("*        2.Sua tour ngoai nuoc        *");
            System.out.println("*                 0.Thoat             *");
            System.out.println("***************************************");
            System.out.print("Nhap tour can them vao: ");
            number=sc.nextInt();
            switch(number)
            {
                case 1:
                    TourTrongNuoc LienThong =new TourTrongNuoc();
                    if(ViTri!=-1)
                        System.out.println("******NHAP THONG TIN TOUR CAN SUA******");
                        LienThong.Nhap();
                        dst[ViTri]=LienThong;        
                    break;
                case 2:
                    TourNgoaiNuoc ChinhQuy= new TourNgoaiNuoc();;
                        System.out.println("******NHAP THONG TIN tour CAN SUA******");
                        ChinhQuy.Nhap();
                        dst[ViTri]=ChinhQuy;           
                    break;
                case 0:
                    break;
            }
        }
        else
        {
            System.out.println("Khong tim thay Tour can sua");
        }
    
    }
    //Sua 1 tour co tham so theo ma tour
    public void Sua(String x)
    {
        int number=-1;
        int ViTri=TimKiemMaTour(x);
        if(ViTri!=-1)
        {
            System.out.println("******NHAP THONG TIN TOUR CAN SUA******");
            System.out.println("*****************-Sua-*************");
            System.out.println("*        1.Sua tour trong nuoc    *");
            System.out.println("*         2.Sua tour ngoai nuoc   *");
            System.out.println("*              0.Thoat            *");
            System.out.println("***********************************");
            System.out.print("Nhap tour can them vao: ");
            number=sc.nextInt();
            switch(number)
            {
                case 1:
                    TourTrongNuoc TrongNuoc =new TourTrongNuoc();
                    System.out.println("******NHAP THONG TIN TOUR CAN SUA******");
                    TrongNuoc.Nhap();
                    dst[ViTri]=TrongNuoc;
                    break;
                case 2:
                    TourNgoaiNuoc ChinhQuy= new TourNgoaiNuoc();
                    System.out.println("******NHAP THONG TIN Tour CAN SUA******");
                    ChinhQuy.Nhap();
                    dst[ViTri]=ChinhQuy;
                case 0:
                    break;
                default:
                    System.out.println("Nhap sai!! Hay Nhap lai");
            }
        }
        else
        {
            System.out.println("Khong tim thay Tour can sua");
        }
    }
    public void TimKiemMaTour()
    {
        n=dst.length;
        int flag=0;
        String MaSo;
        System.out.print("Nhap ma tour can tim: ");
        MaSo=sc.nextLine();
        for(int i=0; i<n; i++)
        {
            if(dst[i].getMaTour().equals(MaSo))
            {
                dst[i].Xuat();
                flag=1;
            }
        }
        if(flag==0)
        {
            System.out.println("khong tim thay tour");
        }
    }
        //Tim kiem tour theo ma so co tham so int
    public int TimKiemMaTour(String Ma)
    {
        n=dst.length;
        int flag=-1;
        for(int i=0; i<n; i++)
        {
            if(dst[i].getMaTour().equals(Ma))
            {
                flag=i;
                break;
            }
        }
        return flag;
    }
        //Tim kiem tour theo ma so co tham so theo kieu Sinhvien
    public Tour TimKiemmMaTour(String Ma)
    {
        n=dst.length;
        Tour flag=null;
        for(int i=0; i<n; i++)
        {
            if(dst[i].getMaTour().equals(Ma))
            {
                dst[i].Xuat();
                flag=dst[i];
            }
        }
        return flag;
    }
    public void LoaiTour()
    {
        int Count1=0, Count2=0;
        for(int i=0; i<n; i++)
        {
            if(dst[i] instanceof TourTrongNuoc)
                Count1++;
            else
                Count2++;
        }
        System.out.println("Co "+Count1+" tour trong nuoc va "+Count2+" nuoc ngoai");
    }
    public String TachNgay(String s)
    {
        String[] NgayThangNam = s.split("/");
        String Ngay=NgayThangNam[0];
        return Ngay;
    }
    public void QuocGiaDen()
    {
        int Count1=0, Count2=0, Count3=0;
        for(int i=0; i<n; i++)
        {
            if(dst[i] instanceof TourNgoaiNuoc)
            {
                TourNgoaiNuoc NgoaiNuoc = new TourNgoaiNuoc();
                NgoaiNuoc=(TourNgoaiNuoc)dst[i];
                String QuocGia =NgoaiNuoc.getQuocGia();
                if(QuocGia.contains("Anh"))
                    Count1++;
                else if(QuocGia.contains("Phap"))
                    Count2++;
                else if(QuocGia.contains("AnDo"))
                    Count3++;
            }
        }
        System.out.println("------Cac_Nam_To_Chuc-------");
        System.out.println("| So den nuoc Anh      | " +Count1+ " |");
        System.out.println("| So den nuoc Phap     | " +Count2+ " |");
        System.out.println("| So den nuoc An Do    | " +Count3+ " |");
        System.out.println("----------------------------");
    }
    public void GhiDuLieuVaoFile() {
        try {
                FileOutputStream fos = new FileOutputStream("Tour.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                for (int i = 0; i < dst.length; i++) {
                        
                        oos.writeObject(dst[i]);
                        oos.writeObject(dst[i].PhuongTien());
                    }
                    oos.close();
                    fos.close();
            } 
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        
    }
    public void DocDuLieuTrongFile()
    {
        Object obj=null;
            try 
            {
                FileInputStream fis = new FileInputStream("Tour.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(fis.available() > 0)
                {
                    obj = ois.readObject();
                    System.out.println(obj);
                }
                ois.close();
                fis.close();
            } 
            catch(FileNotFoundException e)
            {
                e.printStackTrace();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
    }
}
