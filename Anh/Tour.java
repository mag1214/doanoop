package Class;

import java.io.Serializable;
import java.util.Scanner;

public abstract class Tour implements Serializable{
    private String MaTour, TenTour, NoiKhoiHanh,NoiDen,ThoiDiemDi;
    transient Scanner sc = new Scanner(System.in);
    public Tour(){

    }
    public Tour(String MaTour, String TenTour, String NoiKhoiHanh,String NoiDen, String ThoiDiemDi)
    {
        this.MaTour=MaTour;
        this.TenTour=TenTour;
        this.NoiKhoiHanh=NoiKhoiHanh;
        this.NoiDen=NoiDen;
        this.ThoiDiemDi=ThoiDiemDi;
    }
    public Tour(Tour t)
    {
        MaTour=t.MaTour;
        TenTour=t.TenTour;
        NoiKhoiHanh=t.NoiKhoiHanh;
        NoiDen=t.NoiDen;
        ThoiDiemDi=t.ThoiDiemDi;
    }
    public String getMaTour()
    {
        return MaTour;
    }
    public void setMaTour(String MaTour)
    {
        this.MaTour=MaTour;
    }

    public String getTenTour()
    {
        return TenTour;
    }
    public void setTenTour(String TenTour)
    {
        this.TenTour=TenTour;
    }

    public String getNoiKhoiHanh()
    {
        return NoiKhoiHanh;
    }
    public void setNoiKhoiHanh(String NoiKhoiHanh)
    {
        this.NoiKhoiHanh=NoiKhoiHanh;
    }

    public String getNoiDen()
    {
        return NoiDen;
    }
    public void setNoiDen(String NoiDen)
    {
        this.NoiDen=NoiDen;
    }

    public String getThoiDiemDi()
    {
        return ThoiDiemDi;
    }
    public void setThoiDiemDi(String ThoiDiemDi)
    {
        this.ThoiDiemDi=ThoiDiemDi;
    }
    abstract public String PhuongTien();
    public void Nhap()
    {
        do
        {
            System.out.println("Ma Tour bao gom 2 ky tu va khong duoc bo trong");
            System.out.print("Nhap ma tour: ");
            MaTour=sc.nextLine();
            if(MaTour.length()!=2)
                System.out.println("Vui long nhap ma tour co 2 ky tu!!!");
        }while(MaTour.length()!=2);
        do
        {   
            System.out.print("Nhap ten tour: ");
            TenTour=sc.nextLine();
            if(TenTour.length()==0)
                System.out.println("Vui long khong de trong du lieu. Moi ban nhap lai!!");
        }while(TenTour.length()==0);
        do
        {   
            System.out.print("Nhap noi khoi hanh: ");
            NoiKhoiHanh=sc.nextLine();
            if(NoiKhoiHanh.length()==0)
                System.out.println("Vui long khong de trong du lieu. Moi ban nhap lai!!");
        }while(NoiKhoiHanh.length()==0);
        do
        {
            System.out.print("Nhap noi den: ");
            NoiDen=sc.nextLine();
            if(NoiDen.length()==0)
                System.out.println("Vui long khong de trong du lieu. Moi ban nhap lai!!");
        }while (NoiDen.length()==0);
        do
        {
            System.out.print("Nhap noi di: ");
            ThoiDiemDi=sc.nextLine();
            if(ThoiDiemDi.length()==0)
                System.out.println("Vui long khong de trong du lieu. Moi ban nhap lai!!");
        }while (ThoiDiemDi.length()==0);
    }
    public void Xuat()
    {
        System.out.format("\n|| %5s | ", MaTour);
        System.out.format("%6s | ", TenTour);
        System.out.format("%10s | ", NoiKhoiHanh);
        System.out.format("%7s | ", NoiDen);
        System.out.format("%10s |", ThoiDiemDi);
    }
    public String toString() {
        return "Ma: " + getMaTour() + "\nTen: " + getTenTour() + "\nNoi khoi hah: " + getNoiKhoiHanh() + "\nNoi den:"+getNoiDen()
        + "\nThoi diem di: "+ getThoiDiemDi()+"\n"+ PhuongTien();
    }
}
