package com.greenfox.demo;

import com.greenfox.demo.service.MyColor;
import com.greenfox.demo.service.Printer;
import com.greenfox.demo.service.RedColor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;

@SpringBootApplication
public class DependenciInjectionApplication implements CommandLineRunner{

    private static Printer printer;
    private static MyColor myColor;
    public static void main(String[] args) {
        SpringApplication.run(DependenciInjectionApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        printer.log(myColor.printColor());
    }

    @Autowired
    DependenciInjectionApplication(Printer printer, MyColor myColor) {
        this.printer = printer;
        this.myColor = myColor;
    }

}
