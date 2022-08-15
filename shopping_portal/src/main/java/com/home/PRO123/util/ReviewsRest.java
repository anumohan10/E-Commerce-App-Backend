package com.home.PRO123.util;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.home.PRO123.model.Reviews;
import com.home.PRO123.factory.ReviewsFactory;

/**
 * This class provides a REST interface for the employee entity.
 */
@Path("/reviews")
public class ReviewsRest {
  /**
   * Returns Reviews details.
   * @return the Reviews details
   */
  @GET()
  @Path("/viewreviews")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/reviews/viewreviews
  public final Reviews[] listReviews() {
    final Reviews[] reviews = ReviewsFactory.showReviews();
    return reviews;
  }
  /**
   * Returns Reviews for a specific rating.
   * @param rts for storing ratings.
   * @return the Reviews details
   */
  @GET()
  @Path("/reviewsbyratings/{ratings}")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/reviews/reviewsbyratings
  public final Reviews[] listReviewsrts(@PathParam("ratings") final int rts) {
    final Reviews[] reviews = ReviewsFactory.showreviewRatings(rts);
    return reviews;
  }
  /**
   * Returns Reviews for a specific rating.
   * @param fdId for storing ratings.
   * @return the Reviews details
   */
  @GET()
  @Path("/reviewsbyitemId/{itemId}")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/reviews/reviewsbyitemId
  public final Reviews[] listReviewsfdId(@PathParam("itemId") final int fdId) {
    final Reviews[] reviews = ReviewsFactory.showreviewFdId(fdId);
    return reviews;
  }
  /**
   * Returns Reviews for a specific rating.
   * @param fvId for storing ratings.
   * @return the Reviews details
   */
  @GET()
  @Path("/reviewsbyitemVendorId/{itemVendorId}")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/reviews/reviewsbyitemVendorId
  public final Reviews[] listReviewsfvId(@PathParam("itemVendorId") final int fvId) {
    final Reviews[] reviews = ReviewsFactory.showreviewFvId(fvId);
    return reviews;
  }
  /**
   * Returns Reviews for a specific rating.
   * @return the Reviews details.
   */
  @GET()
  @Path("/ratingsorder")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/reviews/ratingorder
  public final Reviews[] listReviewsOrder() {
    final Reviews[] reviews = ReviewsFactory.ratingOrder();
    return reviews;
  }
  /**
   * Returns Reviews for a specific rating.
   * @return the Reviews details
   * @param custId for storing ratings.
   */
  @GET()
  @Path("/reviewsbycustId/{custId}")
  @Produces(MediaType.APPLICATION_JSON)
  //curl -vvv http://localhost:8080/MLP290/api/reviews/reviewsbycustId
  public final Reviews[] listReviewsbycustId(@PathParam("custId") final int custId) {
    final Reviews[] reviews = ReviewsFactory.showreviewcustId(custId);
    return reviews;
  }
  /**
   * Call the data base connection.
   * @return the array of Reviews object.
   * @param cmnts for storing comments.
   * @param rts for storing ratings.
   * @param custId for storing custid.
   * @param fvId for storing itemventorid.
   * @param fdId for storing itemid.
   * @param itemName for storing item name.
   */
  @POST()
   @Path("/reviewsadd/{comments}/{ratings}/{custId}/{itemVendorId}/{itemId}/{itemName}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/reviews/reviewsadd
   public final String addcustReviews(@PathParam("comments") final String cmnts, @PathParam("ratings") final int rts,
                                  @PathParam("custId") final int custId, @PathParam("itemVendorId") final int fvId,
                                  @PathParam("itemId") final int fdId, @PathParam("itemName") final String itemName) {
    int revId = 0;
    Reviews[] reviews = ReviewsFactory.showReviews();
    for (Reviews r : reviews) {
      revId = r.getreviewsId();
    }
    revId++;
    ReviewsFactory.addRev(revId, cmnts, rts, custId, fvId, fdId, itemName);
    return "Successful added Reviews";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param cmnts for storing comments.
   * @param revId  to initialize rev id.
   */
  @PUT()
   @Path("/customerupdatecomments/{comments}/{reviewsId}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/reviews/customerupdatecomments
   public final String updateCustComments(@PathParam("comments") final String cmnts, @PathParam("reviewsId") final int revId) {
    ReviewsFactory.updateitemcmnts(cmnts, revId);
    return "Updated Comments";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param rts for storing comments.
   * @param revId  to initialize rev id.
   */
  @PUT()
   @Path("/customerupdateratings/{ratings}/{reviewsId}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/reviews/customerupdateratings
   public final String updateCustRatings(@PathParam("ratings") final int rts, @PathParam("reviewsId") final int revId) {
    ReviewsFactory.updateitemRatings(rts, revId);
    return "Updated Ratings";
  }
  /**
   * @return the connection object.
   * Call the data base connection.
   * @param revId  to initialize rev id.
   * @param custId to initialize cust id.
   */
  @DELETE()
   @Path("/reviewsdelete/{reviewsId}/{custId}")
   @Produces(MediaType.APPLICATION_JSON)
   //curl -vvv http://localhost:8080/MLP290/api/reviews/reviewsdelete
   public final String deleterevAcc(@PathParam("reviewsId") final int revId, @PathParam("custId") final int custId) {
    ReviewsFactory.delRev(revId, custId);
    return "Delete Reviews Account";
  }
}
