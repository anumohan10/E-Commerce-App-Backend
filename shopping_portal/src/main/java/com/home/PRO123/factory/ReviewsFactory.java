package com.home.PRO123.factory;

import com.home.PRO123.persistence.ReviewsDAO;
import com.home.PRO123.persistence.DbConnection;
import java.util.List;

import com.home.PRO123.model.Reviews;

public class ReviewsFactory {
  /**
   *  Protected constructor.
   */
  protected ReviewsFactory() {

  }
  /**
   * Call the data base connection.
   * @return the connection object.
   */
  private static ReviewsDAO dao() {
    DbConnection db = new DbConnection();
    return db.getConnect().onDemand(ReviewsDAO.class);
  }
  /**
   * Call the data base connection.
   * @return the array of Reviews object.
   * @param revId for storing reviews Id.
   * @param cmnts for storing comments.
   * @param rts for storing ratings.
   * @param custId for storing custid.
   * @param itId for storing itemventorid.
   * @param ieId for storing itemid.
   * @param itemName for storing itemName.
   */
  public static String addRev(final int revId, final String cmnts, final int rts, final int custId,
      final int itId, final int ieId, final String itemName) {
    dao().revinsert(revId, cmnts, rts, custId, itId, ieId, itemName);
    return "Added New Review";
  }
  /**
   * Call the data base connection.
   * @return the array of menu object.
   */
  public static Reviews[] ratingOrder() {
    List<Reviews> reviews = dao().showRatings();
    return reviews.toArray(new Reviews[reviews.size()]);
  }
  /**
   * Call the data base connection.
   * @param rts for item id.
   * @return the array of menu object.
   */
  public static Reviews[] showreviewRatings(final int rts) {
    List<Reviews> reviews = dao().showrts(rts);
    return reviews.toArray(new Reviews[reviews.size()]);
  }
  /**
   * Call the data base connection.
   * @param ieId for item id.
   * @return the array of menu object.
   */
  public static Reviews[] showreviewieId(final int ieId) {
    List<Reviews> reviews = dao().showieId(ieId);
    return reviews.toArray(new Reviews[reviews.size()]);
  }
  /**
   * Call the data base connection.
   * @param itId for item id.
   * @return the array of menu object.
   */
  public static Reviews[] showreviewitId(final int itId) {
    List<Reviews> reviews = dao().showitId(itId);
    return reviews.toArray(new Reviews[reviews.size()]);
  }
  /**
   * Call the data base connection.
   * @param custId for item id.
   * @return the array of menu object.
   */
  public static Reviews[] showreviewcustId(final int custId) {
    List<Reviews> reviews = dao().showcustId(custId);
    return reviews.toArray(new Reviews[reviews.size()]);
  }
  /**
   * Call the data base connection.
   * @param cmnts for storing ratings.
   * @param revId for storing reviews Id.
   * @return the array of menu object.
   */
  public static String updateitemcmnts(final String cmnts, final int revId) {
    dao().updateComments(cmnts, revId);
    return "Updated Comments";
  }
  /**
   * Call the data base connection.
   * @param rts for storing ratings.
   * @param revId for storing reviews Id.
   * @return the array of menu object.
   */
  public static String updateitemRatings(final int rts, final int revId) {
    dao().updateRatings(rts, revId);
    return "Updated Ratings";
  }
  /**
   * Call the data base connection.
   * @return the array of Reviews object.
   * @param revId for storing reviews Id.
   * @param custId for storing custid*
   */
  public static String delRev(final int revId, final int custId) {
    dao().deleteRev(revId, custId);
    return "Review Deleted";
  }
/**
   * Call the data base connection.
   * @return the connection object.
   */
  public static Reviews[] showReviews() {
    List<Reviews> reviews = dao().show();
    return reviews.toArray(new Reviews[reviews.size()]);
  }
}
