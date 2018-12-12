package gr.teicm.ieee.madc.disasternotifierservice.api.rpc;

import gr.teicm.ieee.madc.disasternotifierservice.config.ApplicationConfiguration;
import gr.teicm.ieee.madc.disasternotifierservice.model.FirebaseModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

public interface AuthorizedUserController {

    @GetMapping
    ResponseEntity<?> getMe(@RequestHeader(defaultValue = ApplicationConfiguration.GuestToken) String authorization);

    @GetMapping("reports")
    ResponseEntity<?> myReports(@RequestHeader(defaultValue = ApplicationConfiguration.GuestToken) String authorization);

    @GetMapping("firebase")
    ResponseEntity<?> getMyFirebaseToken(@RequestHeader(defaultValue = ApplicationConfiguration.GuestToken) String authorization);

    @PutMapping("firebase")
    ResponseEntity<?> updateMyFirebaseToken(@RequestHeader(defaultValue = ApplicationConfiguration.GuestToken) String authorization, @RequestBody FirebaseModel firebaseModel);

}
