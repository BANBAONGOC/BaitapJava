public class PhanSo {

    private int tuSo;
    private int mauSo;

    public PhanSo() {
        this.tuSo = 0;
        this.mauSo = 1;
    }

    // Hàm tạo có đối số
    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0!");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
        chuanHoaDau();
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        if (mauSo == 0) {
            throw new IllegalArgumentException("Mau so khong the bang 0!");
        }
        this.mauSo = mauSo;
        chuanHoaDau();
    }

    private void chuanHoaDau() {
        if (this.mauSo < 0) {
            this.tuSo = -this.tuSo;
            this.mauSo = -this.mauSo;
        }
    }

    // Tìm ước chung lớn nhất 
    private int timUCLN(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a == 0 ? 1 : a;
    }

    // Rút gọn
    public PhanSo rutGon() {
        int ucln = timUCLN(this.tuSo, this.mauSo);
        this.tuSo /= ucln;
        this.mauSo /= ucln;
        chuanHoaDau();
        return this;
    }

    // Cộng 
    public PhanSo cong(PhanSo ps) {
        int ts = this.tuSo * ps.mauSo + ps.tuSo * this.mauSo;
        int ms = this.mauSo * ps.mauSo;
        return new PhanSo(ts, ms).rutGon();
    }

    // trừ
    public PhanSo tru(PhanSo ps) {
        int ts = this.tuSo * ps.mauSo - ps.tuSo * this.mauSo;
        int ms = this.mauSo * ps.mauSo;
        return new PhanSo(ts, ms).rutGon();
    }

    // hàm nhân
    public PhanSo nhan(PhanSo ps) {
        int ts = this.tuSo * ps.tuSo;
        int ms = this.mauSo * ps.mauSo;
        return new PhanSo(ts, ms).rutGon();
    }

    // hàm chia
    public PhanSo chia(PhanSo ps) {
        if (ps.tuSo == 0) {
            throw new ArithmeticException("Khong the chia cho phan so co tu bang 0!");
        }
        int ts = this.tuSo * ps.mauSo;
        int ms = this.mauSo * ps.tuSo;
        return new PhanSo(ts, ms).rutGon();
    }

    // So sánh 
    public int soSanh(PhanSo ps) {
        long v1 = (long) this.tuSo * ps.mauSo;
        long v2 = (long) ps.tuSo * this.mauSo;
        return Long.compare(v1, v2);
    }

    // Kiểm tra phân số 
    public boolean laSoNguyen() {
        return this.tuSo % this.mauSo == 0;
    }

    @Override
    public String toString() {
        if (this.mauSo == 1) {
            return String.valueOf(this.tuSo);
        }
        return this.tuSo + "/" + this.mauSo;
    }
}