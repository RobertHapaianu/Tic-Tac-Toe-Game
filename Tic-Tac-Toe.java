import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Joc joc1 = new Joc();
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        while (joc1.getCont_moves() < 9 && joc1.solutie("X") == false && joc1.solutie("0") == false) {
            try {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                joc1.checkMove(x, y);
                joc1.mutare(x, y);
            }
            catch(Exception e) {
                System.out.println("\nA problem occured " + e);
                //joc1.lowerCont_moves();
                joc1.getTabla();
            }
        }
        
        if (joc1.solutie("X") == false && joc1.solutie("0") == false)
            System.out.println("\nREMIZA!!!\n");
        scanner.close();
    }


}