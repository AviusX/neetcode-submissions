class Singleton private constructor() {
    private var instanceValue: String? = null

    companion object {
        @Volatile
        private var instance: Singleton? = null

        fun getInstance(): Singleton {
            return instance ?: synchronized(this) {
                instance ?: Singleton().also {
                    instance = it
                }
            }
        }
    }

    fun getValue(): String? {
        return instanceValue
    }

    fun setValue(value: String) {
        instanceValue = value
    }
}
