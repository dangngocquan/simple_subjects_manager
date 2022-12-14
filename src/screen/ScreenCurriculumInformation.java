package src.screen;

import javax.swing.JPanel;

import src.animation.AnimationPanel;
import src.dialog.DialogList;
import src.launcher.Application;
import src.launcher.Data;
import src.launcher.Setting;
import src.objects.Button;
import src.objects.Department;
import src.objects.Major;
import src.objects.School;
import src.panel.PanelMajor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Graphics;

public class ScreenCurriculumInformation extends JPanel {
        // Properties, Objects and Screens
        private Application applicationFrame;
        private ScreenInformation parentScreen;
        private JPanel mainScreen;
        private String[] buttonTexts = {
                        "Quay lại", "Thay đổi", "", "", ""
        };
        private Button[] buttons;
        private JPanel headPanel, bodyPanel;
        private JPanel headPanel1, headPanel2, headPanel3;
        private JPanel bodyPanel0;

        private School school = Data.SCHOOLS.getSchools().get(0);
        private Department department = school.getDepartments().get(0);
        private Major major = department.getMajors().get(0);

        // Constructor
        public ScreenCurriculumInformation(int width, int height, ScreenInformation parentScreen, Application frame) {
                // Set basic properties
                this.applicationFrame = frame;
                setLayout(null);
                setSize(width, height);
                setBounds(0, 0, width, height);
                this.parentScreen = parentScreen;

                // Create screens
                mainScreen = new JPanel();
                mainScreen.setLayout(null);
                mainScreen.setSize(width, height);
                mainScreen.setBounds(0, 0, width, height);

                // Create sub panels of "mainScreen"
                headPanel = new JPanel();
                headPanel.setLayout(null);
                headPanel.setSize(width, height / 7);
                headPanel.setBounds(0, 0, headPanel.getWidth(), headPanel.getHeight());

                bodyPanel = new JPanel();
                bodyPanel.setLayout(null);
                bodyPanel.setSize(width, height - headPanel.getHeight());
                bodyPanel.setBounds(0, headPanel.getHeight(), bodyPanel.getWidth(),
                                bodyPanel.getHeight());

                // Create sub panels of "headPanel"
                headPanel1 = new JPanel();
                headPanel1.setLayout(null);
                headPanel1.setSize(headPanel.getWidth() / 8, headPanel.getHeight());
                headPanel1.setBounds(0, 0, headPanel1.getWidth(), headPanel1.getHeight());

                headPanel3 = new JPanel();
                headPanel3.setLayout(null);
                headPanel3.setSize(headPanel.getWidth() / 8, headPanel.getHeight());
                headPanel3.setBounds(headPanel.getWidth() - headPanel3.getWidth(), 0,
                                headPanel3.getWidth(), headPanel3.getHeight());

                headPanel2 = new JPanel();
                headPanel2.setLayout(null);
                headPanel2.setSize(headPanel.getWidth() - headPanel1.getWidth() - headPanel3.getWidth(),
                                headPanel.getHeight());
                headPanel2.setBounds(headPanel1.getWidth(), 0, headPanel2.getWidth(),
                                headPanel2.getHeight());

                // Create sub panels of "bodyPanel"
                bodyPanel0 = new JPanel();
                bodyPanel0.setLayout(null);
                bodyPanel0.setSize(bodyPanel.getWidth() / 16 * 15, bodyPanel.getHeight() / 16
                                * 15);
                bodyPanel0.setBounds(bodyPanel.getWidth() / 2 - bodyPanel0.getWidth() / 2,
                                bodyPanel.getHeight() / 2 - bodyPanel0.getHeight() / 2,
                                bodyPanel0.getWidth(), bodyPanel0.getHeight());

                // Create buttons
                buttons = new Button[buttonTexts.length];
                for (int count = 0; count < buttonTexts.length; count++) {
                        buttons[count] = new Button(buttonTexts[count]);
                        buttons[count].setFontText(Button.ARIAL_BOLD_24);
                        buttons[count].setCorrectSizeButton();
                        buttons[count].addMouseListener(new MouseHandler());
                }

                buttons[2].setEnable(false);
                buttons[3].setEnable(false);
                buttons[4].setEnable(false);

                buttons[2].setStrokeWidth(0);
                buttons[3].setStrokeWidth(0);
                buttons[4].setStrokeWidth(0);

                buttons[2].setFontText(Button.ARIAL_BOLD_18);
                buttons[3].setFontText(Button.ARIAL_BOLD_18);
                buttons[4].setFontText(Button.ARIAL_BOLD_18);

                buttons[2].setLocationText(0, 0);
                buttons[3].setLocationText(0, 0);
                buttons[4].setLocationText(0, 0);

                buttons[2].setGradientBackgroundColor(Setting.GRADIENT_POINTS1_3, Setting.GRADIENT_POINTS2_3,
                                Setting.GRADIENT_COLORS_3);
                ;
                buttons[3].setGradientBackgroundColor(Setting.GRADIENT_POINTS1_3, Setting.GRADIENT_POINTS2_3,
                                Setting.GRADIENT_COLORS_3);
                ;
                buttons[4].setGradientBackgroundColor(Setting.GRADIENT_POINTS1_3, Setting.GRADIENT_POINTS2_3,
                                Setting.GRADIENT_COLORS_3);
                ;

                buttons[2].setSizeButton(buttons[2].getWidth(), buttons[2].getHeight() / 2 + 6);
                buttons[3].setSizeButton(buttons[3].getWidth(), buttons[3].getHeight() / 2 + 6);
                buttons[4].setSizeButton(buttons[4].getWidth(), buttons[4].getHeight() / 2 + 6);

                // Update current curriculum
                updateCurriculum();

                // Set location for each button
                buttons[0].setLocationButton(headPanel1.getWidth() / 2, headPanel1.getHeight() / 2,
                                Button.CENTER_CENTER);
                buttons[1].setLocationButton(headPanel3.getWidth() / 2, headPanel3.getHeight() / 2,
                                Button.CENTER_CENTER);
                buttons[2].setLocationButton(headPanel2.getWidth() / 10, headPanel2.getHeight() / 4,
                                Button.CENTER_LEFT);
                buttons[3].setLocationButton(headPanel2.getWidth() / 10, headPanel2.getHeight() / 4 * 2,
                                Button.CENTER_LEFT);
                buttons[4].setLocationButton(headPanel2.getWidth() / 10, headPanel2.getHeight() / 4 * 3,
                                Button.CENTER_LEFT);

                // Add sub panels and buttons to "mainScreen"
                mainScreen.add(headPanel);
                mainScreen.add(bodyPanel);
                headPanel.add(headPanel1);
                headPanel.add(headPanel2);
                headPanel.add(headPanel3);
                headPanel1.add(buttons[0]);
                headPanel2.add(buttons[2]);
                headPanel2.add(buttons[3]);
                headPanel2.add(buttons[4]);
                headPanel3.add(buttons[1]);
                bodyPanel.add(bodyPanel0);
                bodyPanel0.add(new PanelMajor(0, 0, bodyPanel0.getWidth(), bodyPanel0.getHeight(),
                                major, PanelMajor.TOP_LEFT));

                // Add screens to this panel
                add(mainScreen);

                // Set visible of screens
                mainScreen.setVisible(true);

                // Set color and other
                headPanel1.setBackground(Setting.COLOR_RED_02);
                headPanel2.setBackground(Setting.COLOR_RED_02);
                headPanel3.setBackground(Setting.COLOR_RED_02);
        }

        // Update curriculum, school name, department name and major name
        public void updateCurriculum() {
                buttons[2].setTextButton("Trường: " + school.getName());
                buttons[3].setTextButton("Khoa: " + department.getName());
                buttons[4].setTextButton("Ngành: " + major.getName());
                buttons[2].setSizeButton(headPanel2.getWidth() / 10 * 8, buttons[2].getHeight());
                buttons[3].setSizeButton(headPanel2.getWidth() / 10 * 8, buttons[2].getHeight());
                buttons[4].setSizeButton(headPanel2.getWidth() / 10 * 8, buttons[2].getHeight());
                bodyPanel0.removeAll();
                bodyPanel0.add(new PanelMajor(0, 0, bodyPanel0.getWidth(), bodyPanel0.getHeight(),
                                major, PanelMajor.TOP_LEFT));

                repaint();
        }

        // Get application frame
        public Application getApplicationFrame() {
                return this.applicationFrame;
        }

        // Get buttons
        public Button[] getButtons() {
                return this.buttons;
        }

        // Get parentScreen
        public ScreenInformation getParentScreen() {
                return this.parentScreen;
        }

        // Get mainScreen
        public JPanel getMainScreen() {
                return this.mainScreen;
        }

        // Auto called method of JPanel
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
        }

        private class MouseHandler implements MouseListener {

                @Override
                public void mouseClicked(MouseEvent event) {
                }

                @Override
                public void mousePressed(MouseEvent event) {
                        // Press at "Back" of headPanel1 of headPanel of mainScreen
                        if (event.getSource() == buttons[0]) {
                                getParentScreen().getMainScreen().setVisible(true);
                                getParentScreen().getScreenCurriculumInformation().setVisible(false);
                                AnimationPanel animation = new AnimationPanel(getParentScreen().getMainScreen(),
                                                -getParentScreen().getMainScreen().getWidth(), 0, 0, 0,
                                                300);
                                animation.start();
                        }
                        // Press at "Change" of headPanel3 of headPanel of mainScreen
                        else if (event.getSource() == buttons[1]) {
                                // Dialog for user to choose School
                                DialogList dialog1 = new DialogList(Setting.WIDTH / 2, Setting.HEIGHT / 2,
                                                Setting.WIDTH / 3, Setting.HEIGHT / 2, DialogList.CENTER_CENTER,
                                                "", new String[] { "Chọn trường đại học" },
                                                Data.SCHOOLS.getArraySchoolNames());
                                String schoolName = dialog1.getText();
                                if (schoolName == null || schoolName.isEmpty()) {

                                } else {
                                        school = Data.getSchool(schoolName);
                                        department = school.getDepartments().get(0);
                                        major = department.getMajors().get(0);

                                        String departmentName = "";
                                        // Dialog for user to choose Department
                                        if (school.getName().equals(Data.SCHOOLS.getArraySchoolNames()[0])) {
                                                DialogList dialog2 = new DialogList(Setting.WIDTH / 2,
                                                                Setting.HEIGHT / 2,
                                                                Setting.WIDTH / 3, Setting.HEIGHT / 2,
                                                                DialogList.CENTER_CENTER,
                                                                "",
                                                                new String[] { "Chọn khoa của trường "
                                                                                + school.getName() },
                                                                school.getArrayDepartmentNames());
                                                departmentName = dialog2.getText();
                                        } else if (school.getName().equals(Data.SCHOOLS.getArraySchoolNames()[1])) {
                                                DialogList dialog2 = new DialogList(Setting.WIDTH / 2,
                                                                Setting.HEIGHT / 2,
                                                                Setting.WIDTH / 3, Setting.HEIGHT / 2,
                                                                DialogList.CENTER_CENTER,
                                                                "",
                                                                new String[] { "Chọn ngành của " + school.getName() },
                                                                school.getArrayDepartmentNames());
                                                departmentName = dialog2.getText();
                                        }

                                        if (departmentName == null || departmentName.isEmpty()) {

                                        } else {
                                                department = Data.getDepartment(departmentName, school);
                                                major = department.getMajors().get(0);

                                                String majorName = "";
                                                // Dialog for user to choose Major
                                                if (school.getName().equals(Data.SCHOOLS.getArraySchoolNames()[0])) {
                                                        DialogList dialog3 = new DialogList(Setting.WIDTH / 2,
                                                                        Setting.HEIGHT / 2,
                                                                        Setting.WIDTH / 3, Setting.HEIGHT / 2,
                                                                        DialogList.CENTER_CENTER,
                                                                        "",
                                                                        new String[] { "Chọn ngành của khoa "
                                                                                        + department.getName() },
                                                                        department.getArrayMajorNames());
                                                        majorName = dialog3.getText();
                                                } else if (school.getName()
                                                                .equals(Data.SCHOOLS.getArraySchoolNames()[1])) {
                                                        DialogList dialog3 = new DialogList(Setting.WIDTH / 2,
                                                                        Setting.HEIGHT / 2,
                                                                        Setting.WIDTH / 3, Setting.HEIGHT / 2,
                                                                        DialogList.CENTER_CENTER,
                                                                        "",
                                                                        new String[] { "Chọn chuyên ngành của ngành "
                                                                                        + department.getName() },
                                                                        department.getArrayMajorNames());
                                                        majorName = dialog3.getText();
                                                }

                                                if (majorName == null || majorName.isEmpty()) {

                                                } else {
                                                        major = Data.getMajor(majorName, department);
                                                }
                                        }
                                }
                                updateCurriculum();
                        }
                }

                @Override
                public void mouseReleased(MouseEvent event) {

                }

                @Override
                public void mouseEntered(MouseEvent event) {
                }

                @Override
                public void mouseExited(MouseEvent event) {
                }
        }
}
