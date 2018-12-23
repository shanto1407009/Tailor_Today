package today.tailor.tt;

/**
 * Created by Shanto on 2/4/2018.
 */

public class Individual {
    public String ID;
    public String Availability;
    public String Price;
    public String Folder;


    public Individual()
    {

    }

    public Individual(String ID, String availability, String price, String folder) {
        this.ID = ID;
        Availability = availability;
        Price = price;
        Folder = folder;
    }
}
