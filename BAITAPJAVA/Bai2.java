import java.util.Scanner;

public class Bai2 {

    // Cong hai mang theo tung vi tri.
    // Neu mot mang ngan hon, xem phan tu bi thieu la 0.
    public static int[] tinhTongMang(int[] a, int[] b) {
        int n = Math.max(a.length, b.length);
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            int x = (i < a.length) ? a[i] : 0;
            int y = (i < b.length) ? b[i] : 0;
            c[i] = x + y;
        }

        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu mang a: ");
        int n = sc.nextInt();
        if (n < 0) {
            System.out.println("So phan tu khong duoc am.");
            sc.close();
            return;
        }

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
        }

        System.out.print("Nhap so phan tu mang b: ");
        int m = sc.nextInt();
        if (m < 0) {
            System.out.println("So phan tu khong duoc am.");
            sc.close();
            return;
        }

        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            System.out.print("b[" + i + "] = ");
            b[i] = sc.nextInt();
        }

        int[] c = tinhTongMang(a, b);

        System.out.print("Mang tong: ");
        for (int x : c) {
            System.out.print(x + " ");
        }
        System.out.println();

        sc.close();
    }
}
