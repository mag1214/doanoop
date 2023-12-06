package Class;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class DanhSachTour {
    static Tour[] dst;
    int n,a=0;
    Scanner sc = new Scanner(System.in);
    public DanhSachTour(){}
    public DanhSachTour(int n) 
    {
        this.n = n;
        dst = new Tour[n];
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
        int i=0;
        System.out.print("Nhap so tour: ");
        n = sc.nextInt();
        sc.nextLine();
        dst= new Tour[n];
        int number=-1;
        while(i<n)
        {
            System.out.println("**********-Menu-NhapSinhVien*******");
            System.out.println("*       1.Nhap tour trong nuoc    *");
            System.out.println("*       2.Nhap tour trong nuoc    *");
            System.out.println("*              0.Thoat            *");
            System.out.println("***********************************");
            System.out.print("Nhap loai tour ");
            number=sc.nextInt();
            sc.nextLine();
            switch(number)
            {
                case 1:
                        System.out.print("Nhap Tour thu: "+(i+1));
                        System.out.println();
                        dst[i]=new TourTrongNuoc();
                        dst[i].Nhap();
                        GhiDuLieuVaoFile();
                        if(i>1)
                            MaDuyNhat(i);
                        i++;
                    break;
                case 2:
                        System.out.print("Nhap Tour thu: "+(i+1));
                        System.out.println();
                        dst[i]=new TourNgoaiNuoc();
                        dst[i].Nhap();
                        GhiDuLieuVaoFile();
                        if(i>0)
                            MaDuyNhat(i);
                        i++;
                    break;
                case 0:
                    i=n;
                    break;   
                default:
                    System.out.println("Nhap sai so vui long nhap lai!!!"); 
            }
        }
    }
    public void MaDuyNhat(int i) {
		DocDuLieuTuFile();
		String MaTour;
		String mkh = dst[i].getMaTour();
		do {
			if(KiemTraMT(mkh, i)) {
				System.out.println();
				Xuat();
				System.err.println("\nTour thu " + (i+1) + " co ma " + mkh + " bi trung ma ke hoach. An enter de tiep tuc");
				sc.nextLine();
				System.err.print("Nhap Lai Ma: ");
				MaTour = sc.nextLine();
				dst[i].setMaTour(MaTour);
				GhiDuLieuVaoFile();
				mkh = dst[i].getMaTour();
			}
		}while(KiemTraMT(mkh, i));
	}
    public boolean KiemTraMT(String makehoach, int k) {
		for(int i = a - 1; i >= 0; i--) {
			if(dst[i].getMaTour().indexOf(makehoach) != -1 && i!= k) {
				return true;
			}
		}
		return false;
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
        System.out.println("============================================DANH SACH TOUR==============================================");
        System.out.format("||%5s |%5s |%10s |%8s |%5s |%10s |%15s |%15s ||\n",
                  "MaTour", "TenTour", "NoiKhoiHanh", "Noiden", "ThoiDiem Di","PhuongTien", "TinhThanh/QuocGia", "ThoiHanViSa");
        try
        {
            for(int i=0; i<n; i++)
            {
                dst[i].Xuat();
                dst[i].PhuongTien();
            }
        }
        catch(NullPointerException npe) {
			
		}
         System.out.println("======================================================================================================");
    }
    public String MaTourTimThay(int i)
    {
        return dst[i].getMaTour();
    }
    public void Them()
    {
        int number=-1,i=n;
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
                        System.out.print("Nhap Tour can them vao");
                        System.out.println();
                        dst[i]=new TourTrongNuoc();
                        dst[i].Nhap();
                        n++;
                        GhiDuLieuVaoFile();
                        MaDuyNhat(i);
                        System.out.println("**********Da them tour vao danh sach**********");
                    break;
                case 2:
                        dst = Arrays.copyOf(dst,n+1);
                        System.out.print("Nhap tour thu tour can them vao");
                        System.out.println();
                        dst[i]=new TourNgoaiNuoc();
                        dst[i].Nhap();
                        n++;
                        GhiDuLieuVaoFile();
                        MaDuyNhat(i);
                        System.out.println("**********Da them tour vao danh sach**********");
                case 0:
                    break;
            }
    }
    public void Them(TourTrongNuoc x)
    {
        int i=n;
        dst = Arrays.copyOf(dst,n+1);
        dst[n]=new TourTrongNuoc();
        dst[n]=x;
        n++;
        GhiDuLieuVaoFile();
        MaDuyNhat(i);
        System.out.println("**********Da them Tour vao danh sach**********");
    }
    public void Them(TourNgoaiNuoc x)
    {
        int i=n;
        dst = Arrays.copyOf(dst,n+1);
        dst[i]=new TourNgoaiNuoc();
        dst[i]=x;
        n++;
        GhiDuLieuVaoFile();
        MaDuyNhat(i);
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
            GhiDuLieuVaoFile();
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
            GhiDuLieuVaoFile();
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
                        GhiDuLieuVaoFile();
                        if(ViTri>1)
                            MaDuyNhat(ViTri);        
                    break;
                case 2:
                    TourNgoaiNuoc ChinhQuy= new TourNgoaiNuoc();;
                        System.out.println("******NHAP THONG TIN tour CAN SUA******");
                        ChinhQuy.Nhap();
                        dst[ViTri]=ChinhQuy;    
                        GhiDuLieuVaoFile();
                        if(ViTri>1)
                            MaDuyNhat(ViTri);         
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
                    GhiDuLieuVaoFile();
                    if(ViTri>1)
                        MaDuyNhat(ViTri);
                    break;
                case 2:
                    TourNgoaiNuoc ChinhQuy= new TourNgoaiNuoc();
                    System.out.println("******NHAP THONG TIN Tour CAN SUA******");
                    ChinhQuy.Nhap();
                    dst[ViTri]=ChinhQuy;
                    if(ViTri>1)
                        MaDuyNhat(ViTri);
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
        System.out.println("============================================DANH SACH TOUR==============================================");
        System.out.format("||%5s |%5s |%10s |%8s |%5s |%10s |%15s |%15s ||\n",
                  "MaTour", "TenTour", "NoiKhoiHanh", "Noiden", "ThoiDiem Di","PhuongTien", "TinhThanh/QuocGia", "ThoiHanViSa");
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
    System.out.println("============================================================================================================");
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
        System.out.println("============================================DANH SACH TOUR==============================================");
        System.out.format("||%5s |%5s |%10s |%8s |%5s |%10s |%15s |%15s ||\n",
                  "MaTour", "TenTour", "NoiKhoiHanh", "Noiden", "ThoiDiem Di","PhuongTien", "TinhThanh/QuocGia", "ThoiHanViSa");
        for(int i=0; i<n; i++)
        {
            if(dst[i].getMaTour().equals(Ma))
            {
                dst[i].Xuat();
                flag=dst[i];
            }
        }
        System.out.println("========================================================================================================");
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
    public void TimKiemNoiDen()
    {
        String NoiDen;
        int flag=0;
        System.out.println("Nhap noi den can tim trong danh sach");
        NoiDen=sc.nextLine();
        System.out.println("============================================DANH SACH TOUR==============================================");
        System.out.format("||%5s |%5s |%10s |%8s |%5s |%10s |%15s |%15s ||\n",
                  "MaTour", "TenTour", "NoiKhoiHanh", "Noiden", "ThoiDiem Di","PhuongTien", "TinhThanh/QuocGia", "ThoiHanViSa");
        for(int i = 0; i<n; i++)
        {
            if(dst[i].getNoiDen().contains(NoiDen))
            {
                dst[i].Xuat();
                System.out.println();
                flag=1;
            }
        }
        System.out.println("========================================================================================================");
        if(flag==0)
            System.out.println("Khong tim thay tour nao!!!");
    }
    public void GhiDuLieuVaoFile()
    {
        n=dst.length;
        try
        {
            DataOutputStream out = new DataOutputStream(new FileOutputStream("Tour.txt"));
            try
            {
                for (int i = 0; i < n; i++) 
                {       
                    if(dst[i] instanceof TourTrongNuoc)
                    {
                        out.writeInt(1);
                        TourTrongNuoc ttn = new TourTrongNuoc();
                        ttn=(TourTrongNuoc)dst[i];
                        out.writeUTF(ttn.getMaTour());
                        out.writeUTF(ttn.getTenTour());
                        out.writeUTF(ttn.getNoiKhoiHanh());
                        out.writeUTF(ttn.getNoiDen());
                        out.writeUTF(ttn.getThoiDiemDi());
                        out.writeUTF(ttn.getTinhThanh());                        
                    }
                    else if(dst[i] instanceof TourNgoaiNuoc)
                    {
                        out.writeInt(2);
                        TourNgoaiNuoc tnc = new TourNgoaiNuoc();
                        tnc = (TourNgoaiNuoc)dst[i];
                        out.writeUTF(tnc.getMaTour());
                        out.writeUTF(tnc.getTenTour());
                        out.writeUTF(tnc.getNoiKhoiHanh());
                        out.writeUTF(tnc.getNoiDen());
                        out.writeUTF(tnc.getThoiDiemDi());
                        out.writeUTF(tnc.getQuocGia());
                        out.writeUTF(tnc.getThoiHanVisa()); 

                    }
                }
            }
            catch(NullPointerException npe) {}
            out.close();    
        }
        catch(IOException e) 
        {
            e.printStackTrace();    
        }
    }
    public void DocDuLieuTuFile() 
    {
        int i=0;
        dst = new Tour[100];
        try 
        {
            DataInputStream in = new DataInputStream(new FileInputStream("Tour.txt"));
            try
            {
                while (in.available() > 0) 
                {
                    int kieuDuLieu = in.readInt();
                    switch (kieuDuLieu)
                    {
                        case 1:
                            TourTrongNuoc ttn = new TourTrongNuoc();
                            ttn.setMaTour(in.readUTF());
                            ttn.setTenTour(in.readUTF());
                            ttn.setNoiKhoiHanh(in.readUTF());
                            ttn.setNoiDen(in.readUTF());
                            ttn.setThoiDiemDi(in.readUTF());
                            ttn.setTinhThanh(in.readUTF());
                            dst[i]=(Tour)ttn;
                            i++;
                            break;
                        case 2:
                            TourNgoaiNuoc tnc = new TourNgoaiNuoc();
                            tnc.setMaTour(in.readUTF());
                            tnc.setTenTour(in.readUTF());
                            tnc.setNoiKhoiHanh(in.readUTF());
                            tnc.setNoiDen(in.readUTF());
                            tnc.setThoiDiemDi(in.readUTF());
                            tnc.setQuocGia(in.readUTF());
                            tnc.setThoiHanVisa(in.readUTF());
                            dst[i]=(Tour)tnc;
                            i++;
                            break;
                        default:
                            System.out.println("Kiểu dữ liệu không xác định.");
                            break;
                    }
                }
            } 
            catch (EOFException e) { } 
            finally 
            {
                a=i;
                dst = Arrays.copyOf(dst, n);
                in.close();
            }
        }
        catch (IOException e) {}
    }
}
