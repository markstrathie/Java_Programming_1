package gui;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class DirectionPanel extends JPanel implements ActionListener {
	
	private GameWorld gameWorld;

	public DirectionPanel(GameWorld gameWorld) {
		this.gameWorld = gameWorld;
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBorder(new TitledBorder("Directions"));
		
		Box northBox = Box.createHorizontalBox();
		northBox.add(Box.createGlue());
		northBox.add(createDirectionButton(MoveDirection.NORTH));
		northBox.add(Box.createGlue());

		Box eastWestBox = Box.createHorizontalBox();
		eastWestBox.add(createDirectionButton(MoveDirection.WEST));
		eastWestBox.add(Box.createHorizontalStrut(25));
		eastWestBox.add(createDirectionButton(MoveDirection.EAST));

		Box southBox = Box.createHorizontalBox();
		southBox.add(Box.createGlue());
		southBox.add(createDirectionButton(MoveDirection.SOUTH));
		southBox.add(Box.createGlue());

		add(northBox);
		add(eastWestBox);
		add(southBox);
	}
	
	
	private JButton createDirectionButton(MoveDirection dir) {
		JButton button = new JButton(dir.toString());
		button.addActionListener(this);
		return button;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
		{
		String cmd = e.getActionCommand();
		MoveDirection cmdEnum = MoveDirection.valueOf(cmd);
		gameWorld.getTrainerSprite().move(cmdEnum);
		}
	
}
