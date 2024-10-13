import java.util.ArrayList;
import java.util.Scanner;

// Class Penerbangan
public class TPMODUL2_FADIL {

    static class Penerbangan {
        private String nomorPenerbangan;
        private String bandaraKeberangkatan;
        private String bandaraTujuan;
        private String waktuKeberangkatan;
        private String waktuKedatangan;
        private float hargaTiket;

        // Constructor
        public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, 
                            String bandaraTujuan, String waktuKeberangkatan, 
                            String waktuKedatangan, float hargaTiket) {
            this.nomorPenerbangan = nomorPenerbangan;
            this.bandaraKeberangkatan = bandaraKeberangkatan;
            this.bandaraTujuan = bandaraTujuan;
            this.waktuKeberangkatan = waktuKeberangkatan;
            this.waktuKedatangan = waktuKedatangan;
            this.hargaTiket = hargaTiket;
        }

        // Getter methods
        public String getNomorPenerbangan() {
            return nomorPenerbangan;
        }

        public void tampilDaftarPenerbangan() {
            System.out.println("Nomor Penerbangan: " + nomorPenerbangan);
            System.out.println("Bandara Keberangkatan: " + bandaraKeberangkatan);
            System.out.println("Bandara Tujuan: " + bandaraTujuan);
            System.out.println("Waktu Keberangkatan: " + waktuKeberangkatan);
            System.out.println("Waktu Kedatangan: " + waktuKedatangan);
            System.out.println("Harga Tiket: Rp" + hargaTiket);
            System.out.println("-------------------------------");
        }
    }

    // Class Penumpang
    static class Penumpang {
        private String NIK;
        private String namaDepan;
        private String namaBelakang;

        // Constructor
        public Penumpang(String NIK, String namaDepan, String namaBelakang) {
            this.NIK = NIK;
            this.namaDepan = namaDepan;
            this.namaBelakang = namaBelakang;
        }

        // Method untuk menampilkan daftar penumpang
        public void tampilDaftarPenumpang() {
            System.out.println("NIK: " + NIK);
            System.out.println("Nama: " + namaDepan + " " + namaBelakang);
            System.out.println("-------------------------------");
        }
    }

    // Main class Pembelian
    public static void main(String[] args) {
        // ArrayList untuk menyimpan data penerbangan
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();

        // Menambahkan data penerbangan
        daftarPenerbangan.add(new Penerbangan("GA123", "Soekarno-Hatta", "Ngurah Rai", "06:00", "08:00", 1500000));
        daftarPenerbangan.add(new Penerbangan("JT456", "Soekarno-Hatta", "Juanda", "09:00", "10:30", 900000));
        daftarPenerbangan.add(new Penerbangan("SQ789", "Changi", "Soekarno-Hatta", "14:00", "16:00", 2500000));

        // Scanner untuk input data dari user
        Scanner scanner = new Scanner(System.in);

        // Menampilkan daftar penerbangan
        System.out.println("Daftar Penerbangan Tersedia:");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            System.out.println("[" + (i + 1) + "] " + daftarPenerbangan.get(i).getNomorPenerbangan());
        }

        // Memilih penerbangan
        System.out.print("Pilih nomor penerbangan yang ingin dipesan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        if (pilihan < 1 || pilihan > daftarPenerbangan.size()) {
            System.out.println("Nomor penerbangan tidak valid.");
            return;
        }

        Penerbangan penerbanganTerpilih = daftarPenerbangan.get(pilihan - 1);

        // Memasukkan data penumpang
        System.out.print("Masukkan NIK: ");
        String NIK = scanner.nextLine();
        System.out.print("Masukkan Nama Depan: ");
        String namaDepan = scanner.nextLine();
        System.out.print("Masukkan Nama Belakang: ");
        String namaBelakang = scanner.nextLine();

        // Membuat objek Penumpang
        Penumpang penumpang = new Penumpang(NIK, namaDepan, namaBelakang);

        // Menampilkan detail pesanan
        System.out.println("\n--- Detail Pesanan Tiket ---");
        penerbanganTerpilih.tampilDaftarPenerbangan();
        penumpang.tampilDaftarPenumpang();

        System.out.println("Tiket berhasil dipesan!");
    }
}

