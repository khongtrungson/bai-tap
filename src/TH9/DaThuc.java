package TH9;

class DaThuc {
    private HangTu dau;

    public DaThuc(HangTu dau) {
        this.dau = dau;
    }
    public DaThuc() {
        this.dau = null;
    }

    public void themHangTu(double heSo, int soMu) {
        if (heSo == 0) return;
        HangTu moi = HangTu.getHangTu(heSo, soMu);
        // tạo hạng tử mới
        HangTu hienTai = dau;
        if (dau == null) {
            dau = moi;
        }
        // duyệt hạng tử
        HangTu preHantu = null;
        while (hienTai != null && hienTai.getSoMu() >= soMu) {
            if (hienTai.getSoMu() == soMu) {
                hienTai.setHeSo(hienTai.getHeSo() + moi.getHeSo());
                // cập nhập hệ so nếu so mu bằng nhau
                if (hienTai.getHeSo() == 0 && preHantu == null) {
                    dau = null;
                    return;
                } else if (hienTai.getHeSo() != 0 && preHantu != null) {
                }
                preHantu.setKeTiep(hienTai.getKeTiep());
                return;
                // kĩ thuật hai con trỏ
            }
        }
        preHantu = hienTai;
        hienTai = hienTai.getKeTiep();
    }


    public DaThuc nhanHangTu(double heSo, int soMu) {
        DaThuc ketQua = new DaThuc();
        HangTu hienTai = dau;
        while (hienTai != null) {
            ketQua.themHangTu(hienTai.getHeSo() * heSo, hienTai.getSoMu() + soMu);
            hienTai = hienTai.getKeTiep();
        }
        return ketQua;
    }

    public DaThuc congDaThuc(DaThuc b) {
        DaThuc ketQua = new DaThuc();
        HangTu aHienTai = this.dau, bHienTai = b.dau;
        while (aHienTai != null || bHienTai != null) {
            if (bHienTai == null || (aHienTai != null && aHienTai.getSoMu() > bHienTai.getSoMu())) {
                ketQua.themHangTu(aHienTai.getHeSo(), aHienTai.getSoMu());
                aHienTai = aHienTai.getKeTiep();
            } else if (aHienTai == null || (bHienTai != null && bHienTai.getSoMu() > aHienTai.getSoMu())) {
                ketQua.themHangTu(bHienTai.getHeSo(), bHienTai.getSoMu());
                bHienTai = bHienTai.getKeTiep();
            } else {
                ketQua.themHangTu(aHienTai.getHeSo() + bHienTai.getHeSo(), aHienTai.getSoMu());
                aHienTai = aHienTai.getKeTiep();
                bHienTai = bHienTai.getKeTiep();
            }
        }
        return ketQua;
    }

    public void inDaThuc() {
        HangTu hienTai = dau;
        while (hienTai != null) {
            if (hienTai.getHeSo() > 0 && hienTai != dau) System.out.print(" + ");
            System.out.print(hienTai.getHeSo() + "X^" + hienTai.getSoMu());
            hienTai = hienTai.getKeTiep();
        }
        System.out.println();
    }

    public double tinhGiaTri(double x) {
        double ketQua = 0;
        HangTu hienTai = dau;
        while (hienTai != null) {
            ketQua += hienTai.getHeSo() * Math.pow(x, hienTai.getSoMu());
            hienTai = hienTai.getKeTiep();
        }
        return ketQua;
    }

}
