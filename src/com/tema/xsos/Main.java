
package com.tema.xsos;


import java.util.Scanner;


public class Main {
    
    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        int fieldSize;
        int gameType;
        
        Game game = null;
        
        System.out.println("Welcome to XsOs game!");
        System.out.println();
        
        // Ask field size
        while (true) {
            System.out.print("Please, enter field size (from " + Field.MIN_FIELD_SIZE + " to " + Field.MAX_FIELD_SIZE + ", for exit type 0): ");
            
            try {
                fieldSize = input.nextInt();
            } catch (Exception e) {
                continue;
            }
            
            if (fieldSize == 0) {
                exit();
                break;
            } else if (fieldSize < Field.MIN_FIELD_SIZE || fieldSize > Field.MAX_FIELD_SIZE) {
                continue;
            }
            
            System.out.println();
            
            break;
        }
        
        // Ask game type
        System.out.println("Please, choose game type:");
        System.out.println("1 - Local game");
        System.out.println("2 - Game with computer AI");
        System.out.println("3 - Network game");
        
        while (true) {
            System.out.print("Your choise (for exit type 0): ");
            
            try {
                gameType = input.nextInt();
            } catch (Exception e) {
                continue;
            }
            
            switch (gameType) {
                case 0:
                    exit();
                    break;
                case 1:
                    game = new GameLocal(fieldSize);
                    break;
                case 2:
                    game = new GameComputer(fieldSize);
                    break;
                case 3:
                    game = new GameNetwork(fieldSize);
                    break;
                default:
                    continue;
            }
            
            System.out.println();
            
            break;
        }
        
        // Start game
        game.start();
    }
    
    public static void exit() {
        System.out.println("Good bye!");
        System.exit(0);
    }
    
}
