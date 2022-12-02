public abstract class Animal {
    String name;
    int age;
    String gender;
    double price;
    String tag;//标签，用于匹配顾客需求（具体需要什么宠物）

    Animal(String tag, String name, int age, String gender, double price) {
        this.tag = tag;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public abstract String toString();


}
