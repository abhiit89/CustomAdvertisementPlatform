import java.util.ArrayList;
import java.util.List;

public class MeetFemaleCriteria implements Criteria {
    @Override
    public List<Advertiser> meetCriteria(List<Advertiser> allAdvertisers) {
        List<Advertiser> allFemales = new ArrayList<>();
        for(Advertiser ad: allAdvertisers){
            for (AdvertiserTarget at: ad.getAttributes()){
                if (!at.getGender().equalsIgnoreCase("") && at.getGender().equalsIgnoreCase("female")){
                    allFemales.add(ad);
                } else {
                    continue;
                }
            }
        }
        return allFemales;
    }
}
