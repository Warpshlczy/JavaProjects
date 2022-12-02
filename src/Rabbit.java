public class Rabbit extends Animal {
    boolean isVaccineInjected;
    static double price = 50;

    String tag = "兔叽";

    Rabbit(String tag, String name, int age, String gender, double price, boolean isVaccineInjected) {
        super(tag, name, age, gender, price);
        this.isVaccineInjected = isVaccineInjected;
    }

    public String toString() {
        String details = "";
        details += "----------宠物信息----------" + "\n";
        details += "名字:" + name + "\n";
        details += "年龄:" + age + "\n";
        details += "性别:" + gender + "\n";
        details += "价格:" + price + "\n";
        details += "是否打了疫苗:" + isVaccineInjected + "\n";
        details += "--------------------------";
        return details;
    }

}
