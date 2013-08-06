
package com.tema.xsos;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;


public class TestGame {
    
    private Game game;
    
    @Before
    public void setUp() throws Exception {
        this.game = new Game(Field.DEFAULT_FIELD_SIZE);
    }
    
    @Test
    public void testGame() {
        assertEquals(Field.DEFAULT_FIELD_SIZE, game.getField().getSize());
    }
    
    @Test
    public void testSetFieldCell() {
        game.getField().clear();
        
        assertTrue(game.setFieldCell('B', '2', Field.X));
        assertFalse(game.setFieldCell('Z', 'Z', Field.X));
    }
    
    @Test
    public void testIsGameEnd() {
        Field field = game.getField();
        
        // Line
        field.clear();
        
        for (int i = 0; i < field.getSize(); i++) {
            field.setCell(1, i, Field.X);
        }
        
        assertTrue(game.isGameEnd());
        
        // Column
        field.clear();
        
        for (int i = 0; i < field.getSize(); i++) {
            field.setCell(i, 1, Field.X);
        }
        
        assertTrue(game.isGameEnd());
        
        // Left diagonal
        field.clear();
        
        for (int i = 0; i < field.getSize(); i++) {
            field.setCell(i, i, Field.X);
        }
        
        assertTrue(game.isGameEnd());
        
        // Right diagonal
        field.clear();
        
        for (int i = 0; i < field.getSize(); i++) {
            field.setCell(field.getSize() - i - 1, i, Field.X);
        }
        
        assertTrue(game.isGameEnd());
        
        // Draw
        field.clear();
        
        field.setCell(0, 0, Field.O);
        field.setCell(0, 1, Field.X);
        field.setCell(0, 2, Field.O);
        field.setCell(1, 0, Field.O);
        field.setCell(1, 1, Field.X);
        
        assertFalse(game.isGameEnd());
        
        field.setCell(1, 2, Field.X);
        field.setCell(2, 0, Field.X);
        field.setCell(2, 1, Field.O);
        field.setCell(2, 2, Field.X);
        
        assertTrue(game.isGameEnd());
    }
}
