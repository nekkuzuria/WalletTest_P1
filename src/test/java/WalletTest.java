    import org.example.Wallet;
    import org.junit.jupiter.api.*;

    import static org.junit.jupiter.api.Assertions.assertEquals;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    public class WalletTest {
        private static Wallet mywallet;

        @BeforeEach
        void initMethod() {
            mywallet = new Wallet("manda");
            mywallet.addCard("KTM");
            mywallet.addCard("KTP");
            mywallet.addMoney(10000);
            mywallet.addMoney(10000);
            mywallet.addCoin(500);
        }

        @AfterEach
        void tearDown() {
            mywallet.getCards().clear();
            mywallet.getMoneys().clear();
            mywallet.getCoins().clear();
        }


        @Test
        void testAddCard(){
            mywallet.addCard("Mandiri");
            mywallet.addCard("BNI");
            assertEquals(4, mywallet.getCards().size());
        }

        @Test
        void testTakeCard(){
            mywallet.addCard("BRI");
            mywallet.takeCard("KTM");
            assertEquals(2, mywallet.getCards().size());
        }

        @Test
        void testAddMoney(){
            mywallet.addMoney(100000);
            assertEquals(1, mywallet.getMoneys().get(100000));
        }

        @Test
        void testAddCoin(){
            mywallet.addCoin(100);
            assertEquals(1, mywallet.getCoins().get(100));
        }

        @Test
        void testTakeCoins(){
            mywallet.takeCoins(500);
            assertEquals(0, mywallet.getCoins().get(500));
        }

        @Test
        void testTakeMoneys(){
            mywallet.takeMoneys(10000);
            assertEquals(1, mywallet.getMoneys().get(10000));
        }

        @Test
        void testGetMoneyAvailable(){
            assertEquals(20500, mywallet.getMoneyAvailable());
        }

        @Test
        void testCalculateMoneys(){
            assertEquals(20000, mywallet.calculateMoneys());
        }

        @Test
        void testCalculateCoins(){
            assertEquals(500, mywallet.calculateCoins());
        }
    }

