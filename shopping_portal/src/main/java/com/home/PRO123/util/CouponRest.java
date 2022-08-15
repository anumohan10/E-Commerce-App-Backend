package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.Coupon;
import com.home.PRO123.factory.CouponFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/coupon")
public class CouponRest {
  /**
   * Returns Coupon details.
   * @return the Coupon details
   */
  @GET()
  @Produces(MediaType.APPLICATION_JSON)
  public final Coupon[] listCoupon() {
    final Coupon[] coupon = CouponFactory.showMenu();
    return coupon;
  }
  /**
   * Returns Coupon details.
   * @param cpnId to initialize coupon id.
   * @param cpnCode to initialize coupon code.
   * @param cstId to initialize customer id.
   * @param ordrId to initialize order id.
   * @return updated coupon.
   */
  @POST()
  @Path("/listcoupon/{couponId}/{couponCode}/{custId}/{orderId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String listCoupon(@PathParam("couponId") final int cpnId, @PathParam("couponCode") final String cpnCode,
                                  @PathParam("custId") final int cstId, @PathParam("orderId") final int ordrId) {
    CouponFactory.updatedCoupon(cpnId, cpnCode, cstId, ordrId);
    return "Coupon Added Successfully!!";
  }
  /**
   * @return the connection object.
   * call the data base connection.
   * @param cpnCode to initialize coupon code.
   * @param cpnId to initialize coupon id.
   */
  @PUT()
  @Path("/updateCpncd/{couponCode}/{couponId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final String updateCpncd(@PathParam("couponCode") final String cpnCode, @PathParam("couponId") final int cpnId) {
    CouponFactory.couponcodeUpdate(cpnCode, cpnId);
    return "Coupon Code updated successfully!";
  }
}
