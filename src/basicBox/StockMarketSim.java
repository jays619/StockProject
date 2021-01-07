package basicBox;

import java.util.Scanner;

public class StockMarketSim {

	private TradingAccount ta;
	private TradeQueue tq;
	private StockEngine se;
	Scanner keyboard = new Scanner(System.in);

	public StockMarketSim() {
	};

	// override constructor
	public StockMarketSim(TradingAccount ta, TradeQueue tq, StockEngine se) {
		this.ta = ta;
		this.tq = tq;
		this.se = se;
	}

	public void start() {

		this.ta = new TradingAccount();
		this.tq = new TradeQueue();
		this.se = new StockEngine();

		ta.balance = 10000;

		ta.stockPositions = new StockPosition[3];

		ta.stockPositions[0] = new StockPosition(se.s1.getStockSymbol(), 0);
		ta.stockPositions[1] = new StockPosition(se.s2.getStockSymbol(), 0);
		ta.stockPositions[2] = new StockPosition(se.s3.getStockSymbol(), 0);

		this.tq = new TradeQueue();
		this.se = new StockEngine();

		runUI();

	}

	public void processTrades() {
		TradeNode Temp;
		Stock adjust = new Stock();
		int x = 0;

		while (tq.headTradeNode != null) {
			Temp = tq.dequeue();
			if (Temp.stockSymbol.equals("APPL")) {
				adjust = se.s1;
				x = 0;
			} else if (Temp.stockSymbol.equals("INTU")) {
				adjust = se.s2;
				x = 1;
			} else if (Temp.stockSymbol.equals("GOOG")) {
				adjust = se.s3;
				x = 2;
			}

			if (Temp.buy == true) {

				ta.balance -= adjust.getPricePerShare() * Temp.shareCount;

				ta.stockPositions[x].shareCount += Temp.shareCount;

			} else {
				ta.balance += adjust.getPricePerShare() * Temp.shareCount;
				ta.stockPositions[x].shareCount -= Temp.shareCount;

			}

		}

	}

	// Method called by start()
	public void runUI() {

		String User_R;
		String User_RC;
		String User_Sb;
		int shareAmount;
		boolean buy = true;

		do {
			System.out
					.println("Would you like to see your 1 account status? 2 Or trade Stock? 3 or Cycle the market."
							+ "Or if you're done type exit.");

			User_R = keyboard.next();

			if (User_R.equals("1")) {
				System.out.println(ta.balance);
				System.out.println(ta.stockPositions);

			} else if (User_R.equals("2")) {
				System.out
						.println("Which stock would you like? APPl, INTU, GOOG?");
				User_RC = keyboard.next();

				System.out.println("How many shares?");
				shareAmount = keyboard.nextInt();

				System.out.println("Buy or Sell?");
				User_Sb = keyboard.next();

				if (User_Sb.equals("Buy")) {
					buy = true;

				} else {
					buy = false;
				}

				tq.enqueue(User_RC, shareAmount, buy);

			} else if (User_R.equals("3")) {
				se.cycleTurn();
				processTrades();

			}

		} while (!User_R.equals("exit") && ta.balance >= 1);

		System.out.println(ta.balance);
		System.out.println("Thanks for playing");

	}

}
