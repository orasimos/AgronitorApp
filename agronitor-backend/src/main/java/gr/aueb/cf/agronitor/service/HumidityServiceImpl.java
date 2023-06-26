package gr.aueb.cf.agronitor.service;

import gr.aueb.cf.agronitor.model.Humidity;
import gr.aueb.cf.agronitor.repository.HumidityRepository;
import gr.aueb.cf.agronitor.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class HumidityServiceImpl implements IHumidityService {

    private final HumidityRepository humidityRepository;

    @Autowired
    public HumidityServiceImpl(HumidityRepository humidityRepository) {
        this.humidityRepository = humidityRepository;
    }

    @Transactional
    @Override
    public Humidity insertHumidity(Humidity humidity) {
        return humidityRepository.save(humidity);
    }

    @Transactional
    @Override
    public void deleteHumidity(Long id) {
        humidityRepository.deleteById(id);
    }

    @Override
    public Humidity getHumidityById(Long id) throws EntityNotFoundException {
        Humidity humidity = humidityRepository.findHumidityById(id);
        if (humidity == null) throw new EntityNotFoundException(Humidity.class, 0L);
        return humidity;
    }

    @Override
    public Humidity getMaxHumidity(Long greenhouseId) throws EntityNotFoundException {
       Humidity humidity = humidityRepository.getMaxHumidity(greenhouseId);
       if (humidity == null) throw new EntityNotFoundException(Humidity.class, 0L);
       return humidity;
    }

    @Override
    public Humidity getMinHumidity(Long greenhouseId) throws EntityNotFoundException {
        Humidity humidity = humidityRepository.getMinHumidity(greenhouseId);
        if (humidity == null) throw new EntityNotFoundException(Humidity.class, 0L);
        return humidity;
    }

    @Override
    public List<Humidity> getGreehouseLastHum(Long greenhouseId) throws EntityNotFoundException {
        List<Humidity> humidities = humidityRepository.findLastHumidity(greenhouseId);
        if (humidities.isEmpty()) throw new EntityNotFoundException(Humidity.class, 0L);
        return humidities;
    }
}
