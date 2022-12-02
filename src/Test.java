import java.time.LocalDate;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        MyAnimalShop myShop = new MyAnimalShop(1000, new ArrayList<Animal>(), new ArrayList<Customer>(), new ArrayList<Customer>());
        LocalDate day = LocalDate.of(2022, 11, 1);
        myShop.isAtRest(day, false);
        myShop.addNewAnimal(new Cat("猫猫", "小黑", 1, "公", 200, true));
        myShop.addNewAnimal(new ChineseRuralDog("中华田园犬", "Cheems", 4, "公", 100, true));
        myShop.addNewAnimal(new Cat("猫猫", "芝士", 1, "母", 200, false));
        myShop.addNewAnimal(new Rabbit("兔叽", "Judy", 2, "母", 50, false));
        myShop.addNewAnimal(new ChineseRuralDog("中华田园犬", "Doge", 2, "母", 100, true));
        myShop.addNewAnimal(new Rabbit("兔叽", "八哥", 2, "公", 50, false));
        Customer a = new Customer("唐纳德·特朗普");
        myShop.treatCustomer(a);
        a.needForPets = "中华田园犬";
        myShop.sellAnimal(a);
        a.latestArrivalTime = day;
        Customer b = new Customer("埃隆·马斯克", "猫猫");
        myShop.treatCustomer(b);
        myShop.sellAnimal(b);
        b.latestArrivalTime = day;
        Customer c = new Customer("乔·拜登", day);
        myShop.treatCustomer(c);
        c.needForPets = "猫猫";
        myShop.sellAnimal(c);
        Customer d = new Customer("马云", "猫猫", day);
        myShop.treatCustomer(d);
        myShop.sellAnimal(d);
        d.setNeedForPets("兔叽");
        myShop.sellAnimal(d);
        myShop.isAtRest(day, true);
        
    }
}
