import java.util.*;
import solver.Solver;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Solver solver = new Solver();
        System.out.println("Insert value: ");
        int value = scanner.nextInt();
        System.out.println(solver.solve(value));
    }
}
