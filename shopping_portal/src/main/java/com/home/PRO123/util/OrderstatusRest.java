package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.Orderstatus;
import com.home.PRO123.factory.OrderstatusFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orderstatus")
public class OrderstatusRest {
  /**
   * Returns Orderstatus details.
   * @return the Orderstatus details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Orderstatus[] listOrderstatus() {
    final Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    return orderstatus;
  }
  /**
   * Returns Orderstatus details.
   * @param oid to pass orderId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbyorderstatusId/{oid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orderstatus[] listOrderstatusbyOrderId(@PathParam("oid") final int oid) {
    final Orderstatus[] orderstatus = OrderstatusFactory.showbyOrderstatusId(oid);
    return orderstatus;
  }
  /**
   * Returns Orderstatus details.
   * @param cid to pass orderId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbycustId/{cid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orderstatus[] listOrderstatusbyCustd(@PathParam("cid") final int cid) {
    final Orderstatus[] orderstatus = OrderstatusFactory.showbycustId(cid);
    return orderstatus;
  }
  /**
   * Returns Orderstatus details.
   * @param vid to pass orderId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbyvendorId/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orderstatus[] listOrderstatusbyVendorId(@PathParam("vid") final int vid) {
    final Orderstatus[] orderstatus = OrderstatusFactory.showbyvendorId(vid);
    return orderstatus;
  }
  /**
   * Returns Orderstatus details.
   * @param cid to pass orderId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbycustId/recent/{cid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orderstatus[] listOrderstatusbycustIdRecent(@PathParam("cid") final int cid) {
    final Orderstatus[] orderstatus = OrderstatusFactory.showbycustIdRecent(cid);
    return orderstatus;
  }
  /**
   * Returns Orderstatus details.
   * @param vid to pass orderId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbyvendorId/recent/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Orderstatus[] listOrderstatusbyvendorIdRecent(@PathParam("vid") final int vid) {
    final Orderstatus[] orderstatus = OrderstatusFactory.showbyvendorIdRecent(vid);
    return orderstatus;
  }
}
