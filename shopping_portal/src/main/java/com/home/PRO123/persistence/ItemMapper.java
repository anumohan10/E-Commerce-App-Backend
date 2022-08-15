package com.home.PRO123.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.PRO123.model.Item;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * ItemMapper class used to fetch Item data from database.
 */
public class ItemMapper implements ResultSetMapper<Item> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Item map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Item
       */
    return new Item(rs.getInt("itemId"), rs.getString("itemName"), rs.getString("itemType"), 
    rs.getString("availability"), rs.getInt("vendorId"), rs.getInt("itemCost"));
  }
}
