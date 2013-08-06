
package com.tema.xsos;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;


public class TestField {
    
    private Field field;
    
    @Before
    public void setUp() throws Exception {
        this.field = new Field();
    }
    
    @Test
    public void testField() {
        Field field;
        
        field = new Field(Field.MIN_FIELD_SIZE - 1);
        assertEquals(Field.DEFAULT_FIELD_SIZE, field.getSize());
        
        field = new Field(Field.MAX_FIELD_SIZE + 1);
        assertEquals(Field.DEFAULT_FIELD_SIZE, field.getSize());
        
        field = new Field();
        assertEquals(Field.DEFAULT_FIELD_SIZE, field.getSize());
        
        int avgSize = (Field.MIN_FIELD_SIZE + Field.MAX_FIELD_SIZE) / 2;
        field = new Field(avgSize);
        assertEquals(avgSize, field.getSize());
    }
    
    @Test
    public void testClear() {
        field.setCell(1, 1, Field.X);
        field.setCell(0, 2, Field.O);
        field.setCell(2, 0, Field.X);
        
        field.clear();
        
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                if (!field.isEmptyCell(i, j)) {
                    fail();
                }
            }
        }
    }
    
    @Test
    public void testCell() {
        field.clear();
        
        assertFalse(field.setCell(1, 1, 'Y'));
        
        assertFalse(field.setCell(Field.MAX_FIELD_SIZE + 1, Field.MIN_FIELD_SIZE - 1, Field.X));
        
        assertTrue(field.setCell(1, 1, Field.X));
        assertEquals(Field.X, field.getCell(1, 1));
        
        assertFalse(field.setCell(1, 1, Field.O));
        assertEquals(Field.X, field.getCell(1, 1));
    }
    
    @Test
    public void testIsEmptyCell() {
        field.clear();
        
        assertTrue(field.isEmptyCell(0, 0));
        
        assertTrue(field.setCell(1, 1, Field.X));
        assertFalse(field.isEmptyCell(1, 1));
    }
    
}
