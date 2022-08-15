package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import com.home.PRO123.model.Coupon;
/**
 * CouponDAO class used to fetch data from data base.
 */
public interface CouponDAO {
    /**
     * @return the all the Coupon record.
     */
  @SqlQuery("Select * from Coupon")
    @Mapper(CouponMapper.class)
    List<Coupon> show();

    /**
     * @param cpnId to initialize coupon Id.
     * @param cpnCode to initialize coupon Code.
     * @param cstId to initialize cust Id.
     * @param ordrId to initialize order Id.
     */

  @SqlUpdate("insert into Coupon (couponId, couponCode, custId, orderId)"
        + " values (:couponId, :couponCode, :custId, :orderId)")
    void insert(@Bind("couponId") int cpnId, @Bind("couponCode") String cpnCode, @Bind("custId") int cstId, @Bind("orderId")
            int ordrId);

    /**
     * @param cpnCode to initialize coupon Code.
     * @param cpnId to initialize coupon Id.
     */
  @SqlUpdate("update Coupon set couponCode = :couponCode where couponId = :coupon Id")
  void updateCpncd(@Bind("couponCode") String cpnCode, @Bind("couponId") int cpnId);
}
