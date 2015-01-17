
package swing;

import UI.ImageViewer;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ApplicationFrame extends JFrame{
    private ActionListenerFactory factory;
    private int index = 0;
    private ImageViewer imageViewer;

    public ImageViewer getImageViewer() {
        return imageViewer;
    }

    public ApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Image Viewer");
        this.factory = factory;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1024, 800);
        this.setLocationRelativeTo(null);
        this.createComponents();
    }

    private void createComponents() {
        this.add(createToolbar(), BorderLayout.SOUTH);
        this.add(createImagePanel());
    }

    private JPanel createToolbar() {
        JPanel panel = new JPanel();
        panel.add(createButton("Prev"));
        panel.add(createButton("Next"));
        panel.setBackground(Color.black);
        return panel;
    }

    private JPanel createImagePanel() {
        ImagePanel panel = new ImagePanel();
        imageViewer = panel;
        return panel;
    }

    private JButton createButton(String label) {
        JButton button = new JButton(label);
        button.addActionListener(factory.createActionListener(label));
        button.setBackground(Color.green);
        return button;
    }
}    
        
   