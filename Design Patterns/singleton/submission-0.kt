class Singleton private constructor() {
    private var instanceValue: String? = null

    companion object {
        private var instance: Singleton? = null
        fun getInstance(): Singleton {
            if (instance == null) {
                instance = Singleton()
            }

            return instance!!
        }
    }

    fun getValue(): String? {
        return instanceValue
    }

    fun setValue(value: String) {
        instanceValue = value
    }
}
