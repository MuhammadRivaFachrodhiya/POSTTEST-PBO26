public class Meja extends Mebel {
    private String bahan;
    static int counter = 1;

    public Meja(String nama, double harga, int stok, String bahan) {
        super("MJ" + counter, nama, harga, stok);
        this.bahan = bahan;
        counter++;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        this.bahan = bahan;
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", bahan);
    }
}