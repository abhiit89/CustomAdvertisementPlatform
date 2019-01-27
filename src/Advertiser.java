import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Advertiser {
    static List<Advertiser> advertiserList = new ArrayList<>();
    String name;
    int bid;
    String id;
    String adString;
    List<AdvertiserTarget>attributes;

    Advertiser(){ }

    public void setId(){
        this.id = this.name + ":" + this.adString;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public String getAdString() {
        return adString;
    }

    public void setAdString(String adString) {
        this.adString = adString.replaceAll("\\s+","");
    }

    public List<AdvertiserTarget> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AdvertiserTarget> attributes) {
        this.attributes = attributes;
    }

    public static void onBoardAdvertiser(Advertiser newAdvertiser){
        advertiserList.add(newAdvertiser);
    }

    public static void printListOfAdvertisers() {
        for (Advertiser ad : advertiserList) {
            System.out.println(ad.getName() + " has a budget of " + ad.getBid() + " for showing ads for attributes to user with criteria as follow");
            for (AdvertiserTarget targetAttr : ad.getAttributes()) {
                System.out.println(targetAttr.getGender() + " : " + targetAttr.getAgeRange());
            }
        }
    }

    public static void showAd(String userGender, String userAge) {
        MeetAgeAndGenderCriteria genderAgeCriteria = new MeetAgeAndGenderCriteria(userAge,userGender);
        List<Advertiser> meetingTheCriteria = genderAgeCriteria.meetCriteria(Advertiser.advertiserList);
        if (Advertiser.advertiserList.size() > 0 && meetingTheCriteria.size() > 0) {
            Collections.sort(meetingTheCriteria, new BidComparator());
            System.out.println("Advertisement show will be");
            System.out.println(meetingTheCriteria.get(0).getAdString());
            if(meetingTheCriteria.size() < 2){
                chargedPrice(meetingTheCriteria.get(0),null);
            } else {
                chargedPrice(meetingTheCriteria.get(0),meetingTheCriteria.get(1));
            }
        } else {
            System.out.println("No Advertisement will be shown ");
        }
    }

    public static void chargedPrice(Advertiser adOne, Advertiser adTwo){
        System.out.println("Price charged to the advertiser will be");
        int minPrice;
        if (adTwo != null){
            minPrice = adTwo.getBid();
        } else {
            minPrice = adOne.getBid();
        }
        System.out.println("Advertiser paid " + minPrice);
    }

}
