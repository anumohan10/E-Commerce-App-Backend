package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
//import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.Cart;
import com.home.PRO123.factory.CartFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/cart")
public class CartRest {
  /**
   * Returns Cart details.
   * @return the Cart details
   */
  @GET()
  @Produces(MediaType.APPLICATION_JSON)
  public final Cart[] listCart() {
    final Cart[] cart = CartFactory.showCart();
    return cart;
  }
  /**
   * Returns Cart details.
   * @param cartId to initialize Cart id.
   * @param custId to initialize cust id.
   * @param itemId to initialize item id.
   * @param vendorId to initialize vendor id.
   * @param quantity to initialize quantity.
   * @param price to initialize price.
   * @return updated Cart.
   */
  @POST()
  @Path("/update/{cartId}/{custId}/{itemId}/{vendorId}/{quantity}/{price}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String listCart(@PathParam("cartId") final int cartId, @PathParam("custId") final int custId,
                                  @PathParam("itemId") final int itemId, @PathParam("vendorId") final int vendorId,
                                  @PathParam("quantity") final int quantity, @PathParam("price") final int price) {
    CartFactory.update(cartId, custId, itemId, vendorId, quantity, price);
    return "Added Successfully!!";
  }
}
