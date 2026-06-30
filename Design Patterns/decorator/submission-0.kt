abstract class Coffee {
    abstract fun getCost(): Double
}

class SimpleCoffee : Coffee() {
    override fun getCost(): Double = 1.1
}

abstract class CoffeeDecorator(protected val decoratedCoffee: Coffee) : Coffee() {
    override fun getCost(): Double = decoratedCoffee.getCost()
}

class MilkDecorator(private val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double = coffee.getCost() + 0.5
}

class SugarDecorator(private val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double = coffee.getCost() + 0.2
}

class CreamDecorator(private val coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double = coffee.getCost() + 0.7
}
