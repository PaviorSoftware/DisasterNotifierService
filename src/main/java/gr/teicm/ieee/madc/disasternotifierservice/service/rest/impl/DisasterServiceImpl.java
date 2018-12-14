package gr.teicm.ieee.madc.disasternotifierservice.service.rest.impl;

import gr.teicm.ieee.madc.disasternotifierservice.commons.exception.EntityNotFoundException;
import gr.teicm.ieee.madc.disasternotifierservice.commons.exception.NotImplementedException;
import gr.teicm.ieee.madc.disasternotifierservice.commons.exception.UnauthorizedException;
import gr.teicm.ieee.madc.disasternotifierservice.domain.embeddable.Location;
import gr.teicm.ieee.madc.disasternotifierservice.domain.entity.Disaster;
import gr.teicm.ieee.madc.disasternotifierservice.domain.entity.User;
import gr.teicm.ieee.madc.disasternotifierservice.domain.repository.DisasterRepository;
import gr.teicm.ieee.madc.disasternotifierservice.service.rest.DisasterService;
import gr.teicm.ieee.madc.disasternotifierservice.service.security.AuthService;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

@Service
public class DisasterServiceImpl implements DisasterService {

    private final DisasterRepository disasterRepository;
    private final AuthService authService;

    public DisasterServiceImpl(DisasterRepository disasterRepository, AuthService authService) {
        this.disasterRepository = disasterRepository;
        this.authService = authService;
    }

    @Override
    public List<Disaster> get(String accessToken) {
        return disasterRepository.findAll();
    }

    @Override
    public List<Disaster> get(User user) {
        return disasterRepository.findAllByCreator(user);
    }

    @Override
    public Disaster get(Long id, String accessToken) throws EntityNotFoundException {
        return getDisasterByIdOrElseThrow(id, new EntityNotFoundException());
    }

    @Override
    public Disaster post(Disaster disaster, String accessToken) throws UnauthorizedException, NoSuchAlgorithmException {

        if (disaster.getSafeLocation() == null) {
            Location safeLocation = new Location();
            safeLocation.setLatitude((float) 0);
            safeLocation.setLongitude((float) 0);
        }

        User user = authService.getUser(accessToken);
        disaster.setCreator(user);

        return disasterRepository.save(disaster);
    }

    @Override
    public Disaster put(Long id, Disaster disaster, String accessToken) throws NotImplementedException {
        throw new NotImplementedException();
    }

    @Override
    public void delete(Long id, String accessToken) throws NotImplementedException {
        throw new NotImplementedException();
    }

    private Disaster getDisasterByIdOrElseThrow(Long id, EntityNotFoundException e) throws EntityNotFoundException {
        Optional<Disaster> byId = disasterRepository.findById(id);

        if (!byId.isPresent()) {
            throw e;
        }

        return byId.get();

    }
}
