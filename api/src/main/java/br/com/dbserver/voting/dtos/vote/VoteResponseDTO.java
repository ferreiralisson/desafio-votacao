package br.com.dbserver.voting.dtos.vote;

import java.io.Serializable;
import java.util.Objects;

public class VoteResponseDTO implements Serializable {

    private String voteId;
    private String titleSchedule;

    private String nameAssociate;
    private String vote;

    private String status;

    public VoteResponseDTO() {
    }

    public VoteResponseDTO(String voteId, String titleSchedule, String nameAssociate, String vote, String status) {
        this.voteId = voteId;
        this.titleSchedule = titleSchedule;
        this.nameAssociate = nameAssociate;
        this.vote = vote;
        this.status = status;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getVote() {
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitleSchedule() {
        return titleSchedule;
    }

    public void setTitleSchedule(String titleSchedule) {
        this.titleSchedule = titleSchedule;
    }

    public String getNameAssociate() {
        return nameAssociate;
    }

    public void setNameAssociate(String nameAssociate) {
        this.nameAssociate = nameAssociate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof VoteResponseDTO that)) return false;
        return Objects.equals(getVoteId(), that.getVoteId()) && Objects.equals(getTitleSchedule(), that.getTitleSchedule()) && Objects.equals(getNameAssociate(), that.getNameAssociate()) && Objects.equals(getVote(), that.getVote()) && Objects.equals(getStatus(), that.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getVoteId(), getTitleSchedule(), getNameAssociate(), getVote(), getStatus());
    }
}
