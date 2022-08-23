package domain;

public class Engine {
    public Engine() {
    }

     private static int y;
    private static int x;
    private static int numberOfLives;
    private static char[][] fieldOfLife;

    public static void setFieldOfLife(char[][] fieldOfLife) {
        Engine.fieldOfLife = fieldOfLife;
    }

    public static char[][] getFieldOfLife() {
        return fieldOfLife;
    }

    public static int getY() {
        return y;
    }

    public static int getX() {
        return x;
    }

    public static void setY(int vertically) {
        y = vertically;
    }

    public static void setX(int horizontally) {
        x = horizontally;
    }

    public static void setNumberOfLives(int numberOL) {
        numberOfLives = numberOL;
    }


    public static void lifeCycle() {
        char[][] newLife;
        for (int life = 0; life < numberOfLives; life++) {
            newLife = new char[y][x];
            for (int i = 0; i < y; i++) {

                for (int j = 0; j < x; j++) {

                    newLife[i][j] = weСheckЕheМiability(i, j);

                }

            }
            fieldOfLife = newLife;

        }

    }


    private static char weСheckЕheМiability(int v, int h) {
        int lifeСounter = 0;
        char celuli = fieldOfLife[v][h];
       char tmp;
        int verticali;
        int horizontali;

        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                verticali = (v + i + y) % y;
                horizontali = (h + j + x) % x;
                tmp = fieldOfLife[verticali][horizontali];
                if (tmp == 'X') {
                    lifeСounter++;
                }
            }
        }
        if (celuli=='X') {
             lifeСounter --;
             return getCellByState(shouldAliveCellLive(lifeСounter));
        }
        else {return getCellByState(shouldDeadCellLive(lifeСounter));}

    }

    private static boolean shouldAliveCellLive(int lifCounter) {
        return lifCounter > 1 && lifCounter < 4;
    }

    private static boolean shouldDeadCellLive(int lifCounter) {
        return lifCounter == 3;
    }

    private static char getCellByState(boolean state) {
        return state ? 'X' : 'O';
    }
}





