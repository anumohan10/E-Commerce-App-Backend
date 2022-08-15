package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.home.PRO123.model.Orderstatus;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * OrderstatusDAO class used to fetch data from data base.
 */
public interface OrderstatusDAO {
    /**
     * @return the all the Orderstatus record.
     */
  @SqlQuery("Select * from Orderstatus")
    @Mapper(OrderstatusMapper.class)
    List<Orderstatus> show();
    /**
     * @param id to pass id.
     * @return the all the Orderstatus record.
     */
  @SqlQuery("Select * from Orderstatus where id = :id")
    @Mapper(OrderstatusMapper.class)
    List<Orderstatus> showbyid(@Bind("id") int id);
    /**
     * @param custid to pass id.
     * @return the all the Orderstatus record.
     */
  @SqlQuery("Select * from Orderstatus where custid = :custid")
    @Mapper(OrderstatusMapper.class)
    List<Orderstatus> showbycustid(@Bind("custid") int custid);
    /**
     * @param vendorid to pass id.
     * @return the all the Orderstatus record.
     */
  @SqlQuery("Select * from Orderstatus where itemVendorID = :vendorid")
    @Mapper(OrderstatusMapper.class)
    List<Orderstatus> showbyvendorid(@Bind("vendorid") int vendorid);
    /**
     * @param custid to pass id.
     * @return the all the Orderstatus record.
     */
  @SqlQuery("Select * from Orderstatus where custid = :custid order by orderId DESC")
    @Mapper(OrderstatusMapper.class)
    List<Orderstatus> showbycustidRecent(@Bind("custid") int custid);
    /**
     * @param vendorid to pass id.
     * @return the all the Orderstatus record.
     */
  @SqlQuery("Select * from Orderstatus where itemVendorID = :vendorid order by orderId DESC")
    @Mapper(OrderstatusMapper.class)
    List<Orderstatus> showbyvendoridRecent(@Bind("vendorid") int vendorid);
  /**
   * update the table with new order.
   * @param id to initialize Orderstatus ID.
   * @param orderId to initialize order ID.
   * @param vendorId to initialize itemVentorID.
   * @param custId to initialize custId.
   * @param quantity to initialize quantity.
   */
  @SqlUpdate("insert into Orderstatus (id, orderId, ETA, orderstatus, itemVendorID, custId, quantity)"
      + " values (:id, :orderId, '30 mins', 'Order Placed', :vendorId, :custId, :quantity)")
    void insert(@Bind("id") int id, @Bind("orderId") int orderId, @Bind("vendorId") int vendorId, @Bind("custId") int custId,
      @Bind("quantity") int quantity);
  /**
   * order cancellation.
   * @param orderId to initialize order ID.
   */
  @SqlUpdate("update Orderstatus set ETA = '      ' , orderstatus = 'cancelled' where orderId = :orderId")
    void cancel(@Bind("orderId") int orderId);
  /**
   * order cancellation.
   * @param orderId to initialize order ID.
   * @param eta to store eta.
   * @param orderstatus to store order id.
   */
  @SqlUpdate("update Orderstatus set ETA = :eta , orderstatus = :orderstatus where orderId = :orderId")
    void update(@Bind("orderId") int orderId, @Bind("eta") String eta, @Bind("orderstatus") String orderstatus);
}
