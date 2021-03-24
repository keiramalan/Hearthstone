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
    private int coinFlip = 0;
    
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
        // for loop to populate deck with 7 cards
        for (int idx = 0; idx < DECKLENGTH; idx++) {
            deck1.add(new Card("Card " + Integer.toString(idx + 1)));
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
         coinFlip = (int) (1+ Math.random() * 2); // choose first attacker
        return coinFlip;
    }
    
    // attack function
    public void battle() {
        // loop through length of deck
        // choose which deck goes first
        int coinFlip = flipResults();
        do { // check both sides are surviving
            for (int idx = 0; idx < deck1.size(); idx++) { // attack left to right
                
                Card attacker, defender;
                if (coinFlip <=1) { 
                    // deck 1 attacks first
                    // choose cards for attack and defense
                    attacker = deck1.get(idx);
                    
                    // randomly choose victim
                    int defenderIdx = (int)(Math.random() * deck2.size());
                    defender = deck2.get(defenderIdx);
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                    
                    // deck 2 attacks second
                    
                    attacker = deck2.get(idx);
                    
                    // randomly choose victim
                    int defenderIdx = (int)(Math.random() * deck1.size());
                    defender = deck1.get(defenderIdx);
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                    
                }
                
                if (first > 1) { // 2nd deck attack first
                    // choose cards for attack and defense
                    attacker = deck2.get(idx);
                    
                    // randomly choose victim
                    do { 
                        int defenderIdx = (int)(Math.random() * deck2.size());
                        defender = deck2.get(defenderIdx);
                    } while (deck2.get(defender).isAlive() == false); // repeat for dead
                    
                    
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                    
                    // deck 1 attacks second
                    
                    attacker = deck1.get(idx);
                    
                    // randomly choose victim
                    int defenderIdx = (int)(Math.random() * deck2.size());
                    defender = deck2.get(defenderIdx);
                    
                    // Get attack and deal to enemy
                    defender.takeDamage(attacker.getAttack());
                    // Defender attacks back
                    attacker.takeDamage(defender.getAttack());
                }
            }
        } while (checkWinner() == -1);
    }
        // attack left to right by iterating through array
        // simulate game 10,00 times
        // produce stats
        // actually play game with print statments
    
}
