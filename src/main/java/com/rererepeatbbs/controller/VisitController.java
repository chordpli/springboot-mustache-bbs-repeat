package com.rererepeatbbs.controller;

import com.rererepeatbbs.domain.Response;
import com.rererepeatbbs.domain.dto.VisitCreateRequest;
import com.rererepeatbbs.domain.dto.VisitResponse;
import com.rererepeatbbs.service.VisitService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/v1/visits")
@RequiredArgsConstructor
@Slf4j
public class VisitController {

    private final VisitService visitService;

    @PostMapping
    public ResponseEntity<String> createVisitLog(@RequestBody VisitCreateRequest visitCreateRequest, Authentication authentication) {
        String userName = authentication.getName();
        log.info("userName:{}", userName);
        visitService.createVisit(visitCreateRequest, userName);
        return ResponseEntity.ok().body("방문 기록이 등록 되었습니다.");
    }

    @GetMapping
    public Response<List<VisitResponse>> getVisitInfo(Pageable pageable){
        return Response.success(visitService.findAllByPage(pageable));
    }

    @GetMapping("/users/{id}")
    public Response<List<VisitResponse>> getUserVisitInfo(@PathVariable Long id){
        List<VisitResponse> vl = new ArrayList<>();
        return Response.success(vl);
    }

    @GetMapping("/hospitals/{id}")
    public ResponseEntity<String> getHospitalVisitInfo(@PathVariable Long id){
        return ResponseEntity.ok().body("String");
    }
}
