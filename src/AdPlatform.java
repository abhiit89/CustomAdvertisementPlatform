import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdPlatform {
    public static void main(String[] args) {
        System.out.println("Welcome to the Customer advertising platform");
        System.out.println("Please Enter your Choice : ");
        Scanner userInput = new Scanner(System.in);
        String userInputString = "";
        while (!userInputString.equalsIgnoreCase("q")) {
            userInputString = userInput.next();
            switch (userInputString){
                case "onboard":
                    System.out.println("On Boarding Advertiser");
                    Advertiser newAd = new Advertiser();
                    AdvertiserTarget targetAttr= new AdvertiserTarget();
                    List<AdvertiserTarget> attrList = new ArrayList<>();
                    System.out.println("Enter Advertiser Name");
                    newAd.setName(userInput.next());
                    System.out.println("Enter Advertiser bid");
                    newAd.setBid(Integer.parseInt(userInput.next()));
                    System.out.println("Enter Advertiser Advertisement String");
                    newAd.setAdString(userInput.nextLine());
                    System.out.println("Enter Advertiser Target Gender (male or female)");
                    targetAttr.setGender(userInput.next());
                    System.out.println("Enter Advertiser Target Age Range (for example 21-32) or 22");
                    targetAttr.setAgeRange(userInput.next());
                    attrList.add(targetAttr);
                    newAd.setAttributes(attrList);
                    Advertiser.onBoardAdvertiser(newAd);
                    Advertiser.printListOfAdvertisers();
                    System.out.println("Please Enter your Choice : ");
                    break;
                case "bidding":
                    System.out.println("Advertiser Bidding starts ");
                    System.out.println("Enter the User Gender (male or female)");
                    String loggedInUserGender = userInput.next();
                    System.out.println("Enter the User Age");
                    String loggedInUserAge = userInput.next();
                    Advertiser.showAd(loggedInUserGender,loggedInUserAge);
                    break;
                default:
                    System.exit(1);
            }
        }
    }
}
