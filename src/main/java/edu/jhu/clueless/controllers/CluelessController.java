/**
 * 
 */
package edu.jhu.clueless.controllers;

import java.io.IOException;

import org.json.JSONException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.jhu.clueless.DTO.AccuseRequestDTO;
import edu.jhu.clueless.DTO.AccuseResponseDTO;
import edu.jhu.clueless.DTO.EndTurnRequestDTO;
import edu.jhu.clueless.DTO.EndTurnResponseDTO;
import edu.jhu.clueless.DTO.InitRequestDTO;
import edu.jhu.clueless.DTO.InitResponseDTO;
import edu.jhu.clueless.DTO.MoveRequestDTO;
import edu.jhu.clueless.DTO.MoveResponseDTO;
import edu.jhu.clueless.DTO.SuggestRequestDTO;
import edu.jhu.clueless.DTO.SuggestResponseDTO;
import edu.jhu.clueless.domain.ConfidentialFile;
import edu.jhu.clueless.domain.Hallway;
import edu.jhu.clueless.domain.Player;
import edu.jhu.clueless.domain.Room;
import edu.jhu.clueless.service.CluelessService;

@RestController
@RequestMapping("${application.base-path}/api")
public class CluelessController 
{
    private final CluelessService myCluelessService;

    public CluelessController(CluelessService myCluelessService)
    {
      this.myCluelessService = myCluelessService;
    }



    /**
     * 
     * @param myInitRequestDTO
     * @return
     * @throws IOException
     * @throws JSONException
     */
    @PostMapping("/init")
    ResponseEntity<InitResponseDTO> initGame(@RequestBody InitRequestDTO myInitRequestDTO) throws IOException, JSONException 
    {
      InitResponseDTO result = myCluelessService.initGame(myInitRequestDTO);
      return ResponseEntity.ok().body(result);
    }
    
    
    @PostMapping("/move")
    ResponseEntity<MoveResponseDTO> move(@RequestBody MoveRequestDTO myMoveRequestDTO) throws IOException, JSONException 
    {
      MoveResponseDTO result = myCluelessService.move(myMoveRequestDTO);
      return ResponseEntity.ok().body(result);
    }
    
    @PostMapping("/endturn")
    ResponseEntity<EndTurnResponseDTO> move(@RequestBody EndTurnRequestDTO myEndTurnRequestDTO) throws IOException, JSONException 
    {
      EndTurnResponseDTO result = myCluelessService.endTurn(myEndTurnRequestDTO);
      return ResponseEntity.ok().body(result);
    }
    
    @PostMapping("/accuse")
    ResponseEntity<AccuseResponseDTO> move(@RequestBody AccuseRequestDTO myAccuseRequestDTO) throws IOException, JSONException 
    {
      /*if (getAccusedPlayer() == getMurderingPlayer() && getMurderScene() == getMurderLocation() && getMurderWeapon() == getMurderWeapon()){
      endgame}
      else{
      Remove getAccusingPlayer from turn order
      */
      AccuseResponseDTO result = myCluelessService.accuse(myAccuseRequestDTO);
      return ResponseEntity.ok().body(result);
    }
    
    @PostMapping("/suggest")
    ResponseEntity<SuggestResponseDTO> move(@RequestBody SuggestRequestDTO mySuggestRequestDTO) throws IOException, JSONException 
    {
      SuggestResponseDTO result = myCluelessService.suggest(mySuggestRequestDTO);
      return ResponseEntity.ok().body(result);
    }    

}
