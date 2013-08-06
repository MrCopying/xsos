
package com.tema.xsos;


public class Field {
    
    // Should be greater then 0
    public static final int  MIN_FIELD_SIZE     = 3;
    // Should be lesser then or equals to 9
    public static final int  MAX_FIELD_SIZE     = 9;
    // Should be between or equals to minimum and maximum
    public static final int  DEFAULT_FIELD_SIZE = 3;
    
    public static final char EMPTY              = ' ';
    public static final char X                  = 'X';
    public static final char O                  = 'O';
    
    private final int        size;
    private final char[][]   field;
    
    // Constructor
    public Field() {
        this(DEFAULT_FIELD_SIZE);
    }
    
    public Field(int size) {
        if (size < MIN_FIELD_SIZE || size > MAX_FIELD_SIZE) {
            size = DEFAULT_FIELD_SIZE;
        }
        
        this.size = size;
        this.field = new char[size][size];
        
        this.clear();
    }
    
    // Size
    public int getSize() {
        return this.size;
    }
    
    // Cell
    public char getCell(int line, int column) {
        return this.field[column][line];
    }
    
    public boolean setCell(int line, int column, char value) {
        if (line < 0 || line > this.getSize()) {
            return false;
        }
        
        if (column < 0 || column > this.getSize()) {
            return false;
        }
        
        if (!this.isEmptyCell(line, column)) {
            return false;
        }
        
        if (value != X && value != O) {
            return false;
        }
        
        this.field[column][line] = value;
        
        return true;
    }
    
    // Helpers
    public boolean isEmptyCell(int line, int column) {
        return this.getCell(line, column) == EMPTY;
    }
    
    public void clear() {
        for (int line = 0; line < this.getSize(); line++) {
            for (int column = 0; column < this.getSize(); column++) {
                this.field[column][line] = EMPTY;
            }
        }
    }
    
    public void show() {
        char letter = 'A';
        char number = '1';
        
        // Print numbers on top
        System.out.print(" ");
        
        for (int i = 0; i < this.getSize(); i++) {
            System.out.print(" " + number++ + " ");
        }
        
        System.out.println();
        
        // Print field
        for (int line = 0; line < this.getSize(); line++) {
            System.out.print(letter++);
            
            for (int column = 0; column < this.getSize(); column++) {
                System.out.print("[" + this.getCell(line, column) + "]");
            }
            
            System.out.println();
        }
    }
    
}
