import java.util.Scanner;

public class tryCatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan nilai A (int): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Harap masukkan angka!");
            scanner.close();
            return;
        }
        int a = scanner.nextInt();

        System.out.print("Masukkan nilai B (int): ");
        if (!scanner.hasNextInt()) {
            System.out.println("Error: Harap masukkan angka!");
            scanner.close();
            return;
        }
        int b = scanner.nextInt();

        try {
            int hasil = a / b;
            System.out.println("Hasil Pembagian = " + hasil);
        } catch (ArithmeticException e) {
            System.out.println("Error: Tidak bisa dibagi dengan 0");
        } finally {
            scanner.close();
            System.out.println("Terima Kasih :)");
        }
    }
}