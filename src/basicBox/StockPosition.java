package basicBox;

/**
 * 
 * Keeps track of a stock as far as amount of shares held.
 * 
 * @author saidJhofiani
 *
 */
public class StockPosition {

	String stockSymbol;
	int shareCount;
	
	public void StockPostion(){};
	
	public StockPosition(String stockSymbol, int shareCount){
		this.stockSymbol = stockSymbol;
		this.shareCount = shareCount;
	};
}
