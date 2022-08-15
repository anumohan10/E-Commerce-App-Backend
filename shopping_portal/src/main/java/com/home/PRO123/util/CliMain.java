package com.home.PRO123.util;
import java.util.Scanner;
import com.home.PRO123.factory.itemFactory;
import com.home.PRO123.factory.OrderLogFactory;
import com.home.PRO123.factory.CustomerFactory;
import com.home.PRO123.factory.ItemVendorFactory;
import com.home.PRO123.factory.WalletFactory;
import com.home.PRO123.factory.CouponFactory;
import com.home.PRO123.factory.ReviewsFactory;
import com.home.PRO123.factory.OrderstatusFactory;
import com.home.PRO123.model.item;
import com.home.PRO123.model.OrderLog;
import com.home.PRO123.model.Customer;
import com.home.PRO123.model.ItemVendor;
import com.home.PRO123.model.Wallet;
import com.home.PRO123.model.Coupon;
import com.home.PRO123.model.Reviews;
import com.home.PRO123.model.Orderstatus;
import java.security.MessageDigest;
import java.util.Properties;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import javax.mail.Transport;

/**
 * CliMain used as Client interface for java coading.
 */
public class CliMain {
  private Scanner option = new Scanner(System.in, "UTF-8");
/**
 * loginOption method  used to display the option we had in the application.
 */
  private void loginOption() {
    System.out.println("Canteen Management System");
    System.out.println("-----------------------");
    System.out.println("Select");
    System.out.println("1. For Customer Login");
    System.out.println("2. For Vendor Login");
    System.out.println("3. For New Customer Signup");
    System.out.println("4. For New Vendor Signup");
    System.out.println("5. Exit");
    loginSelect();
  }
/**
 * loginSelect method to select between customer and vendor login.
 */
  private void loginSelect() {
    try {
      System.out.println("Enter your choice:");
      int itemOption = option.nextInt();
      switch (itemOption) {
        case 1:
          loginForCust();
          break;
        case 2:
          loginForVendor();
          break;
        case 3:
          customerSignup();
          break;
        case 4:
          vendorSignup();
          break;
        case 5:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2 or 3 or 4 or 5");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    loginOption();
  }
/**
 * newCustomerSignup method to create new customer account in the database.
 */
  private void customerSignup() {
    int cId = 0;
    Customer[] cust = CustomerFactory.showitem();
    for (Customer c : cust) {
      cId = c.getcustId();
    }
    cId++;
    System.out.print("Enter Customer Name = ");
    option.nextLine();
    String cName = option.nextLine();
    System.out.print("Enter Customer Phone number = ");
    try {
      long cPhno = option.nextLong();
      String strPhno = Long.toString(cPhno);
      int i = strPhno.length();
      System.out.print("Enter Customer EmailId = ");
      String cEid = option.next();
      System.out.print("Enter Password (Should contain A-Z/a-z and 0-9) = ");
      String pwd = option.next();
      int j = pwd.length();
      System.out.print("Enter Customer Address = ");
      option.nextLine();
      String cAdd = option.nextLine();
      if (i == 10 && cEid.contains("@") && cEid.contains(".") && j >= 8 && pwd.matches("^[a-zA-Z0-9]*$")) {
        String enpwd = encrypt(pwd);
        CustomerFactory.signup(cId, cName, cPhno, cEid, enpwd, cAdd);
        String subject = "Welcome to Cravings";
        String text = "Hey " + cName + "  Happy to have you in Cravings. Hope to enleash the right craving for you.";
        sendMail(cEid, subject, text);
        System.out.println("\nSuccessful Sign Up, Welcome to Cravings\n");
      } else {
        System.out.println("Invalid Phone Number or EmailId or Password");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Invalid Phone Number");
    }
  }
/**
 * newVendorSignup method to create new vendor account in the database.
 */
  private void vendorSignup() {
    int itId = 0;
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    for (ItemVendor c : Itemvendor) {
      itId = c.getItemVendorId();
    }
    itId++;
    System.out.print("Enter ItemVendor Name = ");
    option.nextLine();
    String itName = option.nextLine();
    System.out.print("Enter ItemVendor Phone Number = ");
    try {
      long phNo = option.nextLong();
      String strphNo = Long.toString(phNo);
      int i = strphNo.length();
      System.out.print("Enter ItemVendor Email Id = ");
      String emailId = option.next();
      System.out.print("Enter Password (Should contain A-Z/a-z and 0-9) = ");
      String pwd = option.next();
      int j = pwd.length();
      if (i == 10 && emailId.contains("@") && emailId.contains(".") && j >= 8 && pwd.matches("^[a-zA-Z0-9]*$")) {
        String enpwd = encrypt(pwd);
        ItemVendorFactory.signup(itId, itName, phNo, emailId, enpwd);
        String subject = "Welcome to Cravings";
        String text = "Hey " + itName + "  Happy to have you in Cravings. Hope you can serve the best craving for us";
        sendMail(emailId, subject, text);
        System.out.println("\nSuccessful Sign Up, Welcome to Cravings\n");
      } else {
        System.out.println("Invalid Phone Number or EmailId or Password");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Invalid Phone Number");
    }
  }
/**
 * Login option for customer.
 */
  private void loginForCust() {
    try {
      System.out.println("------------------");
      System.out.println("Enter your choice:");
      System.out.println("------------------");
      System.out.println("\n1. Customer Login \n2. Forget Password \n3. Go Back \n4. Exit");
      int itemOption = option.nextInt();
      switch (itemOption) {
        case 1:
          loginCustomer();
          break;
        case 2:
          forgetpassCust();
          break;
        case 3:
          loginOption();
          break;
        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2 or 3 or 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    loginOption();
  }
/**
 * forget password for cust.
 */
  private void forgetpassCust() {
    try {
      System.out.println("-----------------------");
      Customer[] cust = CustomerFactory.showitem();
      System.out.println("Enter the Email Id");
      String cEid = option.next();
      System.out.print("Enter your new Password (Should contain A-Z/a-z and 0-9) = ");
      String pwd = option.next();
      int j = pwd.length();
      for (Customer c : cust) {
        if (pwd.equals(c.getpasswrd())) {
          System.out.println("You have entered the old Password");
          break;
        } else if (j >= 8 && pwd.matches("^[a-zA-Z0-9]*$")) {
          String enpwd = encrypt(pwd);
          CustomerFactory.pwdupdate(enpwd, cEid);
          System.out.println("\nSuccessfully updated the Password\n");
          break;
        } else {
          System.out.println("Your password does not match with the given condition");
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    loginOption();
  }
/**
 * loginCustomer method to verify login credentials.
 */
  private void loginCustomer() {
    try {
      System.out.println("Customer Login");
      System.out.println("-----------------------");
      Customer[] cust = CustomerFactory.showitem();
      System.out.print("Enter your Mail ID = ");
      String itemOption1 = option.next();
      System.out.print("Enter your Password = ");
      String itemOption2 = option.next();
      String enpwd = encrypt(itemOption2);
      boolean d = true;
      for (Customer c : cust) {
        if (itemOption1.equals(c.getcustEmailid()) && enpwd.equals(c.getpasswrd())) {
          System.out.println("\nLogin Successful!");
          customeritem(c.getcustName(), c.getcustId());
          d = false;
          break;
        }
      }
      if (d) {
        System.out.println("\nWrong Id or password \n");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Wrong ID or Password");
    }
    option.nextLine();
    loginOption();
  }
/**
 * login for vendor method to verify login credentials.
 */
  private void loginForVendor() {
    try {
      System.out.println("------------------");
      System.out.println("Enter your choice:");
      System.out.println("------------------");
      System.out.println("\n1. Vendor Login \n2. Forget Password \n3. Go Back \n4. Exit");
      int itemOption = option.nextInt();
      switch (itemOption) {
        case 1:
          loginVendor();
          break;
        case 2:
          forgetpassVendor();
          break;
        case 3:
          loginOption();
          break;
        case 4:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2 or 3 or 4");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    loginOption();
  }
/**
 * forget password for vendor.
 */
  private void forgetpassVendor() {
    try {
      System.out.println("-----------------------");
      ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
      System.out.print("Enter ItemVendor Email Id = ");
      String emailId = option.next();
      System.out.print("Enter Password (Should contain A-Z/a-z and 0-9) = ");
      String pwd = option.next();
      int j = pwd.length();
      for (ItemVendor c : Itemvendor) {
        if (pwd.equals(c.getpwd())) {
          System.out.println("You have entered the old Password");
          break;
        } else if (j >= 8 && pwd.matches("^[a-zA-Z0-9]*$")) {
          String enpwd = encrypt(pwd);
          ItemVendorFactory.pwdforpass(enpwd, emailId);
          System.out.println("\nSuccessfully updated the Password\n");
          break;
        } else {
          System.out.println("Your password does not match with the given condition");
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    loginOption();
  }
/**
 * loginVendor method  to check vendor credentials.
 */
  private void loginVendor() {
    System.out.println("Vendor Login");
    System.out.println("-----------------------");
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    System.out.print("Enter your Mail ID = ");
    String itemOption1 = option.next();
    System.out.print("Enter your Password = ");
    String itemOption2 = option.next();
    String enpwd = encrypt(itemOption2);
    boolean d = true;
    try {
      for (ItemVendor c : Itemvendor) {
        if (itemOption1.equals(c.getvendorEmailId()) && enpwd.equals(c.getpwd())) {
          System.out.println("\nLogin Successful!");
          vendoritem(c.getvendorName(), c.getItemVendorId());
          d = false;
          break;
        }
      }
      if (d) {
        System.out.println("\nWrong Id or password \n");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Wrong ID or Password");
    }
    option.nextLine();
    loginOption();
  }
/**
 * customeritem method to display item for customer.
 */
  private void customeritem(final String name, final int custid) {
    System.out.println("\nHello " + name + ", Welcome to Cravings.");
    System.out.println("Enter your choice \n-----------------------");
    System.out.println("0. Show item");
    System.out.println("1. Select Item Type");
    System.out.println("2. Profile");
    System.out.println("3. Order Item");
    System.out.println("4. Your Orders");
    System.out.println("5. Wallet");
    System.out.println("6. Coupon");
    System.out.println("7. Reviews");
    System.out.println("8. Update Profile");
    System.out.println("9. Delete Account");
    System.out.println("10. Go Back");
    System.out.println("11. Exit");
    customeritemShow(name, custid);
  }
/**
 * customeritemShow method to select choices for customer.
 */
  private void customeritemShow(final String name, final int custid) {
    try {
      System.out.println("Enter your choice:");
      int itemOption = option.nextInt();
      switch (itemOption) {
        case 0:
          showFullitem();
          break;
        case 1:
          chooseItemtype();
          break;
        case 2:
          showCustProfile(custid);
          break;
        case 3:
          orderItem(name, custid);
          break;
        case 4:
          showOrderOptions(name, custid);
          break;
        case 5:
          showFullWallet(custid);
          walletitem(name, custid);
          break;
        case 6:
          showFullCoupon();
          break;
        case 7:
          System.out.print("Enter your Choice \n1. Show Reviews \n2. Add New Review");
          System.out.print("\n3. Delete Review \n4. Go Back \n");
          int ro = option.nextInt();
          switch (ro) {
            case 1:
              Reviews[] reviews = ReviewsFactory.showReviews();
              for (Reviews r : reviews) {
                if (r.getcustId() == custid) {
                  showFullReviews();
                  break;
                } else {
                  System.out.print("No review added before");
                  break;
                }
              }
              break;
            case 2:
              addNewReviews();
              break;
            case 3:
              deleteReviews();
              break;
            case 4:
              customeritem(name, custid);
              break;
            default: System.out.println("Wrong Choice!");
              customeritem(name, custid);
              break;
          }
          break;
        case 8:
          System.out.print("Enter your Choice \n1. Update Phone \n2. Update EmailId");
          System.out.print("\n3. Update Password \n4. Update Address \n5. Go Back \n");
          int co = option.nextInt();
          switch (co) {
            case 1:
              updatePhoneNo();
              break;
            case 2:
              updateEmailId();
              break;
            case 3:
              updatePasswrd();
              break;
            case 4:
              updateAddress();
              break;
            case 5:
              customeritem(name, custid);
              break;
            default: System.out.println("Wrong Choice!");
              customeritem(name, custid);
              break;
          }
          break;
        case 9:
          System.out.println("Do you Really want to Delete your Account");
          System.out.println("\n1. Yes \n2. No");
          int or = option.nextInt();
          switch (or) {
            case 1:
              deleteCustAcc();
              break;
            case 2:
              customeritem(name, custid);
              break;
            default: System.out.println("Wrong Choice!");
              customeritem(name, custid);
              break;
          }
          break;
        case 10:
          loginOption();
          break;
        case 11:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 1 or 2 or 3 or 4 or 5 or 6 or 7 or 8 or 9 or 10 or 11");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Enter a valid value");
    }
    option.nextLine();
    customeritem(name, custid);
  }
  /**
 * vendoritem method to display item for Vendor.
 */
  private void vendoritem(final String name, final int id) {
    System.out.println("\nHello " + name + ", Welcome to Cravings.");
    System.out.println("Enter your choice \n-----------------------");
    System.out.println("0. Show item");
    System.out.println("1. Update item");
    System.out.println("2. Order History & Management");
    System.out.println("3. Profile");
    System.out.println("4. Coupon");
    System.out.println("5. Reviews");
    System.out.println("6. updatephNo");
    System.out.println("7. updateEid");
    System.out.println("8. updatepwd");
    System.out.println("9. Update coupon code");
    System.out.println("10. Delete account");
    System.out.println("11. Delete Item item");
    System.out.println("12. Go Back");
    System.out.println("13. Exit");
    vendoritemShow(name, id);
  }
/**
 * vendoritemShow method for vendor choices.
 */
  private void vendoritemShow(final String name, final int vendorid) {
    try {
      System.out.println("Enter your choice:");
      int itemOption = option.nextInt();
      switch (itemOption) {
        case 0:
          showFullitem();
          System.out.print("Enter your Choice \n1. Update Item Name \n2. Update Availability \n3. Update Item Cost \n4. Go Back \nEnter Choice: \n");
          int choice = option.nextInt();
          switch (choice) {
            case 1:
              updateItemname();
              break;
            case 2:
              updateAvailability();
              break;
            case 3:
              updateItemcost();
              break;
            case 4:
              loginOption();
              break;
            default:
              System.out.println("Wrong Choice!");
          }
          break;
        case 1:
          updateitem();
          break;
        case 2:
          manageOrders(name, vendorid);
          break;
        case 3:
          showVendorProfile(vendorid);
          break;
        case 4:
          updateCoupon();
          break;
        case 5:
          showFullReviews();
          break;
        case 6:
          updatephNo();
          break;
        case 7:
          updateEid();
          break;
        case 8:
          updatepwd();
          break;
        case 9:
          updateCouponcode();
          break;
        case 10:
          deleteAccount();
          break;
        case 11:
          deleteItemname();
          break;
        case 12:
          loginOption();
          break;
        case 13:
          Runtime.getRuntime().halt(0);
        default:
          System.out.println("Choose either 0 or 1 or 2 or 3 or 4 or 5 or 6 or 7 or 8 or 9 or 10 or 11 or 12 or 13");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("enter a valid value");
    }
    option.nextLine();
    vendoritem(name, vendorid);
  }
/**
 * to update cust Phone Numbers.
 */
  private void updatePhoneNo() {
    Customer[] cust = CustomerFactory.showitem();
    System.out.println("Enter the Email Id");
    String cEid = option.next();
    System.out.println("Enter the New Phone Number");
    try {
      long cPhno = option.nextLong();
      String strPhno = Long.toString(cPhno);
      int i = strPhno.length();
      for (Customer c : cust) {
        if (cPhno == c.getcustPhno() || !cEid.equals(c.getcustEmailid())) {
          System.out.println("You have entered the old Phone Number");
          break;
        } else if (i < 10 || i > 10) {
          System.out.println("Invalid Phone Number");
          break;
        } else {
          CustomerFactory.phupdate(cPhno, cEid);
          System.out.println("\nSuccessfully updated the Phone Number\n");
          break;
        }
      }
    } catch (Exception e) {
      System.out.println("Invalid Phone Number");
    }
  }
/**
 * to update cust EmailId.
 */
  private void updateEmailId() {
    Customer[] cust = CustomerFactory.showitem();
    System.out.println("Enter your Customer Id");
    int cId = option.nextInt();
    System.out.println("Enter the New Email Id");
    String cEid = option.next();
    for (Customer c : cust) {
      if (cEid.equals(c.getcustEmailid())) {
        System.out.println("You have entered the old Email Id");
        break;
      } else if (cEid.contains("@") && cEid.contains(".")) {
        CustomerFactory.eiupdate(cEid, cId);
        System.out.println("\nSuccessfully updated the Email Id\n");
        break;
      } else {
        System.out.println("You have entered an Invalid Email Id");
        break;
      }
    }
  }
/**
 * to update cust Password.
 */
  private void updatePasswrd() {
    Customer[] cust = CustomerFactory.showitem();
    System.out.println("Enter the New Email Id");
    String cEid = option.next();
    System.out.println("Enter the New Password (Should contain A-Z/a-z and 0-9)");
    String pwd = option.next();
    int j = pwd.length();
    for (Customer c : cust) {
      if (pwd.equals(c.getpasswrd())) {
        System.out.println("You have entered the old Password");
        break;
      } else if (j >= 8 && pwd.matches("^[a-zA-Z0-9]*$")) {
        CustomerFactory.pwdupdate(pwd, cEid);
        System.out.println("\nSuccessfully updated the Password\n");
        break;
      } else {
        System.out.println("Your password does not match with the given condition");
        break;
      }
    }
  }
/**
 * to update cust Address.
 */
  private void updateAddress() {
    Customer[] cust = CustomerFactory.showitem();
    System.out.println("Enter the New Email Id");
    String cEid = option.next();
    System.out.println("Enter the New Address");
    option.nextLine();
    String cAdd = option.nextLine();
    for (Customer c : cust) {
      if (cAdd.equals(c.getcustAddress())) {
        System.out.println("You have entered the old Address");
        break;
      } else {
        CustomerFactory.addupdate(cAdd, cEid);
        System.out.println("\nSuccessfully updated the Address\n");
        break;
      }
    }
  }
/**
 * to Delete cust Account.
 */
  private void deleteCustAcc() {
    System.out.println("Enter the Email Id");
    String cEid = option.next();
    System.out.println("Enter the Password");
    String pwd = option.next();
    Customer[] cust = CustomerFactory.showitem();
    for (Customer c : cust) {
      if (cEid.equals(c.getcustEmailid()) && pwd.equals(c.getpasswrd())) {
        CustomerFactory.accdelete(cEid, pwd);
        System.out.println("Your Account has been Deleted");
        break;
      } else {
        System.out.println("\nWrong EmailId or Password Entered\n");
        break;
      }
    }
  }
 /**
  * to Delete Item item.
  */
  private void deleteItemname() {
    System.out.println("Enter the Item Id");
    int fdid = option.nextInt();
    item[] item = itemFactory.showitem();
    for (item m : item) {
      if (fdid == m.getItemId()) {
        itemFactory.fdnmDelete(fdid);
        System.out.println("Item item has been Deleted");
        break;
      }
    }
  }
/**
 * to add reviews.
 */
  private void addNewReviews() {
    int revId = 0;
    Reviews[] reviews = ReviewsFactory.showReviews();
    for (Reviews r : reviews) {
      revId = r.getreviewsId();
    }
    revId++;
    System.out.println("Enter the comments about the dish or order or vendor:");
    option.nextLine();
    String cmnts = option.nextLine();
    System.out.println("Enter the ratings you want to give out of 5:");
    int rts = option.nextInt();
    int custId = 0;
    Customer[] cust = CustomerFactory.showitem();
    for (Customer c : cust) {
      custId = c.getcustId();
    }
    System.out.println("Enter the Item Vendor Id:");
    int itId = option.nextInt();
    System.out.println("Enter the Item Id:");
    int fdId = option.nextInt();
    System.out.println("Enter Item Name");
    option.nextLine();
    String ItemName = option.nextLine();
    ReviewsFactory.addRev(revId, cmnts, rts, custId, itId, fdId, ItemName);
  }
/**
 * to delete reviews.
 */
  private void deleteReviews() {
    System.out.println("Enter Review Id");
    int revId = option.nextInt();
    System.out.println("Enter the Customer Id");
    int custId = option.nextInt();
    Reviews[] reviews = ReviewsFactory.showReviews();
    for (Reviews r : reviews) {
      if (revId == r.getreviewsId() && custId == r.getcustId()) {
        ReviewsFactory.delRev(revId, custId);
        System.out.println("Your Review has been Deleted");
        break;
      } else {
        System.out.println("\nWrong Review Id or Customer Id Entered\n");
        break;
      }
    }
  }
/**
 * to update Itemname.
 */
  private void updateItemname() {
    int fdid = 0;
    item[] item = itemFactory.showitem();
    System.out.println("Enter Item ID for Item you want to update: ");
    fdid = option.nextInt();
    System.out.println("Enter the new Item Name");
    option.nextLine();
    String fdname = option.nextLine();
    for (item m : item) {
      if (fdname.equals(m.getItemName())) {
        System.out.println("You've entered previous name!");
        break;
      } else {
        itemFactory.ItemnameUpdate(fdname, fdid);
        System.out.println("\nItem Name updated successfully\n");
        break;
      }
    }
  }
/**
 * to update Availability.
 */
  private void updateAvailability() {
    int fdid = 0;
    item[] item = itemFactory.showitem();
    System.out.println("Enter Item ID for Item you want to update: ");
    fdid = option.nextInt();
    System.out.println("Enter the availability");
    String avail = option.next();
    for (item m : item) {
      if (avail.equals(m.getavailability())) {
        System.out.println("You've entered previous availability!");
        break;
      } else {
        itemFactory.availabilityUpdate(avail, fdid);
        System.out.println("\nAvailability updated successfully\n");
        break;
      }
    }
  }
/**
 * to update Itemcost.
 */
  private void updateItemcost() {
    int fdid = 0;
    item[] item = itemFactory.showitem();
    System.out.println("Enter Item ID for Item you want to update: ");
    fdid = option.nextInt();
    System.out.println("Enter the new Item Cost");
    int fdcost = option.nextInt();
    for (item m : item) {
      if (fdcost == m.getItemCost()) {
        System.out.println("You've entered previous cost!");
        break;
      } else {
        itemFactory.ItemcostUpdate(fdcost, fdid);
        System.out.println("\ncost updated successfully\n");
        break;
      }
    }
  }
/**
 * updateitem.
 */
  private void updateitem() {
    int fdId = 0;
    item[] item = itemFactory.showitem();
    for (item m : item) {
      fdId = m.getItemId();
    }
    fdId++;
    System.out.print("Enter Item name:");
    option.nextLine();
    String fdname = option.nextLine();
    System.out.print("Enter Item type:");
    String fdtype = option.next();
    System.out.print("Enter cuisine:");
    String cuisne = option.next();
    System.out.print("Enter availability:");
    String avail = option.next();
    System.out.print("Enter vendor id:");
    int venid = option.nextInt();
    System.out.print("Enter Item cost:");
    int fdcost = option.nextInt();
    itemFactory.updateditem(fdId, fdname, fdtype, cuisne, avail, venid, fdcost);
    System.out.println("\nNew Item Item added Successfully!!\n");
  }
/**
 * updateCoupon.
 */
  private void updateCoupon() {
    int cpnId = 0;
    Coupon[] coupon = CouponFactory.showitem();
    for (Coupon c : coupon) {
      cpnId = c.getcouponId();
    }
    cpnId++;
    System.out.print("Enter Coupon Code:");
    String cpnCode = option.next();
    System.out.print("Enter Customer ID:");
    int cstId = option.nextInt();
    System.out.print("Enter Order ID:");
    int ordrId = option.nextInt();
    CouponFactory.updatedCoupon(cpnId, cpnCode, cstId, ordrId);
    System.out.println("\nNew Coupon added Successfully!!\n");
  }
/**
 * to update vendorPhoneNumber.
 */
  private void updatephNo() {
    String emailId = " ";
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    for (ItemVendor c : Itemvendor) {
      emailId = c.getvendorEmailId();
    }
    System.out.println("Enter the new Phone Number");
    long phNo = option.nextLong();
    ItemVendorFactory.phupdate(phNo, emailId);
    System.out.println("\nPhone Number updated successfully\n");
  }
/**
 * to update vendorEmailId.
 */
  private void updateEid() {
    long phNo = 0;
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    for (ItemVendor c : Itemvendor) {
      phNo = c.getvendorPhoneno();
    }
    System.out.println("Enter the new Email Id");
    String emailId = option.next();
    ItemVendorFactory.eiupdate(emailId, phNo);
    System.out.println("\nEmail Id updated successfully\n");
  }
/**
 * to update vendorPassword.
 */
  private void updatepwd() {
    long phNo = 0;
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    for (ItemVendor c : Itemvendor) {
      phNo = c.getvendorPhoneno();
    }
    System.out.println("Enter the new Password");
    String pwd = option.next();
    ItemVendorFactory.pwdupdate(pwd, phNo);
    System.out.println("\nPassword updated successfully\n");
  }
/**
 * to update Couponcode.
 * to delete vendor Account.
 */
  private void deleteAccount() {
    System.out.println("Enter the Email Id");
    String emailId = option.next();
    System.out.println("Enter the Password");
    String pwd = option.next();
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    for (ItemVendor c : Itemvendor) {
      if (emailId.equals(c.getvendorEmailId()) && pwd.equals(c.getpwd())) {
        ItemVendorFactory.accdelete(emailId, pwd);
        System.out.println("Your Account has been deleted");
        break;
      } else {
        System.out.println("\nWrong EmailId or Password entered\n");
        break;
      }
    }
  }
/**
 * updateCoupon.
 */
  private void updateCouponcode() {
    int cpnId = 0;
    Coupon[] coupon = CouponFactory.showitem();
    System.out.println("Enter Coupon ID for coupon you want to update: ");
    cpnId = option.nextInt();
    System.out.println("Enter the new Coupon Code");
    String cpnCode = option.next();
    for (Coupon c : coupon) {
      if (cpnCode.equals(c.getcouponCode())) {
        System.out.println("You've entered previous code!");
        break;
      } else {
        CouponFactory.couponcodeUpdate(cpnCode, cpnId);
        System.out.println("\nCoupon Code updated successfully\n");
        break;
      }
    }
  }
/**
 * to choose Item type.
 */
  private void chooseItemtype() {
    System.out.println("Enter the Item Type");
    String fdtype = option.next();
    item[] item = itemFactory.showitem();
    System.out.println("ItemId ItemName ItemType cuisine availability vendorId ItemCost");
    for (item m : item) {
      if (fdtype.equals(m.getItemType())) {
        System.out.println(m.getItemId() + "      " + m.getItemName() + "    " + m.getItemType() + "    " + m.getcuisine()
               + "    " + m.getavailability() + "       " + m.getvendorId() + "        "  + m.getItemCost());
      }
    }
    System.out.println("Item type has been selected.");
  }
/**
 * to show wallet item to customer.
 */
  private void walletitem(final String name, final int custid) {
    System.out.print("Enter your Choice \n1. Add money \n2. Update Bank details \n3. Go back \n");
    int choice = option.nextInt();
    switch (choice) {
      case 1: System.out.print("Enter the amount = ");
        int amt = option.nextInt();
        System.out.print(WalletFactory.refund(custid, amt) + "\n");
        customeritem(name, custid);
        break;
      case 2: System.out.print("Enter the bank account no. = ");
        int accno = option.nextInt();
        System.out.println(WalletFactory.updateBank(accno, custid));
        break;
      case 3:customeritem(name, custid);
        break;
      default: System.out.println("Wrong Choice!");
        customeritem(name, custid);
        break;
    }
  }
/**
 * showFullitem method  display the item item stored in database.
 */
  private void showFullitem() {
    item[] item = itemFactory.showitem();
    System.out.println("ItemId ItemName ItemType cuisine availability vendorId ItemCost");
    for (item m : item) {
      System.out.println(m.getItemId() + "      " + m.getItemName() + "    " + m.getItemType() + "    " + m.getcuisine()
             + "    " + m.getavailability() + "       " + m.getvendorId() + "        "  + m.getItemCost());
    }
  }
/**
 * showProfile method to display customer Profile.
 */
  private void showCustProfile(final int custId) {
    Customer[] cust = CustomerFactory.showitem();
    for (Customer c : cust) {
      if (c.getcustId() == custId) {
        System.out.println("\nYour unique id is = " + c.getcustId());
        System.out.println("Name = " + c.getcustName());
        System.out.println("Phone No = " + c.getcustPhno());
        System.out.println("Email Id = " + c.getcustEmailid());
        System.out.println("Password = " + c.getpasswrd());
        System.out.println("Address = " + c.getcustAddress());
      }
    }
  }
/**
 * showFullCustomer method  display the customer item stored in database.
 */
  private void orderItem(final String name, final int custid) {
    item[] item = itemFactory.showitem();
    System.out.println("\nHello " + name + ", what are you craving for? \n");
    System.out.println("Order from our vast item : -");
    System.out.println("-----------------------------");
    System.out.println("ItemId ItemName ItemType cuisine availability vendorId ItemCost");
    for (item m : item) {
      System.out.println(m.getItemId() + "      " + m.getItemName() + "    " + m.getItemType() + "    " + m.getcuisine()
             + "    " + m.getavailability() + "       " + m.getvendorId() + "        "  + m.getItemCost());
    }
    System.out.println("\nTo place order please enter the following details -");
    System.out.print("\nEnter the number of items you want to order = ");
    int size = option.nextInt();
    System.out.println("Do you want to apply a coupon code? \n1. Yes \n2. No");
    int cc = option.nextInt();
    int discount = 0;
    switch (cc) {
      case 1:
        System.out.print("Enter coupon id = ");
        int couponid = option.nextInt();
        Coupon[] coupon = CouponFactory.showitem();
        int counter = 0;
        for (Coupon c : coupon) {
          if (couponid == c.getcouponId()) {
            System.out.println("Coupon Applied!");
            discount = 100 / size;
            counter++;
          }
        }
        if (counter == 0) {
          System.out.println("Invalid Coupon id!!!");
        }
        break;
      default:
        break;
    }
    for (int i = 0; i < size; i++) {
      System.out.print("Enter the Item ID of Item you want to order = ");
      int ItemId = option.nextInt();
      System.out.print("Enter the vendor ID of Item you want to order = ");
      int vendorId = option.nextInt();
      System.out.println("Enter the quantity");
      int qty = option.nextInt();
      String ItemName = " ";
      OrderLog[] order = OrderLogFactory.showOrderLog();
      int orderId = 0;
      for (OrderLog o : order) {
        orderId = o.getorderId();
      }
      orderId++;
      Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
      int orderstatusId = 0;
      for (Orderstatus o : orderstatus) {
        orderstatusId = o.getid();
      }
      orderstatusId++;
      for (item m : item) {
        if (m.getItemId() == ItemId) {
          ItemName = m.getItemName();
        }
      }
      boolean b = true;
      int walletBalance = 0;
      Wallet[] wallet = WalletFactory.showWallet();
      for (Wallet w : wallet) {
        if (w.getcustId() == custid) {
          walletBalance = w.getbalance();
          break;
        }
      }
      for (item c : item) {
        if (ItemId == c.getItemId() && vendorId == c.getvendorId()) {
          int total = qty * c.getItemCost();
          total = total - discount;
          System.out.println("Your wallet balance is = " + walletBalance + "Rs.");
          System.out.print("Your order Total is = " + total + "Rs.\n");
          if (walletBalance > total) {
            walletBalance = walletBalance - total;
            WalletFactory.order(custid, total);
            System.out.println("Remaining balance = " + walletBalance + "Rs. \n");
            OrderLogFactory.placeOrder(orderId, custid, ItemId, ItemName, vendorId, total);
            OrderstatusFactory.placeOrder(orderstatusId, orderId, vendorId, custid, qty);
            System.out.println(qty + " " + c.getItemName() + " On the way");
            System.out.println("\nOrder Placed!");
            b = false;
            break;
          } else {
            System.out.println("Insufficient Balance! Please topup your wallet to continue ordering.");
            break;
          }
        }
      }
      if (b) {
        System.out.println("Invalid Entry!");
      }
    }
    System.out.println("Tip: - You can track your orders from Your Orders Section.");
    customeritem(name, custid);
  }
/**
 * to show options for an order.
 */
  private void showOrderOptions(final String name, final int custid) {
    System.out.println("\nRecent orders.");
    showcustOrderstatus(custid);
    System.out.println("\nAll orders.");
    showcustOrderLog(custid);
    System.out.println("\nOrder Options");
    System.out.println("------------------");
    System.out.println("1. Cancel Order \n2. Go Back");
    int op = option.nextInt();
    switch (op) {
      case 1:  System.out.print("Enter the orderId = ");
        int oid = option.nextInt();
        cancelOrder(oid, custid);
        showOrderOptions(name, custid);
        break;
      case 2: customeritem(name, custid);
        break;
      default:
        System.out.println("Wrong Entry!!");
        showOrderOptions(name, custid);
        break;
    }
  }
/**
 * to cancel order.
 * @param oid to pass orderid.
 * @param custid to pass custid.
 */
  public final void cancelOrder(final int oid, final int custid) {
    int refund = 0;
    int orderid = 0;
    OrderLog[] order = OrderLogFactory.showOrderLog();
    for (OrderLog m : order) {
      if (oid == m.getorderId()) {
        refund = m.gettotalCost();
      }
      orderid = m.getorderId();
    }
    String status = " ";
    Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    for (Orderstatus o : orderstatus) {
      if (oid == o.getorderId()) {
        status = o.getorderstatus();
      }
    }
    if (oid <= orderid && !"cancelled".equals(status) && !"Order Rejected".equals(status)) {
      System.out.println(OrderstatusFactory.cancelOrder(oid));
      Wallet[] wallet = WalletFactory.showWallet();
      for (Wallet m : wallet) {
        if (m.getcustId() == custid) {
          refund = refund + m.getbalance();
        }
      }
      WalletFactory.refund(custid, refund);
      System.out.println("Refund initiated. Amount will soon be added to your wallet");
    } else {
      System.out.println("Order not found or already cancelled!");
    }
  }
/**
 * manageOrders function for managing and updating order details by vendor.
 */
  private void manageOrders(final String name, final int vid) {
    System.out.println("\nRecent orders.");
    showVendorOrderstatus(vid);
    System.out.println("\nAll orders.");
    showVendorOrderLog(vid);
    System.out.println("Managing Orders");
    System.out.println("-----------------");
    System.out.println("1. For status update \n2. Go Back");
    int choice = option.nextInt();
    switch (choice) {
      case 1:
        statusUpdate(name, vid);
        break;
      case 2:
        vendoritem(name, vid);
        break;
      default:
        System.out.println("Wrong Entry!!");
        manageOrders(name, vid);
        break;
    }
  }
/**
 * statusUpdate to update status.
 */
  private void statusUpdate(final String name, final int vid) {
    System.out.print("Enter the order id = ");
    int oid = option.nextInt();
    Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    String status = "";
    for (Orderstatus o : orderstatus) {
      status = o.getorderstatus();
    }
    if (!"cancelled".equals(status)) {
      System.out.println("Select \n1. Accept \n2. Being prepared \n3. Out for Delivery \n4. Reject");
      int c = option.nextInt();
      int e = 0;
      String eta = " ";
      switch (c) {
        case 1:
          System.out.print("Enter ETA in min = ");
          e = option.nextInt();
          eta = Integer.toString(e) + " min";
          System.out.println(OrderstatusFactory.updateOrder(oid, eta, "Order Accepted"));
          manageOrders(name, vid);
          break;
        case 2:
          System.out.print("Enter ETA in min = ");
          e = option.nextInt();
          eta = Integer.toString(e) + " min";
          System.out.println(OrderstatusFactory.updateOrder(oid, eta, "Being Prepared"));
          manageOrders(name, vid);
          break;
        case 3:
          System.out.print("Enter ETA in min = ");
          e = option.nextInt();
          eta = Integer.toString(e) + " min";
          System.out.println(OrderstatusFactory.updateOrder(oid, eta, "Out for Delivery!"));
          manageOrders(name, vid);
          break;
        case 4:
          int custid = 0;
          int refund = 0;
          OrderLog[] order = OrderLogFactory.showOrderLog();
          for (OrderLog m : order) {
            if (oid == m.getorderId()) {
              custid = m.getcustId();
              refund = m.gettotalCost();
            }
          }
          System.out.println(OrderstatusFactory.updateOrder(oid, "    ", "Order Rejected"));
          System.out.println(WalletFactory.refund(custid, refund));
          manageOrders(name, vid);
          break;
        default:
          System.out.println("Wrong choice!");
          manageOrders(name, vid);
          break;
      }
    } else {
      System.out.println("Order cancelled by the user.");
      manageOrders(name, vid);
    }
  }
/**
 * showFullOrderLog method display the Order Log stored in database.
 */
  private void showVendorOrderLog(final int vendorid) {
    OrderLog[] order = OrderLogFactory.showOrderLog();
    System.out.println("orderId    customerId     ItemID   ItemName    vendorId    totalCost    orderDate");
    for (OrderLog m : order) {
      if (vendorid == m.getvendorId()) {
        System.out.println(m.getorderId() + "          " + m.getcustId() + "              " + m.getItemId() + "        " + m.getItemName()
               + "     " + m.getvendorId() + "           " + m.gettotalCost() + "          "  + m.getorderDate());
      }
    }
  }
/**
 * showFullOrderLog method display the Order Log stored in database.
 */
  private void showcustOrderLog(final int custid) {
    OrderLog[] order = OrderLogFactory.showOrderLog();
    System.out.println("orderId    customerId     ItemID   ItemName    vendorId    totalCost    orderDate");
    for (OrderLog m : order) {
      if (custid == m.getcustId()) {
        System.out.println(m.getorderId() + "          " + m.getcustId() + "              " + m.getItemId() + "        " + m.getItemName()
               + "     " + m.getvendorId() + "           " + m.gettotalCost() + "          "  + m.getorderDate());
      }
    }
  }
  /**
 * showFullOrderstatus method  display the item item stored in database.
 */
  private void showVendorOrderstatus(final int vendorid) {
    Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    System.out.println("Id   OrderId    ETA     OrderStatus    VendorId  CustId  Quantity");
    for (Orderstatus o : orderstatus) {
      if (vendorid == o.getItemVendorId()) {
        System.out.println(o.getid() + "      " + o.getorderId() + "    " + o.geteta() + "   " + o.getorderstatus() + "    " + o.getItemVendorId()
              + "       " + o.getcustId() + "       " + o.getquantity());
      }
    }
  }
/**
 * Show customerspecific orders.
 */
  private void showcustOrderstatus(final int custid) {
    Orderstatus[] orderstatus = OrderstatusFactory.showOrderstatus();
    System.out.println("Id   OrderId    ETA     OrderStatus    VendorId  CustId  Quantity");
    for (Orderstatus o : orderstatus) {
      if (custid == o.getcustId()) {
        System.out.println(o.getid() + "      " + o.getorderId() + "    " + o.geteta() + "   " + o.getorderstatus() + "    " + o.getItemVendorId()
              + "       " + o.getcustId() + "       " + o.getquantity());
      }
    }
  }
  /**
 * showFullitem method  display the Itemvendor item stored in database.
 */
  private void showVendorProfile(final int vendorid) {
    ItemVendor[] Itemvendor = ItemVendorFactory.showitem();
    for (ItemVendor c : Itemvendor) {
      if (c.getItemVendorId() == vendorid) {
        System.out.println("\nYour unique id = " + c.getItemVendorId());
        System.out.println("Name = " + c.getvendorName());
        System.out.println("Phone No. = " + c.getvendorPhoneno());
        System.out.println("Email Id = " + c.getvendorEmailId());
        System.out.println("Your Password " + c.getpwd());
      }
    }
  }
  /**
 * showFullWallet method  display the item item stored in database.
 */
  private void showFullWallet(final int custId) {
    Wallet[] wallet = WalletFactory.showWallet();
    System.out.println("walletId custId balance    bankaccNo");
    for (Wallet m : wallet) {
      if (m.getcustId() == custId) {
        System.out.println(m.getwalletId() + "      " + m.getcustId() + "    " + m.getbalance() + "    " + m.getbankaccNo());
      }
    }
  }
/**
 * showFullCoupon method  display the item item stored in database.
 */
  private void showFullCoupon() {
    Coupon[] coupon = CouponFactory.showitem();
    System.out.println("couponId   couponCode   custId   orderId");
    for (Coupon c : coupon) {
      System.out.println(c.getcouponId() + "          " + c.getcouponCode() + "      " + c.getcustId() + "      " + c.getorderId());
    }
  }
  /**
 * showFullReviews method  display the item item stored in database.
 */
  private void showFullReviews() {
    Reviews[] reviews = ReviewsFactory.showReviews();
    System.out.println("ReviewId     Comments                Ratings  CustId  VendorId  ItemId");
    for (Reviews r : reviews) {
      System.out.println(r.getreviewsId() + "         " + r.getcomments() + "      " + r.getratings() + "      " + r.getcustId() + "     "
               + r.getItemVendorId() + "          " + r.getItemId());
    }
  }
  /**
   * @param str for storing mykey.
   * @return null.
   */
  public static String encrypt(final String str) {
    String generatedPassword = null;
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(str.getBytes());
      byte[] bytes = md.digest();
      StringBuilder sb = new StringBuilder();
      for (int i = 0; i < bytes.length; i++) {
        sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
      }
      generatedPassword = sb.toString();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return generatedPassword;
  }
  /**
   * @param receipent for storing mykey.
   * @param subject for subject.
   * @param text for text.
   */
  public static void sendMail(final String receipent, final String subject, final String text) {
    String sender = "cravingsmlp290@gmail.com";
    Properties prop = System.getProperties();
    prop.setProperty("mail.transport.protocol", "smtp");
    prop.setProperty("mail.smtp.host", "smtp.gmail.com");
    prop.setProperty("mail.smtp.port", "587");
    prop.setProperty("mail.smtp.user", "cravingsmlp290@gmail.com");
    prop.setProperty("mail.smtp.password", "cms12345");
    prop.setProperty("mail.smtp.starttls.enable", "true");
    prop.setProperty("mail.smtp.auth", "true");
    Session session = Session.getDefaultInstance(prop, new javax.mail.Authenticator() {
      protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("cravingsmlp290@gmail.com", "cms12345");
        } });
    try {
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(sender));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(receipent));
      message.setSubject(subject);
      message.setContent(
              "<h1>This is actual message embedded in HTML tags</h1>",
             "text/html");
      message.setText(text);
      Transport.send(message);
      System.out.println("Mail successfully sent");
    } catch (MessagingException mex) {
      mex.printStackTrace();
    }
  }
/**
 * main method is the basic entry point for the application.
 * @param args used to get the user input.
 */
  public static void main(final String[] args) {
    final CliMain mainObj = new CliMain();
    mainObj.loginOption();
  }
}
