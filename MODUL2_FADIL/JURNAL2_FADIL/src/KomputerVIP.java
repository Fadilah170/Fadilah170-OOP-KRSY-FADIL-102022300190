class Komputervip extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    protected boolean vipcard;
    // To do: Buatlah constructor pada class KomputerPremium
    public Komputervip (int jumlahkomputer,String namawarnet,Float hargaperjam, boolean vipcard) {
        super(jumlahkomputer, namawarnet, hargaperjam);
        this.vipcard = vipcard;
    }
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    @Override
    public void Informasi() {
        super Informasi();
        if (vipcard){
            System.out.println("status member vip");
            System.out.println("benefit member vip");
            System.out.println("diskon 10% untuk bermain diatas 3 jam");
            System.out.println("gratis minuman setiap 4 jam bermain");
            System.out.println("prioritas booking komputer gaming");
        }
        else {
            System.err.println("status : non vip");
            System.out.println("benefit member vip jangan ngarep lebih maap");
        }
    }
    // To do: Buatlah method Pesan sesuai dengan ketentuan
    public void login(String Username) {
        System.out.println();
    }
    // To do: Buatlah method TambahLayanan sesuai dengan ketentuan
    public void jambermain (int jam) {
        System.out.println();
    }
    // To do: Buatlah method TambahLayanan memakai Polymorphism Overloading sesuai dengan ketentuan
    public void bermain (int jam, int menittambahan) {
        System.out.println();
    }
}
