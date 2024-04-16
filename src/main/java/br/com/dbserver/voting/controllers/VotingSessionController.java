package br.com.dbserver.voting.controllers;

import br.com.dbserver.voting.dtos.vote.ResultOfTheVoteDTO;
import br.com.dbserver.voting.dtos.votingsession.VotingSessionRequestDTO;
import br.com.dbserver.voting.dtos.votingsession.VotingSessionResponseDTO;
import br.com.dbserver.voting.helpers.Constants;
import br.com.dbserver.voting.services.VotingSessionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static br.com.dbserver.voting.helpers.Util.localDateTimeToString;
import static java.time.LocalDateTime.now;

@RestController
@RequestMapping(path = Constants.API_VERSION + "/voting-session")
public class VotingSessionController {

    final VotingSessionService votingSessionService;
    private static final Logger logger = LoggerFactory.getLogger(VotingSessionController.class);

    public VotingSessionController(VotingSessionService votingSessionService) {
        this.votingSessionService = votingSessionService;
    }

    @PostMapping(path = "/open")
    public ResponseEntity<VotingSessionResponseDTO> openVoting(@RequestBody @Valid VotingSessionRequestDTO votingSessionRequestDTO) {
        logger.info("Iniciando votação de uma pauta - Início: {}", localDateTimeToString(now()));
        VotingSessionResponseDTO openVoting = votingSessionService.openVoting(votingSessionRequestDTO);
        MDC.put("sessionVotingId", openVoting.getIdSessionVoting().toString());
        logger.info("Votação de uma pauta concluída - Fim: {}", localDateTimeToString(now()));
        MDC.clear();
        return new ResponseEntity<>(openVoting, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<VotingSessionResponseDTO>> listAll(Pageable pageable) {
        logger.info("Listando sessões abertas de votação para uma pauta - Início: {}", localDateTimeToString(now()));
        Page<VotingSessionResponseDTO> openVotes = votingSessionService.listAll(pageable);
        logger.info("Listagem de sessões abertas de votação concluída - Fim: {}", localDateTimeToString(now()));
        return new ResponseEntity<>(openVotes, HttpStatus.OK);
    }

    @PutMapping(path = "/close/{sessionId}")
    public ResponseEntity<ResultOfTheVoteDTO> closeVoting(@PathVariable Integer sessionId) {
        logger.info("Encerrando votação para uma pauta - Início: {}", localDateTimeToString(now()));
        ResultOfTheVoteDTO resultOfTheVoteDTO = votingSessionService.closeVoting(sessionId);
        MDC.put("sessionVotingId", resultOfTheVoteDTO.getId().toString());
        logger.info("Encerramento da votação para uma pauta concluído - Fim: {}", localDateTimeToString(now()));
        MDC.clear();
        return new ResponseEntity<>(resultOfTheVoteDTO, HttpStatus.OK);
    }

}
