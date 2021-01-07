package basicBox;

import java.security.SecureRandom;

public class Stock {

	private String stockSymbol;
	private int pricePerShare;
	private boolean lastMoveUp;
	
	public Stock() {}
	
	public Stock(String stockSymbol,int pricePerShare, boolean lastMoveUp) {
		this.stockSymbol = stockSymbol;
		this.pricePerShare = pricePerShare;
		this.lastMoveUp = lastMoveUp;
	}
	
	public Stock(String stockSymbol,int pricePerShare) {
		this.stockSymbol = stockSymbol;
		this.pricePerShare = pricePerShare;
	}
	
	public String getStockSymbol() {
		return stockSymbol;
	}
	public void setStockSymbol(String stockSymbol) {
		this.stockSymbol = stockSymbol;
	}
	public int getPricePerShare() {
		return pricePerShare;
	}
	public void setPricePerShare(int pricePerShare) {
		this.pricePerShare = pricePerShare;
	}
	public boolean isLastMoveUp() {
		return lastMoveUp;
	}
	public void setLastMoveUp(boolean lastMoveUp) {
		this.lastMoveUp = lastMoveUp;
	}
	
	
	@Override
	public String toString() {
		return "stockSymbol: "+this.stockSymbol+ " pricePerShare: "+ this.pricePerShare + " lastMoveup: " + this.lastMoveUp;
	}
	
}
