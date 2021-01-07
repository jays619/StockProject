package basicBox;


/**
 * 
 * This manages the pending trade nodes in a queue for the StockMarketSim class
 * 
 * @author saidJhofiani
 *
 */
public class TradeQueue {
	
	

	public TradeNode headTradeNode;
	public TradeNode tailTradeNode;
	
	
	public void enqueue(String sStockSymbol, int iPurchaseShareCount, boolean bBuy){
		TradeNode obj = new TradeNode(sStockSymbol,iPurchaseShareCount,bBuy );
		if(headTradeNode == null){
			headTradeNode = obj;
			tailTradeNode = obj;
			
		}
		else {
			
			tailTradeNode.nextTradeNode = obj;
			tailTradeNode = obj;
			
		}
		
	}
	
	/*
	 * This returns the head TradeNode (the next in line) and makes the second in 
	 * the queue now the first in line.
	 * 
	 */
	public TradeNode dequeue(){
	
		if(headTradeNode == null){
			return null;
		}
		else {
			TradeNode oTemp = headTradeNode;
			headTradeNode = headTradeNode.nextTradeNode;
			return oTemp;
		}
		
	}
	
}
