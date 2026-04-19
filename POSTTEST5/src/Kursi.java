// File: Kursi.java
public class Kursi extends Mebel implements Perawatan {
    private String tipe;
    static int counter = 1;

    public Kursi(String nama, double harga, int stok, String tipe) {
        super("KRS" + counter, nama, harga, stok);
        this.tipe = tipe;
        counter++;
    }

    public String getTipe() { return tipe; }
    public void setTipe(String tipe) { this.tipe = tipe; }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.10; // Diskon 10%
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", tipe);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Hindari kursi dari paparan sinar matahari langsung agar warna tidak pudar.");
    }

    @Override
    public boolean butuhPerakitan() {
        return false;
    }
}