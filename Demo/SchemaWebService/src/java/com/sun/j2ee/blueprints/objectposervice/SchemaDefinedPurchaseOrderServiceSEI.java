/* Copyright 2004 Sun Microsystems, Inc.  All rights reserved.  You may not modify, use, reproduce, or distribute this software except in compliance with the terms of the License at: 
 http://developer.sun.com/berkeley_license.html
 $Id: SchemaDefinedPurchaseOrderServiceSEI.java,v 1.1 2005/03/22 21:46:12 smitha Exp $ */

package com.sun.j2ee.blueprints.objectposervice;

import java.rmi.*;

public interface SchemaDefinedPurchaseOrderServiceSEI extends Remote {
    
    public String submitPO(PurchaseOrder po) 
                                throws RemoteException;
}

