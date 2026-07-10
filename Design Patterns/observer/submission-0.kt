interface Observer {
    fun notify(itemName: String)
}

class Customer(private val name: String) : Observer {
    private var notifications: Int = 0

    override fun notify(itemName: String) {
        notifications += 1
    }

    fun countNotifications(): Int = notifications
}

class OnlineStoreItem(private val itemName: String, private var stock: Int) {
    private val subscribers = mutableSetOf<Observer>()

    fun subscribe(observer: Observer) {
        subscribers.add(observer)
    }

    fun unsubscribe(observer: Observer) {
        subscribers.remove(observer)
    }

    fun updateStock(newStock: Int) {
        if (stock == 0 && newStock > 0) {
            subscribers.forEach { it.notify(itemName) }
        }
        stock = newStock
    }
}
