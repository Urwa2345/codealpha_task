import java.util.Scanner;

public class StockTradingPlatform {

    public static void main(String[] args) {
        Market market = new Market();
        PortfolioManager portfolioManager = new PortfolioManager(market);
        Scanner scanner = new Scanner(System.in);

        // Add sample stocks
        market.addStock(new Stock("Apple", "Apple Inc.", 1500.0));
        market.addStock(new Stock("Google", "Alphabet Inc.", 2800.0));
        market.addStock(new Stock("Amazon", "Amazon.com Inc.", 3500.0));

        while (true) {
            System.out.println("Welcome to the Stock Trading Platform");
            System.out.println("1. View Market Data");
            System.out.println("2. Buy Stocks");
            System.out.println("3. Sell Stocks");
            System.out.println("4. View Portfolio");
            System.out.println("5. Exit");
            System.out.print("Please choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    market.displayMarketData();
                    break;
                case 2:
                    System.out.print("Enter stock symbol: ");
                    String symbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    System.out.print("Enter your name: ");
                    scanner.nextLine();
                    String buyerName = scanner.nextLine();
                    if (portfolioManager.buyStock(buyerName, symbol, quantity)) {
                        System.out.println("Stocks bought successfully!");
                    } else {
                        System.out.println("Failed to buy stocks. Check the stock symbol or availability.");
                    }
                    break;
                case 3:
                    System.out.print("Enter stock symbol: ");
                    String sellSymbol = scanner.next();
                    System.out.print("Enter quantity: ");
                    int sellQuantity = scanner.nextInt();
                    System.out.print("Enter your name: ");
                    scanner.nextLine();
                    String sellerName = scanner.nextLine();
                    if (portfolioManager.sellStock(sellerName, sellSymbol, sellQuantity)) {
                        System.out.println("Stocks sold successfully!");
                    } else {
                        System.out.println("Failed to sell stocks. Check the stock symbol or your portfolio.");
                    }
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    scanner.nextLine();
                    String userName = scanner.nextLine();
                    portfolioManager.viewPortfolio(userName);
                    break;
                case 5:
                    System.out.println("Thank you for using the Stock Trading Platform.");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
