fun main() {
    val items = arrayOf("Nasi Goreng", "Mie Goreng", "Ayam Goreng", "Es Teh Manis", "Jeruk Nipis")
    val harga = arrayOf(12000, 10000, 15000, 5000, 6000)
    val order = mutableMapOf<String, Int>()
    var Ordering = true
    while (Ordering) {
        println("Daftar Menu: ")
        for (i in items.indices) {
            println("${i + 1}. ${items[i]} - Rp${harga[i]}")
        }

        // jika sudah memilih menu masukkan angka 0 untuk menyelesaikan pembayaran
        print("Masukkan nomor menu yang dipesan (ketik '0' jika selesai): ")
        val choice = readLine()!!.toInt()
        if (choice == 0) {
            Ordering = false
        } else if (choice in 1..items.size) {
            print("Masukkan jumlah pesanan: ")
            val quantity = readLine()!!.toInt()
            val item = items[choice - 1]
            order[item] = order.getOrDefault(item, 0) + quantity
        } else {
            println("Menu tidak tersedia!")
        }
    }
    var total = 0
    println("\n=========== Struk ===============")
    for ((item, quantity) in order) {
        val price = harga[items.indexOf(item)]
        val subtotal = price * quantity
        total += subtotal
        println("Item: $item \nJumlah: $quantity \nHarga/item: $price \nSubtotal: $subtotal\n")
    }
    println("Total harga: $total")
}