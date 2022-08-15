package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.home.PRO123.model.OrderLog;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * OrderLogDAO class used to fetch data from data base.
 */
public interface OrderLogDAO {
    /**
     * @return the all the OrderLog record.
     */
  @SqlQuery("Select * from OrderLog")
    @Mapper(OrderLogMapper.class)
    List<OrderLog> show();
    /**
     * @param orderId to pass orderId.
     * @return the all the OrderLog record.
     */
  @SqlQuery("Select * from OrderLog where orderId = :orderId")
    @Mapper(OrderLogMapper.class)
    List<OrderLog> showbyid(@Bind("orderId") int orderId);
    /**
     * @param custId to pass orderId.
     * @return the all the OrderLog record.
     */
  @SqlQuery("Select * from OrderLog where custId = :custId")
    @Mapper(OrderLogMapper.class)
    List<OrderLog> showbycustid(@Bind("custId") int custId);
    /**
     * @param vendorId to pass orderId.
     * @return the all the OrderLog record.
     */
  @SqlQuery("Select * from OrderLog where vendorId = :vendorId")
    @Mapper(OrderLogMapper.class)
    List<OrderLog> showbyvendorid(@Bind("vendorId") int vendorId);
    /**
     * @param custId to pass orderId.
     * @return the all the OrderLog record.
     */
  @SqlQuery("Select * from OrderLog where custId = :custId order by orderId DESC")
    @Mapper(OrderLogMapper.class)
    List<OrderLog> showbycustidRecent(@Bind("custId") int custId);
    /**
     * @param vendorId to pass orderId.
     * @return the all the OrderLog record.
     */
  @SqlQuery("Select * from OrderLog where vendorId = :vendorId order by orderId DESC")
    @Mapper(OrderLogMapper.class)
    List<OrderLog> showbyvendoridRecent(@Bind("vendorId") int vendorId);
    /**
     * update the table with new order.
     * @param orderId for storing order Id.
     * @param custId for storing Customer Id.
     * @param itemId for storing itemId.
     * @param itemName for storing item Name.
     * @param vendorId for storing vendorId.
     * @param totalCost for storing totalCost.
     */
  @SqlUpdate("insert into OrderLog (orderId, custId, itemId, itemName, vendorId, totalCost, orderDate)"
      + " values (:orderId, :custId, :itemId, :itemName, :vendorId, :totalCost, now())")
    void insert(@Bind("orderId") int orderId, @Bind("custId") int custId, @Bind("itemId") int itemId,
      @Bind("itemName") String itemName, @Bind("vendorId") int vendorId, @Bind("totalCost") int totalCost);
}
