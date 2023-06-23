package gr.aueb.cf.agronitor.repository;

import gr.aueb.cf.agronitor.model.Temperature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TemperatureRepository extends JpaRepository<Temperature, Long> {
    Temperature findTemperatureById(Long id);

//    @Query("SELECT count(*) > 0 FROM Temperature T WHERE T.timestamp = ?1")
//    List<Temperature> findTemperatureByTimestamp(Date timestamp);

//    @Query("SELECT count(*) > 0 FROM Temperature T WHERE T.timestamp = ?1 AND T.greenhouse.id = ?2")
//    Temperature findGreenhouseTempByTimestamp(Date timestamp, Long greenhouseId);

    @Query("SELECT MAX(T.value) FROM Temperature T WHERE T.greenhouse.id = ?1")
    Temperature getMaxTemperature(Long greenhouseId);

    @Query("SELECT MIN(T.value) FROM Temperature T WHERE T.greenhouse.id = ?1")
    Temperature getMinTemperature(Long greenhouseId);

    @Query("SELECT count(*) = 1 FROM Temperature T WHERE T.greenhouse.id = ?1 ORDER BY T.timestamp DESC")
    Temperature findLastTemperature(Long greenhouseId);
}
