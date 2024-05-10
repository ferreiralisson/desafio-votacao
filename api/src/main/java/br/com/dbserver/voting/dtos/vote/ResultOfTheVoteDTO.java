package br.com.dbserver.voting.dtos.vote;

import br.com.dbserver.voting.enums.StatusVotingSessionEnum;
import br.com.dbserver.voting.models.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultOfTheVoteDTO implements Serializable {
    private Integer id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime startSession;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private LocalDateTime endSession;
    private Schedule schedule;
    private Long totalYes;
    private Long totalNo;
    private StatusVotingSessionEnum status;

    public ResultOfTheVoteDTO() {
    }

    public ResultOfTheVoteDTO(Integer id, LocalDateTime startSession, LocalDateTime endSession, Schedule schedule, Long totalYes, Long totalNo, StatusVotingSessionEnum status) {
        this.id = id;
        this.startSession = startSession;
        this.endSession = endSession;
        this.schedule = schedule;
        this.totalYes = totalYes;
        this.totalNo = totalNo;
        this.status = status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getStartSession() {
        return startSession;
    }

    public void setStartSession(LocalDateTime startSession) {
        this.startSession = startSession;
    }

    public LocalDateTime getEndSession() {
        return endSession;
    }

    public void setEndSession(LocalDateTime endSession) {
        this.endSession = endSession;
    }

    public Schedule getSchedule() {
        return schedule;
    }

    public void setSchedule(Schedule schedule) {
        this.schedule = schedule;
    }

    public Long getTotalYes() {
        return totalYes;
    }

    public void setTotalYes(Long totalYes) {
        this.totalYes = totalYes;
    }

    public Long getTotalNo() {
        return totalNo;
    }

    public void setTotalNo(Long totalNo) {
        this.totalNo = totalNo;
    }

    public StatusVotingSessionEnum getStatus() {
        return status;
    }

    public void setStatus(StatusVotingSessionEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultOfTheVoteDTO result)) return false;
        return Objects.equals(getId(), result.getId()) && Objects.equals(getStartSession(), result.getStartSession()) && Objects.equals(getEndSession(), result.getEndSession()) && Objects.equals(getSchedule(), result.getSchedule()) && Objects.equals(getTotalYes(), result.getTotalYes()) && Objects.equals(getTotalNo(), result.getTotalNo()) && getStatus() == result.getStatus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getStartSession(), getEndSession(), getSchedule(), getTotalYes(), getTotalNo(), getStatus());
    }
}

