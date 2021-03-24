
/**
 * Create a card, assign it attack value, defence value
 *
 * @author Keira Malan
 * @version 19/3/21
 */
public class Card
{
    // create card
    private String name;
    private int attack, defense;
    final int MAXATTACK = 15;
    final int MAXDEFENSE = 15;

    /**
     * Constructor
     */
    public Card(String nm) {
        // randomly assign attack number
        attack = (int) (Math.random() * MAXATTACK);
        // randomly assign defense number
        defense = (int) (Math.random() * MAXDEFENSE);
        // reassign name
        name = nm;
    }
    
    //return attack number
    public int getAttack() {
        return attack;
    }
    
    // return defense num
    public int getDefense() {
        return defense;
    }
    
    // check if card is alive
    public boolean isAlive() {
        if (defense <= 0)
            return false;
        return true;
    }
    
    // card takes damage
    public void takeDamage(int amt) { // take in other card's attack value
        defense -= amt;
    }
    
    // get a card's name
    public String getName() {
        return name;
    }
}


