package TH9;

public class HangTu {
    private double heSo;
    private int soMu;
    private HangTu keTiep;

    private HangTu(double heso, int somu) {
        this.heSo = heso;
        this.soMu = somu;
    }
    public static HangTu getHangTu(double heso, int somu) throws IllegalArgumentException{
        if(somu < 0){
            throw new IllegalArgumentException("somu < 0");
        }
        return new HangTu(heso, somu);
    }

    public void setSoMu(int soMu) {
        this.soMu = soMu;
    }

    public void setHeSo(double heSo) {
        this.heSo = heSo;
    }

    public double getHeSo() {
        return heSo;
    }

    public int getSoMu() {
        return soMu;
    }

    public HangTu getKeTiep() {
        return keTiep;
    }

    public void setKeTiep(HangTu keTiep) {
        this.keTiep = keTiep;
    }

}
