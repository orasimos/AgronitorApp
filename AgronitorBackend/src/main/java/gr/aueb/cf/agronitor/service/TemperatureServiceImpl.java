package gr.aueb.cf.agronitor.service;

import gr.aueb.cf.agronitor.dto.TemperatureDTO;
import gr.aueb.cf.agronitor.model.Temperature;
import gr.aueb.cf.agronitor.repository.TemperatureRepository;
import gr.aueb.cf.agronitor.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class TemperatureServiceImpl implements ITemperatureService{

    private final TemperatureRepository temperatureRepository;

    @Autowired
    public TemperatureServiceImpl(TemperatureRepository temperatureRepository) {
        this.temperatureRepository = temperatureRepository;
    }

    @Transactional
    @Override
    public Temperature insertTemperature(Temperature temperature) {
        return temperatureRepository.save(temperature);
    }

    @Transactional
    @Override
    public void deleteTemperature(Long id) {
        temperatureRepository.deleteById(id);
    }

    @Override
    public Temperature getTemperatureById(Long id) throws EntityNotFoundException {
        Optional<Temperature> temperature;
        temperature = Optional.ofNullable(temperatureRepository.findTemperatureById(id));
        if (temperature.isEmpty()) throw new EntityNotFoundException(Temperature.class, 0L);
        return temperature.get();
    }

//    @Override
//    public Temperature getGreenhouseTempByTimestamp(Date timestamp, Long greenhouseId) throws EntityNotFoundException {
//        Temperature temperature = temperatureRepository.findGreenhouseTempByTimestamp(timestamp, greenhouseId);
//        if (temperature == null) throw new EntityNotFoundException(Temperature.class, 0L);
//        return temperature;
//    }

    @Override
    public Temperature getMaxTemperature(Long greenhouseId) throws EntityNotFoundException {
        Temperature temperature = temperatureRepository.getMaxTemperature(greenhouseId);
        if (temperature == null) throw new EntityNotFoundException(Temperature.class, 0L);
        return temperature;
    }

    @Override
    public Temperature getMinTemperature(Long greenhouseId) throws EntityNotFoundException {
        Temperature temperature = temperatureRepository.getMinTemperature(greenhouseId);
        if (temperature == null) throw new EntityNotFoundException(Temperature.class, 0L);
        return temperature;
    }

    @Override
    public Temperature getGreenhouseLastTemp(Long greenhouseId) throws EntityNotFoundException {
        Temperature temperature = temperatureRepository.findLastTemperature(greenhouseId);
        if (temperature == null) throw new EntityNotFoundException(Temperature.class, 0L);
        return temperature;
    }


    //    Private methods
    private Temperature convertToNewTemperature(TemperatureDTO temperatureDTO) {
        return new Temperature(temperatureDTO.getTimestamp(), temperatureDTO.getValue(),
                                                                                    temperatureDTO.getGreenhouse());
    }
}
