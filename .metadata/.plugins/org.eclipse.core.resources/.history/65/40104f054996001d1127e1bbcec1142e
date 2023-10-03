import java.util.Random;
import java.util.Scanner;

class RockPaperScissors {

    private Scanner userInput = new Scanner(System.in);
    private Random rand = new Random();
    private int numberOfWeapons;

    RockPaperScissors(){

    }

    private void consoleOutput(String message){
        System.out.println(message);
    }

    private String consoleStringInput(String message){
        consoleOutput(message);
        return userInput.nextLine();
    }

    private int consoleIntInput(String message){
        consoleOutput(message);
        int result = -1;
        do {
            try {
                result = userInput.nextInt();
            } catch (NumberFormatException exception) {
                consoleOutput("Please enter a integer");
            }
        } while (result < 0);

        return result;
    }

    public String generateRequest(String[] weapons){
        String display = "Please select";
        /*for (int i=0;i<weapons.length;i++){*/
        int i=0;
        for (String weapon: weapons){
            display += " " + i + " " + weapon;
            i++;
        };
        return display;
    }

    private int requestPlay(String[] weapons)
    {
        return consoleIntInput(generateRequest(weapons));
    }

    public String determineWinner(String[] weaponList, int userWeapon, int computerWeapon)
    {
        String winner;
        if (userWeapon == computerWeapon)
        {
            winner = "Draw both selected " + weaponList[computerWeapon];
        }
        else if ((userWeapon + 1) % 3 == computerWeapon)
        {
            winner = "You win and beat the computer's " + weaponList[computerWeapon];
        }
        else if ((computerWeapon + 1) % 3 == userWeapon)
        {
            winner = "Computer wins with " + weaponList[computerWeapon];
        }
        else {
            winner = "Please select 1. Rock, 2. Scissors or 3. Paper";
        }

        return winner;

    }

    private void displayWinner(String winner)
    {
        consoleOutput(winner);
    }

    private int getComputerInt(){
        return rand.nextInt(numberOfWeapons);
    }

    public void playGame(String[] weaponList){
        int userWeapon;
        numberOfWeapons = weaponList.length;
        int computerWeapon;
        String winner;
        //Final declares
        userWeapon = requestPlay(weaponList);
        do{
            computerWeapon = getComputerInt();
            winner = determineWinner(weaponList, userWeapon, computerWeapon);
            displayWinner(winner);
            userWeapon = requestPlay(weaponList);
        } while (userWeapon< weaponList.length);

    }

    public static void main(String[ ] args){
        String[] weaponlist = {"Rock", "Scissors", "Paper"};
        RockPaperScissors rockPaperScissor = new RockPaperScissors();
        rockPaperScissor.playGame(weaponlist);
    }

}