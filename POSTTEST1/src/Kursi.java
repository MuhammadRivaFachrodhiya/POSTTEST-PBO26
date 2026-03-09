// File: Kursi.java
class Kursi extends Mebel {
    String tipe;
    static int counter = 1;

    Kursi(String nama, double harga, int stok, String tipe) {
        super("KRS" + counter, nama, harga, stok);
        this.tipe = tipe;
        counter++;
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", tipe);
    }
}