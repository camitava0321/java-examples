/* Copyright 2004 Sun Microsystems, Inc.  All rights reserved.  You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: 
 http://developer.sun.com/berkeley_license.html
 $Id: LineItem.java,v 1.4 2004/06/16 01:02:23 inder Exp $ */

package com.sun.j2ee.blueprints.objectposervice;

public class LineItem {

  private String itemId;
  private int    quantity;
  private float  price;


  public LineItem() {} 

  public LineItem(String itemId, 
                  int quantity, float price) {
    this.itemId = itemId;  
    this.quantity = quantity;
    this.price = price;
  }

  public String getItemId() {
    return this.itemId;
  } 

  public int getQuantity() {
    return this.quantity;
  }

  public float getPrice() {
    return this.price;
  }

  public void setItemId(String itemId) {
    this.itemId = itemId;
    return;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
    return;
  }

  public void setPrice(float price) {
    this.price = price;
    return;
  } 
}