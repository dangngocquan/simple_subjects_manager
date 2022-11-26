package code.screen;

import javax.swing.JPanel;
import code.Application;
import code.Setting;
import code.file_handler.ReadFile;
import code.objects.Button;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScreenAccounts extends JPanel {
    // Properties, Objects and Screens
    private Application applicationFrame;
    private String[] buttonTexts = {
            "Các tài khoản hiện có", "Tạo tài khoản mới", "Quay lại"
    };
    private Button[] buttons;
    private ScreenMainMenu parentScreen;
    private JPanel mainScreen;
    private ScreenExistingAccounts screenExistingAccounts;
    private ScreenCreateNewAccount screenCreateNewAccount;

    // Constructor
    public ScreenAccounts(int width, int height, ScreenMainMenu parentScreen, Application frame) {
        // Set basic properties for this screen
        this.applicationFrame = frame;
        setLayout(null);
        setBounds(0, 0, width, height);
        setSize(width, height);
        this.parentScreen = parentScreen;

        // Create screens
        mainScreen = new JPanel();
        mainScreen.setLayout(null);
        mainScreen.setSize(width, height);
        mainScreen.setBounds(0, 0, width, height);
        screenExistingAccounts = new ScreenExistingAccounts(width, height,
                this, applicationFrame);
        screenCreateNewAccount = new ScreenCreateNewAccount(width, height,
                this, applicationFrame);

        // Create buttons
        buttons = new Button[buttonTexts.length];
        for (int count = 0; count < buttonTexts.length; count++) {
            buttons[count] = new Button(buttonTexts[count]);
            buttons[count].setFont(
                    Setting.FONT_NAME_01,
                    Setting.FONT_STYLE_01,
                    Setting.FONT_SIZE_MEDIUM);
            buttons[count].addActionListener(new ButtonHandler());
        }

        // Set location for each button
        buttons[0].setLocation(width / 2, height / 12 * 3, Button.TOP_CENTER);
        buttons[1].setLocation(width / 2, height / 12 * 5, Button.TOP_CENTER);
        buttons[2].setLocation(width / 2, height / 12 * 7, Button.TOP_CENTER);

        // Add buttons to mainScreen
        for (Button button : buttons) {
            mainScreen.add(button);
        }

        // Add screen to this panel
        add(mainScreen);
        add(screenCreateNewAccount);
        add(screenExistingAccounts);

        // Set visible of screens
        mainScreen.setVisible(true);
        screenCreateNewAccount.setVisible(false);
        screenExistingAccounts.setVisible(false);
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
    public ScreenMainMenu getParentScreen() {
        return this.parentScreen;
    }

    // Get Screen create new account
    public ScreenCreateNewAccount getScreenCreateNewAccount() {
        return this.screenCreateNewAccount;
    }

    // Get mainScreen
    public JPanel getMainScreen() {
        return this.mainScreen;
    }

    // Get Screen Exisitng accounts
    public ScreenExistingAccounts getScreenExistingAccounts() {
        return this.screenExistingAccounts;
    }

    // Auto called method of JPanel
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    // Handler buttons
    private class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Press at "Existing Accounts" in mainScreen
            if (event.getSource() == buttons[0]) {
                screenExistingAccounts.setVisible(true);
                screenExistingAccounts.updatePanelListAccount();
                screenExistingAccounts.updatePanelAccountInfor(ReadFile.getCurrentAccount());
                getMainScreen().setVisible(false);
            }
            // Press at "Create New Account" in mainScreen
            else if (event.getSource() == buttons[1]) {
                getScreenCreateNewAccount().setVisible(true);
                getMainScreen().setVisible(false);
            }
            // Press at "Back" in mainScreen
            else if (event.getSource() == buttons[2]) {
                getParentScreen().getMainScreen().setVisible(true);
                getParentScreen().updateDescriptionPanel();
                getParentScreen().getScreenAccounts().setVisible(false);
            }
        }
    }
}
