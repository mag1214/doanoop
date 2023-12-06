package Class;


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
        do
        {
            System.out.println("Quoc gia den co tu 2 ky tu tro len");
            System.out.print("Nhap quoc gia den: ");
            QuocGia=sc.nextLine();
            if(QuocGia.length()<2)
                System.out.println("Vui long nhap so ky tu tu 2 tro len!!! Moi Moi ban nhap lai");
        }while(QuocGia.length()<2);
        
        NgayThangNam validator = new KiemTraDinhDang("dd/MM/yyyy");
        do {
        System.out.println("Vui long nhap theo dinh dang DD/MM/YYYY");
        System.out.print("Nhap thoi han visa: ");
        ThoiHanVisa = sc.nextLine();

        if (!validator.Check(ThoiHanVisa)) {
        System.out.println("Nhap sai dinh dang vui long nhap lai");
        }
        }while (!validator.Check(ThoiHanVisa));

        
    }
    @Override public void Xuat()
    {
        super.Xuat();
        System.out.format("%10s | ", PhuongTien());
        System.out.format("%16s | ", QuocGia);
        System.out.format("%14s ||\n  ", ThoiHanVisa);
    }
    @Override public String PhuongTien() {
        return "May Bay";
    }
    @Override
    public String toString() {
        return "Tour ngoai nuoc\n" + super.toString() +"\nQuoc gia den: " + getQuocGia() + "\nThoi han visa: "+getThoiHanVisa()+"\n" + PhuongTien();
    }
}
