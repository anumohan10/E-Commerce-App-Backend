package com.home.PRO123.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.PRO123.model.Cart;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * CartMapper class used to fetch menu data from database.
 */
public class CartMapper implements ResultSetMapper<Cart> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Cart map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Cart
       */
    return new Cart(rs.getInt("cartId"), rs.getInt("custId"), rs.getInt("itemId"), rs.getInt("vendorId"), rs.getInt("quantity"), rs.getInt("price"));
  }
}
