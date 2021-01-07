package basicBox;

import java.security.SecureRandom;
import java.util.Random;



public class StockEngine {
	
	Random random;
	Stock s1; 
	Stock s2; 
	Stock s3; 
	
	Stock[] stocks;
	
	public StockEngine() {
		random = new Random();
		s1 = new Stock("APPL", random.nextInt(1000));
		s2 = new Stock("INTU", random.nextInt(1000));
		s3 = new Stock("GOOG", random.nextInt(1000)); 
		stocks = new Stock[]{s1,s2,s3};
	}
	
	/*
	 * This goes through each stock in the array and adjusts the price due to a random number algorithm.
	 * 
	 * a.	Adjusts each stock in array using nextInt method on random object that limits moves to 3 or under.
	 * 
	 * 			i.	Algorithm for creating random up or down will be reviewed in class.
	 * 					1.	This algorithm must make it more likely for stock to go the same way (up or down) as the 
	 * 						last move it made (stored in lastMoveUp).  This allows for a stock to trend, rather than 
	 * 						completely switching up to down and back every turn and not moving very much.
	 * 
	 */
	public void cycleTurn() {
		
		int iTemp;
		
		for(Stock stock : stocks) {
			
			int current = stock.getPricePerShare();
			iTemp = getNewStockPrice(stock.getPricePerShare(), stock.isLastMoveUp());
			stock.setPricePerShare(iTemp);
			
			if( current > iTemp ) {
				stock.setLastMoveUp(true);
			} else if ( current < iTemp){
				stock.setLastMoveUp(false);
			}
			
			System.out.println(stock);
		}
		
	}
	
    // Pass back stock amount
    public int getNewStockPrice(int iCurrentPrice, boolean LastMoveUp){
        
        int iStockMoveLimit = 3;
        int iStockMove;
        int iTrendChance = 70;
        SecureRandom oRand = new SecureRandom();
        
        iStockMove = oRand.nextInt(iStockMoveLimit + 1);
        
        //Figure out if trend continues or not
        //Continue Trend
        if(oRand.nextInt(101) < iTrendChance){
            
            //only need to change to negative if previous move was negative
            if(!LastMoveUp){
            iStockMove = -1*iStockMove;
            }
        }
        //reverse trend
        else {
            
            //only need to change to negative if previous move was positive
            if(LastMoveUp){
              iStockMove = -1*iStockMove;  
            }
        }
        
        
        return iCurrentPrice + iStockMove;
    }
	
}


/*
 *
    public static void main(String[] args) {
     
     Stockadj obj = new Stockadj();
     int iStockPrice = 50;
     boolean bUp = true;
     int itemp;
     
     for(int x = 0 ; x<30; x++){   
        itemp = obj.getNewStockPrice(iStockPrice, bUp);
        
        if(itemp > iStockPrice){
            bUp = true;
        }
        else{ bUp = false;
    }
     
        iStockPrice = itemp;
        System.out.println("Price: "+iStockPrice);
    
    }
    
}
*/
