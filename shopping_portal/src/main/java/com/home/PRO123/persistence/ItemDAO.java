package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.home.PRO123.model.Item;

/**
 * ItemDAO class used to fetch data from data base.
 */
public interface ItemDAO {
    /**
     * @return the all the Item record.
     */
  @SqlQuery("Select * from Item")
    @Mapper(ItemMapper.class)
    List<Item> show();

    /**
     * @param itid to initialize item id.
     * @return the all the Item record.
     */
  @SqlQuery("Select * from Item where itemId = :itemId")
  @Mapper(ItemMapper.class)
  List<Item> show(@Bind("itemId") int itid);

    /**
     * @param itid to initialize item id.
     * @param itname to initialize item name.
     * @param ittype to initialize item type.
     * @param cuisne to initialize cuisine.
     * @param avail to initialize availability.
     * @param venid to initialize vendor id.
     * @param itcost to initialize item cost.
     */

  @SqlUpdate("insert into Item (itemId, itemName, itemType, cuisine, availability, vendorId, itemCost)"
        + " values (:itemId, :itemName, :itemType, :availability, :vendorId, :itemCost)")
    void insert(@Bind("itemId") int itid, @Bind("itemName") String itname, @Bind("itemType") String ittype,
     @Bind("availability") String avail, @Bind("vendorId") int venid, @Bind("itemCost") int itcost);

    /**
     * @param itname to initialize item name.
     * @param itid to initialize item id.
     */

  @SqlUpdate("update Item set itemName = :itemName where itemId = :itemId")
  void updateitnm(@Bind("itemName") String itname, @Bind("itemId") int itid);

    /**
     * @param avail to initialize availability.
     * @param itid to initialize item id.
     */

  @SqlUpdate("update Item set availability = :availability where itemId = :itemId")
  void updateAvail(@Bind("availability") String avail, @Bind("itemId") int itid);

    /**
     * @param itcost to initialize item cost.
     * @param itid to initialize item id.
     */

  @SqlUpdate("update Item set itemCost = :itemCost where itemID = :itemId")
  void updateitcst(@Bind("itemCost") int itcost, @Bind("itemId") int itid);

  /**
   * @param itid to initialize item id.
   */
  @SqlUpdate("delete from Item where itemId = :itid")
  void deleteitnm(@Bind("itid") int itid);

  /**
   * @param ittype to initialize item type.
   * @return the all the Item record.
   */
  @SqlQuery("Select * from Item where itemType = :itemType")
  @Mapper(ItemMapper.class)
  List<Item> chooseittyp(@Bind("itemType") String ittype);
  /**
   * @param cuisne to initialize item cuisine.
   * @return the all the Item record.
   */
  @SqlQuery("Select * from Item where cuisine = :cuisine")
  @Mapper(ItemMapper.class)
  List<Item> choosecusne(@Bind("cuisine") String cuisne);

  /**
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @return the all the Item record.
   */
  @SqlQuery("Select * from Item where itemType = :itemType and availability = :availability order by itemCost")
  @Mapper(ItemMapper.class)
  List<Item> filterit(@Bind("itemType") String ittype, @Bind("availability") String avail);
  /**
   * @param ittype to initialize item type.
   * @param avail to initialize availability.
   * @return the all the Item record.
   */
  @SqlQuery("Select * from Item where itemType = :itemType and availability = :availability order by itemCost desc")
  @Mapper(ItemMapper.class)
  List<Item> filteritdesc(@Bind("itemType") String ittype, @Bind("availability") String avail);

  /**
   * @param mincost to initialize min cost.
   * @param maxcost to initialize max cost.
   * @return the all the Item record.
   */
  @SqlQuery("Select * from Item where itemCost between :minCost and :maxCost order by itemCost asc")
  @Mapper(ItemMapper.class)
  List<Item> filteritrng(@Bind("minCost") int mincost, @Bind("maxCost") int maxcost);
}
