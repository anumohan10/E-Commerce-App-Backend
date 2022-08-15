package com.home.PRO123.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.home.PRO123.model.Reviews;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * ReviewsMapper class used to fetch Reviews data from database.
 */
public class ReviewsMapper implements ResultSetMapper<Reviews> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Reviews map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Reviews
       */
    return new Reviews(rs.getInt("reviewsId"), rs.getString("comments"), rs.getInt("ratings"),
    rs.getInt("custId"), rs.getInt("itemVendorId"), rs.getInt("itemId"), rs.getString("itemName"));
  }
}
