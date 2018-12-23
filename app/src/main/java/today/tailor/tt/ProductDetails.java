package today.tailor.tt;

/**
 * Created by Shanto on 3/9/2018.
 */

public class ProductDetails {
    public String ID;
    public String Availability;
    public String Price;

    public ProductDetails()
    {

    }

    public ProductDetails(String ID, String availability, String price) {
        this.ID = ID;
        Availability = availability;
        Price = price;
    }
}
