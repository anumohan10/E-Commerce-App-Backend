package com.home.PRO123.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.PRO123.model.Orderstatus;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * OrderstatusMapper class used to fetch Orderstatus data from database.
 */
public class OrderstatusMapper implements ResultSetMapper<Orderstatus> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Orderstatus map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Orderstatus
       */
    return new Orderstatus(rs.getInt("id"), rs.getInt("orderId"), rs.getString("eta"), rs.getString("orderstatus"),
      rs.getInt("itemVendorId"), rs.getInt("custId"), rs.getInt("quantity"));
  }
}
