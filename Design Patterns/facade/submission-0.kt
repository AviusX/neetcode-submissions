class Order(private val contents: String, private val takeOut: Boolean) {
    fun getOrder(): String = contents
    fun isTakeOut(): Boolean = takeOut
}

class Cashier {
    fun takeOrder(contents: String, takeOut: Boolean): Order {
        return Order(contents, takeOut)
    }
}

open class Food(private val contents: String) {
    fun getFood(): String = contents
}

class Chef {
    fun prepareFood(order: Order): Food {
        return Food(order.getOrder())
    }
}

class PackagedFood(food: Food) : Food(food.getFood() + " in a bag")

class KitchenStaff {
    fun packageOrder(food: Food): PackagedFood {
        return PackagedFood(food)
    }
}

class DriveThruFacade {
    private val cashier = Cashier()
    private val chef = Chef()
    private val kitchenStaff = KitchenStaff()

    fun takeOrder(orderContents: String, takeOut: Boolean): Food {
        val order = cashier.takeOrder(orderContents, takeOut)
        val preparedFood = chef.prepareFood(order)
        return if (takeOut) kitchenStaff.packageOrder(preparedFood) else preparedFood
    }
}
