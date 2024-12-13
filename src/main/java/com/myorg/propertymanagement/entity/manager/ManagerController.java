    package com.myorg.propertymanagement.entity.manager;
    import io.swagger.v3.oas.annotations.tags.Tag;


    import com.myorg.propertymanagement.entity.manager.dto.LoginResponse;
    import com.myorg.propertymanagement.entity.manager.dto.SignUpResponse;
    import com.myorg.propertymanagement.entity.manager.dto.ManagerDto;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;


    @RestController

    @RequestMapping("api/v1/managers")
    public class ManagerController {

        @Autowired
        ManagerFacade managerFacade;

        @Value("${SECRET}")
        private String SECRET;

        @PostMapping("/")

        public ResponseEntity<SignUpResponse> signup(@RequestBody ManagerDto body) {
            return  ResponseEntity.ok(managerFacade.handleSignup(body));
        }

        @PostMapping("/auth")
        public ResponseEntity<LoginResponse> login(@RequestBody ManagerDto body) {
            return ResponseEntity.ok(managerFacade.handleLogin(body));
        }

        @GetMapping("/")
        public ResponseEntity<Object> getManagers() {
            System.out.println(managerFacade.getAllmanagers());

            return ResponseEntity.ok().header("Content-Type", "application/json").body(managerFacade.getAllmanagers());
        }



        }

