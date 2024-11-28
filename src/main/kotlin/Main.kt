import java.io.File

fun main() {
    // webpage combining Zelda and frogs
    val page = Page(
        "Frogs of Hyrule",
        "The Secret Connection Between Frogs and Zelda".h1(),

        Div(
            "Welcome to this Unique Adventure".h2(),
            """
            Have you ever wondered why Tears of the Kingdom 
            has so many frogs? Let's hop into this adventure!
            """.trimIndent().p()
        ),

        HTMLList(
            true,
            ListItem(
                "Frogs in Zelda Games".h3(),
                HTMLList(
                    false,
                    ListItem("Hot-Footed Frogs boost Link's stamina".text()),
                    ListItem("Tireless Frogs make perfect elixirs".text()),
                    ListItem(
                        "Where to Find These Magical Amphibians".h4(),
                        HTMLList(
                            false,
                            ListItem("Lakes of Hyrule".text()),
                            ListItem("Swamps near Kakariko Village".text()),
                            ListItem("Hidden spots near waterfalls".text())
                        )
                    )
                )
            ),

            ListItem(
                "Why Frogs Are Simply Amazing".h3(),
                HTMLList(
                    false,
                    ListItem("They go 'ribbit' (universal frog language!)".text()),
                    ListItem("They can eat their weight in insects".text()),
                    ListItem("Some change colors like a Chameleon armor set".text())
                )
            )
        ),

        Div(
            "Secret Gaming Tips".h2(),
            HTMLList(
                false,
                ListItem(
                    "Frog Elixir Recipes".h4(),
                    HTMLList(
                        false,
                        ListItem("2x Hot-Footed Frog + 1x Monster Extract = Stamina Elixir".text()),
                        ListItem("3x Tireless Frog + 1x Bokoblin Horn = Super Stamina Elixir".text())
                    )
                ),
                ListItem(
                    "Best Frog Locations by Time of Day".h4(),
                    HTMLList(
                        false,
                        ListItem("Morning: Great Plateau edges".text()),
                        ListItem("Noon: Hidden under mushrooms in forests".text()),
                        ListItem("Night: Near glowing mushrooms in caves".text())
                    )
                )
            )
        ),

        Div(
            "Did You Know?".h2(),
            HTMLList(
                false,
                ListItem("Tears of the Kingdom features over 10 different frog species".text()),
                ListItem("The legendary golden frog only appears during full moons".text()),
                ListItem(
                    "Frogs in Gaming History".h4(),
                    HTMLList(
                        false,
                        ListItem("Frogger was one of the first frog-themed games".text()),
                        ListItem("In Chrono Trigger, Frog is a knight turned into an amphibian".text()),
                        ListItem("Minecraft frogs make different sounds in each biome".text())
                    )
                )
            )
        ),

        """
        Remember: Every frog in Hyrule is a potential friend 
        (even if you might need them for an elixir... sorry, little frogs!)
        """.trimIndent().p()
    )

    // Rendering and saving the page
    val renderedHtml = HTMLRenderer.render(page)
    File("frogs-of-hyrule.html").writeText(renderedHtml)

    println("The frog webpage has been successfully created! Ribbit!")
}

// extension functions
fun String.text(): Text = Text(this)

fun String.p(): Paragraph = Paragraph(this)

infix fun String.h(level: Int): Heading = Heading(this, level)

fun String.h1(): Heading = this h 1
fun String.h2(): Heading = this h 2
fun String.h3(): Heading = this h 3
fun String.h4(): Heading = this h 4
fun String.h5(): Heading = this h 5
fun String.h6(): Heading = this h 6

fun String.indentEachLine(depth: Int = 2, symbol: String = " ") =
    this.split("\n").joinToString("\n") { symbol.repeat(depth) + it }