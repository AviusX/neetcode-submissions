class Meal {
    private var cost: Double = 0.0
    private var takeOut: Boolean = false
    private var main: String? = null
    private var drink: String? = null

    constructor(cost: Double?, takeOut: Boolean? = false, main: String?, drink: String?) {
        if (cost != null) {
            this.cost = cost
        }

        if (takeOut != null) {
            this.takeOut = takeOut
        }

        if (main != null) {
            this.main = main
        }

        if (drink != null) {
            this.drink = drink
        }
    }

    fun getCost(): Double = cost
    fun getTakeOut(): Boolean = takeOut
    fun getMain(): String? = main
    fun getDrink(): String? = drink

    fun setCost(cost: Double) { this.cost = cost }
    fun setTakeOut(takeOut: Boolean) { this.takeOut = takeOut }
    fun setMain(main: String) { this.main = main }
    fun setDrink(drink: String) { this.drink = drink }
}

class MealBuilder {
    private var cost: Double? = null
    private var takeOut: Boolean = false
    private var main: String? = null
    private var drink: String? = null

    fun addCost(cost: Double): MealBuilder {
        this.cost = cost
        return this
    }

    fun addTakeOut(takeOut: Boolean): MealBuilder {
        this.takeOut = takeOut
        return this
    }

    fun addMainCourse(main: String): MealBuilder {
        this.main = main
        return this
    }

    fun addDrink(drink: String): MealBuilder {
        this.drink = drink
        return this
    }

    fun build(): Meal {
        return Meal(
            cost = this.cost,
            takeOut = this.takeOut,
            main= this.main,
            drink = this.drink
        )
    }
}
