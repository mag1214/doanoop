public class TourNgoaiNuoc extends Tour{
    private String QuocGia, ThoiHanVisa;
    
    public TourNgoaiNuoc()
    {}
    public TourNgoaiNuoc(String MaTour, String TenTour, String NoiKhoiHanh,String NoiDen, String ThoiDiemDi,String QuocGia,String ThoiHanVisa)
    {
        super(MaTour,TenTour,NoiKhoiHanh,NoiDen,ThoiDiemDi);
        this.QuocGia=QuocGia;
        this.ThoiHanVisa=ThoiHanVisa;
    }
    public TourNgoaiNuoc(TourNgoaiNuoc t)
    {
        super((TourNgoaiNuoc)t);
        QuocGia=t.QuocGia;
    }
    public String getQuocGia() {
        return QuocGia;
    }
    public void setQuocGia(String QuocGia) {
        this.QuocGia = QuocGia;
    }
    public String getThoiHanVisa() {
        return ThoiHanVisa;
    }
    public void setThoiHanVisa(String ThoiHanVisa) {
        this.ThoiHanVisa=ThoiHanVisa;
    }
    @Override public void Nhap()
    {
        super.Nhap();
        System.out.print("Nhap quoc gia den: ");
        QuocGia=sc.nextLine();
        System.out.print("Nhap thoi han visa: ");
        ThoiHanVisa=sc.nextLine();

    }
    @Override public void Xuat()
    {
        super.Xuat();
        System.out.println("Quoc gia den den: "+QuocGia);
        System.out.println("Thoi han visa: "+ThoiHanVisa);
    }
    @Override public String PhuongTien() {
        return "Phuong tien: May Bay";
    }
    @Override
    public String toString() {
        return "Tour ngoai nuoc\n" + super.toString() +"\nQuoc gia den: " + getQuocGia() + "\nThoi han visa: "+getThoiHanVisa();
    }
}
