package com.home.PRO123.factory;

import com.home.PRO123.persistence.ItemDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.Item;

public class ItemFactory {
  /**
   *  Protected constructor.
   */
  protected ItemFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static ItemDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(ItemDAO.class);
  }

  /**
   * @param itid to initialize item id.
   * @param itname to initialize item name.
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @param venid to initialize vendor id.
   * @param itcost to initialize item cost.
   * @return to return item details
   */

  public static String updatedItem(final int itid, final String itname, final String ittype,
      final String avail, final int venid, final int itcost) {
    dao().insert(itid, itname, ittype, avail, venid, itcost);
    return "Item Successfully updated.";
  }

  /**
   * @param itname to initialize item name.
   * @param itid to initialize item id.
   * @return to return updated details.
   */

  public static String itemnameUpdate(final String itname, final int itid) {
    dao().updateitnm(itname, itid);
    return "item Name updated successfully!";
  }

  /**
   * @param avail to initialize availability.
   * @param itid to initialize item id.
   * @return to return upadted details.
   */

  public static String availabilityUpdate(final String avail, final int itid) {
    dao().updateAvail(avail, itid);
    return "Availabilty updated successfully!";
  }

  /**
   * @param itcost to initialize item cost.
   * @param itid to initialize item id.
   * @return to return updated details.
   */

  public static String itemcostUpdate(final int itcost, final int itid) {
    dao().updateitcst(itcost, itid);
    return "item cost updated successfully!";
  }

  /**
   * @return the connection object.
   * Call the data base connection.
   * @param itid  to initialize item id.
   */
  public static String itnmDelete(final int itid) {
    dao().deleteitnm(itid);
    return "item item has been Deleted";
  }

  /**
   * @param ittype to initialize item type.
   * @return to return updated details.
   */
  public static Item[] showbyitemType(final String ittype) {
    List<Item> Item = dao().chooseittyp(ittype);
    return Item.toArray(new Item[Item.size()]);
  }

  /**
   * Call the data base connection.
   * @return the array of Item object.
   */
  public static Item[] showItem() {
    List<Item> Item = dao().show();
    return Item.toArray(new Item[Item.size()]);
  }
   /**
   * Call the data base connection.
   * @param itid to initialize item id.
   * @return the array of Item object.
   */
  public static Item[] showbyitemId(final int itid) {
    List<Item> Item = dao().show(itid);
    return Item.toArray(new Item[Item.size()]);
  }
  /**
   * Call the data base connection.
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @return the array of Item object.
   */
  public static Item[] showbyfilter(final String ittype, final String avail) {
    List<Item> Item = dao().filterit(ittype, avail);
    return Item.toArray(new Item[Item.size()]);
  }
  /**
   * Call the data base connection.
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @return the array of Item object.
   */
  public static Item[] showbyfilterdsc(final String ittype, final String avail) {
    List<Item> Item = dao().filteritdesc(ittype, avail);
    return Item.toArray(new Item[Item.size()]);
  }

  /**
   * Call the data base connection.
   * @param mincost to initialize min cost.
   * @param maxcost to initialize max cost.
   * @return the array of Item object.
   */
  public static Item[] showbycostrange(final int mincost, final int maxcost) {
    List<Item> Item = dao().filteritrng(mincost, maxcost);
    return Item.toArray(new Item[Item.size()]);
  }
}
