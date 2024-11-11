class KomputerPremium extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    protected boolean ruangprivat;
    // To do: Buatlah constructor pada class KomputerPremium
    public KomputerPremium( int jumlahkomputer, String namawarnet,Float hargaperjam,boolean ruangprivat){
        super(jumlahkomputer, namawarnet, hargaperjam);
        this.ruangprivat = ruangprivat;
    }
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    @Override
    public void Informasi () {

    }
    // To do: Buatlah method Pesan sesuai dengan ketentuan
    public void Pesan(int nomorkomputer) {
        System.out.println();
    }
    // To do: Buatlah method TambahLayanan sesuai dengan ketentuan
    public void TambahLayanan(String makanan){
        
    }
    // To do: Buatlah method TambahLayanan memakai Polymorphism Overloading sesuai dengan ketentuan
    public void TambahLayanan(String makanan,String minuman){

    }
}
