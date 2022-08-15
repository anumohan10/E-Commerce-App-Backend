package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.OrderLog;
import com.home.PRO123.factory.OrderLogFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/orderlog")
public class OrderLogRest {
  /**
   * Returns OrderLog details.
   * @return the OrderLog details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderLog[] listOrderLog() {
    final OrderLog[] orderlog = OrderLogFactory.showOrderLog();
    return orderlog;
  }
  /**
   * Returns Orderstatus details.
   * @param oid to pass custId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbyorderlogId/{oid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderLog[] listOrderLogbyOrderId(@PathParam("oid") final int oid) {
    final OrderLog[] orderlog = OrderLogFactory.showbyorderlogId(oid);
    return orderlog;
  }
  /**
   * Returns Orderstatus details.
   * @param cid to pass custId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbycustId/{cid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderLog[] listOrderLogbyCustId(@PathParam("cid") final int cid) {
    final OrderLog[] orderlog = OrderLogFactory.showbycustId(cid);
    return orderlog;
  }
  /**
   * Returns Orderstatus details.
   * @param vid to pass custId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbyvendorId/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderLog[] listOrderLogbyVendorId(@PathParam("vid") final int vid) {
    final OrderLog[] orderlog = OrderLogFactory.showbyvendorId(vid);
    return orderlog;
  }
  /**
   * Returns Orderstatus details.
   * @param cid to pass custId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbycustId/recent/{cid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderLog[] listOrderLogbyCustIdRecent(@PathParam("cid") final int cid) {
    final OrderLog[] orderlog = OrderLogFactory.showbycustIdRecent(cid);
    return orderlog;
  }
  /**
   * Returns Orderstatus details.
   * @param vid to pass custId.
   * @return the Orderstatus details
   */
  @GET()
  @Path("/showbyvendorId/recent/{vid}")
  @Produces(MediaType.APPLICATION_JSON)
  public final OrderLog[] listOrderLogbyVendorIdRecent(@PathParam("vid") final int vid) {
    final OrderLog[] orderlog = OrderLogFactory.showbycustIdRecent(vid);
    return orderlog;
  }
}
