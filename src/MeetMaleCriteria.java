import java.util.ArrayList;
import java.util.List;

public class MeetMaleCriteria implements Criteria {
    @Override
    public List<Advertiser> meetCriteria(List<Advertiser> allAdvertisers) {
        List<Advertiser> allMales = new ArrayList<>();
        for(Advertiser ad: allAdvertisers){
           for (AdvertiserTarget at: ad.getAttributes()){
               if (!at.getGender().equalsIgnoreCase("") && at.getGender().equalsIgnoreCase("male")){
                   allMales.add(ad);
               } else {
                   continue;
               }
           }
        }
        return allMales;
    }
}
