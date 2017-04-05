package javaschool.app;

import asg.cliche.Command;
import asg.cliche.ShellFactory;

import java.io.IOException;

public class Main {

    @Command
    public String hello() {
        return "Hello, World!";
    }

    @Command
    public String hello(String name) {
        return "Hello, " + name + "!";
    }

    public static void main(String[] args) throws IOException {
        ShellFactory
                .createConsoleShell("hello", "This is Phone Book", new PhoneBook())
                .commandLoop();
    }
}


// homework - oracle.com - javase - tutorial - datetime - TOC