import java.util.ArrayList;
import java.util.List;

public class MeetAgeCriteria implements Criteria {

    public String age;

    MeetAgeCriteria(String age) {
        this.age = age;
    }


    @Override
    public List<Advertiser> meetCriteria(List<Advertiser> allAdvertisers) {
        List<Advertiser> ageCriteria = new ArrayList<>();
        for (Advertiser ad : allAdvertisers) {
            for (AdvertiserTarget at : ad.getAttributes()) {
                if (!this.age.contains("_") && !at.getAgeRange().contains("-") && Integer.parseInt(at.getAgeRange()) == Integer.parseInt(this.age)) {
                    ageCriteria.add(ad);
                } else {
                    if (this.age.contains("-") && !at.getAgeRange().contains("-")) {
                        String[] ageRange = this.age.split("-");
                        if (Integer.parseInt(ageRange[0]) > 0 && Integer.parseInt(ageRange[1]) > 0
                                && Integer.parseInt(ageRange[0]) == Integer.parseInt(at.getAgeRange())
                                || Integer.parseInt(ageRange[1]) == Integer.parseInt(at.getAgeRange())) {
                            ageCriteria.add(ad);
                        }
                    } else {
                        if (!this.age.contains("-") && at.getAgeRange().contains("-")) {
                            String[] ageRange = at.getAgeRange().split("-");
                            if (Integer.parseInt(ageRange[0]) > 0 && Integer.parseInt(ageRange[1]) > 0
                                    && Integer.parseInt(ageRange[0]) == Integer.parseInt(this.age)
                                    || Integer.parseInt(ageRange[1]) == Integer.parseInt(this.age)) {
                                ageCriteria.add(ad);
                            }
                        } else {
                            if (this.age.contains("-") && at.getAgeRange().contains("-")) {
                                String[] ageRangeFromAd = at.getAgeRange().split("-");
                                String[] ageRangeFromUser = this.age.split("-");
                                if (Integer.parseInt(ageRangeFromAd[0]) > 0 && Integer.parseInt(ageRangeFromAd[1]) > 0
                                        && Integer.parseInt(ageRangeFromUser[0]) >= 0 && Integer.parseInt(ageRangeFromUser[1]) > 0
                                        && Integer.parseInt(ageRangeFromUser[0]) < Integer.parseInt(ageRangeFromAd[0]) &&
                                        Integer.parseInt(ageRangeFromUser[1]) <= Integer.parseInt(ageRangeFromAd[1])
                                ) {
                                    ageCriteria.add(ad);
                                }
                            }
                        }
                    }
                }

            }
        }
        return ageCriteria;
    }
}
