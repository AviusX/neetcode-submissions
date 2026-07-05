class Person(private val lastName: String, private val age: Int, private val married: Boolean) {
    fun getLastName(): String = lastName
    fun getAge(): Int = age
    fun isMarried(): Boolean = married
}

interface PersonFilter {
    fun apply(person: Person): Boolean
}

class AdultFilter : PersonFilter {
    override fun apply(person: Person): Boolean = person.getAge() >= 18
}

class SeniorFilter : PersonFilter {
    override fun apply(person: Person): Boolean = person.getAge() >= 65
}

class MarriedFilter : PersonFilter {
    override fun apply(person: Person): Boolean = person.isMarried()
}

class PeopleCounter {
    private var filter: PersonFilter? = null

    fun setFilter(filter: PersonFilter) {
        this.filter = filter
    }

    fun count(people: List<Person>): Int {
        return people.count { filter?.apply(it) ?: false }
    }
}
