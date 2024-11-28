object HTMLRenderer {
    fun render(element: Element): String = when(element) {
        // most specific case first
        is TaggedTextElement -> "${element.openTag}${element.text}${element.closeTag}"

        // then handle containers
        is ContainerElement -> {
            val childrenHtml = element.elements.joinToString("\n") { render(it) }
            if (childrenHtml.isNotEmpty()) {
                "${element.openTag}\n${childrenHtml.indentEachLine()}\n${element.closeTag}"
            } else {
                "${element.openTag}${element.closeTag}"
            }
        }

        // simple text elements
        is TextElement -> element.text

        // any other tagged elements (without text)
        is TaggedElement -> "${element.openTag}${element.closeTag}"
    }

    fun render(page: Page): String {
        val bodyContent = page.elements.joinToString("\n") { render(it) }

        return """
            |<html>
            |  <head>
            |    <title>${page.title}</title>
            |  </head>
            |  <body>
            |${bodyContent.indentEachLine(4)}
            |  </body>
            |</html>
        """.trimMargin()
    }
}