data class Paragraph(
    override val text: String
) : TaggedTextElement {
    //no backing field needed, tag is constant
    override val tag: String
        get() = "p"
}