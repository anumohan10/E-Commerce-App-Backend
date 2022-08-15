package com.home.PRO123.util;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.factory.OrderLogFactory;
import com.home.PRO123.factory.OrderstatusFactory;
import com.home.PRO123.factory.WalletFactory;
import com.home.PRO123.model.OrderLog;
import com.home.PRO123.model.Orderstatus;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/updateorder")
public class UpdateOrderRest {
  /**
   * @param oid to pass orderstatusid.
   * @param custId to pass custId.
   */
  @PUT
  @Path("/cancel/{oid}/{custId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final void cancel(@PathParam("oid") final int oid, @PathParam("custId") final int custId) {
    //Link to execute http://localhost:8080/MLP290/api/updateorder/cancel/1/1 -X PUT
    CliMain c = new CliMain();
    c.cancelOrder(oid, custId);
  }
  /**
   * @param oid for order id.
   * @param e for eta.
   * @param c for choice.
   * @return to return the result.
   */
  @PUT
  @Path("/update/{id}/{eta}/{choice}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String update(@PathParam("id") final int oid, @PathParam("eta") final int e, @PathParam("choice") final int c) {
    //Link to execute http://localhost:8080/MLP290/api/updateorder/update/1/5/2 -X PUT
    Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    String status = "";
    for (Orderstatus o : orderstatus) {
      status = o.getorderstatus();
    }
    if (!"cancelled".equals(status)) {
      String eta = " ";
      switch (c) {
        case 1:
          eta = Integer.toString(e) + " min";
          System.out.println(OrderstatusFactory.updateOrder(oid, eta, "Order Accepted"));
          return "Successfully updated";
        case 2:
          eta = Integer.toString(e) + " min";
          System.out.println(OrderstatusFactory.updateOrder(oid, eta, "Being Prepared"));
          return "Successfully updated";
        case 3:
          eta = Integer.toString(e) + " min";
          System.out.println(OrderstatusFactory.updateOrder(oid, eta, "Out for Delivery!"));
          return "Successfully updated";
        case 4:
          int custid = 0;
          int refund = 0;
          OrderLog[] order = OrderLogFactory.showOrderLog();
          for (OrderLog m : order) {
            if (oid == m.getorderId()) {
              custid = m.getcustId();
              refund = m.gettotalCost();
            }
          }
          System.out.println(OrderstatusFactory.updateOrder(oid, "    ", "Order Rejected"));
          System.out.println(WalletFactory.refund(custid, refund));
          return "Successfully updated";
        default:
          return "Wrong choice!";
      }
    } else {
      return "Order cancelled by the user.";
    }
  }
}
