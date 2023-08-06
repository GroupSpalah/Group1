package homeworks.dmytro_k.hw_2023.hw_18_01_23.task1;

enum ShapeName {
    SQUARE("Square"),
    CIRCLE("Circle");

    private String name;

    ShapeName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

