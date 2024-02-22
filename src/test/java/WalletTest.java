import org.example.Wallet;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class WalletTest {
    @Test
    void testAddCard(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addCard("KTM");
        mywallet.addCard("KTP");
        Assertions.assertEquals(2, mywallet.getCards().size());
    }
    @Test
    void testTakeCard(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addCard("KTM");
        mywallet.addCard("KTP");
        mywallet.addCard("BRI");
        mywallet.takeCard("KTM");
        Assertions.assertEquals(2, mywallet.getCards().size());
    }
    @Test
    void testAddMoney(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addMoney(10000);
        mywallet.addMoney(10000);
        Assertions.assertEquals(2, mywallet.getMoneys().get(10000));
    }
    @Test
    void testAddCoin(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addCoin(500);
        Assertions.assertEquals(1, mywallet.getCoins().get(500));
    }
    @Test
    void testTakeCoins(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addCoin(500);
        mywallet.addCoin(500);
        mywallet.takeCoins(500);
        Assertions.assertEquals(1, mywallet.getCoins().get(500));
    }
    @Test
    void testTakeMoneys(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addMoney(5000);
        mywallet.addMoney(5000);
        mywallet.takeMoneys(5000);
        Assertions.assertEquals(1, mywallet.getMoneys().get(5000));
    }
    @Test
    void testGetMoneyAvailable(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addMoney(10000);
        mywallet.addCoin(500);
        Assertions.assertEquals(10500, mywallet.getMoneyAvailable());
    }
    @Test
    void testCalculateMoneys(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addMoney(10000);
        mywallet.addMoney(20000);
        mywallet.addMoney(1000);
        mywallet.addMoney(50000);
        mywallet.addMoney(100000);
        Assertions.assertEquals(181000, mywallet.calculateMoneys());
    }
    @Test
    void testCalculateCoins(){
        Wallet mywallet = new Wallet("manda");
        mywallet.addCoin(500);
        mywallet.addCoin(100);
        mywallet.addCoin(1000);
        mywallet.addCoin(1000);
        Assertions.assertEquals(2600, mywallet.calculateCoins());
    }
}
