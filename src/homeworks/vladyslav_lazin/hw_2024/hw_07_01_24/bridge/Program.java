package homeworks.vladyslav_lazin.hw_2024.hw_07_01_24.bridge;

public abstract class Program {
    protected Developer developer;

    protected Program(Developer developer) {
        this.developer = developer;
    }
    public abstract void developProgram();
}
