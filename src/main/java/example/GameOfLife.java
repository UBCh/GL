package example;




import java.io.*;

public class GameOfLife {

  private  int verticalSize;
  private  int horizontalSize;
  private  int numberOfCycles;
  private  char[][] originalPlayingField;



  public void game(String fileNameInput, String fileNameOutput) {
   inputFile(fileNameInput);
   lifeCycle();
    outputFile(fileNameOutput);
  }

  public  void inputFile(String fileNameInput)  {
    String path="src/test/resources/";
  try {FileReader fr = new FileReader(path+fileNameInput);
    BufferedReader reader = new BufferedReader(fr);
    String line = reader.readLine( );
    String[] taskСonditions = line.split(",");
    verticalSize=Integer.parseInt(taskСonditions[0]);
    horizontalSize= Integer.parseInt(taskСonditions[1]);
    numberOfCycles=Integer.parseInt(taskСonditions[2]);
    char[][] input = new char[verticalSize][horizontalSize];
    char[] tmp ;
    for (int i = 0; i < verticalSize; i++) {
      line = reader.readLine( );
      if (line==null){ break;}
      line = line.replace(" ", "");
      tmp = line.toCharArray( );
      for (int j = 0; j < horizontalSize; j++) {input[i][j] = tmp[j];}}
    originalPlayingField =input;}
  catch (IOException e) {
    e.printStackTrace( ); }
  }

  public  void lifeCycle() {
    char[][] newLife;
    for (int life = 0; life < numberOfCycles; life++) {
      newLife = new char[verticalSize][horizontalSize];
      for (int i = 0; i < verticalSize; i++) {
        for (int j = 0; j < horizontalSize; j++) {
          newLife[i][j] = viabilityCheck(i, j);}
      }
      originalPlayingField = newLife;
    }
  }

  private  char viabilityCheck(int v, int h) {
    int counter = 0;
    char celuli = originalPlayingField[v][h];
    char tmp;
    int verticali;
    int horizontali;
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        verticali = (v + i + verticalSize) % verticalSize;
        horizontali = (h + j + horizontalSize) % horizontalSize;
        tmp = originalPlayingField[verticali][horizontali];
        if (tmp == 'X') {counter++;}}
    }
    if (celuli=='X') {counter--; return getCellByState(shouldAliveCellLive(counter)); }
    else {return getCellByState(shouldDeadCellLive(counter));}
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

  public  void outputFile(String fileNameOutput) {
    String path="src/test/resources/";
    StringBuilder stringBuilder = new StringBuilder( );
    char[][] tmp = originalPlayingField;
    for (int G = 0; G < verticalSize; G++) {
      for (int E = 0; E < horizontalSize; E++) {
        stringBuilder.append(tmp[G][E]).append(" ");}
      stringBuilder.deleteCharAt(stringBuilder.length( ) - 1);
      stringBuilder.append("\n");
       try { BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path+fileNameOutput)));
         out.append(stringBuilder);
         out.close( ); }
       catch (IOException e) {e.printStackTrace( );}
    }}
}




