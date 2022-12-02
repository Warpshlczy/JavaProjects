import java.time.LocalDate;
import java.util.ArrayList;

public class MyAnimalShop implements AnimalShop {
    double shopBalance;//本店余额
    double profitOfDay;//当日利润
    ArrayList<Animal> petsWarehouse;//宠物仓库
    ArrayList<Customer> customerList, blackList;//造访本店的所有顾客名单和黑名单
    boolean isAtRest;//是否歇业

    MyAnimalShop(double shopBalance) {
        this.shopBalance = shopBalance;
    }//构造器

    MyAnimalShop(double shopBalance, ArrayList<Animal> animalList, ArrayList<Customer> customerList, ArrayList<Customer> blackList) {
        this.shopBalance = shopBalance;
        this.petsWarehouse = animalList;
        this.customerList = customerList;
        this.blackList = blackList;
    }//构造器

    public void setShopBalance(double shopBalance) {
        this.shopBalance = shopBalance;
    }

    public void isAtRest(LocalDate day, boolean state)//当日歇业
    {System.out.println(day+"当日所有交易顾客信息如下：" );
        if (state) {
            isAtRest = true;
            for (var customer : customerList) {
                if (customer.latestArrivalTime.equals(day)) {
                    System.out.println(customer.toString());
                }
            }
            System.out.println("当日利润：" + profitOfDay);
        } else {
            isAtRest = false;
            profitOfDay = 0;
        }

    }

    public void addNewAnimal(Animal newAnimal)//加小动物
    {
        try {
            if (shopBalance < newAnimal.price / 2) {
                throw new InsufficientBalanceException("余额不足");
            }
            petsWarehouse.add(newAnimal);
            shopBalance -= newAnimal.price / 2;//以售出价格的二分之一买入
        } catch (InsufficientBalanceException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("成功买入" + newAnimal.tag + newAnimal.name);
        System.out.println("余额" + shopBalance);
    }

    public void sellAnimal(Customer customer)//出售小动物
    {
        try {
            if (petsWarehouse.isEmpty()) {
                throw new AnimalNotFoundException("店内无待售宠物");
            }
            int i = 0;
            for (Animal animal : petsWarehouse) {
                if (animal.tag.equals(customer.needForPets)) {
                    petsWarehouse.remove(animal);
                    System.out.println(animal.toString());
                    System.out.println("已卖给顾客" + customer.name);
                    System.out.println("该宠物已成功出售");
                    customer.recordingText();
                    shopBalance += animal.price;
                    profitOfDay += animal.price - animal.price / 2;
                    System.out.println("本店余额:" + shopBalance);
                    System.out.println();
                    break;
                }
                i++;
                if (i == petsWarehouse.size() - 1) {
                    System.out.println("仓库里已经没有这种类型的宠物啦");
                    throw new AnimalNotFoundException("找不到所需宠物");
                }
            }

        } catch (AnimalNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void treatCustomer(Customer customer) //招待顾客,但顾客进店不一定买宠物，只添加进店记录
    {
        if (customer.isBlocked) {
            System.out.println("禁止录入:该顾客已加入本宠物店豪华小黑屋套餐");
        } else {
            customerList.add(customer);
        }
        customer.arrivalTimes++;

    }

    public void blockCustomer(Customer targetCustomer) //拉黑顾客
    {
        for (var searchCustomer : customerList) {
            if (searchCustomer == targetCustomer)
                customerList.remove(targetCustomer);
        }
        blackList.add(targetCustomer);
        targetCustomer.isBlocked = true;
    }


}
