import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    private int targetNumber;
    private int turno;
    private boolean adivino;

    public GuessTheNumberGame() {
        Random random = new Random();
        this.targetNumber = random.nextInt(100) + 1;
        System.out.println("NUMERO A ADIVINAR:"+this.targetNumber);
    }

    public void checkGuess(Player player) {
        int guess = player.makeGuess();
        System.out.println(player.getName() + " ha adivinado el número: " + guess);

        if (guess == targetNumber) {
            System.out.println("¡Felicidades! " + player.getName() + " ha adivinado el número.");
            adivino = true;
        } else {
            System.out.println("Sigue intentando, " + player.getName() + ".");
        }
    }

    public void iniciarJuego() {
        HumanPlayer humanPlayer = new HumanPlayer();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escribe tu nombre");
        String nombre = scanner.next();
        humanPlayer.setName(nombre);
        ComputerPlayer computerPlayer = new ComputerPlayer();
        computerPlayer.setName("Computer player");


        while (!adivino) {
            if (turno == 1) {
                checkGuess(humanPlayer);
                turno = 0;
            }else{
                checkGuess(computerPlayer);
                turno = 1;
            }
        }
    }
}
