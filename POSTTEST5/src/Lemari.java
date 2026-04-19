// File: Lemari.java
public class Lemari extends Mebel implements Perawatan {
    private String jenisPintu;
    static int counter = 1;

    public Lemari(String nama, double harga, int stok, String jenisPintu) {
        super("LMR" + counter, nama, harga, stok);
        this.jenisPintu = jenisPintu;
        counter++;
    }

    public String getJenisPintu() { return jenisPintu; }
    public void setJenisPintu(String jenisPintu) { this.jenisPintu = jenisPintu; }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.07; // Diskon 7%
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", jenisPintu);
    }

    @Override
    public void caraPerawatan() {
        System.out.println("Berikan kamper di dalam lemari untuk mencegah kelembaban dan jamur.");
    }

    @Override
    public boolean butuhPerakitan() {
        return true;
    }
}