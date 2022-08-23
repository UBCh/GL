package domain;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Streams {
    static private String path="src/test/resources/";

    public static void inputFile(String fileNameInput) throws IOException {
        FileReader fr = new FileReader(path+fileNameInput);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine( );
        String[] taskСonditions = line.split(",");
        int y = Integer.parseInt(taskСonditions[0]);
        Engine.setY(y);
        int x = Integer.parseInt(taskСonditions[1]);
        Engine.setX(x);
        Engine.setNumberOfLives(Integer.parseInt(taskСonditions[2]));
        char[][] input = new char[y][x];
        char[] tmp ;
            for (int i = 0; i < y; i++) {
                line = reader.readLine( );
                if (line==null){ break;}
                line = line.replace(" ", "");
                tmp = line.toCharArray( );
                for (int j = 0; j < x; j++) {
                    input[i][j] = tmp[j];
                }

            }

        Engine.setFieldOfLife(input);

    }


    public static void outputFile(String fileNameOutput) throws IOException {
               StringBuilder stringBuilder = new StringBuilder( );
        char[][] tmp = Engine.getFieldOfLife( );
        for (int G = 0; G < Engine.getY( ); G++) {
            for (int E = 0; E < Engine.getX( ); E++) {
                stringBuilder.append(tmp[G][E]).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length( ) - 1);
            stringBuilder.append("\n");
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+fileNameOutput)));
            out.append(stringBuilder);
            out.close( );
        }

    }
}



