package by.boika.elective.command.client;

import by.boika.elective.command.ActionCommand;
import by.boika.elective.command.LoginCommand;
import by.boika.elective.command.LogoutCommand;

public enum CommandEnum {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
    LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    };
//    VIEW_STUDENTS {
//        {
//            this.command = new ViewCommand();
//        }
//    };
    ActionCommand command;
    public ActionCommand getCurrentCommand() {
        return command;
    }
}