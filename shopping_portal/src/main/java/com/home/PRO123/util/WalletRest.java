package com.home.PRO123.util;


import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.Wallet;
import com.home.PRO123.factory.WalletFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/wallet")
public class WalletRest {
  /**
   * Returns wallet details.
   * @return the wallet details
   */
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public final Wallet[] listWallet() {
    final Wallet[] wallet = WalletFactory.showWallet();
    return wallet;
  }
  /**
   * Returns Wallet details.
   * @param walletid to initialize wallet id.
   * @return the wallet details
   */
  @GET()
  @Path("/showbywalletId/{walletId}")
  @Produces(MediaType.APPLICATION_JSON)
  public final Wallet[] listWallet(@PathParam("walletId") final int walletid) {
    final Wallet[] wallet = WalletFactory.showbywalletId(walletid);
    return wallet;
  }

  /**
   * @return the order status.
   * @param balance for storing balance.
   * @param custId for storing Customer Id.
   */
  @PUT
    @Path("/addbalance/{CustId}/{balance}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String addbalance(@PathParam("CustId") final int custId, @PathParam("balance") final int balance) {
    WalletFactory.refund(custId, balance);
    return "Money added!";
  }
  /**
   * @return the order status.
   * @param bank for storing account no.
   * @param custId for storing Customer Id.
   */
  @PUT
    @Path("/updatebankacc/{bankaccNo}/{CustId}")
    @Produces(MediaType.APPLICATION_JSON)
    public final String updatebankacc(@PathParam("bankaccNo") final long bank, @PathParam("CustId") final int custId) {
    WalletFactory.updateBank(bank, custId);
    return "Bank Details Updated";
  }
}
