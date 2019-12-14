package _02_Pixel_Art;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

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
		// TODO Auto-generated method stub
		try {
			FileWriter fw = new FileWriter("save_file");
		
			System.out.println(panel.pixels.toString());
			fw.write(panel.pixels.toString());
			
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
