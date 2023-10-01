package homeworks.sergii_khvostov.hw_2023.hw_24_09_23.task1;

public enum DogBreed {
    SHEPHERD("shepherd"),
    RETRIEVER("retriever"),
    HUSKY("husky");
    private final String breedName;

    DogBreed(String breedName) {
        this.breedName = breedName;
    }

    public String getBreedName() {
        return breedName;
    }
}
