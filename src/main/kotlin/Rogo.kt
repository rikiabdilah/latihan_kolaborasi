fun main() {
    val menu = listOf(
        Item("nasi goreng", 12000),
        Item("mie goreng", 10000),
        Item("Ayam Goreng", 15000),
        Item("eh teh", 3000),
        Item("es jeruk", 5000),
    )

    val orders = mutableListOf<Order>()
    var isOrdering = true
    while (isOrdering) {
        println("Daftar Menu :")
        for (i in menu.indices) {
            println("${i + 1}. ${menu[i].name} (Rp${menu[i].price})")
        }
        println("menu yang di pesan :")
        val menuIndex = readLine()!!.toInt() - 1
        println("Jumlah : ")
        val quality = readLine()!!.toInt()
        orders.add(Order(menu[menuIndex], quality))

        var totalPrice = 0
        for (order in orders) {
            totalPrice += order.getTotalPrice()
            println(order)

        }
        println("\nTotal Harga: Rp$totalPrice")
    }
}


class Item(val name: String, val price: Int)

class Order(val item: Item, var quantity: Int){
    fun getTotalPrice(): Int = item.price * quantity

    override fun toString(): String{
        return "Item : ${item.name}\n jumlah : $quantity\n harga/item : ${item.price}"
    }
}