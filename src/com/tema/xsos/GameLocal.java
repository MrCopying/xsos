
package com.tema.xsos;


public class GameLocal extends Game {
    
    public GameLocal(int fieldSize) {
        super(fieldSize);
    }
    
    @Override
    public void playTurn(char player) {
        char letter;
        char number;
        
        String cellAddress;
        
        // Ask cell address
        while (true) {
            System.out.print(player + "'s turn. ");
            System.out.print("Please, enter cell address (B2, for example) or type 'exit': ");
            
            try {
                cellAddress = Main.input.next();
            } catch (Exception e) {
                continue;
            }
            
            if (cellAddress.equals("exit")) {
                Main.exit();
                break;
            } else if (cellAddress.length() == 2) {
                letter = Character.toUpperCase(cellAddress.charAt(0));
                number = Character.toUpperCase(cellAddress.charAt(1));
            } else {
                continue;
            }
            
            if (!this.setFieldCell(letter, number, player)) {
                continue;
            }
            
            System.out.println();
            
            return;
        }
    }
    
}
