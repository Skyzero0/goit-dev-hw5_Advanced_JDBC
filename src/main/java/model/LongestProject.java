package model;

public class LongestProject {
    String name;
    int monthCount;

    public LongestProject (String name, int monthCount) {
        this.name = name;
        this.monthCount = monthCount;
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getMonthCount() {
//        return monthCount;
//    }
//
//    public void setMonthCount(int monthCount) {
//        this.monthCount = monthCount;
//    }

    @Override
    public String toString() {
        return "Longest project: " +
                "name='" + name + '\'' +
                ", monthCount=" + monthCount;
    }
}
