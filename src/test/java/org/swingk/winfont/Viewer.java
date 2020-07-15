package org.swingk.winfont;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.stream.IntStream;

public class Viewer {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(Viewer::showUI);
    }

    private static void showUI() {
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(3, 3, 3, 3));

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        DefaultComboBoxModel<WinFont> fontModel = new DefaultComboBoxModel<>(WinFont.values());
        JComboBox<WinFont> fontCombo = new JComboBox<>(fontModel);
        panel.add(fontCombo);

        DefaultComboBoxModel<Float> sizeModel = new DefaultComboBoxModel<>();
        IntStream.rangeClosed(8, 48).forEach(i -> sizeModel.addElement((float) i));
        JComboBox<Float> sizeCombo = new JComboBox<>(sizeModel);
        panel.add(sizeCombo);
        sizeModel.setSelectedItem(Float.valueOf(12.0f));

        contentPanel.add(panel, BorderLayout.NORTH);

        JTextArea textArea = new JTextArea();
        textArea.setBorder(LineBorder.createGrayLineBorder());
        textArea.setLineWrap(true);
        textArea.setText(" The quick brown fox jumps over the lazy dog\n THE QUICK BROWN FOX JUMPS OVER THE LAZY DOG");
        contentPanel.add(textArea, BorderLayout.CENTER);

        Runnable applyFont = () -> {
            WinFont winFont = (WinFont) fontModel.getSelectedItem();
            float size = (Float) sizeModel.getSelectedItem();
            textArea.setFont(WinFontFactory.getFont(winFont).deriveFont(size));
        };
        applyFont.run();
        fontCombo.addActionListener(e -> applyFont.run());
        sizeCombo.addActionListener(e -> applyFont.run());

        JFrame frame = new JFrame("win-font");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(contentPanel);
        frame.setSize(1000, 600);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}
