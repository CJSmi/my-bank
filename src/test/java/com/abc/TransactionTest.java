package com.abc;

import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Date;

public class TransactionTest {
	
    @Test
    public void transactionCreation() {
        Transaction t = new Transaction(1);
        assertTrue(t instanceof Transaction && 
        		t.getAmount().compareTo(BigDecimal.ONE) == 0 &&
        		t.getDate() instanceof Date);
    }
    
    @Test
    public void ammountRounding() {
    	Transaction t = new Transaction("9.999999");
    	assertTrue(t.getAmount().compareTo(new BigDecimal("9.99")) == 0);
    }
    
    @Test
    public void ammountExactRounding() {
    	Transaction t = new Transaction("8.888888888");
    	assertTrue(t.getExactAmount().compareTo(new BigDecimal("8.8888")) == 0);
    }
    
    @Test
    public void createString() {
    	Transaction t = new Transaction("1.234567");
    	String expectedStart = "Transaction of $1.23 on ";
    	assertTrue(t.toString().startsWith(expectedStart));
    }
    
    @Test
    public void createStringExact() {
    	Transaction t = new Transaction("1.234567");
    	String expectedStart = "Transaction of $1.2345 on ";
    	assertTrue(t.toStringExact().startsWith(expectedStart));
    }
    
    @Test
    public void currencyString() {
    	String expected = "$9,870.65";
    	assertEquals(Transaction.toCurrecy(new BigDecimal("9870.654321")), expected);
    }
}
