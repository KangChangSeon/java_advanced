package Day03.InterfaceEx.Quiz02;

public abstract class Factory {
    private int openHour;
    private int closeHour;
    private String name;

    public Factory(String name,int openHour,int closeHour) {
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.name = name;
    }

    public String getFactoryName() {
        return name;
    }

    public int getWorkingTime(){
        return closeHour-openHour;
    }

    public abstract int makeProducts(char skill);
}
