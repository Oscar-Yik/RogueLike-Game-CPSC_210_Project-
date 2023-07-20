package model;

import java.util.Random;

// Represents an account having an id, owner name and balance (in dollars)
public class Player extends Character {

    private static final int expThreshold = 200;
    private String name;
    private String weapon;
    private int movementSpeed;
    private int range;
    private int exp;
    private String talent;
    private Enemy target;
    private Random rn;

    /*
     * REQUIRES: playerName has a non-zero length
     * EFFECTS: Constructs a player with a name, random talent, sword
     * weapon, damageMultiplier = 2, no exp, and 1 level
     */
    public Player(String playerName) {
        super();
        name = playerName;
        rn = new Random();
        talent = receiveTalent();
        weapon = "Sword";
        damageMultiplier = 2;
        exp = 0;
        levelUp();
    }

    public String getName() {
        return this.name;
    }

    public int getMovementSpeed() {
        return this.movementSpeed;
    }

    public int getRange() {
        return this.range;
    }

    public int getExp() {
        return this.exp;
    }

    public String getWeapon() {
        return this.weapon;
    }

    public String getTalent() {
        return this.talent;
    }

    public Enemy getTarget() {
        return this.target;
    }

    /*
     * MODIFIES: this
     * EFFECTS: returns talent which is randomly chosen as one of
     * Strength, Health Movement Speed, Range
     */
    public String receiveTalent() {
        switch (rn.nextInt(4)) {
            case 0:
                this.talent = "Strength";
            case 1:
                this.talent = "Health";
            case 2:
                this.talent = "Movement Speed";
            case 3:
                this.talent = "Range";
        }
        return talent;
    }

    /*
     * REQUIRES: target is not null
     * MODIFIES: this
     * EFFECTS: sets player's target enemy
     */
    public void chooseTarget(Enemy target) {
        this.target = target;
    }

    /*
     * MODIFIES: this
     * EFFECTS: 100 exp is added to the player; if the player's
     * exp meets or exceeds the threshold, the player gains a level
     * and their exp is lowered by that threshold
     */
    public void addEXP() {
        this.exp += 100;
        if (exp >= expThreshold) {
            exp -= expThreshold;
            levelUp();
        }
    }
}
