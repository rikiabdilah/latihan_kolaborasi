fun main() {
    val menu = mapOf("nasi goreng" to 12000, "mie goreng" to 10000, "ayam goreng" to 15000, "es teh" to 3000, "es jeruk" to 5000)

    println("Daftar Menu:")
    menu.forEach { (item, harga) ->
        println("$item - Rp $harga")
    }

    val pesanan = mutableMapOf<String, Int>()
    var isSelesai = false

    while (!isSelesai) {
        print("Pilih item menu (ketik 'selesai' untuk keluar): ")
        val item = readLine()

        if (item.equals("selesai", ignoreCase = true)) {
            isSelesai = true
        } else {
            print("Jumlah pesanan: ")
            val jumlah = readLine()?.toInt()

            if (jumlah != null) {
                pesanan[item ?: ""] = jumlah
            }
        }
    }

    var totalHarga = 0
    println("===========Struk==================")

    pesanan.forEach { (item, jumlah) ->
        val harga = menu[item] ?: 0
        val subtotal = harga * jumlah

        if (harga > 0) {
            println("Item: $item x $jumlah = Rp $subtotal")
            totalHarga += subtotal
        }
    }

    println("Total Harga: Rp $totalHarga")
}
