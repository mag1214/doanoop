import java.util.Arrays;
import java.util.Scanner;

public class DanhSachKeHoachTour {
    int n;
    KeHoachTour[] kht = new KeHoachTour[n];
    Scanner sc = new Scanner(System.in);
    public DanhSachKeHoachTour(){}
    public DanhSachKeHoachTour(int n, KeHoachTour[] kht)
    {
        this.n=n;
        this.kht=kht;
    }
    public DanhSachKeHoachTour(DanhSachKeHoachTour ds)
    {
        n=ds.n;
        kht=ds.kht;
    }
    public void nhap()
    {
        System.out.print("Nhap so danh sach ke hoach: ");
        n = sc.nextInt();
        sc.nextLine();
        kht = new KeHoachTour[n];
        for(int i = 0; i < n; i++){
            kht[i]= new KeHoachTour();
            kht[i].Nhap();
        }
    }
    public void DuLieuCung()
    {
        kht = new KeHoachTour[5];
        kht[0]= new KeHoachTour("KH1", "T1", "NV1", "24/05/2000", "30/5/2000");
        kht[1]= new KeHoachTour("KH2", "T2", "NV2", "07/05/2010", "30/5/2010");
        kht[2]= new KeHoachTour("KH3", "T3", "NV3", "11/05/2016", "30/5/2016");
        kht[3]= new KeHoachTour("KH4", "T4", "NV4", "19/05/2018", "30/5/2018");
        kht[4]= new KeHoachTour("KH5", "T5", "NV5", "11/05/2019", "30/5/2019");
    }
    public void Xuat()
    {   
        n=kht.length;
        for(int i=0; i<n; i++)
        {
            kht[i].Xuat();
            System.out.println();
        }
    }
    public void Them()
    {
        System.out.println("**********Nhap ke hoach muon them vao**********");
        kht = Arrays.copyOf(kht,n+1);
        kht[n]= new KeHoachTour();
        kht[n].Nhap();
        n++;
        System.out.println("**********Da them ke hoach vao danh sach**********");
    } 
    public void Them(KeHoachTour x)
    {
        n=kht.length;
        kht = Arrays.copyOf(kht,n+1);
        kht[n]=new KeHoachTour();
        KeHoachTour kh = new KeHoachTour(x);
        kht[n] = kh;
        n++;
        System.out.println("**********Da them ke hoach vao danh sach**********");
    }
    public void Sua()
    {
        n=kht.length;
        int a;
        String MaSo;
        KeHoachTour SuaSv= new KeHoachTour();
        System.out.print("Nhap ma so can sua: ");
        MaSo=sc.nextLine();
        a=TimKiem(MaSo);
        if(a!=-1)
        {
            System.out.println("******NHAP THONG TIN KE HOACH CAN SUA******");
            SuaSv.Nhap();
            kht[a]=SuaSv;
        }
        else
        {
            System.out.println("Khong tim thay");
        }
    }
    
    public void Sua(String x)
    {
        n=kht.length;
        int a=TimKiem(x);
        KeHoachTour SuaSv= new KeHoachTour();
        if(a!=-1)
        {
            System.out.println("******NHAP THONG TIN KE HOACH CAN SUA******");
            SuaSv.Nhap();
            kht[a]=SuaSv;
        }
        else
            System.out.println("Khong tim thay");
    }
    public void XoaMa()
    {
        n=kht.length;
        int a;
        String MaSo;
        System.out.print("Nhap ma so can xoa: ");
        MaSo=sc.nextLine();
        a=TimKiem(MaSo);
        if(a!=-1)
        {
            for(int i=a; i<n-1; i++)
                kht[i]=kht[i+1];
            kht = Arrays.copyOf(kht,n-1);
            n--;
        }
        else
        {
            System.out.println("Khong tim thay ");
        }
    }
        //Xoa theo ma so co tham so
    public void XoaMa(String Ma)
    {
        n=kht.length;
        int a=TimKiem(Ma);
        if(a!=-1)
        {
            for(int i=a; i<n-1; i++)
                kht[i]=kht[i+1];
            kht = Arrays.copyOf(kht,n-1);
            n--;
        }
        else 
            System.out.println("Khong tim thay ");
    }
    public void TimKiem()
    {
        n=kht.length;
        int flag=0;
        String MaSo;
        System.out.print("Nhap ma so can tim: ");
        MaSo=sc.nextLine();
        for(int i=0; i<n; i++)
        {
            if(kht[i].getMaKeHoach().equals(MaSo))
            {
                kht[i].Xuat();
                flag=1;
            }
        }
        if(flag==0)
        {
            System.out.println("khong tim thay ");
        }
    }
    //Tim kiem  theo ma so co tham so int
    public int TimKiem(String Ma)
    {
        n=kht.length;
        int flag=0;
        for(int i=0; i<n; i++)
        {
            if(kht[i].getMaKeHoach().equals(Ma))
            {
                flag=i;
                break;
            }
        }
        return flag;
    }
    //Tim kiem  theo ma so co tham so theo kieu Sinhvien
    public KeHoachTour TimKiemm(String Ma)
    {
        n=kht.length;
        KeHoachTour flag=null;
        for(int i=0; i<n; i++)
        {
            if(kht[i].getMaKeHoach().equals(Ma))
            {
                kht[i].Xuat();
                flag=kht[i];
            }
        }
        return flag;
    }
    public String TachNgay(String s)
    {
        String[] NgayThangNam = s.split("/");
        String Ngay=NgayThangNam[0];
        return Ngay;
    }
    public void TimKiemNgayDi()
    {
        n=kht.length;
        int flag=0;
        String Ngay;
        System.out.print("Nhap ngay di: ");
        Ngay=sc.nextLine();
        for(int i=0; i<n; i++)
        {
            if(kht[i].getNgaydi().contains(Ngay))
            {
                kht[i].Xuat();
                flag=1;
            }
        }
        if(flag==0)
        {
            System.out.println("khong tim thay ");
        }
    }
    public String TachNam(String s)
    {
        String[] NgayThangNam = s.split("/");
        String Nam=NgayThangNam[NgayThangNam.length-1];
        return Nam;
    }
    public void NamToChuc()
    {
        int Count1=0, Count2=0, Count3=0, Count4=0;
        
        for(int i=0; i<n; i++)
        {
            String nam=TachNam(kht[i].getNgaydi());
            int Nam= Integer.parseInt(nam);
            if(Nam>=2000 && Nam<2005)
                Count1++;
            else if (Nam>=2005 && Nam<2010)
                Count2++;
            else if(Nam>=2010 && Nam<2015)
                Count3++;
            else if(Nam>=2015 && Nam<=2020)
                Count4++;
        }
        System.out.println("----------Cac_Nam_To_Chuc-----------");
        System.out.println("| So Tour tu nam 2000 den 2004 | " +Count1+ " |");
        System.out.println("| So Tour tu nam 2005 den 2009 | " +Count2+ " |");
        System.out.println("| So Tour tu nam 2010 den 2014 | " +Count3+ " |");
        System.out.println("| So Tour tu nam 2015 den 2020 | " +Count4+ " |");
        System.out.println("------------------------------------");
    }
}
