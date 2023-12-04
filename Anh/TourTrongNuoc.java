package Class;

public class TourTrongNuoc extends Tour{
    private String TinhThanh;
    
    public TourTrongNuoc()
    {}
    public TourTrongNuoc(String MaTour, String TenTour, String NoiKhoiHanh,String NoiDen, String ThoiDiemDi,String TinhThanh)
    {
        super(MaTour,TenTour,NoiKhoiHanh,NoiDen,ThoiDiemDi);
        this.TinhThanh=TinhThanh;
    }
    public TourTrongNuoc(TourTrongNuoc t)
    {
        super((TourTrongNuoc)t);
        TinhThanh=t.TinhThanh;
    }
    public String getTinhThanh() {
        return TinhThanh;
    }
    public void setTinhThanh(String tinhThanh) {
        TinhThanh = tinhThanh;
    }
    @Override 
    public void Nhap()
    {
        super.Nhap();
        System.out.print("Nhap tinh thanh cua dia danh den: ");
        TinhThanh=sc.nextLine();
    }
    @Override 
    public void Xuat()
    {
        super.Xuat();
        System.out.format("%10s | ", PhuongTien());
        System.out.format("%16s | %14s ||\n  ", TinhThanh,"NULL");
    }
    @Override
    public String PhuongTien() {
       return "Xe khach";
    }
    @Override
    public String toString() {
        return "Tour ngoai nuoc\n" + super.toString() +"\nTinh thah den: " + getTinhThanh()+"\n"+ PhuongTien();
    }
}
