package example;


import domain.Engine;
import domain.Streams;

import java.io.IOException;

public class GameOfLife {

  // TODO:
  public void game(String fileNameInput, String fileNameOutput) throws IOException {
    Streams.inputFile(fileNameInput);
    Engine.lifeCycle();
    Streams.outputFile(fileNameOutput);
  }
  
}