package com.amc.gof.structural.flyweight.examples.tea;
/**
 * @author Amitava Chakraborty
 * May 1, 2002 
*/

public class TeaFlavor extends TeaOrder {  
    String teaFlavor; 
   
    TeaFlavor(String teaFlavor) {
        this.teaFlavor = teaFlavor;
    }
   
    public String getFlavor() {
        return this.teaFlavor;
    }
   
    public void serveTea(TeaOrderContext teaOrderContext) {
        System.out.println("Serving tea flavor " + 
                             teaFlavor + 
                           " to table number " + 
                             teaOrderContext.getTable());
    }
}
