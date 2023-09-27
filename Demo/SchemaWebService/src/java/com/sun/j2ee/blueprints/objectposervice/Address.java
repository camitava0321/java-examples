/* Copyright 2004 Sun Microsystems, Inc.  All rights reserved.  You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: 
 http://developer.sun.com/berkeley_license.html
 $Id: Address.java,v 1.4 2004/06/16 01:02:23 inder Exp $ */

package com.sun.j2ee.blueprints.objectposervice;

public class Address {

  private String street;
  private String city;
  private String state;
  private String postalCode;

  // Constructor

  public Address() {}

  public Address(String street, String city,
                 String state, String postalCode) {
    this.street = street;
    this.city = city;
    this.state = state;
    this.postalCode = postalCode;
    return;
  }

  // getter methods

  public String getStreet() {
    return street;
  }

  public String getCity() {
    return city;
  }

  public String getState() {
    return state;
  }

  public String getPostalCode() {
    return postalCode;
  }

  // setter methods

  public void setStreet(String street) {
    this.street = street;
    return;
  }

  public void setCity(String city) {
    this.city = city;
    return;
  }

  public void setState(String state) {
    this.state = state;
    return;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
    return;
  }
}



