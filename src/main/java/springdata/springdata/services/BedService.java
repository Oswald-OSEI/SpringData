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
    private final TransactionTemplate transactionTemplate;
    BedRepository bedRepository;
    public BedService(BedRepository bedRepository, TransactionTemplate transactionTemplate) {
        this.bedRepository = bedRepository;
        this.transactionTemplate = transactionTemplate;
    }

    @Transactional
    @CachePut(value = "bedCache", key = "#result.id")
    public BedDto addBed(BedDto bedDto) {
     Bed newBed = bedRepository.save(convertToEntity(bedDto));
     return convertToDto(newBed);
    }



    public BedDto addBedCustomQuery(BedDto bedDto) {
        transactionTemplate.execute(status-> {
            bedRepository.addBed(bedDto.getBedNumber(), bedDto.getWard().getId());
            return bedDto;
        });
        return bedDto;
    }


    @Cacheable(value = "bedCache", unless = "#result==null")
    public List<BedDto> getAllBeds() {
        List<Bed> beds = bedRepository.findAll();
        return beds.stream().map(this::convertToDto).toList();
    }

    @Cacheable(value = "bedCache", unless = "#result==null")
    public BedDto getBedById(Long id) {
        return convertToDto(bedRepository.findById(id).orElseThrow());
    }

    @Transactional
    @CachePut(value = "bedCache", key = "#bedDto.id")
    public BedDto updateBed(BedDto bedDto) {
        BedDto editedBedDto = new BedDto();
        if (bedDto.getId()!=null){
            Optional<Bed> editBed = bedRepository.findById(bedDto.getId());
            if (editBed.isPresent()) {
                Bed bed = editBed.get();
                bed.setBedNumber(bedDto.getBedNumber());
                bed.setWard(bedDto.getWard());
                bedRepository.save(bed);
                editedBedDto.setBedNumber(bedDto.getBedNumber());
                editedBedDto.setWard(bedDto.getWard());
            }
        }
        return editedBedDto;
    }

    @CacheEvict(value = "bedCache", key = "#id")
    public void deleteBed(long id) {
        bedRepository.deleteById(id);
    }

    public BedDto convertToDto(Bed bed){
        BedDto bedDto = new BedDto();
        bedDto.setId(bed.getId());
        bedDto.setBedNumber(bed.getBedNumber());
        bedDto.setWard(bed.getWard());
        return bedDto;
    }

    public Bed convertToEntity(BedDto bedDto){
        Bed bed = new Bed();
        bed.setBedNumber(bedDto.getBedNumber());
        bed.setWard(bedDto.getWard());
        return bed;
    }

}
