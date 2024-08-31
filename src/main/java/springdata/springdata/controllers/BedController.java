package springdata.springdata.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springdata.springdata.dtos.BedDto;
import springdata.springdata.services.BedService;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/bed")
public class BedController {
    private BedService bedService;
    public BedController(BedService bedService) {
        this.bedService = bedService;
    }

    @PostMapping("/addBed")
    public ResponseEntity<BedDto> addBed(@RequestBody BedDto bedDto) {
        BedDto savedBed = bedService.addBed(bedDto);
        return ResponseEntity.ok().body(savedBed);
    }

    @PostMapping("/addBedCustom")
    public ResponseEntity<BedDto> addBedCustom(@RequestBody BedDto bedDto) {
        BedDto savedBed = bedService.addBedCustomQuery(bedDto);
        return ResponseEntity.ok().body(savedBed);
    }

    @GetMapping("/allBeds")
    public ResponseEntity<List<BedDto>> getAllBeds() {
        long startTime = System.currentTimeMillis(); // Capture the start time
        List<BedDto> allBeds = bedService.getAllBeds();
        if (allBeds.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        long endTime = System.currentTimeMillis(); // Capture the end time

        long timeTaken = endTime - startTime; // Calculate the time taken
        System.out.println("Time taken to process getAllBeds request: " + timeTaken + " ms");
        return ResponseEntity.ok().body(allBeds);
    }

    @GetMapping("/checkBed/{id}")
    public ResponseEntity<BedDto> checkBed(@PathVariable Long id) {
        return ResponseEntity.ok(bedService.getBedById(id));
    }

    @DeleteMapping("/deletedBed/{id}")
    public void deleteBed(@PathVariable Long id) {
        bedService.deleteBed(id);
    }

    @PutMapping("/updateBedDetails")
    public ResponseEntity<BedDto> updateBedDetails(@RequestBody BedDto bedDto) {
        BedDto savedBed = bedService.updateBed(bedDto);
        return ResponseEntity.ok().body(savedBed);
    }

}
