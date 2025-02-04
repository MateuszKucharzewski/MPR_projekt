package com.example.mpr_project_front.controller;

import com.example.mpr_project_front.exception.BiletNotFoundException;
import com.example.mpr_project_front.model.Bilets;
import com.example.mpr_project_front.service.BiletService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ViewController {

    private BiletService biletService;

    public ViewController(BiletService biletService){
        this.biletService = biletService;
    }

    @GetMapping("/")
    public String mainPage(){
        return "mainPage";
    }

    @GetMapping("/bilet/all")
    public String allTickets(Model model){
        List<Bilets> biletsList = this.biletService.getAllBilety();
        model.addAttribute("Bilety", biletsList);
        return "allBilets";
    }

    @GetMapping("/bilet/addBilets")
    public String addBilets(Model model){
        model.addAttribute("bilet", new Bilets());
        return "addBilets";
    }

    @PostMapping("/bilet/addForm")
    public ResponseEntity<String> submitForm(@RequestBody Bilets bilets) {
        try {
            this.biletService.addBilet(bilets);
            return ResponseEntity.ok("Bilet dodany!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Wystąpił błąd podczas dodawania biletu.");
        }
    }

//    @GetMapping("/addBilets")
//    public String showAddBiletsPage() {
//        return "addBilets";
//    }

//    @GetMapping("/deleteForm")
//    public String displayDeleteForm(@RequestParam Long id, Model model) {
//        try {
//            this.biletService.deleteBilet(id);
//        } catch (BiletNotFoundException e) {
//            model.addAttribute("error", "Bilet not found for deletion.");
//            return "noBiletFound";
//        } catch (Exception e) {
//            model.addAttribute("error", "Error deleting Bilet.");
//            return "errorPage";
//        }
//        return "redirect:/view/all";
//    }
//
//    @GetMapping("/updateForm")
//    public String displayUpdateForm(@RequestParam Long id, Model model) {
//        try {
//            Bilets bilets = biletService.get(id);
//            model.addAttribute("bilet", bilets);
//        } catch (BiletNotFoundException e) {
//            model.addAttribute("error", "Bilet not found for update.");
//            return "noBiletFound";
//        } catch (Exception e) {
//            model.addAttribute("error", "Error retrieving Bilets for update.");
//            return "errorPage";
//        }
//        return "updateForm";
//    }
//
//    @PostMapping("/updateForm")
//    public String submitUpdateForm(@ModelAttribute Bilets bilets, Model model) {
//        try {
//            biletService.updateBilet(bilets.getId(), bilets);
//        } catch (Exception e) {
//            model.addAttribute("error", "Error updating Bilet.");
//            return "errorPage";
//        }
//        return "redirect:/view/all";
//    }
}
