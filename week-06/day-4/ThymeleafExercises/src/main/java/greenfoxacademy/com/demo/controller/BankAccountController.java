package greenfoxacademy.com.demo.controller;

import greenfoxacademy.com.demo.model.BankAccount;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BankAccountController {
    public List<BankAccount> listOfBankAccounts = new ArrayList<>();
    BankAccount account1 = new BankAccount("Simba", 2000.00, "lion", false);

    public BankAccountController(){
        listOfBankAccounts.add(new BankAccount("Pumba", 4000.00, "warthog", false));
        listOfBankAccounts.add(new BankAccount("Timon", 2000.00, "meerkat", false));
        listOfBankAccounts.add(new BankAccount("Mufasa", 8000.00, "lion", true));
        listOfBankAccounts.add(new BankAccount("Nala", 4000.00, "lion", false));
    }

    @GetMapping("/show")
    public String landing(Model model) {
        model.addAttribute("account", account1);
        return "index";
    }

    @GetMapping("/newString")
    public String newString() {
        return "newString";
    }

    @GetMapping("/multipleAccounts")
    public String multipleAccounts(Model model) { 
        model.addAttribute("accounts", listOfBankAccounts);
        return "multipleAccounts";
    }
}
