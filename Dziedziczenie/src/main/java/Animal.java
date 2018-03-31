public abstract class Animal {

        private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract MovesReturn moves();
    abstract EatReturn eatsAsAChild();

    public enum MovesReturn
    {
        walks,
        flies,
        swims
    }
    public enum EatReturn
    {
        milk,
        who_knows
    }
}
