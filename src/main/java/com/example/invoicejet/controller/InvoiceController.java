package com.example.invoicejet.controller;

import com.example.invoicejet.model.Invoice;
import com.example.invoicejet.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Invoice> list = invoiceService.getAllInvoices();
        model.addAttribute("invoices", list);
        return "index"; // loads index.html from templates
    }

    @GetMapping("/new")
    public String showNewInvoiceForm(Model model) {
        Invoice invoice = new Invoice();
        model.addAttribute("invoice", invoice);
        return "new_invoice";
    }

    @PostMapping("/save")
    public String saveInvoice(@ModelAttribute("invoice") Invoice invoice) {
        invoiceService.save(invoice);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditInvoiceForm(@PathVariable("id") Long id, Model model) {
        Invoice invoice = invoiceService.getInvoiceById(id);
        model.addAttribute("invoice", invoice);
        return "edit_invoice";
    }

    @GetMapping("/delete/{id}")
    public String deleteInvoice(@PathVariable("id") Long id) {
        invoiceService.delete(id);
        return "redirect:/";
    }
}
