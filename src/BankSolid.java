public class BankSolid {
    public static void main(String[] args) {
        Tabungan ani = new Tabungan("101", "Ani", 1000000, 2.5);
        Tabungan citra = new Tabungan("102", "Citra", 300000, 2.0);
        Giro budi = new Giro("201", "Budi", 200000, 500000);
        Deposito dewi = new Deposito("301", "Dewi", 5000000, 4.0);

        Rekening[] semua = { ani, citra, budi, dewi };
        BerBunga[] berbunga = { ani, citra, dewi };
        BisaDitarik[] bisaDitarik = { ani, citra, budi };

        Notifikasi notifikasi = new SmsNotifikasi();
        // Langkah 7: ganti baris di atas menjadi
        //   Notifikasi notifikasi = new SmsNotifikasi();
        // Baris yang perlu diubah: 1 baris (hanya di main; ProsesAkhirBulan tidak diubah).

        ProsesAkhirBulan proses = new ProsesAkhirBulan(notifikasi);
        LaporanBank laporan = new LaporanBank();

        // Langkah 6 (percobaan, sudah dihapus):
        //   BisaDitarik[] salah = { ani, dewi };
        // Pesan error: incompatible types: Deposito cannot be converted to BisaDitarik
        // Penyebab: Deposito tidak meng-implement BisaDitarik, jadi tidak boleh masuk array tersebut.

        laporan.cetakDaftar("========== REKENING AWAL ==========", semua);
        System.out.println();
        System.out.println("========== AKHIR BULAN ============");
        proses.potongBiayaAdmin(semua);
        proses.tambahBunga(berbunga);
        proses.autodebet(bisaDitarik, 50000);
        System.out.println();
        laporan.cetakDaftar("========== REKENING AKHIR =========", semua);
        laporan.cetakTotal(semua);
    }
}