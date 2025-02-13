package me.ams.menu.options.other;

import me.ams.menu.options.MenuOption;

public class ExitMenuOption implements MenuOption {
    @Override
    public void execute() {
        System.exit(0);
    }
}
