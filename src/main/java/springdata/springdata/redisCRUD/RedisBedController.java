package springdata.springdata.redisCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springdata.springdata.redisCRUD.RedisBedDto;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/redix")
public class RedisBedController {

    @Autowired
    private RedisBedService bedService;

    @PostMapping("/addBed")
    public ResponseEntity<RedisBedDto> createBed(@RequestBody RedisBedDto bedDto) {
        RedisBedDto savedBed = bedService.saveBed(bedDto);
        return new ResponseEntity<>(savedBed, HttpStatus.CREATED);
    }

    @GetMapping("getBed/{id}")
    public ResponseEntity<RedisBedDto> getBedById(@PathVariable String id) {
        Optional<RedisBedDto> bed = bedService.getBedById(id);
        return bed.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/getAllBeds")
    public ResponseEntity<List<RedisBedDto>> getAllBeds() {
        List<RedisBedDto> beds = bedService.getAllBeds();
        return ResponseEntity.ok(beds);
    }

    @PutMapping("updateBed/{id}")
    public ResponseEntity<RedisBedDto> updateBed(@PathVariable String id, @RequestBody RedisBedDto bedDto) {
        bedDto.setId(id);
        RedisBedDto updatedBed = bedService.updateBed(bedDto);
        return ResponseEntity.ok(updatedBed);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBed(@PathVariable String id) {
        bedService.deleteBed(id);
        return ResponseEntity.noContent().build();
    }
}