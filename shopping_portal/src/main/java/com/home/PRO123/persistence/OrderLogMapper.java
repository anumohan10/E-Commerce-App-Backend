package com.home.PRO123.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.PRO123.model.OrderLog;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrderLogMapper class used to fetch OrderLog data from database.
 */
public class OrderLogMapper implements ResultSetMapper<OrderLog> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final OrderLog map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return OrderLog
       */
    return new OrderLog(rs.getInt("orderId"), rs.getInt("custId"), rs.getInt("itemId"), rs.getString("itemName"), rs.getInt("vendorId"),
    rs.getInt("totalCost"), rs.getString("orderDate"));
  }
}
