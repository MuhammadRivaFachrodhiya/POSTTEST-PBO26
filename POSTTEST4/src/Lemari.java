public class Lemari extends Mebel {
    private String jenisPintu;
    static int counter = 1;

    public Lemari(String nama, double harga, int stok, String jenisPintu) {
        super("LMR" + counter, nama, harga, stok);
        this.jenisPintu = jenisPintu;
        counter++;
    }

    public String getJenisPintu() {
        return jenisPintu;
    }

    public void setJenisPintu(String jenisPintu) {
        this.jenisPintu = jenisPintu;
    }

    @Override
    public double hitungDiskon() {
        return getHarga() * 0.07;
    }

    // METHOD OVERRIDING 2:
    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", jenisPintu);
    }
}