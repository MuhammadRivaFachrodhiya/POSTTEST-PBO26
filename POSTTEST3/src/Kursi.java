public class Kursi extends Mebel {
    private String tipe;
    static int counter = 1;

    public Kursi(String nama, double harga, int stok, String tipe) {
        super("KRS" + counter, nama, harga, stok);
        this.tipe = tipe;
        counter++;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    @Override
    void tampilkanBaris() {
        super.tampilkanBaris();
        System.out.printf("| %-15s |\n", tipe);
    }
}