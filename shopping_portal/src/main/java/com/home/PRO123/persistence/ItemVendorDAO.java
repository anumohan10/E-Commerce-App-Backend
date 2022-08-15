package com.home.PRO123.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.home.PRO123.model.ItemVendor;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * ItemVendorDAO class used to fetch data from data base.
 */
public interface ItemVendorDAO {
  /**
   * @return all the item record
   */
  @SqlQuery("select * from ItemVendor")
    @Mapper(ItemVendorMapper.class)
    List<ItemVendor> show();
    /**
     * @param emailId to initialize VendorEmailID.
     * @param pwd to initialize Pwd.
     * @return all the record.
     */
  @SqlQuery("select * from ItemVendor where VendorEmailID = :vendorEmailID AND Pwd = :pwd")
    @Mapper(ItemVendorMapper.class)
    List<ItemVendor> show(@Bind("vendorEmailID") String emailId, @Bind("pwd") String pwd);
    /**
     * @param fvId to initialize ItemVendorID.
     * @param fvName to initialize VendorName.
     * @param phNo to initialize VendorPhoneno.
     * @param emailId to initialize VendorEmailID.
     * @param pwd to initialize Pwd.
     */
  @SqlUpdate("insert into ItemVendor(ItemVendorID, VendorName, VendorPhoneno, VendorEmailID, Pwd)"
        + " values (:ItemVendorID,  :vendorName,  :vendorPhoneno,  :vendorEmailID,  :pwd)")
    void vendorSignup(@Bind("ItemVendorID") int fvId, @Bind("vendorName") String fvName, @Bind("vendorPhoneno") long phNo,
        @Bind("vendorEmailID") String emailId, @Bind("pwd") String pwd);
    /**
     * @param phNo to initialize VendorPhoneno.
     * @param emailId to initialize VendorEmailID.
     */
  @SqlUpdate("update ItemVendor set VendorPhoneno = :vendorPhoneno where VendorEmailID = :vendorEmailID")
    void updatephNo(@Bind("vendorPhoneno") long phNo, @Bind("vendorEmailID") String emailId);
    /**
     * @param emailId to initialize VendorEmailID.
     * @param phNo to initialize VendorPhoneno.
     */
  @SqlUpdate("update ItemVendor set VendorEmailID = :vendorEmailID where VendorPhoneno = :vendorPhoneno")
    void updateEid(@Bind("vendorEmailID") String emailId, @Bind("vendorPhoneno") long phNo);
    /**
     * @param pwd to initialize Pwd.
     * @param phNo to initialize VendorPhoneno.
     */
  @SqlUpdate("update ItemVendor set Pwd = :pwd where VendorPhoneno = :vendorPhoneno")
    void updatepwd(@Bind("pwd") String pwd, @Bind("vendorPhoneno") long phNo);
    /**
     * @param emailId to initialize VendorEmailID.
     * @param pwd to initialize Pwd.
     */
  @SqlUpdate("update ItemVendor set Pwd = :pwd where VendorEmailID = :vendorEmailID")
    void updateforpass(@Bind("pwd") String pwd, @Bind("vendorEmailID") String emailId);
    /**
     * @param emailId to initialize VendorEmailID.
     * @param pwd to initialize Pwd.
     */
  @SqlUpdate("delete from ItemVendor where VendorEmailID = :vendorEmailID AND pwd = :pwd")
    void deleteAcc(@Bind("vendorEmailID") String emailId, @Bind("pwd") String pwd);
}

