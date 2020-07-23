/*
 * The MIT License
 *
 * Copyright 2020 Lucas Gabriel Silva.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package inglesfacil;

import java.util.Calendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Generate a random number
 * @author Lucas Gabriel Silva
 */
public class Random {
    
    private final long p = 2147483648L;
    private final long m = 843314861;
    private final long a = 453816693;
    
    private long xi = 0; //Essa é a semente
    
    /**
     *
     */
    public Random(){
        xi = Calendar.getInstance().getTimeInMillis();
        
        try {
            TimeUnit.MILLISECONDS.sleep(100L);
        } catch (InterruptedException ex) {
            Logger.getLogger(Random.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     *
     * @param value
     */
    public Random(long value){
        xi = value;
    }
    
    /**
     *
     * @return
     */
    public double getRand(){
        
        //xi = (a+m*xi) % p;
        xi = ((a%p)+((m%p)*(xi%p))%p) % p;
        
        double d = xi;
        
        return (d/p);
    }
    
    /**
     *
     * @param max
     * @return
     */
    public int getIntRand(int max){
       double d = (getRand() * max)+1;
       return (int)d;
    }
    
    /**
     *
     * @param value
     */
    public void setSemente(long value){
        xi = value;
    }
    
    /**
     *
     * @return
     */
    public long getSemente(){
        return xi;  
    }
}
