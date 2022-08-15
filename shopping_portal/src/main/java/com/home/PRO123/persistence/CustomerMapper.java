package com.hexaware.MLP290.persistence;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.hexaware.MLP290.model.Customer;

import org.skife.jdbi.v2.tweak.ResultSetMapper;
import org.skife.jdbi.v2.StatementContext;
/**
 * CustMapper class used to fetch Cust data from database.
 */
public class CustomerMapper implements ResultSetMapper<Customer> {
    /**
     * @param idx the index
     * @param rs the resultset
     * @param ctx the context
     * @return the mapped customer object
     * @throws SQLException in case there is an error in fetching data from the resultset
     */
  public final Customer map(final int idx, final ResultSet rs, final StatementContext ctx) throws SQLException {
      /**
       * @return Customer
       */
    return new Customer(rs.getInt("custId"), rs.getString("custName"), rs.getLong("custPhno"), rs.getString("custEmailid"),
    rs.getString("passwrd"), rs.getString("custAddress"));
  }
}
