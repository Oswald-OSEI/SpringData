package springdata.springdata.services;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import springdata.springdata.dtos.BedDto;
import springdata.springdata.entities.Bed;
import springdata.springdata.repositories.BedRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BedService {

    private final BedRepository bedRepository;

    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    @Transactional
    @CachePut(value = "bedCache", key = "#result.id")
    public BedDto addBed(BedDto bedDto) {
        Bed newBed = bedRepository.save(convertToEntity(bedDto));
        return convertToDto(newBed);
    }

    @Cacheable(value = "bedCache", key = "'allRegisteredBeds'")
    public List<BedDto> getAllBeds() {
        List<Bed> beds = bedRepository.findAll();
        return beds.stream()
                .map(this::convertToDto)
                .toList();
    }

    @Cacheable(value = "bedCache", key = "#id", unless = "#result == null")
    public BedDto getBedById(String id) {  // Changed to String since MongoDB uses String for IDs
        return bedRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow();  // Consider using a specific exception, e.g., ResourceNotFoundException
    }

    @Transactional
    @CachePut(value = "bedCache", key = "#bedDto.id")
    public BedDto updateBed(BedDto bedDto) {
        Optional<Bed> editBed = bedRepository.findById(bedDto.getId());
        if (editBed.isPresent()) {
            Bed bed = editBed.get();
            bed.setBedNumber(bedDto.getBedNumber());
            bed.setWard(bedDto.getWard());
            bedRepository.save(bed);
            return convertToDto(bed);
        }
        throw new IllegalArgumentException("Bed not found with id: " + bedDto.getId());
    }

    @Transactional
    @CacheEvict(value = "bedCache", key = "#id")
    public void deleteBed(String id) {  // Changed to String for consistency with MongoDB IDs
        if (bedRepository.existsById(id)) {
            bedRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Bed not found with id: " + id);
        }
    }

    // Conversion methods
    private BedDto convertToDto(Bed bed) {
        BedDto bedDto = new BedDto();
        bedDto.setId(bed.getId());
        bedDto.setBedNumber(bed.getBedNumber());
        bedDto.setWard(bed.getWard());
        return bedDto;
    }

    private Bed convertToEntity(BedDto bedDto) {
        Bed bed = new Bed();
        bed.setBedNumber(bedDto.getBedNumber());
        bed.setWard(bedDto.getWard());
        return bed;
    }
}
