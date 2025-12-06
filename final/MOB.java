public class MOB implements Attributes {
    protected int armor;
    protected int damage;
    protected DiceType damageDie;
    protected int hitModifier;
    protected int maxHP;
    private final String name;

    public MOB(String name, int hp, int armor, int hitModifier, DiceType damageDie){
        this.armor = armor;
        this.damageDie = damageDie;
        this.hitModifier = hitModifier;
        this.maxHP = hp;
        this.name = name;
        this.damage = 0;
    }

    public void addDamage(int dmg){
        this.damage += dmg;
    }

public MOB copy() {
    return new MOB(name, maxHP, armor, hitModifier, damageDie);
}

    @Override
    public int getArmor() {
        return armor;
    }

public int getDamage() {
    return damage;
}

public int getHP() {
    return maxHP - damage;
}

    @Override
    public int getMaxHP() {
        return maxHP;
    }

public String getName() {
    return name;
}

    @Override
    public DiceType getDamageDie() {
        return damageDie;
    }

    @Override
    public int getHitModifier() {
        return hitModifier;
    }

    public void resetDamage() {
        this.damage = 0;
    }

    public String toString(){
        return "+=======================+\n" +
                String.format("| %-27s|%n", getName()) +
                "|                       |\n" +
                String.format("|    Health: %-10d |%n", getHP()) +
                String.format("| Power: %-6s Armor: %-4d|%n", getDamageDie().toString(), getArmor()) +
                "|                       |\n" +
                "+=======================+";
    }

public static void main(String[] args) {

}
}
