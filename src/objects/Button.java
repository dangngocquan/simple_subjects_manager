package src.objects;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import src.launcher.Setting;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Font;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Canvas;
import java.awt.FontMetrics;
import java.awt.RenderingHints;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.util.LinkedList;
import java.util.List;
import java.awt.Polygon;

public class Button extends JPanel {
    // Constants button's root location
    public static final int TOP_LEFT = 0;
    public static final int TOP_CENTER = 1;
    public static final int TOP_RIGHT = 2;
    public static final int CENTER_LEFT = 3;
    public static final int CENTER_CENTER = 4;
    public static final int CENTER_RIGHT = 5;
    public static final int BOTTOM_LEFT = 6;
    public static final int BOTTOM_CENTER = 7;
    public static final int BOTTOM_RIGHT = 8;

    // Constant font
    public static final Font ARIAL_BOLD_12 = new Font("Arial", Font.BOLD, 12);
    public static final Font ARIAL_BOLD_13 = new Font("Arial", Font.BOLD, 13);
    public static final Font ARIAL_BOLD_15 = new Font("Arial", Font.BOLD, 15);
    public static final Font ARIAL_BOLD_18 = new Font("Arial", Font.BOLD, 18);
    public static final Font ARIAL_BOLD_21 = new Font("Arial", Font.BOLD, 21);
    public static final Font ARIAL_BOLD_24 = new Font("Arial", Font.BOLD, 24);
    public static final Font ARIAL_BOLD_28 = new Font("Arial", Font.BOLD, 28);
    public static final Font ARIAL_BOLD_36 = new Font("Arial", Font.BOLD, 36);

    // Constant color
    public static final Color STROKE_COLOR_BLACK = Setting.COLOR_BLACK;
    public static final Color TEXT_COLOR_BLACK = Setting.COLOR_BLACK;
    public static final Color BACKGROUND_COLOR_BLUE = Setting.COLOR_BLUE_02;
    public static final Color BACKGROUND_COLOR_RED = Setting.COLOR_RED_05;
    public static final Color BACKGROUND_COLOR_GREEN = Setting.COLOR_GREEN_03;
    public static final Color BACKGROUND_COLOR_WHITE = Setting.COLOR_WHITE;
    public static final Color BACKGROUND_COLOR_BLACK = Setting.COLOR_BLACK;
    public static final Color BACKGROUND_COLOR_GRAY = Setting.COLOR_GRAY_04;

    // Constant stroke width
    public static final int STROKE_WIDTH_0 = 0;
    public static final int STROKE_WIDTH_1 = 1;
    public static final int STROKE_WIDTH_2 = 2;
    public static final int STROKE_WIDTH_3 = 3;

    // Constant shape
    public static final int RECTANGLE = 0;
    public static final int HEXAGON = 1;
    public static final int RECT_SLANTED_LEFT = 2;
    public static final int RECT_SLANTED_RIGHT = 3;

    // Properties
    private boolean enable = true;
    // properties of button (size, location, button color, stroke width, stroke
    // color)
    private int width, height;
    private int rootLocationType = 0;
    private int xPos = 0, yPos = 0;
    private int strokeWidth = 0;
    private Color strokeColor = STROKE_COLOR_BLACK;
    private Color[][] gradientBackgroundColor = null;
    private double[][] gradientPoint1 = null;
    private double[][] gradientPoint2 = null;
    private Color[][] gradientBackgroundColorEntered = null;
    private double[][] gradientPoint1Entered = null;
    private double[][] gradientPoint2Entered = null;
    private Color[][] gradientBackgroundColorExited = null;
    private double[][] gradientPoint1Exited = null;
    private double[][] gradientPoint2Exited = null;
    private ImageIcon backgroundImage = null;
    private ImageIcon backgroundIcon = null;
    private Color backgroundColor = null;
    private Color backgroundColorEntered = null;
    private Color backgroundColorExited = null;
    private Color backgroundColorApp = Setting.COLOR_NULL;

    // properties of text
    private String text = "";
    private int[] sizeText = null;
    private Font font = ARIAL_BOLD_24;
    private int xText = 0;
    private int yText = 0;
    private Color textColor;

    private String[] textLines = null;

    // Shape
    private Shape shape;
    private int shapeType = 0;

    public Button(String text) {
        setLayout(null);
        // create text
        this.text = text;
        this.textLines = null;
        // Create default font of text
        this.font = ARIAL_BOLD_24;
        // set size of text
        setDefaultSizeText();
        // Create default size of button
        setSizeButton(sizeText[0] + getSizeText("A", this.font)[0] * 6, sizeText[1] / 4 * 7);
        // Set default location of button
        setLocationButton(0, 0, TOP_LEFT);
        // Set default location of text in button
        setLocationText(0, 0); // CENTER_CENTER
        // Set default Stroke width
        setStrokeWidth(STROKE_WIDTH_1);
        // Set default stroke color
        setStrokeColor(STROKE_COLOR_BLACK);
        // Set default text color
        setTextColor(Setting.COLOR_BLACK);
        // Set default gradient color background
        setGradientBackgroundColor(
                Setting.GRADIENT_POINTS1_2,
                Setting.GRADIENT_POINTS2_2,
                Setting.GRADIENT_COLORS_2);
        // Set default gradient color background
        setGradientBackgroundColorEntered(
                Setting.GRADIENT_POINTS1_9,
                Setting.GRADIENT_POINTS2_9,
                Setting.GRADIENT_COLORS_9);
        // Set default gradient color background
        setGradientBackgroundColorExited(
                Setting.GRADIENT_POINTS1_2,
                Setting.GRADIENT_POINTS2_2,
                Setting.GRADIENT_COLORS_2);
        // Add mouse handle
        addMouseListener(new MouseHandler());

    }

    public Button(String[] lineTexts) {
        setLayout(null);
        // create text
        this.text = "";
        this.textLines = lineTexts;
        // Create default font of text
        this.font = ARIAL_BOLD_24;
        // set size of text
        setDefaultSizeText();
        // Create default size of button
        setSizeButton(sizeText[0] + getSizeText("A", this.font)[0] * 6, sizeText[1] / 4 * 7);
        // Set default location of button
        setLocationButton(0, 0, TOP_LEFT);
        // Set default location of text in button
        setLocationText(0, 0); // CENTER_CENTER
        // Set default Stroke width
        setStrokeWidth(STROKE_WIDTH_1);
        // Set default stroke color
        setStrokeColor(STROKE_COLOR_BLACK);
        // Set default text color
        setTextColor(Setting.COLOR_BLACK);
        // Set default gradient color background
        setGradientBackgroundColor(
                Setting.GRADIENT_POINTS1_2,
                Setting.GRADIENT_POINTS2_2,
                Setting.GRADIENT_COLORS_2);
        // Set default gradient color background
        setGradientBackgroundColorEntered(
                Setting.GRADIENT_POINTS1_9,
                Setting.GRADIENT_POINTS2_9,
                Setting.GRADIENT_COLORS_9);
        // Set default gradient color background
        setGradientBackgroundColorExited(
                Setting.GRADIENT_POINTS1_2,
                Setting.GRADIENT_POINTS2_2,
                Setting.GRADIENT_COLORS_2);
        // Add mouse handle
        addMouseListener(new MouseHandler());

    }

    // Set enable
    public void setEnable(boolean flag) {
        this.enable = flag;
    }

    // Set text Color
    public void setTextColor(Color color) {
        this.textColor = color;
        repaint();
    }

    // Get center X
    public int getCenterX() {
        return this.xPos + getWidth() / 2;
    }

    // Get right X
    public int getRightX() {
        return this.xPos + getWidth();
    }

    // Get bottom Y
    public int getBottomY() {
        return this.yPos + getHeight();
    }

    // Get center Y
    public int getCenterY() {
        return this.yPos + getHeight() / 2;
    }

    // Get basic width and height of text with a input font
    public int[] getSizeText(String text, Font font) {
        Canvas c = new Canvas();
        FontMetrics fontMetrics = c.getFontMetrics(font);
        int w = fontMetrics.stringWidth(text);
        int h = fontMetrics.getHeight();
        int descent = fontMetrics.getDescent();
        return (new int[] { w, h, descent });
    }

    // set basic width and height of text with a input font
    public void setDefaultSizeText() {
        if (textLines == null) {
            this.sizeText = getSizeText(this.text, this.font);
        } else {
            Canvas c = new Canvas();
            FontMetrics fontMetrics = c.getFontMetrics(font);
            int w = 0;
            for (String textLine : textLines) {
                w = Math.max(w, fontMetrics.stringWidth(textLine));
            }
            int h = fontMetrics.getHeight() * textLines.length;
            int descent = fontMetrics.getDescent();
            this.sizeText = new int[] { w, h, descent };
        }
    }

    // Set size of button
    public void setSizeButton(int width, int height) {
        this.width = width;
        this.height = height;
        setSize(this.width, this.height);
        repaint();
    }

    // Set size button with current text
    public void setCorrectSizeButton() {
        if (textLines == null) {
            this.width = this.sizeText[0] + getSizeText("A", this.font)[0] * 6;
            this.height = this.sizeText[1] / 4 * 7;
            setSize(this.width, this.height);
            setLocationText(xText, yText);
            repaint();
        } else {
            setDefaultSizeText();
            this.width = this.sizeText[0] + getSizeText("A", this.font)[0] * 6;
            this.height = this.sizeText[1] + getSizeText("A", this.font)[1] / 4 * 3;
            setSize(this.width, this.height);
            setLocationText(xText, yText);
            repaint();
        }

    }

    // Set text
    public void setTextButton(String text) {
        this.text = text;
        setDefaultSizeText();
        setLocationText(xText, yText);
        repaint();
    }

    // Set text lines
    public void setTextLinesButton(String[] textLines) {
        this.textLines = textLines;
        setDefaultSizeText();
        setLocationText(xText, yText);
        repaint();
    }

    // Set font of text
    public void setFontText(Font font) {
        this.font = font;
        setDefaultSizeText();
        setLocationText(xText, yText);
        repaint();
    }

    // Get font of text
    public Font getFontText() {
        return this.font;
    }

    // Get text
    public String getTextButton() {
        return this.text;
    }

    // Set stroke width
    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
        repaint();
    }

    // Set stroke color
    public void setStrokeColor(Color color) {
        this.strokeColor = color;
        repaint();
    }

    // Set background color
    public void setBackgroundColorButton(Color color) {
        this.backgroundColor = color;
        repaint();
    }

    // Set background color entered
    public void setBackgroundColorEnteredButton(Color color) {
        this.backgroundColorEntered = color;
        repaint();
    }

    // Set background color exited
    public void setBackgroundColorExitedButton(Color color) {
        this.backgroundColorExited = color;
        repaint();
    }

    // Set background color of application
    public void setBackgroundColorApp(Color color) {
        this.backgroundColorApp = color;
        repaint();
    }

    // Set current gradient color of background
    public void setGradientBackgroundColor(double[][] point1s, double[][] point2s, Color[][] colors) {
        this.gradientBackgroundColor = colors;
        this.gradientPoint1 = point1s;
        this.gradientPoint2 = point2s;
        repaint();
    }

    // Set gradient color of background when entered
    public void setGradientBackgroundColorEntered(double[][] point1s, double[][] point2s, Color[][] colors) {
        this.gradientBackgroundColorEntered = colors;
        this.gradientPoint1Entered = point1s;
        this.gradientPoint2Entered = point2s;
    }

    // Set gradient color of background when exited
    public void setGradientBackgroundColorExited(double[][] point1s, double[][] point2s, Color[][] colors) {
        this.gradientBackgroundColorExited = colors;
        this.gradientPoint1Exited = point1s;
        this.gradientPoint2Exited = point2s;
    }

    // Set background icon
    public void setBackgroundIcon(ImageIcon icon) {
        this.backgroundIcon = icon;
        repaint();
    }

    // Set background image
    public void setBackgroundImage(ImageIcon image) {
        this.backgroundImage = image;
        repaint();
    }

    // Remove background image
    public void removeBackgroundImage() {
        this.backgroundImage = null;
        repaint();
    }

    // Remove background icon
    public void removeBackgroundIcon() {
        this.backgroundIcon = null;
        repaint();
    }

    // Set location and root location type
    public void setLocationButton(int x, int y, int rootLocationType) {
        this.rootLocationType = rootLocationType;
        switch (this.rootLocationType) {
            case 0:
                xPos = x;
                yPos = y;
                break;
            case 1:
                xPos = x - width / 2;
                yPos = y;
                break;
            case 2:
                xPos = x - width;
                yPos = y;
                break;
            case 3:
                xPos = x;
                yPos = y - height / 2;
                break;
            case 4:
                xPos = x - width / 2;
                yPos = y - height / 2;
                break;
            case 5:
                xPos = x - width;
                yPos = y - height / 2;
                break;
            case 6:
                xPos = x;
                yPos = y - height;
                break;
            case 7:
                xPos = x - width / 2;
                yPos = y - height;
                break;
            case 8:
                xPos = x - width;
                yPos = y - height;
                break;
        }
        setBounds(xPos, yPos, width, height);
        repaint();
    }

    // Set location of text in button
    public void setLocationText(int x, int y) {
        this.xText = x;
        this.yText = y;
        repaint();
    }

    // Set shape type
    public void setShapeType(int type) {
        this.shapeType = type;
        repaint();
    }

    // Auto called method of JPanel
    public void paintComponent(Graphics g) {
        if (shapeType == RECTANGLE) {
            Graphics2D g2 = (Graphics2D) g;

            // Draw stroke
            g2.setColor(this.strokeColor);
            g2.fillRect(0, 0, this.width, this.height);

            // Draw background of button
            if (gradientBackgroundColor != null) {
                int heightPerRow = this.height / this.gradientBackgroundColor.length;
                for (int i = 0; i < this.gradientBackgroundColor.length; i++) {
                    GradientPaint gradientPaint = new GradientPaint(
                            (int) this.gradientPoint1[i][0] * width, (int) this.gradientPoint1[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][0],
                            (int) this.gradientPoint2[i][0] * width, (int) this.gradientPoint2[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][1]);
                    g2.setPaint(gradientPaint);
                    if (i == 0 && i == this.gradientBackgroundColor.length - 1) {
                        g2.fillRect(this.strokeWidth, this.strokeWidth,
                                this.width - 2 * this.strokeWidth, this.height - 2 * this.strokeWidth);
                    } else if (i == 0) {
                        g2.fillRect(this.strokeWidth, this.strokeWidth,
                                this.width - 2 * this.strokeWidth, heightPerRow - this.strokeWidth);
                    } else if (i == this.gradientBackgroundColor.length - 1) {
                        g2.fillRect(this.strokeWidth, 0,
                                this.width - 2 * this.strokeWidth, this.height - heightPerRow * i -
                                        this.strokeWidth);
                    } else {
                        g2.fillRect(this.strokeWidth, 0,
                                this.width - 2 * this.strokeWidth, heightPerRow);
                    }
                    g2.translate(0, heightPerRow);
                }
                g2.translate(0, -heightPerRow * this.gradientBackgroundColor.length);
            }

            // Background color
            if (backgroundColor != null) {
                g2.setColor(backgroundColor);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.fillRect(strokeWidth, strokeWidth, width - strokeWidth * 2, height - strokeWidth * 2);
            }

            // draw background image (if have)
            if (this.backgroundImage != null) {
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundImage.getImage(), strokeWidth, strokeWidth, this.width - 2 * strokeWidth,
                        this.height - 2 * strokeWidth, null);
            }
            // draw background icon (if have)
            if (this.backgroundIcon != null) {
                int tempWidth = this.width / 4 * 3;
                int tempHeight = this.height / 4 * 3;
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundIcon.getImage(), (this.width - tempWidth) / 2,
                        (this.height - tempHeight) / 2,
                        tempWidth, tempHeight, null);
            }

            // Draw text
            g2.setColor(this.textColor);
            g2.setFont(this.font);
            int tempX = 0, tempY = 0;
            if (textLines == null) {
                if (this.xText == 0) {
                    tempX = (this.width - sizeText[0]) / 2;
                } else if (this.xText > 0) {
                    tempX = this.xText;
                } else {
                    tempX = this.width - (sizeText[0] + (-this.xText));
                }

                if (this.yText == 0) {
                    tempY = (this.height - sizeText[1]) / 2 + (sizeText[1] - sizeText[2]);
                } else if (this.yText > 0) {
                    tempY = this.yText + (sizeText[1] - sizeText[2]);
                } else {
                    tempY = this.height - (sizeText[1] + (-this.yText)) + (sizeText[1] - sizeText[2]);
                }
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                        RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                g2.drawString(this.text, tempX, tempY);
            } else {
                // check first
                int maxLine = (this.height - 6) / getSizeText("A", font)[1];
                List<String> tempTextLines = new LinkedList<>();
                for (int index = 0; index < textLines.length; index++) {
                    String textLine = this.textLines[index];
                    String[] words = textLine.split(" ");
                    String tempString = "";
                    for (int index1 = 0; index1 < words.length; index1++) {
                        if (getSizeText((tempString + " " + words[index1]).trim(), font)[0] <= this.width - 4
                                - Math.abs(xText * 2)) {
                            tempString = (tempString + " " + words[index1]).trim();
                        } else {
                            if (tempString.isEmpty()) {
                                tempString += words[index1];
                                if (maxLine - tempTextLines.size() - (textLines.length - 1 - index) - 1 > 0) {
                                    tempTextLines.add(tempString);
                                    tempString = "";
                                }
                            } else {
                                if (maxLine - tempTextLines.size() - (textLines.length - 1 - index) - 1 > 0) {
                                    tempTextLines.add(tempString);
                                    tempString = words[index1];
                                } else {
                                    tempString = (tempString + " " + words[index1]).trim();
                                }

                            }
                        }
                    }
                    if (!tempString.isEmpty()) {
                        tempTextLines.add(tempString);
                    }
                }

                String[] arrTempTextLines = new String[tempTextLines.size()];
                for (int index = 0; index < tempTextLines.size(); index++) {
                    arrTempTextLines[index] = tempTextLines.get(index);
                }
                setTextLinesButton(arrTempTextLines);
                setDefaultSizeText();

                // Draw string
                for (int index = 0; index < tempTextLines.size(); index++) {
                    int[] sizeTextPerLine = getSizeText(tempTextLines.get(index), font);
                    if (this.xText == 0) {
                        tempX = (this.width - sizeTextPerLine[0]) / 2;
                    } else if (this.xText > 0) {
                        tempX = this.xText;
                    } else {
                        tempX = this.width - (sizeTextPerLine[0] + (-this.xText));
                    }

                    if (this.yText == 0) {
                        tempY = (this.height - sizeText[1]) / 2 + (sizeTextPerLine[1] - sizeTextPerLine[2])
                                + sizeTextPerLine[1] * index;
                    } else if (this.yText > 0) {
                        tempY = this.yText + (sizeTextPerLine[1] - sizeTextPerLine[2]) + sizeTextPerLine[1] * index;
                    } else {
                        tempY = this.height - (sizeTextPerLine[1] * (textLines.length - index) + (-this.yText))
                                + (sizeTextPerLine[1] - sizeTextPerLine[2]);
                    }
                    g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                            RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                    if (sizeTextPerLine[0] < this.width) {
                        g2.drawString(tempTextLines.get(index), tempX, tempY);
                    } else {
                        g2.drawString(tempTextLines.get(index), 2, tempY);
                    }
                }
            }

        } else if (shapeType == HEXAGON) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(backgroundColorApp);
            g2.fillRect(0, 0, this.width, this.height);

            int w = width;
            int h = height - strokeWidth;
            int xPoints[] = { 0, (int) (w * 1.0 / 4), (int) (w * 3.0 / 4), w, (int) (w * 3.0 / 4),
                    (int) (w * 1.0 / 4) };
            int yPoints[] = { (int) (h * 1.0 / 2), 0, 0, (int) (h * 1.0 / 2), h, h };

            // Draw stroke
            g2.setColor(this.strokeColor);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillPolygon(new Polygon(xPoints, yPoints, xPoints.length));

            // Coordinate background
            double sinAlpha = h * 1.0 / 2 / Math.sqrt(h * h * 1.0 / 4 + w * w * 1.0 / 16);
            int strokeH = strokeWidth;
            int strokeW = (int) (strokeH * 2.0 / sinAlpha);
            w = w - 2 * strokeW;
            h = h - 2 * strokeH;
            int xPoints2[] = { strokeW, strokeW + (int) (w * 1.0 / 4),
                    strokeW + (int) (w * 3.0 / 4),
                    strokeW + w, strokeW + (int) (w * 3.0 / 4),
                    strokeW + (int) (w * 1.0 / 4) };
            int yPoints2[] = { strokeH + (int) (h * 1.0 / 2), strokeH, strokeH,
                    strokeH + (int) (h * 1.0 / 2), h + strokeH, h + strokeH };

            // Draw background of button
            if (gradientBackgroundColor != null) {
                int heightPerRow = this.height / this.gradientBackgroundColor.length;
                for (int i = 0; i < 1; i++) {
                    GradientPaint gradientPaint = new GradientPaint(
                            (int) this.gradientPoint1[i][0] * width, (int) this.gradientPoint1[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][0],
                            (int) this.gradientPoint2[i][0] * width, (int) this.gradientPoint2[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][1]);
                    g2.setPaint(gradientPaint);
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.fillPolygon(new Polygon(xPoints2, yPoints2, xPoints2.length));
                }
            }

            // Background color
            // backgroundColor = Setting.COLOR_BLUE_02;
            if (backgroundColor != null) {
                g2.setColor(backgroundColor);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.fillPolygon(new Polygon(xPoints2, yPoints2, xPoints2.length));
            }

            // draw background image (if have)
            if (this.backgroundImage != null) {
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundImage.getImage(), 0, 0, this.width, this.height, null);
            }
            // draw background icon (if have)
            if (this.backgroundIcon != null) {
                int tempWidth = this.width / 4 * 3;
                int tempHeight = this.height / 4 * 3;
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundIcon.getImage(), (this.width - tempWidth) / 2,
                        (this.height - tempHeight) / 2,
                        tempWidth, tempHeight, null);
            }

            // Draw text
            g2.setColor(this.textColor);
            g2.setFont(this.font);
            int tempX = 0, tempY = 0;

            if (this.xText == 0) {
                tempX = (this.width - sizeText[0]) / 2;
            } else if (this.xText > 0) {
                tempX = this.xText;
            } else {
                tempX = this.width - (sizeText[0] + (-this.xText));
            }

            if (this.yText == 0) {
                tempY = (this.height - sizeText[1]) / 2 + (sizeText[1] - sizeText[2]);
            } else if (this.yText > 0) {
                tempY = this.yText + (sizeText[1] - sizeText[2]);
            } else {
                tempY = this.height - (sizeText[1] + (-this.yText)) + (sizeText[1] -
                        sizeText[2]);
            }
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString(this.text, tempX, tempY);

        } else if (shapeType == RECT_SLANTED_RIGHT) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(backgroundColorApp);
            g2.fillRect(0, 0, this.width, this.height);

            int w = width;
            int h = height - strokeWidth;
            int xPoints[] = { 0, (int) (h / Math.sqrt(3)), w, w - (int) (h / Math.sqrt(3)) };
            int yPoints[] = { h, 0, 0, h };

            // Draw stroke
            g2.setColor(this.strokeColor);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillPolygon(new Polygon(xPoints, yPoints, xPoints.length));

            // Coordinate background
            int strokeH = strokeWidth;
            int strokeW = (int) Math.round(strokeH * 2.0 / Math.sqrt(3));
            w = w - 2 * strokeW;
            h = h - 2 * strokeH;
            int xPoints2[] = { strokeW, strokeW + (int) (h / Math.sqrt(3)), strokeW + w,
                    strokeW + w - (int) (h / Math.sqrt(3)) };
            int yPoints2[] = { strokeH + h, strokeH, strokeH, strokeH + h };

            // Draw background of button
            if (gradientBackgroundColor != null) {
                int heightPerRow = this.height / this.gradientBackgroundColor.length;
                for (int i = 0; i < 1; i++) {
                    GradientPaint gradientPaint = new GradientPaint(
                            (int) this.gradientPoint1[i][0] * width, (int) this.gradientPoint1[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][0],
                            (int) this.gradientPoint2[i][0] * width, (int) this.gradientPoint2[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][1]);
                    g2.setPaint(gradientPaint);
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.fillPolygon(new Polygon(xPoints2, yPoints2, xPoints2.length));
                }
            }

            // Background color
            // backgroundColor = Setting.COLOR_BLUE_02;
            if (backgroundColor != null) {
                g2.setColor(backgroundColor);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.fillPolygon(new Polygon(xPoints2, yPoints2, xPoints2.length));
            }

            // draw background image (if have)
            if (this.backgroundImage != null) {
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundImage.getImage(), 0, 0, this.width, this.height, null);
            }
            // draw background icon (if have)
            if (this.backgroundIcon != null) {
                int tempWidth = this.width / 4 * 3;
                int tempHeight = this.height / 4 * 3;
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundIcon.getImage(), (this.width - tempWidth) / 2,
                        (this.height - tempHeight) / 2,
                        tempWidth, tempHeight, null);
            }

            // Draw text
            g2.setColor(this.textColor);
            g2.setFont(this.font);
            int tempX = 0, tempY = 0;
            if (this.xText == 0) {
                tempX = (this.width - sizeText[0]) / 2;
            } else if (this.xText > 0) {
                tempX = this.xText;
            } else {
                tempX = this.width - (sizeText[0] + (-this.xText));
            }

            if (this.yText == 0) {
                tempY = (this.height - sizeText[1]) / 2 + (sizeText[1] - sizeText[2]);
            } else if (this.yText > 0) {
                tempY = this.yText + (sizeText[1] - sizeText[2]);
            } else {
                tempY = this.height - (sizeText[1] + (-this.yText)) + (sizeText[1] -
                        sizeText[2]);
            }
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString(this.text, tempX, tempY);
        } else if (shapeType == RECT_SLANTED_LEFT) {
            Graphics2D g2 = (Graphics2D) g;

            g2.setColor(backgroundColorApp);
            g2.fillRect(0, 0, this.width, this.height);

            int w = width;
            int h = height - strokeWidth;
            int xPoints[] = { 0, w - (int) (h / Math.sqrt(3)), w, (int) (h / Math.sqrt(3)) };
            int yPoints[] = { 0, 0, h, h };

            // Draw stroke
            g2.setColor(this.strokeColor);
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            g2.fillPolygon(new Polygon(xPoints, yPoints, xPoints.length));

            // Coordinate background
            int strokeH = strokeWidth;
            int strokeW = (int) (strokeH * 2.0 / Math.sqrt(3));
            w = w - 2 * strokeW;
            h = h - 2 * strokeH;
            int xPoints2[] = { strokeW, strokeW + w - (int) (h / Math.sqrt(3)), strokeW + w,
                    strokeW + (int) (h / Math.sqrt(3)) };
            int yPoints2[] = { strokeH, strokeH, strokeH + h, strokeH + h };

            // Draw background of button
            if (gradientBackgroundColor != null) {
                int heightPerRow = this.height / this.gradientBackgroundColor.length;
                for (int i = 0; i < 1; i++) {
                    GradientPaint gradientPaint = new GradientPaint(
                            (int) this.gradientPoint1[i][0] * width, (int) this.gradientPoint1[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][0],
                            (int) this.gradientPoint2[i][0] * width, (int) this.gradientPoint2[i][1] * heightPerRow,
                            this.gradientBackgroundColor[i][1]);
                    g2.setPaint(gradientPaint);
                    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
                    g2.fillPolygon(new Polygon(xPoints2, yPoints2, xPoints2.length));
                }
            }

            // Background color
            // backgroundColor = Setting.COLOR_BLUE_02;
            if (backgroundColor != null) {
                g2.setColor(backgroundColor);
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2.fillPolygon(new Polygon(xPoints2, yPoints2, xPoints2.length));
            }

            // draw background image (if have)
            if (this.backgroundImage != null) {
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundImage.getImage(), 0, 0, this.width, this.height, null);
            }
            // draw background icon (if have)
            if (this.backgroundIcon != null) {
                int tempWidth = this.width / 4 * 3;
                int tempHeight = this.height / 4 * 3;
                g2.setRenderingHint(RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);
                g2.drawImage(this.backgroundIcon.getImage(), (this.width - tempWidth) / 2,
                        (this.height - tempHeight) / 2,
                        tempWidth, tempHeight, null);
            }

            // Draw text
            g2.setColor(this.textColor);
            g2.setFont(this.font);
            int tempX = 0, tempY = 0;
            if (this.xText == 0) {
                tempX = (this.width - sizeText[0]) / 2;
            } else if (this.xText > 0) {
                tempX = this.xText;
            } else {
                tempX = this.width - (sizeText[0] + (-this.xText));
            }

            if (this.yText == 0) {
                tempY = (this.height - sizeText[1]) / 2 + (sizeText[1] - sizeText[2]);
            } else if (this.yText > 0) {
                tempY = this.yText + (sizeText[1] - sizeText[2]);
            } else {
                tempY = this.height - (sizeText[1] + (-this.yText)) + (sizeText[1] -
                        sizeText[2]);
            }
            g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,
                    RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
            g2.drawString(this.text, tempX, tempY);
        }
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            if (shapeType == RECTANGLE) {
                shape = new Rectangle2D.Float(0, 0, this.width, this.height);

            } else if (shapeType == HEXAGON) {
                int xPoints[] = { 0, (int) (width * 1.0 / 4), (int) (width * 3.0 / 4), width, (int) (width * 3.0 / 4),
                        (int) (width * 1.0 / 4) };
                int yPoints[] = { (int) (height * 1.0 / 2), 0, 0, (int) (height * 1.0 / 2), height, height };
                shape = new Polygon(xPoints, yPoints, xPoints.length);
            } else if (shapeType == RECT_SLANTED_RIGHT) {
                int w = width;
                int h = height;
                int xPoints[] = { 0, (int) (h / Math.sqrt(3)), w, w - (int) (h / Math.sqrt(3)) };
                int yPoints[] = { h, 0, 0, h };
                shape = new Polygon(xPoints, yPoints, xPoints.length);
            } else if (shapeType == RECT_SLANTED_LEFT) {
                int w = width;
                int h = height;
                int xPoints[] = { 0, w - (int) (h / Math.sqrt(3)), w, (int) (h / Math.sqrt(3)) };
                int yPoints[] = { 0, 0, h, h };
                shape = new Polygon(xPoints, yPoints, xPoints.length);
            }
        }
        return shape.contains(x, y);
    }

    private class MouseHandler implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {
            if (enable) {
                setStrokeWidth(strokeWidth + 1);
                if (gradientBackgroundColorEntered != null) {
                    setGradientBackgroundColor(gradientPoint1Entered, gradientPoint2Entered,
                            gradientBackgroundColorEntered);
                }
                if (backgroundColorEntered != null) {
                    setBackgroundColorButton(backgroundColorEntered);
                }

            }
        }

        @Override
        public void mouseExited(MouseEvent e) {
            if (enable) {
                setStrokeWidth(strokeWidth - 1);
                if (gradientBackgroundColorExited != null) {
                    setGradientBackgroundColor(gradientPoint1Exited, gradientPoint2Exited,
                            gradientBackgroundColorExited);
                }
                if (backgroundColorExited != null) {
                    setBackgroundColorButton(backgroundColorExited);
                }

            }
        }
    }
}
