package Map;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Map {
	public void call(String s, String tittle) throws Exception{
	    JFrame frame = new JFrame();
	    JPanel panel = new JPanel();
	    BufferedImage image;
		try {
			image = ImageIO.read(new URL(s));
			JLabel label = new JLabel(new ImageIcon(image));
			panel.add(label);
			frame.add(panel);
			frame.setTitle(tittle);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Finner ikke kartet: er du koblet til internett?");
		}
	}
}
