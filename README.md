# Proyek Pengujian API dengan RestAssured dan TestNG
Proyek ini bertujuan untuk menguji berbagai endpoint dari FakeStoreAPI menggunakan RestAssured dan TestNG untuk memastikan fungsionalitas fitur utama seperti pengelolaan keranjang dan pengambilan informasi produk. Pengujian mencakup fitur seperti menambahkan keranjang baru, mengambil detail keranjang, memfilter keranjang berdasarkan tanggal, membatasi jumlah produk yang ditampilkan, mengurutkan produk, dan mengambil semua produk.

## Teknologi yang Digunakan
* RestAssured: Untuk pengujian API dan pengiriman permintaan HTTP.
* TestNG: Untuk struktur pengujian, pengelolaan kasus uji, dan penegakan aturan.
* FakeStoreAPI: digunakan untuk pengujian fungsionalitas terkait e-commerce.

# Skenario Pengujian
* Add New Cart: Menguji kemampuan untuk membuat keranjang baru untuk pengguna dengan produk tertentu.
* Get User Cart: Memverifikasi apakah detail keranjang yang benar dapat diambil berdasarkan pengguna.
* Get Single Product: Memastikan bahwa detail produk dapat diambil menggunakan ID produk.
* Filter Carts by Date: Memfilter data keranjang berdasarkan rentang tanggal yang ditentukan.
* Validate Product Limit: Menguji apakah jumlah produk yang dikembalikan dari API dapat dibatasi (misalnya, hanya 3 produk).
* Validate Sorting Order: Memverifikasi apakah produk dapat diurutkan dalam urutan menaik atau menurun.
* Get All Products: Mengambil dan memvalidasi daftar semua produk yang tersedia di toko.

# Cara Menjalankan Pengujian
1. Clone repository ini ke directory local kamu

   ````git clone https://github.com/username/repository-name.git````
2. Buka proyek ini di IntelliJ IDEA.
3. Pastikan semua dependensi yang dibutuhkan (RestAssured, TestNG, dll.) sudah terinstal.
4. Jalankan pengujian menggunakan konfigurasi TestNG dari IDE:

  * Klik kanan pada file test atau folder yang berisi pengujian.
  * Pilih Run 'TestNG'.
5. Periksa hasilnya di tab Run untuk melihat status berhasil/gagal.

# Hasil Test
![Screenshot 2024-12-09 144427](https://github.com/user-attachments/assets/43d06d3f-0743-4615-a23b-13034936d58c) ![Screenshot 2024-12-09 144409](https://github.com/user-attachments/assets/3a0b63e0-b63a-461e-9642-6b2940b886e0)

# Fitur Utama
1. Pengujian API Otomatis: Semua pengujian diotomatisasi untuk memastikan validasi yang konsisten terhadap perilaku API.
2. Dapat Diperluas: Mudah untuk menambahkan lebih banyak kasus uji dan memperluas fungsionalitas sesuai kebutuhan.
3. Penegakan Validasi yang Jelas: Pemeriksaan mendalam untuk memvalidasi kebenaran respons API.

# Kesimpulan
Proyek ini memastikan bahwa endpoint FakeStoreAPI berfungsi dengan baik dengan menguji berbagai fungsionalitas yang penting untuk platform e-commerce. Pengujian ini dirancang untuk sederhana namun efektif, memvalidasi semua aspek penting dari pengelolaan produk dan keranjang.

