package springdata.springdata.services;

import org.springframework.stereotype.Service;
import springdata.springdata.dtos.BedDto;
import springdata.springdata.entities.Bed;
import springdata.springdata.repositories.BedRepository;

import java.util.Optional;

@Service
public class BedService {
    BedRepository bedRepository;
    public BedService(BedRepository bedRepository) {
        this.bedRepository = bedRepository;
    }

    public BedDto addBed(BedDto bedDto) {
     Bed newBed = convertToEntity(bedDto);
     bedRepository.save(newBed);
     return convertToDto(newBed);
    }

    public BedDto addBedCustomQuery(BedDto bedDto) {
        bedRepository.addBed(bedDto.getBedNumber(), bedDto.getWard().getId());
        return bedDto;
    }

    public BedDto getBedById(Long id) {
        return convertToDto(bedRepository.findById(id).orElseThrow());
    }

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
