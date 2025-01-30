package me.ams.menu.options;

import me.ams.menu.MenuOption;

public class ExitMenuOption implements MenuOption {
    @Override
    public void execute() {
        System.exit(0);
    }
}
