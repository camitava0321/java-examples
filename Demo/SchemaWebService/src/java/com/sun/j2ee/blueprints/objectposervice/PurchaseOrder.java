/* Copyright 2004 Sun Microsystems, Inc.  All rights reserved.  You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: 
 http://developer.sun.com/berkeley_license.html
 $Id: PurchaseOrder.java,v 1.4 2004/06/16 01:02:23 inder Exp $ */

package com.sun.j2ee.blueprints.objectposervice;

import java.util.*;

/**
 * This object is represents the purchase order
 * that is persisted after a user places an order.
 */
public class PurchaseOrder{

  private String poId;
  private Calendar createDate;
  private Address shipTo;
  private Address billTo;
  private LineItem[] items;


  // Constructor
  public PurchaseOrder() {}

  public PurchaseOrder(String poId, Calendar createDate,
                       Address shipTo, Address billTo,
                       LineItem[] items) {
    this.poId = poId;
    this.shipTo = shipTo;
    this.createDate = createDate;
    this.billTo = billTo; 
    this.items = items;
 
  }

  // getter methods
  public String getPoId() {
    return poId;
  }

  public Calendar getCreateDate() {
    return createDate;
  }

  public Address getShipTo() {
    return shipTo;
  }

  public Address getBillTo() {
    return billTo;
  }

  public LineItem[] getItems() {
    return items;
  }

  // setter methods
  public void setPoId(String poId) {
    this.poId = poId;
  }

  public void setCreateDate(Calendar createDate) {
    this.createDate = createDate;
  }

  public void setShipTo(Address shipTo) {
    this.shipTo = shipTo;
  }

  public void setBillTo(Address billTo) {
    this.billTo = billTo;
  }
 
  public void setItems(LineItem[] item) {
    this.items =  item;
  }  
}

