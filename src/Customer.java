import java.time.LocalDate;

public class Customer {
    String name;//顾客名字
    int arrivalTimes;//到店次数
    LocalDate latestArrivalTime;//最新到店时间
    String needForPets;//需求
    boolean isBlocked;//是否被拉黑
    String recording;//交易记录

    Customer(String name, int arrivalTimes, LocalDate latestArrivalTime)//构造器
    {
        this.name = name;
        this.arrivalTimes = arrivalTimes;
        this.latestArrivalTime = latestArrivalTime;
    }

    Customer(String name) {
        this.name = name;
    }

    Customer(String name, String needForPets) {
        this.name = name;
        this.needForPets = needForPets;
    }

    Customer(String name, LocalDate latestArrivalTime) {
        this.name = name;
        this.latestArrivalTime = latestArrivalTime;
    }

    Customer(String name, String needForPets, LocalDate latestArrivalTime) {
        this.name = name;
        this.needForPets = needForPets;
        this.latestArrivalTime = latestArrivalTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setArrivalTimes(int arrivalTimes) {
        this.arrivalTimes = arrivalTimes;
    }

    public int getArrivalTimes() {
        return arrivalTimes;
    }

    public void setNeedForPets(String needForPets) {
        this.needForPets = needForPets;
    }
public String getNeedForPets(){
        return needForPets;
    }
    public void setLatestArrivalTime(LocalDate latestArrivalTime) {
        this.latestArrivalTime = latestArrivalTime;
    }

    public LocalDate getLatestArrivalTime() {
        return latestArrivalTime;
    }

    public void recordingText() {
        recording="";
        recording += needForPets + "\n";
    }

    @Override
    public String toString() {

        String details = "";
        details += "-----------------------------" + "\n";
        details += "顾客名字:" + name + "\n";
        details += "到店次数:" + arrivalTimes + "\n";
        details += "最新到店时间:" + latestArrivalTime + "\n";
        details += "交易记录:" + recording + "\n";
        details += "-----------------------------" + "\n";
        return details;
    }


}
