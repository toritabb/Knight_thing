public class Knight extends MOB {

    private final int id;
    private int xp;
    private Fortune activeFortune;

    public Knight(int id, String name, int hp, int armor, int hitmodifier, DiceType damageDie, int xp) {
        super(name, hp, armor, hitmodifier, damageDie);
        this.id = id;
        this.xp = xp;
        this.activeFortune = null;
    }

    public Integer getId() {
        return id;
    }

    public int getXP() {
        return xp;
    }

    public void addXP(int xp) {
        this.xp += xp;
    }

    public Fortune getActiveFortune() {
        return activeFortune;
    }

    public void setActiveFortune(Fortune activeFortune) {
        this.activeFortune = activeFortune;
    }

    @Override
    public int getArmor() {
        if (activeFortune == null)
            return super.getArmor();
        return super.getArmor() + activeFortune.getArmor();
    }

    @Override
    public int getMaxHP() {
        if (activeFortune == null)
            return super.getMaxHP();
        return super.getMaxHP() + activeFortune.getMaxHP();
    }

    @Override
    public DiceType getDamageDie() {
        if (activeFortune == null || activeFortune.getDamageDie() == null)
            return super.getDamageDie();
        return activeFortune.getDamageDie();
    }

    @Override
    public int getHitModifier() {
        if (activeFortune == null)
            return super.getHitModifier();
        return super.getHitModifier() + activeFortune.getHitModifier();
    }

    public String toCSV() {
        return String.format("%s,%d,%d,%d,%s,%d",
                super.getName(),
                super.getMaxHP(),       // HP is saved WITHOUT fortune
                super.getArmor(),
                super.getHitModifier(),
                super.getDamageDie().toString(),
                xp);
    }

    @Override
    public String toString() {
        return "+============================+\n" +
                String.format("| %-27s|%n", super.getName()) +
                String.format("| id: %-23d|%n", getId()) +
                "|                            |\n" +
                String.format("| Health: %-6d  XP: %-7d|%n", super.getHP(), getXP()) +
                String.format("|  Power: %-6s  Armor: %-4d|%n",
                        getDamageDie().toString(), getArmor()) +
                "|                            |\n" +
                "+============================+";
    }

    public static void main(String[] args) {
        Knight k = new Knight(1, "Test Knight", 32, 13, 0, DiceType.D8, 0);
        System.out.println(k);
        System.out.println("Armor: " + k.getArmor());
        System.out.println("MaxHP: " + k.getMaxHP());
        System.out.println("DamageDie: " + k.getDamageDie());
        System.out.println("HitModifier: " + k.getHitModifier());
    }
}
