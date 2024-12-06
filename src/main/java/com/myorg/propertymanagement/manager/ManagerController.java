    package com.myorg.propertymanagement.manager;

    import com.myorg.propertymanagement.manager.dto.LoginResponseDto;
    import com.myorg.propertymanagement.manager.dto.SignUpResponseDto;
    import com.myorg.propertymanagement.manager.dto.ManagerDto;
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
        public ResponseEntity<SignUpResponseDto> signup(@RequestBody ManagerDto body) {
            return  ResponseEntity.ok(managerFacade.handleSignup(body));
        }

        @PostMapping("/auth")
        public ResponseEntity<LoginResponseDto> login(@RequestBody ManagerDto body) {
            return ResponseEntity.ok(managerFacade.handleLogin(body));
        }
    }

