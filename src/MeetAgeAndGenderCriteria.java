import java.util.List;

public class MeetAgeAndGenderCriteria  implements Criteria{

    public String age;


    public void setAge(String age) {
        this.age = age.trim();
    }

    public void setGender(String gender) {
        this.gender = gender.trim();
    }

    public String gender;

    MeetAgeAndGenderCriteria(String age, String gender){
        this.setAge(age);
        this.setGender(gender);
    }

    @Override
    public List<Advertiser> meetCriteria(List<Advertiser> allAdvertisers) {
        List<Advertiser> finalListOfAdvertisers;
        if(this.gender.equalsIgnoreCase("male")){
            finalListOfAdvertisers = new MeetMaleCriteria().meetCriteria(allAdvertisers);
        } else {
            finalListOfAdvertisers = new MeetFemaleCriteria().meetCriteria(allAdvertisers);
        }
        finalListOfAdvertisers = new MeetAgeCriteria(this.age).meetCriteria(finalListOfAdvertisers);
        return finalListOfAdvertisers;
    }
}
