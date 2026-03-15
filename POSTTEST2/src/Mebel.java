public abstract class Mebel {
    protected String kode;
    private String nama;
    private double harga;
    private int stok;

    public Mebel(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        if (harga >= 0) {
            this.harga = harga;
        } else {
            this.harga = 0;
        }
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        if (stok >= 0) {
            this.stok = stok;
        } else {
            this.stok = 0;
        }
    }

    void tampilkanBaris() {
        System.out.printf("| %-6s | %-20s | %-12.0f | %-5d ", kode, nama, harga, stok);
    }
}