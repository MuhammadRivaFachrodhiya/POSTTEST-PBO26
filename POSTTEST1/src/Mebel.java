class Mebel {
    String kode;
    String nama;
    double harga;
    int stok;

    Mebel(String kode, String nama, double harga, int stok) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }
    void tampilkanBaris() {
        System.out.printf("| %-6s | %-20s | %-12.0f | %-5d ", kode, nama, harga, stok);
    }
}