public class Mammal extends Animal {

    MovesReturn moves()
    {
        return MovesReturn.walks;
    }

    EatReturn eatsAsAChild()
    {
        return EatReturn.milk;
    }
}
