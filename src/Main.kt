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
import javax.swing.event.ChangeEvent
import javax.swing.event.ChangeListener


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
class MainWindow : JFrame(), ActionListener, KeyListener, ChangeListener, MouseListener {

    private var timer: Timer
    private var whatClicked: String = ""
    private var clicked: Boolean = false
    // Fields to hold the UI elements
    private lateinit var redLabel: JLabel
    private lateinit var redMinus: JButton
    private lateinit var redPlus: JButton
    private lateinit var redField: JTextField
    private lateinit var redSlider: JSlider

    private lateinit var greenLabel: JLabel
    private lateinit var greenMinus: JButton
    private lateinit var greenPlus: JButton
    private lateinit var greenField: JTextField
    private lateinit var greenSlider: JSlider

    private lateinit var blueLabel: JLabel
    private lateinit var blueMinus: JButton
    private lateinit var bluePlus: JButton
    private lateinit var blueField: JTextField
    private lateinit var blueSlider: JSlider

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

        timer=  Timer(100, this)
        timer.start()
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

        redField = JTextField("0")
        redField.bounds = Rectangle(150, 50, 50, 50)
        redField.font = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        redField.addActionListener(this)
        redField.addKeyListener(this)
        add(redField)

        redSlider = JSlider()
        redSlider.bounds = Rectangle(100, 100, 150, 50)
        redSlider.minimum = 0
        redSlider.maximum = 255
        redSlider.addChangeListener(this)
        add(redSlider)


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

        greenField = JTextField("0")
        greenField.bounds = Rectangle(150, 150, 50, 50)
        greenField.font = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        greenField.addActionListener(this)
        greenField.addKeyListener(this)
        add(greenField)

        greenSlider = JSlider()
        greenSlider.bounds = Rectangle(100, 200, 150, 50)
        greenSlider.minimum = 0
        greenSlider.maximum = 255
        greenSlider.addChangeListener(this)
        add(greenSlider)



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

        blueField = JTextField("0")
        blueField.bounds = Rectangle(150, 250, 50, 50)
        blueField.font = Font(Font.SANS_SERIF, Font.PLAIN, 20)
        blueField.addActionListener(this)
        blueField.addKeyListener(this)
        add(blueField)

        blueSlider = JSlider()
        blueSlider.bounds = Rectangle(100, 300, 150, 50)
        blueSlider.minimum = 0
        blueSlider.maximum = 255
        blueSlider.addChangeListener(this)
        add(blueSlider)


        hexTitle = JLabel("HEX")
        hexTitle.horizontalAlignment = SwingConstants.CENTER
        hexTitle.bounds = Rectangle(300, 50, 150, 50)
        hexTitle.font = defaultFont
        add(hexTitle)

        hexDisplay = JLabel(" ")
        hexDisplay.horizontalAlignment = SwingConstants.CENTER
        hexDisplay.bounds = Rectangle(300, 100, 150, 150)
        hexDisplay.font = defaultFont
        hexDisplay.background = Color(0,0,0,255)
        hexDisplay.isOpaque = true
        add(hexDisplay)

        hexCodeLabel = JLabel("#         ")
        hexCodeLabel.horizontalAlignment = SwingConstants.CENTER
        hexCodeLabel.bounds = Rectangle(300, 250, 150, 50)
        hexCodeLabel.font = defaultFont
        add(hexCodeLabel)

        updateUi()
    }


    private fun updateUi() {
        if (redField.text.toInt() > 255) redField.text = "0"
        if (greenField.text.toInt() > 255) greenField.text = "0"
        if (blueField.text.toInt() > 255) blueField.text = "0"
        if (redField.text.toInt() < 0) redField.text = "255"
        if (greenField.text.toInt() < 0) greenField.text = "255"
        if (blueField.text.toInt() < 0) blueField.text = "255"

        redSlider.value = redField.text.toInt()
        greenSlider.value = greenField.text.toInt()
        blueSlider.value = blueField.text.toInt()

        val rgb =  Color(redField.text.toInt(), greenField.text.toInt(), blueField.text.toInt())
        hexDisplay.background = rgb
        hexCodeLabel.text = String.format("#%02x%02x%02x", redField.text.toInt(), greenField.text.toInt(), blueField.text.toInt())
        redField.background = Color(redField.text.toInt(), 0, 0)
        greenField.background = Color(0, greenField.text.toInt(), 0)
        blueField.background = Color(0, 0, blueField.text.toInt())
    }

    /**
     * Handle any UI events (e.g. button clicks)
     */
    override fun actionPerformed(e: ActionEvent?) {

        when (e?.source) {
            redMinus   -> {
                whatClicked     = "redMinus"
                redField.text   = (redField.text.toInt()   - 1).toString()
            }
            redPlus    -> {
                whatClicked     = "redPlus"
                redField.text   = (redField.text.toInt()   + 1).toString()
            }
            greenMinus -> {
                whatClicked     = "greenMinus"
                greenField.text = (greenField.text.toInt() - 1).toString()
            }
            greenPlus  -> {
                whatClicked     = "greenPlus"
                greenField.text = (greenField.text.toInt() + 1).toString()
            }
            blueMinus  -> {
                whatClicked     = "blueMinus"
                blueField.text  = (blueField.text.toInt()  - 1).toString()
            }
            bluePlus   -> {
                whatClicked     = "bluePlus"
                blueField.text  = (blueField.text.toInt()  + 1).toString()
            }

            timer      -> {
                when (whatClicked) {
                    "redMinus"   -> {if (clicked) redField.text.toInt()   - 1}
                    "redPlus"    -> {if (clicked) redField.text.toInt()   + 1}
                    "greenMinus" -> {if (clicked) greenField.text.toInt() - 1}
                    "greenPlus"  -> {if (clicked) greenField.text.toInt() + 1}
                    "blueMinus"  -> {if (clicked) blueField.text.toInt()  - 1}
                    "bluePlus"   -> {if (clicked) blueField.text.toInt()  + 1}
                    else -> println("tick")
                }
            }
        }
        updateUi()
    }


    override fun keyTyped(e: KeyEvent?) {
        println("Key typed")
    }

    override fun keyPressed(e: KeyEvent?) {
        println("Key Pressed")

    }

    override fun keyReleased(e: KeyEvent?) {
        println("Key Released")
        updateUi()
    }

    override fun stateChanged(e: ChangeEvent?) {
        when (e?.source) {
            redSlider   -> redField.text   = redSlider.value.toString()
            greenSlider -> greenField.text = greenSlider.value.toString()
            blueSlider  -> blueField.text  = blueSlider.value.toString()
        }
        updateUi()
    }

    override fun mouseClicked(e: MouseEvent?) {
        println("Mouse clicked")
    }

    override fun mousePressed(e: MouseEvent?) {
        clicked = true
        println("mousePressed")
    }

    override fun mouseReleased(e: MouseEvent?) {
        clicked = false
        println("mouseReleased")
    }

    override fun mouseEntered(e: MouseEvent?) {
        TODO("Not yet implemented")
    }

    override fun mouseExited(e: MouseEvent?) {
        TODO("Not yet implemented")
    }


}

