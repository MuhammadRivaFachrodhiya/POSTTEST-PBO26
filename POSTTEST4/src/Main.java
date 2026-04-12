import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void pressEnter(Scanner scanner) {
        System.out.print("\nTekan ENTER untuk melanjutkan...\n");
        scanner.nextLine();
    }

    public static int getValidInt(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                int input = scanner.nextInt();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Peringatan: Input tidak valid. Harap masukkan angka bulat!");
                scanner.nextLine();
            }
        }
    }

    public static double getValidDouble(Scanner scanner, String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                double input = scanner.nextDouble();
                scanner.nextLine();
                return input;
            } catch (InputMismatchException e) {
                System.out.println("Peringatan: Input tidak valid. Harap masukkan angka!");
                scanner.nextLine();
            }
        }
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

    public static void tampilkanDiskon(ArrayList<Mebel> daftar) {
        System.out.println("------------------------------------------------------------------------");
        System.out.println("| NO | KODE   | NAMA BARANG          | HARGA (RP)   | DISKON (RP)     |");
        System.out.println("------------------------------------------------------------------------");
        if (daftar.isEmpty()) {
            System.out.println("|                   BELUM ADA DATA BARANG DI DALAM STOK                |");
        } else {
            for (int i = 0; i < daftar.size(); i++) {
                Mebel m = daftar.get(i);
                // hitungDiskon() memanggil versi masing-masing subclass (Overriding)
                System.out.printf("| %-2d | %-6s | %-20s | %-12.0f | %-15.0f |\n",
                        (i + 1), m.getKode(), m.getNama(), m.getHarga(), m.hitungDiskon());
            }
        }
        System.out.println("------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        ArrayList<Mebel> daftarMebel = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan = 0;

        do {
            System.out.println("=============================================");
            System.out.println("          SISTEM MANAJEMEN TOKO MEBEL        ");
            System.out.println("=============================================");
            System.out.println("1. Tambah Data Barang");
            System.out.println("2. Lihat Data Barang");
            System.out.println("3. Simulasi Pembelian");
            System.out.println("4. Perbarui Data Barang");
            System.out.println("5. Hapus Data Barang");
            System.out.println("6. Keluar");

            pilihan = getValidInt(scanner, "Pilih Menu: ");

            switch (pilihan) {
                case 1:
                    System.out.println("--- INPUT BARANG BARU ---");
                    int jenis = getValidInt(scanner, "Kategori (1. Meja / 2. Kursi / 3. Lemari): ");

                    System.out.print("Nama Barang : ");
                    String nm = scanner.nextLine();
                    if (!nm.isEmpty()) {
                        nm = nm.substring(0, 1).toUpperCase() + nm.substring(1);
                    }

                    double hg = getValidDouble(scanner, "Harga Jual  : ");
                    int st = getValidInt(scanner, "Jumlah Stok : ");

                    if (jenis == 1) {
                        System.out.print("Bahan Utama : ");
                        String bh = scanner.nextLine();
                        daftarMebel.add(new Meja(nm, hg, st, bh));
                    } else if (jenis == 2) {
                        System.out.print("Tipe/Model  : ");
                        String tp = scanner.nextLine();
                        daftarMebel.add(new Kursi(nm, hg, st, tp));
                    } else if (jenis == 3) {
                        System.out.print("Jenis Pintu : ");
                        String jp = scanner.nextLine();
                        daftarMebel.add(new Lemari(nm, hg, st, jp));
                    } else {
                        System.out.println("Kategori tidak dikenali, gagal menambahkan barang.");
                    }

                    if (jenis >= 1 && jenis <= 3) {
                        System.out.println("\nPesan: Data berhasil ditambah dan disimpan.");
                    }
                    pressEnter(scanner);
                    break;

                case 2:
                    System.out.println("--- DAFTAR BARANG SAAT INI ---");
                    tampilkanTabel(daftarMebel);
                    System.out.println("\n--- INFORMASI DISKON PER KATEGORI ---");
                    tampilkanDiskon(daftarMebel);
                    pressEnter(scanner);
                    break;

                case 3:
                    System.out.println("--- SIMULASI PEMBELIAN ---");
                    tampilkanTabel(daftarMebel);
                    if (!daftarMebel.isEmpty()) {
                        int idB = getValidInt(scanner, "Pilih Nomor Urut Barang: ") - 1;
                        if (idB >= 0 && idB < daftarMebel.size()) {
                            Mebel barang = daftarMebel.get(idB);
                            int jumlah = getValidInt(scanner, "Jumlah yang Dibeli     : ");

                            System.out.println("\n--- RINGKASAN PEMBELIAN ---");
                            System.out.println("Barang       : " + barang.getNama());
                            System.out.println("Harga Satuan : Rp " + String.format("%.0f", barang.getHarga()));
                            System.out.println("Diskon/Unit  : Rp " + String.format("%.0f", barang.hitungDiskon()));

                            double totalTanpaDiskon = barang.hitungTotal(jumlah);
                            double diskonSatuan = barang.hitungDiskon();
                            double persenDiskon = (diskonSatuan / barang.getHarga()) * 100;
                            double totalDenganDiskon = barang.hitungTotal(jumlah, persenDiskon);

                            System.out.println("Total (tanpa diskon) : Rp " + String.format("%.0f", totalTanpaDiskon));
                            System.out.println("Total (dengan diskon): Rp " + String.format("%.0f", totalDenganDiskon));
                            System.out.println("Anda hemat           : Rp " + String.format("%.0f", (totalTanpaDiskon - totalDenganDiskon)));
                        } else {
                            System.out.println("\nPesan: Nomor urut tidak valid.");
                        }
                    }
                    pressEnter(scanner);
                    break;

                case 4:
                    System.out.println("--- EDIT DATA BARANG ---");
                    tampilkanTabel(daftarMebel);
                    if (!daftarMebel.isEmpty()) {
                        int idU = getValidInt(scanner, "Pilih Nomor Urut Barang: ") - 1;
                        if (idU >= 0 && idU < daftarMebel.size()) {
                            Mebel selected = daftarMebel.get(idU);
                            System.out.println("\nApa yang ingin diubah?");
                            System.out.println("1. Nama Barang");
                            System.out.println("2. Harga Barang");
                            System.out.println("3. Stok Barang");

                            int subPilih = getValidInt(scanner, "Pilih (1-3): ");

                            switch(subPilih) {
                                case 1:
                                    System.out.print("Masukkan Nama Baru: ");
                                    String newName = scanner.nextLine();
                                    if (!newName.isEmpty()) {
                                        newName = newName.substring(0, 1).toUpperCase() + newName.substring(1);
                                    }
                                    selected.setNama(newName);
                                    System.out.println("Nama berhasil diperbarui!");
                                    break;
                                case 2:
                                    selected.setHarga(getValidDouble(scanner, "Masukkan Harga Baru: "));
                                    System.out.println("Harga berhasil diperbarui!");
                                    break;
                                case 3:
                                    selected.setStok(getValidInt(scanner, "Masukkan Stok Baru: "));
                                    System.out.println("Stok berhasil diperbarui!");
                                    break;
                                default:
                                    System.out.println("Pilihan tidak tersedia.");
                            }
                        } else {
                            System.out.println("\nPesan: Nomor urut tidak valid.");
                        }
                    }
                    pressEnter(scanner);
                    break;

                case 5:
                    System.out.println("--- HAPUS DATA BARANG ---");
                    tampilkanTabel(daftarMebel);
                    if (!daftarMebel.isEmpty()) {
                        int idH = getValidInt(scanner, "Pilih Nomor Urut: ") - 1;
                        if (idH >= 0 && idH < daftarMebel.size()) {
                            daftarMebel.remove(idH);
                            System.out.println("\nPesan: Data dihapus.");
                        } else {
                            System.out.println("\nPesan: Nomor urut tidak valid.");
                        }
                    }
                    pressEnter(scanner);
                    break;
            }
        } while (pilihan != 6);
        scanner.close();
    }
}