import java.util.Scanner;

public class NamaDanPerhitungan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            
            System.out.print("Masukkan nama kamu: ");
            String nama = scanner.nextLine();
            
            int jumlahKarakterNama = nama.length();
            
            System.out.print("Masukkan nilai A: ");
            int nilaiA = scanner.nextInt();
            
            System.out.print("Masukkan nilai B: ");
            int nilaiB = scanner.nextInt();
          
            if (nilaiB == 0) {
                throw new ArithmeticException("Error: Nilai B tidak boleh nol!");
            }

            int hasilPenjumlahan = nilaiA + jumlahKarakterNama;

            System.out.println("Jumlah karakter nama kamu: " + jumlahKarakterNama);
            System.out.println("Nilai A: " + nilaiA);
            System.out.println("Nilai B: " + nilaiB);
            System.out.println("Hasil penjumlahan nilai A dan jumlah karakter nama: " + hasilPenjumlahan);
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
