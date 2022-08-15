package com.home.PRO123.util;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.factory.OrderLogFactory;
import com.home.PRO123.factory.OrderstatusFactory;
import com.home.PRO123.factory.ItemFactory;
import com.home.PRO123.factory.WalletFactory;
import com.home.PRO123.model.Wallet;
import com.home.PRO123.model.OrderLog;
import com.home.PRO123.model.Orderstatus;
import com.home.PRO123.model.Item;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/placeorder")
public class PlaceOrderRest {
  /**
   * Returns Orderstatus details.
   * @param custId to pass custId.
   * @param itemId to pass itemId.
   * @param vendorId to pass vendorId.
   * @param quantity to pass quantity.
   */
  @POST
  @Path("/placeorder/{custId}/{itemId}/{vendorId}/{quantity}")
  @Produces(MediaType.APPLICATION_JSON)
  public final void placeOrder(@PathParam("custId") final int custId, @PathParam("itemId") final int itemId,
      @PathParam("vendorId") final int vendorId, @PathParam("quantity") final int quantity) {
    //Link to execute http://localhost:8080/MLP290/api/placeorder/placeorder/1/1/1/1 -X POST
    OrderLog[] order = OrderLogFactory.showOrderLog();
    int orderId = 0;
    for (OrderLog o : order) {
      orderId = o.getorderId();
    }
    orderId++;
    Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    int orderstatusId = 0;
    for (Orderstatus o : orderstatus) {
      orderstatusId = o.getid();
    }
    orderstatusId++;
    Item[] Item = ItemFactory.showItem();
    String itemName = " ";
    int totalCost = 0;
    for (Item m : Item) {
      if (m.getitemId() == itemId) {
        itemName = m.getitemName();
        totalCost = m.getitemCost();
      }
    }
    totalCost = totalCost * quantity;
    Wallet[] wallet = WalletFactory.showWallet();
    int walletBalance = 0;
    for (Wallet w : wallet) {
      if (w.getcustId() == custId) {
        walletBalance = w.getbalance();
        break;
      }
    }
    if (walletBalance > totalCost) {
      OrderLogFactory.placeOrder(orderId, custId, itemId, itemName, vendorId, totalCost);
      OrderstatusFactory.placeOrder(orderstatusId, orderId, vendorId, custId, quantity);
      WalletFactory.order(custId, totalCost);
    } else {
      System.out.println("Insufficient Wallet Balance!!!");
    }
  }
}
