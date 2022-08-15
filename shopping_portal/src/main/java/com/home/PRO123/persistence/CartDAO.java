package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.home.PRO123.model.Cart;

public interface CartDAO {
    /**
     * @return the all the Cart record.
     */
  @SqlQuery("Select * from Cart")
    @Mapper(CartMapper.class)
    List<Cart> show();

    /**
     * @param cartId to initialize Cart Id.
     * @param custId to initialize Cart Code.
     * @param itemId to initialize cust Id.
     * @param vendorId to initialize order Id.
     * @param quantity to initialize order Id.
     * @param price to initialize order Id.
     */
  @SqlUpdate("insert into cart (cartId, custId, itemId, vendorId, quantity, price)"
        + " values (:cartId, :custId, :itemId, :vendorId, :quantity, :price)")
    void insert(@Bind("cartId") int cartId, @Bind("custId") int custId, @Bind("itemId") int itemId, @Bind("vendorId")
            int vendorId, @Bind("quantity") int quantity, @Bind("price") int price);
}
