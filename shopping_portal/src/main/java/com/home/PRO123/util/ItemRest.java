package com.home.PRO123.util;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.item;
import com.home.PRO123.factory.itemFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/item")
public class ItemRest {
  /**
   * Returns item details.
   * @return the item details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listitem() {
    final item[] item = itemFactory.showitem();
    return item;
  }
  /**
   * Returns item details.
   * @param itid to initialize item id.
   * @return the item details
   */
  @GET()
  @Path("/showbyitemId/{itemId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listitem(@PathParam("itemId") final int itid) {
    final item[] item = itemFactory.showbyitemId(itid);
    return item;
  }
  /**
   * Returns item details.
   * @param ittype to initialize item type.
   * @return the item details
   */
  @GET()
  @Path("/showbyitemtype/{itemType}")
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listitem(@PathParam("itemType") final String ittype) {
    final item[] item = itemFactory.showbyitemType(ittype);
    return item;
  }
  /**
   * Returns item details.
   * @param cuisne to initialize item cuisine.
   * @return the item details
   */
  @GET()
  @Path("/showbycuisine/{cuisine}")
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listitemcuisine(@PathParam("cuisine") final String cuisne) {
    final item[] item = itemFactory.showbyitcuisine(cuisne);
    return item;
  }
  /**
   * Returns item details.
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @return the item details
   */
  @GET()
  @Path("/filteritem/{itemType}/{availability}")
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listitem(@PathParam("itemType") final String ittype, @PathParam("availability") final String avail) {
    final item[] item = itemFactory.showbyfilter(ittype, avail);
    return item;
  }
  /**
   * Returns item details.
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @return the item details
   */
  @GET()
  @Path("/filteritemdsc/{itemType}/{availability}")
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listitemdsc(@PathParam("itemType") final String ittype, @PathParam("availability") final String avail) {
    final item[] item = itemFactory.showbyfilterdsc(ittype, avail);
    return item;
  }
  /**
   * Returns item details.
   * @param maxcost to initialize min cost.
   * @param mincost to initialize max cost.
   * @return the item details
   */
  @GET()
  @Path("/showbypricerange/{minCost}/{maxCost}")
  @Produces(MediaType.APPLICATION_JSON)
  public final item[] listCostrange(@PathParam("minCost") final int mincost, @PathParam("maxCost") final int maxcost) {
    final item[] item = itemFactory.showbycostrange(mincost, maxcost);
    return item;
  }

  /**
     * @param itid to initialize item id.
     * @param itname to initialize item name.
     * @param ittype to initialize item type.
     * @param avail to initialize availability.
     * @param venid to initialize vendor id.
     * @param itcost to initialize item cost.
     * @return upadted item.
     */
  @POST()
    @Path("/insertitem/{itemId}/{itemName}/{itemType}/{cuisine}/{availability}/{vendorId}/{itemCost}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String listitem(@PathParam("itemId") final int itid, @PathParam("itemName") final String itname,
        @PathParam("itemType") final String ittype, @PathParam("availability") final String avail,
        @PathParam("vendorId") final int venid, @PathParam("itemCost") final int itcost) {
    itemFactory.updateditem(itid, itname, ittype, avail, venid, itcost);
    return "item Updated";
  }
  /**
     * @param itname to initialize item name.
     * @param itid to initialize item id.
     * @return item name.
     */
  @PUT
    @Path("/updatename/{itemName}/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String updateitName(@PathParam("itemName") final String itname, @PathParam("itemId") final int itid) {
    itemFactory.itemnameUpdate(itname, itid);
    return "item name updated";
  }
  /**
   * @param avail to initialize availability.
   * @param itid to initialize item id.
   * @return to return upadted details.
   */
  @PUT
    @Path("/updateavail/{availability}/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String updateitavail(@PathParam("availability") final String avail, @PathParam("itemId") final int itid) {
    itemFactory.availabilityUpdate(avail, itid);
    return "item availability updated";
  }
  /**
   * @param itcost to initialize item cost.
   * @param itid to initialize item id.
   * @return to return updated details.
   */
  @PUT
    @Path("/updatecost/{itemCost}/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String updateitcost(@PathParam("itemCost") final int itcost, @PathParam("itemId") final int itid) {
    itemFactory.itemcostUpdate(itcost, itid);
    return "item cost updated";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param itid  to initialize item id.
   */
  @DELETE
    @Path("/deleteit/{itemId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String deleteitem(@PathParam("itemId") final int itid) {
    itemFactory.itnmDelete(itid);
    return "item item updated";
    //curl -vvv http://localhost:8080/MLP290/api/item/deleteit/104 -X DELETE
  }

}
