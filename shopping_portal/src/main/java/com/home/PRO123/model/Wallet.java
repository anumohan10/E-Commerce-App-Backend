package com.hexaware.MLP290.model;
import java.util.Objects;

/**
 * Wallet class used to display Wallet information.
 * @author hexware
 */
public class Wallet {
/**
 * wallet id to store wallet id.
 */
  private int walletId;
  /**
 * customer id to store customer id.
 */
  private int custId;
  /**
 * balance to store balance.
 */
  private int balance;
  /**
 * bankacc no to store bankacc no.
 */
  private long bankaccNo;
  /**
   * Default Constructor.
   */
  public Wallet() {

  }
/**
 * @param argwalletId to initialize wallet id.
 * @param argcustId to initialize customer id.
 * @param argbalance to initialize balance.
 * @param argbankaccNo to initialize bankacc no.
 * used to get details through constructor.
 */
  public Wallet(final int argwalletId, final int argcustId, final int argbalance, final long argbankaccNo) {
    this.walletId = argwalletId;
    this.custId = argcustId;
    this.balance = argbalance;
    this.bankaccNo = argbankaccNo;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Wallet wallet = (Wallet) obj;
    if (Objects.equals(walletId, wallet.walletId) && Objects.equals(custId, wallet.custId) && Objects.equals(balance, wallet.balance)
          && Objects.equals(bankaccNo, wallet.bankaccNo)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(walletId, custId, balance, bankaccNo);
  }
    /**
     * @return wallet id.
     */
  public final int getwalletId() {
    return walletId;
  }
  /**
     * @return this customer id.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this balance.
     */
  public final int getbalance() {
    return balance;
  }
  /**
     * @return this bankacc no.
     */
  public final long getbankaccNo() {
    return bankaccNo;
  }
    /**
     * @return this wallet id.
     * @param argwalletId to initialize wallet id.
     */
  public final int setwalletId(final int argwalletId) {
    this.walletId = argwalletId;
    return argwalletId;
  }
  /**
   * @return this customer id.
     * @param argcustId to initialize customer id.
     */
  public final int setcustId(final int argcustId) {
    this.custId = argcustId;
    return argcustId;
  }
  /**
   * @return this balance
     * @param argbalance to initialize balance.
     */
  public final int setbalance(final int argbalance) {
    this.balance = argbalance;
    return argbalance;
  }
  /**
   * @return bankacc no.
     * @param argbankaccNo to initialize bankacc no.
     */
  public final long setbankaccNo(final long argbankaccNo) {
    this.bankaccNo = argbankaccNo;
    return argbankaccNo;
  }
}
