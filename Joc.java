public class Joc {
    private String tabla[][] = new String[3][3];
    private int playerTurn = 0;
    private int cont_moves;
    public Joc() {
        cont_moves = 0;
        System.out.println("   |   |   ");
        System.out.println("   |   |   ");
        System.out.println("   |   |   ");

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                this.tabla[i][j] = "1";
    }

    public void mutare(int x, int y) {
        cont_moves++;
        if (this.playerTurn == 0) {
            this.tabla[x][y] = "X";
            this.playerTurn = 1;
            getTabla();
            if (solutie("X")) 
                System.out.println("X-ul a castigat!");
        }
        else {
            this.tabla[x][y] = "0";
            this.playerTurn = 0;
            getTabla();
            if (solutie("0"))
                System.out.println("0-ul a castigat");
        }
    }

    public boolean solutie(String X0) {
        int cont_x0 = 0;
        for (int i = 0; i < 3; i++) {
            if (cont_x0 == 3)
                return true;
            cont_x0 = 0;
            for (int j = 0; j < 3; j++) 
                if (tabla[i][j].equals(X0))
                    ++cont_x0;
        }
        for (int j = 0; j < 3; j++) {
            if (cont_x0 == 3)
                return true;
            cont_x0 = 0;
            for (int i = 0; i < 3; i++) 
                if (tabla[i][j].equals(X0))
                    ++cont_x0;
        }

        if (tabla[0][0].equals(X0) && tabla[1][1].equals(X0) && tabla[2][2].equals(X0))
            return true;
        if (tabla[0][2].equals(X0) && tabla[1][1].equals(X0) && tabla[2][0].equals(X0))
            return true;

        return false;
    }

    public void checkMove(int x, int y) throws UsedWindowException {
        if (tabla[x][y].equals("1") == false)
            throw new UsedWindowException("Aceasta casuta a fost deja folosita!");
    }

    public void getTabla() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.tabla[i][j] == "1") {
                    System.out.print("   ");
                    if (j != 2)
                        System.out.print("|");
                    continue;
                }
                System.out.print(" " + this.tabla[i][j] + " ");
                if (j != 2)
                System.out.print("|");
            }
            System.out.println();
        }
    }

    public void lowerCont_moves() {
        --this.cont_moves;
    }
    public int getCont_moves() {
        return this.cont_moves;
    }

}
