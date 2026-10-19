import java.util.Scanner;

public class Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap so phan tu n: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("n phai lon hon 0.");
            sc.close();
            return;
        }

        int[] a = new int[n];
        int tong = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("a[" + i + "] = ");
            a[i] = sc.nextInt();
            tong += a[i];
        }

        System.out.print("Mang vua nhap: ");
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println("\\nTong cac phan tu: " + tong);

        sc.close();
    }
}
