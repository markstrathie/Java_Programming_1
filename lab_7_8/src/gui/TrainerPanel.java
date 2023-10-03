package gui;

import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import game_controllers.Trainer;
import items.ItemType;
import monsters.Monster;

@SuppressWarnings("serial")
public class TrainerPanel extends JPanel implements ActionListener {

	private GameWorld gameWorld;
	private ControlPanel controlPanel;

	private JButton fightButton, restButton, useItemButton, pickupButton, catchButton;
	
	public TrainerPanel(GameWorld gameWorld, ControlPanel controlPanel) {
		this.gameWorld = gameWorld;
		this.controlPanel = controlPanel;

		setLayout(new GridLayout(0, 1));

		setBorder(new TitledBorder("Trainer actions"));

		fightButton = new JButton("Fight monster");
		add(fightButton);
		fightButton.addActionListener(this);

		catchButton = new JButton("Catch monster");
		add(catchButton);
		catchButton.addActionListener(this);

		pickupButton = new JButton("Pick up item");
		add(pickupButton);
		pickupButton.addActionListener(this);

		useItemButton = new JButton("Use item");
		add(useItemButton);
		useItemButton.addActionListener(this);

		restButton = new JButton("Rest team");
		add(restButton);
		restButton.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Point trainerLoc = gameWorld.getTrainerSprite().getLocation();
		Trainer trainer = gameWorld.getTrainerSprite().getTrainer();
		
		if (e.getSource() == fightButton) {
			MonsterSprite monsterSprite = gameWorld.getMonsterAt(trainerLoc);
			int monsterNum = controlPanel.getSelectedMonster();
			if (monsterSprite != null && monsterSprite.getMonster().isConscious() && monsterNum >= 0) {
				Monster wildMonster = monsterSprite.getMonster();
				trainer.fight(monsterNum, wildMonster);
			}
		}
		
		if (e.getSource() == restButton) {
			trainer.restTeam();
		}
		
		if (e.getSource() == pickupButton) {
			try {
				trainer.addItem(gameWorld.getItemAt(trainerLoc).getItemType().toString());
				gameWorld.removeItemSprite(gameWorld.getItemAt(trainerLoc));
			} catch (Exception noItem){
				//System.out.println("No item found here.");
			}
		}
		
		if (e.getSource() == useItemButton) {
			int monsterNum = controlPanel.getSelectedMonster();
			ItemType itemType = controlPanel.getSelectedItem();
			try {
				trainer.useItem(itemType.toString(), monsterNum);
			} catch (Exception cantUseItem) {
				//System.out.println("Can't use item.");
			}
		}
		
		if (e.getSource() == catchButton) {
			try {
				boolean monsterAdded = trainer.addMonster(gameWorld.getMonsterAt(trainerLoc).getMonster());
				if (monsterAdded)
				{
					gameWorld.removeMonsterSprite(gameWorld.getMonsterAt(trainerLoc));
				}
			} catch (Exception cantCatchMonster) {
				//System.out.println("Can't catch monster.");
			}
		}
		
		controlPanel.update();
	}

}
