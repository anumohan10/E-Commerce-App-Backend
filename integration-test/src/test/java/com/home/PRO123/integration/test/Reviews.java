package com.home.PRO123.integration.test;
import java.util.Objects;
import com.home.PRO123.integration.test.CommonUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;


public class Reviews {
/**
 * Reviews id to store Reviews id.
 */
  private int reviewsId;
  /**
 * comments to store comments.
 */
  private String comments;
  /**
 * ratings to store ratings.
 */
  private int ratings;
  /**
 * custId to store custId.
 */
  private int custId;
  /**
 * itemvendorid to store itemvendorid.
 */
  private int itemVendorId;
  /**
 * itemid to store itemid.
 */
  private int itemId;
  /**
 * itemName to store item name.
 */
  private String itemName;
  /**
   * Default Constructor.
   */
  public Reviews() {

  }
/**
 * @param argreviewsId to initialize Reviews id.
 * @param argcomments to initialize comments.
 * @param argratings to initialize ratings.
 * @param argcustId to initialize custId.
 * @param argitemVendorId to initialize itemvendorid.
 * @param argitemId to initialize itemid.
 * @param argitemName to initialize itemName.
 * used to get details through constructor.
 */
  public Reviews(final int argreviewsId, final String argcomments, final int argratings, final int argcustId,
      final int argitemVendorId, final int argitemId, final String argitemName) {
    this.reviewsId = argreviewsId;
    this.comments = argcomments;
    this.ratings = argratings;
    this.custId = argcustId;
    this.itemVendorId = argitemVendorId;
    this.itemId = argitemId;
    this.itemName = argitemName;
  }
  @Override
    public final boolean equals(final Object obj) {
    if (obj == null) {
      return false;
    }
    if (getClass() != obj.getClass()) {
      return false;
    }
    Reviews reviews = (Reviews) obj;
    if (Objects.equals(reviewsId, reviews.reviewsId) && Objects.equals(comments, reviews.comments) && Objects.equals(ratings, reviews.ratings)
         && Objects.equals(custId, reviews.custId) && Objects.equals(itemVendorId, reviews.itemVendorId)
         && Objects.equals(itemId, reviews.itemId) && Objects.equals(itemName, reviews.itemName)) {
      return true;
    }
    return false;
  }
  @Override
    public final int hashCode() {
    return Objects.hash(reviewsId, comments, ratings, custId, itemVendorId, itemId, itemName);
  }
    /**
     * @return Reviews id.
     */
  public final int getreviewsId() {
    return reviewsId;
  }
  /**
     * @return this comments.
     */
  public final String getcomments() {
    return comments;
  }
  /**
     * @return this ratings.
     */
  public final int getratings() {
    return ratings;
  }
  /**
     * @return this custId.
     */
  public final int getcustId() {
    return custId;
  }
  /**
     * @return this itemvendorid.
     */
  public final int getitemVendorId() {
    return itemVendorId;
  }
  /**
     * @return this itemid.
     */
  public final int getitemId() {
    return itemId;
  }
  /**
     * @return this itemName.
     */
  public final String getitemName() {
    return itemName;
  }
    /**
     * @return reviews id.
     * @param argreviewsId to initialize Reviews id.
     */
  public final int setreviewsId(final int argreviewsId) {
    this.reviewsId = argreviewsId;
    return argreviewsId;
  }
  /**
     * @return comments.
     * @param argcomments to initialize comments.
     */
  public final String setcomments(final String argcomments) {
    this.comments = argcomments;
    return argcomments;
  }
  /**
     * @return ratings.
     * @param argratings to initialize ratings.
     */
  public final int setratings(final int argratings) {
    this.ratings = argratings;
    return argratings;
  }
  /**
     * @return cust id.
     * @param argcustId to initialize custId.
     */
  public final int setcustId(final int argcustId) {
    this.custId = argcustId;
    return argcustId;
  }
  /**
     * @return itemvendor id.
     * @param argitemVendorId to initialize itemvendorid.
     */
  public final int setitemVendorId(final int argitemVendorId) {
    this.itemVendorId = argitemVendorId;
    return argitemVendorId;
  }
  /**
     * @return item id.
     * @param argitemId to initialize itemid.
     */
  public final int setitemId(final int argitemId) {
    this.itemId = argitemId;
    return argitemId;
  }
  /**
     * @return item name.
     * @param argitemName to initialize itemname.
     */
  public final String setitemName(final String argitemName) {
    this.itemName = argitemName;
    return argitemName;
  }
}
