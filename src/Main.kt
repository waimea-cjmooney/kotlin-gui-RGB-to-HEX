/**
 * ===============================================================
 * Kotlin GUI Basic Starter
 * ===============================================================
 *
 * This is a starter project for a simple Kotlin GUI application.
 * The Java Swing library is used, plus the FlatLAF look-and-feel
 * for a reasonably modern look.
 */

import com.formdev.flatlaf.FlatDarkLaf
import java.awt.*
import java.awt.event.*
import javax.swing.*


/**
 * Launch the application
 */
fun main() {
    FlatDarkLaf.setup()     // Flat, dark look-and-feel
    MainWindow()            // Create and show the UI
}


/**
 * Main UI window (view)
 * Defines the UI and responds to events
 * The app model should be passwd as an argument
 */
class MainWindow : JFrame(), ActionListener {

    // Fields to hold the UI elements
    private lateinit var redLabel: JLabel
    private lateinit var redMinus: JButton
    private lateinit var redPlus: JButton
    private lateinit var redField: JTextField

    private lateinit var greenLabel: JLabel
    private lateinit var greenMinus: JButton
    private lateinit var greenPlus: JButton
    private lateinit var greenField: JTextField

    private lateinit var blueLabel: JLabel
    private lateinit var blueMinus: JButton
    private lateinit var bluePlus: JButton
    private lateinit var blueField: JTextField


    private lateinit var hexTitle: JLabel
    private lateinit var hexDisplay: JLabel
    private lateinit var hexCodeLabel: JLabel

    /**
     * Configure the UI and display it
     */
    init {
        configureWindow()               // Configure the window
        addControls()                   // Build the UI

        setLocationRelativeTo(null)     // Centre the window
        isVisible = true                // Make it visible
    }

    /**
     * Configure the main window
     */
    private fun configureWindow() {
        title = "Kotlin Swing GUI Demo"
        contentPane.preferredSize = Dimension(500, 350)
        defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
        isResizable = false
        layout = null

        pack()
    }

    /**
     * Populate the UI with UI controls
     */
    private fun addControls() {
        val defaultFont = Font(Font.SANS_SERIF, Font.PLAIN, 30)

        redLabel = JLabel("R")
        redLabel.horizontalAlignment = SwingConstants.CENTER
        redLabel.bounds = Rectangle(50, 50, 50, 50)
        redLabel.font = defaultFont
        add(redLabel)

        redMinus = JButton("-")
        redMinus.bounds = Rectangle(100,50,50,50)
        redMinus.font = defaultFont
        redMinus.addActionListener(this)     // Handle any clicks
        add(redMinus)

        redPlus = JButton("+")
        redPlus.bounds = Rectangle(200,50,50,50)
        redPlus.font = defaultFont
        redPlus.addActionListener(this)     // Handle any clicks
        add(redPlus)

        redField = JTextField()
        redField.bounds = Rectangle(150, 50, 50, 50)
        redField.font = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        redField.addActionListener(this)
        add(redField)


        greenLabel = JLabel("G")
        greenLabel.horizontalAlignment = SwingConstants.CENTER
        greenLabel.bounds = Rectangle(50, 150, 50, 50)
        greenLabel.font = defaultFont
        add(greenLabel)

        greenMinus = JButton("-")
        greenMinus.bounds = Rectangle(100,150,50,50)
        greenMinus.font = defaultFont
        greenMinus.addActionListener(this)     // Handle any clicks
        add(greenMinus)

        greenPlus = JButton("+")
        greenPlus.bounds = Rectangle(200,150,50,50)
        greenPlus.font = defaultFont
        greenPlus.addActionListener(this)     // Handle any clicks
        add(greenPlus)

        greenField = JTextField()
        greenField.bounds = Rectangle(150, 150, 50, 50)
        greenField.font = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        greenField.addActionListener(this)
        add(greenField)



        blueLabel = JLabel("B")
        blueLabel.horizontalAlignment = SwingConstants.CENTER
        blueLabel.bounds = Rectangle(50, 250, 50, 50)
        blueLabel.font = defaultFont
        add(blueLabel)

        blueMinus = JButton("-")
        blueMinus.bounds = Rectangle(100,250,50,50)
        blueMinus.font = defaultFont
        blueMinus.addActionListener(this)     // Handle any clicks
        add(blueMinus)

        bluePlus = JButton("+")
        bluePlus.bounds = Rectangle(200,250,50,50)
        bluePlus.font = defaultFont
        bluePlus.addActionListener(this)     // Handle any clicks
        add(bluePlus)

        blueField = JTextField()
        blueField.bounds = Rectangle(150, 250, 50, 50)
        blueField.font = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        blueField.addActionListener(this)
        add(blueField)


        hexTitle = JLabel("B")
        hexTitle.horizontalAlignment = SwingConstants.CENTER
        hexTitle.bounds = Rectangle(300, 50, 50, 50)
        hexTitle.font = defaultFont
        add(hexTitle)

        hexDisplay = JLabel()
        hexDisplay.horizontalAlignment = SwingConstants.CENTER
        hexDisplay.bounds = Rectangle(300, 100, 50, 50)
        hexDisplay.font = defaultFont
        add(hexDisplay)

        hexCodeLabel = JLabel("B")
        hexCodeLabel.horizontalAlignment = SwingConstants.CENTER
        hexCodeLabel.bounds = Rectangle(300, 50, 50, 50)
        hexCodeLabel.font = defaultFont
        add(hexCodeLabel)
    }


    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {
        when (e?.source) {
            redMinus -> {
                redLabel.text = "You clicked the button!"
            }
        }
    }

}

