import models.Auction;
import models.User;
import repositories.AuctionRepository;
import repositories.BidRepository;
import repositories.UserRepository;
import services.AuctionService;
import strategies.StandardWinnerStrategy;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    AuctionService auctionService = new AuctionService(
            new AuctionRepository(), new BidRepository(), new StandardWinnerStrategy(), new UserRepository()
    );

    String buyer1 = auctionService.addBuyer("Hanuman");
    String buyer2 = auctionService.addBuyer("Lakshman");
    String buyer3 = auctionService.addBuyer("Bharat");
    String seller1 = auctionService.addSeller("Ram");

    String auction1 = auctionService.createAuction(10,50,seller1 , 1);
    auctionService.placeBid(auction1,buyer1,17);
    auctionService.placeBid(auction1,buyer2,15);
    auctionService.updateBid(buyer2,auction1,19);
    auctionService.placeBid(auction1,buyer3,19);
    //auctionService.withdrawBid(buyer1,auction1);
    auctionService.closeAuction(auction1);



}
