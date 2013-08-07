
package com.tema.xsos;


public abstract class Game {
    
    private final Field field;
    
    // Constructor
    public Game(int fieldSize) {
        this.field = new Field(fieldSize);
    }
    
    public Field getField() {
        return this.field;
    }
    
    public void showField() {
        this.field.show();
        System.out.println();
    }
    
    public boolean setFieldCell(char letter, char number, char player) {
        // Convert from letters to index
        int line = letter - 'A';
        int column = number - '1';
        
        // Set new cell value
        return this.field.setCell(line, column, player);
    }
    
    public abstract void playTurn(char player);
    
    public boolean isGameEnd() {
        char playerWinner = Field.EMPTY;
        
        char symbolLeftCorner = this.field.getCell(0, 0);
        char symbolRightCorner = this.field.getCell(0, this.field.getSize() - 1);
        char symbolLine;
        char symbolColumn;
        
        int traceLeftCorner = 0;
        int traceRightCorner = 0;
        int traceLine = 0;
        int traceColumn = 0;
        
        int emptyCells = 0;
        
        for (int i = 0; i < this.field.getSize(); i++) {
            symbolLine = this.field.getCell(i, 0);
            symbolColumn = this.field.getCell(0, i);
            
            traceLeftCorner += this.field.getCell(i, i);
            traceRightCorner += this.field.getCell(i, this.field.getSize() - i - 1);
            traceLine = 0;
            traceColumn = 0;
            
            for (int j = 0; j < this.field.getSize(); j++) {
                if (this.field.getCell(j, i) == Field.EMPTY) {
                    emptyCells++;
                }
                
                traceLine += this.field.getCell(i, j);
                traceColumn += this.field.getCell(j, i);
            }
            
            // Check the line
            if (symbolLine != Field.EMPTY && traceLine / this.field.getSize() == symbolLine) {
                playerWinner = symbolLine;
                break;
            }
            
            // Check the column
            if (symbolColumn != Field.EMPTY && traceColumn / this.field.getSize() == symbolColumn) {
                playerWinner = symbolColumn;
                break;
            }
        }
        
        // Check the left diagonal
        if (symbolLeftCorner != Field.EMPTY && traceLeftCorner / this.field.getSize() == symbolLeftCorner) {
            playerWinner = symbolLeftCorner;
        }
        
        // Check the right diagonal
        if (symbolRightCorner != Field.EMPTY && traceRightCorner / this.field.getSize() == symbolRightCorner) {
            playerWinner = symbolRightCorner;
        }
        
        // Check for the winners or draw
        if (playerWinner != Field.EMPTY) {
            this.showField();
            System.out.println(playerWinner + "s are winners!");
            
            return true;
        } else if (emptyCells == 0) {
            this.showField();
            System.out.println("Draw!");
            
            return true;
        }
        
        return false;
    }
    
    public void start() {
        char currentPlayer = Field.X;
        
        while (!this.isGameEnd()) {
            this.showField();
            this.playTurn(currentPlayer);
            
            // Change player
            currentPlayer = currentPlayer == Field.X ? Field.O : Field.X;
        }
    }
    
}
