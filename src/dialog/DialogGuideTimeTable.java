package src.dialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import src.launcher.Setting;
import src.objects.Button;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;

public class DialogGuideTimeTable {
        // Constants dialog's root location
        public static final int TOP_LEFT = 0;
        public static final int TOP_CENTER = 1;
        public static final int TOP_RIGHT = 2;
        public static final int CENTER_LEFT = 3;
        public static final int CENTER_CENTER = 4;
        public static final int CENTER_RIGHT = 5;
        public static final int BOTTOM_LEFT = 6;
        public static final int BOTTOM_CENTER = 7;
        public static final int BOTTOM_RIGHT = 8;

        // Properties
        private JDialog dialog = null;
        private JPanel panelScroll = null;
        private int scrollCursor = 0;

        // Constructor
        public DialogGuideTimeTable(int x, int y, int width, int height, int rootLocationType, String title) {
                // Create frame and set propertis of this frame
                JFrame f = new JFrame();
                dialog = new JDialog(f, title, true);
                dialog.setLayout(null);
                dialog.setSize(width, height);
                dialog.setIconImage(Setting.LOGO.getImage());
                dialog.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                int xPos = x, yPos = y;
                switch (rootLocationType) {
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
                dialog.setBounds(xPos, yPos, width, height);

                // Create panelScroll
                this.panelScroll = new JPanel();
                panelScroll.setLayout(null);

                // Create objects in this panel (String, button, ...)
                int tempHeight = 30;

                // Guide about time table
                Button button1 = new Button(new String[] {
                                ".",
                                "?????u v??o:",
                                "       + B???n c???n ph???i t???o nh???ng m??n h???c m?? b???n mu???n c?? trong l???ch h???c c???a b???n.",
                                "       + M???i m??n h???c c?? th??? c?? 1 ho???c nhi???u m?? l???p h???c kh??c nhau, m???i m?? l???p h???c c?? th??? c?? th???i gian h???c tr??ng nhau ho???c kh??c nhau.",
                                ".",
                                "M???c ti??u:",
                                "       + Ki???m tra xem ?????i v???i danh s??ch m??n h???c v?? s??? l?????ng m?? l???p, th???i gian c???a t???ng m?? l???p h???c v???a nh???p th?? c?? t???n t???i l???ch h???c h???p l??? hay kh??ng.",
                                "       + N???u c?? t???n t???i l???ch h???c th???a m??n th?? s??? li???t k?? nh???ng l???ch h???c ????.",
                                ".",
                                "L??u ??:",
                                "       + M???t l???ch h???c ???????c coi l?? h???p l??? khi n?? ch???a ????? c??c m??n h???c m?? b???n ??ang x??t, ?????ng th???i c??c th???i gian h???c c???a nh???ng m??n h???c n??y kh??ng tr??ng nhau.",
                                "       + Nh???ng m??n h???c ??ang x??t bao g???m nh???ng m??n h???c c?? trong danh s??ch m??n m?? b???n nh???p, ?????ng th???i c?? tr???ng th??i ho???t ?????ng l?? \"??ang s??? d???ng\", v?? c?? s??? m?? l???p h???c (??? tr???ng th??i \"??ang s??? d???ng\") l???n h??n 0.",
                                "       + T????ng t???, ???ng d???ng c??ng ch??? x??t nh???ng m?? l???p h???c c?? tr???ng th??i ho???t ?????ng l?? \"??ang s??? d???ng\"."
                });
                button1.setFontText(Button.ARIAL_BOLD_21);
                button1.setCorrectSizeButton();
                button1.setLocationText(15, 15);
                button1.setSizeButton(width / 20 * 19, button1.getHeight() * 6 / 5);
                button1.setLocationButton(width / 2, tempHeight, Button.TOP_CENTER);
                button1.setStrokeWidth(0);
                button1.setBackgroundColorButton(dialog.getBackground());
                button1.setEnable(false);
                panelScroll.add(button1);
                tempHeight += button1.getHeight();

                // Guide add new subject
                Button button2 = new Button(new String[] {
                                "1. Th??m m??n h???c v??o danh s??ch",
                                "+ Sau khi nh???n n??t (nh?? h??nh), b???n s??? c???n nh???p T??n m??n h???c v?? M?? m??n h???c",
                                "+ M??n h???c s??? ???????c coi l?? h???p l??? n???u m?? m??n kh??ng tr??ng v???i m???t trong nh???ng m?? m??n h???c ???? c?? trong danh s??ch."
                });
                button2.setFontText(Button.ARIAL_BOLD_21);
                button2.setCorrectSizeButton();
                button2.setLocationText(15, 15);
                button2.setSizeButton(width / 20 * 19 / 3 - 10, button2.getHeight());
                button2.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button2.setStrokeWidth(0);
                button2.setBackgroundColorButton(dialog.getBackground());
                button2.setEnable(false);
                panelScroll.add(button2);

                Button button3 = new Button("");
                button3.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button3.setLocationButton(button2.getX() + button2.getWidth(), tempHeight, Button.TOP_LEFT);
                button3.setStrokeWidth(0);
                button3.setGradientBackgroundColor(null, null, null);
                button3.setBackgroundImage(Setting.GUIDE_ADD_NEW_SUBJECT);
                button3.setEnable(false);
                button2.setSizeButton(button2.getWidth(), button3.getHeight());
                panelScroll.add(button3);
                tempHeight += button3.getHeight() + 50;

                // Guide turn on/ off subject
                Button button4 = new Button(new String[] {
                                "2. Ch???nh s???a tr???ng th??i ho???t ?????ng c???a m???t m??n h???c",
                                "+ ??? tr???ng th??i \"??ang s??? d???ng\" (m??u xanh), m??n h???c s??? ???????c d??ng khi x???p l???ch h???c.",
                                "+ ??? tr???ng th??i \"??ang kh??ng s??? d???ng\" (m??u ?????), m??n h???c s??? kh??ng ???????c d??ng khi x???p l???ch h???c."
                });
                button4.setFontText(Button.ARIAL_BOLD_21);
                button4.setCorrectSizeButton();
                button4.setLocationText(15, 15);
                button4.setSizeButton(width / 20 * 19 / 3 - 10, button4.getHeight());
                button4.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button4.setStrokeWidth(0);
                button4.setBackgroundColorButton(dialog.getBackground());
                button4.setEnable(false);
                panelScroll.add(button4);

                Button button5 = new Button("");
                button5.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button5.setLocationButton(button4.getX() + button4.getWidth(), tempHeight, Button.TOP_LEFT);
                button5.setStrokeWidth(0);
                button5.setGradientBackgroundColor(null, null, null);
                button5.setBackgroundImage(Setting.GUIDE_TURN_OFF_SUBJECT);
                button5.setEnable(false);
                panelScroll.add(button5);
                button4.setSizeButton(button4.getWidth(), button5.getHeight());
                tempHeight += button5.getHeight() + 50;

                // Guide show inffor a subject
                Button button6 = new Button(new String[] {
                                "3. Xem v?? ch???nh s???a d??? li???u c???a m???t m??n h???c",
                                "+ Nh???n v??o ?? c???a m???t m??n h???c (nh?? h??nh) ????? xem th??ng tin c???a m??n h???c ????."
                });
                button6.setFontText(Button.ARIAL_BOLD_21);
                button6.setCorrectSizeButton();
                button6.setLocationText(15, 15);
                button6.setSizeButton(width / 20 * 19 / 3 - 10, button6.getHeight());
                button6.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button6.setStrokeWidth(0);
                button6.setBackgroundColorButton(dialog.getBackground());
                button6.setEnable(false);
                panelScroll.add(button6);

                Button button7 = new Button("");
                button7.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button7.setLocationButton(button6.getX() + button6.getWidth(), tempHeight, Button.TOP_LEFT);
                button7.setStrokeWidth(0);
                button7.setGradientBackgroundColor(null, null, null);
                button7.setBackgroundImage(Setting.GUIDE_EDIT_SUBJECT);
                button7.setEnable(false);
                panelScroll.add(button7);
                button6.setSizeButton(button6.getWidth(), button7.getHeight());
                tempHeight += button7.getHeight() + 50;

                // Guide add new class of subject
                Button button8 = new Button(new String[] {
                                "4. Th??m m?? l???p h???c c???a m???t m??n h???c",
                                "+ Nh???n n??t (nh?? h??nh) ????? th??m m???t m?? l???p h???c m???i.",
                                "+ B???n s??? c???n ph???i nh???p m?? c???a l???p h???c (kh??ng tr??ng v???i nh???ng m?? l???p h???c ???? t???n t???i c???a m??n h???c ??ang x??t), v?? ch???n th???i gian h???c t????ng ???ng v???i m?? l???p h???c n??y."
                });
                button8.setFontText(Button.ARIAL_BOLD_21);
                button8.setCorrectSizeButton();
                button8.setLocationText(15, 15);
                button8.setSizeButton(width / 20 * 19 / 3 - 10, button8.getHeight());
                button8.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button8.setStrokeWidth(0);
                button8.setBackgroundColorButton(dialog.getBackground());
                button8.setEnable(false);
                panelScroll.add(button8);

                Button button9 = new Button("");
                button9.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button9.setLocationButton(button8.getX() + button8.getWidth(), tempHeight, Button.TOP_LEFT);
                button9.setStrokeWidth(0);
                button9.setGradientBackgroundColor(null, null, null);
                button9.setBackgroundImage(Setting.GUIDE_ADD_NEW_CLASS_OF_SUBJECT);
                button9.setEnable(false);
                panelScroll.add(button9);
                button8.setSizeButton(button8.getWidth(), button9.getHeight());
                tempHeight += button9.getHeight() + 50;

                // Guide turn on/ off class of subject
                Button button10 = new Button(new String[] {
                                "5. Ch???nh s???a tr???ng th??i ho???t ?????ng c???a m???t m?? l???p h???c",
                                "+ ??? tr???ng th??i \"??ang s??? d???ng\" (m??u xanh), m?? l???p h???c s??? ???????c d??ng khi x???p l???ch h???c.",
                                "+ ??? tr???ng th??i \"??ang kh??ng s??? d???ng\" (m??u ?????), m?? l???p h???c s??? kh??ng ???????c d??ng khi x???p l???ch h???c."
                });
                button10.setFontText(Button.ARIAL_BOLD_21);
                button10.setCorrectSizeButton();
                button10.setLocationText(15, 15);
                button10.setSizeButton(width / 20 * 19 / 3 - 10, button10.getHeight());
                button10.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button10.setStrokeWidth(0);
                button10.setBackgroundColorButton(dialog.getBackground());
                button10.setEnable(false);
                panelScroll.add(button10);

                Button button11 = new Button("");
                button11.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button11.setLocationButton(button10.getX() + button10.getWidth(), tempHeight, Button.TOP_LEFT);
                button11.setStrokeWidth(0);
                button11.setGradientBackgroundColor(null, null, null);
                button11.setBackgroundImage(Setting.GUIDE_TURN_OFF_CLASS_OF_SUBJECT);
                button11.setEnable(false);
                panelScroll.add(button11);
                button10.setSizeButton(button10.getWidth(), button11.getHeight());
                tempHeight += button11.getHeight() + 50;

                // Guide Run app
                Button button12 = new Button(new String[] {
                                "6. Ki???m tra l???ch h???c kh??? thi",
                                "+ Sau khi ???? t???o c??c m??n h???c v?? t???o c??c m?? l???p h???c cho t???ng m??n h???c, b???n c?? th??? nh???n n??t (nh?? h??nh) ????? ???ng d???ng b???t ?????u ki???m tra l???ch h???c kh??? thi",
                                "+ "
                });
                button12.setFontText(Button.ARIAL_BOLD_21);
                button12.setCorrectSizeButton();
                button12.setLocationText(15, 15);
                button12.setSizeButton(width / 20 * 19 / 3 - 10, button12.getHeight());
                button12.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button12.setStrokeWidth(0);
                button12.setBackgroundColorButton(dialog.getBackground());
                button12.setEnable(false);
                panelScroll.add(button12);

                Button button13 = new Button("");
                button13.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button13.setLocationButton(button12.getX() + button12.getWidth(), tempHeight, Button.TOP_LEFT);
                button13.setStrokeWidth(0);
                button13.setGradientBackgroundColor(null, null, null);
                button13.setBackgroundImage(Setting.GUIDE_CHECK_VALID_TIME_TABLE_1);
                button13.setEnable(false);
                panelScroll.add(button13);
                button12.setSizeButton(button12.getWidth(), button13.getHeight());
                tempHeight += button13.getHeight() + 50;

                Button button14 = new Button(new String[] {
                                "+ B???n c?? th??? nh???n c??c n??t (nh?? h??nh) ????? di chuy???n gi???a c??c l???ch h???c.",
                                "+ B???n c??ng c?? th??? d??ng con l??n chu???t ????? di chuy???n gi???a c??c l???ch h???c m???t c??ch nhanh ch??ng."
                });
                button14.setFontText(Button.ARIAL_BOLD_21);
                button14.setCorrectSizeButton();
                button14.setLocationText(15, 15);
                button14.setSizeButton(width / 20 * 19 / 3 - 10, button14.getHeight());
                button14.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button14.setStrokeWidth(0);
                button14.setBackgroundColorButton(dialog.getBackground());
                button14.setEnable(false);
                panelScroll.add(button14);

                Button button15 = new Button("");
                button15.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button15.setLocationButton(button12.getX() + button12.getWidth(), tempHeight, Button.TOP_LEFT);
                button15.setStrokeWidth(0);
                button15.setGradientBackgroundColor(null, null, null);
                button15.setBackgroundImage(Setting.GUIDE_CHECK_VALID_TIME_TABLE_2);
                button15.setEnable(false);
                panelScroll.add(button15);
                button14.setSizeButton(button14.getWidth(), button15.getHeight());
                tempHeight += button15.getHeight() + 50;

                // Guide remove class subject
                Button button16 = new Button(new String[] {
                                "7. X??a m?? l???p h???c",
                                "+ Nh???n n??t (nh?? h??nh) ????? x??a m???t m?? l???p h???c."
                });
                button16.setFontText(Button.ARIAL_BOLD_21);
                button16.setCorrectSizeButton();
                button16.setLocationText(15, 15);
                button16.setSizeButton(width / 20 * 19 / 3 - 10, button16.getHeight());
                button16.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button16.setStrokeWidth(0);
                button16.setBackgroundColorButton(dialog.getBackground());
                button16.setEnable(false);
                panelScroll.add(button16);

                Button button17 = new Button("");
                button17.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button17.setLocationButton(button12.getX() + button12.getWidth(), tempHeight, Button.TOP_LEFT);
                button17.setStrokeWidth(0);
                button17.setGradientBackgroundColor(null, null, null);
                button17.setBackgroundImage(Setting.GUIDE_REMOVE_CLASS_OF_SUBJECT);
                button17.setEnable(false);
                panelScroll.add(button17);
                button16.setSizeButton(button16.getWidth(), button17.getHeight());
                tempHeight += button17.getHeight() + 50;

                // Guide remove subject
                Button button18 = new Button(new String[] {
                                "8. X??a m???t m??n h???c",
                                "+ Nh???n n??t (nh?? h??nh) ????? x??a m???t m??n h???c."
                });
                button18.setFontText(Button.ARIAL_BOLD_21);
                button18.setCorrectSizeButton();
                button18.setLocationText(15, 15);
                button18.setSizeButton(width / 20 * 19 / 3 - 10, button18.getHeight());
                button18.setLocationButton(width / 20 / 2, tempHeight, Button.TOP_LEFT);
                button18.setStrokeWidth(0);
                button18.setBackgroundColorButton(dialog.getBackground());
                button18.setEnable(false);
                panelScroll.add(button18);

                Button button19 = new Button("");
                button19.setSizeButton(width / 20 * 19 / 3 * 2,
                                (int) (width / 20 * 19 * 1.0 * Setting.HEIGHT / Setting.WIDTH) / 3 * 2);
                button19.setLocationButton(button12.getX() + button12.getWidth(), tempHeight, Button.TOP_LEFT);
                button19.setStrokeWidth(0);
                button19.setGradientBackgroundColor(null, null, null);
                button19.setBackgroundImage(Setting.GUIDE_REMOVE_SUBJECT);
                button19.setEnable(false);
                panelScroll.add(button19);
                button18.setSizeButton(button18.getWidth(), button19.getHeight());
                tempHeight += button19.getHeight() + 200;

                panelScroll.setSize(width, Math.max(tempHeight, height));
                panelScroll.setLocation(0, 0);
                updateContent();
                panelScroll.addMouseWheelListener(new MouseWheelHandler());
                dialog.add(panelScroll);

                // Show dialog
                dialog.setVisible(true);
        }

        public void updateContent() {
                panelScroll.setBounds(panelScroll.getX(), -this.scrollCursor, panelScroll.getWidth(),
                                panelScroll.getHeight());
        }

        // Get max of scrollCursor
        public int getMaxScrollCursor() {
                return Math.max(0, panelScroll.getHeight() - dialog.getHeight());
        }

        // Set cursor
        public void setScrollCursor(int value) {
                if (value < 0) {
                        this.scrollCursor = 0;
                } else if (value > getMaxScrollCursor()) {
                        this.scrollCursor = getMaxScrollCursor();
                } else {
                        this.scrollCursor = value;
                }
        }

        private class MouseWheelHandler implements MouseWheelListener {
                public void mouseWheelMoved(MouseWheelEvent event) {
                        for (int count = 0; count < 20; count++) {
                                setScrollCursor(scrollCursor + event.getWheelRotation());
                        }
                        updateContent();
                }

        }

}
