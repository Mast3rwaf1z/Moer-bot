package bot1;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

/**
 * GUI
 */
public class GUI extends JFrame implements WindowListener, ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public final String activity = "Gaust er mør";
    static public boolean button1pressed = false;
    static public boolean button2pressed = false;
    static public boolean button3pressed = false;
    static public boolean online = false;
    static public boolean idle = false;
    static public boolean DnD = false;
    private final JButton button;
    private final JButton button2;
    private final JButton button3;
    final private String[] list = { "Online", "Idle", "Do not Disturb" };
    JComboBox<String> box = new JComboBox<>(list);

    public GUI(final String title) {
        super(title);
        JPanel line2 = new JPanel();
        JPanel line3 = new JPanel();
        this.setLayout(new FlowLayout());
        this.setResizable(false);
        this.setVisible(true);
        this.setIconImage(new ImageIcon("BotImage").getImage());
        button = new JButton("Er gaust mør?");
        button2 = new JButton("Mørcounter");
        button3 = new JButton("Reset Mør");
        JTextArea titlepanel = new JTextArea(title + " Kontrolpanel");
        this.add(titlepanel);
        line2.add(button);
        line2.add(box);
        this.add(line2);
        line3.add(button2);
        line3.add(button3);
        this.add(line3);
        button.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        this.setSize(250, 140);
        this.setResizable(false);
        HideGUI();
        box.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED && list[0].equals(e.getItem())) {
                }
                if (e.getStateChange() == ItemEvent.SELECTED && list[1].equals(e.getItem())) {
                    idle = true;
                }
                if (e.getStateChange() == ItemEvent.SELECTED && list[2].equals(e.getItem())) {
                    DnD = true;
                }
            }
        });
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == button) {
            button1pressed = true;
            System.out.println("Er gaust mør?");
        }
        if (e.getSource() == button2) {
            button2pressed = true;
        }
        if (e.getSource() == button3) {
            button3pressed = true;
        }
    }

    @Override
    public void windowOpened(final WindowEvent e) {

    }

    @Override
    public void windowClosing(final WindowEvent e) {
    	System.out.println("windowclosing!");
        this.dispose();
        System.exit(0);

    }

    @Override
    public void windowClosed(final WindowEvent e) {
    	System.out.println("windowclosed!");
    	this.dispose();
    	System.exit(0);
    }
    
    protected void processWindowEvent(WindowEvent e) {
    	super.processWindowEvent(e);
    	if (e.getID() == WindowEvent.WINDOW_CLOSING) {
			this.dispose();
			System.exit(0);
		}
    }

    @Override
    public void windowIconified(final WindowEvent e) {

    }

    @Override
    public void windowDeiconified(final WindowEvent e) {

    }

    @Override
    public void windowActivated(final WindowEvent e) {

    }

    @Override
    public void windowDeactivated(final WindowEvent e) {

    }

    TrayIcon trayIcon;
    SystemTray tray;

    public void HideGUI() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        if (SystemTray.isSupported()) {
            tray = SystemTray.getSystemTray();

            Image image = Toolkit.getDefaultToolkit().getImage("BotImage.jpg");
            ActionListener exitListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            };
            PopupMenu popup = new PopupMenu();
            MenuItem defaultItem = new MenuItem("Exit");
            defaultItem.addActionListener(exitListener);
            popup.add(defaultItem);
            defaultItem = new MenuItem("Open");
            defaultItem.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    setVisible(true);
                    setExtendedState(JFrame.NORMAL);
                }
            });
            popup.add(defaultItem);
            trayIcon = new TrayIcon(image, "Mør Bot", popup);
            trayIcon.setImageAutoSize(true);
        }
        addWindowStateListener(new WindowStateListener() {
            public void windowStateChanged(WindowEvent e) {
                if (e.getNewState() == ICONIFIED) {
                    try {
                        tray.add(trayIcon);
                        setVisible(false);
                    } catch (AWTException ex) {
                    }
                }
                if (e.getNewState() == 7) {
                    try {
                        tray.add(trayIcon);
                        setVisible(false);
                    } catch (AWTException ex) {
                    }
                }
                if (e.getNewState() == MAXIMIZED_BOTH) {
                    tray.remove(trayIcon);
                    setVisible(true);
                }
                if (e.getNewState() == NORMAL) {
                    tray.remove(trayIcon);
                    setVisible(true);
                }
            }
        });
    }
}