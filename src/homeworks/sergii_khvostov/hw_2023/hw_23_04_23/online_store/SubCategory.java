package homeworks.sergii_khvostov.hw_2023.hw_23_04_23.online_store;

public enum SubCategory {
    MOBILE_PHONES(Category.MOBILE),
    SMARTPHONES(Category.MOBILE),
    SMART_TV(Category.TV),
    CONVENTIONAL_TV(Category.TV),
    GAME_LAPTOP(Category.LAPTOP),
    WORK_LAPTOP(Category.LAPTOP),
    STUDY_LAPTOP(Category.LAPTOP),
    BOOMBOX(Category.AUDIO_SYSTEM),
    AUDIO_CENTER(Category.AUDIO_SYSTEM),
    MOBILE_AUDIO_CENTER(Category.AUDIO_SYSTEM),
    AUDIO_PLAYER(Category.AUDIO_SYSTEM),
    VIDEO_PLAYER(Category.VIDEO_SYSTEM),
    DVD_CENTER(Category.VIDEO_SYSTEM),
    BLURAY_CENTER(Category.VIDEO_SYSTEM),
    WORKSTATION(Category.PC),
    GAMESTATION(Category.PC),
    HOMESTATION(Category.PC);

    private final Category category;


    SubCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }
}
