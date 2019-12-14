package _02_Pixel_Art;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JButton;
import javax.swing.JPanel;

public class SavePanel extends JPanel implements ActionListener{
	
	private JButton save;
	GridPanel panel;
	
	SavePanel() {
		save = new JButton("Save");
		save.addActionListener(this);
		add(save);
	}
	
	void input(GridPanel p) {
		panel = p;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		System.out.println("saved?");
		try (FileOutputStream fos = new FileOutputStream(new File("src/_02_Pixel_Art/save_file.txt")); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(panel.pixels);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
