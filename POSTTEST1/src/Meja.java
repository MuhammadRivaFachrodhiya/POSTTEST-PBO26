class Meja extends Mebel {
    String bahan;
    static int counter = 1;

    Meja(String nama, double harga, int stok, String bahan) {
        super("MJ" + counter, nama, harga, stok);
        this.bahan = bahan;
        counter++;
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", bahan);
    }
}