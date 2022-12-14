package src.launcher;

import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;

import java.awt.Font;
import java.awt.Color;

public class Setting {
        public static Setting instance = null;

        public static int WIDTH = (int) (GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getMaximumWindowBounds().getWidth());
        public static int HEIGHT = (int) ((GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getMaximumWindowBounds().getHeight()));
        public static String FONT_NAME_01 = "Arial";
        public static int FONT_STYLE_00 = Font.PLAIN;
        public static int FONT_STYLE_01 = Font.BOLD;
        public static int FONT_STYLE_02 = Font.ITALIC;
        public static int FONT_STYLE_03 = Font.BOLD + Font.ITALIC;
        public static int FONT_SIZE_BIG = 36;
        public static int FONT_SIZE_MEDIUM = 24;
        public static int FONT_SIZE_SMALL_2 = 21;
        public static int FONT_SIZE_SMALL = 18;
        public static int FONT_SIZE_VERY_SMALL = 13;
        public static Color COLOR_NULL = new Color(0, 0, 0, 0);
        public static Color COLOR_BLACK = new Color(0, 0, 0);
        public static Color COLOR_GREEN_01 = new Color(133, 186, 149);
        public static Color COLOR_GREEN_02 = new Color(153, 214, 171);
        public static Color COLOR_GREEN_03 = new Color(231, 255, 229);
        public static Color COLOR_ORANGE_01 = new Color(255, 209, 165);
        public static Color COLOR_ORANGE_02 = new Color(255, 231, 194);
        public static Color COLOR_GRAY_01 = new Color(70, 70, 70);
        public static Color COLOR_GRAY_02 = new Color(111, 111, 111);
        public static Color COLOR_GRAY_03 = new Color(200, 200, 200);
        public static Color COLOR_GRAY_04 = new Color(220, 220, 220);
        public static Color COLOR_GRAY_05 = new Color(232, 232, 232);
        public static Color COLOR_GRAY_06 = new Color(242, 242, 242);
        public static Color COLOR_WHITE = new Color(255, 255, 255);
        public static Color COLOR_RED_01 = new Color(50, 0, 0);
        public static Color COLOR_RED_02 = new Color(130, 0, 0);
        public static Color COLOR_RED_03 = new Color(150, 0, 0);
        public static Color COLOR_RED_04 = new Color(255, 240, 240);
        public static Color COLOR_RED_05 = new Color(235, 188, 188);
        public static Color COLOR_RED_06 = new Color(235, 201, 201);
        public static Color COLOR_RED_07 = new Color(255, 218, 218);
        public static Color COLOR_RED_08 = new Color(255, 0, 0);
        public static Color COLOR_VIOLET_01 = new Color(230, 228, 255);
        public static Color COLOR_VIOLET_02 = new Color(211, 202, 255);
        public static Color COLOR_VIOLET_03 = new Color(240, 237, 255);
        public static Color COLOR_BLUE_01 = new Color(241, 250, 255);
        public static Color COLOR_BLUE_02 = new Color(222, 255, 253);
        public static Color COLOR_BLUE_03 = new Color(189, 239, 255);
        public static Color COLOR_BLUE_04 = new Color(168, 200, 200);
        public static Color[] ARRAY_COLORS = {
                        new Color(255, 175, 153),
                        new Color(255, 214, 89),
                        new Color(255, 242, 38),
                        new Color(138, 255, 128),
                        new Color(40, 249, 255),
                        new Color(131, 144, 255),
                        new Color(215, 155, 255),
                        new Color(255, 174, 223),
                        new Color(255, 218, 212),
                        new Color(255, 245, 221),
                        new Color(255, 255, 221),
                        new Color(227, 255, 228),
                        new Color(235, 255, 255),
                        new Color(237, 233, 255),
                        new Color(255, 243, 245)
        };
        // Gradien color combo
        // Combo 1 // No color
        public static final Color[][] GRADIENT_COLORS_1 = {
                        new Color[] { COLOR_WHITE, COLOR_WHITE }
        };
        public static final double[][] GRADIENT_POINTS1_1 = {
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_1 = {
                        new double[] { 0, 1 }
        };
        // Combo 2 // Deafault button
        public static final Color[][] GRADIENT_COLORS_2 = {
                        new Color[] { COLOR_BLUE_03, COLOR_GRAY_06 },
                        new Color[] { COLOR_GRAY_06, COLOR_BLUE_03 }

        };
        public static final double[][] GRADIENT_POINTS1_2 = {
                        new double[] { 1, 0 },
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_2 = {
                        new double[] { 0, 1 },
                        new double[] { 2, 0 }
        };
        // Combo 3 // Use for enable button (information bar)
        public static final Color[][] GRADIENT_COLORS_3 = {
                        new Color[] { COLOR_GRAY_03, COLOR_WHITE }
        };
        public static final double[][] GRADIENT_POINTS1_3 = {
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_3 = {
                        new double[] { 0, 1 }
        };
        // Combo 4 // use for title bar of table (use button)
        public static final Color[][] GRADIENT_COLORS_4 = {
                        new Color[] { COLOR_RED_06, COLOR_GRAY_06 },
                        new Color[] { COLOR_GRAY_06, COLOR_RED_06 }
        };
        public static final double[][] GRADIENT_POINTS1_4 = {
                        new double[] { 0, 0 },
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_4 = {
                        new double[] { 0, 1 },
                        new double[] { 0, 1 }
        };
        // Combo 5 // Use for button
        public static final Color[][] GRADIENT_COLORS_5 = {
                        new Color[] { COLOR_GRAY_03, COLOR_GRAY_06 },
                        new Color[] { COLOR_GRAY_06, COLOR_GRAY_04 }
        };
        public static final double[][] GRADIENT_POINTS1_5 = {
                        new double[] { 0, 0 },
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_5 = {
                        new double[] { 0, 1 },
                        new double[] { 0, 1 }
        };
        // Combo 6 // Use for panelString
        public static final Color[][] GRADIENT_COLORS_6 = {
                        new Color[] { COLOR_BLUE_02, COLOR_RED_04 },
                        new Color[] { COLOR_RED_04, COLOR_BLUE_02 }
        };
        public static final double[][] GRADIENT_POINTS1_6 = {
                        new double[] { 0, 0 },
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_6 = {
                        new double[] { 1, 0 },
                        new double[] { 1, 0 }
        };
        // Combo 7 // Use for panel
        public static final Color[][] GRADIENT_COLORS_7 = {
                        new Color[] { COLOR_GRAY_04, COLOR_GRAY_02 }
        };
        public static final double[][] GRADIENT_POINTS1_7 = {
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_7 = {
                        new double[] { 1, 0 }
        };
        // Combo 8 // Use for panel
        public static final Color[][] GRADIENT_COLORS_8 = {
                        new Color[] { COLOR_GRAY_04, COLOR_GREEN_03 }
        };
        public static final double[][] GRADIENT_POINTS1_8 = {
                        new double[] { 1, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_8 = {
                        new double[] { 0, 0 }
        };
        // Combo 9 // Deafault button when entered
        public static final Color[][] GRADIENT_COLORS_9 = {
                        new Color[] { COLOR_GREEN_03, COLOR_WHITE },
                        new Color[] { COLOR_WHITE, COLOR_GREEN_03 }

        };
        public static final double[][] GRADIENT_POINTS1_9 = {
                        new double[] { 1, 0 },
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_9 = {
                        new double[] { 0, 1 },
                        new double[] { 2, 0 }
        };
        // Combo 10 // Use for panel
        public static final Color[][] GRADIENT_COLORS_10 = {
                        new Color[] { COLOR_WHITE, COLOR_GRAY_06 },
                        new Color[] { COLOR_GRAY_06, COLOR_GREEN_03 }
        };
        public static final double[][] GRADIENT_POINTS1_10 = {
                        new double[] { 0, 0 },
                        new double[] { 0, 0 }
        };
        public static final double[][] GRADIENT_POINTS2_10 = {
                        new double[] { 0, 1 },
                        new double[] { 0, 1 }
        };
        // Combo 11 // Use for panel
        public static final Color[][] GRADIENT_COLORS_11 = {
                        new Color[] { COLOR_GRAY_04, COLOR_GREEN_03 }
        };
        public static final double[][] GRADIENT_POINTS1_11 = {
                        new double[] { 1, 3 }
        };
        public static final double[][] GRADIENT_POINTS2_11 = {
                        new double[] { 0, 0 }
        };
        // Combo 12 // Use for panel
        public static final Color[][] GRADIENT_COLORS_12 = {
                        new Color[] { COLOR_GRAY_04, COLOR_GREEN_03 }
        };
        public static final double[][] GRADIENT_POINTS1_12 = {
                        new double[] { 0, 1 }
        };
        public static final double[][] GRADIENT_POINTS2_12 = {
                        new double[] { 0, 0 }
        };

        // ImageIcon
        public static ImageIcon LOGO = null;
        public static ImageIcon ARROW_DOWN = null;
        public static ImageIcon ARROW_LEFT = null;
        public static ImageIcon ARROW_RIGHT = null;
        public static ImageIcon ARROW_UP = null;
        public static ImageIcon SETTING = null;
        public static ImageIcon EDIT = null;
        public static ImageIcon REMOVE = null;
        public static ImageIcon COPY = null;
        public static ImageIcon CHANGE = null;
        public static ImageIcon INFORMATION = null;
        public static ImageIcon WARNING = null;
        public static ImageIcon ADD = null;
        public static ImageIcon LOCK = null;
        public static ImageIcon UNLOCK = null;
        public static ImageIcon RUN = null;

        // Image guide in Time table
        public static ImageIcon GUIDE_ADD_NEW_SUBJECT = null;
        public static ImageIcon GUIDE_EDIT_SUBJECT = null;
        public static ImageIcon GUIDE_REMOVE_SUBJECT = null;
        public static ImageIcon GUIDE_ADD_NEW_CLASS_OF_SUBJECT = null;
        public static ImageIcon GUIDE_REMOVE_CLASS_OF_SUBJECT = null;
        public static ImageIcon GUIDE_TURN_OFF_SUBJECT = null;
        public static ImageIcon GUIDE_TURN_OFF_CLASS_OF_SUBJECT = null;
        public static ImageIcon GUIDE_CHECK_VALID_TIME_TABLE_1 = null;
        public static ImageIcon GUIDE_CHECK_VALID_TIME_TABLE_2 = null;

        // Image guide in Map Relative
        public static ImageIcon GUIDE_ZOOM_MAP_1 = null;
        public static ImageIcon GUIDE_ZOOM_MAP_2 = null;
        public static ImageIcon GUIDE_CTRL_ZOOM_MAP_1 = null;
        public static ImageIcon GUIDE_CTRL_ZOOM_MAP_2 = null;
        public static ImageIcon GUIDE_SHIFT_ZOOM_MAP_1 = null;
        public static ImageIcon GUIDE_SHIFT_ZOOM_MAP_2 = null;
        public static ImageIcon GUIDE_DRAGGED_MAP_1 = null;
        public static ImageIcon GUIDE_DRAGGED_MAP_2 = null;
        public static ImageIcon GUIDE_ENTERED_MAP = null;
        public static ImageIcon GUIDE_PRESSED_MAP_1 = null;

        // Splash screen
        public static ImageIcon[] SPLASH = null;

        public Setting() {
                instance = this;
                try {
                        // ImageIcon
                        LOGO = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/logo.png"));
                        ARROW_DOWN = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/arrow_down.png"));
                        ARROW_LEFT = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/arrow_left.png"));
                        ARROW_RIGHT = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/arrow_right.png"));
                        ARROW_UP = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/arrow_up.png"));
                        SETTING = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/setting.png"));
                        EDIT = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/edit.png"));
                        REMOVE = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/remove.png"));
                        COPY = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/copy.png"));
                        CHANGE = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/change.png"));
                        INFORMATION = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/information.png"));
                        WARNING = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/warning.png"));
                        ADD = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/add.png"));
                        LOCK = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/lock.png"));
                        UNLOCK = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/unlock.png"));
                        RUN = new ImageIcon(
                                        instance.getClass().getResource("assets/icon/run.png"));

                        // Image guide in Time table
                        GUIDE_ADD_NEW_SUBJECT = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/time_table/add_new_subject.png"));
                        GUIDE_EDIT_SUBJECT = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/time_table/edit_subject.png"));
                        GUIDE_REMOVE_SUBJECT = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/time_table/remove_subject.png"));
                        GUIDE_ADD_NEW_CLASS_OF_SUBJECT = new ImageIcon(
                                        instance.getClass().getResource(
                                                        "assets/images/guide/time_table/add_new_class_of_subject.png"));
                        GUIDE_REMOVE_CLASS_OF_SUBJECT = new ImageIcon(
                                        instance.getClass().getResource(
                                                        "assets/images/guide/time_table/remove_class_of_subject.png"));
                        GUIDE_TURN_OFF_SUBJECT = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/time_table/turn_off_subject.png"));
                        GUIDE_TURN_OFF_CLASS_OF_SUBJECT = new ImageIcon(
                                        instance.getClass().getResource(
                                                        "assets/images/guide/time_table/turn_off_class_of_subject.png"));
                        GUIDE_CHECK_VALID_TIME_TABLE_1 = new ImageIcon(
                                        instance.getClass().getResource(
                                                        "assets/images/guide/time_table/check_valid_time_table_1.png"));
                        GUIDE_CHECK_VALID_TIME_TABLE_2 = new ImageIcon(
                                        instance.getClass().getResource(
                                                        "assets/images/guide/time_table/check_valid_time_table_2.png"));

                        // Image guide in Map Relative
                        GUIDE_ZOOM_MAP_1 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/zoom_1.png"));
                        GUIDE_ZOOM_MAP_2 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/zoom_2.png"));
                        GUIDE_CTRL_ZOOM_MAP_1 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/ctrl_zoom_1.png"));
                        GUIDE_CTRL_ZOOM_MAP_2 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/ctrl_zoom_2.png"));
                        GUIDE_SHIFT_ZOOM_MAP_1 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/shift_zoom_1.png"));
                        GUIDE_SHIFT_ZOOM_MAP_2 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/shift_zoom_2.png"));
                        GUIDE_DRAGGED_MAP_1 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/dragged_1.png"));
                        GUIDE_DRAGGED_MAP_2 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/dragged_2.png"));
                        GUIDE_ENTERED_MAP = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/entered.png"));
                        GUIDE_PRESSED_MAP_1 = new ImageIcon(instance.getClass().getResource(
                                        "assets/images/guide/map_relative/pressed_1.png"));

                        // Splash
                        SPLASH = new ImageIcon[] {
                                        new ImageIcon(instance.getClass()
                                                        .getResource("assets/images/splash/splash_1.png")),
                                        new ImageIcon(instance.getClass()
                                                        .getResource("assets/images/splash/splash_2.png")),
                                        new ImageIcon(instance.getClass()
                                                        .getResource("assets/images/splash/splash_3.png")),
                                        new ImageIcon(instance.getClass()
                                                        .getResource("assets/images/splash/splash_4.png")),
                                        new ImageIcon(instance.getClass()
                                                        .getResource("assets/images/splash/splash_5.png")),
                                        new ImageIcon(instance.getClass()
                                                        .getResource("assets/images/splash/splash_6.png")),
                        };
                } catch (Exception e) {
                        System.out.println("Error when read img");
                }

        }

}
