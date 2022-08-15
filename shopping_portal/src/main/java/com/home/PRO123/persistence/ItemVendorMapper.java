package com.home.PRO123.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.PRO123.model.ItemVendor;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * ItemMapper class used to fetch items data from database.
 */
public class ItemVendorMapper implements ResultSetMapper<ItemVendor> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final ItemVendor map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Itemvendor
       */
    return new ItemVendor(rs.getInt("ItemVendorId"), rs.getString("vendorName"), rs.getLong("vendorPhoneno"), rs.getString("vendorEmailId"),
     rs.getString("pwd"));
  }
}
