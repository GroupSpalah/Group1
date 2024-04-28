package homeworks.dmytro_k.hw_2024.hw_14_04_24;

public enum ProductionStages {
    STAGE_1(new ProductionStage("stage 1", 1)),
    STAGE_2(new ProductionStage("stage 2", 1)),
    STAGE_3(new ProductionStage("stage 3", 1)),
    STAGE_4(new ProductionStage("stage 4", 1)),
    STAGE_5(new ProductionStage("stage 5", 1)),
    STAGE_6(new ProductionStage("stage 6", 1)),
    STAGE_7(new ProductionStage("stage 7", 1)),
    STAGE_8(new ProductionStage("stage 8", 1)),
    STAGE_9(new ProductionStage("stage 9", 1)),
    STAGE_10(new ProductionStage("stage 10", 1));

    private final ProductionStage productionStage;

    ProductionStages(ProductionStage productionStage) {
        this.productionStage = productionStage;
    }

    public ProductionStage productionStage() {
        return productionStage;
    }
}
