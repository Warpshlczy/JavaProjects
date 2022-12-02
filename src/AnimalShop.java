import java.time.LocalDate;

public interface AnimalShop {
    void addNewAnimal(Animal newAnimal);//进口新动物

    void treatCustomer(Customer customer);//招待顾客列表

    void isAtRest(LocalDate day, boolean state);//本店是否正在歇业

    void blockCustomer(Customer customer);//拉黑顾客

}
