package dasinjava.ood;

//* class for objects that can be sold, packed, and shipped. */
public class BoxedItem implements Sellable, Transportable{
    private String descript;					// description of this photo
	private int price;							// the price we are setting
	private int weight;							// weight in grams
	private boolean haz;						// true if object is hazardous
	@SuppressWarnings("unused")
	private int height=0;						// box height in centimeters
	@SuppressWarnings("unused")
	private int width=0;						// box width in centimeters
	@SuppressWarnings("unused")
	private int depth=0;						// box depth in centimeters
	/** Constructor */
	public BoxedItem(String desc, int p, int w, boolean h) {
		descript = desc;
		price = p;
		weight = w;
		haz = h;
	}
	public String description() {return descript;}
	public int listPrice() {return price;}
	public int lowestPrice() {return price/2;}
	public int weight() {return weight;}
	public boolean isHazardous() {return haz;}
	public int insuredValue() {return price*2;}
	public void setBox(int h, int w, int d) {
		height = h;
		width = w;
		depth = d;
	}
	public static void main(String[] args) {
		BoxedItem b = new BoxedItem("Bag", 500, 400, false);
		b.setBox(100,20,100);
	}
}
