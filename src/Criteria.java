import java.util.List;

public interface Criteria {
    List<Advertiser> meetCriteria(List<Advertiser> allAdvertisers);
}
