import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<PhanSo> danhSach = new ArrayList<>();

        System.out.print("Nhap so luong phan so: ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Nhap phan so thu " + (i + 1) + ":");
            System.out.print("  Tu so: ");
            int ts = sc.nextInt();
            System.out.print("  Mau so: ");
            int ms = sc.nextInt();

            while (ms == 0) {
                System.out.print("  Mau so phai khac 0, vui long nhap lai mau so: ");
                ms = sc.nextInt();
            }

            danhSach.add(new PhanSo(ts, ms));
        }

        if (danhSach.isEmpty()) {
            System.out.println("Tap hop rong!");
            sc.close();
            return;
        }

        System.out.println("\n--- DANH SACH PHAN SO ĐA NHAP ---");
        for (PhanSo ps : danhSach) {
            System.out.print(ps + "  ");
        }
        System.out.println();

        // Tìm phân số lớn
        PhanSo maxPs = danhSach.get(0);
        for (int i = 1; i < danhSach.size(); i++) {
            if (danhSach.get(i).soSanh(maxPs) > 0) {
                maxPs = danhSach.get(i);
            }
        }
        System.out.println("\n1. Phan so lon nhat: " + maxPs);

        // Tính tổng 
        PhanSo tong = new PhanSo(0, 1);
        for (PhanSo ps : danhSach) {
            tong = tong.cong(ps);
        }
        System.out.println("2. Tong cac phan so: " + tong);

        // hàm đếm 
        int demKhongNguyen = 0;
        for (PhanSo ps : danhSach) {
            if (!ps.laSoNguyen()) {
                demKhongNguyen++;
            }
        }
        System.out.println("3. So luong phan so khong phai la so nguyen: " + demKhongNguyen);

        sc.close();
    }
}