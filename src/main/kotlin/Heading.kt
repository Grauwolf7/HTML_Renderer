data class Heading(
    override val text: String,
    val level: Int = 1 // standard value 1 for <h1>
) : TaggedTextElement {
    // is executed before object initialization
    init {
        require(level in 1..6) {
            "Heading level must be between 1 and 6, but was $level"
        }
    }

    override val tag: String
        get() = "h$level"
}