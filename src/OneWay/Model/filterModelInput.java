package OneWay.Model;

public class filterModelInput {
	public String From;
    public String To;
    public String DepartureDate;

    public static filterModelInput createNew(String from, String to, String departureDate) {
    	filterModelInput data = new filterModelInput();
    	data.From = from;
    	data.To = to;
    	data.DepartureDate = departureDate;
        return data;
    }
}
