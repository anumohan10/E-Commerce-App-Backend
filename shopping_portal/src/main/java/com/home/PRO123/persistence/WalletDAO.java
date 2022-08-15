package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.home.PRO123.model.Wallet;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * WalletDAO class used to fetch data from data base.
 */
public interface WalletDAO {
    /**
     * @return the all the Wallet record.
     */
  @SqlQuery("Select * from Wallet")
    @Mapper(WalletMapper.class)
    List<Wallet> show();
    /**
     * @param walletid to initialize wallet id.
     * @return the all the Wallet record.
     */
  @SqlQuery("Select * from Wallet")
    @Mapper(WalletMapper.class)
    List<Wallet> show(@Bind("walletId") int walletid);
    /**
     * update the table wallet balance.
     * @param custId for storing Customer Id.
     * @param balance for storing balance
     */
  @SqlUpdate("update wallet set balance = balance - :balance where CustId = :custId")
    void order(@Bind("custId") int custId, @Bind("balance") int balance);
      /**
     * update the table wallet balance.
     * @param custId for storing Customer Id.
     * @param balance for storing balance
     */
  @SqlUpdate("update wallet set balance = balance + :balance where CustId = :custId")
    void refund(@Bind("custId") int custId, @Bind("balance") int balance);
      /**
     * update the table wallet balance.
     * @param walletId for storing wallet id.
     * @param custId for storing Customer Id.
     */
  @SqlUpdate("insert into wallet (walletId, CustId, balance) values (:walletId, :custId, 0)")
    void insert(@Bind("walletId") int walletId, @Bind("custId") int custId);
    /**
     * update the table wallet balance.
     * @param custId for storing Customer Id.
     * @param bank for storing account no.
     */
  @SqlUpdate("update wallet set bankaccNo = :bankaccNo where CustId = :CustId")
    void updateBank(@Bind("bankaccNo") long bank, @Bind("CustId") int custId);
}
