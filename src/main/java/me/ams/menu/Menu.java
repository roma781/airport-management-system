package me.ams.menu;

import me.ams.menu.options.MenuOption;

public interface Menu {
    void startListeningForOptions();
    default void executeOption(MenuOption option) {
        option.execute();
    }
    MenuOption getOptionFromNumber(int number);
}
