package gui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game_controllers.Trainer;
import monsters.Monster;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class EnvironmentPanel extends JPanel implements ActionListener {
	
	private GameWorld gameWorld;
	
	private JButton respawnButton, startButton, stopButton;
	
	public EnvironmentPanel(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBorder(new TitledBorder("Environment controls"));
		
		respawnButton = new JButton("Respawn all");
		add(respawnButton);
		respawnButton.addActionListener(this);
		
		startButton = new JButton("Start monsters");
		add(startButton);
		startButton.addActionListener(this);
		
		stopButton = new JButton("Stop monsters");
		add(stopButton);
		stopButton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == respawnButton) {
			gameWorld.spawnMonstersAndItems();
			
		} else if (e.getSource() == startButton)
		{
			
			
		} else if (e.getSource() == stopButton)
		{
			
			
		}
	} 
}
