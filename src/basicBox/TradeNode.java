package basicBox;


/**
 * 
 * This holds details of a pending stock trade and is stored in a 
 * queue until execution
 * 
 * @author saidJhofiani
 *
 */

public class TradeNode {

		public String stockSymbol;
		public int shareCount;
		public boolean buy;
		public TradeNode nextTradeNode;
		
		public TradeNode() {}
		
		public TradeNode(String stockSymbol, int shareCount, boolean buy){
			this.stockSymbol = stockSymbol;
			this.shareCount = shareCount;
			this.buy = buy;
		
		}
		
}
