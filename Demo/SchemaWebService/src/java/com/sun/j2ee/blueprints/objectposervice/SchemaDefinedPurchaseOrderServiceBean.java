/* Copyright 2004 Sun Microsystems, Inc.  All rights reserved.  You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: 
 http://developer.sun.com/berkeley_license.html
 $Id: SchemaDefinedPurchaseOrderServiceBean.java,v 1.1 2005/03/22 21:46:12 smitha Exp $ */

package com.sun.j2ee.blueprints.objectposervice;

import java.rmi.*;
import java.io.*;

import javax.ejb.*;
import javax.naming.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import org.w3c.dom.*;
import org.xml.sax.*;


/**
 * A simple endpoint that receives  PO objects
 * and returns the po ID
 */
public class SchemaDefinedPurchaseOrderServiceBean implements SessionBean {

    private SessionContext sc;
 
    public SchemaDefinedPurchaseOrderServiceBean (){}  

    public String submitPO(PurchaseOrder po) throws RemoteException {

        //extract the PO ID and return to the client
      
        return po.getPoId();
    }
    
   
    //life cycle methods
    public void ejbCreate() throws CreateException {} 
    
    public void setSessionContext(SessionContext sc) {
        this.sc = sc;
    }
    
    public void ejbRemove() throws RemoteException {}    

    public void ejbActivate() {}

    public void ejbPassivate() {}
   
}
