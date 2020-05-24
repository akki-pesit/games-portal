package com.personal.gamesportal.controller;

import com.personal.gamesportal.model.DevelopersListResponse;
import com.personal.gamesportal.model.GameDeveloper;
import com.personal.gamesportal.service.GamePortalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
class GamesPortalController implements DefaultApi{

    @Autowired private GamePortalService gamePortalService;

    @Override
    public ResponseEntity<GameDeveloper> getGetDeveloperId(String id, String xRapidAPIHost, String xRapidAPIKey) {
        GameDeveloper gameDeveloper = null;
        try {
            gameDeveloper = gamePortalService.getGameDeveloperById(id, xRapidAPIHost, xRapidAPIHost);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(gameDeveloper);
    }

    @Override
    public ResponseEntity<DevelopersListResponse> getGetDevelopersList(String xRapidAPIHost, String xRapidAPIKey) {
        DevelopersListResponse developersListResponse = null;
        try {
            developersListResponse = gamePortalService.getDevelopersListResponse(xRapidAPIHost, xRapidAPIHost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok(developersListResponse);
    }
}
