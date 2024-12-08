    package com.myorg.propertymanagement.entity.manager;

    import com.myorg.propertymanagement.entity.manager.dto.LoginResponse;
    import com.myorg.propertymanagement.entity.manager.dto.SignUpResponse;
    import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.PostMapping;
    import org.springframework.web.bind.annotation.RequestBody;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    @RestController
    @RequestMapping("api/v1/managers")
    public class ManagerController {

        @Autowired
        ManagerFacade managerFacade;

        @PostMapping("/")
        public ResponseEntity<SignUpResponse> signup(@RequestBody ManagerDto body) {
            return  ResponseEntity.ok(managerFacade.handleSignup(body));
        }

        @PostMapping("/auth")
        public ResponseEntity<LoginResponse> login(@RequestBody ManagerDto body) {
            return ResponseEntity.ok(managerFacade.handleLogin(body));
        }
    }

