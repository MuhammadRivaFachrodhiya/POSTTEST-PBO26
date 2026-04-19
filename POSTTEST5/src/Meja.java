// File: Meja.java
public class Meja extends Mebel implements Perawatan {
    private String bahan;
    static int counter = 1;

    public Meja(String nama, double harga, int stok, String bahan) {
        super("MJ" + counter, nama, harga, stok);
        this.bahan = bahan;
        counter++;
    }

    public String getBahan() { return bahan; }
    public void setBahan(String bahan) { this.bahan = bahan; }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.05;
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", bahan);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Lap meja menggunakan cairan pembersih kayu secara berkala.");
    }

    @Override
    public boolean butuhPerakitan() {
        return true;
    }
}