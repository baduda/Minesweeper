import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Board board = new Board();
        boolean boom;
        do {
            board.print();

            System.out.println("Input cell x and y: ");
            int y = scanner.nextInt();
            int x = scanner.nextInt();

            boom = board.swap(x, y);
        } while ( !boom && !board.allOpen());

        if (boom) {
            board.print();
            System.out.println("Boom!");
        } else {
            System.out.println("Win!");
        }
    }
}
