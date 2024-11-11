class Komputer {
    // To do: Buatlah 3 variable sesuai ketentuan
    protected int jumlahkomputer;
    protected String namawarnet;
    protected Float hargaperjam;
    // To do: Buatlah constructor pada class Komputer
    public Komputer(int jumlahkomputer,String namawarnet,Float hargaperjam) {
        this.jumlahkomputer = jumlahkomputer;
        this.namawarnet = namawarnet;
        this.hargaperjam = hargaperjam;
    }
    // To do: Buatlah Method Informasi dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
public void Informasi () {
    System.out.println("jumlahkomputer:"+ jumlahkomputer);
    System.out.println("namawarnet:"+ namawarnet);
    System.out.println("hargaperjam:"+ hargaperjam);
}

}