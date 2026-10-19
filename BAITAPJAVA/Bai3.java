import java.util.Scanner;

public class Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap cac so nguyen, cach nhau boi dau cach: ");
        String chuoi = sc.nextLine().trim();

        if (chuoi.isEmpty()) {
            System.out.println("So phan tu: 0");
            System.out.println("Tong: 0");
            sc.close();
            return;
        }

        String[] ds = chuoi.split("\\s+");
        int tong = 0;

        try {
            for (String s : ds) {
                tong += Integer.parseInt(s);
            }

            System.out.println("So phan tu: " + ds.length);
            System.out.println("Tong: " + tong);
        } catch (NumberFormatException e) {
            System.out.println("Du lieu khong hop le. Vui long chi nhap so nguyen.");
        }

        sc.close();
    }
}
