package springdata.springdata.redisCRUD;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import springdata.springdata.redisCRUD.RedisBedDto;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RedisBedService {

    private static final String HASH_KEY = "BED";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public RedisBedDto saveBed(RedisBedDto bedDto) {
        redisTemplate.opsForHash().put(HASH_KEY, bedDto.getId(), bedDto);
        return bedDto;
    }

    public Optional<RedisBedDto> getBedById(String id) {
        Object obj = redisTemplate.opsForHash().get(HASH_KEY, id);
        return Optional.ofNullable(obj instanceof RedisBedDto ? (RedisBedDto) obj : null);
    }

    public List<RedisBedDto> getAllBeds() {
        List<Object> objects = redisTemplate.opsForHash().values(HASH_KEY);
        return objects.stream()
                .filter(obj -> obj instanceof RedisBedDto)
                .map(obj -> (RedisBedDto) obj)
                .collect(Collectors.toList());
    }

    public RedisBedDto updateBed(RedisBedDto bedDto) {
        if (redisTemplate.opsForHash().hasKey(HASH_KEY, bedDto.getId())) {
            redisTemplate.opsForHash().put(HASH_KEY, bedDto.getId(), bedDto);
            return bedDto;
        }
        return null; // or throw an exception if the bed doesn't exist
    }

    public void deleteBed(String id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }
}