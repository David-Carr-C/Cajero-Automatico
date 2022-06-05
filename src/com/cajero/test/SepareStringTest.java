package com.cajero.test;

import com.cajero.model.SepareString;
import junit.framework.TestCase;

import java.util.List;

public class SepareStringTest extends TestCase {
    private SepareString ss;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ss = new SepareString("12321321111$ 1234$ David$ Credito$ 2000$");
    }

    public void testSepareOnce() {
        List<String> arr = ss.sub$tring();
        assertEquals("12321321111",arr.get(0));
    }

    public void testSepareTwoTimes() {
        List<String> arr = ss.sub$tring();
        assertEquals("12321321111",arr.get(0));
        assertEquals("1234",arr.get(1));
    }

    public void testSepareAll() {
        List<String> arr = ss.sub$tring();
        assertEquals("12321321111",arr.get(0));
        assertEquals("1234",arr.get(1));
        assertEquals("David",arr.get(2));
        assertEquals("Credito",arr.get(3));
        assertEquals("2000",arr.get(4));
    }
}
