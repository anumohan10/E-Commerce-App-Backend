package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.home.PRO123.model.Reviews;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * ReviewsDAO class used to fetch data from data base.
 */
public interface ReviewsDAO {
    /**
     * @return the all the Reviews record.
     */
  @SqlQuery("Select * from Reviews")
    @Mapper(ReviewsMapper.class)
    List<Reviews> show();
    /**
     * update the table with new Review.
     * @param revId for storing reviews Id.
     * @param cmnts for storing comments.
     * @param rts for storing ratings.
     * @param custId for storing custid.
     * @param itId for storing itemventorid.
     * @param ieId for storing itemid.
     * @param itemName for storing item name.
     */
  @SqlUpdate("insert into Reviews (reviewsId, comments, ratings, custId, itemVendorId, itemId, itemName)"
      + " values (:reviewsId, :comments, :ratings, :custId, :itemVendorId, :itemId, :itemName)")
    void revinsert(@Bind("reviewsId") int revId, @Bind("comments") String cmnts, @Bind("ratings") int rts,
      @Bind("custId") int custId, @Bind("itemVendorId") int itId, @Bind("itemId") int ieId, @Bind("itemName") String itemName);
  /**
     * @param rts to initialize passwrd.
     * @return the all the Reviews record.
     */
  @SqlQuery("Select * from Reviews where ratings =:ratings")
    @Mapper(ReviewsMapper.class)
    List<Reviews> showrts(@Bind("ratings") int rts);
  /**
     * @param ieId to initialize itemid.
     * @return the all the Reviews record.
     */
  @SqlQuery("Select * from Reviews where itemId =:itemId")
    @Mapper(ReviewsMapper.class)
    List<Reviews> showieId(@Bind("itemId") int ieId);
  /**
     * @param custId to initialize itemid.
     * @return the all the Reviews record.
     */
  @SqlQuery("Select * from Reviews where custId =:custId")
    @Mapper(ReviewsMapper.class)
    List<Reviews> showcustId(@Bind("custId") int custId);
  /**
     * @param itId to initialize passwrd.
     * @return the all the Reviews record.
     */
  @SqlQuery("Select * from Reviews where itemVendorId =:itemVendorId")
    @Mapper(ReviewsMapper.class)
    List<Reviews> showitId(@Bind("itemVendorId") int itId);
  /**
     * @return the all the Reviews record.
     */
  @SqlQuery("Select * from Reviews ORDER BY ratings DESC")
    @Mapper(ReviewsMapper.class)
    List<Reviews> showRatings();
  /**
   * @param revId for storing reviews Id.
   * @param cmnts for storing comments.
   */
  @SqlUpdate("update Reviews set comments = :comments where reviewsId = :reviewsId")
  void updateComments(@Bind("comments") String cmnts, @Bind("reviewsId") int revId);
  /**
   * @param revId for storing reviews Id.
   * @param rts for storing comments.
   */
  @SqlUpdate("update Reviews set ratings = :ratings where reviewsId = :reviewsId")
  void updateRatings(@Bind("ratings") int rts, @Bind("reviewsId") int revId);
  /**
   * @param revId for storing reviews Id.
   * @param custId for storing custid.
   */
  @SqlUpdate("delete from Reviews where reviewsId = :reviewsId AND custId = :custId")
  void deleteRev(@Bind("reviewsId") int revId, @Bind("custId") int custId);
}
