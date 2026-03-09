import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void pressEnter(Scanner scanner) {
        System.out.print("\nTekan ENTER untuk melanjutkan...\n");
        scanner.nextLine();
    }
    public static void tampilkanTabel(ArrayList<Mebel> daftar) {
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("| NO | KODE   | NAMA BARANG          | HARGA (RP)   | STOK  | KETERANGAN      |");
        System.out.println("-------------------------------------------------------------------------------");
        if (daftar.isEmpty()) {
            System.out.println("|                      BELUM ADA DATA BARANG DI DALAM STOK                    |");
        } else {
            for (int i = 0; i < daftar.size(); i++) {
                System.out.printf("| %-2d ", (i + 1));
                daftar.get(i).tampilkanBaris();
            }
        }
        System.out.println("-------------------------------------------------------------------------------");
    }
    public static void main(String[] args) {
        ArrayList<Mebel> daftarMebel = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;
        do {
            System.out.println("=============================================");
            System.out.println("          SISTEM MANAJEMEN TOKO MEBEL        ");
            System.out.println("=============================================");
            System.out.println("1. Tambah Data Barang");
            System.out.println("2. Lihat Data Barang");
            System.out.println("3. Perbarui Data Barang");
            System.out.println("4. Hapus Data Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih Menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();
            switch (pilihan) {
                case 1:
                    System.out.println("--- INPUT BARANG BARU ---");
                    System.out.print("Kategori (1. Meja / 2. Kursi): ");
                    int jenis = scanner.nextInt(); scanner.nextLine();
                    System.out.print("Nama Barang : "); String nm = scanner.nextLine();
                    System.out.print("Harga Jual  : "); double hg = scanner.nextDouble();
                    System.out.print("Jumlah Stok : "); int st = scanner.nextInt(); scanner.nextLine();
                    if (jenis == 1) {
                        System.out.print("Bahan Utama : "); String bh = scanner.nextLine();
                        daftarMebel.add(new Meja(nm, hg, st, bh));
                    } else {
                        System.out.print("Tipe/Model  : "); String tp = scanner.nextLine();
                        daftarMebel.add(new Kursi(nm, hg, st, tp));
                    }
                    System.out.println("\nPesan: Data berhasil ditambah dan disimpan.");
                    pressEnter(scanner);
                    break;
                case 2:
                    System.out.println("--- DAFTAR BARANG SAAT INI ---");
                    tampilkanTabel(daftarMebel);
                    pressEnter(scanner);
                    break;
                case 3:
                    System.out.println("--- EDIT DATA BARANG ---");
                    tampilkanTabel(daftarMebel);
                    if (!daftarMebel.isEmpty()) {
                        System.out.print("Pilih Nomor Urut Barang: ");
                        int idU = scanner.nextInt() - 1;
                        if (idU >= 0 && idU < daftarMebel.size()) {
                            Mebel selected = daftarMebel.get(idU);
                            System.out.println("\nApa yang ingin diubah?");
                            System.out.println("1. Nama Barang");
                            System.out.println("2. Harga Barang");
                            System.out.println("3. Stok Barang");
                            System.out.print("Pilih (1-3): ");
                            int subPilih = scanner.nextInt();
                            scanner.nextLine();
                            switch(subPilih) {
                                case 1:
                                    System.out.print("Masukkan Nama Baru: ");
                                    selected.nama = scanner.nextLine();
                                    System.out.println("Nama berhasil diperbarui!");
                                    break;
                                case 2:
                                    System.out.print("Masukkan Harga Baru: ");
                                    selected.harga = scanner.nextDouble();
                                    scanner.nextLine();
                                    System.out.println("Harga berhasil diperbarui!");
                                    break;
                                case 3:
                                    System.out.print("Masukkan Stok Baru: ");
                                    selected.stok = scanner.nextInt();
                                    scanner.nextLine();
                                    System.out.println("Stok berhasil diperbarui!");
                                    break;
                                default:
                                    System.out.println("Pilihan tidak tersedia.");
                            }
                        } else {
                            System.out.println("\nPesan: Nomor urut tidak valid.");
                        }
                    }
                    break;
                case 4:
                    System.out.println("--- HAPUS DATA BARANG ---");
                    tampilkanTabel(daftarMebel);
                    if (!daftarMebel.isEmpty()) {
                        System.out.print("Pilih Nomor Urut: ");
                        int idH = scanner.nextInt() - 1;
                        if (idH >= 0 && idH < daftarMebel.size()) {
                            daftarMebel.remove(idH);
                            System.out.println("\nPesan: Data dihapus.");
                        }
                    }
                    pressEnter(scanner);
                    break;
            }
        } while (pilihan != 5);
        scanner.close();
    }
}