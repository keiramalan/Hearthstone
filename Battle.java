import java.util.ArrayList; // import array list class
/**
 * Create two decks and simulate a fight
 *
 * @author Keira Malan
 * @version 25/3/21
 */
public class Battle
{
    // make 2 decks
    private ArrayList<Card> deck1 = new ArrayList<Card>();
    private ArrayList<Card> deck2 = new ArrayList<Card>();
    // deck lengths
    private final int DECKLENGTH = 7;
    
    /**
     * Constructor for objects of class Battle
     */
    public Battle() 
    {
        // Populate decks
        this.populateDecks();
    }

    
    // populate both decks
    public void populateDecks() {
        int randomAt = (int)
        // for loop to populate deck with 7 cards
        for (int idx = 0; idx < DECKLENGTH; idx++) {
            //
            deck1.add(new Card(("Card " + Integer.toString(idx + 1)), randomAt, 1);
            //
            deck2.add(new Card("Card " + Integer.toString(idx + 1)));
        }
    }

    public int getAttackIndex(ArrayList<Card> deck1) {
        for (int idx = 0; idx < DECKLENGTH; idx++) {
            // check if card at that index is alive
            if (deck1.get(idx).isAlive()) {
                return idx;
            }
            
        }
        return 0;
    }
        
    // Decide which deck attacks first
    public int flipResults() {
        int coinFlip = 0;
        coinFlip = (int) (1 + Math.random() * 2); // choose first attacker
        return coinFlip;
    }
    
    /**
     * check if a deck is alive
     */
    public int cardsAlive(ArrayList<Card> deck) {
        int counter = 0;
        // loop through deck
        for (Card card : deck) {
            if (card.isAlive()) {
                // if the card is alive, add to counter
                counter++;
            }
        }
        // return counter
        return counter;
    }
    
    // attack function
    public int battleGround() {
        int result = 0;
        // choose which deck goes first
        int coinFlip = flipResults();
        do { // check both sides are alive
                Card attacker, defender;
                if (coinFlip <=1) { // deck 1 attacks first
                    
                    // find first alive card in deck 1
                    int attackerIdx1 = getAttackIndex(deck1);
                    // assign it to attack
                    attacker = deck1.get(attackerIdx1);
                    
                    // randomly choose victim
                    do { 
                        int defenderIdx1 = (int)(Math.random() * deck2.size());
                        defender = deck2.get(defenderIdx1);
                    } while ((defender.isAlive() == false) && (cardsAlive(deck2) > 0)); // check if they're deaad

                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                    
                    // deck 2 attacks second
                    int attackerIdx2 = getAttackIndex(deck2);
                    attacker = deck2.get(attackerIdx2);
                    
                    // randomly choose victim
                    do { 
                        int defenderIdx2 = (int)(Math.random() * deck1.size());
                        defender = deck1.get(defenderIdx2);
                    } while (defender.isAlive() == false && (cardsAlive(deck1) > 0)); // check if they're deaad
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                    
                }
                
                if (coinFlip > 1) { // 2nd deck attack first
                    
                    // find first alive card in deck 2
                    int attackerIdx1 = getAttackIndex(deck2);
                    // assign it to attack
                    attacker = deck2.get(attackerIdx1);
                    
                    // randomly choose victim
                    do { 
                        int defenderIdx1 = (int)(Math.random() * deck1.size());
                        defender = deck1.get(defenderIdx1);
                    } while (defender.isAlive() == false && (cardsAlive(deck1) > 0)); // check if they're deaad
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                    
                    // deck 1 attacks second
                    int attackerIdx2 = getAttackIndex(deck1);
                    attacker = deck1.get(attackerIdx1);
                    
                    // randomly choose victim from deck 2
                    do { 
                        int defenderIdx2 = (int)(Math.random() * deck2.size());
                        defender = deck2.get(defenderIdx2);
                    } while (defender.isAlive() == false && (cardsAlive(deck2) > 0)); // check if they're deaad
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                }
        } // check there are cards alive in both decks 
        while (cardsAlive(deck1) > 0 && cardsAlive(deck2) > 0);
        
        // return winner stats
        // check for a tie
        if (cardsAlive(deck1) <= 0 && cardsAlive(deck2) <= 0) {
            result = 0; // 0 means tie
            //System.out.println("deckalive" + cardsAlive(deck1));
        }
        else if (cardsAlive(deck2) <= 0) {
            //System.out.println("deck 1 won");
            result = 1; // deck 1 won
        }
        else if (cardsAlive(deck1) <= 0) {
            result = 2; // deck 2 won
            //System.out.println("deck 2 won");
        }
        return result;
    }

    
    public static void main(String[] args) {    // simulate game 10,00 times
        Battle b = new Battle();
        final int GAMELOOP = 1;
        int deck1Win = 0;
        int deck2Win = 0;
        int tie = 0;
        

        // run game 10,000 times
        for (int index = 0; index < GAMELOOP; index++) {
            // produce stats
            // play game
            int winner = b.battleGround();
            System.out.println(winner);
            // if statements for statistics
            if (winner == 0) {
                tie += 1;
            }
            else if (winner == 1) {
                deck1Win += 1;
            }
            else if (winner == 2) {
                deck2Win += 2;
            }
        
        }
        // print stats
        System.out.println("Your chances of winning are " + (deck1Win / GAMELOOP) * 100);
        System.out.println("Your chances of losing are " + (deck2Win / GAMELOOP) * 100);
        System.out.println("Your chances of a tie are " + (tie / GAMELOOP) * 100);
    }
}
